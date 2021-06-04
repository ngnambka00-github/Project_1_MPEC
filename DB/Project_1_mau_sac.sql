-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: localhost    Database: Project_1
-- ------------------------------------------------------
-- Server version	8.0.25-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mau_sac`
--

DROP TABLE IF EXISTS `mau_sac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mau_sac` (
  `id_mau_sac` int NOT NULL AUTO_INCREMENT,
  `ten_mau_sac` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ma_mau` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_mau_sac`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mau_sac`
--

LOCK TABLES `mau_sac` WRITE;
/*!40000 ALTER TABLE `mau_sac` DISABLE KEYS */;
INSERT INTO `mau_sac` VALUES (1,'Vàng Beeswas','#f1c40f',1),(2,'Strong Blue','#ff0101',1),(3,'Solid.Đen/Black.Đen','#2d3436',1),(4,'Solid.Đỏ/Red.Đỏ','#d63031',1),(5,'Solid.Trắng/Red.Trắng','#fff9d5',1),(6,'Solid.Xanh da trời/Blue.Xanh blue','#0984e3',1),(7,'White.Trắng xanh','#81ecec',1),(8,'Hoa kẻ trắng gà','#ffaaad',1),(9,'Pattern.Cam/Orange.Cam','#e67e22',1),(10,'Kẻ Caro.Đen/Black.Đen/Trắng','#312f2e',1),(11,'Kẻ Caro.Vàng/White.Trắng','#ffe200',1),(12,'Kẻ Caro.Be/Beige.Be','#dff17b',1),(13,'Caro Cam/Nâu/Đen','#b6003b',1),(14,'Solid Trắng/White.Trắng','#f5f6fa',1),(15,'Solid Tím/Purple.Tím','#9b59b6',1),(16,'Solid Xanh lá cây/Green.Xanh lá','#2ecc71',1),(17,'Solid Hồng/Pink.Hồng','#ED4C67',1),(18,'Xanh bơ','#78e08f',1),(19,'Melange.Xám/Grey.Tàn ','#596275',1),(20,'Kẻ sọc/Kẻ ngang.Đen/Black.Đen/Trắng','#596275',1),(21,'Kẻ caro ghi','#3c6382',1),(22,'Kẻ caro.Vàng/Yellow + Gold.Vàng','#fff200',1),(23,'Kẻ caro.Nâu/Brown.Nâu','#e15f41',1),(24,'Kẻ caro.Xanh lá cây/Green.Xanh lá','#2ecc71',1);
/*!40000 ALTER TABLE `mau_sac` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-03 15:33:08
