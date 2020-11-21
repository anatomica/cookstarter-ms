'use strict';
var content = document.querySelector('#content');
var restaurantId = document.querySelector('#restaurantId');
var value = restaurantId.textContent;
var stompClient = null;
var border = "1px solid #000";


function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, onConnected, onError);
}

function onConnected() {
    stompClient.subscribe('/topic/board/' + value, onMessageReceived);

}

function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket Server. Please refresh this page to try again.';
    connectingElement.style.color = 'red';

}

function onMessageReceived(payload) {
    alert("Order is received.");
    var order = JSON.parse(payload.body);
    var dishes = order.dishes
    var total = 0;
    var message = document.createElement('div');
    var customer = document.createElement('b');
    var table = document.createElement('table');
    table.style.border = border;
    var thead = document.createElement('thead');
    var headers = ['Name', 'Quantity', 'Price', 'Sum'];
    thead.appendChild(rowBuilder(headers));
    table.appendChild(thead);

    dishes.forEach(function (entry) {
        var fields = [entry.name, entry.qty, entry.price];
        var tableRow = rowBuilder(fields);
        var sum = entry.qty * entry.price;
        total = total + sum;
        var sumCell = document.createElement('td');
        sumCell.appendChild(document.createTextNode(sum));
        sumCell.style.border = border;
        tableRow.appendChild(sumCell);
        table.appendChild(tableRow);
    });

    customer.appendChild(document.createTextNode('Order № ' + order.orderId + ' for: ' + order.userName));
    message.appendChild(customer);
    message.appendChild(table);
    message.appendChild(document.createTextNode('Total: ' + total));
    content.appendChild(message);
    content.scrollTop = content.scrollHeight;
}

function rowBuilder(values) {
    var row = document.createElement('tr');
    var cell;
    values.forEach(function (entry) {
        cell = document.createElement('td');
        cell.style.border = border;
        cell.appendChild(document.createTextNode(entry));
        row.appendChild(cell);
    });
    return row;
}

connect();