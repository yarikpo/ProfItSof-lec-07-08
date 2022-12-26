# ProfItSof-lec-07-08
Розробити веб-застосунок з функцією автентифікації. Можна використовувати або чисті Servlets+JSP, або Spring MVC (+JSP). Spring Security в цьому завданні прохання не використовувати (щоб було менше магії, і ви отримали досвід, як такі речі можуть працювати "під капотом").

## Installation

```bash
git clone https://github.com/yarikpo/ProfItSof-lec-07-08.git
```

## How to Run

### Via IntelliJ Idea

* Open project in Intellij
* Set up TomCat server
* Run

### Without IDE

* Install maven in your system
* Enter directory with project using command prompt:
```bash
cd ./ProfItSof-lec-07-08
```
* Run the following command:
```bash
mvn package
```
* Put generated war file from target folder into tomcat/webapps
* Run the startup script in bin folder

## User Guide

* Якщо користвач не автентифікований - він може перебувати тільки на шляху http://localhost:8080/ProfItSoft-lec-07-08/login
* Якщо користувач вводить неправильний логін чи пароль - під формою з1являється повідомлення з помилкою
* Якщо користувач успішно авторизувався - його перенаправляє на посилання http://localhost:8080/ProfItSoft-lec-07-08/home
* Авторизований користувач може перебувати виключно на шляхах http://localhost:8080/ProfItSoft-lec-07-08/home та http://localhost:8080/ProfItSoft-lec-07-08/users
* При натисканні на кнопку *logout* - користувача перенапрявляє на посилання http://localhost:8080/ProfItSoft-lec-07-08/login та він не бачить помилки, якщо вона до цього буда (та, що під формою)
* При натисканні на кнопку users - користувача направляє за посиланням http://localhost:8080/ProfItSoft-lec-07-08/users
* За посиланням http://localhost:8080/ProfItSoft-lec-07-08/users перелічені всі користувачі
* З посилання http://localhost:8080/ProfItSoft-lec-07-08/users можна перейти до посилання http://localhost:8080/ProfItSoft-lec-07-08/home
