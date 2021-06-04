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
-- Table structure for table `chi_tiet_san_pham`
--

DROP TABLE IF EXISTS `chi_tiet_san_pham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chi_tiet_san_pham` (
  `id_chi_tiet_san_pham` int NOT NULL AUTO_INCREMENT,
  `id_san_pham` int DEFAULT NULL,
  `id_kich_thuoc` int DEFAULT NULL,
  `id_mau_sac` int DEFAULT NULL,
  `so_luong` int DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_chi_tiet_san_pham`),
  KEY `fk_chi_tiet_san_pham_san_pham_idx` (`id_san_pham`),
  KEY `fk_chi_tiet_san_pham_kich_thuoc_idx` (`id_kich_thuoc`),
  KEY `fk_chi_tiet_san_pham_mau_sac_idx` (`id_mau_sac`),
  CONSTRAINT `fk_chi_tiet_san_pham_kich_thuoc` FOREIGN KEY (`id_kich_thuoc`) REFERENCES `kich_thuoc` (`id_kich_thuoc`),
  CONSTRAINT `fk_chi_tiet_san_pham_mau_sac` FOREIGN KEY (`id_mau_sac`) REFERENCES `mau_sac` (`id_mau_sac`),
  CONSTRAINT `fk_chi_tiet_san_pham_san_pham` FOREIGN KEY (`id_san_pham`) REFERENCES `san_pham` (`id_san_pham`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_tiet_san_pham`
--

LOCK TABLES `chi_tiet_san_pham` WRITE;
/*!40000 ALTER TABLE `chi_tiet_san_pham` DISABLE KEYS */;
INSERT INTO `chi_tiet_san_pham` VALUES (1,1,1,1,20,1),(2,1,1,2,20,1),(3,1,1,3,20,1),(4,1,1,4,20,1),(5,1,1,5,20,1),(6,1,2,1,20,1),(7,1,2,2,20,1),(8,1,2,3,20,1),(9,1,2,4,20,1),(10,1,2,5,20,1),(11,1,3,1,20,1),(12,1,3,2,20,1),(13,1,3,3,20,1),(14,1,3,4,20,1),(15,1,3,5,20,1),(16,1,4,1,20,1),(17,1,4,2,20,1),(18,1,4,3,20,1),(19,1,4,4,20,1),(20,1,4,5,20,1),(21,1,5,1,20,1),(22,1,5,2,20,1),(23,1,5,3,20,1),(24,1,5,4,20,1),(25,1,5,5,20,1),(26,2,1,3,20,1),(27,2,2,3,20,1),(28,2,3,3,20,1),(29,2,4,3,20,1),(30,2,1,6,20,1),(31,2,2,6,20,1),(32,2,3,6,20,1),(34,2,4,6,20,1),(35,3,1,7,20,1),(36,3,2,7,20,1),(37,3,3,7,20,1),(38,3,4,7,0,1),(39,3,5,7,20,1),(40,4,1,8,20,1),(41,4,2,8,20,1),(42,4,3,8,20,1),(43,4,4,8,20,1),(44,5,1,6,20,1),(45,5,2,6,20,1),(46,5,3,6,20,1),(47,5,4,6,20,1),(48,5,1,9,20,1),(49,5,2,9,20,1),(50,5,3,9,20,1),(51,5,4,9,20,1),(52,6,1,10,12,1),(53,6,2,10,0,1),(54,6,3,10,0,1),(55,6,1,11,15,1),(56,6,2,11,15,1),(57,6,3,11,15,1),(58,7,1,12,20,1),(59,7,2,12,20,1),(60,7,3,12,0,1),(61,7,1,13,20,1),(62,7,2,13,20,1),(63,7,3,13,0,1),(64,8,1,14,20,1),(65,8,2,14,20,1),(66,8,3,14,20,1),(67,8,4,14,20,1),(68,8,1,3,20,1),(69,8,2,3,20,1),(70,8,3,3,20,1),(71,8,4,3,20,1),(72,9,1,1,20,1),(73,9,2,1,20,1),(74,9,3,1,20,1),(75,9,4,1,20,1),(76,9,5,1,0,1),(77,9,1,15,20,1),(78,9,2,15,20,1),(79,9,3,15,20,1),(80,9,4,15,20,1),(81,9,5,15,0,1),(82,9,1,3,20,1),(83,9,2,3,20,1),(84,9,3,3,20,1),(85,9,4,3,20,1),(86,9,5,3,0,1),(87,9,1,16,20,1),(88,9,2,16,20,1),(89,9,3,16,20,1),(90,9,4,16,20,1),(91,9,5,16,0,1),(92,10,1,14,20,1),(93,10,2,14,20,1),(94,10,3,14,0,1),(95,10,4,14,0,1),(96,10,5,14,0,1),(97,10,1,3,0,1),(98,10,2,3,20,1),(99,10,3,3,0,1),(100,10,4,3,0,1),(101,10,5,3,0,1),(102,11,2,14,0,1),(103,11,3,14,0,1),(104,11,4,14,0,1),(105,12,2,17,20,1),(106,12,3,17,20,1),(107,13,1,18,0,1),(108,13,2,18,20,1),(109,13,3,18,20,1),(110,13,4,18,20,1),(111,13,5,18,0,1),(112,13,1,19,0,1),(113,13,2,19,20,1),(114,13,3,19,20,1),(115,13,4,19,0,1),(116,13,5,19,0,1),(117,13,1,15,0,1),(118,13,2,15,20,1),(119,13,3,15,20,1),(120,13,4,15,20,1),(121,13,5,15,0,1),(122,13,1,20,20,1),(123,13,2,20,20,1),(124,13,3,20,20,1),(125,13,4,20,20,1),(126,13,5,20,0,1),(127,14,7,14,20,1),(128,14,7,3,22,1),(129,15,1,3,20,1),(130,15,2,3,20,1),(131,15,3,3,0,1),(132,15,4,3,20,1),(133,15,1,21,20,1),(134,15,2,21,20,1),(135,15,3,21,20,1),(136,15,4,21,20,1),(164,16,2,3,20,1),(165,16,3,3,0,1),(166,16,4,3,20,1),(167,16,2,22,20,1),(168,16,3,22,20,1),(169,16,4,22,20,1),(170,16,2,23,20,1),(171,16,3,23,20,1),(172,16,4,23,20,1),(173,16,2,24,20,1),(174,16,3,24,20,1),(175,16,4,24,20,1);
/*!40000 ALTER TABLE `chi_tiet_san_pham` ENABLE KEYS */;
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
