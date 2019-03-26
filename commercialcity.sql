-- MySQL dump 10.13  Distrib 5.1.62, for Win64 (unknown)
--
-- Host: localhost    Database: commercialcity
-- ------------------------------------------------------
-- Server version	5.1.62-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `browserhistory`
--

DROP TABLE IF EXISTS `browserhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `browserhistory` (
  `customerId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`customerId`,`productId`,`time`),
  KEY `productId` (`productId`),
  CONSTRAINT `browserhistory_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`),
  CONSTRAINT `browserhistory_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `browserhistory`
--

LOCK TABLES `browserhistory` WRITE;
/*!40000 ALTER TABLE `browserhistory` DISABLE KEYS */;
INSERT INTO `browserhistory` VALUES (6,88,'2017-06-12 13:59:23'),(6,88,'2017-06-12 15:12:59'),(8,88,'2017-06-12 02:18:28'),(6,89,'2017-06-12 10:52:06'),(6,89,'2017-06-12 14:01:04'),(6,89,'2017-06-12 14:02:16'),(6,89,'2017-06-12 14:18:21'),(6,89,'2017-06-12 15:12:53'),(8,89,'2017-06-12 02:23:10'),(6,91,'2017-06-12 14:02:33'),(6,91,'2017-06-12 14:23:37'),(7,91,'2017-06-12 15:23:09'),(7,91,'2017-06-12 15:24:27'),(6,92,'2017-06-12 14:02:45'),(6,92,'2017-06-12 14:05:48'),(6,92,'2017-06-12 14:32:25'),(6,92,'2017-06-12 15:13:19'),(6,94,'2017-06-12 15:04:28'),(7,94,'2017-06-12 15:25:26'),(6,95,'2017-06-12 14:06:15'),(6,96,'2017-06-12 14:01:35'),(6,98,'2017-06-12 15:04:48'),(7,98,'2017-06-12 15:25:22'),(6,99,'2017-06-12 10:47:58'),(6,99,'2017-06-12 10:50:24'),(6,99,'2017-06-12 10:51:25'),(6,99,'2017-06-12 10:56:31'),(6,99,'2017-06-12 14:11:22'),(6,99,'2017-06-12 14:34:10'),(6,100,'2017-06-12 14:00:51'),(6,100,'2017-06-12 15:05:34'),(8,100,'2017-06-12 03:00:30'),(6,101,'2017-06-12 10:56:13'),(6,102,'2017-06-12 10:55:46'),(6,103,'2017-06-12 10:58:44'),(6,103,'2017-06-12 11:00:33'),(6,103,'2017-06-12 11:42:22'),(6,104,'2017-06-12 11:00:41'),(6,104,'2017-06-12 11:09:13'),(6,104,'2017-06-12 11:09:32'),(6,115,'2017-06-12 14:00:58'),(6,117,'2017-06-12 11:48:23'),(6,117,'2017-06-12 11:50:18'),(6,118,'2017-06-12 11:51:51'),(6,129,'2017-06-12 15:21:50'),(6,133,'2017-06-12 15:13:37'),(6,136,'2017-06-12 15:16:16'),(6,138,'2017-06-12 14:47:39'),(6,138,'2017-06-12 15:00:03'),(6,139,'2017-06-12 14:52:25'),(6,140,'2017-06-12 14:55:51'),(6,140,'2017-06-12 14:57:11'),(6,147,'2017-06-12 14:13:37'),(6,150,'2017-06-12 15:16:00'),(6,153,'2017-06-12 14:14:55'),(6,153,'2017-06-12 14:16:58'),(7,153,'2017-06-12 15:25:37'),(6,157,'2017-06-12 15:21:29'),(7,157,'2017-06-12 15:25:16');
/*!40000 ALTER TABLE `browserhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `customerId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `orderId` int(11) NOT NULL,
  `commentContent` varchar(200) NOT NULL,
  `commentTime` datetime NOT NULL,
  `goodrate` int(11) NOT NULL,
  PRIMARY KEY (`customerId`,`productId`,`commentTime`),
  KEY `productId` (`productId`),
  KEY `orderId` (`orderId`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`),
  CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`orderId`) REFERENCES `ordermaster` (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (6,92,7,'黄宁好笨','2017-06-12 15:12:37',2),(6,138,9,'黄宁好黑','2017-06-12 15:12:28',2),(6,139,10,'黄宁好傻','2017-06-12 15:12:22',2),(6,153,3,'真的太好看了  卖家太帅了  我要给他生猴子','2017-06-12 14:16:21',5),(6,153,4,'taihaole ','2017-06-12 14:17:21',5);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditcard` (
  `creditCardId` int(11) NOT NULL AUTO_INCREMENT,
  `creditAccount` varchar(10) NOT NULL,
  `creditPassword` varchar(10) NOT NULL,
  `money` double NOT NULL,
  PRIMARY KEY (`creditCardId`),
  UNIQUE KEY `creditAccount` (`creditAccount`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard`
--

LOCK TABLES `creditcard` WRITE;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
INSERT INTO `creditcard` VALUES (14,'1234567890','1234567890',99173),(15,'1234567891','1234567891',13695),(16,'1234567892','1234567892',18995),(17,'1234567893','1234567893',29075),(18,'1234567894','1234567894',48780),(19,'1234567895','1234567895',38995),(20,'1234567896','1234567896',36917),(21,'1234567897','1234567897',89495),(22,'1234567898','1234567898',89495),(23,'1234567899','1234567899',32289.3);
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `creditCardId` int(11) NOT NULL,
  `customerName` varchar(24) NOT NULL,
  `customerSex` enum('男','女') DEFAULT NULL,
  `customerAccount` varchar(14) NOT NULL,
  `customerPassword` varchar(14) NOT NULL,
  `customerMail` varchar(25) NOT NULL,
  `displayPicture` varchar(100) NOT NULL,
  PRIMARY KEY (`customerId`),
  KEY `creditCardId` (`creditCardId`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`creditCardId`) REFERENCES `creditcard` (`creditCardId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (6,14,'林拱','男','987654321','987654321','441299124@qq.com','/CommercialCity/commercialcity/agofqyqgnjogpcfcahna.jpg'),(7,18,'林冻','男','987654322','987654322','21541851@qq.com','/CommercialCity/commercialcity/customer.jpg'),(8,19,'买书的那位同学','男','987654323','987654323','761439434@qq.com','/CommercialCity/commercialcity/customer.jpg');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliveryaddress`
--

DROP TABLE IF EXISTS `deliveryaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliveryaddress` (
  `deliveryAddressId` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL,
  `receiverName` varchar(15) NOT NULL,
  `receiverTelephone` varchar(11) NOT NULL,
  `receiverAddressFirst` varchar(10) NOT NULL,
  `receiverAddressSecond` varchar(10) NOT NULL,
  `receiverAddressThird` varchar(10) NOT NULL,
  `receiverAddressDetail` varchar(50) NOT NULL,
  PRIMARY KEY (`deliveryAddressId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliveryaddress`
--

LOCK TABLES `deliveryaddress` WRITE;
/*!40000 ALTER TABLE `deliveryaddress` DISABLE KEYS */;
INSERT INTO `deliveryaddress` VALUES (1,6,'林拱','13774588352','35','3501','350105','琅岐镇海边'),(2,6,'林小拱','13774588352','35','3501','350105','一个美丽的海岛上'),(3,7,'林栋栋','12345678901','35','3505','350524','我也不知道哪里');
/*!40000 ALTER TABLE `deliveryaddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdetail` (
  `orderId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`orderId`,`productId`),
  KEY `productId` (`productId`),
  CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `ordermaster` (`orderId`),
  CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES (1,88,1),(2,89,10),(2,91,9),(2,96,5),(2,115,1),(3,153,13),(4,153,1),(5,89,1),(6,91,1),(7,92,1),(8,99,1),(9,138,1),(10,139,1),(11,140,1),(12,94,2),(13,98,2),(14,150,3),(15,136,3),(16,157,5),(17,129,4),(18,91,3),(19,94,3),(20,153,2);
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordermaster`
--

DROP TABLE IF EXISTS `ordermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordermaster` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL,
  `deliveryAddressId` int(11) NOT NULL,
  `orderMasterTime` datetime NOT NULL,
  `orderMasterStatus` varchar(10) NOT NULL,
  PRIMARY KEY (`orderId`),
  KEY `customerId` (`customerId`),
  KEY `deliveryAddressId` (`deliveryAddressId`),
  CONSTRAINT `ordermaster_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordermaster`
--

LOCK TABLES `ordermaster` WRITE;
/*!40000 ALTER TABLE `ordermaster` DISABLE KEYS */;
INSERT INTO `ordermaster` VALUES (1,6,1,'2017-06-12 13:59:57','待发货'),(2,6,1,'2017-06-12 14:12:30','待发货'),(3,6,1,'2017-06-12 14:16:21','订单完成'),(4,6,1,'2017-06-12 14:17:21','订单完成'),(5,6,1,'2017-06-12 15:12:03','待评价'),(6,6,1,'2017-06-12 15:12:04','待评价'),(7,6,1,'2017-06-12 15:12:37','订单完成'),(8,6,1,'2017-06-12 15:10:23','待收货'),(9,6,1,'2017-06-12 15:12:28','订单完成'),(10,6,1,'2017-06-12 15:12:22','订单完成'),(11,6,1,'2017-06-12 15:11:35','待收货'),(12,6,1,'2017-06-12 15:11:34','待收货'),(13,6,1,'2017-06-12 15:04:52','待付款'),(14,6,1,'2017-06-12 15:16:09','待发货'),(15,6,1,'2017-06-12 15:16:26','待发货'),(16,6,2,'2017-06-12 15:21:39','待发货'),(17,6,1,'2017-06-12 15:21:59','待发货'),(18,7,3,'2017-06-12 15:25:04','待发货'),(19,7,3,'2017-06-12 15:25:30','待付款'),(20,7,3,'2017-06-12 15:25:46','待发货');
/*!40000 ALTER TABLE `ordermaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `shopId` int(11) NOT NULL,
  `productName` varchar(40) NOT NULL,
  `productIntroduction` varchar(200) NOT NULL,
  `productSale` double NOT NULL,
  `productStock` int(11) NOT NULL,
  `productClass` varchar(30) NOT NULL,
  `productShowPicture` varchar(140) NOT NULL,
  `productAttribute` varchar(400) NOT NULL,
  `writer` varchar(40) NOT NULL,
  `publishingHouse` varchar(40) NOT NULL,
  `shelfTime` datetime NOT NULL,
  `productIntroductionPictureOne` varchar(100) NOT NULL,
  `productIntroductionPictureTwo` varchar(100) NOT NULL,
  `productIntroductionPictureThree` varchar(100) NOT NULL,
  PRIMARY KEY (`productId`),
  KEY `shopId` (`shopId`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`shopId`) REFERENCES `shop` (`shopId`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (88,21,'狼图腾','《狼图腾》由几十个有机连贯的“狼故事”一气呵成，情节紧张激烈而又新奇神秘。',32,99,'小说','/CommercialCity/commercialcity/uqfxtgxmruoopqlqrfcf.png','是否是套装: 否  出版时间: 2004年04月    作者地区: 中国大陆\n    开本: 16开   ISBN编号: 9787535427304','姜戎','长江文艺出版社','2017-06-12 02:18:24','/CommercialCity/commercialcity/csgcjcqorwvlxqnlxpvb.png','/CommercialCity/commercialcity/cfireazrqzgekttchxit.png','/CommercialCity/commercialcity/rwzjlbkwzouborripuyl.png'),(89,21,'鬼谷子','《鬼谷子》是一部集纵横家、兵家、道家、仙家、阴阳家等思想于一体的权谋理论著作。',45,110,'励志/成功','/CommercialCity/commercialcity/efnpivvowrcicajqjvai.jpg','\n 是否是套装: 是   出版时间: 2014年2月   作者地区: 中国大陆  开本: 16开  ISBN编号: 9787553441054','鬼谷子','北方文艺','2017-06-12 02:23:04','/CommercialCity/commercialcity/hyvbfcohxfvalblwedol.png','/CommercialCity/commercialcity/yxnssiwodfjpyzudibfr.png','/CommercialCity/commercialcity/jligxxddnszjesgbhltq.png'),(91,21,'挪威的森林','《挪威的森林》是一部动人心弦的、平缓舒雅的、略带感伤的、百分之百的恋爱小 说。小说主人公渡边以第一人称展开他同两个女孩间的爱情纠葛。\n',33,137,'文艺','/CommercialCity/commercialcity/jpcobyvdejwqxzfpwvjf.jpg','是否是套装: 否  出版时间: 2007年08月   作者地区: 日本   译者: 林少华  开本: 32开    ISBN编号: 9787532742929','村上春树','上海译文出版社','2017-06-12 02:26:59','/CommercialCity/commercialcity/oyvpgltxndcuzyrgszsw.png','/CommercialCity/commercialcity/bjsxntabihufgoisazed.png','/CommercialCity/commercialcity/jkfkybxlarropfofccll.png'),(92,21,'白夜行','《白夜行》讲述多年以前，大阪的一栋废弃建筑中发现一名遭利器刺死的男子。案件扑朔迷离，始终悬而未决。此后20年间，案件滋生出的恶逐渐萌芽生长，绽放出恶之花。案件相关者的人生逐渐被越来越重的阴影笼罩……',39.5,139,'青春文学/动漫-幽默','/CommercialCity/commercialcity/oqinvjgumaperzcpgenz.jpg','是否是套装: 否   出版时间: 2013年01月   作者地区: 日本  译者: 刘姿君   开本: 32开   ISBN编号: 9787544258609\n','东野圭吾','南海出版公司','2017-06-12 02:30:32','/CommercialCity/commercialcity/madabzptfaaatcbsoamf.png','/CommercialCity/commercialcity/guruknyujuoqqnmdysgn.png','/CommercialCity/commercialcity/lhtspypxppwfuosecvya.png'),(93,21,'史记','《史记》是汉朝司马迁所著，是中国两千年来最伟大的历史名著，其中有许多文学名篇。\n',120,120,'小说','/CommercialCity/commercialcity/wvjcbxrlmaaxuhqkotpz.jpg','\n 是否是套装: 是  出版时间: 2010年3月  开本: 16开  书名: 史记  ISBN编号: 9787545108453','司马迁','辽海出版社','2017-06-12 02:33:30','/CommercialCity/commercialcity/nalprucuzkwwoezdwlub.png','/CommercialCity/commercialcity/afjlkrspniehfsmrgtdo.png','/CommercialCity/commercialcity/fmvtmgjjfzoebsotajoo.png'),(94,21,'他们说，我是幸运的','《他们说，我是幸运的》是畅销书《可爱的骨头》作者的成名作，记录了她自己的真实经历。\n',25,122,'生活','/CommercialCity/commercialcity/qikxuopghydqnxhzjnjd.jpg','是否是套装: 否   出版时间: 2016年8月  开本: 32开  ISBN编号: 9787550279629\n','艾丽斯·西伯德','北京联合出版公司','2017-06-12 02:35:36','/CommercialCity/commercialcity/vlrinkrshltpzsexntny.png','/CommercialCity/commercialcity/wmhstvhiksvyvvvbgbxo.png','/CommercialCity/commercialcity/augorbegkmexfmanwmsa.png'),(95,21,'国史讲话全本','《国史讲话全本》采用小说笔法，正说历史：它是一位历史学家对死板学术体裁的背叛，是用活泼的通俗体裁撰写的一套历史“小说”。',110,87,'人文社科','/CommercialCity/commercialcity/ucmvqmgwsnrevqgbvpxe.jpg','是否是套装: 是     出版时间: 2015年7月            ISBN编号: 9787208129900','顾颉刚',' 上海人民出版社','2017-06-12 02:38:39','/CommercialCity/commercialcity/zycorlyvmbijkqhsujfe.png','/CommercialCity/commercialcity/wezxnayctwhxymizccfj.png','/CommercialCity/commercialcity/pkddrnemmpfjvgntyscp.png'),(96,21,'四大名著','四大名著是中国经典文学作品，是文学作品的顶峰。',245,43,'教育','/CommercialCity/commercialcity/drlxfmufvksnmjuxcipc.jpg','是否是套装: 是    出版时间: 2014年5月  作者地区: 中国大陆   ISBN编号: 9787552238396','吴承恩 曹雪芹 罗贯中 施耐庵','光明日报出版社','2017-06-12 02:41:16','/CommercialCity/commercialcity/smawyhbnervsolnnleye.png','/CommercialCity/commercialcity/zhygqtsmbbkvcwbwsksp.png','/CommercialCity/commercialcity/oucqtfjgucmndaixlzyf.png'),(97,21,'十万个为什么','《十万个为什么》属于儿童读物，可以更好地帮助儿童发散思维。\n',42,412,'教育','/CommercialCity/commercialcity/mmcqjcjievueqahvqfhq.jpg','年龄: 3-6周岁   是否是套装: 是   出版时间: 2016年9月  开本: 24开\n ISBN编号: 9787511021687','嘉良传媒','海豚出版社','2017-06-12 02:43:30','/CommercialCity/commercialcity/zpivnosjmkkcwdtpqmqv.png','/CommercialCity/commercialcity/ewgjtasaykyqtssuhesh.png','/CommercialCity/commercialcity/xxngyjrxvoajohbdwjpt.png'),(98,21,'好吗好的','《好吗好的》——百万销量作家大冰2016年新书。在寒冷的地方，写就暖心的、真实的、善意的、舍不得读完的江湖故事。',39,42,'文艺','/CommercialCity/commercialcity/njlvsznbirgclkjwwjqh.jpg','\n 是否是套装: 否  ISBN编号: 9787540476892','大冰','湖南文艺','2017-06-12 02:46:22','/CommercialCity/commercialcity/aqbvxgbjvaamdbrlfmro.png','/CommercialCity/commercialcity/sqgafmrefimlhlafaqon.png','/CommercialCity/commercialcity/bpvaszwuznqnzakwqliy.png'),(99,22,'活着','活着 余华经典作品原版长篇小说 民国历史 兄弟 许三观卖血记作者 中国当代文学小说畅销图书籍',20,196,'小说','/CommercialCity/commercialcity/ewukorqzonbfkwykljdh.jpg','是否是套装: 否    出版时间: 2012年08月    作者地区: 中国大陆       译者: 9787506365437    编者: 9787506365437    开本: 32开    ISBN编号: 9787506365437','余华','作家出版社','2017-06-12 02:52:24','/CommercialCity/commercialcity/ioavzwbrstpecbcprest.png','/CommercialCity/commercialcity/tewffcunlwuwazbvpqga.png','/CommercialCity/commercialcity/peqzqrkefgelbciqgvhn.png'),(100,22,'追风筝的人','风筝的人胡塞尼中文版灿烂千阳高圆圆力荐情感读物 文艺女性的动人故事',39.5,200,'小说','/CommercialCity/commercialcity/biaggsrnmemnqiyfwsxd.jpg','是否是套装: 否    作者地区: 美国    译者: 李继宏    编者: 风    开本: 32开    ISBN编号: 9787208061644','卡勒德.胡赛尼','上海人民出版社','2017-06-12 02:57:33','/CommercialCity/commercialcity/ggphizbtbxdqzsbtnnxj.png','/CommercialCity/commercialcity/nvfevdetgfdvssnacfji.png','/CommercialCity/commercialcity/uhwsanlfgxsxvxzeioqf.png'),(101,22,'围城(精)','围城(精) 钱钟书代表作 中国现代长篇文学小说 杨绛先生文集 人民文学出版社',39,200,'文艺','/CommercialCity/commercialcity/iiwmxjjmvasfejrlbwmk.jpg','是否是套装: 否    出版时间: 1991年02月    作者地区: 中国大陆    开本: 16开    ISBN编号: 9787020090006','钱钟书','人民文学出版社','2017-06-12 10:47:55','/CommercialCity/commercialcity/kavhfyioomjpjbakwcxw.png','/CommercialCity/commercialcity/sjdrioqjgykihcmtlvot.png','/CommercialCity/commercialcity/hvvmackhagbwvidujgch.png'),(102,22,'人类群星闪耀时','人类群星闪耀时 十四篇历史特写(新版增订版)茨威格的名人物传记历史书籍 舒昌善 译',36,200,'人文社科','/CommercialCity/commercialcity/yzovgdtgtdphkgexagab.jpg','是否是套装: 否       出版时间: 2013年6月       作者: 无       译者: 李杰       开本: 32开        SBN编号: 9787560985749\n\n','无','华中科技大学出版社','2017-06-12 10:55:42','/CommercialCity/commercialcity/wzvopguhfpkgtnrzwtqy.png','/CommercialCity/commercialcity/mqqxmnujnoduacuwtiaq.png','/CommercialCity/commercialcity/cjcnpmqvqwcahynoxpkj.png'),(103,22,'不会说话你就输了','与人沟通技巧书籍说话技巧的书口才训练书籍 销售技巧谈判技巧幽默口才聊天心理学社交礼仪人际交往书籍',20,200,'教育','/CommercialCity/commercialcity/cmjzpawccxyilrqpknco.jpg','是否是套装: 否  出版时间: 2016年10月  开本: 16开  ISBN编号: 9787553313368\n','墨陌','南京出版社','2017-06-12 10:58:41','/CommercialCity/commercialcity/btgtocyczkbblupzjxjg.png','/CommercialCity/commercialcity/zwnzjybopchovaxndulc.png','/CommercialCity/commercialcity/ctxpvtmsicngybgqcwsh.png'),(104,22,'演讲与口才','别输在不会表达上 语言表达能力训练书籍 畅销书排行榜 沟通技巧职场人际交往好好说话',24,200,'教育','/CommercialCity/commercialcity/crxficsdolvjzsnbyoyk.jpg','是否是套装: 否 出版时间: 2014年3月   ISBN编号: 9787563821914','无','首都经济贸易大学出版社','2017-06-12 11:00:31','/CommercialCity/commercialcity/otmhntfvgprfpcqywbsa.png','/CommercialCity/commercialcity/gunljatgznofittjhoxt.png','/CommercialCity/commercialcity/xyjbsqjqlabbjzqwovmo.png'),(105,22,'遥远的救世主','遥远的救世主 天幕红尘 作者豆豆著 《天道》原著 畅销书籍中国现当代经典文学名著',27,98,'文艺','/CommercialCity/commercialcity/bbifrcdczphetjfvcpzu.jpg',' 是否是套装: 否   出版时间: 2010年09月  作者地区: 中国大陆  译者: 空   编者: 空  开本: 32开   ISBN编号: 9787506331746\n',' 豆豆著','作家出版社','2017-06-12 11:04:21','/CommercialCity/commercialcity/wpuniymmcuhypqoiqbgb.png','/CommercialCity/commercialcity/kuycjhnsafpijbodazcj.png','/CommercialCity/commercialcity/kzbwnxtmnzlgnwkpphxa.png'),(106,22,'别让直性子毁了你','人际沟通口才畅销书 情绪管理情商心理学书籍 成人交往沟通说话销售技巧人际沟通社交书籍',36,87,'教育','/CommercialCity/commercialcity/qitaawlfcagswwdbpxyp.jpg','是否是套装: 否  出版时间: 2015年12月   开本: 16开  ISBN编号: 9787516807675','无','台海出版社','2017-06-12 11:06:21','/CommercialCity/commercialcity/kknvnwlpshazaunlnczi.png','/CommercialCity/commercialcity/jeyfucidtdczzhlrbwzi.png','/CommercialCity/commercialcity/icpltrlcnatrooxvijdd.png'),(107,22,'湖畔','湖畔 东野圭吾著 又名湖畔杀人事件 湖边凶杀案 继白夜行后又一力作 对当代社会与家庭严厉的拷问 悬疑推理小说',34,76,'小说','/CommercialCity/commercialcity/ylgxznwpribjbugixrkt.jpg','是否是套装: 否  ISBN编号: 9787122250155',' 东野圭吾','化学工业出版','2017-06-12 11:09:02','/CommercialCity/commercialcity/ijmhsakbpxibatlcbjqi.png','/CommercialCity/commercialcity/jdqxvuxagyvktdnqmwob.png','/CommercialCity/commercialcity/okrauqtifjlgcwgkrijf.png'),(108,22,'抱抱(精)','正版抱抱绘本精装少低幼儿童宝宝小孩亲子情商启蒙故事图书籍0-1-2-3-4-6岁启发绘本',30,65,'青春文学/动漫-幽默','/CommercialCity/commercialcity/xdcjzsdtvnbprftjxupx.jpg',' 年龄: 0-3周岁  是否是套装: 否   出版时间: 2009年03月  作者地区: 英国  译者: 上谊  开本: 16开  ISBN编号: 9787533258795','(英)杰兹·阿波罗',' 明天','2017-06-12 11:15:56','/CommercialCity/commercialcity/hffulwmposwsyuvhwsli.png','/CommercialCity/commercialcity/fqgycsiuifdisgmsgfts.png','/CommercialCity/commercialcity/fqgozjmzifxdtehfuyjj.png'),(109,22,'爱上表达系列绘本全8册','爱上表达系列绘本全8册幼儿图书0-3-4-5-6周岁儿童绘本情商培养教育 宝宝睡前故事书幼儿园语言启蒙早教书读物 好习惯故事书',65,89,'青春文学/动漫-幽默','/CommercialCity/commercialcity/fgwuqhkztyiskjgygrsg.jpg','年龄: 3-6周岁  是否是套装: 是  ISBN编号: 9787531068426\n','无','河北美术出版','2017-06-12 11:18:39','/CommercialCity/commercialcity/kbgjqsneazyqgzokyjiv.png','/CommercialCity/commercialcity/hqijyeqnpxgicrfyupgw.png','/CommercialCity/commercialcity/kmevytchdiygzumhqzry.png'),(110,22,'绘本','有声儿童故事书图书绘本0-3-6周岁 幼儿园早教启蒙认知读物童书漫画书 幼儿书籍情商绘本0-1-2-4-5岁宝宝睡前童话故事书',54,246,'青春文学/动漫-幽默','/CommercialCity/commercialcity/ivomxajrydewegvhuvmb.jpg','年龄: 3-6周岁  是否是套装: 是  出版时间: 2015年1月  开本: 16开  ISBN编号: 9787216081634',' 王蔚','湖北人民出版社','2017-06-12 11:20:55','/CommercialCity/commercialcity/vkzcllyhdhbtfuvyjvls.png','/CommercialCity/commercialcity/qcixplufqzrdkfexqrhs.png','/CommercialCity/commercialcity/mefvtjshupgxbqjcnqze.png'),(111,22,'我有多爱你','猜猜我有多爱你绘本儿童0-3-4-6周岁非注音版幼儿书籍宝宝小孩亲子读物儿童图书情商启蒙早教书童话故事图画书绘本',35,124,'青春文学/动漫-幽默','','年龄: 3-6周岁  是否是套装: 否  出版时间: 2013年7月作者地区: 其他\n 译者: 梅子涵  编者: 凌艳明   开本: 16开  ISBN编号: 9787533274269','山姆 麦克布雷尼','明天出版社','2017-06-12 11:23:57','','',''),(113,22,'三毛全集','三毛作品全集共11册 珍藏版 畅销书籍 现当代文学小说',100,65,'小说','/CommercialCity/commercialcity/aprcvymmqrgpkfodpcdk.jpg','ISBN编号: 9787802081048','三毛','北京十月文艺出版社','2017-06-12 11:26:05','/CommercialCity/commercialcity/swlzjomwmzatnpjshxqr.png','/CommercialCity/commercialcity/cygfjcrjamhqmefwmlth.png','/CommercialCity/commercialcity/gqusrlhhiiufqjrjhwnd.png'),(114,22,'365夜童话','睡前小道理/故事/秘密/小问号 彩图注音版宝宝早教启蒙益智绘本 幼儿童365夜童话经典图画书籍少儿课外读物3-4-5-6-7-10岁 ',19,69,'青春文学/动漫-幽默','/CommercialCity/commercialcity/hlqniggdxcfitxeckemu.jpg','年龄: 3-6周岁   是否是套装: 否  出版时间: 2015年3月  开本: 16开\nISBN编号: 9787538665529','无','吉林美术出版社','2017-06-12 11:27:51','/CommercialCity/commercialcity/jesvremprshvuewquyxd.png','/CommercialCity/commercialcity/pbqizzmolzridyjkbyfv.png','/CommercialCity/commercialcity/xehzurqzhycsoonzumgv.png'),(115,21,'弟子规','幼儿早教唐诗三百300首古诗 三字经 弟子规 成语故事彩图注音正版国学启蒙经典书籍3-6岁全套4册',19.8,199,'教育','/CommercialCity/commercialcity/fbmzshlxsauugudgrtkz.jpg','是否是套装: 否 出版时间: 2014年1月 开本: 16开 ISBN编号: 9787539464886','无','湖北美术出版社','2017-06-12 11:44:48','/CommercialCity/commercialcity/kcnzxpjjfhkkumxaande.png','/CommercialCity/commercialcity/osxdodghnzbrbszpxjkv.png','/CommercialCity/commercialcity/hinbjiibwenlsksrwlxe.png'),(116,21,'愿有人陪你颠沛流离','超越首部百万销量《你要去相信，没有到不了的明天》的巅峰之作 正版励志青春文学畅销书籍排行榜 ',35.8,150,'生活','/CommercialCity/commercialcity/zjrzhsdkfgfbkkfjugbk.jpg','是否是套装: 否  出版时间: 2014年7月  ISBN编号: 9787540467883','卢思浩','湖南文艺出版社','2017-06-12 11:46:25','/CommercialCity/commercialcity/ofpcsaktplehwaozbycf.png','/CommercialCity/commercialcity/stomqahlnvntfmfgabha.png','/CommercialCity/commercialcity/tppyyvaqmgidnnowlrtp.png'),(117,21,'思考致富','《思考致富》全书共分为五章，从品德、教育、人际交往等方面讲述人在面临诸多现实问题时，该如何树立信心。',36.8,170,'小说','/CommercialCity/commercialcity/wgwwdabeibtfsavympoh.jpg','是否是套装: 否  作者地区: 美国  开本: 32开 \n ISBN编号: 9787554605400','（美）拿破仑.希尔 著','古吴轩出版社','2017-06-12 11:48:16','/CommercialCity/commercialcity/ccfcmjvnspeszosrivmt.png','/CommercialCity/commercialcity/fobqsumfuamvoxgolxhu.png','/CommercialCity/commercialcity/mjowydfxccqnaxpjlwjp.png'),(118,21,'冰心儿童文学','3册冰心儿童文学全集繁星春水正版包邮小桔灯寄小读者橘灯阅读书籍散文集三四五六年级课外书必读图书6-8-10-12-15岁小学生读物',20,190,'教育','/CommercialCity/commercialcity/dodhgewdyqoyqwamsokl.jpg','是否是套装: 是 \n\n ISBN编号: 9787505988798','冰心','中国文联出版社','2017-06-12 11:51:48','/CommercialCity/commercialcity/xzkerlirjdqtfatifwvw.png','/CommercialCity/commercialcity/trglwkpmxtrbsjvzkxym.png','/CommercialCity/commercialcity/ixqrfymlihjuivoeqwlz.png'),(119,21,'城南旧事新课标必读名著','城南旧事正版/精美彩插/无障碍阅读版/名师导读/中小学生青少年新课标必读课外书籍/励志版',26,78,'小说','/CommercialCity/commercialcity/rzebavxqedpcuxskzngm.jpg','年龄: 6-12周岁  是否是套装: 否  出版时间: 2012年7月  ISBN编号: 9787100089500','林海音','商务印书馆','2017-06-12 12:38:15','/CommercialCity/commercialcity/cqrhnekmmiirwkmzcqtp.png','/CommercialCity/commercialcity/ovhaelcdknhmbsauziss.png','/CommercialCity/commercialcity/kjbienuwnxgzjsyvqcbe.png'),(120,21,'人性的弱点全集','人性的弱点全集 卡耐基成功心理学管理哲理人生经商销售励志书籍畅销书 心灵鸡汤改变自己人际关系说话技巧青春正能量关于创业正版',28,86,'小说','/CommercialCity/commercialcity/atxsjlwbajpyoklbgzwl.jpg','译者: 袭村野  开本: 32开\nISBN编号: 9787800947728',' 戴尔·卡耐基','大众文艺出版社','2017-06-12 12:40:36','/CommercialCity/commercialcity/qnqspytjteupceatohdl.png','/CommercialCity/commercialcity/ilswdzcdhwaazxyelfcb.png','/CommercialCity/commercialcity/zlqzlwqryrdtxyetadbp.png'),(121,21,'三毛作品全集','三毛作品全集共11册 珍藏版 畅销书籍 现代文学小说',56,86,'小说','/CommercialCity/commercialcity/zsuefshcgvuqvaqbwvuz.jpg','出版时间: 2010年04月  开本: 32开','三毛','无','2017-06-12 12:43:08','/CommercialCity/commercialcity/pzqbbnoztirkzdkzduzf.png','/CommercialCity/commercialcity/tvnferypaezismoghokz.png','/CommercialCity/commercialcity/paormmuozkogimuruaae.png'),(122,21,'超炫理论','超弦理论：探究时间、空间及宇宙的本原自然科学 物理系列 科技研究类书籍 超炫理论导论 量子物理基础原理 空间时间概念',39,78,'科技','/CommercialCity/commercialcity/nmlipwaqnhzxrdjhngkh.jpg','出版时间: 2015-01-01 ISBN编号: 9787115373861','大栗博司','人民邮电出版社','2017-06-12 12:46:18','/CommercialCity/commercialcity/egtpjowppivvqypnxvxf.png','/CommercialCity/commercialcity/kgnwjabvshsnvkmbehmn.png','/CommercialCity/commercialcity/jnunuohixiuqkvlvplbd.png'),(123,21,'中国新闻周刊杂志','.中国新闻周刊杂志近期10本打包2017年7/14/15/16期+2016年33-38期 新闻时事过期刊 关注政治经济 科技文化 娱乐时尚综合新闻类书籍 ',5,50,'科技','/CommercialCity/commercialcity/kpgzixjahupmmexifyjk.jpg','刊号: 2016-10 月份: 10月\n','佚名','无','2017-06-12 12:49:18','/CommercialCity/commercialcity/kmvbelckgqoyvesaigip.png','/CommercialCity/commercialcity/gjmwptpnwxviunqzdoxu.png','/CommercialCity/commercialcity/knzsozctrtqejhfcwaxr.png'),(124,21,'全彩图说时间简史','\n38.全彩图说时间简史霍金翻译宇宙知识科技丛书科普读物宇宙学思想和理论的解读探索科技物理学科学书籍著名科学类书籍理论物理最前沿 ',68,88,'科技','/CommercialCity/commercialcity/qoqjuwiszdwbpllqeabo.jpg','编者: 楚丽萍 开本: 16 ISBN编号: 9787511355355','无','中国华侨出版社','2017-06-12 12:50:40','/CommercialCity/commercialcity/utcpqhpbuyrrnhhptyfw.png','/CommercialCity/commercialcity/bfphuajnxnuyghpnhoek.png','/CommercialCity/commercialcity/jdpdpsluxnwselctvuwe.png'),(125,21,'奇点临近','现货包邮！奇点临近 库兹韦尔著 人工智能与未来科技 科技文明与人类未来 人工智能技术导论 人工智能书籍 计算机类书籍包邮 ',69,55,'科技','/CommercialCity/commercialcity/sdgbhtckqvmwkjqqqqsv.jpg','作者地区: 中国大陆 译者: 无 开本: 16开 ISBN编号: 9787111358893','李庆诚','机械工业出版社','2017-06-12 12:52:00','/CommercialCity/commercialcity/skyxqawkemzmwduhmsyo.png','/CommercialCity/commercialcity/tndsevwqhwtovckwmefp.png','/CommercialCity/commercialcity/ncmcmjplhztiyzllygwh.png'),(126,21,'大学物理学杂谈','高等院校精品课程规划教辅：大学物理练习册（含上下册和参考答案） 书店 华中科技大学出版社 理学类书籍 畅销书 \n',24,88,'科技','/CommercialCity/commercialcity/xwymgxvfwwtvzahifrue.jpg','出版时间: 2014年11月 ISBN编号: 9787568002677','杨长铭','华中科技大学出版社','2017-06-12 12:54:20','/CommercialCity/commercialcity/snttnfgndhnozrrvvbkn.png','/CommercialCity/commercialcity/xmrbhutcejfurfbfjfcf.png','/CommercialCity/commercialcity/kalaczvdzozygmsblpvu.png'),(127,21,'超级机器人大作战','《绝境生存系列36超级机器人大作战2我的本科学漫画书》',25,56,'科技','/CommercialCity/commercialcity/iznxykvcfsmtsoqwoggp.jpg','ISBN编号: 9787556821990','金政郁','二十一世纪出版社','2017-06-12 12:57:41','/CommercialCity/commercialcity/rdvzoizfmtfyztwebwnv.png','/CommercialCity/commercialcity/cbotqvuyfxldqlobdsmw.png','/CommercialCity/commercialcity/pxjgtxclswnolkyyqbxv.png'),(128,21,'2014艾特奖获奖作品年鉴','2014-艾特奖获奖作品年鉴 本书委会 湖南科技 百科全书类书 书籍',498,10,'科技','/CommercialCity/commercialcity/xwofylukjcbtddijuffu.jpg','出版时间: 2015年9月 开本: 16开 ISBN编号: 9787535787231','国际空间设','湖南科学技术出版社','2017-06-12 12:59:11','/CommercialCity/commercialcity/hxhdfgwmiaknhuemdkxg.png','/CommercialCity/commercialcity/pdwzsfpbboxevcqgbyvh.png','/CommercialCity/commercialcity/ydwelkzolfqzgahuxrzz.png'),(129,21,'现代科技与机器人','现代科技与机器人/科普面对面/开启人类知识天窗的科普类书 \n产品名称：现代科技与机器人',27,84,'科技','/CommercialCity/commercialcity/jggrrqcesvwzjaaedkoc.jpg',' ISBN编号: 9787536827738','其他作者','陕西人民美术出版社','2017-06-12 13:00:32','/CommercialCity/commercialcity/zxymxjyyohfvxkedozxl.png','/CommercialCity/commercialcity/mwdmnzodhwtrhxihcuwn.png','/CommercialCity/commercialcity/dtxvjxnalheelhvwhgyb.png'),(130,21,'大中国上下五千年—中国历代科技成就','[全新正版自然科学类书籍]大中国上下五千年——中国历代科技成就 ',55,89,'科技','/CommercialCity/commercialcity/jotqvntktwzknqnfuyms.jpg','编者: 丛书编委会 开本: 16 16开 ISBN编号: 9787119063867\n','其他作者','外文出版社','2017-06-12 13:01:32','/CommercialCity/commercialcity/diflltmnduunfphhijwm.png','/CommercialCity/commercialcity/hstmeydaaotgvyuntdmm.png','/CommercialCity/commercialcity/jdkkmilkamuasrinvcec.png'),(131,21,'科技写作与交流:期刊论文.基金申请书及会议讲演','[全新正版自然科学类书籍]科技写作与交流：期刊论文、基金申请书',98,50,'科技','/CommercialCity/commercialcity/lzmumqzkezbypnxjzikr.jpg','译者: 任胜利　等 开本: 5开 ISBN编号: 9787030343598','(美)霍夫曼','科学出版社','2017-06-12 13:02:34','/CommercialCity/commercialcity/lmyxfmdysbhkwaenopra.png','/CommercialCity/commercialcity/ihizwvafqmvhaoxenash.png','/CommercialCity/commercialcity/dulrvouxdmmmaczffima.png'),(132,21,'马云-未来已来','现货【赠送马云寄语笔记本】正版 马云 未来已来 马云书籍畅销书籍阿里巴巴集团经营管理互联网 经管经济学互联网在线 经济类书籍',49,89,'经管','/CommercialCity/commercialcity/fuwlvdjnxeyoijzszviz.jpg','ISBN编号: 9787505139121','阿里巴巴集团','红旗出版社','2017-06-12 13:05:27','/CommercialCity/commercialcity/btmfvhrzrbienqczhwmu.png','/CommercialCity/commercialcity/snxcvunohblgcwqghans.png','/CommercialCity/commercialcity/ycccvvmomyvorwxptnyb.png'),(133,21,'巅峰对话 企业国际并购与管','770540|巅峰对话：企业国际并购与管理 企业管理类书籍 经管类书 企业并购教程',45,78,'经管','/CommercialCity/commercialcity/scdjzaoxnuqzlmjoklba.jpg',' 出版时间: 2014年10月 作者地区: 美国  ISBN编号: 9787111476252','赫尔穆特·毛赫尔','机械工业出版社','2017-06-12 13:08:00','/CommercialCity/commercialcity/eruspsfxipfjmcighizz.png','/CommercialCity/commercialcity/wwcefdohefiskrrznmyr.png','/CommercialCity/commercialcity/wzvvecfiyljrepxfkhoy.png'),(134,21,'领导梯队：全面打造领导力驱动型公司','974448|领导梯队:全面打造领导力驱动型公司(原书第2版珍藏版)领导力开发的圣经/领导技能/时间管理/企业管理/团队管理/经管类书 ',49,96,'经管','/CommercialCity/commercialcity/owtalvhgrbpnfgvaztiy.jpg','译者: 徐中 林嵩 雷静 ISBN编号: 9787111544333\n','拉姆·查兰','机械工业出版社','2017-06-12 13:09:11','/CommercialCity/commercialcity/ibfnoqfoldcygljqsmtc.png','/CommercialCity/commercialcity/xvcnncthjxjdpjyuwwve.png','/CommercialCity/commercialcity/emmvotjdaumdtmqjbwqf.png'),(135,21,'黄金高胜算交易　','正版现货 黄金高胜算交易（第3版）八年稳居中文黄金交易类书籍 贵金属交易员权威教程 全新旁注解读原理 经管 奥华元',67,75,'经管','/CommercialCity/commercialcity/xcbjsbjnrpdopelybnuc.png',' ISBN编号: 9787509644744\n','魏强斌 欧阳傲杰','经济管理出版社','2017-06-12 13:10:05','/CommercialCity/commercialcity/uygreqagkyzwtlbvxanl.png','/CommercialCity/commercialcity/nckdyufuimtozuxqzuyp.png','/CommercialCity/commercialcity/xaveyofkbelemdbiatlv.png'),(136,21,'董事会里的战争 企业管理层的25个营销误区','正版书籍 董事会里的战争 企业管理层的25个营销误区 定位经典丛书 华章大师经典之定位系列 战略管理 企业管理类书 经管书籍 ',45,73,'经管','/CommercialCity/commercialcity/bwiwkotqstlxswxhuscd.jpg','作者地区: 美国 ISBN编号: 9787111434344','艾·里斯','机械工业出版社','2017-06-12 13:11:09','/CommercialCity/commercialcity/ljlnfnotbqhlzphhxfcz.png','/CommercialCity/commercialcity/vkrenjnsonzjvaotjkme.png','/CommercialCity/commercialcity/hvgamtbrhcoboyougpcl.png'),(137,21,'将来的你,一定会感谢现在拼命的自己','将来的你,一定会感谢现在拼命的自己青春文学书籍 文学小说写给志存高远却迷茫无助的你 正版包邮励志书籍青春 \n产品名称：将来的你,一定会感谢现在...',36,56,'励志/成功','/CommercialCity/commercialcity/hrfibcmdiriskidstpyh.jpg','作者地区: 中国大陆 ISBN编号: 9787558009310\n','黎芫','江苏凤凰美术出版社','2017-06-12 13:17:36','/CommercialCity/commercialcity/dwcdlqsigsyyhilblwwn.png','/CommercialCity/commercialcity/qgidjggxgdcbpdjrioig.png','/CommercialCity/commercialcity/ijjbcyuswbhscnkxplyo.png'),(138,21,'别在吃苦的年纪选择安逸','别在吃苦的年纪选择安逸 景天著 写给年轻人爱正能量信心青春文学小说成功励志书籍 畅销书 青少年人生哲理女性心灵鸡汤',35,55,'励志/成功','/CommercialCity/commercialcity/cxsosnvphqzxorucpizq.jpg','ISBN编号: 9787539289014','景天','江西教育出版社','2017-06-12 13:18:36','/CommercialCity/commercialcity/cxnwgmwssccqsdxkshhq.png','/CommercialCity/commercialcity/lcgktmwznievfyjxbyiz.png','/CommercialCity/commercialcity/tsacjmickaiiorrvgscc.png'),(139,21,'人生不设限','人生不设限我那好得不像话的生命体验 力克胡哲著 人生生活哲学成功励志书籍感动数亿人心灵的勇气之书励志教育 \n',32,86,'励志/成功','/CommercialCity/commercialcity/ftbudkenfyaxvotcgfdo.jpg','\n ISBN编号: 9787556400874\n','无','湖北教育出版社','2017-06-12 13:19:26','/CommercialCity/commercialcity/gkjcuuhprvmislcmduuo.png','/CommercialCity/commercialcity/lxsptrgjpftoosocqtyj.png','/CommercialCity/commercialcity/fwqopmacrqkibmxjzjdc.png'),(140,21,'强者的逻辑- 你没有变强,是因为你一直待在舒适区!','强者的逻辑 将来的你会感谢现在的自己 企业管理学书籍 心理学管理书籍畅销书 人生哲理创业沟通技巧成功励志畅销书 \n',40,55,'励志/成功','/CommercialCity/commercialcity/glbrlaqoymnikynkwfvt.jpg','ISBN编号: 9787514336221',' 高原','现代出版社','2017-06-12 13:20:16','/CommercialCity/commercialcity/jcuxfxibdpwjcuutwnil.png','/CommercialCity/commercialcity/gbtixdvvjyyhsceutezz.png','/CommercialCity/commercialcity/oovvvhqvdltozdljjswj.png'),(141,21,'太较真你就输了','心灵休养书 哲学书籍书人生籍畅销书人生哲学书成功励志书 哲学禅悟 书籍 人生不必太计较 别跟自己过不去 ',60,78,'小说','/CommercialCity/commercialcity/hmnvqhlkfwpzolgodrig.jpg','ISBN编号: 9787511347640','无','中国华侨出版社','2017-06-12 13:21:19','/CommercialCity/commercialcity/ithvswopprhcddrcbtvp.png','/CommercialCity/commercialcity/bxqbwmrfukzmhxigntxg.png','/CommercialCity/commercialcity/dqpwvtkapeoiezteievb.png'),(142,21,'九型人格气场修炼术','心理学书籍畅销图书 青春成功励志书 逻辑学读心术全套三册 正版包邮 九型人格气场修炼术 微反应心理学 微改变 ',30,45,'励志/成功','/CommercialCity/commercialcity/vsbiqupsaynwbgmpxngy.png','ISBN编号: 9787510042928','海华','世界图书出版公司','2017-06-12 13:22:09','/CommercialCity/commercialcity/wyohbgppevtobbcdwdmx.png','/CommercialCity/commercialcity/dzsimkbdmbsmjgggedtd.png','/CommercialCity/commercialcity/gbbxlvvxmcxfgpdggyym.png'),(143,22,'中国国家地理百科全书','中国国家地理百科全书 全套10册 中国地理常识全知道 知识百科全书 人文地理总论 地理知识城市建设划分百科书 ',199,56,'人文社科','/CommercialCity/commercialcity/lfleqvdcoycskwierdad.jpg','ISBN编号: 9787550275478','张妙弟','北京联合出版社','2017-06-12 13:26:20','/CommercialCity/commercialcity/heglewpwjxvxldgyvsqg.png','/CommercialCity/commercialcity/japwxgxxdkvuypxaoyur.png','/CommercialCity/commercialcity/pzkdtzuodzgvofgctbfp.png'),(144,22,'微表情心理学','微表情心理学微反应微动作全集3册正版包邮 心理学与读心术FBI教你人际交往心理学与生活 社会普通犯罪行为心理学书籍入门畅销书 ',298,56,'人文社科','/CommercialCity/commercialcity/ynckgcnuzdjfkcyprgpe.jpg',' ISBN编号: 9787511352071','弗洛伊德','中国华侨出版社','2017-06-12 13:27:07','/CommercialCity/commercialcity/gplmngmbwfimsgtjrevg.png','/CommercialCity/commercialcity/dvujhorsylbteoeautfo.png','/CommercialCity/commercialcity/deofxmvtcnfeclojwyql.png'),(145,22,'人际交往','际交往心理学书籍 畅销书微表情心理学销售行为心理学入门书籍基础人际关系沟通技巧励志书籍 说话心理学与读心术 ',36,78,'人文社科','/CommercialCity/commercialcity/gmgpzkwdxrfeoioywffi.jpg','ISBN编号: 9787519425593','宋璐璐','光明日报出版社','2017-06-12 13:28:04','/CommercialCity/commercialcity/pndcuagoanoyfsafbdmx.png','/CommercialCity/commercialcity/mgalaeeiqramfhtnnunc.png','/CommercialCity/commercialcity/bjccnccpccxxoveejizf.png'),(146,22,'心静了世界就静了','畅销书心静了世界就静了 青春成功励志书籍小说 畅销书青春文学心灵心灵励志 职场生活励志人生哲理书籍心灵鸡汤静心 ',35,68,'人文社科','/CommercialCity/commercialcity/ooopiatwlamkjffauxkr.jpg','ISBN编号: 9787510447365\n','龚诗琦',' 新世界出版社','2017-06-12 13:28:41','/CommercialCity/commercialcity/hqkptuupydwslrobmvlb.png','/CommercialCity/commercialcity/klfpgnkcnwiauqziycdn.png','/CommercialCity/commercialcity/olilbdwigeejraqzdfcf.png'),(147,22,'资治通鉴','治通鉴（文白对照礼品装）正版全18册锦盒精装中华书局定价1280元司马光编著资治通鉴全本原文译文简体横排中国通史历史畅销书籍',1280,10,'人文社科','/CommercialCity/commercialcity/hnwqldcezaxwndbrnsqk.jpg',' ISBN编号: 9787101083897\n','【宋】司马光','中华书局','2017-06-12 13:29:25','/CommercialCity/commercialcity/mzkcaafyctyewkzmfroi.png','/CommercialCity/commercialcity/mumtsbjqvyinhjgmgshd.png','/CommercialCity/commercialcity/ahefvzepzlrsfpyzxjqy.png'),(148,22,'青春励志','你若盛开清风自来+这样做女人最好命+淡定的女人最幸福不抱怨的人生悦读时光心灵鸡汤全集适合女性修养气质青春励志文学书籍畅销书 ',30,56,'人文社科','/CommercialCity/commercialcity/jskdexxyoktdvqhfafpt.png',' ISBN编号: 9787806757802\n','无','内蒙古文化出版社','2017-06-12 13:30:02','/CommercialCity/commercialcity/klfflxvgjsbnfsfnpcex.png','/CommercialCity/commercialcity/kokjbphydlrcgxdngtln.png','/CommercialCity/commercialcity/nnbjgmxapkujtfoconbs.png'),(149,23,'项目管理知识体系指南(PMBOK指南)(第5版) (英文版)','项目管理知识体系指南 PMBOK指南 第5版 ——软件分册项目管理协会 Project Management Institute 电气与经管类书 ',128,45,'经管','/CommercialCity/commercialcity/qzosasfiomsimtgdgqqk.jpg','作者地区: 美国 ISBN编号: 9787121274046','美）Project Management Institute','电子工业出版社','2017-06-12 13:36:46','/CommercialCity/commercialcity/nzirwkerkvxtdpujboux.png','/CommercialCity/commercialcity/dnwutqwdcjryymysadle.png','/CommercialCity/commercialcity/gfmdbwjdhjmfszvixvvf.png'),(150,23,'博弈论','正版书籍 博弈论（经济科学译丛；“十一五”国家重点图书出版规划项目）Jean Tirole 让梯若尔 弗登博格,姚洋校,经管类书 ',98,42,'经管','/CommercialCity/commercialcity/lmuaplzxaxbfyqzscxxz.jpg','ISBN编号: 9787300117850\n',' 朱·弗登博格,让·梯诺尔','中国人民大学出版社','2017-06-12 13:37:26','/CommercialCity/commercialcity/himobdyuwwijmjnahvbr.png','/CommercialCity/commercialcity/dsskpdoyoofqddwrwfah.png','/CommercialCity/commercialcity/fxbkihwwgieytzlphmvy.png'),(151,23,'一生健康','大趋势丛书健康保健丛书养生书籍生活健康类书',45,89,'生活','/CommercialCity/commercialcity/jnqzrdinjziibupfylva.jpg','32开黑白页 总共200页','雷斯丹','无','2017-06-12 13:38:21','/CommercialCity/commercialcity/hxzsqqrcccaksdhhhysr.png','/CommercialCity/commercialcity/nlkbcvpklfljyjeycsvo.png','/CommercialCity/commercialcity/xyixhfgpsstdvonqcqxl.png'),(152,23,'生活中的经济学','全新正版经济类书籍]生活中的经济学/加里·贝克尔，吉蒂·贝克',45,56,'生活','/CommercialCity/commercialcity/zhvrdumlknxytcovjipj.jpg',' ISBN编号: 9787111422006','加里·贝克尔,吉蒂·贝克尔','机械工业出版社','2017-06-12 13:39:09','/CommercialCity/commercialcity/wqgsrwwgyyebuvojdyge.png','/CommercialCity/commercialcity/mhsdjpqkvoihqrbacqph.png','/CommercialCity/commercialcity/irdvxpocmzjuencijhhl.png'),(153,23,'丽江慢生活','丽江慢生活 大山 丽江旅游攻略 丽江图书 丽江自助旅游 丽江客栈',58,69,'生活','/CommercialCity/commercialcity/wbujrbipvjztxuurjiut.jpg','ISBN编号: 9787222082595','大山','云南人民出版社','2017-06-12 13:39:49','/CommercialCity/commercialcity/ndisowvqyxfszweiqvfr.png','/CommercialCity/commercialcity/nuuqrtrgmlkpsknbkdtn.png','/CommercialCity/commercialcity/ltkvnvpcuvedtymrkkgx.png'),(154,23,'茶经','WG 【全彩】正版 图解茶经 陆羽原著 中国茶经 中华茶道/茶艺/茶文化书籍 茶书 茶叶书籍 生活实用识茶品茶泡茶图鉴 茶道书籍 ',1448,98,'生活','/CommercialCity/commercialcity/ohhgkrqirrexngwlymvq.jpg','ISBN编号: 9787550228306','陆羽','北京联合出版公司','2017-06-12 13:40:29','/CommercialCity/commercialcity/nkwxreukqhsehnalucga.png','/CommercialCity/commercialcity/cmfqjponicoszieyhwxp.png','/CommercialCity/commercialcity/tzagtwougitfyzufbhme.png'),(155,23,'无与伦比的恩典','正版全新 《无与伦比的恩典》【美】陆可铎或路卡杜 基督徒生活心理灵修 基督教书籍 畅销类书籍 心灵鸡汤 美好的心灵 ',36,56,'小说','/CommercialCity/commercialcity/avpzuasjgqzrwxudnsbj.jpg','ISBN编号: 9787531688372','陆可铎','黑龙江教育出版社','2017-06-12 13:41:08','/CommercialCity/commercialcity/wwpoujpnentehvrxwfyb.png','/CommercialCity/commercialcity/ndajchjztmcstxxlktbl.png','/CommercialCity/commercialcity/hwqbabqtnbytviufadac.png'),(156,23,'第一次品红茶就上手','正版现货 第一次品红茶就上手 图解版 辨别识别品鉴红茶分类等级文化 起源 产区 分类 采制 泡饮 品茶喝茶 关于茶的生活养生书籍',40,59,'小说','/CommercialCity/commercialcity/vzbccrstigbkqzytkqqx.jpg','ISBN编号: 9787563731152\n','无','旅游教育出版社','2017-06-12 13:41:43','/CommercialCity/commercialcity/ciziogwvyzjpeobarqum.png','/CommercialCity/commercialcity/nzhrfynktzjtauprqngy.png','/CommercialCity/commercialcity/detinehdthrazoyoatrs.png'),(157,23,'茶日子','茶日子 茶艺茶道 养生茶 生活健康 茶水饮料 识茶泡茶品茶 学茶入门畅销 茶书籍 中华中国茶文化 茶叶关于茶的书籍 电子茶艺DIY ',40,54,'生活','/CommercialCity/commercialcity/twdhuxievmbiyqqfguqa.jpg','ISBN编号: 9787121253546','李啟彰','电子工业出版社','2017-06-12 13:42:17','/CommercialCity/commercialcity/ulcgyhsqvjprournakhm.png','/CommercialCity/commercialcity/bqndhdfkoeranjbecirr.png','/CommercialCity/commercialcity/dmwbgldhhqvhdbedxbhg.png'),(158,23,'超级漫画技法从入门到精通...','.漫画教程书 超级漫画技法从入门到精通 超值版 零基础学漫画零基础入门教程 色铅笔手绘画动漫画技法宝典圣经 自学教程 正版书籍 ',30,59,'青春文学/动漫-幽默','/CommercialCity/commercialcity/duekcyckgqsdtmmhrwfv.jpg',' ISBN编号: 9787115403940\n','无','人民邮电出版社','2017-06-12 13:43:05','/CommercialCity/commercialcity/zlkwazlqlkhyixnhxviu.png','/CommercialCity/commercialcity/wjxthjypionutkgmtowl.png','/CommercialCity/commercialcity/yznvsmpntidxrqfrtkla.png'),(159,23,'生活中来1-88合订本家庭生活常识小窍门妙招百科类书籍','家庭生活常识小窍门妙招百科类书籍',26,50,'生活','/CommercialCity/commercialcity/mujokydfevwvufogggrk.jpg','家庭生活常识小窍门妙招百科类书籍','无','无','2017-06-12 13:43:52','/CommercialCity/commercialcity/ivoatscnkijcaotkxkoe.png','/CommercialCity/commercialcity/lgcwapshjaowhxbrnpdx.png','/CommercialCity/commercialcity/yrbuirmvcaqctvtlqusd.png'),(160,23,'海底小纵队','海底小纵队书 全套10册探险记注音版 儿童故事书3-4-5-6-7-8岁睡前故事 幼儿绘本书籍阅读 卡通动漫图书读物宝宝童话带拼音 动画书',36,89,'青春文学/动漫-幽默','/CommercialCity/commercialcity/jzsjckaztfvofqiizsgi.jpg','ISBN编号: 9787556033065','无','长江少年儿童出版社  作者: 无','2017-06-12 13:44:30','/CommercialCity/commercialcity/lbskrnhhvblxmbltxvqi.png','/CommercialCity/commercialcity/tlybxhllafupwptarric.png','/CommercialCity/commercialcity/ypooyqjrdiluliqfhgxr.png'),(161,23,'哑舍·零·秦失其鹿','赠书签+明信片+笔记本】哑舍·零·秦失其鹿 玄色著 哑舍12345系列前传 古风动漫幻想小说 新华书店正版畅销图书籍',30,98,'青春文学/动漫-幽默','/CommercialCity/commercialcity/payuylbjqfteocjexvqi.jpg',' ISBN编号: 9787556215805','玄色','湖南少年儿童出版社','2017-06-12 13:45:16','/CommercialCity/commercialcity/gchhbfezkjruxceowies.png','/CommercialCity/commercialcity/pwuhaowdqcpmlitqwvys.png','/CommercialCity/commercialcity/ivudpkgoziafyiwvrkbf.png'),(162,23,'我在等,等风等你来','言情小书我在等等风等你来2册云上校园青春小说畅销书青春文学校园爱情情感伤感文艺书籍青春风都市小情歌系列大鱼文化',29,60,'青春文学/动漫-幽默','/CommercialCity/commercialcity/knjgxyknserggoyselqs.png','v','云上','花山文艺出版社有限责任公司','2017-06-12 13:47:25','/CommercialCity/commercialcity/xtnaodtnxucjsmxzxxuk.png','/CommercialCity/commercialcity/cksasxcxistdcahhlddk.png','/CommercialCity/commercialcity/ppjrfwjqicprhrfvuvoy.png'),(163,23,'谢谢你出现在我的青春里','谢谢你出现在我的青春里 文子金浩森 丁丁张刘同推荐 我不要一成不变的生活青春文学书籍xs博集',42,56,'青春文学/动漫-幽默','/CommercialCity/commercialcity/eqcdjgvhnkrbresrneib.jpg','ISBN编号: 9787540480646','文子著金浩森摄影','湖南文艺出版社','2017-06-12 13:48:48','/CommercialCity/commercialcity/opxljimbrdssrwbqoket.png','/CommercialCity/commercialcity/tgiwpfyfwhkplkxswvbc.png','/CommercialCity/commercialcity/xbcctiydsqnaiakwdkdj.png'),(164,23,'牧羊少年奇幻之旅','牧羊少年奇幻之旅(精装) 保罗&middot;柯艾略/迄今语种超圣经的书/外国文学人文社科 课外阅读教辅书籍',25,56,'青春文学/动漫-幽默','/CommercialCity/commercialcity/yiabkwdxfduljvtrnlnp.jpg','译者: 丁文林 开本: 32开 ISBN编号: 9787544244190','保罗·柯艾略','南海出版公司','2017-06-12 13:49:49','/CommercialCity/commercialcity/zwbqqvueqydigoixbvlz.png','/CommercialCity/commercialcity/pyopfdciupqylgucoioi.png','/CommercialCity/commercialcity/zkgkxoizqdcltbkznwbj.png'),(165,23,'不知爱将至','不知爱将至 板栗子著 畅销青春文学书籍小说网络原名《逃婚奏鸣曲》让你的少女心甜到炸',32,15,'青春文学/动漫-幽默','/CommercialCity/commercialcity/yrgiyevbzteindxfgegr.jpg','ISBN编号: 9787550022386','板栗子','百花洲文艺出版社','2017-06-12 13:50:39','/CommercialCity/commercialcity/iezbqhvehkdshudlqjrq.png','/CommercialCity/commercialcity/sjnhesijtgcojyutmftr.png','/CommercialCity/commercialcity/vzolonndhlldnqnewjke.png'),(166,23,'痛才是青春','痛 才是青春青春励志文学畅销书籍正能量人生哲理故事悦读时光不生气的智慧淡定的人生修养心灵鸡汤做好的自己书籍',18,59,'青春文学/动漫-幽默','/CommercialCity/commercialcity/tlsiuumqzhzrtbjndedf.jpg','ISBN编号: 9787538588422','无','北方妇女儿童出版社','2017-06-12 13:51:43','/CommercialCity/commercialcity/zrryjrbshyjxgxtklxar.png','/CommercialCity/commercialcity/ksbsoljjehmpcaozwtzp.png','/CommercialCity/commercialcity/srognwimhyldezevezxx.png');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop` (
  `shopId` int(11) NOT NULL AUTO_INCREMENT,
  `shopperId` int(11) NOT NULL,
  `shopName` varchar(40) NOT NULL,
  `introduction` varchar(200) NOT NULL,
  `openDate` datetime NOT NULL,
  `displayPicture` varchar(100) NOT NULL,
  `goodRate` double NOT NULL,
  PRIMARY KEY (`shopId`),
  UNIQUE KEY `shopName` (`shopName`),
  KEY `shopperId` (`shopperId`),
  CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`shopperId`) REFERENCES `shopper` (`shopperId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (21,12,'我爱学习','本店销售各类图书，应有尽有','2017-06-12 01:36:00','/CommercialCity/commercialcity/jihgjpednhvgdkcfhmci.png',0),(22,13,'书的海洋','本店主营各类图书，适合各年龄阶段的用户阅读','2017-06-12 01:47:13','/CommercialCity/commercialcity/azhiupbxogiaqijzmsnu.jpg',0),(23,14,'三味书屋','一个卖书的大帅逼','2017-06-12 13:31:46','/CommercialCity/commercialcity/itjjvhunblzsgtqldlav.jpg',0);
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopper`
--

DROP TABLE IF EXISTS `shopper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopper` (
  `shopperId` int(11) NOT NULL AUTO_INCREMENT,
  `creditCardId` int(11) NOT NULL,
  `account` varchar(14) NOT NULL,
  `password` varchar(14) NOT NULL,
  `mail` varchar(20) NOT NULL,
  `idCard` varchar(18) NOT NULL,
  `onlineName` varchar(20) NOT NULL,
  `displayPicture` varchar(100) NOT NULL,
  PRIMARY KEY (`shopperId`),
  UNIQUE KEY `account` (`account`),
  UNIQUE KEY `mail` (`mail`),
  UNIQUE KEY `idCard` (`idCard`),
  UNIQUE KEY `onlineName` (`onlineName`),
  KEY `creditCardId` (`creditCardId`),
  CONSTRAINT `shopper_ibfk_1` FOREIGN KEY (`creditCardId`) REFERENCES `creditcard` (`creditCardId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopper`
--

LOCK TABLES `shopper` WRITE;
/*!40000 ALTER TABLE `shopper` DISABLE KEYS */;
INSERT INTO `shopper` VALUES (12,23,'123456789','123456789','1085581172@qq.com','350322199603081558','黄牛','/CommercialCity/commercialcity/yobiephvmrzothxzqhfk.jpg'),(13,17,'123456788','123456788','441299124@qq.com','350105419960731271','林拱','/CommercialCity/commercialcity/ckvfcxronqwvvqdqugcd.jpg'),(14,20,'123456787','123456787','821621494@qq.com','789456216547893214','孙宁','/CommercialCity/commercialcity/ikuxxutjgwwiijnmojun.jpg');
/*!40000 ALTER TABLE `shopper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingcartproduct`
--

DROP TABLE IF EXISTS `shoppingcartproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingcartproduct` (
  `customerId` int(11) NOT NULL DEFAULT '0',
  `productId` int(11) NOT NULL DEFAULT '0',
  `quantity` int(11) NOT NULL DEFAULT '0',
  `time` datetime NOT NULL,
  PRIMARY KEY (`customerId`,`productId`),
  KEY `productId` (`productId`),
  CONSTRAINT `shoppingcartproduct_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`),
  CONSTRAINT `shoppingcartproduct_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcartproduct`
--

LOCK TABLES `shoppingcartproduct` WRITE;
/*!40000 ALTER TABLE `shoppingcartproduct` DISABLE KEYS */;
INSERT INTO `shoppingcartproduct` VALUES (6,100,2,'2017-06-12 15:05:36'),(7,98,3,'2017-06-12 15:25:23'),(7,157,4,'2017-06-12 15:25:18');
/*!40000 ALTER TABLE `shoppingcartproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_employee`
--

DROP TABLE IF EXISTS `tb_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(25) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_employee`
--

LOCK TABLES `tb_employee` WRITE;
/*!40000 ALTER TABLE `tb_employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-12 15:35:50
