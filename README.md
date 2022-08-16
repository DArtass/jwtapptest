# jwtapptest
БД подключается по 
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/jwtapptest

инициализируется при помощи Liquibase:
users: 
username: "test_user" password: "test"
messages:
text: "testmessage 1" user_id "1"
text: "testmessage 2" user_id "1"

cURL:
1) Получение токена: 
curl --location --request POST 'localhost:8075/api/v1/auth/login' --header 'Content-Type: application/json' --data-raw '{ "username":"test_user", "password":"test" }'
2) Отправка сообщения: 
curl --location --request POST 'localhost:8075/api/v1/messages/send' --header 'Authorization: Bearer_Полученный токен' --header 'Content-Type: application/json' --data-raw '{ "username":"test_user", "message":"histo" }'
2) Получение истории сообщений: 
curl --location --request POST 'localhost:8075/api/v1/messages/send' --header 'Authorization: Bearer_Полученный токен' --header 'Content-Type: application/json' --data-raw '{ "username":"test_user", "message":"history 10" }'
