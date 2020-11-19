'use strict';
var content = document.querySelector('#content');
var restaurantId = document.querySelector('#restaurantId');
var value = restaurantId.textContent;
var stompClient = null;

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
    alert("receive");
    var order = JSON.parse(payload.body);
    var dishes = order.dishes
    var message = document.createElement('div');
    var customer = document.createElement('b');
    customer.appendChild(document.createTextNode('Order № ' + order.orderId + ' for: '));
    customer.appendChild(document.createTextNode(order.userName));
    content.appendChild(customer);

    var table = document.createElement('table');
    var thead = document.createElement('thead');
    var row = document.createElement('tr');
    var hcell1 = document.createElement('td');
    var hcell2 = document.createElement('td');
    var hcell3 = document.createElement('td');
    var hcell4 = document.createElement('td');
    hcell1.style.border = "1px solid #000";
    hcell2.style.border = "1px solid #000";
    hcell3.style.border = "1px solid #000";
    hcell4.style.border = "1px solid #000";
    hcell1.appendChild(document.createTextNode('Name'));
    hcell2.appendChild(document.createTextNode('Quantity'));
    hcell3.appendChild(document.createTextNode('Price'));
    hcell4.appendChild(document.createTextNode('Sum'));
    row.appendChild(hcell1);
    row.appendChild(hcell2);
    row.appendChild(hcell3);
    row.appendChild(hcell4);
    thead.appendChild(row);
    table.appendChild(thead);

    var total = 0;

    dishes.forEach(function (entry) {
        var row1 = document.createElement('tr');
        var cell1 = document.createElement('td');
        var cell2 = document.createElement('th');
        var cell3 = document.createElement('th');
        var cell4 = document.createElement('th');
        cell1.style.border = "1px solid #000";
        cell2.style.border = "1px solid #000";
        cell3.style.border = "1px solid #000";
        cell4.style.border = "1px solid #000";
        cell1.appendChild(document.createTextNode(entry.name));
        cell2.appendChild(document.createTextNode(entry.qty));
        cell3.appendChild(document.createTextNode(entry.price));
        var sum = entry.qty * entry.price;
        total = total + sum;
        cell4.appendChild(document.createTextNode(sum));
        row1.appendChild(cell1);
        row1.appendChild(cell2);
        row1.appendChild(cell3);
        row1.appendChild(cell4);
        table.appendChild(row1);
    })

    table.style.border = "1px solid #000";

    message.appendChild(table);
    message.appendChild(document.createTextNode('Total: ' + total));
    content.appendChild(message);
    content.scrollTop = content.scrollHeight;
}

connect();