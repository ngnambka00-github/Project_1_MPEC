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
-- Table structure for table `chi_tiet_hoa_don`
--

DROP TABLE IF EXISTS `chi_tiet_hoa_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chi_tiet_hoa_don` (
  `id_hoa_don` int NOT NULL,
  `id_chi_tiet_san_pham` int NOT NULL,
  `so_luong` int DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_hoa_don`,`id_chi_tiet_san_pham`),
  KEY `fk_chi_tiet_hoa_don_chi_tiet_san_pham_idx` (`id_chi_tiet_san_pham`),
  KEY `fk_chi_tiet_hoa_don_hoa_don_idx` (`id_hoa_don`),
  CONSTRAINT `fk_chi_tiet_hoa_don_chi_tiet_san_pham` FOREIGN KEY (`id_chi_tiet_san_pham`) REFERENCES `chi_tiet_san_pham` (`id_chi_tiet_san_pham`),
  CONSTRAINT `fk_chi_tiet_hoa_don_hoa_don` FOREIGN KEY (`id_hoa_don`) REFERENCES `hoa_don` (`id_hoa_don`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_tiet_hoa_don`
--

LOCK TABLES `chi_tiet_hoa_don` WRITE;
/*!40000 ALTER TABLE `chi_tiet_hoa_don` DISABLE KEYS */;
/*!40000 ALTER TABLE `chi_tiet_hoa_don` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `danh_muc`
--

DROP TABLE IF EXISTS `danh_muc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danh_muc` (
  `id_danh_muc` int NOT NULL AUTO_INCREMENT,
  `ten_danh_muc` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `mo_ta` text CHARACTER SET utf8 COLLATE utf8_bin,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_danh_muc`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danh_muc`
--

LOCK TABLES `danh_muc` WRITE;
/*!40000 ALTER TABLE `danh_muc` DISABLE KEYS */;
INSERT INTO `danh_muc` VALUES (1,'Áo phông','',1),(2,'Áo ba lỗ','',1),(3,'Áo sơ mi','',1),(4,'Áo thun dai tay','',1),(5,'Áo len','',1),(6,'Áo nỉ không mũ',NULL,1),(7,'Áo nỉ mũ',NULL,1),(8,'Áo khoác nỉ',NULL,1),(9,'Áo khoác',NULL,1),(10,'Bộ áo dài',NULL,1),(11,'Váy',NULL,1),(12,'Yếm',NULL,1),(13,'Chân váy',NULL,1),(14,'Quần váy',NULL,1),(15,'Quần short',NULL,1),(16,'Quần Jeans',NULL,1),(17,'Quần Khaki',NULL,1),(18,'Quần Jogger',NULL,1),(19,'Quần dài',NULL,1),(25,'Trần Thị Hà','12345',0),(29,'Phạm Thị Quỳnh','Phạm Thị Quỳnh',0),(35,'Sản Phẩm cho người khuyết tật','Nguyễn Văn Nam - Trường đại học Bách Khoa Hà Nội, Số 1 Đại Cổ Việt aaaa aaaaaaaa aaaaaaa aaa aaaaaaaaaa aaaa aaaaa',0),(36,'Nguyễn Văn Nam','abcd1234',1),(37,'Nguyễn Văn Nam abc','Trần Thị Hà: sao bạn lại giỏi đến vậy',0),(38,'Phạm aaaa','FDSFA',0),(39,'Danh mục new 1','Test mô tả danh mục new 1',1);
/*!40000 ALTER TABLE `danh_muc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hinh_anh`
--

DROP TABLE IF EXISTS `hinh_anh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hinh_anh` (
  `id_hinh_anh` int NOT NULL AUTO_INCREMENT,
  `ten_hinh_anh` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id_san_pham` int DEFAULT NULL,
  `id_mau_sac` int DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_hinh_anh`),
  KEY `fk_hinh_anh_san_pham_idx` (`id_san_pham`),
  KEY `fk_hinh_anh_mau_sac_idx` (`id_mau_sac`),
  CONSTRAINT `fk_hinh_anh_mau_sac` FOREIGN KEY (`id_mau_sac`) REFERENCES `mau_sac` (`id_mau_sac`),
  CONSTRAINT `fk_hinh_anh_san_pham` FOREIGN KEY (`id_san_pham`) REFERENCES `san_pham` (`id_san_pham`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hinh_anh`
--

LOCK TABLES `hinh_anh` WRITE;
/*!40000 ALTER TABLE `hinh_anh` DISABLE KEYS */;
INSERT INTO `hinh_anh` VALUES (1,'ao-phong-marvel-s21-boozilla-un-xhd0m-0.jpg',1,1,1),(2,'ao-phong-marvel-s21-boozilla-un-dscz6-3.jpg',1,1,1),(3,'ao-phong-marvel-s21-boozilla-un-rhixp-2.jpg',1,1,1),(4,'ao-phong-marvel-s21-boozilla-un-pwsdk-1.jpg',1,1,1),(5,'ao-phong-marvel-s21-boozilla-un-soliddo-reddo-1.jpg',1,4,1),(6,'ao-phong-marvel-s21-boozilla-un-soliddo-reddo-2.jpg',1,4,1),(7,'ao-phong-marvel-s21-boozilla-un-soliddo-reddo-4.jpg',1,4,1),(8,'ao-phong-marvel-s21-boozilla-un-soliddo-reddo-3.jpg',1,4,1),(9,'ao-phong-marvel-s21-boozilla-un-solidtrangwhitetrang-1.jpg',1,3,1),(10,'ao-phong-marvel-s21-boozilla-un-solidtrangwhitetrang-2.jpg',1,3,1),(11,'ao-phong-marvel-s21-boozilla-un-solidtrangwhitetrang-3.jpg',1,3,1),(12,'ao-phong-marvel-s21-boozilla-un-solidtrangwhitetrang-4.jpg',1,3,1),(13,'ao-phong-marvel-s21-boozilla-un-strong-blue-1.jpg',1,2,1),(14,'ao-phong-marvel-s21-boozilla-un-strong-blue-2.jpg',1,2,1),(15,'ao-phong-marvel-s21-boozilla-un-strong-blue-4.jpg',1,2,1),(16,'ao-phong-marvel-s21-boozilla-un-strong-blue-3.jpg',1,2,1),(17,'ao-phong-marvel-s21-boozilla-un-solidden-blackden-1.jpg',1,5,1),(18,'ao-phong-marvel-s21-boozilla-un-solidden-blackden-2.jpg',1,5,1),(19,'ao-phong-marvel-s21-boozilla-un-solidden-blackden-3.jpg',1,5,1),(20,'ao-phong-marvel-s21-boozilla-un-solidden-blackden-4.jpg',1,5,1),(21,'ao-tee-mickey-go-sg-un-bzl-solidden-blackden-1.jpg',2,3,1),(22,'ao-tee-mickey-go-sg-un-bzl-solidden-blackden-2.jpg',2,3,1),(23,'ao-tee-mickey-go-sg-un-bzl-solidden-blackden-3.jpg',2,3,1),(24,'ao-tee-mickey-go-sg-un-bzl-solidden-blackden-4.jpg',2,3,1),(25,'ao-tee-mickey-go-sg-un-bzl-solidxanh-da-troi-bluexanh-blu-1.jpg',2,6,1),(26,'ao-tee-mickey-go-sg-un-bzl-solidxanh-da-troi-bluexanh-blu-2.jpg',2,6,1),(27,'ao-tee-mickey-go-sg-un-bzl-solidxanh-da-troi-bluexanh-blu-3.jpg',2,6,1),(28,'ao-tee-mickey-go-sg-un-bzl-solidxanh-da-troi-bluexanh-blu-4.jpg',2,6,1),(33,'ao-ba-lo-nam-loose-tie-dye-patten-hoa-tiettrangwhitetrang-xanh-1.jpg',3,7,1),(34,'ao-ba-lo-nam-loose-tie-dye-patten-hoa-tiettrangwhitetrang-xanh-2.jpg',3,7,1),(35,'ao-ba-lo-nam-loose-tie-dye-patten-hoa-tiettrangwhitetrang-xanh-3.jpg',3,7,1),(36,'ao-ba-lo-nam-loose-tie-dye-patten-hoa-tiettrangwhitetrang-xanh-4.jpg',3,7,1),(37,'ao-ba-lo-nu-crop-2-day-hoa-tiet-hoa-ke-trang-nga-1.jpg',4,8,1),(38,'ao-ba-lo-nu-crop-2-day-hoa-tiet-hoa-ke-trang-nga-2.jpg',4,8,1),(39,'ao-ba-lo-nu-crop-2-day-hoa-tiet-hoa-ke-trang-nga-3.jpg',4,8,1),(40,'ao-ba-lo-nu-crop-2-day-hoa-tiet-hoa-ke-trang-nga-4.jpg',4,8,1),(41,'ao-so-mi-nam-loose-co-cuba-patten-hoa-tietxanh-da-troi-bluexanh-1.jpg',5,6,1),(42,'ao-so-mi-nam-loose-co-cuba-patten-hoa-tietxanh-da-troi-bluexanh-3.jpg',5,6,1),(43,'ao-so-mi-nam-loose-co-cuba-patten-hoa-tietxanh-da-troi-bluexanh-7.jpg',5,6,1),(44,'ao-so-mi-nam-loose-co-cuba-patten-hoa-tietxanh-da-troi-bluexanh-6.jpg',5,6,1),(45,'ao-so-mi-nam-loose-co-cuba-patten-hoa-tietcam-orangecam-1.jpg',5,9,1),(46,'ao-so-mi-nam-loose-co-cuba-patten-hoa-tietcam-orangecam-3.jpg',5,9,1),(47,'ao-so-mi-nam-loose-co-cuba-patten-hoa-tietcam-orangecam-6.jpg',5,9,1),(48,'ao-so-mi-nam-loose-co-cuba-patten-hoa-tietcam-orangecam-7.jpg',5,9,1),(49,'shirt-so-mi-fe-stu-loose-nt-kem-tui-ke-caroden-blackdentrang-1.jpg',6,10,1),(50,'shirt-so-mi-fe-stu-loose-nt-kem-tui-ke-caroden-blackdentrang-2.jpg',6,10,1),(51,'shirt-so-mi-fe-stu-loose-nt-kem-tui-ke-caroden-blackdentrang-3.jpg',6,10,1),(52,'shirt-so-mi-fe-stu-loose-nt-kem-tui-ke-caroden-blackdentrang-4.jpg',6,10,1),(53,'shirt-so-mi-fe-stu-loose-nt-kem-tui-ke-caro-vangtrang-1.jpg',6,11,1),(54,'shirt-so-mi-fe-stu-loose-nt-kem-tui-ke-caro-vangtrang-2.jpg',6,11,1),(55,'shirt-so-mi-fe-stu-loose-nt-kem-tui-ke-caro-vangtrang-3.jpg',6,11,1),(56,'shirt-so-mi-fe-stu-loose-nt-kem-tui-ke-caro-vangtrang-4.jpg',6,11,1),(57,'vay-nu-a-line-1-hang-khuy-ke-carobe-beigebe-1.jpg',7,12,1),(58,'vay-nu-a-line-1-hang-khuy-ke-carobe-beigebe-2.jpg',7,12,1),(59,'vay-nu-a-line-1-hang-khuy-ke-carobe-beigebe-4.jpg',7,12,1),(60,'vay-nu-a-line-1-hang-khuy-ke-carobe-beigebe-6.jpg',7,12,1),(61,'vay-nu-a-line-1-hang-khuy-caro-camnauden-1.jpg',7,13,1),(62,'vay-nu-a-line-1-hang-khuy-caro-camnauden-2.jpg',7,13,1),(63,'vay-nu-a-line-1-hang-khuy-caro-camnauden-5.jpg',7,13,1),(64,'vay-nu-a-line-1-hang-khuy-caro-camnauden-6.jpg',7,13,1),(65,'ao-tee-oversized-marvel-bzl-solidtrangwhitetrang-1.jpg',8,14,1),(66,'ao-tee-oversized-marvel-bzl-solidtrangwhitetrang-2.jpg',8,14,1),(67,'ao-tee-oversized-marvel-bzl-solidtrangwhitetrang-3.jpg',8,14,1),(68,'ao-tee-oversized-marvel-bzl-solidtrangwhitetrang-4.jpg',8,14,1),(69,'ao-tee-oversized-marvel-bzl-solidden-blackden-5.jpg',8,3,1),(70,'ao-tee-oversized-marvel-bzl-solidden-blackden-6.jpg',8,3,1),(71,'ao-tee-oversized-marvel-bzl-solidden-blackden-7.jpg',8,3,1),(72,'ao-tee-oversized-marvel-bzl-solidden-blackden-8.jpg',8,3,1),(73,'ao-phong-nu-loose-in-gicuw-2.jpg',9,1,1),(74,'ao-phong-nu-loose-in-spfoe-3.jpg',9,1,1),(75,'ao-phong-nu-loose-in-wop0r-0.jpg',9,1,1),(76,'ao-phong-nu-loose-in-ghmas-1.jpg',9,1,1),(77,'ao-phong-nu-loose-in-solidtim-purpletim-1.jpg',9,15,1),(78,'ao-phong-nu-loose-in-solidtim-purpletim-2.jpg',9,15,1),(79,'ao-phong-nu-loose-in-solidtim-purpletim-3.jpg',9,15,1),(80,'ao-phong-nu-loose-in-solidtim-purpletim-4.jpg',9,15,1),(81,'ao-phong-nu-loose-in-solidden-blackden-1.jpg',9,3,1),(82,'ao-phong-nu-loose-in-solidden-blackden-2.jpg',9,3,1),(83,'ao-phong-nu-loose-in-solidden-blackden-3.jpg',9,3,1),(84,'ao-phong-nu-loose-in-solidden-blackden-4.jpg',9,3,1),(85,'ao-phong-nu-loose-in-solidxanh-la-cay-greenxanh-la-1.jpg',9,16,1),(86,'ao-phong-nu-loose-in-solidxanh-la-cay-greenxanh-la-2.jpg',9,16,1),(87,'ao-phong-nu-loose-in-solidxanh-la-cay-greenxanh-la-4.jpg',9,16,1),(88,'ao-phong-nu-loose-in-solidxanh-la-cay-greenxanh-la-3.jpg',9,16,1),(89,'ao-phong-mickey-tet-form-loose-solidtrangwhitetrang-4.jpg',10,14,1),(90,'ao-phong-mickey-tet-form-loose-solidtrangwhitetrang-2.jpg',10,14,1),(91,'ao-phong-mickey-tet-form-loose-solidtrangwhitetrang-1.jpg',10,14,1),(92,'ao-phong-mickey-tet-form-loose-solidtrangwhitetrang-3.jpg',10,14,1),(93,'ao-phong-mickey-tet-form-loose-solidden-blackden-4.jpg',10,3,1),(94,'ao-phong-mickey-tet-form-loose-solidden-blackden-2.jpg',10,3,1),(95,'ao-phong-mickey-tet-form-loose-solidden-blackden-3.jpg',10,3,1),(96,'ao-phong-mickey-tet-form-loose-solidden-blackden-1.jpg',10,3,1),(97,'sleeveless-ao-fe-stu-loose-mickey-layer-solidtrangwhitetrang-1.jpg',11,14,1),(98,'sleeveless-ao-fe-stu-loose-mickey-layer-solidtrangwhitetrang-2.jpg',11,14,1),(99,'sleeveless-ao-fe-stu-loose-mickey-layer-solidtrangwhitetrang-3.jpg',11,14,1),(100,'sleeveless-ao-fe-stu-loose-mickey-layer-solidtrangwhitetrang-5.jpg',11,14,1),(105,'ao-ba-lo-nu-crop-2-day-gio-solidhong-pink-magentahong-1.jpg',12,17,1),(106,'ao-ba-lo-nu-crop-2-day-gio-solidhong-pink-magentahong-2.jpg',12,17,1),(107,'ao-ba-lo-nu-crop-2-day-gio-solidhong-pink-magentahong-3.jpg',12,17,1),(108,'ao-ba-lo-nu-crop-2-day-gio-solidhong-pink-magentahong-4.jpg',12,17,1),(109,'ao-ba-lo-nu-crop-fit-basic-aq7uq-2.jpg',13,18,1),(110,'ao-ba-lo-nu-crop-fit-basic-ghnre-3.jpg',13,18,1),(111,'ao-ba-lo-nu-crop-fit-basic-xg13q-0.jpg',13,18,1),(112,'ao-ba-lo-nu-crop-fit-basic-6hzwx-1.jpg',13,18,1),(113,'ao-ba-lo-nu-crop-fit-basic-melangexam-graytan-dam-1.jpg',13,19,1),(114,'ao-ba-lo-nu-crop-fit-basic-melangexam-graytan-dam-2.jpg',13,19,1),(115,'ao-ba-lo-nu-crop-fit-basic-melangexam-graytan-dam-3.jpg',13,19,1),(116,'ao-ba-lo-nu-crop-fit-basic-melangexam-graytan-dam-4.jpg',13,19,1),(117,'ao-ba-lo-nu-crop-fit-basic-solidtim-purpletim-1.jpg',13,15,1),(118,'ao-ba-lo-nu-crop-fit-basic-solidtim-purpletim-2.jpg',13,15,1),(119,'ao-ba-lo-nu-crop-fit-basic-solidtim-purpletim-3.jpg',13,15,1),(120,'ao-ba-lo-nu-crop-fit-basic-solidtim-purpletim-4.jpg',13,15,1),(121,'ao-ba-lo-nu-crop-fit-basic-ke-socke-ngangden-blackdentrang-1.jpg',13,20,1),(122,'ao-ba-lo-nu-crop-fit-basic-ke-socke-ngangden-blackdentrang-2.jpg',13,20,1),(123,'ao-ba-lo-nu-crop-fit-basic-ke-socke-ngangden-blackdentrang-3.jpg',13,20,1),(124,'ao-ba-lo-nu-crop-fit-basic-ke-socke-ngangden-blackdentrang-4.jpg',13,20,1),(125,'chan-vay-nu-midi-cap-chun-solidtrangwhitetrang-1.jpg',14,14,1),(126,'chan-vay-nu-midi-cap-chun-solidtrangwhitetrang-2.jpg',14,14,1),(127,'chan-vay-nu-midi-cap-chun-solidtrangwhitetrang-3.jpg',14,14,1),(128,'chan-vay-nu-midi-cap-chun-solidtrangwhitetrang-4.jpg',14,14,1),(129,'chan-vay-nu-midi-cap-chun-solidden-blackden-1.jpg',14,3,1),(130,'chan-vay-nu-midi-cap-chun-solidden-blackden-2.jpg',14,3,1),(131,'chan-vay-nu-midi-cap-chun-solidden-blackden-3.jpg',14,3,1),(132,'chan-vay-nu-midi-cap-chun-solidden-blackden-4.jpg',14,3,1),(133,'chan-vay-nu-a-line-chot-sap-xow1e-3.jpg',15,3,1),(134,'chan-vay-nu-a-line-chot-sap-elzoh-2.jpg',15,3,1),(135,'chan-vay-nu-a-line-chot-sap-nb5jm-0.jpg',15,3,1),(136,'chan-vay-nu-a-line-chot-sap-ijgms-1.jpg',15,3,1),(137,'chan-vay-nu-a-line-chot-sap-ke-caro-ghi-1.jpg',15,21,1),(138,'chan-vay-nu-a-line-chot-sap-ke-caro-ghi-2.jpg',15,21,1),(139,'chan-vay-nu-a-line-chot-sap-ke-caro-ghi-3.jpg',15,21,1),(140,'chan-vay-nu-a-line-chot-sap-ke-caro-ghi-4.jpg',15,21,1),(141,'chan-vay-nu-a-line-pleated-solidden-blackden-1.jpg',16,3,1),(142,'chan-vay-nu-a-line-pleated-solidden-blackden-2.jpg',16,3,1),(143,'chan-vay-nu-a-line-pleated-solidden-blackden-3.jpg',16,3,1),(144,'chan-vay-nu-a-line-pleated-solidden-blackden-4.jpg',16,3,1),(145,'chan-vay-nu-a-line-pleated-ke-carovang-yellow-goldvang-13-0759-tpx-1.jpg',16,22,1),(146,'chan-vay-nu-a-line-pleated-ke-carovang-yellow-goldvang-13-0759-tpx-2.jpg',16,22,1),(147,'chan-vay-nu-a-line-pleated-ke-carovang-yellow-goldvang-13-0759-tpx-3.jpg',16,22,1),(148,'chan-vay-nu-a-line-pleated-ke-carovang-yellow-goldvang-13-0759-tpx-4.jpg',16,22,1),(149,'chan-vay-nu-a-line-pleated-ke-caronau-brownnau-1.jpg',16,23,1),(150,'chan-vay-nu-a-line-pleated-ke-caronau-brownnau-2.jpg',16,23,1),(151,'chan-vay-nu-a-line-pleated-ke-caronau-brownnau-3.jpg',16,23,1),(152,'chan-vay-nu-a-line-pleated-ke-caronau-brownnau-4.jpg',16,23,1),(153,'chan-vay-nu-a-line-pleated-ke-caroxanh-la-cay-greenxanh-la-1.jpg',16,24,1),(154,'chan-vay-nu-a-line-pleated-ke-caroxanh-la-cay-greenxanh-la-2.jpg',16,24,1),(155,'chan-vay-nu-a-line-pleated-ke-caroxanh-la-cay-greenxanh-la-3.jpg',16,24,1),(156,'chan-vay-nu-a-line-pleated-ke-caroxanh-la-cay-greenxanh-la-4.jpg',16,24,1);
/*!40000 ALTER TABLE `hinh_anh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoa_don`
--

DROP TABLE IF EXISTS `hoa_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoa_don` (
  `id_hoa_don` int NOT NULL AUTO_INCREMENT,
  `id_khach_hang` int DEFAULT NULL,
  `ngay_tao` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `is_thanh_toan` tinyint DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_hoa_don`),
  KEY `fk_hoa_don_khach_hang_idx` (`id_khach_hang`),
  CONSTRAINT `fk_hoa_don_khach_hang` FOREIGN KEY (`id_khach_hang`) REFERENCES `khach_hang` (`id_khach_hang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don`
--

LOCK TABLES `hoa_don` WRITE;
/*!40000 ALTER TABLE `hoa_don` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoa_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khach_hang`
--

DROP TABLE IF EXISTS `khach_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khach_hang` (
  `id_khach_hang` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ho_ten` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `dia_chi` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `so_dien_thoai` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `is_admin` tinyint DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_khach_hang`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khach_hang`
--

LOCK TABLES `khach_hang` WRITE;
/*!40000 ALTER TABLE `khach_hang` DISABLE KEYS */;
INSERT INTO `khach_hang` VALUES (1,'ngnambka00','dgsMUE35','Nguyễn Văn Nam','ngnambka00@gmail.com','Hải Phòng','0901599299',1,1),(2,'tranthiha','dgsMUE35','Trần Thị Hà','hatranthi@gmail.com','Thanh Hóa','0933812586',0,1),(3,'maipham','maipham','Phạm Thị Mai','maipham@gmail.com','Hải Phòng','0123456789',0,1);
/*!40000 ALTER TABLE `khach_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khuyen_mai`
--

DROP TABLE IF EXISTS `khuyen_mai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khuyen_mai` (
  `id_khuyen_mai` int NOT NULL AUTO_INCREMENT,
  `ten_khuyen_mai` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tien_khuyen_mai` int DEFAULT NULL,
  `thoi_gian_bat_dau` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `thoi_gian_ket_thuc` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_khuyen_mai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khuyen_mai`
--

LOCK TABLES `khuyen_mai` WRITE;
/*!40000 ALTER TABLE `khuyen_mai` DISABLE KEYS */;
/*!40000 ALTER TABLE `khuyen_mai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kich_thuoc`
--

DROP TABLE IF EXISTS `kich_thuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kich_thuoc` (
  `id_kich_thuoc` int NOT NULL AUTO_INCREMENT,
  `ten_kich_thuoc` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ky_hieu` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_kich_thuoc`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kich_thuoc`
--

LOCK TABLES `kich_thuoc` WRITE;
/*!40000 ALTER TABLE `kich_thuoc` DISABLE KEYS */;
INSERT INTO `kich_thuoc` VALUES (1,'Rất nhỏ','XS',1),(2,'Nhỏ','S',1),(3,'Trung bình','M',1),(4,'Size to','L',1),(5,'Size rất to','XL',1),(6,'Size rất rất to','XXL',1),(7,'Tự do','Free',1),(8,'Kích thước 0','Test ký hiệu 0',1),(9,'Kích thước 1','Nội dung 1',1),(10,'Kích thước 2','Nội dung 2',1),(11,'Kích thước 3','Nội dung 3 ',1);
/*!40000 ALTER TABLE `kich_thuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mau_sac`
--

DROP TABLE IF EXISTS `mau_sac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mau_sac` (
  `id_mau_sac` int NOT NULL AUTO_INCREMENT,
  `ten_mau_sac` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ma_mau` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_mau_sac`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mau_sac`
--

LOCK TABLES `mau_sac` WRITE;
/*!40000 ALTER TABLE `mau_sac` DISABLE KEYS */;
INSERT INTO `mau_sac` VALUES (1,'Vàng Beeswas','#f1c40f',1),(2,'Strong Blue','#ff0101',1),(3,'Solid.Đen/Black.Đen','#2d3436',1),(4,'Solid.Đỏ/Red.Đỏ','#d63031',1),(5,'Solid.Trắng/Red.Trắng','#fff9d5',1),(6,'Solid.Xanh da trời/Blue.Xanh blue','#0984e3',1),(7,'White.Trắng xanh','#81ecec',1),(8,'Hoa kẻ trắng gà','#ffaaad',1),(9,'Pattern.Cam/Orange.Cam','#e67e22',1),(10,'Kẻ Caro.Đen/Black.Đen/Trắng','#312f2e',1),(11,'Kẻ Caro.Vàng/White.Trắng','#ffe200',1),(12,'Kẻ Caro.Be/Beige.Be','#dff17b',1),(13,'Caro Cam/Nâu/Đen','#b6003b',1),(14,'Solid Trắng/White.Trắng','#f5f6fa',1),(15,'Solid Tím/Purple.Tím','#9b59b6',1),(16,'Solid Xanh lá cây/Green.Xanh lá','#2ecc71',1),(17,'Solid Hồng/Pink.Hồng','#ED4C67',1),(18,'Xanh bơ','#78e08f',1),(19,'Melange.Xám/Grey.Tàn ','#596275',1),(20,'Kẻ sọc/Kẻ ngang.Đen/Black.Đen/Trắng','#596275',1),(21,'Kẻ caro ghi','#3c6382',1),(22,'Kẻ caro.Vàng/Yellow + Gold.Vàng','#fff200',1),(23,'Kẻ caro.Nâu/Brown.Nâu','#e15f41',1),(24,'Kẻ caro.Xanh lá cây/Green.Xanh lá','#2ecc71',0),(27,'Màu mới 1','#17eea6',1),(28,'Màu mới 2','#f01919',1),(29,'Màu sắc 3','#0ecd7a',1),(30,'Màu sắc 4','#df8430',1);
/*!40000 ALTER TABLE `mau_sac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `san_pham`
--

DROP TABLE IF EXISTS `san_pham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `san_pham` (
  `id_san_pham` int NOT NULL AUTO_INCREMENT,
  `id_danh_muc` int DEFAULT NULL,
  `ten_san_pham` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gia_san_pham` int DEFAULT NULL,
  `id_khuyen_mai` int DEFAULT NULL,
  `gioi_tinh` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `mo_ta_san_pham` text CHARACTER SET utf8 COLLATE utf8_bin,
  `ngay_nhap` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_san_pham`),
  KEY `fk_san_pham_1_idx` (`id_danh_muc`),
  KEY `fk_san_pham_khuyen_mai_idx` (`id_khuyen_mai`),
  CONSTRAINT `fk_san_pham_danh_muc` FOREIGN KEY (`id_danh_muc`) REFERENCES `danh_muc` (`id_danh_muc`) ON UPDATE CASCADE,
  CONSTRAINT `fk_san_pham_khuyen_mai` FOREIGN KEY (`id_khuyen_mai`) REFERENCES `khuyen_mai` (`id_khuyen_mai`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `san_pham`
--

LOCK TABLES `san_pham` WRITE;
/*!40000 ALTER TABLE `san_pham` DISABLE KEYS */;
INSERT INTO `san_pham` VALUES (1,1,'ÁO PHÔNG Marvel S21 BOOZilla UN',399000,NULL,'Nam','Là item không thể thiếu trong tủ đồ vì sự thoải mái, dễ chịu, lại rất dễ phối đồ.\nÁo thun unisex thích hợp với cả nam và nữ. Mặc làm áo thun cặp, áo nhóm rất phù hợp.\nSản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\nForm áo cơ bản, vừa vặn cơ thể, thoải mái theo từng cử động.\nKhông ra màu, không bai, không xù, không bám dính\nHọa tiết được in lên trước ngực áo, có độ bền cao.','14/01/2021',1),(2,1,'Áo Tee Mickey Go SG UN BZL',599000,NULL,'Nam','Áo thun dành cho nam và nữ của thương hiệu BOOZilla\n- Dáng áo rộng cùng chất cotton thoáng mát, thấm hút mồ hôi tốt\n- Hình in logo Mickey nhỏ trước ngực. Phía sau lưng là hình ảnh đường phố Sài Gòn nằm trong hình ảnh chú chuột Mickey\n- Size mẫu mặc: M\n- Số đo mẫu: 179cm, 69kg.','14/01/2021',1),(3,2,'ÁO BA LỖ NAM LOOSE TIE DYE\n',349000,NULL,'Nam','Áo ba lỗ nam với chất liệu cotton thấm hút mồ hôi tốt\n- Dáng áo Loose mang lại sự thoải mái cho người mặc\n- Chất vải tie - dye đã được xử lý màu, cũng như độ co dãn\n- Size mẫu mặc: L\n- Số đo mẫu: 185cm, 69kg.','14/01/2021',1),(4,2,'ÁO BA LỖ NỮ CROP 2 DÂY HỌA TIẾT',299000,NULL,'Nữ','• Chắc chắn bạn sẽ cảm thấy rất tiếc nuối nếu chưa kịp cập nhật mẫu áo hai dây crop-top vào tủ đồ của mình khi mùa hè sắp đi qua. Vừa cá tính lại siêu cuốn hút nên sẽ không có lý do nào để bạn thờ ơ trước kiểu áo hai dây này.\n• Nếu muốn có một outfit thật bắt mắt khi xuống phố thì bạn đừng ngần ngại chọn ngay một chiếc áo hai dây crop-top để mix với quần ống rộng, quần jeans hay với quần jogger nhé. Và còn gì tuyệt hơn khi vừa có một set đồ “chất như nước cất” lại có thể khoe khéo được vòng eo thon gọn của mình.\n• Một set đồ sẽ không thể hoàn hảo khi thiếu vắng những món phụ kiện. Vì thế, bạn đừng quên chọn cho mình một đôi sandal, giày sneaker khi diện áo hai dây crop-top.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Không ra màu, không bai, không xù, không bám dính','14/01/2021',1),(5,3,'ÁO SƠ MI NAM LOOSE CỔ CUBA',499000,NULL,'Nam','• Áo sơ mi cổ vest hiện nay đang trở thành xu thế thịnh hành được các chàng trai trẻ trung, hiện đại yêu thích nhất.\n• Chúng không những khiến người mặc trở nên lịch lãm mà còn trẻ trung và cá tính. Có thể kết hợp những chiếc áo này phù hợp với rất nhiều phụ kiện thời trang khác tạo nên sự đa dạng phong cách , chính vì vậy mà chúng được cánh mày râu rất yêu thích.\n• Chiếc áo sơ mi cổ vest họa tiết luôn tạo ra sự ấn tượng và thú vị riêng của mình, khi bạn kết hợp chúng với một chiếc quần jean sẽ “lột xác” thành một chàng trai cá tính, trẻ trung.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Không ra màu, không bai, không xù, không bám dính','14/01/2021',1),(6,3,'Shirt- Sơ mi FE STU Loose kèm túi',549000,NULL,'Nữ','Set áo sơ mi nữ kèm túi, áo tay lửng dáng loose cổ vuông tay bồng, khâu nhúm lưng.\n- Chất liệu: cotton tự nhiên.\n- Số đo mẫu: 46kg, 87 - 64 - 88 - 160 (cm)\n- Size mẫu mặc: M','14/01/2021',1),(7,11,'VÁY NỮ A-LINE 1 HÀNG KHUY',499000,NULL,'Nữ','Váy yếm nữ dáng A-line phối hàng khuy lệch.\n- Chất liệu: cotton tự nhiên\n- Size mẫu mặc: M\n- Số đo mẫu: Cao 162cm - Nặng 46kg - 3 vòng: 80cm, 62cm, 85cm','14/01/2021',1),(8,1,'Áo Tee Oversized Marvel BZL',499000,NULL,'Nam','Áo thun dành cho nam và nữ của thương hiệu BOOZilla\n- Dáng áo rộng, chất vải cotton thấm hút mồ hôi tốt\n- Hình in logo Marvel trước ngực\n- Size mẫu mặc: M\n- Số đo mẫu: 178cm, 69kg.','14/01/2021',1),(9,1,'ÁO PHÔNG NỮ LOOSE IN',299000,NULL,'Nữ','• Là item không thể thiếu trong tủ đồ vì sự thoải mái, dễ chịu, lại rất dễ phối đồ.\n• Áo thun form rộng có thể phối nhiều item khác nhau (demim, flannel, short, jogger.....) mang tới phong cách năng động, cá tính cho người mặc.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Không ra màu, không bai, không xù, không bám dính\n• Họa tiết graphic được in lên áo, có độ bền cao.\n- Chất liệu: Cotton\n- Size mẫu mặc: S\n- Số đo mẫu: 163cm, 46kg.','14/01/2021',1),(10,1,'ÁO PHÔNG Mickey Tết BOOZilla',599000,NULL,'Nữ','• Là một trong những item đang được yêu thích nhất trong giới trẻ hiện nay. Áo được thiết kế kiểu dáng rộng rãi, thích hợp cho cả nam và nữ.\n• Áo thun unisex form rộng có thể phối nhiều item khác nhau (demim, flannel, short, jogger.....) mang tới phong cách năng động, cá tính cho người mặc.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Không ra màu, không bai, không xù, không bám dính\n• Họa tiết được in lên trước ngực áo, có độ bền cao.','14/01/2021',1),(11,2,'Sleeveless- Áo FE STU Loose Mickey Layer',349000,NULL,'Nữ','Áo ba lỗ nữ dáng oversize phối 2 lớp, thêu graphic đầu Mickey.\n- Chất liệu: 100% cotton tự nhiên\n- Size mẫu mặc: M \n- Số đo mẫu: 164cm, 42kg, ngực 72cm - eo 56cm - hông 88cm.','14/01/2021',1),(12,2,'ÁO BA LỖ NỮ CROP 2 DÂY GIÓ',299000,NULL,'Nữ','• Chắc chắn bạn sẽ cảm thấy rất tiếc nuối nếu chưa kịp cập nhật mẫu áo hai dây crop-top vào tủ đồ của mình khi mùa hè sắp đi qua. Vừa cá tính lại siêu cuốn hút nên sẽ không có lý do nào để bạn thờ ơ trước kiểu áo hai dây này.\n• Nếu muốn có một outfit thật bắt mắt khi xuống phố thì bạn đừng ngần ngại chọn ngay một chiếc áo hai dây crop-top để mix với quần ống rộng, quần jeans hay với quần jogger nhé. Và còn gì tuyệt hơn khi vừa có một set đồ “chất như nước cất” lại có thể khoe khéo được vòng eo thon gọn của mình.\n• Một set đồ sẽ không thể hoàn hảo khi thiếu vắng những món phụ kiện. Vì thế, bạn đừng quên chọn cho mình một đôi sandal, giày sneaker khi diện áo hai dây crop-top.\n• Không ra màu, không bai, không xù, không bám dính','14/01/2021',1),(13,2,'ÁO BA LỖ NỮ CROP FIT BASIC',199000,NULL,'Nữ','• Chắc chắn bạn sẽ cảm thấy rất tiếc nuối nếu chưa kịp cập nhật mẫu áo ba lỗ dáng crop-top vào tủ đồ của mình khi mùa hè sắp đi qua. Vừa cá tính lại siêu cuốn hút nên sẽ không có lý do nào để bạn thờ ơ trước kiểu áo ba lỗ này.\n• Nếu muốn có một outfit thật bắt mắt khi xuống phố thì bạn đừng ngần ngại chọn ngay một chiếc áo ba lỗ dáng crop-top để mix với quần ống rộng, quần jeans hay với quần jogger nhé. Và còn gì tuyệt hơn khi vừa có một set đồ “chất như nước cất” lại có thể khoe khéo được vòng eo thon gọn của mình.\n• Một set đồ sẽ không thể hoàn hảo khi thiếu vắng những món phụ kiện. Vì thế, bạn đừng quên chọn cho mình một đôi sandal, giày sneaker khi diện áo ba lỗ dáng crop-top.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Không ra màu, không bai, không xù, không bám dính','14/01/2021',1),(14,13,'CHÂN VÁY NỮ MIDI CẠP CHUN',499000,NULL,'Nữ','• Nghe tên thì có vẻ khó hình dung, nhưng thật ra đây là chân váy được các bạn nữ rất ưa chuộng. Chân váy kiểu midi là tên gọi của những mẫu chân váy có chiều dài đến giữa bắp chân hoặc dài hơn.\n• Bạn không cần phải sở hữu vòng eo con kiến hay đôi chân dài miên mang thì mới phù hợp mặc thiết kế midi. Đây là chân váy dành cho đại đa số bạn gái, do đó chỉ cần nắm vững những nguyên tắc mix đồ thì ai cũng có thể xinh đẹp và toả sáng.\n• Đối với những bạn nữ có thân hình hơi gầy, bạn có thể thử phối váy midi cùng áo hai dây để giúp cơ thể trông đầy đặn và hài hòa hơn. Đặc biệt bạn nên chọn áo hai dây có màu sáng, như vậy nhìn bạn sẽ xinh xắn và quyến rũ hơn.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Chất liệu vải mềm mịn, không nhăn, không xù lông, giữ dáng, không phai màu.','14/01/2021',1),(15,13,'CHÂN VÁY NỮ A-LINE CHỐT SẬP',499000,NULL,'Nữ','• Nói đến chân váy chữ A chắc các nàng ai cũng phải sở hữu ít nhất một chiếc trong tủ đồ của mình rồi. Chân váy thì có phần eo ôm sát và phần dưới xòe ra vừa giúp nàng khoe được đường cong của mình. Che được khuyết điểm ở đôi chân, lại vừa tạo nên sự thoải mái, dễ chịu.\n• Dù bạn là người có chiều cao khiêm tốn hay vòng eo không chuẩn thì cũng không hề cảm thấy e ngại, vì chân váy ngắn không kén người mặc. Chỉ cần tinh ý một chút thôi là bạn đã có ngay một bộ đồ thời trang, thu hút được mọi ánh nhìn xung quanh rồi.\n• Không chỉ áo phông, áo T-shirt hay crop top mới phù hợp với chân váy xếp ly ngắn, áo sơ mi cũng là một ý tưởng mix đồ được nhiều người lựa chọn. Đây là sự kết hợp kín đáo nhưng vẫn mang tới sự trẻ trung, và cá tính mạnh mẽ cho người mặc.\n• Chất liệu vải mềm mịn, không nhăn, không xù lông, giữ dáng, không phai màu.','14/01/2021',1),(16,13,'CHÂN VÁY NỮ A-LINE PLEATED',399000,NULL,'Nữ','• Váy kẻ caro dáng chữ A đang và vẫn sẽ là xu hướng thống trị thời trang trong thời gian sắp tới, lựa chọn những mẫu váy caro chữ A sẽ giúp bạn mới mẻ, trẻ trung và dịu dàng hơn bao giờ hết.\n• Mẫu chân váy caro chữ A sẽ giúp đôi chân của các nàng được kéo dài ra đáng kể, tuy nhiên nàng nhớ rằng để chúng có thể phát huy được khả năng “hack dáng” của mình thì bạn đừng quên nguyên tắc sơ vin gọn gàng.\n• Ngoài ra, chân váy xếp ly caro dáng chữ A cũng sẽ rất phù hợp, bạn nên chọn mẫu chân váy có màu sắc nổi bật để diện cùng áo thun đơn giản, đi cùng giày sneaker và đôi tất lửng sẽ vô cùng đáng yêu, kiểu dáng này lại càng phù hợp với các cô nàng nấm lùn.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Chất liệu vải mềm mịn, không nhăn, không xù lông, giữ dáng, không phai màu.','14/01/2021',1);
/*!40000 ALTER TABLE `san_pham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'Project_1'
--

--
-- Dumping routines for database 'Project_1'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-09 14:53:25
