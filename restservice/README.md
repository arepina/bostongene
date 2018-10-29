
В компании «А» возникла потребность в хранении и управлении учетными записями
пользователей (добавление, удаление и поиск по email). Задача по реализации данных
потребностей выпала Вам. Необходимо реализовать REST сервис, отвечающий следующим
требованиям:
- данные пользователя, которые будут храниться: Фамилия, Имя, Дата рождения, email и
пароль;
- пароль пользователя должен храниться в безопасной форме;
- использовать InMemory реализацию базы данных (т.е. хранить данные в памяти);
- приложение необходимо реализовать на одном из языков: Java 8, Groovy или Kotlin с
использованием Spring Boot;
- наличие примеров запросов к сервису (например, curl).

To run the service enter to the command line:
1) gradle build
2) java -jar build/libs/restservice-0.0.1.jar
Comands:
1) Add new user
curl --header "Content-Type: application/json" --request POST --data '{"name":"Anastasia","surname":"Repina","birthday":"1996-08-02","email":"anastasiya.repina2012@yandex.ru","password":"123456"}' http://localhost:8080/users
2) Read all users
curl http://localhost:8080/users
3) Read user with id = 1
curl http://localhost:8080/users/1
4) Delete user with id = 1
curl --request DELETE http://localhost:8080/users/1
