# jwtapptest
БД MySQL инициализируется при помощи Liquibase:
users: 
username: "test_user" password: "test"
messages:
text: "testmessage 1" sender_id "1"
text: "testmessage 2" sender_id "1"

cURL:
1) Получение токена: 
curl --location --request POST 'localhost:8075/api/v1/auth/login' --header 'Content-Type: application/json' --data-raw '{ "username":"test_user", "password":"test" }'
2) Отправка сообщения: 
curl --location --request POST 'localhost:8075/api/v1/messages/send' --header 'Authorization: Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0X3VzZXIiLCJpYXQiOjE2NjA2NzkzODIsImV4cCI6MTY2MDY4Mjk4Mn0.Ry1aoy_1zwi3LJEPWWVPMu_6guR-cyXbzMGvtjCBKTQ' --header 'Content-Type: application/json' --data-raw '{ "username":"test_user", "message":"histo" }'
2) Получение истории сообщений: 
curl --location --request POST 'localhost:8075/api/v1/messages/send' --header 'Authorization: Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0X3VzZXIiLCJpYXQiOjE2NjA2NzkzODIsImV4cCI6MTY2MDY4Mjk4Mn0.Ry1aoy_1zwi3LJEPWWVPMu_6guR-cyXbzMGvtjCBKTQ' --header 'Content-Type: application/json' --data-raw '{ "username":"test_user", "message":"history 10" }'
