Итоговая контрольная работа

Информация о проекте

Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.

Как сдавать проект

Для сдачи проекта необходимо создать отдельный общедоступный
репозиторий(Github, gitlub, или Bitbucket). Разработку вести в этом
репозитории, использовать пул реквесты на изменения. Программа должна
запускаться и работать, ошибок при выполнении программы быть не должно.
Программа, может использоваться в различных системах, поэтому необходимо
разработать класс в виде конструктора

Задание

1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).

см в коммитах 

2. Создать директорию, переместить файл туда.

см в коммитах 

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.

sudo docker run -h systemHostName --name some-mysql -e MYSQL_ROOT_PASSWORD=my123 -d mysql

sudo apt-get install mysql-server



4. Установить и удалить deb-пакет с помощью dpkg.

sudo apt-get install apache2 
sudo apt-get remove apache2



5. Выложить историю команд в терминале ubuntu

см выше


6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).


![image](https://github.com/Ivan123451/hwFinal/assets/122518106/08a5f5bc-aeaa-42f0-88e0-bf5049f1832f)


7. В подключенном MySQL репозитории создать базу данных “Друзья
человека

вхожу в контейнер
sudo docker exec -it some-mysql bash 
mysql -u root -p
ввожу пароль 12345

создаем БД 
CREATE DATABASE Human_friends;

8. Создать таблицы с иерархией из диаграммы в БД

USE Human_friends;
CREATE TABLE all_animal_class
(
	Id INT AUTO_INCREMENT PRIMARY KEY, 
	Class_name VARCHAR(40)
);

INSERT INTO all_animal_class (Class_name)
VALUES ('вьючные'),
('домашние');  


CREATE TABLE packed_animals
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO packed_animals (Genus_name, Class_id)
VALUES ('Лошади', 1),
('Ослы', 1),  
('Верблюды', 1); 
    
CREATE TABLE home_animals
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO home_animals (Genus_name, Class_id)
VALUES ('Кошки', 2),
('Собаки', 2),  
('Хомяки', 2); 




9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения

CREATE TABLE cats 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO cats (Name, Birthday, Commands, Genus_id)
VALUES ('Мурка', '2019-05-01', 'кис-кис', 1),
('Яшка', '2018-03-02', "мур-мур", 1),  
('Рыжик', '2020-02-01', "вперед", 1); 

CREATE TABLE dogs 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dogs (Name, Birthday, Commands, Genus_id)
VALUES ('Шарик', '2021-03-03', 'лежать', 2),
('Бобик', '2020-02-02', "лапу", 2),  

CREATE TABLE hamsters 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO hamsters (Name, Birthday, Commands, Genus_id)
VALUES ('Хомо', '2022-12-11', 'вверх', 3),
('Бурс', '2021-02-10', "вниз", 3),  


CREATE TABLE horses 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horses (Name, Birthday, Commands, Genus_id)
VALUES ('Первый', '2000-01-12', 'шагом', 1),
('Мощьный', '2012-03-12', "хоп", 1),  

CREATE TABLE donkeys 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkeys (Name, Birthday, Commands, Genus_id)
VALUES ('ИА', '2012-03-10', "ииии", 2),
('ИАИА', '2010-03-12', "коко", 2),  


CREATE TABLE camels 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO camels (Name, Birthday, Commands, Genus_id)
VALUES ('Грифон', '2012-05-11', 'за мной', 3),
('Карл', '2015-04-02', "стой", 3),  
('Мудрый', '2012-07-10', "вперед", 3), 


10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.





11.Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице





12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.





13.Создать класс с Инкапсуляцией методов и наследованием по диаграмме.





14. Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:





14.1 Завести новое животное



14.2 определять животное в правильный класс



14.3 увидеть список команд, которое выполняет животное




14.4 обучить животное новым командам




14.5 Реализовать навигацию по меню




15.Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
значение внутренней̆int переменной̆на 1 при нажатие “Завести новое
животное” Сделайте так, чтобы с объектом такого типа можно было работать в
блоке try-with-resources. Нужно бросить исключение, если работа с объектом
типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
считать в ресурсе try, если при заведения животного заполнены все поля.
