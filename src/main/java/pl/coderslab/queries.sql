
CREATE DATABASE workshop2 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

use  workshop2;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userName varchar(255) ,
    eMail varchar(255) UNIQUE,
    passWord varchar(60)
);

drop table users;


CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userName varchar(255) ,
    eMail varchar(255) UNIQUE,
    passWord varchar(60)
);

select * from users;


INSERT INTO `users` VALUES (1,'Andrzej','andrzej.jozwiak@coderslab.pl','$2a$12$shPJKdEI224cN41VvKsVDuhtPPiAtEgP7w8z2WqpgVXjIFQhrwBqO'),(2,'Mateusz','mateusz.jądro@coderslab.pl','$2a$12$ohO6RMv6COaGoVR4EEwEUe8EMrdSQfMIScKWyayoAl68UHWgcB7Iu'),(3,'Grzegorz','grzegorz@bak.pl','$2a$12$1JdGmRNjgKdFZe.OM2Xfq.7wnuInvPio92KfI7nxXQQLDY.Gmwv9K'),(4,'Marian','marian.luter@coderslab.pl','$2a$12$.URCkRWVCD2M.qFbIZJ0WefwaJuEv8WAbJQR3t1oSuYjpsKSkxvnS'),(5,'Joanna','joanna.blonda@coderslab.pl','$2a$12$47TTGYIMjBydk9KYb5shTe8sElg79WG9q/Zv4/Bgpugr/mEovXnWK');

select * from users;