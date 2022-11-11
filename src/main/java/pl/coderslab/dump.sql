-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: workshop2
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `userName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `eMail` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `passWord` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Andrzej','andrzej.jozwiak@coderslab.pl','$2a$12$shPJKdEI224cN41VvKsVDuhtPPiAtEgP7w8z2WqpgVXjIFQhrwBqO'),(2,'Mateusz','mateusz.jądro@coderslab.pl','$2a$12$ohO6RMv6COaGoVR4EEwEUe8EMrdSQfMIScKWyayoAl68UHWgcB7Iu'),(3,'Grzegorz','grzegorz@bak.pl','$2a$12$1JdGmRNjgKdFZe.OM2Xfq.7wnuInvPio92KfI7nxXQQLDY.Gmwv9K'),(4,'Marian','marian.luter@coderslab.pl','$2a$12$.URCkRWVCD2M.qFbIZJ0WefwaJuEv8WAbJQR3t1oSuYjpsKSkxvnS'),(5,'Joanna','joanna.blonda@coderslab.pl','$2a$12$47TTGYIMjBydk9KYb5shTe8sElg79WG9q/Zv4/Bgpugr/mEovXnWK');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-11 17:07:38
