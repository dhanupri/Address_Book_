--uc1 create database
mysql> create database address_book;
Query OK, 1 row affected (0.05 sec)

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| address_book       |
| bootcamp           |
| college            |
| cric               |
| cric_field         |
| cric_ppl           |
| cricket            |
| day1bootcamp       |
| dhanu              |
| emp                |
| emp_det            |
| employee           |
| information_schema |
| ipl                |
| lab                |
| mysql              |
| payroll_service    |
| people             |
| performance_schema |
| ppl                |
| rough              |
| sakila             |
| stu                |
| stud_det           |
| student_d          |
| student_db         |
| student_details    |
| student_info       |
| sys                |
| team               |
| todo1              |
| todo2              |
| todo_list          |
| world              |
+--------------------+
34 rows in set (0.02 sec)

--uc2 create address book table with attributes
mysql> use  address_book;
Database changed
mysql> CREATE TABLE Address_Book_service(
    ->   id INT PRIMARY KEY AUTO_INCREMENT,
    ->     firstName VARCHAR(50) NOT NULL,
    ->     lastName VARCHAR(50) NOT NULL,
    ->     address VARCHAR(255) NOT NULL,
    ->     city VARCHAR(100) NOT NULL,
    ->     state VARCHAR(50) NOT NULL,
    ->     zip VARCHAR(20) NOT NULL,
    ->     phoneNumber VARCHAR(20) NOT NULL,
    ->     email VARCHAR(100) NOT NULL
    -> );
Query OK, 0 rows affected (0.07 sec)

mysql> Select * from Address_Book_service;
Empty set (0.02 sec)

--uc3 insert value into table
mysql> INSERT INTO Address_Book_service (firstName, lastName, address, city, state, zip, phoneNumber, email) VALUES('Dhanu','pri','111mainst','zzz','TN','641017','1234567890','aaaa@gmail.com'),
    -> ('deepak','kumar','222 main','mmm','TN','641018','0987654321','bbb@gmail.com');
Query OK, 2 rows affected (0.01 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> Select * from Address_Book_service;
+----+-----------+----------+-----------+------+-------+--------+-------------+----------------+
| id | firstName | lastName | address   | city | state | zip    | phoneNumber | email          |
+----+-----------+----------+-----------+------+-------+--------+-------------+----------------+
|  1 | Dhanu     | pri      | 111mainst | zzz  | TN    | 641017 | 1234567890  | aaaa@gmail.com |
|  2 | deepak    | kumar    | 222 main  | mmm  | TN    | 641018 | 0987654321  | bbb@gmail.com  |
+----+-----------+----------+-----------+------+-------+--------+-------------+----------------+
2 rows in set (0.00 sec)

--uc4 edit contact by person
mysql> UPDATE  Address_Book_service
    -> SET address='123 new',
    -> city ='cbe',
    -> zip='123',
    -> phoneNumber='1357809765',
    -> email='qwe12@gmail.com'
    -> WHERE firstName='Dhanu' AND lastName='pri';
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> Select * from Address_Book_service;
+----+-----------+----------+----------+------+-------+--------+-------------+-----------------+
| id | firstName | lastName | address  | city | state | zip    | phoneNumber | email           |
+----+-----------+----------+----------+------+-------+--------+-------------+-----------------+
|  1 | Dhanu     | pri      | 123 new  | cbe  | TN    | 123    | 1357809765  | qwe12@gmail.com |
|  2 | deepak    | kumar    | 222 main | mmm  | TN    | 641018 | 0987654321  | bbb@gmail.com   |
+----+-----------+----------+----------+------+-------+--------+-------------+-----------------+
2 rows in set (0.00 sec)

--uc5 delete by name

mysql> DELETE FROM Address_Book_service
    -> WHERE firstName='Dhanu' AND lastName='pri';
Query OK, 1 row affected (0.01 sec)

mysql> Select * from Address_Book_service;
+----+-----------+----------+----------+------+-------+--------+-------------+---------------+
| id | firstName | lastName | address  | city | state | zip    | phoneNumber | email         |
+----+-----------+----------+----------+------+-------+--------+-------------+---------------+
|  2 | deepak    | kumar    | 222 main | mmm  | TN    | 641018 | 0987654321  | bbb@gmail.com |
+----+-----------+----------+----------+------+-------+--------+-------------+---------------+
1 row in set (0.00 sec)

--uc6 retrieve person belong to city or state

mysql> SELECT * FROM Address_Book_service
    -> WHERE city='aaa';
+----+-----------+----------+------------+------+-------+--------+-------------+----------------+
| id | firstName | lastName | address    | city | state | zip    | phoneNumber | email          |
+----+-----------+----------+------------+------+-------+--------+-------------+----------------+
|  4 | naveen    | sharma   | 121 mainst | aaa  | TN    | 641018 | 0987651121  | bbb4@gmail.com |
+----+-----------+----------+------------+------+-------+--------+-------------+----------------+
1 row in set (0.00 sec)

mysql> SELECT * FROM Address_Book_service
    -> WHERE state='TN';
+----+-----------+----------+------------+------+-------+--------+-------------+----------------+
| id | firstName | lastName | address    | city | state | zip    | phoneNumber | email          |
+----+-----------+----------+------------+------+-------+--------+-------------+----------------+
|  2 | deepak    | kumar    | 222 main   | mmm  | TN    | 641018 | 0987654321  | bbb@gmail.com  |
|  3 | Nishanth  | J        | 111mainst  | zzz  | TN    | 641017 | 1234567890  | aaaa@gmail.com |
|  4 | naveen    | sharma   | 121 mainst | aaa  | TN    | 641018 | 0987651121  | bbb4@gmail.com |
+----+-----------+----------+------------+------+-------+--------+-------------+----------------+
3 rows in set (0.00 sec)

--uc7 size of address book by city and state
mysql> SELECT city,COUNT(*) as city_count
    -> FROM  Address_Book_service
    -> GROUP BY city;
+------+------------+
| city | city_count |
+------+------------+
| mmm  |          1 |
| zzz  |          1 |
| aaa  |          1 |
+------+------------+
3 rows in set (0.01 sec)

mysql> SELECT state,COUNT(*) as state_count
    -> FROM  Address_Book_service
    -> GROUP BY state;
+-------+-------------+
| state | state_count |
+-------+-------------+
| TN    |           3 |
+-------+-------------+
1 row in set (0.00 sec)

--uc8 retrive entries sorted alphabetically by person's name for a given city

mysql> SELECT * FROM Address_Book_service
    -> WHERE city='palani'
    -> ORDER BY lastName,FirstName;
+----+-----------+----------+---------+--------+-------+--------+-------------+------------------+
| id | firstName | lastName | address | city   | state | zip    | phoneNumber | email            |
+----+-----------+----------+---------+--------+-------+--------+-------------+------------------+
|  5 | aarthi    | A        | 11we    | palani | TN    | 641017 | 1234567890  | aarthi@gmail.com |
|  6 | sandy     | s        | qqq     | palani | TN    | 641018 | 0987651121  | bbb4@gmail.com   |
+----+-----------+----------+---------+--------+-------+--------+-------------+------------------+
2 rows in set (0.00 sec)

mysql> SELECT * FROM Address_Book_service
    -> ;
+----+-----------+----------+------------+--------+-------+--------+-------------+------------------+
| id | firstName | lastName | address    | city   | state | zip    | phoneNumber | email            |
+----+-----------+----------+------------+--------+-------+--------+-------------+------------------+
|  2 | deepak    | kumar    | 222 main   | mmm    | TN    | 641018 | 0987654321  | bbb@gmail.com    |
|  3 | Nishanth  | J        | 111mainst  | zzz    | TN    | 641017 | 1234567890  | aaaa@gmail.com   |
|  4 | naveen    | sharma   | 121 mainst | aaa    | TN    | 641018 | 0987651121  | bbb4@gmail.com   |
|  5 | aarthi    | A        | 11we       | palani | TN    | 641017 | 1234567890  | aarthi@gmail.com |
|  6 | sandy     | s        | qqq        | palani | TN    | 641018 | 0987651121  | bbb4@gmail.com   |
+----+-----------+----------+------------+--------+-------+--------+-------------+------------------+
5 rows in set (0.00 sec)

--uc9 alter addressbook by adding column

mysql> ALTER TABLE Address_Book_service
    -> ADD COLUMN name VARCHAR(100) NOT NULL,
    -> ADD COLUMN type VARCHAR(100) NOT NULL;
Query OK, 0 rows affected (0.06 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> UPDATE Address_Book_service
    -> SET name='deepak kumar', type='friend'
    -> WHERE firstName='deepak' AND lastName='kumar';
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE Address_Book_service
    -> SET name='nish', type='friend'
    -> WHERE firstName='Nishanth' AND lastName='J';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE Address_Book_service
    -> SET name='naveen sharma', type='friend'
    -> WHERE firstName='naveen' AND lastName='sharma';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE Address_Book_service
    -> SET name='aarthi', type='classmate'
    -> WHERE firstName='aarthi' AND lastName='A';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE Address_Book_service
    -> SET name='sandhya', type='classmate'
    -> WHERE firstName='sandy' AND lastName='s';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> SELECT * FROM Address_Book_service
    -> ;
+----+-----------+----------+------------+--------+-------+--------+-------------+------------------+---------------+-----------+
| id | firstName | lastName | address    | city   | state | zip    | phoneNumber | email            | name          | type      |
+----+-----------+----------+------------+--------+-------+--------+-------------+------------------+---------------+-----------+
|  2 | deepak    | kumar    | 222 main   | mmm    | TN    | 641018 | 0987654321  | bbb@gmail.com    | deepak kumar  | friend    |
|  3 | Nishanth  | J        | 111mainst  | zzz    | TN    | 641017 | 1234567890  | aaaa@gmail.com   | nish          | friend    |
|  4 | naveen    | sharma   | 121 mainst | aaa    | TN    | 641018 | 0987651121  | bbb4@gmail.com   | naveen sharma | friend    |
|  5 | aarthi    | A        | 11we       | palani | TN    | 641017 | 1234567890  | aarthi@gmail.com | aarthi        | classmate |
|  6 | sandy     | s        | qqq        | palani | TN    | 641018 | 0987651121  | bbb4@gmail.com   | sandhya       | classmate |
+----+-----------+----------+------------+--------+-------+--------+-------------+------------------+---------------+-----------+
5 rows in set (0.00 sec)

--uc11 add same person for  both classmate and friend
mysql> INSERT INTO Address_Book_service (firstName, lastName, address, city, state, zip, phoneNumber, email,name,type) VALUES('aarthi','A','11we','palani','TN','641017','1234567890','aarthi@gmail.com','aarthi','friend');
Query OK, 1 row affected (0.03 sec)

mysql> SELECT * FROM Address_Book_service;
+----+-----------+----------+------------+--------+-------+--------+-------------+------------------+---------------+-----------+
| id | firstName | lastName | address    | city   | state | zip    | phoneNumber | email            | name          | type      |
+----+-----------+----------+------------+--------+-------+--------+-------------+------------------+---------------+-----------+
|  2 | deepak    | kumar    | 222 main   | mmm    | TN    | 641018 | 0987654321  | bbb@gmail.com    | deepak kumar  | friend    |
|  3 | Nishanth  | J        | 111mainst  | zzz    | TN    | 641017 | 1234567890  | aaaa@gmail.com   | nish          | friend    |
|  4 | naveen    | sharma   | 121 mainst | aaa    | TN    | 641018 | 0987651121  | bbb4@gmail.com   | naveen sharma | friend    |
|  5 | aarthi    | A        | 11we       | palani | TN    | 641017 | 1234567890  | aarthi@gmail.com | aarthi        | classmate |
|  6 | sandy     | s        | qqq        | palani | TN    | 641018 | 0987651121  | bbb4@gmail.com   | sandhya       | classmate |
|  7 | aarthi    | A        | 11we       | palani | TN    | 641017 | 1234567890  | aarthi@gmail.com | aarthi        | friend    |
+----+-----------+----------+------------+--------+-------+--------+-------------+------------------+---------------+-----------+
6 rows in set (0.01 sec)

--uc13 retrieve for all above usecases
 SELECT * FROM Address_Book_service
    -> WHERE city='palani'
    -> GROUP BY city;
+----+-----------+----------+---------+--------+-------+--------+-------------+------------------+--------+-----------+
| id | firstName | lastName | address | city   | state | zip    | phoneNumber | email            | name   | type      |
+----+-----------+----------+---------+--------+-------+--------+-------------+------------------+--------+-----------+
|  5 | aarthi    | A        | 11we    | palani | TN    | 641017 | 1234567890  | aarthi@gmail.com | aarthi | classmate |
+----+-----------+----------+---------+--------+-------+--------+-------------+------------------+--------+-----------+
1 row in set (0.01 sec)

mysql> SELECT city,COUNT(*) as city_count
    -> FROM  Address_Book_service
    -> GROUP BY city;
+--------+------------+
| city   | city_count |
+--------+------------+
| mmm    |          1 |
| zzz    |          1 |
| aaa    |          1 |
| palani |          3 |
+--------+------------+
4 rows in set (0.01 sec)
mysql>  SELECT * FROM Address_Book_service
    -> WHERE city='palani'
    -> ORDER BY lastName,FirstName;
+----+-----------+----------+---------+--------+-------+--------+-------------+------------------+---------+-----------+
| id | firstName | lastName | address | city   | state | zip    | phoneNumber | email            | name    | type      |
+----+-----------+----------+---------+--------+-------+--------+-------------+------------------+---------+-----------+
|  5 | aarthi    | A        | 11we    | palani | TN    | 641017 | 1234567890  | aarthi@gmail.com | aarthi  | classmate |
|  7 | aarthi    | A        | 11we    | palani | TN    | 641017 | 1234567890  | aarthi@gmail.com | aarthi  | friend    |
|  6 | sandy     | s        | qqq     | palani | TN    | 641018 | 0987651121  | bbb4@gmail.com   | sandhya | classmate |
+----+-----------+----------+---------+--------+-------+--------+-------------+------------------+---------+-----------+
3 rows in set (0.01 sec)

mysql> SELECT * FROM Address_Book_service;
+----+-----------+----------+------------+--------+-------+--------+-------------+------------------+---------------+-----------+
| id | firstName | lastName | address    | city   | state | zip    | phoneNumber | email            | name          | type      |
+----+-----------+----------+------------+--------+-------+--------+-------------+------------------+---------------+-----------+
|  2 | deepak    | kumar    | 222 main   | mmm    | TN    | 641018 | 0987654321  | bbb@gmail.com    | deepak kumar  | friend    |
|  3 | Nishanth  | J        | 111mainst  | zzz    | TN    | 641017 | 1234567890  | aaaa@gmail.com   | nish          | friend    |
|  4 | naveen    | sharma   | 121 mainst | aaa    | TN    | 641018 | 0987651121  | bbb4@gmail.com   | naveen sharma | friend    |
|  5 | aarthi    | A        | 11we       | palani | TN    | 641017 | 1234567890  | aarthi@gmail.com | aarthi        | classmate |
|  6 | sandy     | s        | qqq        | palani | TN    | 641018 | 0987651121  | bbb4@gmail.com   | sandhya       | classmate |
|  7 | aarthi    | A        | 11we       | palani | TN    | 641017 | 1234567890  | aarthi@gmail.com | aarthi        | friend    |
+----+-----------+----------+------------+--------+-------+--------+-------------+------------------+---------------+-----------+
6 rows in set (0.00 sec)