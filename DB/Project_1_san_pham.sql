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
  `gioi_tinh` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `mo_ta_san_pham` text COLLATE utf8_bin,
  `ngay_nhap` varchar(20) COLLATE utf8_bin DEFAULT NULL,
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
INSERT INTO `san_pham` VALUES (1,1,'ÁO PHÔNG Marvel S21 BOOZilla UN',399000,NULL,'Nam','Là item không thể thiếu trong tủ đồ vì sự thoải mái, dễ chịu, lại rất dễ phối đồ.\nÁo thun unisex thích hợp với cả nam và nữ. Mặc làm áo thun cặp, áo nhóm rất phù hợp.\nSản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\nForm áo cơ bản, vừa vặn cơ thể, thoải mái theo từng cử động.\nKhông ra màu, không bai, không xù, không bám dính\nHọa tiết được in lên trước ngực áo, có độ bền cao.',NULL,1),(2,1,'Áo Tee Mickey Go SG UN BZL',599000,NULL,'Nam','Áo thun dành cho nam và nữ của thương hiệu BOOZilla\n- Dáng áo rộng cùng chất cotton thoáng mát, thấm hút mồ hôi tốt\n- Hình in logo Mickey nhỏ trước ngực. Phía sau lưng là hình ảnh đường phố Sài Gòn nằm trong hình ảnh chú chuột Mickey\n- Size mẫu mặc: M\n- Số đo mẫu: 179cm, 69kg.',NULL,1),(3,2,'ÁO BA LỖ NAM LOOSE TIE DYE\n',349000,NULL,'Nam','Áo ba lỗ nam với chất liệu cotton thấm hút mồ hôi tốt\n- Dáng áo Loose mang lại sự thoải mái cho người mặc\n- Chất vải tie - dye đã được xử lý màu, cũng như độ co dãn\n- Size mẫu mặc: L\n- Số đo mẫu: 185cm, 69kg.',NULL,1),(4,2,'ÁO BA LỖ NỮ CROP 2 DÂY HỌA TIẾT',299000,NULL,'Nữ','• Chắc chắn bạn sẽ cảm thấy rất tiếc nuối nếu chưa kịp cập nhật mẫu áo hai dây crop-top vào tủ đồ của mình khi mùa hè sắp đi qua. Vừa cá tính lại siêu cuốn hút nên sẽ không có lý do nào để bạn thờ ơ trước kiểu áo hai dây này.\n• Nếu muốn có một outfit thật bắt mắt khi xuống phố thì bạn đừng ngần ngại chọn ngay một chiếc áo hai dây crop-top để mix với quần ống rộng, quần jeans hay với quần jogger nhé. Và còn gì tuyệt hơn khi vừa có một set đồ “chất như nước cất” lại có thể khoe khéo được vòng eo thon gọn của mình.\n• Một set đồ sẽ không thể hoàn hảo khi thiếu vắng những món phụ kiện. Vì thế, bạn đừng quên chọn cho mình một đôi sandal, giày sneaker khi diện áo hai dây crop-top.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Không ra màu, không bai, không xù, không bám dính',NULL,1),(5,3,'ÁO SƠ MI NAM LOOSE CỔ CUBA',499000,NULL,'Nam','• Áo sơ mi cổ vest hiện nay đang trở thành xu thế thịnh hành được các chàng trai trẻ trung, hiện đại yêu thích nhất.\n• Chúng không những khiến người mặc trở nên lịch lãm mà còn trẻ trung và cá tính. Có thể kết hợp những chiếc áo này phù hợp với rất nhiều phụ kiện thời trang khác tạo nên sự đa dạng phong cách , chính vì vậy mà chúng được cánh mày râu rất yêu thích.\n• Chiếc áo sơ mi cổ vest họa tiết luôn tạo ra sự ấn tượng và thú vị riêng của mình, khi bạn kết hợp chúng với một chiếc quần jean sẽ “lột xác” thành một chàng trai cá tính, trẻ trung.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Không ra màu, không bai, không xù, không bám dính',NULL,1),(6,3,'Shirt- Sơ mi FE STU Loose kèm túi',549000,NULL,'Nữ','Set áo sơ mi nữ kèm túi, áo tay lửng dáng loose cổ vuông tay bồng, khâu nhúm lưng.\n- Chất liệu: cotton tự nhiên.\n- Số đo mẫu: 46kg, 87 - 64 - 88 - 160 (cm)\n- Size mẫu mặc: M',NULL,1),(7,11,'VÁY NỮ A-LINE 1 HÀNG KHUY',499000,NULL,'Nữ','Váy yếm nữ dáng A-line phối hàng khuy lệch.\n- Chất liệu: cotton tự nhiên\n- Size mẫu mặc: M\n- Số đo mẫu: Cao 162cm - Nặng 46kg - 3 vòng: 80cm, 62cm, 85cm',NULL,1),(8,1,'Áo Tee Oversized Marvel BZL',499000,NULL,'Nam','Áo thun dành cho nam và nữ của thương hiệu BOOZilla\n- Dáng áo rộng, chất vải cotton thấm hút mồ hôi tốt\n- Hình in logo Marvel trước ngực\n- Size mẫu mặc: M\n- Số đo mẫu: 178cm, 69kg.',NULL,1),(9,1,'ÁO PHÔNG NỮ LOOSE IN',299000,NULL,'Nữ','• Là item không thể thiếu trong tủ đồ vì sự thoải mái, dễ chịu, lại rất dễ phối đồ.\n• Áo thun form rộng có thể phối nhiều item khác nhau (demim, flannel, short, jogger.....) mang tới phong cách năng động, cá tính cho người mặc.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Không ra màu, không bai, không xù, không bám dính\n• Họa tiết graphic được in lên áo, có độ bền cao.\n- Chất liệu: Cotton\n- Size mẫu mặc: S\n- Số đo mẫu: 163cm, 46kg.',NULL,1),(10,1,'ÁO PHÔNG Mickey Tết BOOZilla',599000,NULL,'Nữ','• Là một trong những item đang được yêu thích nhất trong giới trẻ hiện nay. Áo được thiết kế kiểu dáng rộng rãi, thích hợp cho cả nam và nữ.\n• Áo thun unisex form rộng có thể phối nhiều item khác nhau (demim, flannel, short, jogger.....) mang tới phong cách năng động, cá tính cho người mặc.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Không ra màu, không bai, không xù, không bám dính\n• Họa tiết được in lên trước ngực áo, có độ bền cao.',NULL,1),(11,2,'Sleeveless- Áo FE STU Loose Mickey Layer',349000,NULL,'Nữ','Áo ba lỗ nữ dáng oversize phối 2 lớp, thêu graphic đầu Mickey.\n- Chất liệu: 100% cotton tự nhiên\n- Size mẫu mặc: M \n- Số đo mẫu: 164cm, 42kg, ngực 72cm - eo 56cm - hông 88cm.',NULL,1),(12,2,'ÁO BA LỖ NỮ CROP 2 DÂY GIÓ',299000,NULL,'Nữ','• Chắc chắn bạn sẽ cảm thấy rất tiếc nuối nếu chưa kịp cập nhật mẫu áo hai dây crop-top vào tủ đồ của mình khi mùa hè sắp đi qua. Vừa cá tính lại siêu cuốn hút nên sẽ không có lý do nào để bạn thờ ơ trước kiểu áo hai dây này.\n• Nếu muốn có một outfit thật bắt mắt khi xuống phố thì bạn đừng ngần ngại chọn ngay một chiếc áo hai dây crop-top để mix với quần ống rộng, quần jeans hay với quần jogger nhé. Và còn gì tuyệt hơn khi vừa có một set đồ “chất như nước cất” lại có thể khoe khéo được vòng eo thon gọn của mình.\n• Một set đồ sẽ không thể hoàn hảo khi thiếu vắng những món phụ kiện. Vì thế, bạn đừng quên chọn cho mình một đôi sandal, giày sneaker khi diện áo hai dây crop-top.\n• Không ra màu, không bai, không xù, không bám dính',NULL,1),(13,2,'ÁO BA LỖ NỮ CROP FIT BASIC',199000,NULL,'Nữ','• Chắc chắn bạn sẽ cảm thấy rất tiếc nuối nếu chưa kịp cập nhật mẫu áo ba lỗ dáng crop-top vào tủ đồ của mình khi mùa hè sắp đi qua. Vừa cá tính lại siêu cuốn hút nên sẽ không có lý do nào để bạn thờ ơ trước kiểu áo ba lỗ này.\n• Nếu muốn có một outfit thật bắt mắt khi xuống phố thì bạn đừng ngần ngại chọn ngay một chiếc áo ba lỗ dáng crop-top để mix với quần ống rộng, quần jeans hay với quần jogger nhé. Và còn gì tuyệt hơn khi vừa có một set đồ “chất như nước cất” lại có thể khoe khéo được vòng eo thon gọn của mình.\n• Một set đồ sẽ không thể hoàn hảo khi thiếu vắng những món phụ kiện. Vì thế, bạn đừng quên chọn cho mình một đôi sandal, giày sneaker khi diện áo ba lỗ dáng crop-top.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Không ra màu, không bai, không xù, không bám dính',NULL,1),(14,13,'CHÂN VÁY NỮ MIDI CẠP CHUN',499000,NULL,'Nữ','• Nghe tên thì có vẻ khó hình dung, nhưng thật ra đây là chân váy được các bạn nữ rất ưa chuộng. Chân váy kiểu midi là tên gọi của những mẫu chân váy có chiều dài đến giữa bắp chân hoặc dài hơn.\n• Bạn không cần phải sở hữu vòng eo con kiến hay đôi chân dài miên mang thì mới phù hợp mặc thiết kế midi. Đây là chân váy dành cho đại đa số bạn gái, do đó chỉ cần nắm vững những nguyên tắc mix đồ thì ai cũng có thể xinh đẹp và toả sáng.\n• Đối với những bạn nữ có thân hình hơi gầy, bạn có thể thử phối váy midi cùng áo hai dây để giúp cơ thể trông đầy đặn và hài hòa hơn. Đặc biệt bạn nên chọn áo hai dây có màu sáng, như vậy nhìn bạn sẽ xinh xắn và quyến rũ hơn.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Chất liệu vải mềm mịn, không nhăn, không xù lông, giữ dáng, không phai màu.',NULL,1),(15,13,'CHÂN VÁY NỮ A-LINE CHỐT SẬP',499000,NULL,'Nữ','• Nói đến chân váy chữ A chắc các nàng ai cũng phải sở hữu ít nhất một chiếc trong tủ đồ của mình rồi. Chân váy thì có phần eo ôm sát và phần dưới xòe ra vừa giúp nàng khoe được đường cong của mình. Che được khuyết điểm ở đôi chân, lại vừa tạo nên sự thoải mái, dễ chịu.\n• Dù bạn là người có chiều cao khiêm tốn hay vòng eo không chuẩn thì cũng không hề cảm thấy e ngại, vì chân váy ngắn không kén người mặc. Chỉ cần tinh ý một chút thôi là bạn đã có ngay một bộ đồ thời trang, thu hút được mọi ánh nhìn xung quanh rồi.\n• Không chỉ áo phông, áo T-shirt hay crop top mới phù hợp với chân váy xếp ly ngắn, áo sơ mi cũng là một ý tưởng mix đồ được nhiều người lựa chọn. Đây là sự kết hợp kín đáo nhưng vẫn mang tới sự trẻ trung, và cá tính mạnh mẽ cho người mặc.\n• Chất liệu vải mềm mịn, không nhăn, không xù lông, giữ dáng, không phai màu.',NULL,1),(16,13,'CHÂN VÁY NỮ A-LINE PLEATED',399000,NULL,'Nữ','• Váy kẻ caro dáng chữ A đang và vẫn sẽ là xu hướng thống trị thời trang trong thời gian sắp tới, lựa chọn những mẫu váy caro chữ A sẽ giúp bạn mới mẻ, trẻ trung và dịu dàng hơn bao giờ hết.\n• Mẫu chân váy caro chữ A sẽ giúp đôi chân của các nàng được kéo dài ra đáng kể, tuy nhiên nàng nhớ rằng để chúng có thể phát huy được khả năng “hack dáng” của mình thì bạn đừng quên nguyên tắc sơ vin gọn gàng.\n• Ngoài ra, chân váy xếp ly caro dáng chữ A cũng sẽ rất phù hợp, bạn nên chọn mẫu chân váy có màu sắc nổi bật để diện cùng áo thun đơn giản, đi cùng giày sneaker và đôi tất lửng sẽ vô cùng đáng yêu, kiểu dáng này lại càng phù hợp với các cô nàng nấm lùn.\n• Sản phẩm 100% cotton, đường may tinh tế chắc chắn với bề mặt vải mềm mại, thấm hút mồ hôi tốt tạo cảm giác thoáng mát cho người mặc.\n• Chất liệu vải mềm mịn, không nhăn, không xù lông, giữ dáng, không phai màu.',NULL,1);
/*!40000 ALTER TABLE `san_pham` ENABLE KEYS */;
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
