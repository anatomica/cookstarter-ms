

### Customer service API

**Регистрация нового пользователя**

POST /reg/customer
```json5
{
     "username": 'string', //обязательно,
     "pass1": 'string', //обязательно
     "pass2": 'string', //обязательно
     "firstName": 'string', //обязательно
     "lastName": 'string', //обязательно
     "email": 'string', //обязательно
     
 }
```
ответ
```json5
{
    "status": "OK",
}
```

**Регистрация нового ресторана**

POST /reg/restaurant
```json5
{
     "username": 'string', //обязательно,
     "password": 'string', //обязательно
     "role": 'string', //обязательно
 }
```
ответ
```json5
{
    "status": "OK",
}
```

**Аутентификация пользователя**

POST /auth
```json5
{
     "username": 'string', //обязательно,
     "password": 'string', //обязательно
 }
```
ответ
```json5
{
    "status": "OK",
    "token": "token with user details and role"

}
```

### Restaurant service API
1) ресторан
{
     "name": 'string', 
     "description": 'string', 
     "contact": {
          "address": 'string',
          "phone": 'string',
          "location": 'string',
          "mail": 'string',
          "website": 'string',
     },
     "picture": 1 // restaurant picture_id
}

2) меню
{ 
          "dish1": {
          "name": 'string',
          "price": 0.99, 
          "description": 'string', 
          "picture": 10 
           },
          "dish2": {
          "name": 'string',
          "price": 0.99, 
          "description": 'string', 
          "picture": 11 // dish picture_id
          }
     }
}
тут нужно еще привязать меню к ресторану, но это что угодно на выбор - через pathvriable, через дополнительное поле в json

Любой запрос должен содержать header "Authentication" с Bearer + токеном, полученным при авторизации.

**Добавление карточки ресторана**

POST /restaurant/add
```json5
{
     "name": 'string', 
     "description": 'string', 
     "contact": {
          "address": 'string',
          "phone": 'string',
          "location": 'string',
          "mail": 'string',
          "website": 'string',
     },

     "menu": { 
          "dish1": {
          "name": 'string',
          "price": 0.99, 
          "description": 'string', 
          "picture": 10 
           },
          "dish2": {
          "name": 'string',
          "price": 0.99, 
          "description": 'string', 
          "picture": 11 // dish picture_id
          }
     },
     "picture": 1 // restaurant picture_id
 }
```
ответ
```json5
{
    "status": "OK",
}
```

**Обновление карточки ресторана**

POST /restaurant/update
```json5
{
     "name": 'string', 
     "description": 'string', 
     "contact": {
          "address": 'string',
          "phone": 'string',
          "location": 'string',
          "mail": 'string',
          "website": 'string',
     },

     "menu": { 
          "dish1": {
          "name": 'string',
          "price": 0.99, 
          "description": 'string', 
          "picture": 10 
           },
          "dish2": {
          "name": 'string',
          "price": 0.99, 
          "description": 'string', 
          "picture": 11 // dish picture_id
          }
     },
     "picture": 1 // restaurant picture_id
 }
```
ответ
```json5
{
    "status": "OK",
}
```


**Получение карточки ресторана**

GET /restaurant/get/{id}

ответ
```json5
{
     "name": 'string', 
     "description": 'string', 
     "contact": {
          "address": 'string',
          "phone": 'string',
          "location": 'string',
          "mail": 'string',
          "website": 'string',
     },

     "menu": { 
          "dish1": {
          "name": 'string',
          "price": 0.99, 
          "description": 'string', 
          "picture": 10 
           },
          "dish2": {
          "name": 'string',
          "price": 0.99, 
          "description": 'string', 
          "picture": 11 // dish picture_id
          }
     },
     "picture": 1 // restaurant picture_id
 }
```

**Удаление карточки ресторана**

GET /restaurant/delete/{id}

ответ
```json5
{
     "status": 'ok', 
          
 }
```




### Picture service API

Любой запрос должен содержать header "jwt-token" с токеном, полученным при авторизации.


**Добавление картинки**

POST /picture/add

    ---файл---
ответ
```json5
{
    "status": "OK",
    "id": 1
}
```

**Обновление картнинки**

POST /picture/update/{id}

    ---файл---

ответ
```json5
{
    "status": "OK",
    "id": 1
}
```


**Получение картинки**

GET /picture/get/{id}

ответ

    ---файл---
```json5
{
     "status": 'ok', 
          
 }
```

**Удаление картинки**

GET /picture/delete/{id}

ответ
```json5
{
     "status": 'ok', 
          
 }
```


### Order service API

Любой запрос должен содержать header "jwt-token" с токеном, полученным при авторизации.

**Добавление нового заказа**

POST /orders/add
```json5
{
     "customerId": 42, //обязательно
     "restaurantId": 24, //обязательно
     "dishes": { // пустой список и нулевое количество не сохраняется
         "1": { // id блюда из меню
             "price": 0.99, //обязательно
             "quantity": 5 //обязательно
         },
         "2": {
             "price": 1.99,
             "quantity": 3
         }
     }
 }
```
ответ
```json5
{
    "status": "OK",
    "id": "23" //id созданного заказа
}
```
статусы ответов в конце страницы

---
**Обновление заказа**

POST /orders/update
```json5
{
    "id": 21, //обязательно
    "customerId": 42, //обязательно
    "restaurantId": 24, //обязательно
    "dishes": { // пустой список удаляет полностью заказ, блюда с нулевыми количествами удаляются
        "1": { // id блюда из меню
            "id": 62, //id блюда в заказе (не путать с меню), не обязательно
            "price": 0.99, //обязательно
            "quantity": 6 //обязательно
        },
        "2": {
            "id": 63,
            "price": 1.99,
            "quantity": 3
        }
    }
}
```
ответ
```json5
{
    "status": "OK",
}
```
---
**Удаление заказа**

GET /orders/delete/{id}

ответ
```json5
{
    "status": "OK",
}
```
---
**Удаление блюда из заказа**

GET /orders/delete/item/{id}

ответ
```json5
{
    "status": "OK",
}
```
---
**Получить информацию по заказу**

GET /orders/get/{id}

ответ
```json5
{
    "id": 21,
    "customerId": 42,
    "restaurantId": 24,
    "status": "SAVED",
    "dateCreated": "04-10-2020 13:11:41.800+0300",
    "dishes": {
        "1": {
            "id": 62,
            "price": 0.99,
            "quantity": 6
        },
        "2": {
            "id": 63,
            "price": 1.99,
            "quantity": 3
        }
    }
}
```
статусы заказов в конце страницы

---
**Получить все заказы по клиенту**

GET /orders/get/customer/{id}

ответ
```json5
[
    {
        "id": 22,
        "customerId": 42,
        "restaurantId": 24,
        "status": "SAVED",
        "dateCreated": "04-10-2020 13:23:29.614+0300",
        "dishes": {
            "1": {
                "id": 64,
                "price": 0.99,
                "quantity": 5
            },
            "2": {
                "id": 65,
                "price": 1.99,
                "quantity": 3
            }
        }
    },
    {
        "id": 23,
        "customerId": 42,
        "restaurantId": 24,
        "status": "SAVED",
        "dateCreated": "04-10-2020 13:27:20.316+0300",
        "dishes": {
            "1": {
                "id": 66,
                "price": 0.99,
                "quantity": 5
            },
            "2": {
                "id": 67,
                "price": 1.99,
                "quantity": 3
            }
        }
    }
]
```
---
**Получить все заказы по ресторану**

GET /orders/get/restaurant/{id}

ответ
```json5
[
    {
        "id": 22,
        "customerId": 42,
        "restaurantId": 24,
        "status": "SAVED",
        "dateCreated": "04-10-2020 13:23:29.614+0300",
        "dishes": {
            "1": {
                "id": 64,
                "price": 0.99,
                "quantity": 5
            },
            "2": {
                "id": 65,
                "price": 1.99,
                "quantity": 3
            }
        }
    },
    {
        "id": 23,
        "customerId": 42,
        "restaurantId": 24,
        "status": "SAVED",
        "dateCreated": "04-10-2020 13:27:20.316+0300",
        "dishes": {
            "1": {
                "id": 66,
                "price": 0.99,
                "quantity": 5
            },
            "2": {
                "id": 67,
                "price": 1.99,
                "quantity": 3
            }
        }
    }
]
```
---
**Ошибки**

*статус и сообщение, если ошибка известна*
```json5
{
    "status": "ERROR",
    "error": "Ошибка в запросе"
}
```
статусы ответов:
- OK
- ERROR (см. в конце страницы)

статусы заказов:
- SAVED - заказ сохранен
- PAID - оплачен
- IN_PROCESS - принят рестораном / готовится
- READY - готов к выдаче
- COMPLETED - завершен