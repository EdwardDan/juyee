-- MySQL dump 10.13  Distrib 5.7.11, for osx10.9 (x86_64)
--
-- Host: 192.168.1.51    Database: jtjs
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `account_`
--

DROP TABLE IF EXISTS `account_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_` (
  `accountId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `parentAccountId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `legalName` varchar(75) DEFAULT NULL,
  `legalId` varchar(75) DEFAULT NULL,
  `legalType` varchar(75) DEFAULT NULL,
  `sicCode` varchar(75) DEFAULT NULL,
  `tickerSymbol` varchar(75) DEFAULT NULL,
  `industry` varchar(75) DEFAULT NULL,
  `type_` varchar(75) DEFAULT NULL,
  `size_` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`accountId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_`
--

LOCK TABLES `account_` WRITE;
/*!40000 ALTER TABLE `account_` DISABLE KEYS */;
INSERT INTO `account_` VALUES (20156,20154,0,'','2016-06-30 20:51:57','2016-07-05 15:51:46',0,'交通建设工程管理平台','','','','','','','','');
/*!40000 ALTER TABLE `account_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `uuid_` varchar(75) DEFAULT NULL,
  `addressId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `street1` varchar(75) DEFAULT NULL,
  `street2` varchar(75) DEFAULT NULL,
  `street3` varchar(75) DEFAULT NULL,
  `city` varchar(75) DEFAULT NULL,
  `zip` varchar(75) DEFAULT NULL,
  `regionId` bigint(20) DEFAULT NULL,
  `countryId` bigint(20) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `mailing` tinyint(4) DEFAULT NULL,
  `primary_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`addressId`),
  KEY `IX_93D5AD4E` (`companyId`),
  KEY `IX_ABD7DAC0` (`companyId`,`classNameId`),
  KEY `IX_71CB1123` (`companyId`,`classNameId`,`classPK`),
  KEY `IX_923BD178` (`companyId`,`classNameId`,`classPK`,`mailing`),
  KEY `IX_9226DBB4` (`companyId`,`classNameId`,`classPK`,`primary_`),
  KEY `IX_5BC8B0D4` (`userId`),
  KEY `IX_381E55DA` (`uuid_`),
  KEY `IX_8FCB620E` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `announcementsdelivery`
--

DROP TABLE IF EXISTS `announcementsdelivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `announcementsdelivery` (
  `deliveryId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `type_` varchar(75) DEFAULT NULL,
  `email` tinyint(4) DEFAULT NULL,
  `sms` tinyint(4) DEFAULT NULL,
  `website` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`deliveryId`),
  UNIQUE KEY `IX_BA4413D5` (`userId`,`type_`),
  KEY `IX_6EDB9600` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcementsdelivery`
--

LOCK TABLES `announcementsdelivery` WRITE;
/*!40000 ALTER TABLE `announcementsdelivery` DISABLE KEYS */;
INSERT INTO `announcementsdelivery` VALUES (20433,20154,20198,'general',0,0,1),(20434,20154,20198,'news',0,0,1),(20435,20154,20198,'test',0,0,1),(20945,20154,20939,'general',0,0,0),(20946,20154,20939,'news',0,0,0),(20947,20154,20939,'test',0,0,0);
/*!40000 ALTER TABLE `announcementsdelivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `announcementsentry`
--

DROP TABLE IF EXISTS `announcementsentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `announcementsentry` (
  `uuid_` varchar(75) DEFAULT NULL,
  `entryId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `title` varchar(75) DEFAULT NULL,
  `content` longtext,
  `url` longtext,
  `type_` varchar(75) DEFAULT NULL,
  `displayDate` datetime DEFAULT NULL,
  `expirationDate` datetime DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `alert` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`entryId`),
  KEY `IX_A6EF0B81` (`classNameId`,`classPK`),
  KEY `IX_14F06A6B` (`classNameId`,`classPK`,`alert`),
  KEY `IX_D49C2E66` (`userId`),
  KEY `IX_1AFBDE08` (`uuid_`),
  KEY `IX_F2949120` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcementsentry`
--

LOCK TABLES `announcementsentry` WRITE;
/*!40000 ALTER TABLE `announcementsentry` DISABLE KEYS */;
/*!40000 ALTER TABLE `announcementsentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `announcementsflag`
--

DROP TABLE IF EXISTS `announcementsflag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `announcementsflag` (
  `flagId` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `entryId` bigint(20) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  PRIMARY KEY (`flagId`),
  UNIQUE KEY `IX_4539A99C` (`userId`,`entryId`,`value`),
  KEY `IX_9C7EB9F` (`entryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcementsflag`
--

LOCK TABLES `announcementsflag` WRITE;
/*!40000 ALTER TABLE `announcementsflag` DISABLE KEYS */;
/*!40000 ALTER TABLE `announcementsflag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetcategory`
--

DROP TABLE IF EXISTS `assetcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetcategory` (
  `uuid_` varchar(75) DEFAULT NULL,
  `categoryId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `parentCategoryId` bigint(20) DEFAULT NULL,
  `leftCategoryId` bigint(20) DEFAULT NULL,
  `rightCategoryId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `title` longtext,
  `description` longtext,
  `vocabularyId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`categoryId`),
  UNIQUE KEY `IX_BE4DF2BF` (`parentCategoryId`,`name`,`vocabularyId`),
  UNIQUE KEY `IX_E8D019AA` (`uuid_`,`groupId`),
  KEY `IX_E639E2F6` (`groupId`),
  KEY `IX_C7F39FCA` (`groupId`,`name`,`vocabularyId`),
  KEY `IX_852EA801` (`groupId`,`parentCategoryId`,`name`,`vocabularyId`),
  KEY `IX_87603842` (`groupId`,`parentCategoryId`,`vocabularyId`),
  KEY `IX_2008FACB` (`groupId`,`vocabularyId`),
  KEY `IX_D61ABE08` (`name`,`vocabularyId`),
  KEY `IX_7BB1826B` (`parentCategoryId`),
  KEY `IX_9DDD15EA` (`parentCategoryId`,`name`),
  KEY `IX_B185E980` (`parentCategoryId`,`vocabularyId`),
  KEY `IX_4D37BB00` (`uuid_`),
  KEY `IX_BBAF6928` (`uuid_`,`companyId`),
  KEY `IX_287B1F89` (`vocabularyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetcategory`
--

LOCK TABLES `assetcategory` WRITE;
/*!40000 ALTER TABLE `assetcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetcategoryproperty`
--

DROP TABLE IF EXISTS `assetcategoryproperty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetcategoryproperty` (
  `categoryPropertyId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `categoryId` bigint(20) DEFAULT NULL,
  `key_` varchar(75) DEFAULT NULL,
  `value` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`categoryPropertyId`),
  UNIQUE KEY `IX_DBD111AA` (`categoryId`,`key_`),
  KEY `IX_99DA856` (`categoryId`),
  KEY `IX_8654719F` (`companyId`),
  KEY `IX_52340033` (`companyId`,`key_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetcategoryproperty`
--

LOCK TABLES `assetcategoryproperty` WRITE;
/*!40000 ALTER TABLE `assetcategoryproperty` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetcategoryproperty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetentries_assetcategories`
--

DROP TABLE IF EXISTS `assetentries_assetcategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetentries_assetcategories` (
  `categoryId` bigint(20) NOT NULL,
  `entryId` bigint(20) NOT NULL,
  PRIMARY KEY (`categoryId`,`entryId`),
  KEY `IX_A188F560` (`categoryId`),
  KEY `IX_E119938A` (`entryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetentries_assetcategories`
--

LOCK TABLES `assetentries_assetcategories` WRITE;
/*!40000 ALTER TABLE `assetentries_assetcategories` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetentries_assetcategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetentries_assettags`
--

DROP TABLE IF EXISTS `assetentries_assettags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetentries_assettags` (
  `entryId` bigint(20) NOT NULL,
  `tagId` bigint(20) NOT NULL,
  PRIMARY KEY (`entryId`,`tagId`),
  KEY `IX_2ED82CAD` (`entryId`),
  KEY `IX_B2A61B55` (`tagId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetentries_assettags`
--

LOCK TABLES `assetentries_assettags` WRITE;
/*!40000 ALTER TABLE `assetentries_assettags` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetentries_assettags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetentry`
--

DROP TABLE IF EXISTS `assetentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetentry` (
  `entryId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `classUuid` varchar(75) DEFAULT NULL,
  `classTypeId` bigint(20) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `publishDate` datetime DEFAULT NULL,
  `expirationDate` datetime DEFAULT NULL,
  `mimeType` varchar(75) DEFAULT NULL,
  `title` longtext,
  `description` longtext,
  `summary` longtext,
  `url` longtext,
  `layoutUuid` varchar(75) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `priority` double DEFAULT NULL,
  `viewCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`entryId`),
  UNIQUE KEY `IX_1E9D371D` (`classNameId`,`classPK`),
  KEY `IX_FC1F9C7B` (`classUuid`),
  KEY `IX_7306C60` (`companyId`),
  KEY `IX_75D42FF9` (`expirationDate`),
  KEY `IX_1EBA6821` (`groupId`,`classUuid`),
  KEY `IX_FEC4A201` (`layoutUuid`),
  KEY `IX_2E4E3885` (`publishDate`),
  KEY `IX_9029E15A` (`visible`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetentry`
--

LOCK TABLES `assetentry` WRITE;
/*!40000 ALTER TABLE `assetentry` DISABLE KEYS */;
INSERT INTO `assetentry` VALUES (20179,20172,20154,20158,'','2016-06-30 20:51:58','2016-06-30 20:51:58',20116,20177,'b0f75e85-9652-41b5-8b62-e2fcc53f5bdf',0,0,NULL,NULL,NULL,NULL,'text/html','20175','','','','',0,0,0,0),(20188,20181,20154,20158,'','2016-06-30 20:52:00','2016-06-30 20:52:00',20116,20186,'089e724b-260e-4671-9bd5-210fae19bdc9',0,0,NULL,NULL,NULL,NULL,'text/html','20184','','','','',0,0,0,0),(20204,20194,20154,20198,'Test Test','2016-06-30 20:52:00','2016-06-30 20:52:23',20005,20198,'d7b06915-181d-4d23-9831-af3d920503ef',0,0,NULL,NULL,NULL,NULL,'','Test Test','','','','',0,0,0,0),(20325,20317,20154,20158,'','2016-06-30 20:52:07','2016-06-30 20:52:07',20116,20322,'3c70f0b4-bf26-46c7-83ff-f691d746faad',0,0,NULL,NULL,NULL,NULL,'text/html','20320','','','','',0,0,0,0),(20336,20329,20154,20158,'','2016-06-30 20:52:09','2016-06-30 20:52:09',20116,20334,'28a22d2d-9a52-4768-b292-515d00c66ff7',0,0,NULL,NULL,NULL,NULL,'text/html','20332','','','','',0,0,0,0),(20346,20339,20154,20158,'','2016-06-30 20:52:11','2016-06-30 20:52:11',20116,20344,'957677a7-8c11-4987-90b2-f42ad3fc323a',0,0,NULL,NULL,NULL,NULL,'text/html','20342','','','','',0,0,0,0),(20365,20350,20154,20158,'','2016-06-30 20:52:14','2016-06-30 20:52:14',20116,20363,'22919673-c8e0-431b-a45a-4880846b975d',0,0,NULL,NULL,NULL,NULL,'text/html','20361','','','','',0,0,0,0),(20373,20350,20154,20158,'','2016-06-30 20:52:16','2016-06-30 20:52:16',20116,20371,'3188693b-f110-4428-b546-20d1b8147ea7',0,0,NULL,NULL,NULL,NULL,'text/html','20369','','','','',0,0,0,0),(20391,20376,20154,20158,'','2016-06-30 20:52:17','2016-06-30 20:52:17',20116,20389,'5024c7f1-756a-4bb5-84d1-40208be4bdce',0,0,NULL,NULL,NULL,NULL,'text/html','20387','','','','',0,0,0,0),(20400,20376,20154,20158,'','2016-06-30 20:52:19','2016-06-30 20:52:19',20116,20398,'083451d7-46ca-43f8-bb20-4d4a26743265',0,0,NULL,NULL,NULL,NULL,'text/html','20396','','','','',0,0,0,0),(20408,20376,20154,20158,'','2016-06-30 20:52:21','2016-06-30 20:52:21',20116,20406,'938bce00-c350-4c33-bf8f-cb441717daac',0,0,NULL,NULL,NULL,NULL,'text/html','20404','','','','',0,0,0,0),(20520,20201,20154,20198,'Test Test','2016-06-30 20:53:46','2016-06-30 20:53:46',20116,20518,'48261069-2927-4b3b-81ed-78be2f305da3',0,0,NULL,NULL,NULL,NULL,'text/html','20516','','','','',0,0,0,0),(20526,20201,20154,20198,'Test Test','2016-06-30 20:53:47','2016-06-30 20:53:47',20116,20524,'8b5fbac7-5d78-49dd-961f-36f9563e5abd',0,0,NULL,NULL,NULL,NULL,'text/html','20522','','','','',0,0,0,0),(20611,20194,20154,20198,'Test Test','2016-07-01 09:13:15','2016-07-01 09:13:59',20001,20608,'',0,0,NULL,NULL,NULL,NULL,'','综合信息服务系统','','','','',0,0,0,0),(20619,20608,20154,20198,'Test Test','2016-07-01 09:14:33','2016-07-01 09:14:33',20116,20617,'b4f82a08-2d22-4a3f-8f8b-1436a5ad178e',0,0,NULL,NULL,NULL,NULL,'text/html','20615','','','','',0,0,0,0),(20625,20608,20154,20198,'Test Test','2016-07-01 09:15:08','2016-07-01 09:15:08',20116,20623,'facf1101-4988-4643-a400-1c1a32569f1f',0,0,NULL,NULL,NULL,NULL,'text/html','20621','','','','',0,0,0,0),(20631,20608,20154,20198,'Test Test','2016-07-01 09:15:26','2016-07-01 09:15:26',20116,20629,'a4e68502-1d58-4a54-820c-6dececc8d893',0,0,NULL,NULL,NULL,NULL,'text/html','20627','','','','',0,0,0,0),(20637,20608,20154,20198,'Test Test','2016-07-01 09:15:50','2016-07-01 09:15:50',20116,20635,'956e4a10-57d7-4ac7-95bf-e256562310ae',0,0,NULL,NULL,NULL,NULL,'text/html','20633','','','','',0,0,0,0),(20643,20608,20154,20198,'Test Test','2016-07-01 09:16:13','2016-07-01 09:16:13',20116,20641,'6c150942-5db5-4d6f-9250-89a10a90b92b',0,0,NULL,NULL,NULL,NULL,'text/html','20639','','','','',0,0,0,0),(20649,20608,20154,20198,'Test Test','2016-07-01 09:17:03','2016-07-01 09:17:03',20116,20647,'31c0b2f0-7c84-467c-87f7-2a2ef33b2738',0,0,NULL,NULL,NULL,NULL,'text/html','20645','','','','',0,0,0,0),(20655,20608,20154,20198,'Test Test','2016-07-01 09:17:15','2016-07-01 09:17:15',20116,20653,'d4b60fac-f720-4046-9c6c-fb1f3fe61dc0',0,0,NULL,NULL,NULL,NULL,'text/html','20651','','','','',0,0,0,0),(20661,20608,20154,20198,'Test Test','2016-07-01 09:17:40','2016-07-01 09:17:40',20116,20659,'8acebfec-0261-428c-88c5-cf743812b4e8',0,0,NULL,NULL,NULL,NULL,'text/html','20657','','','','',0,0,0,0),(20667,20608,20154,20198,'Test Test','2016-07-01 09:17:59','2016-07-01 09:17:59',20116,20665,'772103bf-59c7-4c76-8260-b58057c7e30c',0,0,NULL,NULL,NULL,NULL,'text/html','20663','','','','',0,0,0,0),(20673,20608,20154,20198,'Test Test','2016-07-01 09:18:17','2016-07-01 09:18:17',20116,20671,'b5523f30-bb9d-461e-a8b2-78c735412e04',0,0,NULL,NULL,NULL,NULL,'text/html','20669','','','','',0,0,0,0),(20679,20608,20154,20198,'Test Test','2016-07-01 09:18:33','2016-07-01 09:18:33',20116,20677,'69c9a80b-e930-434d-a41f-d547c19c65c2',0,0,NULL,NULL,NULL,NULL,'text/html','20675','','','','',0,0,0,0),(20685,20608,20154,20198,'Test Test','2016-07-01 09:18:54','2016-07-01 09:18:54',20116,20683,'d3023429-e3dc-4843-a974-fecfabb97491',0,0,NULL,NULL,NULL,NULL,'text/html','20681','','','','',0,0,0,0),(20691,20608,20154,20198,'Test Test','2016-07-01 09:19:10','2016-07-01 09:19:10',20116,20689,'c5366872-d488-4d67-83c4-d2063e0e572c',0,0,NULL,NULL,NULL,NULL,'text/html','20687','','','','',0,0,0,0),(20697,20608,20154,20198,'Test Test','2016-07-01 09:19:27','2016-07-01 09:19:27',20116,20695,'798631e9-c4b0-4813-9ed3-e19ff34de68e',0,0,NULL,NULL,NULL,NULL,'text/html','20693','','','','',0,0,0,0),(20703,20608,20154,20198,'Test Test','2016-07-01 09:19:41','2016-07-01 09:19:41',20116,20701,'c3c1f1ce-7987-4093-8f9a-2fc3ed01c8ee',0,0,NULL,NULL,NULL,NULL,'text/html','20699','','','','',0,0,0,0),(20717,20608,20154,20198,'Test Test','2016-07-01 09:28:45','2016-07-01 09:28:45',20116,20715,'efa79655-a00c-444c-b46d-dc270d8eca2b',0,0,NULL,NULL,NULL,NULL,'text/html','20713','','','','',0,0,0,0),(20723,20608,20154,20198,'Test Test','2016-07-01 09:28:57','2016-07-01 09:28:57',20116,20721,'b58f3630-409b-4fb8-984b-9b24d662d269',0,0,NULL,NULL,NULL,NULL,'text/html','20719','','','','',0,0,0,0),(20729,20608,20154,20198,'Test Test','2016-07-01 09:29:21','2016-07-01 09:29:21',20116,20727,'eabff6d3-d8b7-4bfc-a7fe-44632710b808',0,0,NULL,NULL,NULL,NULL,'text/html','20725','','','','',0,0,0,0),(20734,20194,20154,20198,'Test Test','2016-07-01 09:30:12','2016-07-01 09:30:53',20001,20731,'',0,0,NULL,NULL,NULL,NULL,'','工程项目管理系统','','','','',0,0,0,0),(20738,20194,20154,20198,'Test Test','2016-07-01 09:31:13','2016-07-01 09:31:13',20001,20735,'',0,0,NULL,NULL,NULL,NULL,'','从业主体综合管理系统','','','','',0,0,0,0),(20743,20735,20154,20198,'Test Test','2016-07-01 09:32:54','2016-07-01 09:32:54',20116,20741,'1351c3df-57ea-4a3d-a3c3-6f931758de9c',0,0,NULL,NULL,NULL,NULL,'text/html','20739','','','','',0,0,0,0),(20749,20735,20154,20198,'Test Test','2016-07-01 09:33:22','2016-07-01 09:33:22',20116,20747,'342fd65e-02ca-4464-8568-2e2ee4e3acde',0,0,NULL,NULL,NULL,NULL,'text/html','20745','','','','',0,0,0,0),(20755,20735,20154,20198,'Test Test','2016-07-01 09:33:35','2016-07-01 09:33:35',20116,20753,'430c78a4-48fd-45e6-90d4-018acca3c74f',0,0,NULL,NULL,NULL,NULL,'text/html','20751','','','','',0,0,0,0),(20761,20735,20154,20198,'Test Test','2016-07-01 09:33:49','2016-07-01 09:33:49',20116,20759,'4985eb57-af43-441c-8cba-27ebb3de6b1c',0,0,NULL,NULL,NULL,NULL,'text/html','20757','','','','',0,0,0,0),(20767,20735,20154,20198,'Test Test','2016-07-01 09:34:00','2016-07-01 09:34:00',20116,20765,'39f8ac13-9653-4277-a82b-40d9d1d0a132',0,0,NULL,NULL,NULL,NULL,'text/html','20763','','','','',0,0,0,0),(20773,20735,20154,20198,'Test Test','2016-07-01 09:34:08','2016-07-01 09:34:08',20116,20771,'a6a79111-a05c-4d54-916a-e79dec90bc41',0,0,NULL,NULL,NULL,NULL,'text/html','20769','','','','',0,0,0,0),(20779,20735,20154,20198,'Test Test','2016-07-01 09:34:33','2016-07-01 09:34:33',20116,20777,'a119bf69-3a3c-43ea-bd9c-6befde4c47ba',0,0,NULL,NULL,NULL,NULL,'text/html','20775','','','','',0,0,0,0),(20787,20731,20154,20198,'Test Test','2016-07-01 09:35:16','2016-07-01 09:35:16',20116,20785,'80aaa4d9-6815-4e4a-8cea-5e5418abba1f',0,0,NULL,NULL,NULL,NULL,'text/html','20783','','','','',0,0,0,0),(20793,20731,20154,20198,'Test Test','2016-07-01 09:35:29','2016-07-01 09:35:29',20116,20791,'f6944be3-7797-4bd8-bc2b-c7f5c8e56f11',0,0,NULL,NULL,NULL,NULL,'text/html','20789','','','','',0,0,0,0),(20799,20731,20154,20198,'Test Test','2016-07-01 09:36:01','2016-07-01 09:36:01',20116,20797,'fb06cf4c-e30a-41f9-a2ad-2445ef5c11ef',0,0,NULL,NULL,NULL,NULL,'text/html','20795','','','','',0,0,0,0),(20805,20731,20154,20198,'Test Test','2016-07-01 09:36:13','2016-07-01 09:36:13',20116,20803,'4ff66e7f-9219-4a33-9ba8-d2e73842e861',0,0,NULL,NULL,NULL,NULL,'text/html','20801','','','','',0,0,0,0),(20811,20731,20154,20198,'Test Test','2016-07-01 09:36:26','2016-07-01 09:36:26',20116,20809,'ba6d965f-199e-4abb-b8a9-52dbc78a43af',0,0,NULL,NULL,NULL,NULL,'text/html','20807','','','','',0,0,0,0),(20817,20731,20154,20198,'Test Test','2016-07-01 09:36:39','2016-07-01 09:36:39',20116,20815,'97446fdc-b778-47f8-a48a-9d4b4a670119',0,0,NULL,NULL,NULL,NULL,'text/html','20813','','','','',0,0,0,0),(20825,20731,20154,20198,'Test Test','2016-07-01 09:42:09','2016-07-01 09:42:09',20116,20823,'3bd5c3e9-358c-4659-a846-6f2052fc07b5',0,0,NULL,NULL,NULL,NULL,'text/html','20821','','','','',0,0,0,0),(20827,20194,20154,20158,'','2016-07-01 09:46:02','2016-07-01 09:46:02',20001,20181,'',0,0,NULL,NULL,NULL,NULL,'','建管中心','','','','',0,0,0,0),(20859,20194,20154,20198,'Test Test','2016-07-01 10:10:00','2016-07-01 10:10:00',20003,20855,'48933aa6-117b-490d-8e7e-12eb11b6cf58',0,0,NULL,NULL,NULL,NULL,'','上海市交通建设工程管理中心','','','','',0,0,0,0),(20865,20194,20154,20198,'Test Test','2016-07-01 10:12:59','2016-07-01 10:12:59',20003,20861,'c6885686-f7c6-425a-bcc6-4c975059f053',0,0,NULL,NULL,NULL,NULL,'','中心领导','','','','',0,0,0,0),(20871,20194,20154,20198,'Test Test','2016-07-01 10:13:35','2016-07-01 10:13:35',20003,20867,'cb5da9d7-a70e-4645-aeca-ebc0793972ce',0,0,NULL,NULL,NULL,NULL,'','办公室','','','','',0,0,0,0),(20877,20194,20154,20198,'Test Test','2016-07-01 10:13:56','2016-07-01 10:14:33',20003,20873,'3333b6d3-1ea4-4b01-8033-f1f6ac768ee0',0,0,NULL,NULL,NULL,NULL,'','组织人事科（监察室）','','','','',0,0,0,0),(20885,20194,20154,20198,'Test Test','2016-07-01 10:14:52','2016-07-01 10:14:52',20003,20881,'a75e6221-1205-4c64-8a85-a84ac42b434a',0,0,NULL,NULL,NULL,NULL,'','财务科','','','','',0,0,0,0),(20891,20194,20154,20198,'Test Test','2016-07-01 10:15:08','2016-07-01 10:15:08',20003,20887,'a612be48-cffd-4817-a893-8a7bc052cfa9',0,0,NULL,NULL,NULL,NULL,'','市场监管科','','','','',0,0,0,0),(20897,20194,20154,20198,'Test Test','2016-07-01 10:15:35','2016-07-01 10:15:35',20003,20893,'2ed474e1-179e-4ecd-aa20-62c824dc2c3e',0,0,NULL,NULL,NULL,NULL,'','科技信息科','','','','',0,0,0,0),(20903,20194,20154,20198,'Test Test','2016-07-01 10:16:07','2016-07-01 10:16:07',20003,20899,'888d1563-be04-4075-90fd-328c51ce3bd8',0,0,NULL,NULL,NULL,NULL,'','综合管理科（执法监督科）','','','','',0,0,0,0),(20909,20194,20154,20198,'Test Test','2016-07-01 10:16:31','2016-07-01 10:16:31',20003,20905,'488e6c9b-ee55-4a57-b807-7aef669fe25d',0,0,NULL,NULL,NULL,NULL,'','交通工程科','','','','',0,0,0,0),(20915,20194,20154,20198,'Test Test','2016-07-01 10:16:48','2016-07-01 10:16:48',20003,20911,'21c3440d-9b4e-4ef7-9d45-4fbab0a8a134',0,0,NULL,NULL,NULL,NULL,'','市政工程科','','','','',0,0,0,0),(20944,20194,20154,20198,'Test Test','2016-07-01 14:50:31','2016-07-05 20:32:03',20005,20939,'f4b995b4-2238-4833-b610-98f97c9e5639',0,0,NULL,NULL,NULL,NULL,'','杨志杰','','','','',0,0,0,0),(21142,20731,20154,20198,'Test Test','2016-07-05 20:00:49','2016-07-05 20:00:49',20116,21140,'6a6d9bdb-a404-4d9b-a59f-204e2c79426c',0,0,NULL,NULL,NULL,NULL,'text/html','21138','','','','',0,0,0,0),(21148,20731,20154,20198,'Test Test','2016-07-05 20:01:12','2016-07-05 20:01:12',20116,21146,'865aa995-b491-4f19-a6ed-73b0b1dc6e2b',0,0,NULL,NULL,NULL,NULL,'text/html','21144','','','','',0,0,0,0),(21154,20731,20154,20198,'Test Test','2016-07-05 20:01:28','2016-07-05 20:01:28',20116,21152,'4547e974-1044-4304-a082-d86af606a2f9',0,0,NULL,NULL,NULL,NULL,'text/html','21150','','','','',0,0,0,0),(21160,20731,20154,20198,'Test Test','2016-07-05 20:02:32','2016-07-05 20:02:32',20116,21158,'09762421-bf94-4e8d-a5d6-26a0b1efdcd3',0,0,NULL,NULL,NULL,NULL,'text/html','21156','','','','',0,0,0,0),(21172,20941,20154,20939,'杨志杰','2016-07-05 20:32:14','2016-07-05 20:32:14',20116,21170,'f00028c1-e2cc-4aca-bc6c-2130c1163292',0,0,NULL,NULL,NULL,NULL,'text/html','21168','','','','',0,0,0,0),(21178,20941,20154,20939,'杨志杰','2016-07-05 20:32:15','2016-07-05 20:32:15',20116,21176,'699be20b-6043-4bf1-82da-2f67f6e8173d',0,0,NULL,NULL,NULL,NULL,'text/html','21174','','','','',0,0,0,0);
/*!40000 ALTER TABLE `assetentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetlink`
--

DROP TABLE IF EXISTS `assetlink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetlink` (
  `linkId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `entryId1` bigint(20) DEFAULT NULL,
  `entryId2` bigint(20) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`linkId`),
  UNIQUE KEY `IX_8F542794` (`entryId1`,`entryId2`,`type_`),
  KEY `IX_128516C8` (`entryId1`),
  KEY `IX_56E0AB21` (`entryId1`,`entryId2`),
  KEY `IX_14D5A20D` (`entryId1`,`type_`),
  KEY `IX_12851A89` (`entryId2`),
  KEY `IX_91F132C` (`entryId2`,`type_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetlink`
--

LOCK TABLES `assetlink` WRITE;
/*!40000 ALTER TABLE `assetlink` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetlink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assettag`
--

DROP TABLE IF EXISTS `assettag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assettag` (
  `tagId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `assetCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`tagId`),
  KEY `IX_7C9E46BA` (`groupId`),
  KEY `IX_D63322F9` (`groupId`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assettag`
--

LOCK TABLES `assettag` WRITE;
/*!40000 ALTER TABLE `assettag` DISABLE KEYS */;
/*!40000 ALTER TABLE `assettag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assettagproperty`
--

DROP TABLE IF EXISTS `assettagproperty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assettagproperty` (
  `tagPropertyId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `tagId` bigint(20) DEFAULT NULL,
  `key_` varchar(75) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tagPropertyId`),
  UNIQUE KEY `IX_2C944354` (`tagId`,`key_`),
  KEY `IX_DFF1F063` (`companyId`),
  KEY `IX_13805BF7` (`companyId`,`key_`),
  KEY `IX_3269E180` (`tagId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assettagproperty`
--

LOCK TABLES `assettagproperty` WRITE;
/*!40000 ALTER TABLE `assettagproperty` DISABLE KEYS */;
/*!40000 ALTER TABLE `assettagproperty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assettagstats`
--

DROP TABLE IF EXISTS `assettagstats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assettagstats` (
  `tagStatsId` bigint(20) NOT NULL,
  `tagId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `assetCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`tagStatsId`),
  UNIQUE KEY `IX_56682CC4` (`tagId`,`classNameId`),
  KEY `IX_50702693` (`classNameId`),
  KEY `IX_9464CA` (`tagId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assettagstats`
--

LOCK TABLES `assettagstats` WRITE;
/*!40000 ALTER TABLE `assettagstats` DISABLE KEYS */;
/*!40000 ALTER TABLE `assettagstats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetvocabulary`
--

DROP TABLE IF EXISTS `assetvocabulary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetvocabulary` (
  `uuid_` varchar(75) DEFAULT NULL,
  `vocabularyId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `title` longtext,
  `description` longtext,
  `settings_` longtext,
  PRIMARY KEY (`vocabularyId`),
  UNIQUE KEY `IX_1B2B8792` (`uuid_`,`groupId`),
  KEY `IX_B22D908C` (`companyId`),
  KEY `IX_B6B8CA0E` (`groupId`),
  KEY `IX_C0AAD74D` (`groupId`,`name`),
  KEY `IX_55F58818` (`uuid_`),
  KEY `IX_C4E6FD10` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetvocabulary`
--

LOCK TABLES `assetvocabulary` WRITE;
/*!40000 ALTER TABLE `assetvocabulary` DISABLE KEYS */;
INSERT INTO `assetvocabulary` VALUES ('3085f929-f1bc-429b-a240-aac50690491b',20324,20194,20154,20158,'','2016-06-30 20:52:07','2016-06-30 20:52:07','Topic','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Title language-id=\"zh_CN\">Topic</Title></root>','','');
/*!40000 ALTER TABLE `assetvocabulary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `backgroundtask`
--

DROP TABLE IF EXISTS `backgroundtask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `backgroundtask` (
  `backgroundTaskId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `servletContextNames` varchar(255) DEFAULT NULL,
  `taskExecutorClassName` varchar(200) DEFAULT NULL,
  `taskContext` longtext,
  `completed` tinyint(4) DEFAULT NULL,
  `completionDate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusMessage` longtext,
  PRIMARY KEY (`backgroundTaskId`),
  KEY `IX_C5A6C78F` (`companyId`),
  KEY `IX_5A09E5D1` (`groupId`),
  KEY `IX_98CC0AAB` (`groupId`,`name`,`taskExecutorClassName`),
  KEY `IX_579C63B0` (`groupId`,`name`,`taskExecutorClassName`,`completed`),
  KEY `IX_C71C3B7` (`groupId`,`status`),
  KEY `IX_A73B688A` (`groupId`,`taskExecutorClassName`),
  KEY `IX_7A9FF471` (`groupId`,`taskExecutorClassName`,`completed`),
  KEY `IX_7E757D70` (`groupId`,`taskExecutorClassName`,`status`),
  KEY `IX_C07CC7F8` (`name`),
  KEY `IX_75638CDF` (`status`),
  KEY `IX_2FCFE748` (`taskExecutorClassName`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backgroundtask`
--

LOCK TABLES `backgroundtask` WRITE;
/*!40000 ALTER TABLE `backgroundtask` DISABLE KEYS */;
/*!40000 ALTER TABLE `backgroundtask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blogsentry`
--

DROP TABLE IF EXISTS `blogsentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blogsentry` (
  `uuid_` varchar(75) DEFAULT NULL,
  `entryId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `title` varchar(150) DEFAULT NULL,
  `urlTitle` varchar(150) DEFAULT NULL,
  `description` longtext,
  `content` longtext,
  `displayDate` datetime DEFAULT NULL,
  `allowPingbacks` tinyint(4) DEFAULT NULL,
  `allowTrackbacks` tinyint(4) DEFAULT NULL,
  `trackbacks` longtext,
  `smallImage` tinyint(4) DEFAULT NULL,
  `smallImageId` bigint(20) DEFAULT NULL,
  `smallImageURL` longtext,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`entryId`),
  UNIQUE KEY `IX_DB780A20` (`groupId`,`urlTitle`),
  UNIQUE KEY `IX_1B1040FD` (`uuid_`,`groupId`),
  KEY `IX_72EF6041` (`companyId`),
  KEY `IX_430D791F` (`companyId`,`displayDate`),
  KEY `IX_BB0C2905` (`companyId`,`displayDate`,`status`),
  KEY `IX_EB2DCE27` (`companyId`,`status`),
  KEY `IX_8CACE77B` (`companyId`,`userId`),
  KEY `IX_A5F57B61` (`companyId`,`userId`,`status`),
  KEY `IX_2672F77F` (`displayDate`,`status`),
  KEY `IX_81A50303` (`groupId`),
  KEY `IX_621E19D` (`groupId`,`displayDate`),
  KEY `IX_F0E73383` (`groupId`,`displayDate`,`status`),
  KEY `IX_1EFD8EE9` (`groupId`,`status`),
  KEY `IX_FBDE0AA3` (`groupId`,`userId`,`displayDate`),
  KEY `IX_DA04F689` (`groupId`,`userId`,`displayDate`,`status`),
  KEY `IX_49E15A23` (`groupId`,`userId`,`status`),
  KEY `IX_69157A4D` (`uuid_`),
  KEY `IX_5E8307BB` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blogsentry`
--

LOCK TABLES `blogsentry` WRITE;
/*!40000 ALTER TABLE `blogsentry` DISABLE KEYS */;
/*!40000 ALTER TABLE `blogsentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blogsstatsuser`
--

DROP TABLE IF EXISTS `blogsstatsuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blogsstatsuser` (
  `statsUserId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `entryCount` int(11) DEFAULT NULL,
  `lastPostDate` datetime DEFAULT NULL,
  `ratingsTotalEntries` int(11) DEFAULT NULL,
  `ratingsTotalScore` double DEFAULT NULL,
  `ratingsAverageScore` double DEFAULT NULL,
  PRIMARY KEY (`statsUserId`),
  UNIQUE KEY `IX_82254C25` (`groupId`,`userId`),
  KEY `IX_90CDA39A` (`companyId`,`entryCount`),
  KEY `IX_43840EEB` (`groupId`),
  KEY `IX_28C78D5C` (`groupId`,`entryCount`),
  KEY `IX_BB51F1D9` (`userId`),
  KEY `IX_507BA031` (`userId`,`lastPostDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blogsstatsuser`
--

LOCK TABLES `blogsstatsuser` WRITE;
/*!40000 ALTER TABLE `blogsstatsuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `blogsstatsuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookmarksentry`
--

DROP TABLE IF EXISTS `bookmarksentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookmarksentry` (
  `uuid_` varchar(75) DEFAULT NULL,
  `entryId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `resourceBlockId` bigint(20) DEFAULT NULL,
  `folderId` bigint(20) DEFAULT NULL,
  `treePath` longtext,
  `name` varchar(255) DEFAULT NULL,
  `url` longtext,
  `description` longtext,
  `visits` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`entryId`),
  UNIQUE KEY `IX_EAA02A91` (`uuid_`,`groupId`),
  KEY `IX_1F90CA2D` (`companyId`),
  KEY `IX_276C8C13` (`companyId`,`status`),
  KEY `IX_5200100C` (`groupId`,`folderId`),
  KEY `IX_146382F2` (`groupId`,`folderId`,`status`),
  KEY `IX_416AD7D5` (`groupId`,`status`),
  KEY `IX_C78B61AC` (`groupId`,`userId`,`folderId`,`status`),
  KEY `IX_9D9CF70F` (`groupId`,`userId`,`status`),
  KEY `IX_E848278F` (`resourceBlockId`),
  KEY `IX_B670BA39` (`uuid_`),
  KEY `IX_89BEDC4F` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookmarksentry`
--

LOCK TABLES `bookmarksentry` WRITE;
/*!40000 ALTER TABLE `bookmarksentry` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookmarksentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookmarksfolder`
--

DROP TABLE IF EXISTS `bookmarksfolder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookmarksfolder` (
  `uuid_` varchar(75) DEFAULT NULL,
  `folderId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `resourceBlockId` bigint(20) DEFAULT NULL,
  `parentFolderId` bigint(20) DEFAULT NULL,
  `treePath` longtext,
  `name` varchar(75) DEFAULT NULL,
  `description` longtext,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`folderId`),
  UNIQUE KEY `IX_DC2F8927` (`uuid_`,`groupId`),
  KEY `IX_2ABA25D7` (`companyId`),
  KEY `IX_C27C9DBD` (`companyId`,`status`),
  KEY `IX_7F703619` (`groupId`),
  KEY `IX_967799C0` (`groupId`,`parentFolderId`),
  KEY `IX_D16018A6` (`groupId`,`parentFolderId`,`status`),
  KEY `IX_28A49BB9` (`resourceBlockId`),
  KEY `IX_451E7AE3` (`uuid_`),
  KEY `IX_54F0ED65` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookmarksfolder`
--

LOCK TABLES `bookmarksfolder` WRITE;
/*!40000 ALTER TABLE `bookmarksfolder` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookmarksfolder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `browsertracker`
--

DROP TABLE IF EXISTS `browsertracker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `browsertracker` (
  `browserTrackerId` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `browserKey` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`browserTrackerId`),
  UNIQUE KEY `IX_E7B95510` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `browsertracker`
--

LOCK TABLES `browsertracker` WRITE;
/*!40000 ALTER TABLE `browsertracker` DISABLE KEYS */;
INSERT INTO `browsertracker` VALUES (20602,20198,975549916899),(21181,20939,3236556652);
/*!40000 ALTER TABLE `browsertracker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendar`
--

DROP TABLE IF EXISTS `calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendar` (
  `uuid_` varchar(75) DEFAULT NULL,
  `calendarId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `resourceBlockId` bigint(20) DEFAULT NULL,
  `calendarResourceId` bigint(20) DEFAULT NULL,
  `name` longtext,
  `description` longtext,
  `timeZoneId` varchar(75) DEFAULT NULL,
  `color` int(11) DEFAULT NULL,
  `defaultCalendar` tinyint(4) DEFAULT NULL,
  `enableComments` tinyint(4) DEFAULT NULL,
  `enableRatings` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`calendarId`),
  UNIQUE KEY `IX_3AE311A` (`uuid_`,`groupId`),
  KEY `IX_B53EB0E1` (`groupId`,`calendarResourceId`),
  KEY `IX_97FC174E` (`groupId`,`calendarResourceId`,`defaultCalendar`),
  KEY `IX_F0FAF226` (`resourceBlockId`),
  KEY `IX_96C8590` (`uuid_`),
  KEY `IX_97656498` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendar`
--

LOCK TABLES `calendar` WRITE;
/*!40000 ALTER TABLE `calendar` DISABLE KEYS */;
/*!40000 ALTER TABLE `calendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendarbooking`
--

DROP TABLE IF EXISTS `calendarbooking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendarbooking` (
  `uuid_` varchar(75) DEFAULT NULL,
  `calendarBookingId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `resourceBlockId` bigint(20) DEFAULT NULL,
  `calendarId` bigint(20) DEFAULT NULL,
  `calendarResourceId` bigint(20) DEFAULT NULL,
  `parentCalendarBookingId` bigint(20) DEFAULT NULL,
  `vEventUid` varchar(255) DEFAULT NULL,
  `title` longtext,
  `description` longtext,
  `location` longtext,
  `startTime` bigint(20) DEFAULT NULL,
  `endTime` bigint(20) DEFAULT NULL,
  `allDay` tinyint(4) DEFAULT NULL,
  `recurrence` longtext,
  `firstReminder` bigint(20) DEFAULT NULL,
  `firstReminderType` varchar(75) DEFAULT NULL,
  `secondReminder` bigint(20) DEFAULT NULL,
  `secondReminderType` varchar(75) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`calendarBookingId`),
  UNIQUE KEY `IX_113A264E` (`calendarId`,`parentCalendarBookingId`),
  UNIQUE KEY `IX_8B23DA0E` (`calendarId`,`vEventUid`),
  UNIQUE KEY `IX_F4C61797` (`uuid_`,`groupId`),
  KEY `IX_D300DFCE` (`calendarId`),
  KEY `IX_470170B4` (`calendarId`,`status`),
  KEY `IX_B198FFC` (`calendarResourceId`),
  KEY `IX_57EBF55B` (`parentCalendarBookingId`),
  KEY `IX_F7B8A941` (`parentCalendarBookingId`,`status`),
  KEY `IX_22DFDB49` (`resourceBlockId`),
  KEY `IX_F6E8EE73` (`uuid_`),
  KEY `IX_A21D9FD5` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendarbooking`
--

LOCK TABLES `calendarbooking` WRITE;
/*!40000 ALTER TABLE `calendarbooking` DISABLE KEYS */;
/*!40000 ALTER TABLE `calendarbooking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendarnotificationtemplate`
--

DROP TABLE IF EXISTS `calendarnotificationtemplate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendarnotificationtemplate` (
  `uuid_` varchar(75) DEFAULT NULL,
  `calendarNotificationTemplateId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `calendarId` bigint(20) DEFAULT NULL,
  `notificationType` varchar(75) DEFAULT NULL,
  `notificationTypeSettings` varchar(75) DEFAULT NULL,
  `notificationTemplateType` varchar(75) DEFAULT NULL,
  `subject` varchar(75) DEFAULT NULL,
  `body` longtext,
  PRIMARY KEY (`calendarNotificationTemplateId`),
  UNIQUE KEY `IX_4012E97F` (`uuid_`,`groupId`),
  KEY `IX_A412E5B6` (`calendarId`),
  KEY `IX_7727A482` (`calendarId`,`notificationType`,`notificationTemplateType`),
  KEY `IX_A2D4D78B` (`uuid_`),
  KEY `IX_4D7D97BD` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendarnotificationtemplate`
--

LOCK TABLES `calendarnotificationtemplate` WRITE;
/*!40000 ALTER TABLE `calendarnotificationtemplate` DISABLE KEYS */;
/*!40000 ALTER TABLE `calendarnotificationtemplate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendarresource`
--

DROP TABLE IF EXISTS `calendarresource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendarresource` (
  `uuid_` varchar(75) DEFAULT NULL,
  `calendarResourceId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `resourceBlockId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `classUuid` varchar(75) DEFAULT NULL,
  `code_` varchar(75) DEFAULT NULL,
  `name` longtext,
  `description` longtext,
  `active_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`calendarResourceId`),
  UNIQUE KEY `IX_16A12327` (`classNameId`,`classPK`),
  UNIQUE KEY `IX_4ABD2BC8` (`uuid_`,`groupId`),
  KEY `IX_76DDD0F7` (`active_`),
  KEY `IX_4470A59D` (`companyId`,`code_`,`active_`),
  KEY `IX_1243D698` (`groupId`),
  KEY `IX_40678371` (`groupId`,`active_`),
  KEY `IX_55C2F8AA` (`groupId`,`code_`),
  KEY `IX_8BCB4D38` (`resourceBlockId`),
  KEY `IX_150E2F22` (`uuid_`),
  KEY `IX_56A06BC6` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendarresource`
--

LOCK TABLES `calendarresource` WRITE;
/*!40000 ALTER TABLE `calendarresource` DISABLE KEYS */;
/*!40000 ALTER TABLE `calendarresource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calevent`
--

DROP TABLE IF EXISTS `calevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calevent` (
  `uuid_` varchar(75) DEFAULT NULL,
  `eventId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `title` varchar(75) DEFAULT NULL,
  `description` longtext,
  `location` longtext,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `durationHour` int(11) DEFAULT NULL,
  `durationMinute` int(11) DEFAULT NULL,
  `allDay` tinyint(4) DEFAULT NULL,
  `timeZoneSensitive` tinyint(4) DEFAULT NULL,
  `type_` varchar(75) DEFAULT NULL,
  `repeating` tinyint(4) DEFAULT NULL,
  `recurrence` longtext,
  `remindBy` int(11) DEFAULT NULL,
  `firstReminder` int(11) DEFAULT NULL,
  `secondReminder` int(11) DEFAULT NULL,
  PRIMARY KEY (`eventId`),
  UNIQUE KEY `IX_5CCE79C8` (`uuid_`,`groupId`),
  KEY `IX_D6FD9496` (`companyId`),
  KEY `IX_12EE4898` (`groupId`),
  KEY `IX_4FDDD2BF` (`groupId`,`repeating`),
  KEY `IX_FCD7C63D` (`groupId`,`type_`),
  KEY `IX_FD93CBFA` (`groupId`,`type_`,`repeating`),
  KEY `IX_F6006202` (`remindBy`),
  KEY `IX_C1AD2122` (`uuid_`),
  KEY `IX_299639C6` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calevent`
--

LOCK TABLES `calevent` WRITE;
/*!40000 ALTER TABLE `calevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `calevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classname_`
--

DROP TABLE IF EXISTS `classname_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classname_` (
  `classNameId` bigint(20) NOT NULL,
  `value` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`classNameId`),
  UNIQUE KEY `IX_B27A301F` (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classname_`
--

LOCK TABLES `classname_` WRITE;
/*!40000 ALTER TABLE `classname_` DISABLE KEYS */;
INSERT INTO `classname_` VALUES (21101,'com.justonetech.oa.model.DeptWork'),(21102,'com.justonetech.oa.model.DeptWorkItem'),(21103,'com.justonetech.oa.model.Dispatch'),(21104,'com.justonetech.oa.model.LeaderWork'),(21105,'com.justonetech.oa.model.OfficeSupply'),(21106,'com.justonetech.oa.model.OfficeSupplyRequisition'),(21107,'com.justonetech.oa.model.OfficeSupplyRequisitionItem'),(21108,'com.justonetech.oa.model.VehicleRequisition'),(21004,'com.justonetech.sys.model.Dictionary'),(20443,'com.liferay.calendar.model.Calendar'),(20444,'com.liferay.calendar.model.CalendarBooking'),(20445,'com.liferay.calendar.model.CalendarNotificationTemplate'),(20446,'com.liferay.calendar.model.CalendarResource'),(20017,'com.liferay.counter.model.Counter'),(20437,'com.liferay.marketplace.model.App'),(20438,'com.liferay.marketplace.model.Module'),(20473,'com.liferay.notifications.model.UserNotificationEvent'),(20501,'com.liferay.opensocial.model.Gadget'),(20502,'com.liferay.opensocial.model.OAuthConsumer'),(20503,'com.liferay.opensocial.model.OAuthToken'),(20422,'com.liferay.portal.kernel.repository.model.FileEntry'),(20018,'com.liferay.portal.kernel.workflow.WorkflowTask'),(20019,'com.liferay.portal.model.Account'),(20020,'com.liferay.portal.model.Address'),(20021,'com.liferay.portal.model.BackgroundTask'),(20022,'com.liferay.portal.model.BrowserTracker'),(20023,'com.liferay.portal.model.ClassName'),(20024,'com.liferay.portal.model.ClusterGroup'),(20025,'com.liferay.portal.model.Company'),(20026,'com.liferay.portal.model.Contact'),(20027,'com.liferay.portal.model.Country'),(20028,'com.liferay.portal.model.EmailAddress'),(20001,'com.liferay.portal.model.Group'),(20029,'com.liferay.portal.model.Image'),(20002,'com.liferay.portal.model.Layout'),(20030,'com.liferay.portal.model.LayoutBranch'),(20031,'com.liferay.portal.model.LayoutFriendlyURL'),(20032,'com.liferay.portal.model.LayoutPrototype'),(20033,'com.liferay.portal.model.LayoutRevision'),(20034,'com.liferay.portal.model.LayoutSet'),(20035,'com.liferay.portal.model.LayoutSetBranch'),(20036,'com.liferay.portal.model.LayoutSetPrototype'),(20037,'com.liferay.portal.model.ListType'),(20038,'com.liferay.portal.model.Lock'),(20039,'com.liferay.portal.model.MembershipRequest'),(20003,'com.liferay.portal.model.Organization'),(20040,'com.liferay.portal.model.OrgGroupRole'),(20041,'com.liferay.portal.model.OrgLabor'),(20042,'com.liferay.portal.model.PasswordPolicy'),(20043,'com.liferay.portal.model.PasswordPolicyRel'),(20044,'com.liferay.portal.model.PasswordTracker'),(20045,'com.liferay.portal.model.Phone'),(20046,'com.liferay.portal.model.PluginSetting'),(20047,'com.liferay.portal.model.PortalPreferences'),(20048,'com.liferay.portal.model.Portlet'),(20049,'com.liferay.portal.model.PortletItem'),(20050,'com.liferay.portal.model.PortletPreferences'),(20051,'com.liferay.portal.model.Region'),(20052,'com.liferay.portal.model.Release'),(20053,'com.liferay.portal.model.Repository'),(20054,'com.liferay.portal.model.RepositoryEntry'),(20055,'com.liferay.portal.model.ResourceAction'),(20056,'com.liferay.portal.model.ResourceBlock'),(20057,'com.liferay.portal.model.ResourceBlockPermission'),(20058,'com.liferay.portal.model.ResourcePermission'),(20059,'com.liferay.portal.model.ResourceTypePermission'),(20004,'com.liferay.portal.model.Role'),(20060,'com.liferay.portal.model.ServiceComponent'),(20061,'com.liferay.portal.model.Shard'),(20062,'com.liferay.portal.model.Subscription'),(20063,'com.liferay.portal.model.SystemEvent'),(20064,'com.liferay.portal.model.Team'),(20065,'com.liferay.portal.model.Ticket'),(20005,'com.liferay.portal.model.User'),(20006,'com.liferay.portal.model.UserGroup'),(20066,'com.liferay.portal.model.UserGroupGroupRole'),(20067,'com.liferay.portal.model.UserGroupRole'),(20068,'com.liferay.portal.model.UserIdMapper'),(20069,'com.liferay.portal.model.UserNotificationDelivery'),(20070,'com.liferay.portal.model.UserNotificationEvent'),(20190,'com.liferay.portal.model.UserPersonalSite'),(20071,'com.liferay.portal.model.UserTracker'),(20072,'com.liferay.portal.model.UserTrackerPath'),(20073,'com.liferay.portal.model.VirtualHost'),(20074,'com.liferay.portal.model.WebDAVProps'),(20075,'com.liferay.portal.model.Website'),(20076,'com.liferay.portal.model.WorkflowDefinitionLink'),(20077,'com.liferay.portal.model.WorkflowInstanceLink'),(20846,'com.liferay.portal.repository.liferayrepository.LiferayRepository'),(20450,'com.liferay.portal.workflow.kaleo.model.KaleoAction'),(20451,'com.liferay.portal.workflow.kaleo.model.KaleoCondition'),(20452,'com.liferay.portal.workflow.kaleo.model.KaleoDefinition'),(20453,'com.liferay.portal.workflow.kaleo.model.KaleoInstance'),(20454,'com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken'),(20455,'com.liferay.portal.workflow.kaleo.model.KaleoLog'),(20456,'com.liferay.portal.workflow.kaleo.model.KaleoNode'),(20457,'com.liferay.portal.workflow.kaleo.model.KaleoNotification'),(20458,'com.liferay.portal.workflow.kaleo.model.KaleoNotificationRecipient'),(20459,'com.liferay.portal.workflow.kaleo.model.KaleoTask'),(20460,'com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment'),(20461,'com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignmentInstance'),(20462,'com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken'),(20463,'com.liferay.portal.workflow.kaleo.model.KaleoTimer'),(20464,'com.liferay.portal.workflow.kaleo.model.KaleoTimerInstanceToken'),(20465,'com.liferay.portal.workflow.kaleo.model.KaleoTransition'),(20078,'com.liferay.portlet.announcements.model.AnnouncementsDelivery'),(20079,'com.liferay.portlet.announcements.model.AnnouncementsEntry'),(20080,'com.liferay.portlet.announcements.model.AnnouncementsFlag'),(20081,'com.liferay.portlet.asset.model.AssetCategory'),(20082,'com.liferay.portlet.asset.model.AssetCategoryProperty'),(20083,'com.liferay.portlet.asset.model.AssetEntry'),(20084,'com.liferay.portlet.asset.model.AssetLink'),(20085,'com.liferay.portlet.asset.model.AssetTag'),(20086,'com.liferay.portlet.asset.model.AssetTagProperty'),(20087,'com.liferay.portlet.asset.model.AssetTagStats'),(20088,'com.liferay.portlet.asset.model.AssetVocabulary'),(20007,'com.liferay.portlet.blogs.model.BlogsEntry'),(20089,'com.liferay.portlet.blogs.model.BlogsStatsUser'),(20008,'com.liferay.portlet.bookmarks.model.BookmarksEntry'),(20009,'com.liferay.portlet.bookmarks.model.BookmarksFolder'),(20010,'com.liferay.portlet.calendar.model.CalEvent'),(20090,'com.liferay.portlet.documentlibrary.model.DLContent'),(20011,'com.liferay.portlet.documentlibrary.model.DLFileEntry'),(20091,'com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata'),(20092,'com.liferay.portlet.documentlibrary.model.DLFileEntryType'),(20093,'com.liferay.portlet.documentlibrary.model.DLFileRank'),(20094,'com.liferay.portlet.documentlibrary.model.DLFileShortcut'),(20095,'com.liferay.portlet.documentlibrary.model.DLFileVersion'),(20012,'com.liferay.portlet.documentlibrary.model.DLFolder'),(20096,'com.liferay.portlet.documentlibrary.model.DLSyncEvent'),(20314,'com.liferay.portlet.documentlibrary.util.RawMetadataProcessor'),(20097,'com.liferay.portlet.dynamicdatalists.model.DDLRecord'),(20098,'com.liferay.portlet.dynamicdatalists.model.DDLRecordSet'),(20099,'com.liferay.portlet.dynamicdatalists.model.DDLRecordVersion'),(20100,'com.liferay.portlet.dynamicdatamapping.model.DDMContent'),(20101,'com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink'),(20102,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure'),(20103,'com.liferay.portlet.dynamicdatamapping.model.DDMStructureLink'),(20104,'com.liferay.portlet.dynamicdatamapping.model.DDMTemplate'),(20105,'com.liferay.portlet.expando.model.ExpandoColumn'),(20106,'com.liferay.portlet.expando.model.ExpandoRow'),(20107,'com.liferay.portlet.expando.model.ExpandoTable'),(20108,'com.liferay.portlet.expando.model.ExpandoValue'),(20109,'com.liferay.portlet.journal.model.JournalArticle'),(20110,'com.liferay.portlet.journal.model.JournalArticleImage'),(20111,'com.liferay.portlet.journal.model.JournalArticleResource'),(20112,'com.liferay.portlet.journal.model.JournalContentSearch'),(20113,'com.liferay.portlet.journal.model.JournalFeed'),(20013,'com.liferay.portlet.journal.model.JournalFolder'),(20114,'com.liferay.portlet.messageboards.model.MBBan'),(20115,'com.liferay.portlet.messageboards.model.MBCategory'),(20116,'com.liferay.portlet.messageboards.model.MBDiscussion'),(20117,'com.liferay.portlet.messageboards.model.MBMailingList'),(20014,'com.liferay.portlet.messageboards.model.MBMessage'),(20118,'com.liferay.portlet.messageboards.model.MBStatsUser'),(20015,'com.liferay.portlet.messageboards.model.MBThread'),(20119,'com.liferay.portlet.messageboards.model.MBThreadFlag'),(20120,'com.liferay.portlet.mobiledevicerules.model.MDRAction'),(20121,'com.liferay.portlet.mobiledevicerules.model.MDRRule'),(20122,'com.liferay.portlet.mobiledevicerules.model.MDRRuleGroup'),(20123,'com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance'),(20124,'com.liferay.portlet.polls.model.PollsChoice'),(20125,'com.liferay.portlet.polls.model.PollsQuestion'),(20126,'com.liferay.portlet.polls.model.PollsVote'),(20127,'com.liferay.portlet.ratings.model.RatingsEntry'),(20128,'com.liferay.portlet.ratings.model.RatingsStats'),(20129,'com.liferay.portlet.shopping.model.ShoppingCart'),(20130,'com.liferay.portlet.shopping.model.ShoppingCategory'),(20131,'com.liferay.portlet.shopping.model.ShoppingCoupon'),(20132,'com.liferay.portlet.shopping.model.ShoppingItem'),(20133,'com.liferay.portlet.shopping.model.ShoppingItemField'),(20134,'com.liferay.portlet.shopping.model.ShoppingItemPrice'),(20135,'com.liferay.portlet.shopping.model.ShoppingOrder'),(20136,'com.liferay.portlet.shopping.model.ShoppingOrderItem'),(20137,'com.liferay.portlet.social.model.SocialActivity'),(20138,'com.liferay.portlet.social.model.SocialActivityAchievement'),(20139,'com.liferay.portlet.social.model.SocialActivityCounter'),(20140,'com.liferay.portlet.social.model.SocialActivityLimit'),(20141,'com.liferay.portlet.social.model.SocialActivitySet'),(20142,'com.liferay.portlet.social.model.SocialActivitySetting'),(20143,'com.liferay.portlet.social.model.SocialRelation'),(20144,'com.liferay.portlet.social.model.SocialRequest'),(20145,'com.liferay.portlet.softwarecatalog.model.SCFrameworkVersion'),(20146,'com.liferay.portlet.softwarecatalog.model.SCLicense'),(20147,'com.liferay.portlet.softwarecatalog.model.SCProductEntry'),(20148,'com.liferay.portlet.softwarecatalog.model.SCProductScreenshot'),(20149,'com.liferay.portlet.softwarecatalog.model.SCProductVersion'),(20150,'com.liferay.portlet.trash.model.TrashEntry'),(20151,'com.liferay.portlet.trash.model.TrashVersion'),(20152,'com.liferay.portlet.wiki.model.WikiNode'),(20016,'com.liferay.portlet.wiki.model.WikiPage'),(20153,'com.liferay.portlet.wiki.model.WikiPageResource'),(20511,'com.liferay.sync.model.SyncDLFileVersionDiff'),(20512,'com.liferay.sync.model.SyncDLObject');
/*!40000 ALTER TABLE `classname_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clustergroup`
--

DROP TABLE IF EXISTS `clustergroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clustergroup` (
  `clusterGroupId` bigint(20) NOT NULL,
  `name` varchar(75) DEFAULT NULL,
  `clusterNodeIds` varchar(75) DEFAULT NULL,
  `wholeCluster` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`clusterGroupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clustergroup`
--

LOCK TABLES `clustergroup` WRITE;
/*!40000 ALTER TABLE `clustergroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `clustergroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `companyId` bigint(20) NOT NULL,
  `accountId` bigint(20) DEFAULT NULL,
  `webId` varchar(75) DEFAULT NULL,
  `key_` longtext,
  `mx` varchar(75) DEFAULT NULL,
  `homeURL` longtext,
  `logoId` bigint(20) DEFAULT NULL,
  `system` tinyint(4) DEFAULT NULL,
  `maxUsers` int(11) DEFAULT NULL,
  `active_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`companyId`),
  UNIQUE KEY `IX_EC00543C` (`webId`),
  KEY `IX_38EFE3FD` (`logoId`),
  KEY `IX_12566EC2` (`mx`),
  KEY `IX_35E3E7C6` (`system`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (20154,20156,'liferay.com','rO0ABXNyAB9qYXZheC5jcnlwdG8uc3BlYy5TZWNyZXRLZXlTcGVjW0cLZuIwYU0CAAJMAAlhbGdvcml0aG10ABJMamF2YS9sYW5nL1N0cmluZztbAANrZXl0AAJbQnhwdAADQUVTdXIAAltCrPMX+AYIVOACAAB4cAAAABCKRjG8CfL9hR3Le9og3pI5','liferay.com','/web/jtjs/home',0,0,0,1);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_`
--

DROP TABLE IF EXISTS `contact_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_` (
  `contactId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `accountId` bigint(20) DEFAULT NULL,
  `parentContactId` bigint(20) DEFAULT NULL,
  `emailAddress` varchar(75) DEFAULT NULL,
  `firstName` varchar(75) DEFAULT NULL,
  `middleName` varchar(75) DEFAULT NULL,
  `lastName` varchar(75) DEFAULT NULL,
  `prefixId` int(11) DEFAULT NULL,
  `suffixId` int(11) DEFAULT NULL,
  `male` tinyint(4) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `smsSn` varchar(75) DEFAULT NULL,
  `aimSn` varchar(75) DEFAULT NULL,
  `facebookSn` varchar(75) DEFAULT NULL,
  `icqSn` varchar(75) DEFAULT NULL,
  `jabberSn` varchar(75) DEFAULT NULL,
  `msnSn` varchar(75) DEFAULT NULL,
  `mySpaceSn` varchar(75) DEFAULT NULL,
  `skypeSn` varchar(75) DEFAULT NULL,
  `twitterSn` varchar(75) DEFAULT NULL,
  `ymSn` varchar(75) DEFAULT NULL,
  `employeeStatusId` varchar(75) DEFAULT NULL,
  `employeeNumber` varchar(75) DEFAULT NULL,
  `jobTitle` varchar(100) DEFAULT NULL,
  `jobClass` varchar(75) DEFAULT NULL,
  `hoursOfOperation` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`contactId`),
  KEY `IX_B8C28C53` (`accountId`),
  KEY `IX_791914FA` (`classNameId`,`classPK`),
  KEY `IX_66D496A3` (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_`
--

LOCK TABLES `contact_` WRITE;
/*!40000 ALTER TABLE `contact_` DISABLE KEYS */;
INSERT INTO `contact_` VALUES (20159,20154,20158,'','2016-06-30 20:51:57','2016-06-30 20:51:57',20005,20158,20156,0,'default@liferay.com','','','',0,0,1,'2016-06-30 20:51:57','','','','','','','','','','','','','','',''),(20200,20154,20198,'','2016-06-30 20:52:00','2016-06-30 20:52:23',20005,20198,20156,0,'test@liferay.com','Test','','Test',0,0,1,'1970-01-01 00:00:00','','','','','','','','','','','','','','',''),(20940,20154,20198,'Test Test','2016-07-01 14:50:31','2016-07-05 20:32:03',20005,20939,20156,0,'yangzhijie@liferay.com','杨志杰','','',0,0,1,'1970-01-01 00:00:00','','','','','','','','','','','','','','','');
/*!40000 ALTER TABLE `contact_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counter`
--

DROP TABLE IF EXISTS `counter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `counter` (
  `name` varchar(75) NOT NULL,
  `currentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counter`
--

LOCK TABLES `counter` WRITE;
/*!40000 ALTER TABLE `counter` DISABLE KEYS */;
INSERT INTO `counter` VALUES ('com.liferay.counter.model.Counter',21200),('com.liferay.portal.model.Layout#20172#true',1),('com.liferay.portal.model.Layout#20181#false',1),('com.liferay.portal.model.Layout#20201#false',1),('com.liferay.portal.model.Layout#20201#true',1),('com.liferay.portal.model.Layout#20317#true',1),('com.liferay.portal.model.Layout#20329#true',1),('com.liferay.portal.model.Layout#20339#true',1),('com.liferay.portal.model.Layout#20350#true',2),('com.liferay.portal.model.Layout#20376#true',3),('com.liferay.portal.model.Layout#20608#false',1),('com.liferay.portal.model.Layout#20608#true',17),('com.liferay.portal.model.Layout#20731#false',1),('com.liferay.portal.model.Layout#20731#true',10),('com.liferay.portal.model.Layout#20735#false',2),('com.liferay.portal.model.Layout#20735#true',5),('com.liferay.portal.model.Layout#20941#false',1),('com.liferay.portal.model.Layout#20941#true',1),('com.liferay.portal.model.ResourceAction',1400),('com.liferay.portal.model.ResourcePermission',1000);
/*!40000 ALTER TABLE `counter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `countryId` bigint(20) NOT NULL,
  `name` varchar(75) DEFAULT NULL,
  `a2` varchar(75) DEFAULT NULL,
  `a3` varchar(75) DEFAULT NULL,
  `number_` varchar(75) DEFAULT NULL,
  `idd_` varchar(75) DEFAULT NULL,
  `zipRequired` tinyint(4) DEFAULT NULL,
  `active_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`countryId`),
  UNIQUE KEY `IX_717B97E1` (`a2`),
  UNIQUE KEY `IX_717B9BA2` (`a3`),
  UNIQUE KEY `IX_19DA007B` (`name`),
  KEY `IX_25D734CD` (`active_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'canada','CA','CAN','124','001',1,1),(2,'china','CN','CHN','156','086',1,1),(3,'france','FR','FRA','250','033',1,1),(4,'germany','DE','DEU','276','049',1,1),(5,'hong-kong','HK','HKG','344','852',1,1),(6,'hungary','HU','HUN','348','036',1,1),(7,'israel','IL','ISR','376','972',1,1),(8,'italy','IT','ITA','380','039',1,1),(9,'japan','JP','JPN','392','081',0,1),(10,'south-korea','KR','KOR','410','082',1,1),(11,'netherlands','NL','NLD','528','031',1,1),(12,'portugal','PT','PRT','620','351',1,1),(13,'russia','RU','RUS','643','007',1,1),(14,'singapore','SG','SGP','702','065',1,1),(15,'spain','ES','ESP','724','034',1,1),(16,'turkey','TR','TUR','792','090',1,1),(17,'vietnam','VN','VNM','704','084',1,1),(18,'united-kingdom','GB','GBR','826','044',1,1),(19,'united-states','US','USA','840','001',1,1),(20,'afghanistan','AF','AFG','4','093',1,1),(21,'albania','AL','ALB','8','355',1,1),(22,'algeria','DZ','DZA','12','213',1,1),(23,'american-samoa','AS','ASM','16','684',1,1),(24,'andorra','AD','AND','20','376',1,1),(25,'angola','AO','AGO','24','244',0,1),(26,'anguilla','AI','AIA','660','264',1,1),(27,'antarctica','AQ','ATA','10','672',1,1),(28,'antigua-barbuda','AG','ATG','28','268',0,1),(29,'argentina','AR','ARG','32','054',1,1),(30,'armenia','AM','ARM','51','374',1,1),(31,'aruba','AW','ABW','533','297',0,1),(32,'australia','AU','AUS','36','061',1,1),(33,'austria','AT','AUT','40','043',1,1),(34,'azerbaijan','AZ','AZE','31','994',1,1),(35,'bahamas','BS','BHS','44','242',0,1),(36,'bahrain','BH','BHR','48','973',1,1),(37,'bangladesh','BD','BGD','50','880',1,1),(38,'barbados','BB','BRB','52','246',1,1),(39,'belarus','BY','BLR','112','375',1,1),(40,'belgium','BE','BEL','56','032',1,1),(41,'belize','BZ','BLZ','84','501',0,1),(42,'benin','BJ','BEN','204','229',0,1),(43,'bermuda','BM','BMU','60','441',1,1),(44,'bhutan','BT','BTN','64','975',1,1),(45,'bolivia','BO','BOL','68','591',1,1),(46,'bosnia-herzegovina','BA','BIH','70','387',1,1),(47,'botswana','BW','BWA','72','267',0,1),(48,'brazil','BR','BRA','76','055',1,1),(49,'british-virgin-islands','VG','VGB','92','284',1,1),(50,'brunei','BN','BRN','96','673',1,1),(51,'bulgaria','BG','BGR','100','359',1,1),(52,'burkina-faso','BF','BFA','854','226',0,1),(53,'burma-myanmar','MM','MMR','104','095',1,1),(54,'burundi','BI','BDI','108','257',0,1),(55,'cambodia','KH','KHM','116','855',1,1),(56,'cameroon','CM','CMR','120','237',1,1),(57,'cape-verde-island','CV','CPV','132','238',1,1),(58,'cayman-islands','KY','CYM','136','345',1,1),(59,'central-african-republic','CF','CAF','140','236',0,1),(60,'chad','TD','TCD','148','235',1,1),(61,'chile','CL','CHL','152','056',1,1),(62,'christmas-island','CX','CXR','162','061',1,1),(63,'cocos-islands','CC','CCK','166','061',1,1),(64,'colombia','CO','COL','170','057',1,1),(65,'comoros','KM','COM','174','269',0,1),(66,'republic-of-congo','CD','COD','180','242',0,1),(67,'democratic-republic-of-congo','CG','COG','178','243',0,1),(68,'cook-islands','CK','COK','184','682',0,1),(69,'costa-rica','CR','CRI','188','506',1,1),(70,'croatia','HR','HRV','191','385',1,1),(71,'cuba','CU','CUB','192','053',1,1),(72,'cyprus','CY','CYP','196','357',1,1),(73,'czech-republic','CZ','CZE','203','420',1,1),(74,'denmark','DK','DNK','208','045',1,1),(75,'djibouti','DJ','DJI','262','253',0,1),(76,'dominica','DM','DMA','212','767',0,1),(77,'dominican-republic','DO','DOM','214','809',1,1),(78,'ecuador','EC','ECU','218','593',1,1),(79,'egypt','EG','EGY','818','020',1,1),(80,'el-salvador','SV','SLV','222','503',1,1),(81,'equatorial-guinea','GQ','GNQ','226','240',0,1),(82,'eritrea','ER','ERI','232','291',0,1),(83,'estonia','EE','EST','233','372',1,1),(84,'ethiopia','ET','ETH','231','251',1,1),(85,'faeroe-islands','FO','FRO','234','298',1,1),(86,'falkland-islands','FK','FLK','238','500',1,1),(87,'fiji-islands','FJ','FJI','242','679',0,1),(88,'finland','FI','FIN','246','358',1,1),(89,'french-guiana','GF','GUF','254','594',1,1),(90,'french-polynesia','PF','PYF','258','689',1,1),(91,'gabon','GA','GAB','266','241',1,1),(92,'gambia','GM','GMB','270','220',0,1),(93,'georgia','GE','GEO','268','995',1,1),(94,'ghana','GH','GHA','288','233',0,1),(95,'gibraltar','GI','GIB','292','350',1,1),(96,'greece','GR','GRC','300','030',1,1),(97,'greenland','GL','GRL','304','299',1,1),(98,'grenada','GD','GRD','308','473',0,1),(99,'guadeloupe','GP','GLP','312','590',1,1),(100,'guam','GU','GUM','316','671',1,1),(101,'guatemala','GT','GTM','320','502',1,1),(102,'guinea','GN','GIN','324','224',0,1),(103,'guinea-bissau','GW','GNB','624','245',1,1),(104,'guyana','GY','GUY','328','592',0,1),(105,'haiti','HT','HTI','332','509',1,1),(106,'honduras','HN','HND','340','504',1,1),(107,'iceland','IS','ISL','352','354',1,1),(108,'india','IN','IND','356','091',1,1),(109,'indonesia','ID','IDN','360','062',1,1),(110,'iran','IR','IRN','364','098',1,1),(111,'iraq','IQ','IRQ','368','964',1,1),(112,'ireland','IE','IRL','372','353',0,1),(113,'ivory-coast','CI','CIV','384','225',1,1),(114,'jamaica','JM','JAM','388','876',1,1),(115,'jordan','JO','JOR','400','962',1,1),(116,'kazakhstan','KZ','KAZ','398','007',1,1),(117,'kenya','KE','KEN','404','254',1,1),(118,'kiribati','KI','KIR','408','686',0,1),(119,'kuwait','KW','KWT','414','965',1,1),(120,'north-korea','KP','PRK','408','850',0,1),(121,'kyrgyzstan','KG','KGZ','471','996',1,1),(122,'laos','LA','LAO','418','856',1,1),(123,'latvia','LV','LVA','428','371',1,1),(124,'lebanon','LB','LBN','422','961',1,1),(125,'lesotho','LS','LSO','426','266',1,1),(126,'liberia','LR','LBR','430','231',1,1),(127,'libya','LY','LBY','434','218',1,1),(128,'liechtenstein','LI','LIE','438','423',1,1),(129,'lithuania','LT','LTU','440','370',1,1),(130,'luxembourg','LU','LUX','442','352',1,1),(131,'macau','MO','MAC','446','853',0,1),(132,'macedonia','MK','MKD','807','389',1,1),(133,'madagascar','MG','MDG','450','261',1,1),(134,'malawi','MW','MWI','454','265',0,1),(135,'malaysia','MY','MYS','458','060',1,1),(136,'maldives','MV','MDV','462','960',1,1),(137,'mali','ML','MLI','466','223',0,1),(138,'malta','MT','MLT','470','356',1,1),(139,'marshall-islands','MH','MHL','584','692',1,1),(140,'martinique','MQ','MTQ','474','596',1,1),(141,'mauritania','MR','MRT','478','222',0,1),(142,'mauritius','MU','MUS','480','230',0,1),(143,'mayotte-island','YT','MYT','175','269',1,1),(144,'mexico','MX','MEX','484','052',1,1),(145,'micronesia','FM','FSM','583','691',1,1),(146,'moldova','MD','MDA','498','373',1,1),(147,'monaco','MC','MCO','492','377',1,1),(148,'mongolia','MN','MNG','496','976',1,1),(149,'montenegro','ME','MNE','499','382',1,1),(150,'montserrat','MS','MSR','500','664',0,1),(151,'morocco','MA','MAR','504','212',1,1),(152,'mozambique','MZ','MOZ','508','258',1,1),(153,'namibia','NA','NAM','516','264',1,1),(154,'nauru','NR','NRU','520','674',0,1),(155,'nepal','NP','NPL','524','977',1,1),(156,'netherlands-antilles','AN','ANT','530','599',1,1),(157,'new-caledonia','NC','NCL','540','687',1,1),(158,'new-zealand','NZ','NZL','554','064',1,1),(159,'nicaragua','NI','NIC','558','505',1,1),(160,'niger','NE','NER','562','227',1,1),(161,'nigeria','NG','NGA','566','234',1,1),(162,'niue','NU','NIU','570','683',0,1),(163,'norfolk-island','NF','NFK','574','672',1,1),(164,'norway','NO','NOR','578','047',1,1),(165,'oman','OM','OMN','512','968',1,1),(166,'pakistan','PK','PAK','586','092',1,1),(167,'palau','PW','PLW','585','680',1,1),(168,'palestine','PS','PSE','275','970',1,1),(169,'panama','PA','PAN','591','507',1,1),(170,'papua-new-guinea','PG','PNG','598','675',1,1),(171,'paraguay','PY','PRY','600','595',1,1),(172,'peru','PE','PER','604','051',1,1),(173,'philippines','PH','PHL','608','063',1,1),(174,'poland','PL','POL','616','048',1,1),(175,'puerto-rico','PR','PRI','630','787',1,1),(176,'qatar','QA','QAT','634','974',0,1),(177,'reunion-island','RE','REU','638','262',1,1),(178,'romania','RO','ROU','642','040',1,1),(179,'rwanda','RW','RWA','646','250',0,1),(180,'st-helena','SH','SHN','654','290',1,1),(181,'st-kitts','KN','KNA','659','869',0,1),(182,'st-lucia','LC','LCA','662','758',0,1),(183,'st-pierre-miquelon','PM','SPM','666','508',1,1),(184,'st-vincent','VC','VCT','670','784',1,1),(185,'san-marino','SM','SMR','674','378',1,1),(186,'sao-tome-principe','ST','STP','678','239',0,1),(187,'saudi-arabia','SA','SAU','682','966',1,1),(188,'senegal','SN','SEN','686','221',1,1),(189,'serbia','RS','SRB','688','381',1,1),(190,'seychelles','SC','SYC','690','248',0,1),(191,'sierra-leone','SL','SLE','694','249',0,1),(192,'slovakia','SK','SVK','703','421',1,1),(193,'slovenia','SI','SVN','705','386',1,1),(194,'solomon-islands','SB','SLB','90','677',0,1),(195,'somalia','SO','SOM','706','252',0,1),(196,'south-africa','ZA','ZAF','710','027',1,1),(197,'sri-lanka','LK','LKA','144','094',1,1),(198,'sudan','SD','SDN','736','095',1,1),(199,'suriname','SR','SUR','740','597',0,1),(200,'swaziland','SZ','SWZ','748','268',1,1),(201,'sweden','SE','SWE','752','046',1,1),(202,'switzerland','CH','CHE','756','041',1,1),(203,'syria','SY','SYR','760','963',0,1),(204,'taiwan','TW','TWN','158','886',1,1),(205,'tajikistan','TJ','TJK','762','992',1,1),(206,'tanzania','TZ','TZA','834','255',0,1),(207,'thailand','TH','THA','764','066',1,1),(208,'togo','TG','TGO','768','228',1,1),(209,'tonga','TO','TON','776','676',0,1),(210,'trinidad-tobago','TT','TTO','780','868',0,1),(211,'tunisia','TN','TUN','788','216',1,1),(212,'turkmenistan','TM','TKM','795','993',1,1),(213,'turks-caicos','TC','TCA','796','649',1,1),(214,'tuvalu','TV','TUV','798','688',0,1),(215,'uganda','UG','UGA','800','256',0,1),(216,'ukraine','UA','UKR','804','380',1,1),(217,'united-arab-emirates','AE','ARE','784','971',0,1),(218,'uruguay','UY','URY','858','598',1,1),(219,'uzbekistan','UZ','UZB','860','998',1,1),(220,'vanuatu','VU','VUT','548','678',0,1),(221,'vatican-city','VA','VAT','336','039',1,1),(222,'venezuela','VE','VEN','862','058',1,1),(223,'wallis-futuna','WF','WLF','876','681',1,1),(224,'western-samoa','WS','WSM','882','685',1,1),(225,'yemen','YE','YEM','887','967',0,1),(226,'zambia','ZM','ZMB','894','260',1,1),(227,'zimbabwe','ZW','ZWE','716','263',0,1),(228,'aland-islands','AX','ALA','248','359',1,1),(229,'bonaire-st-eustatius-saba','BQ','BES','535','599',1,1),(230,'bouvet-island','BV','BVT','74','047',1,1),(231,'british-indian-ocean-territory','IO','IOT','86','246',1,1),(232,'curacao','CW','CUW','531','599',1,1),(233,'french-southern-territories','TF','ATF','260','033',0,1),(234,'guernsey','GG','GGY','831','044',1,1),(235,'heard-island-mcdonald-islands','HM','HMD','334','061',1,1),(236,'isle-of-man','IM','IMN','833','044',1,1),(237,'jersey','JE','JEY','832','044',1,1),(238,'northern-mariana-islands','MP','MNP','580','670',1,1),(239,'pitcairn','PN','PCN','612','649',1,1),(240,'south-georgia-south-sandwich-islands','GS','SGS','239','044',1,1),(241,'south-sudan','SS','SSD','728','211',1,1),(242,'sint-maarten','SX','SXM','534','721',1,1),(243,'st-barthelemy','BL','BLM','652','590',1,1),(244,'st-martin','MF','MAF','663','590',1,1),(245,'tokelau','TK','TKL','772','690',0,1),(246,'timor-leste','TL','TLS','626','670',1,1),(247,'united-states-minor-outlying-islands','UM','UMI','581','699',1,1),(248,'united-states-virgin-islands','VI','VIR','850','340',1,1),(249,'western-sahara','EH','ESH','732','212',1,1);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cyrususer`
--

DROP TABLE IF EXISTS `cyrususer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cyrususer` (
  `userId` varchar(75) NOT NULL,
  `password_` varchar(75) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cyrususer`
--

LOCK TABLES `cyrususer` WRITE;
/*!40000 ALTER TABLE `cyrususer` DISABLE KEYS */;
/*!40000 ALTER TABLE `cyrususer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cyrusvirtual`
--

DROP TABLE IF EXISTS `cyrusvirtual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cyrusvirtual` (
  `emailAddress` varchar(75) NOT NULL,
  `userId` varchar(75) NOT NULL,
  PRIMARY KEY (`emailAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cyrusvirtual`
--

LOCK TABLES `cyrusvirtual` WRITE;
/*!40000 ALTER TABLE `cyrusvirtual` DISABLE KEYS */;
/*!40000 ALTER TABLE `cyrusvirtual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddlrecord`
--

DROP TABLE IF EXISTS `ddlrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ddlrecord` (
  `uuid_` varchar(75) DEFAULT NULL,
  `recordId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `versionUserId` bigint(20) DEFAULT NULL,
  `versionUserName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `DDMStorageId` bigint(20) DEFAULT NULL,
  `recordSetId` bigint(20) DEFAULT NULL,
  `version` varchar(75) DEFAULT NULL,
  `displayIndex` int(11) DEFAULT NULL,
  PRIMARY KEY (`recordId`),
  UNIQUE KEY `IX_B4328F39` (`uuid_`,`groupId`),
  KEY `IX_6A6C1C85` (`companyId`),
  KEY `IX_87A6B599` (`recordSetId`),
  KEY `IX_AAC564D3` (`recordSetId`,`userId`),
  KEY `IX_8BC2F891` (`uuid_`),
  KEY `IX_384AB6F7` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddlrecord`
--

LOCK TABLES `ddlrecord` WRITE;
/*!40000 ALTER TABLE `ddlrecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `ddlrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddlrecordset`
--

DROP TABLE IF EXISTS `ddlrecordset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ddlrecordset` (
  `uuid_` varchar(75) DEFAULT NULL,
  `recordSetId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `DDMStructureId` bigint(20) DEFAULT NULL,
  `recordSetKey` varchar(75) DEFAULT NULL,
  `name` longtext,
  `description` longtext,
  `minDisplayRows` int(11) DEFAULT NULL,
  `scope` int(11) DEFAULT NULL,
  PRIMARY KEY (`recordSetId`),
  UNIQUE KEY `IX_56DAB121` (`groupId`,`recordSetKey`),
  UNIQUE KEY `IX_270BA5E1` (`uuid_`,`groupId`),
  KEY `IX_4FA5969F` (`groupId`),
  KEY `IX_561E44E9` (`uuid_`),
  KEY `IX_5938C39F` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddlrecordset`
--

LOCK TABLES `ddlrecordset` WRITE;
/*!40000 ALTER TABLE `ddlrecordset` DISABLE KEYS */;
/*!40000 ALTER TABLE `ddlrecordset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddlrecordversion`
--

DROP TABLE IF EXISTS `ddlrecordversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ddlrecordversion` (
  `recordVersionId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `DDMStorageId` bigint(20) DEFAULT NULL,
  `recordSetId` bigint(20) DEFAULT NULL,
  `recordId` bigint(20) DEFAULT NULL,
  `version` varchar(75) DEFAULT NULL,
  `displayIndex` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`recordVersionId`),
  UNIQUE KEY `IX_C79E347` (`recordId`,`version`),
  KEY `IX_2F4DDFE1` (`recordId`),
  KEY `IX_762ADC7` (`recordId`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddlrecordversion`
--

LOCK TABLES `ddlrecordversion` WRITE;
/*!40000 ALTER TABLE `ddlrecordversion` DISABLE KEYS */;
/*!40000 ALTER TABLE `ddlrecordversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddmcontent`
--

DROP TABLE IF EXISTS `ddmcontent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ddmcontent` (
  `uuid_` varchar(75) DEFAULT NULL,
  `contentId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `name` longtext,
  `description` longtext,
  `xml` longtext,
  PRIMARY KEY (`contentId`),
  UNIQUE KEY `IX_EB9BDE28` (`uuid_`,`groupId`),
  KEY `IX_E3BAF436` (`companyId`),
  KEY `IX_50BF1038` (`groupId`),
  KEY `IX_AE4B50C2` (`uuid_`),
  KEY `IX_3A9C0626` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddmcontent`
--

LOCK TABLES `ddmcontent` WRITE;
/*!40000 ALTER TABLE `ddmcontent` DISABLE KEYS */;
/*!40000 ALTER TABLE `ddmcontent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddmstoragelink`
--

DROP TABLE IF EXISTS `ddmstoragelink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ddmstoragelink` (
  `uuid_` varchar(75) DEFAULT NULL,
  `storageLinkId` bigint(20) NOT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `structureId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`storageLinkId`),
  UNIQUE KEY `IX_702D1AD5` (`classPK`),
  KEY `IX_81776090` (`structureId`),
  KEY `IX_32A18526` (`uuid_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddmstoragelink`
--

LOCK TABLES `ddmstoragelink` WRITE;
/*!40000 ALTER TABLE `ddmstoragelink` DISABLE KEYS */;
/*!40000 ALTER TABLE `ddmstoragelink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddmstructure`
--

DROP TABLE IF EXISTS `ddmstructure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ddmstructure` (
  `uuid_` varchar(75) DEFAULT NULL,
  `structureId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `parentStructureId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `structureKey` varchar(75) DEFAULT NULL,
  `name` longtext,
  `description` longtext,
  `xsd` longtext,
  `storageType` varchar(75) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  PRIMARY KEY (`structureId`),
  UNIQUE KEY `IX_C8785130` (`groupId`,`classNameId`,`structureKey`),
  UNIQUE KEY `IX_85C7EBE2` (`uuid_`,`groupId`),
  KEY `IX_31817A62` (`classNameId`),
  KEY `IX_4FBAC092` (`companyId`,`classNameId`),
  KEY `IX_C8419FBE` (`groupId`),
  KEY `IX_B6ED5E50` (`groupId`,`classNameId`),
  KEY `IX_43395316` (`groupId`,`parentStructureId`),
  KEY `IX_657899A8` (`parentStructureId`),
  KEY `IX_20FDE04C` (`structureKey`),
  KEY `IX_E61809C8` (`uuid_`),
  KEY `IX_F9FB8D60` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddmstructure`
--

LOCK TABLES `ddmstructure` WRITE;
/*!40000 ALTER TABLE `ddmstructure` DISABLE KEYS */;
INSERT INTO `ddmstructure` VALUES ('4d5ec05b-3e07-4839-afad-a55d50c09d6e',20303,20194,20154,20158,'','2016-06-30 20:52:05','2016-06-30 20:52:05',0,20091,'LEARNING MODULE METADATA','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Learning Module Metadata</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Learning Module Metadata</Description></root>','<?xml version=\"1.0\"?>\n\n<root available-locales=\"zh_CN\" default-locale=\"zh_CN\">\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" multiple=\"true\" name=\"select2235\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"home_edition\" type=\"option\" value=\"HE\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Home Edition]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"business_edition\" type=\"option\" value=\"BE\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Business Edition]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"enterprise_edition\" type=\"option\" value=\"EE\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Enterprise Edition]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Product]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" multiple=\"true\" name=\"select3212\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"1_0\" type=\"option\" value=\"1\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[1.0]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"2_0\" type=\"option\" value=\"2\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[2.0]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"3_0\" type=\"option\" value=\"3\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[3.0]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Version]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" multiple=\"true\" name=\"select4115\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"administration\" type=\"option\" value=\"admin\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Administration]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"installation\" type=\"option\" value=\"install\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Installation]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"configuration\" type=\"option\" value=\"config\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Configuration]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Topics]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" multiple=\"false\" name=\"select5069\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"beginner\" type=\"option\" value=\"beginner\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Beginner]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"intermediate\" type=\"option\" value=\"intermediate\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Intermediate]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"advanced\" type=\"option\" value=\"advanced\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Advanced]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Level]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n</root>','xml',0),('8046d44b-852d-4329-bbfb-b8f40d567f09',20304,20194,20154,20158,'','2016-06-30 20:52:05','2016-06-30 20:52:05',0,20091,'MARKETING CAMPAIGN THEME METADATA','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Marketing Campaign Theme Metadata</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Marketing Campaign Theme Metadata</Description></root>','<?xml version=\"1.0\"?>\n\n<root available-locales=\"zh_CN\" default-locale=\"zh_CN\">\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" multiple=\"false\" name=\"select2305\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"strong_company\" type=\"option\" value=\"strong\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Strong Company]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"new_product_launch\" type=\"option\" value=\"product\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[New Product Launch]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"company_philosophy\" type=\"option\" value=\"philosophy\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Company Philosophy]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Select]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" multiple=\"false\" name=\"select3229\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"your_trusted_advisor\" type=\"option\" value=\"advisor\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Your Trusted Advisor]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"10_years_of_customer_solutions\" type=\"option\" value=\"solutions\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[10 Years of Customer Solutions]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"making_a_difference\" type=\"option\" value=\"difference\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Making a Difference]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Campaign Theme]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" multiple=\"false\" name=\"select4282\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"awareness\" type=\"option\" value=\"awareness\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Awareness]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"lead_generation\" type=\"option\" value=\"leads\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Lead Generation]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"customer_service\" type=\"option\" value=\"service\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Customer Service]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Business Goal]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n</root>','xml',0),('6bd0d381-c713-46c3-a48a-ef074b2e7c30',20305,20194,20154,20158,'','2016-06-30 20:52:05','2016-06-30 20:52:05',0,20091,'MEETING METADATA','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Meeting Metadata</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Metadata for meeting</Description></root>','<?xml version=\"1.0\"?>\n\n<root available-locales=\"zh_CN\" default-locale=\"zh_CN\">\n	<dynamic-element dataType=\"date\" fieldNamespace=\"ddm\" indexType=\"keyword\" name=\"ddm-date3054\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"ddm-date\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Date]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" name=\"text2217\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Meeting Name]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" name=\"text4569\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Time]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" name=\"text5638\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Location]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"text\" name=\"textarea6584\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"textarea\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Description]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"text\" name=\"textarea7502\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"textarea\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Participants]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n</root>','xml',0),('f1d919ac-1dc1-473e-b40b-d902d3c53190',20307,20194,20154,20158,'','2016-06-30 20:52:06','2016-06-30 20:52:06',0,20091,'AUTO_D7F80596-F6CE-474A-8C2D-8A81086A163E','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Contract</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Contract</Description></root>','<?xml version=\"1.0\"?>\n\n<root available-locales=\"zh_CN\" default-locale=\"zh_CN\">\n	<dynamic-element dataType=\"date\" fieldNamespace=\"ddm\" indexType=\"keyword\" name=\"ddm-date18949\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"ddm-date\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Effective Date]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"date\" fieldNamespace=\"ddm\" indexType=\"keyword\" name=\"ddm-date20127\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"ddm-date\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Expiration Date]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" multiple=\"false\" name=\"select10264\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"nda\" type=\"option\" value=\"NDA\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[NDA]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"msa\" type=\"option\" value=\"MSA\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[MSA]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"license_agreement\" type=\"option\" value=\"License\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[License Agreement]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Contract Type]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" multiple=\"false\" name=\"select4893\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"draft\" type=\"option\" value=\"Draft\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Draft]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"in_review\" type=\"option\" value=\"Review\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[In Review]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"suspended\" type=\"option\" value=\"Suspended\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Suspended]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"signed\" type=\"option\" value=\"Signed\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Signed]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Status]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" name=\"text14822\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Legal Reviewer]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" name=\"text17700\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Signing Authority]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" name=\"text2087\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Deal Name]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n</root>','xml',1),('32e96da6-159c-4afd-a2b3-e97b6055c212',20309,20194,20154,20158,'','2016-06-30 20:52:06','2016-06-30 20:52:06',0,20091,'AUTO_F11FDC5E-C300-4761-AC36-517405E040E6','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Marketing Banner</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Marketing Banner</Description></root>','<?xml version=\"1.0\"?>\n\n<root available-locales=\"zh_CN\" default-locale=\"zh_CN\">\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" name=\"radio5547\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"radio\">\n		<dynamic-element name=\"yes\" type=\"option\" value=\"yes\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Yes]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"no\" type=\"option\" value=\"no\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[No]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Needs Legal Review]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" name=\"text2033\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Banner Name]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"text\" name=\"textarea2873\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"textarea\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Description]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n</root>','xml',1),('4c392f70-248e-4169-b7e8-fa50ec6c77a1',20311,20194,20154,20158,'','2016-06-30 20:52:06','2016-06-30 20:52:06',0,20091,'AUTO_BD448AA1-6D2F-4B8C-8A20-A0942174A0DC','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Online Training</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Online Training</Description></root>','<?xml version=\"1.0\"?>\n\n<root available-locales=\"zh_CN\" default-locale=\"zh_CN\">\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" name=\"text2082\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Lesson Title]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" name=\"text2979\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Author]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n</root>','xml',1),('e2d8dc69-ac8d-406b-bf5d-c0657c5a5870',20313,20194,20154,20158,'','2016-06-30 20:52:06','2016-06-30 20:52:06',0,20091,'AUTO_64799D61-6C44-432B-BB8A-2DB80DFC9BDC','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Sales Presentation</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Sales Presentation</Description></root>','<?xml version=\"1.0\"?>\n\n<root available-locales=\"zh_CN\" default-locale=\"zh_CN\">\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" multiple=\"false\" name=\"select2890\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"home_edition\" type=\"option\" value=\"HE\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Home Edition]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"business_edition\" type=\"option\" value=\"BE\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Business Edition]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"enterprise_edition\" type=\"option\" value=\"EE\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Enterprise Edition]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Product]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" multiple=\"false\" name=\"select3864\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"1_0\" type=\"option\" value=\"1\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[1.0]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"2_0\" type=\"option\" value=\"2\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[2.0]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"3_0\" type=\"option\" value=\"3\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[3.0]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Version]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" multiple=\"true\" name=\"select4831\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"website\" type=\"option\" value=\"website\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Website]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"collaboration\" type=\"option\" value=\"collaboration\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Collaboration]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"intranet\" type=\"option\" value=\"intranet\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Intranet]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Areas of Interest]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" multiple=\"true\" name=\"select5929\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"acme\" type=\"option\" value=\"acme\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[ACME]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"sevencogs\" type=\"option\" value=\"sevencogs\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[SevenCogs]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"freeplus\" type=\"option\" value=\"freeplus\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[FreePlus]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Competitors]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" indexType=\"keyword\" name=\"text1993\" readOnly=\"false\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Prospect Name]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n</root>','xml',1),('a99385bc-0088-49fa-901d-cd96b8ef6ea0',20315,20194,20154,20158,'','2016-06-30 20:52:06','2016-06-30 20:52:06',0,20314,'TIKARAWMETADATA','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">TIKARAWMETADATA</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">TIKARAWMETADATA</Description></root>','<root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><dynamic-element dataType=\"string\" name=\"ClimateForcast_PROGRAM_ID\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.PROGRAM_ID]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_COMMAND_LINE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.COMMAND_LINE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_HISTORY\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.HISTORY]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_TABLE_ID\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.TABLE_ID]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_INSTITUTION\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.INSTITUTION]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_SOURCE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.SOURCE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_CONTACT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.CONTACT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_PROJECT_ID\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.PROJECT_ID]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_CONVENTIONS\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.CONVENTIONS]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_REFERENCES\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.REFERENCES]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_ACKNOWLEDGEMENT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.ACKNOWLEDGEMENT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_REALIZATION\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.REALIZATION]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_EXPERIMENT_ID\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.EXPERIMENT_ID]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_COMMENT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.COMMENT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"ClimateForcast_MODEL_NAME_ENGLISH\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.ClimateForcast.MODEL_NAME_ENGLISH]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"CreativeCommons_LICENSE_URL\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.CreativeCommons.LICENSE_URL]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"CreativeCommons_LICENSE_LOCATION\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.CreativeCommons.LICENSE_LOCATION]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"CreativeCommons_WORK_TYPE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.CreativeCommons.WORK_TYPE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_NAMESPACE_URI_DC\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.NAMESPACE_URI_DC]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_NAMESPACE_URI_DC_TERMS\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.NAMESPACE_URI_DC_TERMS]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_PREFIX_DC\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.PREFIX_DC]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_PREFIX_DC_TERMS\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.PREFIX_DC_TERMS]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_FORMAT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.FORMAT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_IDENTIFIER\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.IDENTIFIER]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_MODIFIED\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.MODIFIED]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_CONTRIBUTOR\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.CONTRIBUTOR]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_COVERAGE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.COVERAGE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_CREATOR\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.CREATOR]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_CREATED\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.CREATED]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_DATE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.DATE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_DESCRIPTION\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.DESCRIPTION]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_LANGUAGE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.LANGUAGE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_PUBLISHER\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.PUBLISHER]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_RELATION\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.RELATION]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_RIGHTS\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.RIGHTS]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_SOURCE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.SOURCE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_SUBJECT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.SUBJECT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_TITLE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.TITLE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"DublinCore_TYPE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.DublinCore.TYPE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"Geographic_LATITUDE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.Geographic.LATITUDE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"Geographic_LONGITUDE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.Geographic.LONGITUDE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"Geographic_ALTITUDE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.Geographic.ALTITUDE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"HttpHeaders_CONTENT_ENCODING\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.HttpHeaders.CONTENT_ENCODING]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"HttpHeaders_CONTENT_LANGUAGE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.HttpHeaders.CONTENT_LANGUAGE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"HttpHeaders_CONTENT_LENGTH\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.HttpHeaders.CONTENT_LENGTH]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"HttpHeaders_CONTENT_LOCATION\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.HttpHeaders.CONTENT_LOCATION]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"HttpHeaders_CONTENT_DISPOSITION\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.HttpHeaders.CONTENT_DISPOSITION]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"HttpHeaders_CONTENT_MD5\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.HttpHeaders.CONTENT_MD5]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"HttpHeaders_CONTENT_TYPE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.HttpHeaders.CONTENT_TYPE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"HttpHeaders_LAST_MODIFIED\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.HttpHeaders.LAST_MODIFIED]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"HttpHeaders_LOCATION\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.HttpHeaders.LOCATION]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"Message_MESSAGE_RECIPIENT_ADDRESS\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.Message.MESSAGE_RECIPIENT_ADDRESS]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"Message_MESSAGE_FROM\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.Message.MESSAGE_FROM]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"Message_MESSAGE_TO\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.Message.MESSAGE_TO]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"Message_MESSAGE_CC\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.Message.MESSAGE_CC]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"Message_MESSAGE_BCC\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.Message.MESSAGE_BCC]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_KEYWORDS\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.KEYWORDS]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_COMMENTS\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.COMMENTS]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_LAST_AUTHOR\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.LAST_AUTHOR]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_AUTHOR\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.AUTHOR]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_APPLICATION_NAME\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.APPLICATION_NAME]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_REVISION_NUMBER\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.REVISION_NUMBER]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_TEMPLATE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.TEMPLATE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_TOTAL_TIME\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.TOTAL_TIME]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_PRESENTATION_FORMAT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.PRESENTATION_FORMAT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_NOTES\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.NOTES]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_MANAGER\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.MANAGER]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_APPLICATION_VERSION\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.APPLICATION_VERSION]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_VERSION\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.VERSION]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_CONTENT_STATUS\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.CONTENT_STATUS]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_CATEGORY\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.CATEGORY]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_COMPANY\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.COMPANY]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_SECURITY\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.SECURITY]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_SLIDE_COUNT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.SLIDE_COUNT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_PAGE_COUNT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.PAGE_COUNT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_PARAGRAPH_COUNT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.PARAGRAPH_COUNT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_LINE_COUNT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.LINE_COUNT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_WORD_COUNT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.WORD_COUNT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_CHARACTER_COUNT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.CHARACTER_COUNT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_CHARACTER_COUNT_WITH_SPACES\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.CHARACTER_COUNT_WITH_SPACES]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_TABLE_COUNT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.TABLE_COUNT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_IMAGE_COUNT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.IMAGE_COUNT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_OBJECT_COUNT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.OBJECT_COUNT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_EDIT_TIME\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.EDIT_TIME]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_CREATION_DATE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.CREATION_DATE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_LAST_SAVED\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.LAST_SAVED]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_LAST_PRINTED\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.LAST_PRINTED]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"MSOffice_USER_DEFINED_METADATA_NAME_PREFIX\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.MSOffice.USER_DEFINED_METADATA_NAME_PREFIX]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_BITS_PER_SAMPLE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.BITS_PER_SAMPLE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_IMAGE_LENGTH\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.IMAGE_LENGTH]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_IMAGE_WIDTH\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.IMAGE_WIDTH]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_SAMPLES_PER_PIXEL\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.SAMPLES_PER_PIXEL]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_FLASH_FIRED\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.FLASH_FIRED]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_EXPOSURE_TIME\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.EXPOSURE_TIME]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_F_NUMBER\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.F_NUMBER]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_FOCAL_LENGTH\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.FOCAL_LENGTH]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_ISO_SPEED_RATINGS\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.ISO_SPEED_RATINGS]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_EQUIPMENT_MAKE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.EQUIPMENT_MAKE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_EQUIPMENT_MODEL\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.EQUIPMENT_MODEL]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_SOFTWARE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.SOFTWARE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_ORIENTATION\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.ORIENTATION]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_RESOLUTION_HORIZONTAL\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.RESOLUTION_HORIZONTAL]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_RESOLUTION_VERTICAL\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.RESOLUTION_VERTICAL]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_RESOLUTION_UNIT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.RESOLUTION_UNIT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TIFF_ORIGINAL_DATE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TIFF.ORIGINAL_DATE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TikaMetadataKeys_RESOURCE_NAME_KEY\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TikaMetadataKeys.RESOURCE_NAME_KEY]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TikaMetadataKeys_PROTECTED\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TikaMetadataKeys.PROTECTED]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TikaMetadataKeys_EMBEDDED_RELATIONSHIP_ID\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TikaMetadataKeys.EMBEDDED_RELATIONSHIP_ID]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TikaMimeKeys_TIKA_MIME_FILE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TikaMimeKeys.TIKA_MIME_FILE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"TikaMimeKeys_MIME_TYPE_MAGIC\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.TikaMimeKeys.MIME_TYPE_MAGIC]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_DURATION\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.DURATION]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_ABS_PEAK_AUDIO_FILE_PATH\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.ABS_PEAK_AUDIO_FILE_PATH]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_ALBUM\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.ALBUM]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_ALT_TAPE_NAME\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.ALT_TAPE_NAME]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_ARTIST\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.ARTIST]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_AUDIO_MOD_DATE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.AUDIO_MOD_DATE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_AUDIO_SAMPLE_RATE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.AUDIO_SAMPLE_RATE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_AUDIO_SAMPLE_TYPE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.AUDIO_SAMPLE_TYPE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_AUDIO_CHANNEL_TYPE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.AUDIO_CHANNEL_TYPE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_AUDIO_COMPRESSOR\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.AUDIO_COMPRESSOR]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_COMPOSER\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.COMPOSER]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_COPYRIGHT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.COPYRIGHT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_ENGINEER\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.ENGINEER]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_FILE_DATA_RATE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.FILE_DATA_RATE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_GENRE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.GENRE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_INSTRUMENT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.INSTRUMENT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_KEY\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.KEY]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_LOG_COMMENT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.LOG_COMMENT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_LOOP\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.LOOP]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_NUMBER_OF_BEATS\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.NUMBER_OF_BEATS]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_METADATA_MOD_DATE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.METADATA_MOD_DATE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_PULL_DOWN\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.PULL_DOWN]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_RELATIVE_PEAK_AUDIO_FILE_PATH\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.RELATIVE_PEAK_AUDIO_FILE_PATH]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_RELEASE_DATE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.RELEASE_DATE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_SCALE_TYPE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.SCALE_TYPE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_SCENE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.SCENE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_SHOT_DATE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.SHOT_DATE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_SHOT_LOCATION\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.SHOT_LOCATION]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_SHOT_NAME\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.SHOT_NAME]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_SPEAKER_PLACEMENT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.SPEAKER_PLACEMENT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_STRETCH_MODE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.STRETCH_MODE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_TAPE_NAME\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.TAPE_NAME]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_TEMPO\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.TEMPO]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_TIME_SIGNATURE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.TIME_SIGNATURE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_TRACK_NUMBER\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.TRACK_NUMBER]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_VIDEO_ALPHA_MODE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.VIDEO_ALPHA_MODE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_VIDEO_ALPHA_UNITY_IS_TRANSPARENT\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.VIDEO_ALPHA_UNITY_IS_TRANSPARENT]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_VIDEO_COLOR_SPACE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.VIDEO_COLOR_SPACE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_VIDEO_COMPRESSOR\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.VIDEO_COMPRESSOR]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_VIDEO_FIELD_ORDER\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.VIDEO_FIELD_ORDER]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_VIDEO_FRAME_RATE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.VIDEO_FRAME_RATE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_VIDEO_MOD_DATE\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.VIDEO_MOD_DATE]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_VIDEO_PIXEL_DEPTH\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.VIDEO_PIXEL_DEPTH]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType=\"string\" name=\"XMPDM_VIDEO_PIXEL_ASPECT_RATIO\" required=\"false\" showLabel=\"true\" type=\"text\"><meta-data locale=\"zh_CN\"><entry name=\"label\"><![CDATA[metadata.XMPDM.VIDEO_PIXEL_ASPECT_RATIO]]></entry><entry name=\"predefinedValue\"><![CDATA[]]></entry></meta-data></dynamic-element></root>','xml',0),('a800bbdb-96a4-40af-9f59-37ead821fe84',20412,20181,20154,20158,'','2016-06-30 20:52:21','2016-06-30 20:52:21',0,20098,'CONTACTS','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Contacts</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Contacts</Description></root>','<?xml version=\"1.0\"?>\n\n<root available-locales=\"zh_CN\" default-locale=\"zh_CN\">\n	<dynamic-element dataType=\"string\" name=\"company\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"50\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Company]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"email\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"50\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Email]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"firstName\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"50\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[First Name]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" multiple=\"false\" name=\"imService\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"aol\" type=\"option\" value=\"aol\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[AOL]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"yahoo\" type=\"option\" value=\"yahoo\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Yahoo]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"gtalk\" type=\"option\" value=\"gtalk\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[GTalk]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Instant Messenger Service]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[[\"gtalk\"]]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"imUserName\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"50\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Instant Messenger]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"jobTitle\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"50\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Job Title]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"lastName\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"50\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Last Name]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"notes\" required=\"false\" showLabel=\"true\" type=\"textarea\" width=\"100\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Notes]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"phoneMobile\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"50\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Phone (Mobile)]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"phoneOffice\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"50\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Phone (Office)]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n</root>','xml',0),('c977c90b-e871-4f2c-9509-6f22c50aa6b7',20413,20181,20154,20158,'','2016-06-30 20:52:21','2016-06-30 20:52:21',0,20098,'EVENTS','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Events</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Events</Description></root>','<?xml version=\"1.0\"?>\n\n<root available-locales=\"zh_CN\" default-locale=\"zh_CN\">\n	<dynamic-element dataType=\"document-library\" fieldNamespace=\"ddm\" name=\"attachment\" required=\"false\" showLabel=\"true\" type=\"ddm-documentlibrary\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Attachment]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[Upload documents no larger than 3,000k.]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"double\" fieldNamespace=\"ddm\" name=\"cost\" required=\"false\" showLabel=\"true\" type=\"ddm-number\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Cost]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"description\" required=\"false\" showLabel=\"true\" type=\"textarea\" width=\"100\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Description]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"date\" fieldNamespace=\"ddm\" name=\"eventDate\" required=\"false\" showLabel=\"true\" type=\"ddm-date\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Date]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"eventName\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"50\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Event Name]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"eventTime\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Time]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"location\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"50\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Location]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n</root>','xml',0),('18e53a21-936b-4977-a225-0e450d35e138',20414,20181,20154,20158,'','2016-06-30 20:52:22','2016-06-30 20:52:22',0,20098,'INVENTORY','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Inventory</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Inventory</Description></root>','<?xml version=\"1.0\"?>\n\n<root available-locales=\"zh_CN\" default-locale=\"zh_CN\">\n	<dynamic-element dataType=\"string\" name=\"description\" required=\"false\" showLabel=\"true\" type=\"textarea\" width=\"100\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Description]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"style\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"item\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Item]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"style\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"location\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Location]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"style\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"date\" fieldNamespace=\"ddm\" name=\"purchaseDate\" required=\"false\" showLabel=\"true\" type=\"ddm-date\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Purchase Date]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"style\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"double\" fieldNamespace=\"ddm\" name=\"purchasePrice\" required=\"false\" showLabel=\"true\" type=\"ddm-number\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Purchase Price]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"double\" fieldNamespace=\"ddm\" name=\"quantity\" required=\"false\" showLabel=\"true\" type=\"ddm-number\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Quantity]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n</root>','xml',0),('78f1fe59-fc0e-46dc-a50c-001c54b96fcd',20415,20181,20154,20158,'','2016-06-30 20:52:22','2016-06-30 20:52:22',0,20098,'ISSUES TRACKING','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Issues Tracking</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Issue Tracking</Description></root>','<?xml version=\"1.0\"?>\n\n<root available-locales=\"zh_CN\" default-locale=\"zh_CN\">\n	<dynamic-element dataType=\"string\" name=\"assignedTo\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Assigned To]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"document-library\" fieldNamespace=\"ddm\" name=\"attachment\" required=\"false\" showLabel=\"true\" type=\"ddm-documentlibrary\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Attachment]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[Upload documents no larger than 3,000k.]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"comments\" required=\"false\" showLabel=\"true\" type=\"textarea\" width=\"100\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Comments]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"description\" required=\"false\" showLabel=\"true\" type=\"textarea\" width=\"100\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Description]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"date\" fieldNamespace=\"ddm\" name=\"dueDate\" required=\"false\" showLabel=\"true\" type=\"ddm-date\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Due Date]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"issueId\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Issue ID]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" multiple=\"false\" name=\"severity\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"critical\" type=\"option\" value=\"critical\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Critical]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"major\" type=\"option\" value=\"major\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Major]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"minor\" type=\"option\" value=\"minor\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Minor]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"trivial\" type=\"option\" value=\"trivial\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Trivial]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Severity]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[[\"minor\"]]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" multiple=\"false\" name=\"status\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"open\" type=\"option\" value=\"open\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Open]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"pending\" type=\"option\" value=\"pending\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Pending]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"completed\" type=\"option\" value=\"completed\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Completed]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Status]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[[\"open\"]]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"title\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"100\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Title]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n</root>','xml',0),('121dabfd-fa1e-4466-a635-461aed62787a',20416,20181,20154,20158,'','2016-06-30 20:52:22','2016-06-30 20:52:22',0,20098,'MEETING MINUTES','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Meeting Minutes</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Meeting Minutes</Description></root>','<?xml version=\"1.0\"?>\n\n<root available-locales=\"zh_CN\" default-locale=\"zh_CN\">\n	<dynamic-element dataType=\"document-library\" fieldNamespace=\"ddm\" name=\"attachment\" required=\"false\" showLabel=\"true\" type=\"ddm-documentlibrary\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Attachment]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[Upload documents no larger than 3,000k.]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"author\" required=\"false\" showLabel=\"true\" type=\"text\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Author]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"description\" required=\"false\" showLabel=\"true\" type=\"textarea\" width=\"100\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Description]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"duration\" required=\"false\" showLabel=\"true\" type=\"text\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Meeting Duration]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"date\" fieldNamespace=\"ddm\" name=\"meetingDate\" required=\"false\" showLabel=\"true\" type=\"ddm-date\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Meeting Date]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"minutes\" required=\"false\" showLabel=\"true\" type=\"textarea\" width=\"100\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Minutes]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"title\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"100\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Title]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n</root>','xml',0),('20e085b1-d4a1-4786-be97-72b6d7c63dc3',20417,20181,20154,20158,'','2016-06-30 20:52:22','2016-06-30 20:52:22',0,20098,'TO DO','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">To Do</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">To Do</Description></root>','<?xml version=\"1.0\"?>\n\n<root available-locales=\"zh_CN\" default-locale=\"zh_CN\">\n	<dynamic-element dataType=\"string\" name=\"assignedTo\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"50\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Assigned To]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"document-library\" fieldNamespace=\"ddm\" name=\"attachment\" required=\"false\" showLabel=\"true\" type=\"ddm-documentlibrary\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Attachment]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n			<entry name=\"tip\"><![CDATA[Upload documents no larger than 3,000k.]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"comments\" required=\"false\" showLabel=\"true\" type=\"textarea\" width=\"100\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Comments]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"description\" required=\"false\" showLabel=\"true\" type=\"textarea\" width=\"100\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Description]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"date\" fieldNamespace=\"ddm\" name=\"endDate\" required=\"false\" showLabel=\"true\" type=\"ddm-date\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[End Date]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"integer\" fieldNamespace=\"ddm\" name=\"percentComplete\" required=\"false\" showLabel=\"true\" type=\"ddm-integer\" width=\"25\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[% Complete]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[0]]></entry>\n			<entry name=\"tip\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" multiple=\"false\" name=\"severity\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"critical\" type=\"option\" value=\"critical\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Critical]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"major\" type=\"option\" value=\"major\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Major]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"minor\" type=\"option\" value=\"minor\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Minor]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"trivial\" type=\"option\" value=\"trivial\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Trivial]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Severity]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[[\"minor\"]]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"date\" fieldNamespace=\"ddm\" name=\"startDate\" required=\"false\" showLabel=\"true\" type=\"ddm-date\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Start Date]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" multiple=\"false\" name=\"status\" required=\"false\" showLabel=\"true\" type=\"select\">\n		<dynamic-element name=\"open\" type=\"option\" value=\"open\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Open]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"pending\" type=\"option\" value=\"pending\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Pending]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<dynamic-element name=\"completed\" type=\"option\" value=\"completed\">\n			<meta-data locale=\"zh_CN\">\n				<entry name=\"label\"><![CDATA[Completed]]></entry>\n			</meta-data>\n		</dynamic-element>\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Status]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[[\"open\"]]]></entry>\n		</meta-data>\n	</dynamic-element>\n	<dynamic-element dataType=\"string\" name=\"title\" required=\"false\" showLabel=\"true\" type=\"text\" width=\"50\">\n		<meta-data locale=\"zh_CN\">\n			<entry name=\"label\"><![CDATA[Title]]></entry>\n			<entry name=\"predefinedValue\"><![CDATA[]]></entry>\n		</meta-data>\n	</dynamic-element>\n</root>','xml',0);
/*!40000 ALTER TABLE `ddmstructure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddmstructurelink`
--

DROP TABLE IF EXISTS `ddmstructurelink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ddmstructurelink` (
  `structureLinkId` bigint(20) NOT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `structureId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`structureLinkId`),
  UNIQUE KEY `IX_C803899D` (`classPK`),
  KEY `IX_D43E4208` (`classNameId`),
  KEY `IX_17692B58` (`structureId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddmstructurelink`
--

LOCK TABLES `ddmstructurelink` WRITE;
/*!40000 ALTER TABLE `ddmstructurelink` DISABLE KEYS */;
/*!40000 ALTER TABLE `ddmstructurelink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddmtemplate`
--

DROP TABLE IF EXISTS `ddmtemplate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ddmtemplate` (
  `uuid_` varchar(75) DEFAULT NULL,
  `templateId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `templateKey` varchar(75) DEFAULT NULL,
  `name` longtext,
  `description` longtext,
  `type_` varchar(75) DEFAULT NULL,
  `mode_` varchar(75) DEFAULT NULL,
  `language` varchar(75) DEFAULT NULL,
  `script` longtext,
  `cacheable` tinyint(4) DEFAULT NULL,
  `smallImage` tinyint(4) DEFAULT NULL,
  `smallImageId` bigint(20) DEFAULT NULL,
  `smallImageURL` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`templateId`),
  UNIQUE KEY `IX_E6DFAB84` (`groupId`,`classNameId`,`templateKey`),
  UNIQUE KEY `IX_1AA75CE3` (`uuid_`,`groupId`),
  KEY `IX_B6356F93` (`classNameId`,`classPK`,`type_`),
  KEY `IX_32F83D16` (`classPK`),
  KEY `IX_DB24DDDD` (`groupId`),
  KEY `IX_BD9A4A91` (`groupId`,`classNameId`),
  KEY `IX_824ADC72` (`groupId`,`classNameId`,`classPK`),
  KEY `IX_90800923` (`groupId`,`classNameId`,`classPK`,`type_`),
  KEY `IX_F0C3449` (`groupId`,`classNameId`,`classPK`,`type_`,`mode_`),
  KEY `IX_B1C33EA6` (`groupId`,`classPK`),
  KEY `IX_33BEF579` (`language`),
  KEY `IX_127A35B0` (`smallImageId`),
  KEY `IX_CAE41A28` (`templateKey`),
  KEY `IX_C4F283C8` (`type_`),
  KEY `IX_F2A243A7` (`uuid_`),
  KEY `IX_D4C2C221` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddmtemplate`
--

LOCK TABLES `ddmtemplate` WRITE;
/*!40000 ALTER TABLE `ddmtemplate` DISABLE KEYS */;
INSERT INTO `ddmtemplate` VALUES ('f595cda0-a169-4ad2-a8a7-9c77bac528d2',20418,20194,20154,20158,'','2016-06-30 20:52:22','2016-06-30 20:52:22',20016,0,'WIKI-SOCIAL-FTL','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Social</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Displays social bookmarks and ratings for wiki pages and their child pages.</Description></root>','display','','ftl','<#assign liferay_ui = taglibLiferayHash[\"/WEB-INF/tld/liferay-ui.tld\"] />\n\n<#assign wikiPageClassName = \"com.liferay.portlet.wiki.model.WikiPage\" />\n\n<#assign assetRenderer = assetEntry.getAssetRenderer() />\n\n<div class=\"taglib-header\">\n	<h1 class=\"header-title\">${entry.getTitle()}</h1>\n</div>\n\n<div style=\"float: right;\">\n	<@getEditIcon />\n\n	<@getPageDetailsIcon />\n\n	<@getPrintIcon />\n</div>\n\n<div class=\"wiki-body\">\n	<div class=\"wiki-info\">\n		<span class=\"stats\">${assetEntry.getViewCount()} <@liferay.language key=\"views\" /></span> |\n\n		<span class=\"date\"><@liferay.language key=\"last-modified\" /> ${dateUtil.getDate(entry.getModifiedDate(), \"dd MMM yyyy - HH:mm:ss\", locale)}</span>\n\n		<span class=\"author\"><@liferay.language key=\"by\" /> ${htmlUtil.escape(portalUtil.getUserName(entry.getUserId(), entry.getUserName()))}</span>\n	</div>\n\n	<div class=\"wiki-content\">\n		<@liferay_ui[\"social-bookmarks\"]\n			displayStyle=\"normal\"\n			target=\"_blank\"\n			title=entry.getTitle()\n			url=viewURL\n		/>\n\n		${formattedContent}\n	</div>\n\n	<div class=\"page-actions\">\n		<div class=\"article-actions\">\n			<@getAddChildPageIcon />\n\n			<@getAttatchmentsIcon />\n		</div>\n	</div>\n\n	 <br />\n\n	<@getRatings cssClass=\"page-ratings\" entry=entry />\n\n	<@getRelatedAssets />\n</div>\n\n<div class=\"page-categorization\">\n	<div class=\"page-categories\">\n		<#assign viewCategorizedPagesURL = renderResponse.createRenderURL() />\n\n		${viewCategorizedPagesURL.setParameter(\"struts_action\", \"/wiki/view_categorized_pages\")}\n		${viewCategorizedPagesURL.setParameter(\"nodeId\", entry.getNodeId()?string)}\n\n		<@liferay_ui[\"asset-categories-summary\"]\n			className=wikiPageClassName\n			classPK=entry.getResourcePrimKey()\n			portletURL=viewCategorizedPagesURL\n		/>\n	</div>\n\n	<div class=\"page-tags\">\n		<#assign viewTaggedPagesURL = renderResponse.createRenderURL() />\n\n		${viewTaggedPagesURL.setParameter(\"struts_action\", \"/wiki/view_tagged_pages\")}\n		${viewTaggedPagesURL.setParameter(\"nodeId\", entry.getNodeId()?string)}\n\n		<@liferay_ui[\"asset-tags-summary\"]\n			className=wikiPageClassName\n			classPK=entry.getResourcePrimKey()\n			portletURL=viewTaggedPagesURL\n		/>\n	</div>\n</div>\n\n<#assign childPages = entry.getChildPages() />\n\n<#if (childPages?has_content)>\n	<div class=\"child-pages\">\n		<h2><@liferay.language key=\"children-pages\" /></h2>\n\n		<table class=\"taglib-search-iterator\">\n			<tr class=\"portlet-section-header results-header\">\n				<th>\n					<@liferay.language key=\"page\" />\n				</th>\n				<th>\n					<@liferay.language key=\"last-modified\" />\n				</th>\n				<th>\n					<@liferay.language key=\"ratings\" />\n				</th>\n			</tr>\n\n			<#list childPages as childPage>\n				<tr class=\"results-row\">\n					<#assign viewPageURL = renderResponse.createRenderURL() />\n\n					${viewPageURL.setParameter(\"struts_action\", \"/wiki/view\")}\n\n					<#assign childNode = childPage.getNode() />\n\n					${viewPageURL.setParameter(\"nodeName\", childNode.getName())}\n					${viewPageURL.setParameter(\"title\", childPage.getTitle())}\n\n					<td>\n						<a href=\"${viewPageURL}\">${childPage.getTitle()}</a>\n					</td>\n					<td>\n						<a href=\"${viewPageURL}\">${dateUtil.getDate(childPage.getModifiedDate(),\"dd MMM yyyy - HH:mm:ss\", locale)} <@liferay.language key=\"by\" /> ${htmlUtil.escape(portalUtil.getUserName(childPage.getUserId(), childPage.getUserName()))}</a>\n					</td>\n					<td>\n						<@getRatings cssClass=\"child-ratings\" entry=childPage />\n					</td>\n				</tr>\n			</#list>\n		</table>\n	</div>\n</#if>\n\n<@getDiscussion />\n\n<#macro getAddChildPageIcon>\n	<#if assetRenderer.hasEditPermission(themeDisplay.getPermissionChecker())>\n		<#assign addPageURL = renderResponse.createRenderURL() />\n\n		${addPageURL.setParameter(\"struts_action\", \"/wiki/edit_page\")}\n		${addPageURL.setParameter(\"redirect\", currentURL)}\n		${addPageURL.setParameter(\"nodeId\", entry.getNodeId()?string)}\n		${addPageURL.setParameter(\"title\", \"\")}\n		${addPageURL.setParameter(\"editTitle\", \"1\")}\n		${addPageURL.setParameter(\"parentTitle\", entry.getTitle())}\n\n		<@liferay_ui[\"icon\"]\n			image=\"add_article\"\n			label=true\n			message=\"add-child-page\"\n			url=addPageURL?string\n		/>\n	</#if>\n</#macro>\n\n<#macro getAttatchmentsIcon>\n	<#assign viewPageAttachmentsURL = renderResponse.createRenderURL() />\n\n	${viewPageAttachmentsURL.setParameter(\"struts_action\", \"/wiki/view_page_attachments\") }\n\n	<@liferay_ui[\"icon\"]\n		image=\"clip\"\n		label=true\n		message=\'${entry.getAttachmentsFileEntriesCount() + languageUtil.get(locale, \"attachments\")}\'\n		url=viewPageAttachmentsURL?string\n	/>\n</#macro>\n\n<#macro getDiscussion>\n	<#if validator.isNotNull(assetRenderer.getDiscussionPath()) && (enableComments == \"true\")>\n		<br />\n\n		<#assign discussionURL = renderResponse.createActionURL() />\n\n		${discussionURL.setParameter(\"struts_action\", \"/wiki/\" + assetRenderer.getDiscussionPath())}\n\n		<@liferay_ui[\"discussion\"]\n			className=wikiPageClassName\n			classPK=entry.getResourcePrimKey()\n			formAction=discussionURL?string\n			formName=\"fm2\"\n			ratingsEnabled=enableCommentRatings == \"true\"\n			redirect=currentURL\n			subject=assetRenderer.getTitle(locale)\n			userId=assetRenderer.getUserId()\n		/>\n	</#if>\n</#macro>\n\n<#macro getEditIcon>\n	<#if assetRenderer.hasEditPermission(themeDisplay.getPermissionChecker())>\n		<#assign editPageURL = renderResponse.createRenderURL() />\n\n		${editPageURL.setParameter(\"struts_action\", \"/wiki/edit_page\")}\n		${editPageURL.setParameter(\"redirect\", currentURL)}\n		${editPageURL.setParameter(\"nodeId\", entry.getNodeId()?string)}\n		${editPageURL.setParameter(\"title\", entry.getTitle())}\n\n		<@liferay_ui[\"icon\"]\n			image=\"edit\"\n			message=entry.getTitle()\n			url=editPageURL?string\n		/>\n	</#if>\n</#macro>\n\n<#macro getPageDetailsIcon>\n	<#assign viewPageDetailsURL = renderResponse.createRenderURL() />\n\n	${viewPageDetailsURL.setParameter(\"struts_action\", \"/wiki/view_page_details\")}\n	${viewPageDetailsURL.setParameter(\"redirect\", currentURL)}\n\n	<@liferay_ui[\"icon\"]\n		image=\"history\"\n		message=\"details\"\n		url=viewPageDetailsURL?string\n	/>\n</#macro>\n\n<#macro getPrintIcon>\n	<#assign printURL = renderResponse.createRenderURL() />\n\n	${printURL.setParameter(\"viewMode\", \"print\")}\n	${printURL.setWindowState(\"pop_up\")}\n\n	<#assign title = languageUtil.format(locale, \"print-x-x\", [\"hide-accessible\", htmlUtil.escape(assetRenderer.getTitle(locale))]) />\n	<#assign taglibPrintURL = \"javascript:Liferay.Util.openWindow({dialog: {width: 960}, id:\'\" + renderResponse.getNamespace() + \"printAsset\', title: \'\" + title + \"\', uri: \'\" + htmlUtil.escapeURL(printURL.toString()) + \"\'});\" />\n\n	<@liferay_ui[\"icon\"]\n		image=\"print\"\n		message=\"print\"\n		url=taglibPrintURL\n	/>\n</#macro>\n\n<#macro getRatings\n	cssClass\n	entry\n>\n	<#if enablePageRatings == \"true\">\n		<div class=\"${cssClass}\">\n			<@liferay_ui[\"ratings\"]\n				className=wikiPageClassName\n				classPK=entry.getResourcePrimKey()\n			/>\n		</div>\n	</#if>\n</#macro>\n\n<#macro getRelatedAssets>\n	<#if assetEntry?? && (enableRelatedAssets == \"true\")>\n		<@liferay_ui[\"asset-links\"]\n			assetEntryId=assetEntry.getEntryId()\n		/>\n	</#if>\n</#macro>',0,0,20419,''),('d5300ce6-b45c-4216-8ec6-1084a721f8a7',20420,20194,20154,20158,'','2016-06-30 20:52:22','2016-06-30 20:52:22',20081,0,'ASSET-CATEGORIES-NAVIGATION-MULTI-COLUMN-LAYOUT-FTL','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Multi Column Layout</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Displays a column for each vocabulary. Each column includes the name of a vocabulary with the vocabulary\'s top level categories listed underneath.</Description></root>','display','','ftl','<#assign aui = taglibLiferayHash[\"/WEB-INF/tld/aui.tld\"] />\n\n<#if entries?has_content>\n	<@aui.layout>\n		<#list entries as entry>\n			<@aui.column columnWidth=25>\n				<div class=\"results-header\">\n					<h3>\n						${entry.getName()}\n					</h3>\n				</div>\n\n				<#assign categories = entry.getCategories()>\n\n				<@displayCategories categories=categories />\n			</@aui.column>\n		</#list>\n	</@aui.layout>\n</#if>\n\n<#macro displayCategories\n	categories\n>\n	<#if categories?has_content>\n		<ul class=\"categories\">\n			<#list categories as category>\n				<li>\n					<#assign categoryURL = renderResponse.createRenderURL()>\n\n					${categoryURL.setParameter(\"resetCur\", \"true\")}\n					${categoryURL.setParameter(\"categoryId\", category.getCategoryId()?string)}\n\n					<a href=\"${categoryURL}\">${category.getName()}</a>\n\n					<#if serviceLocator??>\n						<#assign assetCategoryService = serviceLocator.findService(\"com.liferay.portlet.asset.service.AssetCategoryService\")>\n\n						<#assign childCategories = assetCategoryService.getChildCategories(category.getCategoryId())>\n\n						<@displayCategories categories=childCategories />\n					</#if>\n				</li>\n			</#list>\n		</ul>\n	</#if>\n</#macro>',0,0,20421,''),('2c15eb9b-8013-44b0-a1c8-cacaca572152',20423,20194,20154,20158,'','2016-06-30 20:52:22','2016-06-30 20:52:22',20422,0,'DOCUMENTLIBRARY-CAROUSEL-FTL','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Carousel</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Displays images in a carousel.</Description></root>','display','','ftl','<#assign aui = taglibLiferayHash[\"/WEB-INF/tld/aui.tld\"] />\n<#assign liferay_portlet = taglibLiferayHash[\"/WEB-INF/tld/liferay-portlet.tld\"] />\n\n<#if entries?has_content>\n	<style>\n		#<@liferay_portlet.namespace />carousel .carousel-item {\n			background-color: #000;\n			height: 250px;\n			overflow: hidden;\n			text-align: center;\n			width: 700px;\n		}\n\n		#<@liferay_portlet.namespace />carousel .carousel-item img {\n			max-height: 250px;\n			max-width: 700px;\n		}\n	</style>\n\n	<div id=\"<@liferay_portlet.namespace />carousel\">\n		<#assign imageMimeTypes = propsUtil.getArray(\"dl.file.entry.preview.image.mime.types\") />\n\n		<#list entries as entry>\n			<#if imageMimeTypes?seq_contains(entry.getMimeType()) >\n				<div class=\"carousel-item\">\n					<img src=\"${dlUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, \"\")}\" />\n				</div>\n			</#if>\n		</#list>\n	</div>\n\n	<@aui.script use=\"aui-carousel\">\n		new A.Carousel(\n			{\n				contentBox: \'#<@liferay_portlet.namespace />carousel\',\n				height: 250,\n				intervalTime: 2,\n				width: 700\n			}\n		).render();\n	</@aui.script>\n</#if>',0,0,20424,''),('eb1f1ec6-3f59-49fc-ad58-725921d71387',20425,20194,20154,20158,'','2016-06-30 20:52:22','2016-06-30 20:52:22',20083,0,'ASSET-PUBLISHER-RICH-SUMMARY-FTL','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Rich Summary</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Displays abstracts, icons, related assets, and print/edit actions for assets. Optionally include asset bookmarks and ratings.</Description></root>','display','','ftl','<#assign liferay_ui = taglibLiferayHash[\"/WEB-INF/tld/liferay-ui.tld\"] />\n\n<#list entries as entry>\n	<#assign entry = entry />\n\n	<#assign assetRenderer = entry.getAssetRenderer() />\n\n	<#assign entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale)) />\n\n	<#assign viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entry) />\n\n	<#if assetLinkBehavior != \"showFullContent\">\n		<#assign viewURL = assetPublisherHelperImpl.getAssetViewURL(renderRequest, renderResponse, entry, true) />\n	</#if>\n\n	<div class=\"asset-abstract\">\n		<div class=\"lfr-meta-actions asset-actions\">\n			<@getPrintIcon />\n\n			<@getFlagsIcon />\n\n			<@getEditIcon />\n		</div>\n\n		<h3 class=\"asset-title\">\n			<a href=\"${viewURL}\"><img alt=\"\" src=\"${assetRenderer.getIconPath(renderRequest)}\" />${entryTitle}</a>\n		</h3>\n\n		<@getMetadataField fieldName=\"tags\" />\n\n		<@getMetadataField fieldName=\"create-date\" />\n\n		<@getMetadataField fieldName=\"view-count\" />\n\n		<div class=\"asset-content\">\n			<@getSocialBookmarks />\n\n			<div class=\"asset-summary\">\n				<@getMetadataField fieldName=\"author\" />\n\n				${htmlUtil.escape(assetRenderer.getSummary(locale))}\n\n				<a href=\"${viewURL}\"><@liferay.language key=\"read-more\" /><span class=\"hide-accessible\"><@liferay.language key=\"about\" />${entryTitle}</span> &raquo;</a>\n			</div>\n\n			<@getRatings />\n\n			<@getRelatedAssets />\n\n			<@getDiscussion />\n		</div>\n	</div>\n\n</#list>\n\n<#macro getDiscussion>\n	<#if validator.isNotNull(assetRenderer.getDiscussionPath()) && (enableComments == \"true\")>\n		<br />\n\n		<#assign discussionURL = renderResponse.createActionURL() />\n\n		${discussionURL.setParameter(\"struts_action\", \"/asset_publisher/\" + assetRenderer.getDiscussionPath())}\n\n		<@liferay_ui[\"discussion\"]\n			className=entry.getClassName()\n			classPK=entry.getClassPK()\n			formAction=discussionURL?string\n			formName=\"fm\" + entry.getClassPK()\n			ratingsEnabled=enableCommentRatings == \"true\"\n			redirect=portalUtil.getCurrentURL(request)\n			userId=assetRenderer.getUserId()\n		/>\n	</#if>\n</#macro>\n\n<#macro getEditIcon>\n	<#if assetRenderer.hasEditPermission(themeDisplay.getPermissionChecker())>\n		<#assign redirectURL = renderResponse.createRenderURL() />\n\n		${redirectURL.setParameter(\"struts_action\", \"/asset_publisher/add_asset_redirect\")}\n		${redirectURL.setWindowState(\"pop_up\")}\n\n		<#assign editPortletURL = assetRenderer.getURLEdit(renderRequest, renderResponse, windowStateFactory.getWindowState(\"pop_up\"), redirectURL)!\"\" />\n\n		<#if validator.isNotNull(editPortletURL)>\n			<#assign title = languageUtil.format(locale, \"edit-x\", entryTitle) />\n\n			<@liferay_ui[\"icon\"]\n				image=\"edit\"\n				message=title\n				url=\"javascript:Liferay.Util.openWindow({dialog: {width: 960}, id:\'\" + renderResponse.getNamespace() + \"editAsset\', title: \'\" + title + \"\', uri:\'\" + htmlUtil.escapeURL(editPortletURL.toString()) + \"\'});\"\n			/>\n		</#if>\n	</#if>\n</#macro>\n\n<#macro getFlagsIcon>\n	<#if enableFlags == \"true\">\n		<@liferay_ui[\"flags\"]\n			className=entry.getClassName()\n			classPK=entry.getClassPK()\n			contentTitle=entry.getTitle(locale)\n			label=false\n			reportedUserId=entry.getUserId()\n		/>\n	</#if>\n</#macro>\n\n<#macro getMetadataField\n	fieldName\n>\n	<#if stringUtil.split(metadataFields)?seq_contains(fieldName)>\n		<span class=\"metadata-entry metadata-\"${fieldName}\">\n			<#assign dateFormat = \"dd MMM yyyy - HH:mm:ss\" />\n\n			<#if fieldName == \"author\">\n				<@liferay.language key=\"by\" /> ${portalUtil.getUserName(assetRenderer.getUserId(), assetRenderer.getUserName())}\n			<#elseif fieldName == \"categories\">\n				<@liferay_ui[\"asset-categories-summary\"]\n					className=entry.getClassName()\n					classPK=entry.getClassPK()\n					portletURL=renderResponse.createRenderURL()\n				/>\n			<#elseif fieldName == \"create-date\">\n				${dateUtil.getDate(entry.getCreateDate(), dateFormat, locale)}\n			<#elseif fieldName == \"expiration-date\">\n				${dateUtil.getDate(entry.getExpirationDate(), dateFormat, locale)}\n			<#elseif fieldName == \"modified-date\">\n				${dateUtil.getDate(entry.getModifiedDate(), dateFormat, locale)}\n			<#elseif fieldName == \"priority\">\n				${entry.getPriority()}\n			<#elseif fieldName == \"publish-date\">\n				${dateUtil.getDate(entry.getPublishDate(), dateFormat, locale)}\n			<#elseif fieldName == \"tags\">\n				<@liferay_ui[\"asset-tags-summary\"]\n					className=entry.getClassName()\n					classPK=entry.getClassPK()\n					portletURL=renderResponse.createRenderURL()\n				/>\n			<#elseif fieldName == \"view-count\">\n				<@liferay_ui[\"icon\"]\n					image=\"history\"\n				/>\n\n				${entry.getViewCount()} <@liferay.language key=\"views\" />\n			</#if>\n		</span>\n	</#if>\n</#macro>\n\n<#macro getPrintIcon>\n	<#if enablePrint == \"true\" >\n		<#assign printURL = renderResponse.createRenderURL() />\n\n		${printURL.setParameter(\"struts_action\", \"/asset_publisher/view_content\")}\n		${printURL.setParameter(\"assetEntryId\", entry.getEntryId()?string)}\n		${printURL.setParameter(\"viewMode\", \"print\")}\n		${printURL.setParameter(\"type\", entry.getAssetRendererFactory().getType())}\n\n		<#if (validator.isNotNull(assetRenderer.getUrlTitle()))>\n			<#if (assetRenderer.getGroupId() != themeDisplay.getScopeGroupId())>\n				${printURL.setParameter(\"groupId\", assetRenderer.getGroupId()?string)}\n			</#if>\n\n			${printURL.setParameter(\"urlTitle\", assetRenderer.getUrlTitle())}\n		</#if>\n\n		${printURL.setWindowState(\"pop_up\")}\n\n		<@liferay_ui[\"icon\"]\n			image=\"print\"\n			message=\"print\"\n			url=\"javascript:Liferay.Util.openWindow({id:\'\" + renderResponse.getNamespace() + \"printAsset\', title: \'\" + languageUtil.format(locale, \"print-x-x\", [\"hide-accessible\", entryTitle]) + \"\', uri: \'\" + htmlUtil.escapeURL(printURL.toString()) + \"\'});\"\n		/>\n	</#if>\n</#macro>\n\n<#macro getRatings>\n	<#if (enableRatings == \"true\")>\n		<div class=\"asset-ratings\">\n			<@liferay_ui[\"ratings\"]\n				className=entry.getClassName()\n				classPK=entry.getClassPK()\n			/>\n		</div>\n	</#if>\n</#macro>\n\n<#macro getRelatedAssets>\n	<#if enableRelatedAssets == \"true\">\n		<@liferay_ui[\"asset-links\"]\n			assetEntryId=entry.getEntryId()\n		/>\n	</#if>\n</#macro>\n\n<#macro getSocialBookmarks>\n	<#if enableSocialBookmarks == \"true\">\n		<@liferay_ui[\"social-bookmarks\"]\n			displayStyle=\"${socialBookmarksDisplayStyle}\"\n			target=\"_blank\"\n			title=entry.getTitle(locale)\n			url=viewURL\n		/>\n	</#if>\n</#macro>',0,0,20426,''),('47949d3d-a236-4415-95a2-92533740d344',20427,20194,20154,20158,'','2016-06-30 20:52:22','2016-06-30 20:52:22',20034,0,'SITE-MAP-MULTI-COLUMN-LAYOUT-FTL','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Multi Column Layout</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Displays a column for each top level page. Each column includes the name of a top level page with the page\'s immediate children listed underneath.</Description></root>','display','','ftl','<#assign aui = taglibLiferayHash[\"/WEB-INF/tld/aui.tld\"] />\n\n<#if entries?has_content>\n	<@aui.layout>\n		<#list entries as entry>\n		    <@aui.column columnWidth=25>\n				<div class=\"results-header\">\n					<h3>\n						<#assign layoutURL = portalUtil.getLayoutURL(entry, themeDisplay)>\n\n						<a href=\"${layoutURL}\">${entry.getName(locale)}</a>\n					</h3>\n				</div>\n\n				<#assign pages = entry.getChildren()>\n\n				<@displayPages pages = pages />\n		    </@aui.column>\n		</#list>\n	</@aui.layout>\n</#if>\n\n<#macro displayPages\n	pages\n>\n	<#if pages?has_content>\n		<ul class=\"child-pages\">\n			<#list pages as page>\n				<li>\n					<#assign pageLayoutURL = portalUtil.getLayoutURL(page, themeDisplay)>\n\n					<a href=\"${pageLayoutURL}\">${page.getName(locale)}</a>\n\n					<#assign childPages = page.getChildren()>\n\n					<@displayPages pages = childPages />\n				</li>\n			</#list>\n		</ul>\n	</#if>\n</#macro>',0,0,20428,''),('e78ea109-17bd-4439-8572-7ff8c7a067ef',20429,20194,20154,20158,'','2016-06-30 20:52:22','2016-06-30 20:52:22',20085,0,'ASSET-TAGS-NAVIGATION-COLOR-BY-POPULARITY-FTL','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Color by Popularity</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Displays asset tags colored by popularity: red (high), yellow (medium), and green (low).</Description></root>','display','','ftl','<#if entries?has_content>\n	<ul class=\"tag-items tag-list\">\n		<#assign scopeGroupId = getterUtil.getLong(scopeGroupId, themeDisplay.getScopeGroupId()) />\n		<#assign classNameId = getterUtil.getLong(classNameId, 0) />\n\n		<#assign maxCount = 1 />\n		<#assign minCount = 1 />\n\n		<#list entries as entry>\n			<#assign maxCount = liferay.max(maxCount, entry.getAssetCount()) />\n			<#assign minCount = liferay.min(minCount, entry.getAssetCount()) />\n		</#list>\n\n		<#assign multiplier = 1 />\n\n		<#if maxCount != minCount>\n			<#assign multiplier = 3 / (maxCount - minCount) />\n		</#if>\n\n		<#list entries as entry>\n			<li class=\"taglib-asset-tags-summary\">\n				<#assign popularity = (maxCount - (maxCount - (entry.getAssetCount() - minCount))) * multiplier />\n\n				<#if popularity < 1>\n					<#assign color = \"green\" />\n				<#elseif (popularity >= 1) && (popularity < 2)>\n					<#assign color = \"orange\" />\n				<#else>\n					<#assign color = \"red\" />\n				</#if>\n\n				<#assign tagURL = renderResponse.createRenderURL() />\n\n				${tagURL.setParameter(\"resetCur\", \"true\")}\n				${tagURL.setParameter(\"tag\", entry.getName())}\n\n				<a class =\"tag\" style=\"color: ${color};\" href=\"${tagURL}\">\n					${entry.getName()}\n\n					<#if (showAssetCount == \"true\")>\n						<span class=\"tag-asset-count\">(${count})</span>\n					</#if>\n				</a>\n			</li>\n		</#list>\n	</ul>\n\n	<br style=\"clear: both;\" />\n</#if>',0,0,20430,''),('ba1f3a74-1c2f-4fe9-9ee8-93c238c183cf',20431,20194,20154,20158,'','2016-06-30 20:52:23','2016-06-30 20:52:23',20007,0,'BLOGS-BASIC-FTL','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Basic</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Displays titles, authors, and abstracts compactly for blog entries.</Description></root>','display','','ftl','<#assign liferay_ui = taglibLiferayHash[\"/WEB-INF/tld/liferay-ui.tld\"] />\n\n<#list entries as entry>\n	<div class=\"entry\">\n		<#assign viewURL = renderResponse.createRenderURL() />\n\n		${viewURL.setParameter(\"struts_action\", \"/blogs/view_entry\")}\n		${viewURL.setParameter(\"redirect\", currentURL)}\n		${viewURL.setParameter(\"urlTitle\", entry.getUrlTitle())}\n\n		<div class=\"entry-content\">\n			<div class=\"entry-title\">\n				<h2><a href=\"${viewURL}\">${htmlUtil.escape(entry.getTitle())}</a></h2>\n			</div>\n		</div>\n\n		<div class=\"entry-body\">\n			<div class=\"entry-author\">\n				<@liferay.language key=\"written-by\" /> ${htmlUtil.escape(portalUtil.getUserName(entry.getUserId(), entry.getUserName()))}\n			</div>\n\n			<#assign summary = entry.getDescription() />\n\n			<#if (validator.isNull(summary))>\n				<#assign summary = entry.getContent() />\n			</#if>\n\n			${stringUtil.shorten(htmlUtil.stripHtml(summary), 100)}\n\n			<a href=\"${viewURL}\"><@liferay.language key=\"read-more\" /> <span class=\"hide-accessible\"><@liferay.language key=\"about\"/>${htmlUtil.escape(entry.getTitle())}</span> &raquo;</a>\n		</div>\n\n		<div class=\"entry-footer\">\n			<span class=\"entry-date\">\n				${dateUtil.getDate(entry.getCreateDate(), \"dd MMM yyyy - HH:mm:ss\", locale)}\n			</span>\n\n			<#assign blogsEntryClassName = \"com.liferay.portlet.blogs.model.BlogsEntry\" />\n\n			<#if (enableFlags == \"true\")>\n				<@liferay_ui[\"flags\"]\n					className=blogsEntryClassName\n					classPK=entry.getEntryId()\n					contentTitle=entry.getTitle()\n					reportedUserId=entry.getUserId()\n				/>\n			</#if>\n\n			<span class=\"entry-categories\">\n				<@liferay_ui[\"asset-categories-summary\"]\n					className=blogsEntryClassName\n					classPK=entry.getEntryId()\n					portletURL=renderResponse.createRenderURL()\n				/>\n			</span>\n\n			<span class=\"entry-tags\">\n				<@liferay_ui[\"asset-tags-summary\"]\n					className=blogsEntryClassName\n					classPK=entry.getEntryId()\n					portletURL=renderResponse.createRenderURL()\n				/>\n			</span>\n		</div>\n	</div>\n\n	<div class=\"separator\"><!-- --></div>\n</#list>',0,0,20432,'');
/*!40000 ALTER TABLE `ddmtemplate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dlcontent`
--

DROP TABLE IF EXISTS `dlcontent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dlcontent` (
  `contentId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `repositoryId` bigint(20) DEFAULT NULL,
  `path_` varchar(255) DEFAULT NULL,
  `version` varchar(75) DEFAULT NULL,
  `data_` longblob,
  `size_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`contentId`),
  UNIQUE KEY `IX_FDD1AAA8` (`companyId`,`repositoryId`,`path_`,`version`),
  KEY `IX_6A83A66A` (`companyId`,`repositoryId`),
  KEY `IX_EB531760` (`companyId`,`repositoryId`,`path_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dlcontent`
--

LOCK TABLES `dlcontent` WRITE;
/*!40000 ALTER TABLE `dlcontent` DISABLE KEYS */;
/*!40000 ALTER TABLE `dlcontent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dlfileentry`
--

DROP TABLE IF EXISTS `dlfileentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dlfileentry` (
  `uuid_` varchar(75) DEFAULT NULL,
  `fileEntryId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `repositoryId` bigint(20) DEFAULT NULL,
  `folderId` bigint(20) DEFAULT NULL,
  `treePath` longtext,
  `name` varchar(255) DEFAULT NULL,
  `extension` varchar(75) DEFAULT NULL,
  `mimeType` varchar(75) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` longtext,
  `extraSettings` longtext,
  `fileEntryTypeId` bigint(20) DEFAULT NULL,
  `version` varchar(75) DEFAULT NULL,
  `size_` bigint(20) DEFAULT NULL,
  `readCount` int(11) DEFAULT NULL,
  `smallImageId` bigint(20) DEFAULT NULL,
  `largeImageId` bigint(20) DEFAULT NULL,
  `custom1ImageId` bigint(20) DEFAULT NULL,
  `custom2ImageId` bigint(20) DEFAULT NULL,
  `manualCheckInRequired` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`fileEntryId`),
  UNIQUE KEY `IX_5391712` (`groupId`,`folderId`,`name`),
  UNIQUE KEY `IX_ED5CA615` (`groupId`,`folderId`,`title`),
  UNIQUE KEY `IX_BC2E7E6A` (`uuid_`,`groupId`),
  KEY `IX_4CB1B2B4` (`companyId`),
  KEY `IX_772ECDE7` (`fileEntryTypeId`),
  KEY `IX_8F6C75D0` (`folderId`,`name`),
  KEY `IX_F4AF5636` (`groupId`),
  KEY `IX_93CF8193` (`groupId`,`folderId`),
  KEY `IX_29D0AF28` (`groupId`,`folderId`,`fileEntryTypeId`),
  KEY `IX_43261870` (`groupId`,`userId`),
  KEY `IX_D20C434D` (`groupId`,`userId`,`folderId`),
  KEY `IX_D9492CF6` (`mimeType`),
  KEY `IX_1B352F4A` (`repositoryId`,`folderId`),
  KEY `IX_64F0FE40` (`uuid_`),
  KEY `IX_31079DE8` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dlfileentry`
--

LOCK TABLES `dlfileentry` WRITE;
/*!40000 ALTER TABLE `dlfileentry` DISABLE KEYS */;
/*!40000 ALTER TABLE `dlfileentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dlfileentrymetadata`
--

DROP TABLE IF EXISTS `dlfileentrymetadata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dlfileentrymetadata` (
  `uuid_` varchar(75) DEFAULT NULL,
  `fileEntryMetadataId` bigint(20) NOT NULL,
  `DDMStorageId` bigint(20) DEFAULT NULL,
  `DDMStructureId` bigint(20) DEFAULT NULL,
  `fileEntryTypeId` bigint(20) DEFAULT NULL,
  `fileEntryId` bigint(20) DEFAULT NULL,
  `fileVersionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`fileEntryMetadataId`),
  UNIQUE KEY `IX_7332B44F` (`DDMStructureId`,`fileVersionId`),
  KEY `IX_4F40FE5E` (`fileEntryId`),
  KEY `IX_A44636C9` (`fileEntryId`,`fileVersionId`),
  KEY `IX_F8E90438` (`fileEntryTypeId`),
  KEY `IX_1FE9C04` (`fileVersionId`),
  KEY `IX_D49AB5D1` (`uuid_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dlfileentrymetadata`
--

LOCK TABLES `dlfileentrymetadata` WRITE;
/*!40000 ALTER TABLE `dlfileentrymetadata` DISABLE KEYS */;
/*!40000 ALTER TABLE `dlfileentrymetadata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dlfileentrytype`
--

DROP TABLE IF EXISTS `dlfileentrytype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dlfileentrytype` (
  `uuid_` varchar(75) DEFAULT NULL,
  `fileEntryTypeId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `fileEntryTypeKey` varchar(75) DEFAULT NULL,
  `name` longtext,
  `description` longtext,
  PRIMARY KEY (`fileEntryTypeId`),
  UNIQUE KEY `IX_5B6BEF5F` (`groupId`,`fileEntryTypeKey`),
  UNIQUE KEY `IX_1399D844` (`uuid_`,`groupId`),
  KEY `IX_4501FD9C` (`groupId`),
  KEY `IX_90724726` (`uuid_`),
  KEY `IX_5B03E942` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dlfileentrytype`
--

LOCK TABLES `dlfileentrytype` WRITE;
/*!40000 ALTER TABLE `dlfileentrytype` DISABLE KEYS */;
INSERT INTO `dlfileentrytype` VALUES ('c6e03901-ee00-4d97-8e31-c851b96c6850',0,0,0,0,'','2016-06-30 20:51:55','2016-06-30 20:51:55','BASIC-DOCUMENT','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Name language-id=\"en_US\">basic-document</Name></root>',''),('d7f80596-f6ce-474a-8c2d-8a81086a163e',20306,20194,20154,20158,'','2016-06-30 20:52:06','2016-06-30 20:52:06','CONTRACT','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Contract</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Contract</Description></root>'),('f11fdc5e-c300-4761-ac36-517405e040e6',20308,20194,20154,20158,'','2016-06-30 20:52:06','2016-06-30 20:52:06','MARKETING BANNER','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Marketing Banner</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Marketing Banner</Description></root>'),('bd448aa1-6d2f-4b8c-8a20-a0942174a0dc',20310,20194,20154,20158,'','2016-06-30 20:52:06','2016-06-30 20:52:06','ONLINE TRAINING','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Online Training</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Online Training</Description></root>'),('64799d61-6c44-432b-bb8a-2db80dfc9bdc',20312,20194,20154,20158,'','2016-06-30 20:52:06','2016-06-30 20:52:06','SALES PRESENTATION','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Sales Presentation</Name></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">Sales Presentation</Description></root>');
/*!40000 ALTER TABLE `dlfileentrytype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dlfileentrytypes_ddmstructures`
--

DROP TABLE IF EXISTS `dlfileentrytypes_ddmstructures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dlfileentrytypes_ddmstructures` (
  `structureId` bigint(20) NOT NULL,
  `fileEntryTypeId` bigint(20) NOT NULL,
  PRIMARY KEY (`structureId`,`fileEntryTypeId`),
  KEY `IX_8373EC7C` (`fileEntryTypeId`),
  KEY `IX_F147CF3F` (`structureId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dlfileentrytypes_ddmstructures`
--

LOCK TABLES `dlfileentrytypes_ddmstructures` WRITE;
/*!40000 ALTER TABLE `dlfileentrytypes_ddmstructures` DISABLE KEYS */;
INSERT INTO `dlfileentrytypes_ddmstructures` VALUES (20307,20306),(20304,20308),(20309,20308),(20303,20310),(20311,20310),(20305,20312),(20313,20312);
/*!40000 ALTER TABLE `dlfileentrytypes_ddmstructures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dlfileentrytypes_dlfolders`
--

DROP TABLE IF EXISTS `dlfileentrytypes_dlfolders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dlfileentrytypes_dlfolders` (
  `fileEntryTypeId` bigint(20) NOT NULL,
  `folderId` bigint(20) NOT NULL,
  PRIMARY KEY (`fileEntryTypeId`,`folderId`),
  KEY `IX_5BB6AD6C` (`fileEntryTypeId`),
  KEY `IX_6E00A2EC` (`folderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dlfileentrytypes_dlfolders`
--

LOCK TABLES `dlfileentrytypes_dlfolders` WRITE;
/*!40000 ALTER TABLE `dlfileentrytypes_dlfolders` DISABLE KEYS */;
/*!40000 ALTER TABLE `dlfileentrytypes_dlfolders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dlfilerank`
--

DROP TABLE IF EXISTS `dlfilerank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dlfilerank` (
  `fileRankId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `fileEntryId` bigint(20) DEFAULT NULL,
  `active_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`fileRankId`),
  UNIQUE KEY `IX_38F0315` (`companyId`,`userId`,`fileEntryId`),
  KEY `IX_A65A1F8B` (`fileEntryId`),
  KEY `IX_BAFB116E` (`groupId`,`userId`),
  KEY `IX_4E96195B` (`groupId`,`userId`,`active_`),
  KEY `IX_EED06670` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dlfilerank`
--

LOCK TABLES `dlfilerank` WRITE;
/*!40000 ALTER TABLE `dlfilerank` DISABLE KEYS */;
/*!40000 ALTER TABLE `dlfilerank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dlfileshortcut`
--

DROP TABLE IF EXISTS `dlfileshortcut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dlfileshortcut` (
  `uuid_` varchar(75) DEFAULT NULL,
  `fileShortcutId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `repositoryId` bigint(20) DEFAULT NULL,
  `folderId` bigint(20) DEFAULT NULL,
  `toFileEntryId` bigint(20) DEFAULT NULL,
  `treePath` longtext,
  `active_` tinyint(4) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`fileShortcutId`),
  UNIQUE KEY `IX_FDB4A946` (`uuid_`,`groupId`),
  KEY `IX_A4BB2E58` (`companyId`),
  KEY `IX_8571953E` (`companyId`,`status`),
  KEY `IX_B0051937` (`groupId`,`folderId`),
  KEY `IX_348DC3B2` (`groupId`,`folderId`,`active_`),
  KEY `IX_17EE3098` (`groupId`,`folderId`,`active_`,`status`),
  KEY `IX_4B7247F6` (`toFileEntryId`),
  KEY `IX_4831EBE4` (`uuid_`),
  KEY `IX_29AE81C4` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dlfileshortcut`
--

LOCK TABLES `dlfileshortcut` WRITE;
/*!40000 ALTER TABLE `dlfileshortcut` DISABLE KEYS */;
/*!40000 ALTER TABLE `dlfileshortcut` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dlfileversion`
--

DROP TABLE IF EXISTS `dlfileversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dlfileversion` (
  `uuid_` varchar(75) DEFAULT NULL,
  `fileVersionId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `repositoryId` bigint(20) DEFAULT NULL,
  `folderId` bigint(20) DEFAULT NULL,
  `fileEntryId` bigint(20) DEFAULT NULL,
  `treePath` longtext,
  `extension` varchar(75) DEFAULT NULL,
  `mimeType` varchar(75) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` longtext,
  `changeLog` varchar(75) DEFAULT NULL,
  `extraSettings` longtext,
  `fileEntryTypeId` bigint(20) DEFAULT NULL,
  `version` varchar(75) DEFAULT NULL,
  `size_` bigint(20) DEFAULT NULL,
  `checksum` varchar(75) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`fileVersionId`),
  UNIQUE KEY `IX_E2815081` (`fileEntryId`,`version`),
  UNIQUE KEY `IX_C99B2650` (`uuid_`,`groupId`),
  KEY `IX_F389330E` (`companyId`),
  KEY `IX_A0A283F4` (`companyId`,`status`),
  KEY `IX_C68DC967` (`fileEntryId`),
  KEY `IX_D47BB14D` (`fileEntryId`,`status`),
  KEY `IX_DFD809D3` (`groupId`,`folderId`,`status`),
  KEY `IX_9BE769ED` (`groupId`,`folderId`,`title`,`version`),
  KEY `IX_FFB3395C` (`mimeType`),
  KEY `IX_4BFABB9A` (`uuid_`),
  KEY `IX_95E9E44E` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dlfileversion`
--

LOCK TABLES `dlfileversion` WRITE;
/*!40000 ALTER TABLE `dlfileversion` DISABLE KEYS */;
/*!40000 ALTER TABLE `dlfileversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dlfolder`
--

DROP TABLE IF EXISTS `dlfolder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dlfolder` (
  `uuid_` varchar(75) DEFAULT NULL,
  `folderId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `repositoryId` bigint(20) DEFAULT NULL,
  `mountPoint` tinyint(4) DEFAULT NULL,
  `parentFolderId` bigint(20) DEFAULT NULL,
  `treePath` longtext,
  `name` varchar(100) DEFAULT NULL,
  `description` longtext,
  `lastPostDate` datetime DEFAULT NULL,
  `defaultFileEntryTypeId` bigint(20) DEFAULT NULL,
  `hidden_` tinyint(4) DEFAULT NULL,
  `overrideFileEntryTypes` tinyint(4) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`folderId`),
  UNIQUE KEY `IX_902FD874` (`groupId`,`parentFolderId`,`name`),
  UNIQUE KEY `IX_3CC1DED2` (`uuid_`,`groupId`),
  KEY `IX_A74DB14C` (`companyId`),
  KEY `IX_E79BE432` (`companyId`,`status`),
  KEY `IX_F2EA1ACE` (`groupId`),
  KEY `IX_F78286C5` (`groupId`,`mountPoint`,`parentFolderId`,`hidden_`),
  KEY `IX_C88430AB` (`groupId`,`mountPoint`,`parentFolderId`,`hidden_`,`status`),
  KEY `IX_49C37475` (`groupId`,`parentFolderId`),
  KEY `IX_CE360BF6` (`groupId`,`parentFolderId`,`hidden_`,`status`),
  KEY `IX_51556082` (`parentFolderId`,`name`),
  KEY `IX_EE29C715` (`repositoryId`),
  KEY `IX_CBC408D8` (`uuid_`),
  KEY `IX_DA448450` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dlfolder`
--

LOCK TABLES `dlfolder` WRITE;
/*!40000 ALTER TABLE `dlfolder` DISABLE KEYS */;
INSERT INTO `dlfolder` VALUES ('e1e34896-88f7-4539-93fa-fa92b200d501',20848,20194,20154,20158,'','2016-07-01 10:09:15','2016-07-01 10:09:15',20847,1,0,'/20848/','20','','2016-07-01 10:09:16',0,1,0,0,0,'',NULL),('7d23cdc8-7043-4c09-8774-661da7b42ad6',20849,20194,20154,20198,'Test Test','2016-07-01 10:09:16','2016-07-01 10:09:16',20847,0,20848,'/20848/20849/','20198','','2016-07-01 10:09:17',0,0,0,0,0,'',NULL),('bffe2dfc-cd4d-433b-bb4e-64912959cbb5',20850,20194,20154,20198,'Test Test','2016-07-01 10:09:16','2016-07-01 10:09:16',20847,0,20849,'/20848/20849/20850/','c04f8cdb685f7b905abc9e7e323c800ff8d08c2936c6b5ca153edfdd90850a0f','','2016-07-01 10:09:16',0,0,0,0,0,'',NULL),('0a1237fe-e4bd-4be5-b202-0d983d5968e2',20852,20194,20154,20198,'Test Test','2016-07-01 10:09:17','2016-07-01 10:09:17',20847,0,20849,'/20848/20849/20852/','83293aff52e6204538a107043fd5064ea57e819745f7a43bc2a1abbe7e4c1714','','2016-07-01 10:09:17',0,0,0,0,0,'',NULL);
/*!40000 ALTER TABLE `dlfolder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dlsyncevent`
--

DROP TABLE IF EXISTS `dlsyncevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dlsyncevent` (
  `syncEventId` bigint(20) NOT NULL,
  `modifiedTime` bigint(20) DEFAULT NULL,
  `event` varchar(75) DEFAULT NULL,
  `type_` varchar(75) DEFAULT NULL,
  `typePK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`syncEventId`),
  UNIQUE KEY `IX_57D82B06` (`typePK`),
  KEY `IX_3D8E1607` (`modifiedTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dlsyncevent`
--

LOCK TABLES `dlsyncevent` WRITE;
/*!40000 ALTER TABLE `dlsyncevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `dlsyncevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emailaddress`
--

DROP TABLE IF EXISTS `emailaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emailaddress` (
  `uuid_` varchar(75) DEFAULT NULL,
  `emailAddressId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `address` varchar(75) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `primary_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`emailAddressId`),
  KEY `IX_1BB072CA` (`companyId`),
  KEY `IX_49D2DEC4` (`companyId`,`classNameId`),
  KEY `IX_551A519F` (`companyId`,`classNameId`,`classPK`),
  KEY `IX_2A2CB130` (`companyId`,`classNameId`,`classPK`,`primary_`),
  KEY `IX_7B43CD8` (`userId`),
  KEY `IX_D24F3956` (`uuid_`),
  KEY `IX_F74AB912` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emailaddress`
--

LOCK TABLES `emailaddress` WRITE;
/*!40000 ALTER TABLE `emailaddress` DISABLE KEYS */;
/*!40000 ALTER TABLE `emailaddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expandocolumn`
--

DROP TABLE IF EXISTS `expandocolumn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expandocolumn` (
  `columnId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `tableId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  `defaultData` longtext,
  `typeSettings` longtext,
  PRIMARY KEY (`columnId`),
  UNIQUE KEY `IX_FEFC8DA7` (`tableId`,`name`),
  KEY `IX_A8C0CBE8` (`tableId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expandocolumn`
--

LOCK TABLES `expandocolumn` WRITE;
/*!40000 ALTER TABLE `expandocolumn` DISABLE KEYS */;
INSERT INTO `expandocolumn` VALUES (20442,20154,20441,'clientId',15,'','');
/*!40000 ALTER TABLE `expandocolumn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expandorow`
--

DROP TABLE IF EXISTS `expandorow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expandorow` (
  `rowId_` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `tableId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`rowId_`),
  UNIQUE KEY `IX_81EFBFF5` (`tableId`,`classPK`),
  KEY `IX_49EB3118` (`classPK`),
  KEY `IX_D3F5D7AE` (`tableId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expandorow`
--

LOCK TABLES `expandorow` WRITE;
/*!40000 ALTER TABLE `expandorow` DISABLE KEYS */;
/*!40000 ALTER TABLE `expandorow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expandotable`
--

DROP TABLE IF EXISTS `expandotable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expandotable` (
  `tableId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`tableId`),
  UNIQUE KEY `IX_37562284` (`companyId`,`classNameId`,`name`),
  KEY `IX_B5AE8A85` (`companyId`,`classNameId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expandotable`
--

LOCK TABLES `expandotable` WRITE;
/*!40000 ALTER TABLE `expandotable` DISABLE KEYS */;
INSERT INTO `expandotable` VALUES (20509,20154,20002,'OPEN_SOCIAL_DATA_'),(20441,20154,20005,'MP'),(20510,20154,20005,'OPEN_SOCIAL_DATA_');
/*!40000 ALTER TABLE `expandotable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expandovalue`
--

DROP TABLE IF EXISTS `expandovalue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expandovalue` (
  `valueId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `tableId` bigint(20) DEFAULT NULL,
  `columnId` bigint(20) DEFAULT NULL,
  `rowId_` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `data_` longtext,
  PRIMARY KEY (`valueId`),
  UNIQUE KEY `IX_9DDD21E5` (`columnId`,`rowId_`),
  UNIQUE KEY `IX_D27B03E7` (`tableId`,`columnId`,`classPK`),
  KEY `IX_B29FEF17` (`classNameId`,`classPK`),
  KEY `IX_F7DD0987` (`columnId`),
  KEY `IX_9112A7A0` (`rowId_`),
  KEY `IX_F0566A77` (`tableId`),
  KEY `IX_1BD3F4C` (`tableId`,`classPK`),
  KEY `IX_CA9AFB7C` (`tableId`,`columnId`),
  KEY `IX_B71E92D5` (`tableId`,`rowId_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expandovalue`
--

LOCK TABLES `expandovalue` WRITE;
/*!40000 ALTER TABLE `expandovalue` DISABLE KEYS */;
/*!40000 ALTER TABLE `expandovalue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_`
--

DROP TABLE IF EXISTS `group_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_` (
  `uuid_` varchar(75) DEFAULT NULL,
  `groupId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `creatorUserId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `parentGroupId` bigint(20) DEFAULT NULL,
  `liveGroupId` bigint(20) DEFAULT NULL,
  `treePath` longtext,
  `name` varchar(150) DEFAULT NULL,
  `description` longtext,
  `type_` int(11) DEFAULT NULL,
  `typeSettings` longtext,
  `manualMembership` tinyint(4) DEFAULT NULL,
  `membershipRestriction` int(11) DEFAULT NULL,
  `friendlyURL` varchar(255) DEFAULT NULL,
  `site` tinyint(4) DEFAULT NULL,
  `remoteStagingGroupCount` int(11) DEFAULT NULL,
  `active_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`groupId`),
  UNIQUE KEY `IX_D0D5E397` (`companyId`,`classNameId`,`classPK`),
  UNIQUE KEY `IX_5DE0BE11` (`companyId`,`classNameId`,`liveGroupId`,`name`),
  UNIQUE KEY `IX_5BDDB872` (`companyId`,`friendlyURL`),
  UNIQUE KEY `IX_BBCA55B` (`companyId`,`liveGroupId`,`name`),
  UNIQUE KEY `IX_5AA68501` (`companyId`,`name`),
  UNIQUE KEY `IX_754FBB1C` (`uuid_`,`groupId`),
  KEY `IX_ABA5CEC2` (`companyId`),
  KEY `IX_B584B5CC` (`companyId`,`classNameId`),
  KEY `IX_ABE2D54` (`companyId`,`classNameId`,`parentGroupId`),
  KEY `IX_5D75499E` (`companyId`,`parentGroupId`),
  KEY `IX_6C499099` (`companyId`,`parentGroupId`,`site`),
  KEY `IX_63A2AABD` (`companyId`,`site`),
  KEY `IX_16218A38` (`liveGroupId`),
  KEY `IX_7B590A7A` (`type_`,`active_`),
  KEY `IX_F981514E` (`uuid_`),
  KEY `IX_26CC761A` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_`
--

LOCK TABLES `group_` WRITE;
/*!40000 ALTER TABLE `group_` DISABLE KEYS */;
INSERT INTO `group_` VALUES ('ea04d45f-1a69-4182-ad6a-3522003e591d',20172,20154,20158,20001,20172,0,0,'/20172/','Control Panel','',3,'',1,0,'/control_panel',0,0,1),('2b92f2f7-72f8-4961-9b62-c7ce8d32bb96',20181,20154,20158,20001,20181,0,0,'/20181/','Guest','',1,'breadcrumbShowParentGroups=true\ncontentSharingWithChildrenEnabled=-1\ndirectoryIndexingEnabled=false\nfalse-robots.txt=User-Agent: *_SAFE_NEWLINE_CHARACTER_Disallow:_SAFE_NEWLINE_CHARACTER_Sitemap: http://localhost/sitemap.xml\ninheritLocales=true\nlanguageId=zh_CN\nlocales=ca_ES,zh_CN,en_US,fi_FI,fr_FR,de_DE,iw_IL,hu_HU,ja_JP,pt_BR,es_ES\ntrashEnabled=true\n',1,0,'/jtjs',1,0,1),('66b1a4cf-9edc-4c1f-bb89-56c458f0be3e',20191,20154,20158,20190,20158,0,0,'/20191/','User Personal Site','',3,'',1,0,'/personal_site',0,0,1),('2336a2d8-fc85-40f0-b212-ad839b8e5f06',20194,20154,20158,20025,20154,0,0,'/20194/','20154','',0,'',1,0,'/global',1,0,1),('4dc8c42b-2b83-4cb9-9ede-854b72b37b8d',20201,20154,20198,20005,20198,0,0,'/20201/','20198','',0,'',1,0,'/test',0,0,1),('fd3d481c-de3e-4942-a4ab-e2ee55e39e41',20317,20154,20158,20032,20316,0,0,'/20317/','20316','',0,'',1,0,'/template-20316',0,0,1),('c5cf968d-8d09-455d-88b9-ce12b0a79524',20329,20154,20158,20032,20328,0,0,'/20329/','20328','',0,'',1,0,'/template-20328',0,0,1),('6fedcce5-cc4d-4209-b68c-413720a364e8',20339,20154,20158,20032,20338,0,0,'/20339/','20338','',0,'',1,0,'/template-20338',0,0,1),('89c6e713-033b-49ea-a1f3-1a81d8f985fa',20350,20154,20158,20036,20349,0,0,'/20350/','20349','',0,'',1,0,'/template-20349',0,0,1),('b83a542a-0a8a-4031-a7cf-a9b2c1dbcd04',20376,20154,20158,20036,20375,0,0,'/20376/','20375','',0,'',1,0,'/template-20375',0,0,1),('72846382-c9b2-43c5-872c-3fddf6637df2',20608,20154,20198,20001,20608,0,0,'/20608/','综合信息服务系统','',1,'breadcrumbShowParentGroups=true\ncontentSharingWithChildrenEnabled=-1\ndirectoryIndexingEnabled=false\ninheritLocales=true\nlanguageId=zh_CN\nlocales=ca_ES,zh_CN,en_US,fi_FI,fr_FR,de_DE,iw_IL,hu_HU,ja_JP,pt_BR,es_ES\ntrashEnabled=true\n',1,0,'/zhxx',1,0,1),('8df814fe-7552-47b3-af9b-870c563e8874',20731,20154,20198,20001,20731,0,0,'/20731/','工程项目管理系统','',1,'breadcrumbShowParentGroups=true\ncontentSharingWithChildrenEnabled=-1\ndirectoryIndexingEnabled=false\ninheritLocales=true\nlanguageId=zh_CN\nlocales=ca_ES,zh_CN,en_US,fi_FI,fr_FR,de_DE,iw_IL,hu_HU,ja_JP,pt_BR,es_ES\ntrashEnabled=true\n',1,0,'/gcxm',1,0,1),('b3efdc29-4c7a-47e0-8058-e83f31be801e',20735,20154,20198,20001,20735,0,0,'/20735/','从业主体综合管理系统','',1,'breadcrumbShowParentGroups=true\ncontentSharingWithChildrenEnabled=-1\ntrashEnabled=true\n',1,0,'/-',1,0,1),('73270c00-4d9f-4d75-bb16-91596ac78190',20856,20154,20198,20003,20855,0,0,'/20856/','上海市交通建设工程管理中心 LFR_ORGANIZATION','',3,'',0,0,'/-1',0,0,1),('bed77f4e-aba9-43fa-9d1e-af30f0b6db29',20862,20154,20198,20003,20861,0,0,'/20862/','中心领导 LFR_ORGANIZATION','',3,'',0,0,'/-2',0,0,1),('8843c7e2-2a04-40f4-8522-b85b21b42cc6',20868,20154,20198,20003,20867,0,0,'/20868/','办公室 LFR_ORGANIZATION','',3,'',0,0,'/-3',0,0,1),('65dc2742-2ca9-4ab7-887b-9852d2c9892f',20874,20154,20198,20003,20873,0,0,'/20874/','组织人事科（监察室） LFR_ORGANIZATION','',3,'',0,0,'/-4',0,0,1),('97b7f3f9-a872-4e6a-8ebf-c29ba8947741',20882,20154,20198,20003,20881,0,0,'/20882/','财务科 LFR_ORGANIZATION','',3,'',0,0,'/-5',0,0,1),('232d31c5-56ee-4bdc-ab05-586d0f666f6b',20888,20154,20198,20003,20887,0,0,'/20888/','市场监管科 LFR_ORGANIZATION','',3,'',0,0,'/-6',0,0,1),('669880fa-2dac-438a-9f29-e4adad6fd0b4',20894,20154,20198,20003,20893,0,0,'/20894/','科技信息科 LFR_ORGANIZATION','',3,'',0,0,'/-7',0,0,1),('f2d6618f-02bb-401a-8cf3-2aed96ee0364',20900,20154,20198,20003,20899,0,0,'/20900/','综合管理科（执法监督科） LFR_ORGANIZATION','',3,'',0,0,'/-8',0,0,1),('90a4d85f-0d65-4f67-ae05-91bdabcb9caf',20906,20154,20198,20003,20905,0,0,'/20906/','交通工程科 LFR_ORGANIZATION','',3,'',0,0,'/-9',0,0,1),('6ce558e0-bf12-419d-b22a-b74efc0c74a9',20912,20154,20198,20003,20911,0,0,'/20912/','市政工程科 LFR_ORGANIZATION','',3,'',0,0,'/-10',0,0,1),('30f09a4b-5e6d-4419-8532-98a978a84aa6',20941,20154,20939,20005,20939,0,0,'/20941/','20939','',0,'',1,0,'/yangzhijie',0,0,1);
/*!40000 ALTER TABLE `group_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups_orgs`
--

DROP TABLE IF EXISTS `groups_orgs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups_orgs` (
  `groupId` bigint(20) NOT NULL,
  `organizationId` bigint(20) NOT NULL,
  PRIMARY KEY (`groupId`,`organizationId`),
  KEY `IX_75267DCA` (`groupId`),
  KEY `IX_6BBB7682` (`organizationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups_orgs`
--

LOCK TABLES `groups_orgs` WRITE;
/*!40000 ALTER TABLE `groups_orgs` DISABLE KEYS */;
INSERT INTO `groups_orgs` VALUES (20608,20861);
/*!40000 ALTER TABLE `groups_orgs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups_roles`
--

DROP TABLE IF EXISTS `groups_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups_roles` (
  `groupId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`groupId`,`roleId`),
  KEY `IX_84471FD2` (`groupId`),
  KEY `IX_3103EF3D` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups_roles`
--

LOCK TABLES `groups_roles` WRITE;
/*!40000 ALTER TABLE `groups_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups_usergroups`
--

DROP TABLE IF EXISTS `groups_usergroups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups_usergroups` (
  `groupId` bigint(20) NOT NULL,
  `userGroupId` bigint(20) NOT NULL,
  PRIMARY KEY (`groupId`,`userGroupId`),
  KEY `IX_31FB749A` (`groupId`),
  KEY `IX_3B69160F` (`userGroupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups_usergroups`
--

LOCK TABLES `groups_usergroups` WRITE;
/*!40000 ALTER TABLE `groups_usergroups` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups_usergroups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `imageId` bigint(20) NOT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `type_` varchar(75) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `size_` int(11) DEFAULT NULL,
  PRIMARY KEY (`imageId`),
  KEY `IX_6A925A4D` (`size_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journalarticle`
--

DROP TABLE IF EXISTS `journalarticle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journalarticle` (
  `uuid_` varchar(75) DEFAULT NULL,
  `id_` bigint(20) NOT NULL,
  `resourcePrimKey` bigint(20) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `folderId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `treePath` longtext,
  `articleId` varchar(75) DEFAULT NULL,
  `version` double DEFAULT NULL,
  `title` longtext,
  `urlTitle` varchar(150) DEFAULT NULL,
  `description` longtext,
  `content` longtext,
  `type_` varchar(75) DEFAULT NULL,
  `structureId` varchar(75) DEFAULT NULL,
  `templateId` varchar(75) DEFAULT NULL,
  `layoutUuid` varchar(75) DEFAULT NULL,
  `displayDate` datetime DEFAULT NULL,
  `expirationDate` datetime DEFAULT NULL,
  `reviewDate` datetime DEFAULT NULL,
  `indexable` tinyint(4) DEFAULT NULL,
  `smallImage` tinyint(4) DEFAULT NULL,
  `smallImageId` bigint(20) DEFAULT NULL,
  `smallImageURL` longtext,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id_`),
  UNIQUE KEY `IX_85C52EEC` (`groupId`,`articleId`,`version`),
  UNIQUE KEY `IX_3463D95B` (`uuid_`,`groupId`),
  KEY `IX_FF0E7A72` (`classNameId`,`templateId`),
  KEY `IX_DFF98523` (`companyId`),
  KEY `IX_323DF109` (`companyId`,`status`),
  KEY `IX_3D070845` (`companyId`,`version`),
  KEY `IX_E82F322B` (`companyId`,`version`,`status`),
  KEY `IX_EA05E9E1` (`displayDate`,`status`),
  KEY `IX_9356F865` (`groupId`),
  KEY `IX_68C0F69C` (`groupId`,`articleId`),
  KEY `IX_4D5CD982` (`groupId`,`articleId`,`status`),
  KEY `IX_9CE6E0FA` (`groupId`,`classNameId`,`classPK`),
  KEY `IX_A2534AC2` (`groupId`,`classNameId`,`layoutUuid`),
  KEY `IX_91E78C35` (`groupId`,`classNameId`,`structureId`),
  KEY `IX_F43B9FF2` (`groupId`,`classNameId`,`templateId`),
  KEY `IX_5CD17502` (`groupId`,`folderId`),
  KEY `IX_F35391E8` (`groupId`,`folderId`,`status`),
  KEY `IX_3C028C1E` (`groupId`,`layoutUuid`),
  KEY `IX_301D024B` (`groupId`,`status`),
  KEY `IX_2E207659` (`groupId`,`structureId`),
  KEY `IX_8DEAE14E` (`groupId`,`templateId`),
  KEY `IX_22882D02` (`groupId`,`urlTitle`),
  KEY `IX_D2D249E8` (`groupId`,`urlTitle`,`status`),
  KEY `IX_D19C1B9F` (`groupId`,`userId`),
  KEY `IX_43A0F80F` (`groupId`,`userId`,`classNameId`),
  KEY `IX_3F1EA19E` (`layoutUuid`),
  KEY `IX_33F49D16` (`resourcePrimKey`),
  KEY `IX_89FF8B06` (`resourcePrimKey`,`indexable`),
  KEY `IX_451D63EC` (`resourcePrimKey`,`indexable`,`status`),
  KEY `IX_3E2765FC` (`resourcePrimKey`,`status`),
  KEY `IX_EF9B7028` (`smallImageId`),
  KEY `IX_8E8710D9` (`structureId`),
  KEY `IX_9106F6CE` (`templateId`),
  KEY `IX_F029602F` (`uuid_`),
  KEY `IX_71520099` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journalarticle`
--

LOCK TABLES `journalarticle` WRITE;
/*!40000 ALTER TABLE `journalarticle` DISABLE KEYS */;
/*!40000 ALTER TABLE `journalarticle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journalarticleimage`
--

DROP TABLE IF EXISTS `journalarticleimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journalarticleimage` (
  `articleImageId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `articleId` varchar(75) DEFAULT NULL,
  `version` double DEFAULT NULL,
  `elInstanceId` varchar(75) DEFAULT NULL,
  `elName` varchar(75) DEFAULT NULL,
  `languageId` varchar(75) DEFAULT NULL,
  `tempImage` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`articleImageId`),
  UNIQUE KEY `IX_103D6207` (`groupId`,`articleId`,`version`,`elInstanceId`,`elName`,`languageId`),
  KEY `IX_3B51BB68` (`groupId`),
  KEY `IX_158B526F` (`groupId`,`articleId`,`version`),
  KEY `IX_D4121315` (`tempImage`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journalarticleimage`
--

LOCK TABLES `journalarticleimage` WRITE;
/*!40000 ALTER TABLE `journalarticleimage` DISABLE KEYS */;
/*!40000 ALTER TABLE `journalarticleimage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journalarticleresource`
--

DROP TABLE IF EXISTS `journalarticleresource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journalarticleresource` (
  `uuid_` varchar(75) DEFAULT NULL,
  `resourcePrimKey` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `articleId` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`resourcePrimKey`),
  UNIQUE KEY `IX_88DF994A` (`groupId`,`articleId`),
  UNIQUE KEY `IX_84AB0309` (`uuid_`,`groupId`),
  KEY `IX_F8433677` (`groupId`),
  KEY `IX_DCD1FAC1` (`uuid_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journalarticleresource`
--

LOCK TABLES `journalarticleresource` WRITE;
/*!40000 ALTER TABLE `journalarticleresource` DISABLE KEYS */;
/*!40000 ALTER TABLE `journalarticleresource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journalcontentsearch`
--

DROP TABLE IF EXISTS `journalcontentsearch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journalcontentsearch` (
  `contentSearchId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `privateLayout` tinyint(4) DEFAULT NULL,
  `layoutId` bigint(20) DEFAULT NULL,
  `portletId` varchar(200) DEFAULT NULL,
  `articleId` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`contentSearchId`),
  UNIQUE KEY `IX_C3AA93B8` (`groupId`,`privateLayout`,`layoutId`,`portletId`,`articleId`),
  KEY `IX_9207CB31` (`articleId`),
  KEY `IX_6838E427` (`groupId`,`articleId`),
  KEY `IX_20962903` (`groupId`,`privateLayout`),
  KEY `IX_7CC7D73E` (`groupId`,`privateLayout`,`articleId`),
  KEY `IX_B3B318DC` (`groupId`,`privateLayout`,`layoutId`),
  KEY `IX_7ACC74C9` (`groupId`,`privateLayout`,`layoutId`,`portletId`),
  KEY `IX_8DAF8A35` (`portletId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journalcontentsearch`
--

LOCK TABLES `journalcontentsearch` WRITE;
/*!40000 ALTER TABLE `journalcontentsearch` DISABLE KEYS */;
/*!40000 ALTER TABLE `journalcontentsearch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journalfeed`
--

DROP TABLE IF EXISTS `journalfeed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journalfeed` (
  `uuid_` varchar(75) DEFAULT NULL,
  `id_` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `feedId` varchar(75) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `description` longtext,
  `type_` varchar(75) DEFAULT NULL,
  `structureId` varchar(75) DEFAULT NULL,
  `templateId` varchar(75) DEFAULT NULL,
  `rendererTemplateId` varchar(75) DEFAULT NULL,
  `delta` int(11) DEFAULT NULL,
  `orderByCol` varchar(75) DEFAULT NULL,
  `orderByType` varchar(75) DEFAULT NULL,
  `targetLayoutFriendlyUrl` varchar(255) DEFAULT NULL,
  `targetPortletId` varchar(75) DEFAULT NULL,
  `contentField` varchar(75) DEFAULT NULL,
  `feedFormat` varchar(75) DEFAULT NULL,
  `feedVersion` double DEFAULT NULL,
  PRIMARY KEY (`id_`),
  UNIQUE KEY `IX_65576CBC` (`groupId`,`feedId`),
  UNIQUE KEY `IX_39031F51` (`uuid_`,`groupId`),
  KEY `IX_35A2DB2F` (`groupId`),
  KEY `IX_50C36D79` (`uuid_`),
  KEY `IX_CB37A10F` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journalfeed`
--

LOCK TABLES `journalfeed` WRITE;
/*!40000 ALTER TABLE `journalfeed` DISABLE KEYS */;
/*!40000 ALTER TABLE `journalfeed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journalfolder`
--

DROP TABLE IF EXISTS `journalfolder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journalfolder` (
  `uuid_` varchar(75) DEFAULT NULL,
  `folderId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `parentFolderId` bigint(20) DEFAULT NULL,
  `treePath` longtext,
  `name` varchar(100) DEFAULT NULL,
  `description` longtext,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`folderId`),
  UNIQUE KEY `IX_65026705` (`groupId`,`parentFolderId`,`name`),
  UNIQUE KEY `IX_E002061` (`uuid_`,`groupId`),
  KEY `IX_E6E2725D` (`companyId`),
  KEY `IX_C36B0443` (`companyId`,`status`),
  KEY `IX_742DEC1F` (`groupId`),
  KEY `IX_E988689E` (`groupId`,`name`),
  KEY `IX_190483C6` (`groupId`,`parentFolderId`),
  KEY `IX_EFD9CAC` (`groupId`,`parentFolderId`,`status`),
  KEY `IX_63BDFA69` (`uuid_`),
  KEY `IX_54F89E1F` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journalfolder`
--

LOCK TABLES `journalfolder` WRITE;
/*!40000 ALTER TABLE `journalfolder` DISABLE KEYS */;
/*!40000 ALTER TABLE `journalfolder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleoaction`
--

DROP TABLE IF EXISTS `kaleoaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleoaction` (
  `kaleoActionId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoClassName` varchar(200) DEFAULT NULL,
  `kaleoClassPK` bigint(20) DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `kaleoNodeName` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `description` longtext,
  `executionType` varchar(20) DEFAULT NULL,
  `script` longtext,
  `scriptLanguage` varchar(75) DEFAULT NULL,
  `scriptRequiredContexts` longtext,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`kaleoActionId`),
  KEY `IX_50E9112C` (`companyId`),
  KEY `IX_170EFD7A` (`kaleoClassName`,`kaleoClassPK`),
  KEY `IX_4B2545E8` (`kaleoClassName`,`kaleoClassPK`,`executionType`),
  KEY `IX_F95A622` (`kaleoDefinitionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleoaction`
--

LOCK TABLES `kaleoaction` WRITE;
/*!40000 ALTER TABLE `kaleoaction` DISABLE KEYS */;
INSERT INTO `kaleoaction` VALUES (20470,0,20154,20158,'','2016-06-30 20:53:23','2016-06-30 20:53:23','com.liferay.portal.workflow.kaleo.model.KaleoNode',20469,20468,'update','reject','','onAssignment','\n					\n						Packages.com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil.updateStatus(Packages.com.liferay.portal.kernel.workflow.WorkflowConstants.toStatus(\"denied\"), workflowContext);\n						Packages.com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil.updateStatus(Packages.com.liferay.portal.kernel.workflow.WorkflowConstants.toStatus(\"pending\"), workflowContext);\n					\n				','javascript','',0),(20477,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24','com.liferay.portal.workflow.kaleo.model.KaleoNode',20476,20468,'approved','approve','','onEntry','\n					\n						import com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil;\n						import com.liferay.portal.kernel.workflow.WorkflowConstants;\n\n						WorkflowStatusManagerUtil.updateStatus(WorkflowConstants.toStatus(\"approved\"), workflowContext);\n					\n				','groovy','',0);
/*!40000 ALTER TABLE `kaleoaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleocondition`
--

DROP TABLE IF EXISTS `kaleocondition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleocondition` (
  `kaleoConditionId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `kaleoNodeId` bigint(20) DEFAULT NULL,
  `script` longtext,
  `scriptLanguage` varchar(75) DEFAULT NULL,
  `scriptRequiredContexts` longtext,
  PRIMARY KEY (`kaleoConditionId`),
  KEY `IX_FEE46067` (`companyId`),
  KEY `IX_DC978A5D` (`kaleoDefinitionId`),
  KEY `IX_86CBD4C` (`kaleoNodeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleocondition`
--

LOCK TABLES `kaleocondition` WRITE;
/*!40000 ALTER TABLE `kaleocondition` DISABLE KEYS */;
/*!40000 ALTER TABLE `kaleocondition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleodefinition`
--

DROP TABLE IF EXISTS `kaleodefinition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleodefinition` (
  `kaleoDefinitionId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `title` longtext,
  `description` longtext,
  `content` longtext,
  `version` int(11) DEFAULT NULL,
  `active_` tinyint(4) DEFAULT NULL,
  `startKaleoNodeId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`kaleoDefinitionId`),
  KEY `IX_40B9112F` (`companyId`),
  KEY `IX_408542BA` (`companyId`,`active_`),
  KEY `IX_76C781AE` (`companyId`,`name`),
  KEY `IX_4C23F11B` (`companyId`,`name`,`active_`),
  KEY `IX_EC14F81A` (`companyId`,`name`,`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleodefinition`
--

LOCK TABLES `kaleodefinition` WRITE;
/*!40000 ALTER TABLE `kaleodefinition` DISABLE KEYS */;
INSERT INTO `kaleodefinition` VALUES (20468,0,20154,20158,'','2016-06-30 20:53:23','2016-06-30 20:53:24','Single Approver','Single Approver','A single approver can approve a workflow content.','<?xml version=\"1.0\"?>\n\n<workflow-definition xmlns=\"urn:liferay.com:liferay-workflow_6.2.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:liferay.com:liferay-workflow_6.2.0 http://www.liferay.com/dtd/liferay-workflow-definition_6_2_0.xsd\">\n	<name>Single Approver</name>\n	<description>A single approver can approve a workflow content.</description>\n	<version>1</version>\n	<state>\n		<name>created</name>\n		<metadata> <![CDATA[{\"xy\":[36,51]}]]> </metadata>\n		<initial>true</initial>\n		<transitions>\n			<transition>\n				<name>review</name>\n				<target>review</target>\n			</transition>\n		</transitions>\n	</state>\n	<task>\n		<name>update</name>\n		<metadata> <![CDATA[{\"transitions\":{\"resubmit\":{\"bendpoints\":[[303,140]]}},\"xy\":[328,199]}]]> </metadata>\n		<actions>\n			<action>\n				<name>reject</name>\n				<script> <![CDATA[\n						Packages.com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil.updateStatus(Packages.com.liferay.portal.kernel.workflow.WorkflowConstants.toStatus(\"denied\"), workflowContext);\n						Packages.com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil.updateStatus(Packages.com.liferay.portal.kernel.workflow.WorkflowConstants.toStatus(\"pending\"), workflowContext);\n					]]> </script>\n				<script-language>javascript</script-language>\n				<execution-type>onAssignment</execution-type>\n			</action>\n			<notification>\n				<name>Creator Modification Notification</name>\n				<template>Your submission was rejected by ${userName}, please modify and resubmit.</template>\n				<template-language>freemarker</template-language>\n				<notification-type>email</notification-type>\n				<notification-type>user-notification</notification-type>\n				<execution-type>onAssignment</execution-type>\n			</notification>\n		</actions>\n		<assignments>\n			<user/>\n		</assignments>\n		<transitions>\n			<transition>\n				<name>resubmit</name>\n				<target>review</target>\n			</transition>\n		</transitions>\n	</task>\n	<task>\n		<name>review</name>\n		<metadata> <![CDATA[{\"xy\":[168,36]}]]> </metadata>\n		<actions>\n			<notification>\n				<name>Review Notification</name>\n				<template>${userName} sent you a ${entryType} for review in the workflow.</template>\n				<template-language>freemarker</template-language>\n				<notification-type>email</notification-type>\n				<notification-type>user-notification</notification-type>\n				<execution-type>onAssignment</execution-type>\n			</notification>\n			<notification>\n				<name>Review Completion Notification</name>\n				<template>Your submission has been reviewed and the reviewer has applied the following ${taskComments}.</template>\n				<template-language>freemarker</template-language>\n				<notification-type>email</notification-type>\n				<recipients>\n					<user/>\n				</recipients>\n				<execution-type>onExit</execution-type>\n			</notification>\n		</actions>\n		<assignments>\n			<roles>\n				<role>\n					<role-type>organization</role-type>\n					<name>Organization Administrator</name>\n				</role>\n				<role>\n					<role-type>organization</role-type>\n					<name>Organization Content Reviewer</name>\n				</role>\n				<role>\n					<role-type>organization</role-type>\n					<name>Organization Owner</name>\n				</role>\n				<role>\n					<role-type>regular</role-type>\n					<name>Administrator</name>\n				</role>\n				<role>\n					<role-type>regular</role-type>\n					<name>Portal Content Reviewer</name>\n				</role>\n				<role>\n					<role-type>site</role-type>\n					<name>Site Administrator</name>\n				</role>\n				<role>\n					<role-type>site</role-type>\n					<name>Site Content Reviewer</name>\n				</role>\n				<role>\n					<role-type>site</role-type>\n					<name>Site Owner</name>\n				</role>\n			</roles>\n		</assignments>\n		<transitions>\n			<transition>\n				<name>approve</name>\n				<target>approved</target>\n			</transition>\n			<transition>\n				<name>reject</name>\n				<target>update</target>\n				<default>false</default>\n			</transition>\n		</transitions>\n	</task>\n	<state>\n		<name>approved</name>\n		<metadata> <![CDATA[\n				{\"xy\":[380,51]}\n			]]> </metadata>\n		<actions>\n			<action>\n				<name>approve</name>\n				<script> <![CDATA[\n						import com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil;\n						import com.liferay.portal.kernel.workflow.WorkflowConstants;\n\n						WorkflowStatusManagerUtil.updateStatus(WorkflowConstants.toStatus(\"approved\"), workflowContext);\n					]]> </script>\n				<script-language>groovy</script-language>\n				<execution-type>onEntry</execution-type>\n			</action>\n		</actions>\n	</state>\n</workflow-definition>',1,1,20478);
/*!40000 ALTER TABLE `kaleodefinition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleoinstance`
--

DROP TABLE IF EXISTS `kaleoinstance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleoinstance` (
  `kaleoInstanceId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `kaleoDefinitionName` varchar(200) DEFAULT NULL,
  `kaleoDefinitionVersion` int(11) DEFAULT NULL,
  `rootKaleoInstanceTokenId` bigint(20) DEFAULT NULL,
  `className` varchar(200) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `completed` tinyint(4) DEFAULT NULL,
  `completionDate` datetime DEFAULT NULL,
  `workflowContext` longtext,
  PRIMARY KEY (`kaleoInstanceId`),
  KEY `IX_58D85ECB` (`className`,`classPK`),
  KEY `IX_5F2FCD2D` (`companyId`),
  KEY `IX_BF5839F8` (`companyId`,`kaleoDefinitionName`,`kaleoDefinitionVersion`,`completionDate`),
  KEY `IX_C6D7A867` (`companyId`,`userId`),
  KEY `IX_4DA4D123` (`kaleoDefinitionId`),
  KEY `IX_ACF16238` (`kaleoDefinitionId`,`completed`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleoinstance`
--

LOCK TABLES `kaleoinstance` WRITE;
/*!40000 ALTER TABLE `kaleoinstance` DISABLE KEYS */;
/*!40000 ALTER TABLE `kaleoinstance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleoinstancetoken`
--

DROP TABLE IF EXISTS `kaleoinstancetoken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleoinstancetoken` (
  `kaleoInstanceTokenId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `kaleoInstanceId` bigint(20) DEFAULT NULL,
  `parentKaleoInstanceTokenId` bigint(20) DEFAULT NULL,
  `currentKaleoNodeId` bigint(20) DEFAULT NULL,
  `currentKaleoNodeName` varchar(200) DEFAULT NULL,
  `className` varchar(200) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `completed` tinyint(4) DEFAULT NULL,
  `completionDate` datetime DEFAULT NULL,
  PRIMARY KEY (`kaleoInstanceTokenId`),
  KEY `IX_153721BE` (`companyId`),
  KEY `IX_4A86923B` (`companyId`,`parentKaleoInstanceTokenId`),
  KEY `IX_360D34D9` (`companyId`,`parentKaleoInstanceTokenId`,`completionDate`),
  KEY `IX_7BDB04B4` (`kaleoDefinitionId`),
  KEY `IX_F42AAFF6` (`kaleoInstanceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleoinstancetoken`
--

LOCK TABLES `kaleoinstancetoken` WRITE;
/*!40000 ALTER TABLE `kaleoinstancetoken` DISABLE KEYS */;
/*!40000 ALTER TABLE `kaleoinstancetoken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleolog`
--

DROP TABLE IF EXISTS `kaleolog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleolog` (
  `kaleoLogId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoClassName` varchar(200) DEFAULT NULL,
  `kaleoClassPK` bigint(20) DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `kaleoInstanceId` bigint(20) DEFAULT NULL,
  `kaleoInstanceTokenId` bigint(20) DEFAULT NULL,
  `kaleoTaskInstanceTokenId` bigint(20) DEFAULT NULL,
  `kaleoNodeName` varchar(200) DEFAULT NULL,
  `terminalKaleoNode` tinyint(4) DEFAULT NULL,
  `kaleoActionId` bigint(20) DEFAULT NULL,
  `kaleoActionName` varchar(200) DEFAULT NULL,
  `kaleoActionDescription` longtext,
  `previousKaleoNodeId` bigint(20) DEFAULT NULL,
  `previousKaleoNodeName` varchar(200) DEFAULT NULL,
  `previousAssigneeClassName` varchar(200) DEFAULT NULL,
  `previousAssigneeClassPK` bigint(20) DEFAULT NULL,
  `currentAssigneeClassName` varchar(200) DEFAULT NULL,
  `currentAssigneeClassPK` bigint(20) DEFAULT NULL,
  `type_` varchar(50) DEFAULT NULL,
  `comment_` longtext,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `duration` bigint(20) DEFAULT NULL,
  `workflowContext` longtext,
  PRIMARY KEY (`kaleoLogId`),
  KEY `IX_73B5F4DE` (`companyId`),
  KEY `IX_E66A153A` (`kaleoClassName`,`kaleoClassPK`,`kaleoInstanceTokenId`,`type_`),
  KEY `IX_6C64B7D4` (`kaleoDefinitionId`),
  KEY `IX_5BC6AB16` (`kaleoInstanceId`),
  KEY `IX_470B9FF8` (`kaleoInstanceTokenId`,`type_`),
  KEY `IX_B0CDCA38` (`kaleoTaskInstanceTokenId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleolog`
--

LOCK TABLES `kaleolog` WRITE;
/*!40000 ALTER TABLE `kaleolog` DISABLE KEYS */;
/*!40000 ALTER TABLE `kaleolog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleonode`
--

DROP TABLE IF EXISTS `kaleonode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleonode` (
  `kaleoNodeId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `metadata` longtext,
  `description` longtext,
  `type_` varchar(20) DEFAULT NULL,
  `initial_` tinyint(4) DEFAULT NULL,
  `terminal` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`kaleoNodeId`),
  KEY `IX_C4E9ACE0` (`companyId`),
  KEY `IX_F28C443E` (`companyId`,`kaleoDefinitionId`),
  KEY `IX_32E94DD6` (`kaleoDefinitionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleonode`
--

LOCK TABLES `kaleonode` WRITE;
/*!40000 ALTER TABLE `kaleonode` DISABLE KEYS */;
INSERT INTO `kaleonode` VALUES (20469,0,20154,20158,'','2016-06-30 20:53:23','2016-06-30 20:53:23',20468,'update','\n			{\"transitions\":{\"resubmit\":{\"bendpoints\":[[303,140]]}},\"xy\":[328,199]}\n		','','TASK',0,0),(20476,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24',20468,'approved','\n			\n				{\"xy\":[380,51]}\n			\n		','','STATE',0,1),(20478,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24',20468,'created','\n			{\"xy\":[36,51]}\n		','','STATE',1,0),(20479,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24',20468,'review','\n			{\"xy\":[168,36]}\n		','','TASK',0,0);
/*!40000 ALTER TABLE `kaleonode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleonotification`
--

DROP TABLE IF EXISTS `kaleonotification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleonotification` (
  `kaleoNotificationId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoClassName` varchar(200) DEFAULT NULL,
  `kaleoClassPK` bigint(20) DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `kaleoNodeName` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `description` longtext,
  `executionType` varchar(20) DEFAULT NULL,
  `template` longtext,
  `templateLanguage` varchar(75) DEFAULT NULL,
  `notificationTypes` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`kaleoNotificationId`),
  KEY `IX_38829497` (`companyId`),
  KEY `IX_902D342F` (`kaleoClassName`,`kaleoClassPK`),
  KEY `IX_F3362E93` (`kaleoClassName`,`kaleoClassPK`,`executionType`),
  KEY `IX_4B968E8D` (`kaleoDefinitionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleonotification`
--

LOCK TABLES `kaleonotification` WRITE;
/*!40000 ALTER TABLE `kaleonotification` DISABLE KEYS */;
INSERT INTO `kaleonotification` VALUES (20471,0,20154,20158,'','2016-06-30 20:53:23','2016-06-30 20:53:23','com.liferay.portal.workflow.kaleo.model.KaleoNode',20469,20468,'update','Creator Modification Notification','','onAssignment','Your submission was rejected by ${userName}, please modify and resubmit.','freemarker','email,user-notification'),(20480,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24','com.liferay.portal.workflow.kaleo.model.KaleoNode',20479,20468,'review','Review Notification','','onAssignment','${userName} sent you a ${entryType} for review in the workflow.','freemarker','email,user-notification'),(20481,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24','com.liferay.portal.workflow.kaleo.model.KaleoNode',20479,20468,'review','Review Completion Notification','','onExit','\n					Your submission has been reviewed and the reviewer has applied the following ${taskComments}.','freemarker','email');
/*!40000 ALTER TABLE `kaleonotification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleonotificationrecipient`
--

DROP TABLE IF EXISTS `kaleonotificationrecipient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleonotificationrecipient` (
  `kaleoNotificationRecipientId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `kaleoNotificationId` bigint(20) DEFAULT NULL,
  `recipientClassName` varchar(200) DEFAULT NULL,
  `recipientClassPK` bigint(20) DEFAULT NULL,
  `recipientRoleType` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`kaleoNotificationRecipientId`),
  KEY `IX_2C8C4AF4` (`companyId`),
  KEY `IX_AA6697EA` (`kaleoDefinitionId`),
  KEY `IX_7F4FED02` (`kaleoNotificationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleonotificationrecipient`
--

LOCK TABLES `kaleonotificationrecipient` WRITE;
/*!40000 ALTER TABLE `kaleonotificationrecipient` DISABLE KEYS */;
INSERT INTO `kaleonotificationrecipient` VALUES (20482,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24',20468,20481,'com.liferay.portal.model.User',0,0,'');
/*!40000 ALTER TABLE `kaleonotificationrecipient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleotask`
--

DROP TABLE IF EXISTS `kaleotask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleotask` (
  `kaleoTaskId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `kaleoNodeId` bigint(20) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `description` longtext,
  PRIMARY KEY (`kaleoTaskId`),
  KEY `IX_E1F8B23D` (`companyId`),
  KEY `IX_3FFA633` (`kaleoDefinitionId`),
  KEY `IX_77B3F1A2` (`kaleoNodeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleotask`
--

LOCK TABLES `kaleotask` WRITE;
/*!40000 ALTER TABLE `kaleotask` DISABLE KEYS */;
INSERT INTO `kaleotask` VALUES (20472,0,20154,20158,'','2016-06-30 20:53:23','2016-06-30 20:53:23',20468,20469,'update',''),(20483,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24',20468,20479,'review','');
/*!40000 ALTER TABLE `kaleotask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleotaskassignment`
--

DROP TABLE IF EXISTS `kaleotaskassignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleotaskassignment` (
  `kaleoTaskAssignmentId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoClassName` varchar(200) DEFAULT NULL,
  `kaleoClassPK` bigint(20) DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `kaleoNodeId` bigint(20) DEFAULT NULL,
  `assigneeClassName` varchar(200) DEFAULT NULL,
  `assigneeClassPK` bigint(20) DEFAULT NULL,
  `assigneeActionId` varchar(75) DEFAULT NULL,
  `assigneeScript` longtext,
  `assigneeScriptLanguage` varchar(75) DEFAULT NULL,
  `assigneeScriptRequiredContexts` longtext,
  PRIMARY KEY (`kaleoTaskAssignmentId`),
  KEY `IX_611732B0` (`companyId`),
  KEY `IX_D835C576` (`kaleoClassName`,`kaleoClassPK`),
  KEY `IX_1087068E` (`kaleoClassName`,`kaleoClassPK`,`assigneeClassName`),
  KEY `IX_575C03A6` (`kaleoDefinitionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleotaskassignment`
--

LOCK TABLES `kaleotaskassignment` WRITE;
/*!40000 ALTER TABLE `kaleotaskassignment` DISABLE KEYS */;
INSERT INTO `kaleotaskassignment` VALUES (20475,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24','com.liferay.portal.workflow.kaleo.model.KaleoTask',20472,20468,0,'com.liferay.portal.model.User',0,'','','',''),(20484,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24','com.liferay.portal.workflow.kaleo.model.KaleoTask',20483,20468,0,'com.liferay.portal.model.Role',20161,'','','',''),(20485,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24','com.liferay.portal.workflow.kaleo.model.KaleoTask',20483,20468,0,'com.liferay.portal.model.Role',20486,'','','',''),(20487,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24','com.liferay.portal.workflow.kaleo.model.KaleoTask',20483,20468,0,'com.liferay.portal.model.Role',20488,'','','',''),(20489,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24','com.liferay.portal.workflow.kaleo.model.KaleoTask',20483,20468,0,'com.liferay.portal.model.Role',20490,'','','',''),(20491,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24','com.liferay.portal.workflow.kaleo.model.KaleoTask',20483,20468,0,'com.liferay.portal.model.Role',20171,'','','',''),(20492,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24','com.liferay.portal.workflow.kaleo.model.KaleoTask',20483,20468,0,'com.liferay.portal.model.Role',20169,'','','',''),(20493,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24','com.liferay.portal.workflow.kaleo.model.KaleoTask',20483,20468,0,'com.liferay.portal.model.Role',20166,'','','',''),(20494,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24','com.liferay.portal.workflow.kaleo.model.KaleoTask',20483,20468,0,'com.liferay.portal.model.Role',20167,'','','','');
/*!40000 ALTER TABLE `kaleotaskassignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleotaskassignmentinstance`
--

DROP TABLE IF EXISTS `kaleotaskassignmentinstance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleotaskassignmentinstance` (
  `kaleoTaskAssignmentInstanceId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `kaleoInstanceId` bigint(20) DEFAULT NULL,
  `kaleoInstanceTokenId` bigint(20) DEFAULT NULL,
  `kaleoTaskInstanceTokenId` bigint(20) DEFAULT NULL,
  `kaleoTaskId` bigint(20) DEFAULT NULL,
  `kaleoTaskName` varchar(200) DEFAULT NULL,
  `assigneeClassName` varchar(200) DEFAULT NULL,
  `assigneeClassPK` bigint(20) DEFAULT NULL,
  `completed` tinyint(4) DEFAULT NULL,
  `completionDate` datetime DEFAULT NULL,
  PRIMARY KEY (`kaleoTaskAssignmentInstanceId`),
  KEY `IX_945F4EB7` (`assigneeClassName`),
  KEY `IX_3BD436FD` (`assigneeClassName`,`assigneeClassPK`),
  KEY `IX_6E3CDA1B` (`companyId`),
  KEY `IX_38A47B17` (`groupId`,`assigneeClassPK`),
  KEY `IX_C851011` (`kaleoDefinitionId`),
  KEY `IX_67A9EE93` (`kaleoInstanceId`),
  KEY `IX_D4C2235B` (`kaleoTaskInstanceTokenId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleotaskassignmentinstance`
--

LOCK TABLES `kaleotaskassignmentinstance` WRITE;
/*!40000 ALTER TABLE `kaleotaskassignmentinstance` DISABLE KEYS */;
/*!40000 ALTER TABLE `kaleotaskassignmentinstance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleotaskinstancetoken`
--

DROP TABLE IF EXISTS `kaleotaskinstancetoken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleotaskinstancetoken` (
  `kaleoTaskInstanceTokenId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `kaleoInstanceId` bigint(20) DEFAULT NULL,
  `kaleoInstanceTokenId` bigint(20) DEFAULT NULL,
  `kaleoTaskId` bigint(20) DEFAULT NULL,
  `kaleoTaskName` varchar(200) DEFAULT NULL,
  `className` varchar(200) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `completionUserId` bigint(20) DEFAULT NULL,
  `completed` tinyint(4) DEFAULT NULL,
  `completionDate` datetime DEFAULT NULL,
  `dueDate` datetime DEFAULT NULL,
  `workflowContext` longtext,
  PRIMARY KEY (`kaleoTaskInstanceTokenId`),
  KEY `IX_A3271995` (`className`,`classPK`),
  KEY `IX_997FE723` (`companyId`),
  KEY `IX_608E9519` (`kaleoDefinitionId`),
  KEY `IX_2CE1159B` (`kaleoInstanceId`),
  KEY `IX_B857A115` (`kaleoInstanceId`,`kaleoTaskId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleotaskinstancetoken`
--

LOCK TABLES `kaleotaskinstancetoken` WRITE;
/*!40000 ALTER TABLE `kaleotaskinstancetoken` DISABLE KEYS */;
/*!40000 ALTER TABLE `kaleotaskinstancetoken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleotimer`
--

DROP TABLE IF EXISTS `kaleotimer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleotimer` (
  `kaleoTimerId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoClassName` varchar(200) DEFAULT NULL,
  `kaleoClassPK` bigint(20) DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `blocking` tinyint(4) DEFAULT NULL,
  `description` longtext,
  `duration` double DEFAULT NULL,
  `scale` varchar(75) DEFAULT NULL,
  `recurrenceDuration` double DEFAULT NULL,
  `recurrenceScale` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`kaleoTimerId`),
  KEY `IX_4DE6A889` (`kaleoClassName`,`kaleoClassPK`),
  KEY `IX_1A479F32` (`kaleoClassName`,`kaleoClassPK`,`blocking`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleotimer`
--

LOCK TABLES `kaleotimer` WRITE;
/*!40000 ALTER TABLE `kaleotimer` DISABLE KEYS */;
/*!40000 ALTER TABLE `kaleotimer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleotimerinstancetoken`
--

DROP TABLE IF EXISTS `kaleotimerinstancetoken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleotimerinstancetoken` (
  `kaleoTimerInstanceTokenId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoClassName` varchar(200) DEFAULT NULL,
  `kaleoClassPK` bigint(20) DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `kaleoInstanceId` bigint(20) DEFAULT NULL,
  `kaleoInstanceTokenId` bigint(20) DEFAULT NULL,
  `kaleoTaskInstanceTokenId` bigint(20) DEFAULT NULL,
  `kaleoTimerId` bigint(20) DEFAULT NULL,
  `kaleoTimerName` varchar(200) DEFAULT NULL,
  `blocking` tinyint(4) DEFAULT NULL,
  `completionUserId` bigint(20) DEFAULT NULL,
  `completed` tinyint(4) DEFAULT NULL,
  `completionDate` datetime DEFAULT NULL,
  `workflowContext` longtext,
  PRIMARY KEY (`kaleoTimerInstanceTokenId`),
  KEY `IX_DB96C55B` (`kaleoInstanceId`),
  KEY `IX_DB279423` (`kaleoInstanceTokenId`,`completed`),
  KEY `IX_9932524C` (`kaleoInstanceTokenId`,`completed`,`blocking`),
  KEY `IX_13A5BA2C` (`kaleoInstanceTokenId`,`kaleoTimerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleotimerinstancetoken`
--

LOCK TABLES `kaleotimerinstancetoken` WRITE;
/*!40000 ALTER TABLE `kaleotimerinstancetoken` DISABLE KEYS */;
/*!40000 ALTER TABLE `kaleotimerinstancetoken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaleotransition`
--

DROP TABLE IF EXISTS `kaleotransition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaleotransition` (
  `kaleoTransitionId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `kaleoDefinitionId` bigint(20) DEFAULT NULL,
  `kaleoNodeId` bigint(20) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `description` longtext,
  `sourceKaleoNodeId` bigint(20) DEFAULT NULL,
  `sourceKaleoNodeName` varchar(200) DEFAULT NULL,
  `targetKaleoNodeId` bigint(20) DEFAULT NULL,
  `targetKaleoNodeName` varchar(200) DEFAULT NULL,
  `defaultTransition` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`kaleoTransitionId`),
  KEY `IX_41D6C6D` (`companyId`),
  KEY `IX_479F3063` (`kaleoDefinitionId`),
  KEY `IX_A392DFD2` (`kaleoNodeId`),
  KEY `IX_A38E2194` (`kaleoNodeId`,`defaultTransition`),
  KEY `IX_85268A11` (`kaleoNodeId`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaleotransition`
--

LOCK TABLES `kaleotransition` WRITE;
/*!40000 ALTER TABLE `kaleotransition` DISABLE KEYS */;
INSERT INTO `kaleotransition` VALUES (20495,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24',20468,20469,'resubmit','',20469,'update',20479,'review',1),(20496,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24',20468,20478,'review','',20478,'created',20479,'review',1),(20497,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24',20468,20479,'approve','',20479,'review',20476,'approved',1),(20498,0,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24',20468,20479,'reject','',20479,'review',20469,'update',0);
/*!40000 ALTER TABLE `kaleotransition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `layout`
--

DROP TABLE IF EXISTS `layout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `layout` (
  `uuid_` varchar(75) DEFAULT NULL,
  `plid` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `privateLayout` tinyint(4) DEFAULT NULL,
  `layoutId` bigint(20) DEFAULT NULL,
  `parentLayoutId` bigint(20) DEFAULT NULL,
  `name` longtext,
  `title` longtext,
  `description` longtext,
  `keywords` longtext,
  `robots` longtext,
  `type_` varchar(75) DEFAULT NULL,
  `typeSettings` longtext,
  `hidden_` tinyint(4) DEFAULT NULL,
  `friendlyURL` varchar(255) DEFAULT NULL,
  `iconImage` tinyint(4) DEFAULT NULL,
  `iconImageId` bigint(20) DEFAULT NULL,
  `themeId` varchar(75) DEFAULT NULL,
  `colorSchemeId` varchar(75) DEFAULT NULL,
  `wapThemeId` varchar(75) DEFAULT NULL,
  `wapColorSchemeId` varchar(75) DEFAULT NULL,
  `css` longtext,
  `priority` int(11) DEFAULT NULL,
  `layoutPrototypeUuid` varchar(75) DEFAULT NULL,
  `layoutPrototypeLinkEnabled` tinyint(4) DEFAULT NULL,
  `sourcePrototypeLayoutUuid` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`plid`),
  UNIQUE KEY `IX_BC2C4231` (`groupId`,`privateLayout`,`friendlyURL`),
  UNIQUE KEY `IX_7162C27C` (`groupId`,`privateLayout`,`layoutId`),
  UNIQUE KEY `IX_E118C537` (`uuid_`,`groupId`,`privateLayout`),
  KEY `IX_C7FBC998` (`companyId`),
  KEY `IX_C099D61A` (`groupId`),
  KEY `IX_705F5AA3` (`groupId`,`privateLayout`),
  KEY `IX_6DE88B06` (`groupId`,`privateLayout`,`parentLayoutId`),
  KEY `IX_8CE8C0D9` (`groupId`,`privateLayout`,`sourcePrototypeLayoutUuid`),
  KEY `IX_1A1B61D2` (`groupId`,`privateLayout`,`type_`),
  KEY `IX_23922F7D` (`iconImageId`),
  KEY `IX_B529BFD3` (`layoutPrototypeUuid`),
  KEY `IX_39A18ECC` (`sourcePrototypeLayoutUuid`),
  KEY `IX_D0822724` (`uuid_`),
  KEY `IX_2CE4BE84` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layout`
--

LOCK TABLES `layout` WRITE;
/*!40000 ALTER TABLE `layout` DISABLE KEYS */;
INSERT INTO `layout` VALUES ('372279f0-c0bf-434f-bd70-c47970117705',20175,20172,20154,20158,'','2016-06-30 20:51:58','2016-06-30 20:51:58',1,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Name language-id=\"en_US\">Control Panel</Name></root>','','','','','control_panel','privateLayout=true\n',0,'/manage',0,0,'','','','','',0,'',0,''),('c3d26464-0405-427f-a3cd-62b9ae9aa951',20184,20181,20154,20158,'','2016-06-30 20:52:00','2016-07-01 09:48:44',0,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Name language-id=\"en_US\">Welcome</Name></root>','','','','','portlet','column-1=58,\ncolumn-2=184_INSTANCE_MCoV5B8xsCQ3\nlayout-template-id=2_columns_ii\n',0,'/home',0,0,'','','','','',0,'',0,''),('820c6fca-d2a0-45fc-82cc-915e5b14e39b',20320,20317,20154,20158,'','2016-06-30 20:52:07','2016-06-30 20:52:08',1,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Blog</Name></root>','','','','','portlet','column-1=33,\ncolumn-2=148_INSTANCE_mWmqEdahLqMP,114,\nlayout-template-id=2_columns_iii\nprivateLayout=true\n',0,'/layout',0,0,'','','','','',0,'',0,''),('a636956d-f17d-4367-bf9e-cde669c64777',20332,20329,20154,20158,'','2016-06-30 20:52:09','2016-06-30 20:52:11',1,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Content Display Page</Name></root>','','','','','portlet','column-1=141_INSTANCE_4CcB7CrDn3FC,122_INSTANCE_4wErzgn4RIBU,\ncolumn-2=3,101_INSTANCE_T4YbeRawCGZn,\ndefault-asset-publisher-portlet-id=101_INSTANCE_T4YbeRawCGZn\nlayout-template-id=2_columns_ii\nprivateLayout=true\n',0,'/layout',0,0,'','','','','',0,'',0,''),('e9974d07-6db8-4529-97c8-5e8d91196197',20342,20339,20154,20158,'','2016-06-30 20:52:11','2016-06-30 20:52:12',1,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Wiki</Name></root>','','','','','portlet','column-1=36,\ncolumn-2=122_INSTANCE_C8oODZqdkH2l,141_INSTANCE_2rhnCUy2CIOc,\nlayout-template-id=2_columns_iii\nprivateLayout=true\n',0,'/layout',0,0,'','','','','',0,'',0,''),('d116bbda-98a5-4e2c-9188-d92534cfa9b0',20361,20350,20154,20158,'','2016-06-30 20:52:14','2016-06-30 20:52:16',1,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Home</Name></root>','','','','','portlet','column-1=19,\ncolumn-2=3,59_INSTANCE_2BDkFraUiWdr,180,101_INSTANCE_3Ehai8qFPPux,\nlayout-template-id=2_columns_iii\nprivateLayout=true\n',0,'/home',0,0,'','','','','',0,'',0,''),('ef8e647d-d209-4b83-b3a0-4dc0b95654a9',20369,20350,20154,20158,'','2016-06-30 20:52:16','2016-06-30 20:52:16',1,2,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Wiki</Name></root>','','','','','portlet','column-1=36,\ncolumn-2=122_INSTANCE_xCrdj2xoHDuF,148_INSTANCE_qeZx14WKqejB,\nlayout-template-id=2_columns_iii\nprivateLayout=true\n',0,'/wiki',0,0,'','','','','',1,'',0,''),('ef4a2a45-d274-4cc9-9aa2-6364602d4aff',20387,20376,20154,20158,'','2016-06-30 20:52:17','2016-06-30 20:52:19',1,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Home</Name></root>','','','','','portlet','column-1=116,\ncolumn-2=3,82,101_INSTANCE_5r2gG79nrjNw,\nlayout-template-id=2_columns_i\nprivateLayout=true\n',0,'/home',0,0,'','','','','',0,'',0,''),('9ebedffd-ac03-4ba7-8ec7-0e509454a111',20396,20376,20154,20158,'','2016-06-30 20:52:19','2016-06-30 20:52:21',1,2,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Documents and Media</Name></root>','','','','','portlet','column-1=20,\ncolumn-2=101_INSTANCE_nODfUxlvAneS,\nlayout-template-id=1_column\nprivateLayout=true\n',0,'/documents',0,0,'','','','','',1,'',0,''),('86209957-f238-48e8-887f-3e86d87bebe2',20404,20376,20154,20158,'','2016-06-30 20:52:21','2016-06-30 20:52:21',1,3,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">News</Name></root>','','','','','portlet','column-1=39_INSTANCE_hdT9AX4ACu96,\ncolumn-2=39_INSTANCE_F26XmskYlWyj,\nlayout-template-id=2_columns_iii\nprivateLayout=true\n',0,'/news',0,0,'','','','','',2,'',0,''),('7eb2a42e-457e-481e-8e99-2f3f009ac374',20516,20201,20154,20198,'Test Test','2016-06-30 20:53:46','2016-06-30 20:53:47',1,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Welcome</Name></root>','','','','','portlet','column-1=82,23,11,\ncolumn-2=29,\nlayout-template-id=2_columns_ii\nprivateLayout=true\n',0,'/home',0,0,'','','','','',0,'',0,''),('248016cb-70cd-431e-8a9d-d77702e8f2d9',20522,20201,20154,20198,'Test Test','2016-06-30 20:53:47','2016-06-30 20:53:47',0,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Welcome</Name></root>','','','','','portlet','column-1=82,3,\ncolumn-2=33,\nlayout-template-id=2_columns_ii\n',0,'/home',0,0,'','','','','',0,'',0,''),('58deaaf0-c8ca-4a2e-9180-ed243a05552a',20615,20608,20154,20198,'Test Test','2016-07-01 09:14:33','2016-07-01 09:49:53',0,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">登录</Name></root>','','','','','portlet','column-1=58\nlayout-template-id=1_column\n',0,'/-',0,0,'','','','','',0,'',0,''),('049a8281-c7fa-48ef-b506-7bc5622c33fd',20621,20608,20154,20198,'Test Test','2016-07-01 09:15:08','2016-07-01 09:15:08',1,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">首页</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-',0,0,'','','','','',0,'',0,''),('86672cab-f039-43c2-9bf7-d4c3b1620467',20627,20608,20154,20198,'Test Test','2016-07-01 09:15:26','2016-07-01 09:15:26',1,2,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">信息发布</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-1',0,0,'','','','','',1,'',0,''),('e932a002-4478-4b78-9e80-0610d1028eb9',20633,20608,20154,20198,'Test Test','2016-07-01 09:15:50','2016-07-01 09:15:51',1,3,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">会议管理</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-2',0,0,'','','','','',2,'',0,''),('eb61eab5-a199-45cc-8a1d-bee2fbd74d79',20639,20608,20154,20198,'Test Test','2016-07-01 09:16:13','2016-07-01 09:16:13',1,4,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">一周工作</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-3',0,0,'','','','','',3,'',0,''),('d589e960-baf0-418c-8cb1-0e6dbe34ed11',20645,20608,20154,20198,'Test Test','2016-07-01 09:17:03','2016-07-05 18:42:48',1,5,4,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">领导一周工作安排</Name></root>','','','','','portlet','column-1=leaderweeklywork_WAR_oaportlet\nlayout-template-id=1_column\nlayoutUpdateable=true\nprivateLayout=true\n',0,'/-4',0,0,'classic','','','','',0,'',0,''),('3578ecf7-4b6b-4269-afca-0496f6a15d54',20651,20608,20154,20198,'Test Test','2016-07-01 09:17:14','2016-07-01 09:17:15',1,6,4,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">科室一周工作安排</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-5',0,0,'','','','','',1,'',0,''),('b3730cfc-567b-46fc-a93e-c2db16d72f34',20657,20608,20154,20198,'Test Test','2016-07-01 09:17:40','2016-07-05 18:43:26',1,7,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">车辆申请</Name></root>','','','','','portlet','column-1=vehiclerequisition_WAR_oaportlet\nlayout-template-id=1_column\nprivateLayout=true\n',0,'/-6',0,0,'','','','','',4,'',0,''),('daf00620-242d-487c-99bc-14fb3b131f06',20663,20608,20154,20198,'Test Test','2016-07-01 09:17:59','2016-07-01 09:17:59',1,8,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">办公用品管理</Name></root>','','','','','portlet','layout-template-id=2_columns_ii\nprivateLayout=true\n',0,'/-7',0,0,'','','','','',5,'',0,''),('8eab537f-ebe0-4541-93c7-0eb70f0d0612',20669,20608,20154,20198,'Test Test','2016-07-01 09:18:17','2016-07-05 18:49:44',1,9,8,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">办公用品库</Name></root>','','','','','portlet','column-1=officesupply_WAR_oaportlet\nlayout-template-id=1_column\nprivateLayout=true\n',0,'/-8',0,0,'','','','','',0,'',0,''),('ad1c9b8b-1925-4c9a-8452-a7e3fcadf105',20675,20608,20154,20198,'Test Test','2016-07-01 09:18:33','2016-07-01 09:18:34',1,10,8,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">办公用品申请</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-9',0,0,'','','','','',1,'',0,''),('9e5ef6bc-2074-46b0-aaa9-7b062bc5bb1a',20681,20608,20154,20198,'Test Test','2016-07-01 09:18:54','2016-07-01 09:18:54',1,11,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">工作督办</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-10',0,0,'','','','','',6,'',0,''),('716d0a9f-d408-48b7-b971-65886251a308',20687,20608,20154,20198,'Test Test','2016-07-01 09:19:10','2016-07-01 09:19:11',1,12,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">收发文管理</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-11',0,0,'','','','','',7,'',0,''),('c6ec7ed2-9c37-458d-affd-85798d4c5c79',20693,20608,20154,20198,'Test Test','2016-07-01 09:19:27','2016-07-01 09:19:28',1,13,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">邮件管理</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-12',0,0,'','','','','',8,'',0,''),('3be10952-a9ac-4cd9-a9d0-fce1f74d969e',20699,20608,20154,20198,'Test Test','2016-07-01 09:19:41','2016-07-05 16:08:15',1,14,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">系统管理</Name></root>','','','','','link_to_layout','column-1-customizable=false\ngroupId=20608\nlayout-template-id=1_column\nlayoutUpdateable=true\nlinkToLayoutId=17\nprivateLayout=true\n',0,'/-13',0,0,'classic','','','','',9,'',0,''),('6db3a03e-306c-408a-a868-d820419c5900',20713,20608,20154,20198,'Test Test','2016-07-01 09:28:45','2016-07-01 09:28:45',1,15,12,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">收文管理</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-14',0,0,'','','','','',0,'',0,''),('91b80734-1f69-4914-ab1c-918d1c48682b',20719,20608,20154,20198,'Test Test','2016-07-01 09:28:57','2016-07-05 18:44:11',1,16,12,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">发文管理</Name></root>','','','','','portlet','column-1=senddispatch_WAR_oaportlet\nlayout-template-id=1_column\nprivateLayout=true\n',0,'/-15',0,0,'','','','','',1,'',0,''),('b02782f9-9adb-4c0e-9515-17cc4bfc91f0',20725,20608,20154,20198,'Test Test','2016-07-01 09:29:21','2016-07-05 16:07:38',1,17,14,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">系统字典</Name></root>','','','','','portlet','column-1=dictionary_WAR_sysportlet\nlayout-template-id=1_column\nprivateLayout=true\n',0,'/-16',0,0,'','','','','',0,'',0,''),('267ca443-04cf-4e0b-bde3-a022d3735497',20739,20735,20154,20198,'Test Test','2016-07-01 09:32:54','2016-07-01 09:48:59',0,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">登录</Name></root>','','','','','portlet','column-1=58\nlayout-template-id=1_column\n',0,'/-',0,0,'','','','','',0,'',0,''),('0b3e0cb4-956d-4129-976e-7a949b373298',20745,20735,20154,20198,'Test Test','2016-07-01 09:33:22','2016-07-01 09:33:22',1,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">企业资质管理</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-',0,0,'','','','','',0,'',0,''),('b64e0c6e-9ace-45c2-a27b-a4d90f4cb7e1',20751,20735,20154,20198,'Test Test','2016-07-01 09:33:35','2016-07-01 09:33:36',1,2,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">人员资质管理</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-1',0,0,'','','','','',1,'',0,''),('ea9f77b1-db97-41b8-8fad-57212855d8d0',20757,20735,20154,20198,'Test Test','2016-07-01 09:33:48','2016-07-01 09:33:49',1,3,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">行政执法管理</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-2',0,0,'','','','','',2,'',0,''),('2dc7f01e-a664-448f-945a-b5f2a15f2606',20763,20735,20154,20198,'Test Test','2016-07-01 09:34:00','2016-07-01 09:34:00',1,4,2,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">注册人员资质</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-3',0,0,'','','','','',0,'',0,''),('414f8ea8-a6ce-4e8b-8d35-668343b373cf',20769,20735,20154,20198,'Test Test','2016-07-01 09:34:08','2016-07-01 09:34:08',1,5,2,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">三类人员资质</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-4',0,0,'','','','','',1,'',0,''),('a9d0c130-bf3f-4533-be8e-b69a1b45f00b',20775,20735,20154,20198,'Test Test','2016-07-01 09:34:33','2016-07-01 09:34:33',0,2,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">法律法规</Name></root>','','','','','portlet','layout-template-id=1_column\n',0,'/-1',0,0,'','','','','',1,'',0,''),('bc499388-5242-4dee-a0c3-74a7ecbedcfd',20783,20731,20154,20198,'Test Test','2016-07-01 09:35:16','2016-07-01 09:35:17',1,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">项目信息管理</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-',0,0,'','','','','',0,'',0,''),('5e7aa2b5-4e3a-4021-8453-261894f06389',20789,20731,20154,20198,'Test Test','2016-07-01 09:35:28','2016-07-01 09:35:29',1,2,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">项目填报管理</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-1',0,0,'','','','','',1,'',0,''),('a38046f5-8f7b-4eeb-a5e0-05d8b7c494d4',20795,20731,20154,20198,'Test Test','2016-07-01 09:36:01','2016-07-01 09:36:01',1,3,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">项目查询统计</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-2',0,0,'','','','','',2,'',0,''),('8a748e40-536d-4ed5-9294-e3a6722e921c',20801,20731,20154,20198,'Test Test','2016-07-01 09:36:13','2016-07-01 09:36:13',1,4,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">项目审批管理</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-3',0,0,'','','','','',3,'',0,''),('de90ee15-a186-4913-8684-be42611b76c6',20807,20731,20154,20198,'Test Test','2016-07-01 09:36:25','2016-07-01 09:36:26',1,5,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">系统管理</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-4',0,0,'','','','','',4,'',0,''),('476573eb-e8c4-4a0c-973e-62266852a278',20813,20731,20154,20198,'Test Test','2016-07-01 09:36:39','2016-07-05 19:08:55',1,6,5,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">系统字典</Name></root>','','','','','portlet','column-1=dictionary_WAR_sysportlet\nlayout-template-id=1_column\nprivateLayout=true\n',0,'/-5',0,0,'','','','','',0,'',0,''),('addfd999-2cc2-44b1-b3d6-f65abcfcde07',20821,20731,20154,20198,'Test Test','2016-07-01 09:42:09','2016-07-01 09:49:33',0,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">登录</Name></root>','','','','','portlet','column-1=58\nlayout-template-id=1_column\n',0,'/-',0,0,'','','','','',0,'',0,''),('020eb6df-42d2-407a-8ff4-ae03e32075f0',21138,20731,20154,20198,'Test Test','2016-07-05 20:00:48','2016-07-05 20:00:50',1,7,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">施工许可</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-6',0,0,'','','','','',5,'',0,''),('cb0a66d4-b33a-4f0e-9734-b34e5956aae1',21144,20731,20154,20198,'Test Test','2016-07-05 20:01:12','2016-07-05 20:01:12',1,8,7,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">市施工许可</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-7',0,0,'','','','','',0,'',0,''),('60918678-b139-4645-9a27-523ae76edaba',21150,20731,20154,20198,'Test Test','2016-07-05 20:01:28','2016-07-05 20:01:28',1,9,7,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">区县施工许可</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-8',0,0,'','','','','',1,'',0,''),('d8c209d2-8dbc-4c34-8d0e-22f50029087e',21156,20731,20154,20198,'Test Test','2016-07-05 20:02:32','2016-07-05 20:02:32',1,10,7,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">附件下载</Name></root>','','','','','portlet','layout-template-id=1_column\nprivateLayout=true\n',0,'/-9',0,0,'','','','','',2,'',0,''),('20a30797-1b2f-4adc-91df-18ec9d676e44',21168,20941,20154,20939,'杨志杰','2016-07-05 20:32:14','2016-07-05 20:32:14',1,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Welcome</Name></root>','','','','','portlet','column-1=82,23,11,\ncolumn-2=29,\nlayout-template-id=2_columns_ii\nprivateLayout=true\n',0,'/home',0,0,'','','','','',0,'',0,''),('9a02e9eb-9acd-43c4-8921-35456ff67103',21174,20941,20154,20939,'杨志杰','2016-07-05 20:32:14','2016-07-05 20:32:15',0,1,0,'<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Welcome</Name></root>','','','','','portlet','column-1=82,3,\ncolumn-2=33,\nlayout-template-id=2_columns_ii\n',0,'/home',0,0,'','','','','',0,'',0,'');
/*!40000 ALTER TABLE `layout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `layoutbranch`
--

DROP TABLE IF EXISTS `layoutbranch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `layoutbranch` (
  `LayoutBranchId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `layoutSetBranchId` bigint(20) DEFAULT NULL,
  `plid` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `description` longtext,
  `master` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`LayoutBranchId`),
  UNIQUE KEY `IX_FD57097D` (`layoutSetBranchId`,`plid`,`name`),
  KEY `IX_6C226433` (`layoutSetBranchId`),
  KEY `IX_2C42603E` (`layoutSetBranchId`,`plid`),
  KEY `IX_A705FF94` (`layoutSetBranchId`,`plid`,`master`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layoutbranch`
--

LOCK TABLES `layoutbranch` WRITE;
/*!40000 ALTER TABLE `layoutbranch` DISABLE KEYS */;
/*!40000 ALTER TABLE `layoutbranch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `layoutfriendlyurl`
--

DROP TABLE IF EXISTS `layoutfriendlyurl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `layoutfriendlyurl` (
  `uuid_` varchar(75) DEFAULT NULL,
  `layoutFriendlyURLId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `plid` bigint(20) DEFAULT NULL,
  `privateLayout` tinyint(4) DEFAULT NULL,
  `friendlyURL` varchar(255) DEFAULT NULL,
  `languageId` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`layoutFriendlyURLId`),
  UNIQUE KEY `IX_A6FC2B28` (`groupId`,`privateLayout`,`friendlyURL`,`languageId`),
  UNIQUE KEY `IX_C5762E72` (`plid`,`languageId`),
  UNIQUE KEY `IX_326525D6` (`uuid_`,`groupId`),
  KEY `IX_EAB317C8` (`companyId`),
  KEY `IX_742EF04A` (`groupId`),
  KEY `IX_CA713461` (`groupId`,`privateLayout`,`friendlyURL`),
  KEY `IX_83AE56AB` (`plid`),
  KEY `IX_59051329` (`plid`,`friendlyURL`),
  KEY `IX_9F80D54` (`uuid_`),
  KEY `IX_F4321A54` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layoutfriendlyurl`
--

LOCK TABLES `layoutfriendlyurl` WRITE;
/*!40000 ALTER TABLE `layoutfriendlyurl` DISABLE KEYS */;
INSERT INTO `layoutfriendlyurl` VALUES ('c4c63332-ebbf-48b3-954e-15cbbfb03ef1',20176,20172,20154,20158,'','2016-06-30 20:51:58','2016-06-30 20:51:58',20175,1,'/manage','en_US'),('1729503f-b7f5-413f-a666-4c91d249d2ee',20185,20181,20154,20158,'','2016-06-30 20:52:00','2016-06-30 20:52:00',20184,0,'/home','en_US'),('46ba6b86-6b11-4478-9a97-66ff8f5f2f09',20321,20317,20154,20158,'','2016-06-30 20:52:07','2016-06-30 20:52:07',20320,1,'/layout','zh_CN'),('b5dc37bd-2633-46c0-87a9-63d0c6ab76cd',20333,20329,20154,20158,'','2016-06-30 20:52:09','2016-06-30 20:52:09',20332,1,'/layout','zh_CN'),('16a0b4ee-6ca8-4453-be13-bb4e657bb1f9',20343,20339,20154,20158,'','2016-06-30 20:52:11','2016-06-30 20:52:11',20342,1,'/layout','zh_CN'),('1dca09bc-f10f-4773-ba42-2ac0eb78a5c6',20362,20350,20154,20158,'','2016-06-30 20:52:14','2016-06-30 20:52:14',20361,1,'/home','zh_CN'),('8c67c63b-119c-4b9b-b667-c285ec8c7c9a',20370,20350,20154,20158,'','2016-06-30 20:52:16','2016-06-30 20:52:16',20369,1,'/wiki','zh_CN'),('bd87b935-2d3c-4212-a090-5219a3f6711a',20388,20376,20154,20158,'','2016-06-30 20:52:17','2016-06-30 20:52:17',20387,1,'/home','zh_CN'),('3a8f3a83-dca4-4ad2-bfb8-6e6af3a124a1',20397,20376,20154,20158,'','2016-06-30 20:52:19','2016-06-30 20:52:19',20396,1,'/documents','zh_CN'),('10654ba4-2c5e-454b-b859-e6f9bf90a994',20405,20376,20154,20158,'','2016-06-30 20:52:21','2016-06-30 20:52:21',20404,1,'/news','zh_CN'),('6856c5eb-6b1a-4ab1-b02f-72ed4cc042a4',20517,20201,20154,20198,'Test Test','2016-06-30 20:53:46','2016-06-30 20:53:46',20516,1,'/home','zh_CN'),('04d527bb-e232-4e0b-83cd-6e89509a049a',20523,20201,20154,20198,'Test Test','2016-06-30 20:53:47','2016-06-30 20:53:47',20522,0,'/home','zh_CN'),('e5123d55-eda5-4f32-8144-665e35886480',20616,20608,20154,20198,'Test Test','2016-07-01 09:14:33','2016-07-01 09:14:33',20615,0,'/-','zh_CN'),('61dc5e50-f9b0-40fd-85b3-2ed2daa05496',20622,20608,20154,20198,'Test Test','2016-07-01 09:15:08','2016-07-01 09:15:08',20621,1,'/-','zh_CN'),('eab04931-9416-4594-86a2-8566731f7ba2',20628,20608,20154,20198,'Test Test','2016-07-01 09:15:26','2016-07-01 09:15:26',20627,1,'/-1','zh_CN'),('6aa0a381-35a3-4d22-b3d1-fd96436875ba',20634,20608,20154,20198,'Test Test','2016-07-01 09:15:50','2016-07-01 09:15:50',20633,1,'/-2','zh_CN'),('3b5a9829-1f88-45fe-9678-d011d2eda992',20640,20608,20154,20198,'Test Test','2016-07-01 09:16:13','2016-07-01 09:16:13',20639,1,'/-3','zh_CN'),('8973b43f-7943-4242-b623-a701d3b8e9cb',20646,20608,20154,20198,'Test Test','2016-07-01 09:17:03','2016-07-01 09:17:03',20645,1,'/-4','zh_CN'),('daf1025b-3733-41ec-83be-0de9a92b86ad',20652,20608,20154,20198,'Test Test','2016-07-01 09:17:14','2016-07-01 09:17:14',20651,1,'/-5','zh_CN'),('4a60490c-2406-4a9f-9233-53fd57beb94f',20658,20608,20154,20198,'Test Test','2016-07-01 09:17:40','2016-07-01 09:17:40',20657,1,'/-6','zh_CN'),('b10f0827-1b35-4d72-9f94-6b6357b60c44',20664,20608,20154,20198,'Test Test','2016-07-01 09:17:59','2016-07-01 09:17:59',20663,1,'/-7','zh_CN'),('ae0c9b4a-b3dd-4868-b703-15e988239690',20670,20608,20154,20198,'Test Test','2016-07-01 09:18:17','2016-07-01 09:18:17',20669,1,'/-8','zh_CN'),('503e3356-72dd-4f16-a7b4-a7093defb177',20676,20608,20154,20198,'Test Test','2016-07-01 09:18:33','2016-07-01 09:18:33',20675,1,'/-9','zh_CN'),('611d5c3d-25d5-4017-a6c8-6dbc68a6b33a',20682,20608,20154,20198,'Test Test','2016-07-01 09:18:54','2016-07-01 09:18:54',20681,1,'/-10','zh_CN'),('1a95646c-86b4-4ae6-9fb9-c9e36ea4b70e',20688,20608,20154,20198,'Test Test','2016-07-01 09:19:10','2016-07-01 09:19:10',20687,1,'/-11','zh_CN'),('6982e395-81f2-42c8-991f-1acef1fc40af',20694,20608,20154,20198,'Test Test','2016-07-01 09:19:27','2016-07-01 09:19:27',20693,1,'/-12','zh_CN'),('3b807799-08fd-4bc9-b903-9084e1b22d77',20700,20608,20154,20198,'Test Test','2016-07-01 09:19:41','2016-07-01 09:19:41',20699,1,'/-13','zh_CN'),('fc3ba5bf-d8ef-4ee2-a49a-97aaebf7e437',20714,20608,20154,20198,'Test Test','2016-07-01 09:28:45','2016-07-01 09:28:45',20713,1,'/-14','zh_CN'),('ac106e47-8661-4a16-87be-2ba6e45be2d8',20720,20608,20154,20198,'Test Test','2016-07-01 09:28:57','2016-07-01 09:28:57',20719,1,'/-15','zh_CN'),('d059685f-d0d1-4202-8c2b-e9bf156c2ca0',20726,20608,20154,20198,'Test Test','2016-07-01 09:29:21','2016-07-01 09:29:21',20725,1,'/-16','zh_CN'),('c9a2e9ed-c386-4bfc-98e2-02a90a375937',20740,20735,20154,20198,'Test Test','2016-07-01 09:32:54','2016-07-01 09:32:54',20739,0,'/-','zh_CN'),('bd7148e8-ff29-4777-8deb-c13892458f66',20746,20735,20154,20198,'Test Test','2016-07-01 09:33:22','2016-07-01 09:33:22',20745,1,'/-','zh_CN'),('bda3adc2-7dbe-48e1-9be5-9b8bb7cf1396',20752,20735,20154,20198,'Test Test','2016-07-01 09:33:35','2016-07-01 09:33:35',20751,1,'/-1','zh_CN'),('6f5012e5-a73e-4861-a815-2f1de6bd79f2',20758,20735,20154,20198,'Test Test','2016-07-01 09:33:49','2016-07-01 09:33:49',20757,1,'/-2','zh_CN'),('633f2211-6645-4e5f-96d1-c415aa4765ce',20764,20735,20154,20198,'Test Test','2016-07-01 09:34:00','2016-07-01 09:34:00',20763,1,'/-3','zh_CN'),('3e04d4e5-a637-4c82-a9e0-bbc883ffa594',20770,20735,20154,20198,'Test Test','2016-07-01 09:34:08','2016-07-01 09:34:08',20769,1,'/-4','zh_CN'),('3b1aae48-9a91-4674-9cab-964a8c4949a0',20776,20735,20154,20198,'Test Test','2016-07-01 09:34:33','2016-07-01 09:34:33',20775,0,'/-1','zh_CN'),('7e9fd811-c0c2-4172-8736-0bdb8c48d389',20784,20731,20154,20198,'Test Test','2016-07-01 09:35:16','2016-07-01 09:35:16',20783,1,'/-','zh_CN'),('f476c95b-5462-4855-bcd3-55614a67d9e9',20790,20731,20154,20198,'Test Test','2016-07-01 09:35:28','2016-07-01 09:35:28',20789,1,'/-1','zh_CN'),('0c516aa1-a701-46f4-b4f2-659baf439103',20796,20731,20154,20198,'Test Test','2016-07-01 09:36:01','2016-07-01 09:36:01',20795,1,'/-2','zh_CN'),('dafd1c5e-3022-4e11-b635-c1c8dcdba344',20802,20731,20154,20198,'Test Test','2016-07-01 09:36:13','2016-07-01 09:36:13',20801,1,'/-3','zh_CN'),('82b89f0f-20f9-430f-95a0-b02eb1bf600c',20808,20731,20154,20198,'Test Test','2016-07-01 09:36:26','2016-07-01 09:36:26',20807,1,'/-4','zh_CN'),('c0dcf019-6efe-49c7-934c-798bd8ce2f25',20814,20731,20154,20198,'Test Test','2016-07-01 09:36:39','2016-07-01 09:36:39',20813,1,'/-5','zh_CN'),('aebd6aab-2572-4459-ac12-8fecc4dfdda2',20822,20731,20154,20198,'Test Test','2016-07-01 09:42:09','2016-07-01 09:42:09',20821,0,'/-','zh_CN'),('8a459f38-3650-4a49-afad-b60ce332192b',21139,20731,20154,20198,'Test Test','2016-07-05 20:00:48','2016-07-05 20:00:48',21138,1,'/-6','zh_CN'),('72de2e08-b823-423d-a80d-3b513d290e3f',21145,20731,20154,20198,'Test Test','2016-07-05 20:01:12','2016-07-05 20:01:12',21144,1,'/-7','zh_CN'),('b9cfaa9d-64c8-493a-a859-52f7692ed15d',21151,20731,20154,20198,'Test Test','2016-07-05 20:01:28','2016-07-05 20:01:28',21150,1,'/-8','zh_CN'),('50cabcc3-f0de-47e7-9c4d-a8fe1e1149e7',21157,20731,20154,20198,'Test Test','2016-07-05 20:02:32','2016-07-05 20:02:32',21156,1,'/-9','zh_CN'),('bcfbb9b4-e251-433a-be64-ec5fe4fbf9cc',21169,20941,20154,20939,'杨志杰','2016-07-05 20:32:14','2016-07-05 20:32:14',21168,1,'/home','zh_CN'),('d87650d5-d446-47ad-8af9-0bcce8835aa8',21175,20941,20154,20939,'杨志杰','2016-07-05 20:32:15','2016-07-05 20:32:15',21174,0,'/home','zh_CN');
/*!40000 ALTER TABLE `layoutfriendlyurl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `layoutprototype`
--

DROP TABLE IF EXISTS `layoutprototype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `layoutprototype` (
  `uuid_` varchar(75) DEFAULT NULL,
  `layoutPrototypeId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `name` longtext,
  `description` longtext,
  `settings_` longtext,
  `active_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`layoutPrototypeId`),
  KEY `IX_30616AAA` (`companyId`),
  KEY `IX_557A639F` (`companyId`,`active_`),
  KEY `IX_CEF72136` (`uuid_`),
  KEY `IX_63ED2532` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layoutprototype`
--

LOCK TABLES `layoutprototype` WRITE;
/*!40000 ALTER TABLE `layoutprototype` DISABLE KEYS */;
INSERT INTO `layoutprototype` VALUES ('978d7618-1072-4bd5-9147-c988d9be6a01',20316,20154,20158,'','2016-06-30 20:52:06','2016-06-30 20:52:06','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Blog</Name></root>','Create, edit, and view blogs from this page. Explore topics using tags, and connect with other members that blog.','',1),('4faa7951-427c-4597-aee5-6a895437f432',20328,20154,20158,'','2016-06-30 20:52:09','2016-06-30 20:52:09','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Content Display Page</Name></root>','Create, edit, and explore web content with this page. Search available content, explore related content with tags, and browse content categories.','',1),('6134537e-f350-48d5-9a61-11b7f507b8cb',20338,20154,20158,'','2016-06-30 20:52:11','2016-06-30 20:52:11','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Wiki</Name></root>','Collaborate with members through the wiki on this page. Discover related content through tags, and navigate quickly and easily with categories.','',1);
/*!40000 ALTER TABLE `layoutprototype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `layoutrevision`
--

DROP TABLE IF EXISTS `layoutrevision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `layoutrevision` (
  `layoutRevisionId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `layoutSetBranchId` bigint(20) DEFAULT NULL,
  `layoutBranchId` bigint(20) DEFAULT NULL,
  `parentLayoutRevisionId` bigint(20) DEFAULT NULL,
  `head` tinyint(4) DEFAULT NULL,
  `major` tinyint(4) DEFAULT NULL,
  `plid` bigint(20) DEFAULT NULL,
  `privateLayout` tinyint(4) DEFAULT NULL,
  `name` longtext,
  `title` longtext,
  `description` longtext,
  `keywords` longtext,
  `robots` longtext,
  `typeSettings` longtext,
  `iconImage` tinyint(4) DEFAULT NULL,
  `iconImageId` bigint(20) DEFAULT NULL,
  `themeId` varchar(75) DEFAULT NULL,
  `colorSchemeId` varchar(75) DEFAULT NULL,
  `wapThemeId` varchar(75) DEFAULT NULL,
  `wapColorSchemeId` varchar(75) DEFAULT NULL,
  `css` longtext,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`layoutRevisionId`),
  KEY `IX_43E8286A` (`head`,`plid`),
  KEY `IX_314B621A` (`layoutSetBranchId`),
  KEY `IX_A9AC086E` (`layoutSetBranchId`,`head`),
  KEY `IX_E10AC39` (`layoutSetBranchId`,`head`,`plid`),
  KEY `IX_13984800` (`layoutSetBranchId`,`layoutBranchId`,`plid`),
  KEY `IX_4A84AF43` (`layoutSetBranchId`,`parentLayoutRevisionId`,`plid`),
  KEY `IX_B7B914E5` (`layoutSetBranchId`,`plid`),
  KEY `IX_70DA9ECB` (`layoutSetBranchId`,`plid`,`status`),
  KEY `IX_7FFAE700` (`layoutSetBranchId`,`status`),
  KEY `IX_9329C9D6` (`plid`),
  KEY `IX_8EC3D2BC` (`plid`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layoutrevision`
--

LOCK TABLES `layoutrevision` WRITE;
/*!40000 ALTER TABLE `layoutrevision` DISABLE KEYS */;
/*!40000 ALTER TABLE `layoutrevision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `layoutset`
--

DROP TABLE IF EXISTS `layoutset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `layoutset` (
  `layoutSetId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `privateLayout` tinyint(4) DEFAULT NULL,
  `logo` tinyint(4) DEFAULT NULL,
  `logoId` bigint(20) DEFAULT NULL,
  `themeId` varchar(75) DEFAULT NULL,
  `colorSchemeId` varchar(75) DEFAULT NULL,
  `wapThemeId` varchar(75) DEFAULT NULL,
  `wapColorSchemeId` varchar(75) DEFAULT NULL,
  `css` longtext,
  `pageCount` int(11) DEFAULT NULL,
  `settings_` longtext,
  `layoutSetPrototypeUuid` varchar(75) DEFAULT NULL,
  `layoutSetPrototypeLinkEnabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`layoutSetId`),
  UNIQUE KEY `IX_48550691` (`groupId`,`privateLayout`),
  KEY `IX_A40B8BEC` (`groupId`),
  KEY `IX_72BBA8B7` (`layoutSetPrototypeUuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layoutset`
--

LOCK TABLES `layoutset` WRITE;
/*!40000 ALTER TABLE `layoutset` DISABLE KEYS */;
INSERT INTO `layoutset` VALUES (20173,20172,20154,'2016-06-30 20:51:58','2016-06-30 20:51:58',1,0,0,'classic','01','mobile','01','',1,'','',0),(20174,20172,20154,'2016-06-30 20:51:58','2016-06-30 20:51:58',0,0,0,'classic','01','mobile','01','',0,'','',0),(20182,20181,20154,'2016-06-30 20:51:59','2016-06-30 20:51:59',1,0,0,'classic','01','mobile','01','',0,'','',0),(20183,20181,20154,'2016-06-30 20:51:59','2016-06-30 20:52:00',0,0,0,'classic','01','mobile','01','',1,'','',0),(20192,20191,20154,'2016-06-30 20:52:00','2016-06-30 20:52:00',1,0,0,'classic','01','mobile','01','',0,'','',0),(20193,20191,20154,'2016-06-30 20:52:00','2016-06-30 20:52:00',0,0,0,'classic','01','mobile','01','',0,'','',0),(20195,20194,20154,'2016-06-30 20:52:00','2016-06-30 20:52:00',1,0,0,'classic','01','mobile','01','',0,'','',0),(20196,20194,20154,'2016-06-30 20:52:00','2016-06-30 20:52:00',0,0,0,'classic','01','mobile','01','',0,'','',0),(20202,20201,20154,'2016-06-30 20:52:01','2016-06-30 20:53:46',1,0,0,'classic','01','mobile','01','',1,'','',0),(20203,20201,20154,'2016-06-30 20:52:01','2016-06-30 20:53:47',0,0,0,'classic','01','mobile','01','',1,'','',0),(20318,20317,20154,'2016-06-30 20:52:06','2016-06-30 20:52:07',1,0,0,'classic','01','mobile','01','',1,'','',0),(20319,20317,20154,'2016-06-30 20:52:06','2016-06-30 20:52:06',0,0,0,'classic','01','mobile','01','',0,'','',0),(20330,20329,20154,'2016-06-30 20:52:09','2016-06-30 20:52:09',1,0,0,'classic','01','mobile','01','',1,'','',0),(20331,20329,20154,'2016-06-30 20:52:09','2016-06-30 20:52:09',0,0,0,'classic','01','mobile','01','',0,'','',0),(20340,20339,20154,'2016-06-30 20:52:11','2016-06-30 20:52:11',1,0,0,'classic','01','mobile','01','',1,'','',0),(20341,20339,20154,'2016-06-30 20:52:11','2016-06-30 20:52:11',0,0,0,'classic','01','mobile','01','',0,'','',0),(20351,20350,20154,'2016-06-30 20:52:12','2016-06-30 20:52:16',1,0,0,'classic','01','mobile','01','',2,'','',0),(20352,20350,20154,'2016-06-30 20:52:12','2016-06-30 20:52:12',0,0,0,'classic','01','mobile','01','',0,'','',0),(20377,20376,20154,'2016-06-30 20:52:16','2016-06-30 20:52:21',1,0,0,'classic','01','mobile','01','',3,'','',0),(20378,20376,20154,'2016-06-30 20:52:16','2016-06-30 20:52:16',0,0,0,'classic','01','mobile','01','',0,'','',0),(20609,20608,20154,'2016-07-01 09:13:14','2016-07-01 09:29:21',1,0,0,'classic','01','mobile','01','',17,'','',0),(20610,20608,20154,'2016-07-01 09:13:14','2016-07-01 09:14:33',0,0,0,'classic','01','mobile','01','',1,'','',0),(20732,20731,20154,'2016-07-01 09:30:12','2016-07-05 20:02:32',1,0,0,'classic','01','mobile','01','',10,'','',0),(20733,20731,20154,'2016-07-01 09:30:12','2016-07-01 09:42:09',0,0,0,'classic','01','mobile','01','',1,'','',0),(20736,20735,20154,'2016-07-01 09:31:13','2016-07-01 09:34:08',1,0,0,'classic','01','mobile','01','',5,'','',0),(20737,20735,20154,'2016-07-01 09:31:13','2016-07-01 09:34:33',0,0,0,'classic','01','mobile','01','',2,'','',0),(20857,20856,20154,'2016-07-01 10:10:00','2016-07-01 10:10:00',1,0,0,'classic','01','mobile','01','',0,'','',0),(20858,20856,20154,'2016-07-01 10:10:00','2016-07-01 10:10:00',0,0,0,'classic','01','mobile','01','',0,'','',0),(20863,20862,20154,'2016-07-01 10:12:59','2016-07-01 10:12:59',1,0,0,'classic','01','mobile','01','',0,'','',0),(20864,20862,20154,'2016-07-01 10:12:59','2016-07-01 10:12:59',0,0,0,'classic','01','mobile','01','',0,'','',0),(20869,20868,20154,'2016-07-01 10:13:35','2016-07-01 10:13:35',1,0,0,'classic','01','mobile','01','',0,'','',0),(20870,20868,20154,'2016-07-01 10:13:35','2016-07-01 10:13:35',0,0,0,'classic','01','mobile','01','',0,'','',0),(20875,20874,20154,'2016-07-01 10:13:56','2016-07-01 10:13:56',1,0,0,'classic','01','mobile','01','',0,'','',0),(20876,20874,20154,'2016-07-01 10:13:56','2016-07-01 10:13:56',0,0,0,'classic','01','mobile','01','',0,'','',0),(20883,20882,20154,'2016-07-01 10:14:52','2016-07-01 10:14:52',1,0,0,'classic','01','mobile','01','',0,'','',0),(20884,20882,20154,'2016-07-01 10:14:52','2016-07-01 10:14:52',0,0,0,'classic','01','mobile','01','',0,'','',0),(20889,20888,20154,'2016-07-01 10:15:08','2016-07-01 10:15:08',1,0,0,'classic','01','mobile','01','',0,'','',0),(20890,20888,20154,'2016-07-01 10:15:08','2016-07-01 10:15:08',0,0,0,'classic','01','mobile','01','',0,'','',0),(20895,20894,20154,'2016-07-01 10:15:35','2016-07-01 10:15:35',1,0,0,'classic','01','mobile','01','',0,'','',0),(20896,20894,20154,'2016-07-01 10:15:35','2016-07-01 10:15:35',0,0,0,'classic','01','mobile','01','',0,'','',0),(20901,20900,20154,'2016-07-01 10:16:07','2016-07-01 10:16:07',1,0,0,'classic','01','mobile','01','',0,'','',0),(20902,20900,20154,'2016-07-01 10:16:07','2016-07-01 10:16:07',0,0,0,'classic','01','mobile','01','',0,'','',0),(20907,20906,20154,'2016-07-01 10:16:31','2016-07-01 10:16:31',1,0,0,'classic','01','mobile','01','',0,'','',0),(20908,20906,20154,'2016-07-01 10:16:31','2016-07-01 10:16:31',0,0,0,'classic','01','mobile','01','',0,'','',0),(20913,20912,20154,'2016-07-01 10:16:48','2016-07-01 10:16:48',1,0,0,'classic','01','mobile','01','',0,'','',0),(20914,20912,20154,'2016-07-01 10:16:48','2016-07-01 10:16:48',0,0,0,'classic','01','mobile','01','',0,'','',0),(20942,20941,20154,'2016-07-01 14:50:31','2016-07-05 20:32:14',1,0,0,'classic','01','mobile','01','',1,'','',0),(20943,20941,20154,'2016-07-01 14:50:31','2016-07-05 20:32:15',0,0,0,'classic','01','mobile','01','',1,'','',0);
/*!40000 ALTER TABLE `layoutset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `layoutsetbranch`
--

DROP TABLE IF EXISTS `layoutsetbranch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `layoutsetbranch` (
  `layoutSetBranchId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `privateLayout` tinyint(4) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `description` longtext,
  `master` tinyint(4) DEFAULT NULL,
  `logo` tinyint(4) DEFAULT NULL,
  `logoId` bigint(20) DEFAULT NULL,
  `themeId` varchar(75) DEFAULT NULL,
  `colorSchemeId` varchar(75) DEFAULT NULL,
  `wapThemeId` varchar(75) DEFAULT NULL,
  `wapColorSchemeId` varchar(75) DEFAULT NULL,
  `css` longtext,
  `settings_` longtext,
  `layoutSetPrototypeUuid` varchar(75) DEFAULT NULL,
  `layoutSetPrototypeLinkEnabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`layoutSetBranchId`),
  UNIQUE KEY `IX_5FF18552` (`groupId`,`privateLayout`,`name`),
  KEY `IX_8FF5D6EA` (`groupId`),
  KEY `IX_C4079FD3` (`groupId`,`privateLayout`),
  KEY `IX_CCF0DA29` (`groupId`,`privateLayout`,`master`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layoutsetbranch`
--

LOCK TABLES `layoutsetbranch` WRITE;
/*!40000 ALTER TABLE `layoutsetbranch` DISABLE KEYS */;
/*!40000 ALTER TABLE `layoutsetbranch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `layoutsetprototype`
--

DROP TABLE IF EXISTS `layoutsetprototype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `layoutsetprototype` (
  `uuid_` varchar(75) DEFAULT NULL,
  `layoutSetPrototypeId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `name` longtext,
  `description` longtext,
  `settings_` longtext,
  `active_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`layoutSetPrototypeId`),
  KEY `IX_55F63D98` (`companyId`),
  KEY `IX_9178FC71` (`companyId`,`active_`),
  KEY `IX_C5D69B24` (`uuid_`),
  KEY `IX_D9FFCA84` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layoutsetprototype`
--

LOCK TABLES `layoutsetprototype` WRITE;
/*!40000 ALTER TABLE `layoutsetprototype` DISABLE KEYS */;
INSERT INTO `layoutsetprototype` VALUES ('aabff18d-a1cc-430b-9ad4-69630bf6aff1',20349,20154,20158,'','2016-06-30 20:52:12','2016-07-05 15:51:46','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Community Site</Name></root>','Site with Forums and Wiki','layoutsUpdateable=true\n',1),('67d28c48-21e2-47e7-b50b-0fc99bb7608a',20375,20154,20158,'','2016-06-30 20:52:16','2016-07-05 15:51:46','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Name language-id=\"zh_CN\">Intranet Site</Name></root>','Site with Documents and News','layoutsUpdateable=true\n',1);
/*!40000 ALTER TABLE `layoutsetprototype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listtype`
--

DROP TABLE IF EXISTS `listtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listtype` (
  `listTypeId` int(11) NOT NULL,
  `name` varchar(75) DEFAULT NULL,
  `type_` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`listTypeId`),
  KEY `IX_2932DD37` (`type_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listtype`
--

LOCK TABLES `listtype` WRITE;
/*!40000 ALTER TABLE `listtype` DISABLE KEYS */;
INSERT INTO `listtype` VALUES (10000,'billing','com.liferay.portal.model.Account.address'),(10001,'other','com.liferay.portal.model.Account.address'),(10002,'p-o-box','com.liferay.portal.model.Account.address'),(10003,'shipping','com.liferay.portal.model.Account.address'),(10004,'email-address','com.liferay.portal.model.Account.emailAddress'),(10005,'email-address-2','com.liferay.portal.model.Account.emailAddress'),(10006,'email-address-3','com.liferay.portal.model.Account.emailAddress'),(10007,'fax','com.liferay.portal.model.Account.phone'),(10008,'local','com.liferay.portal.model.Account.phone'),(10009,'other','com.liferay.portal.model.Account.phone'),(10010,'toll-free','com.liferay.portal.model.Account.phone'),(10011,'tty','com.liferay.portal.model.Account.phone'),(10012,'intranet','com.liferay.portal.model.Account.website'),(10013,'public','com.liferay.portal.model.Account.website'),(11000,'business','com.liferay.portal.model.Contact.address'),(11001,'other','com.liferay.portal.model.Contact.address'),(11002,'personal','com.liferay.portal.model.Contact.address'),(11003,'email-address','com.liferay.portal.model.Contact.emailAddress'),(11004,'email-address-2','com.liferay.portal.model.Contact.emailAddress'),(11005,'email-address-3','com.liferay.portal.model.Contact.emailAddress'),(11006,'business','com.liferay.portal.model.Contact.phone'),(11007,'business-fax','com.liferay.portal.model.Contact.phone'),(11008,'mobile-phone','com.liferay.portal.model.Contact.phone'),(11009,'other','com.liferay.portal.model.Contact.phone'),(11010,'pager','com.liferay.portal.model.Contact.phone'),(11011,'personal','com.liferay.portal.model.Contact.phone'),(11012,'personal-fax','com.liferay.portal.model.Contact.phone'),(11013,'tty','com.liferay.portal.model.Contact.phone'),(11014,'dr','com.liferay.portal.model.Contact.prefix'),(11015,'mr','com.liferay.portal.model.Contact.prefix'),(11016,'mrs','com.liferay.portal.model.Contact.prefix'),(11017,'ms','com.liferay.portal.model.Contact.prefix'),(11020,'ii','com.liferay.portal.model.Contact.suffix'),(11021,'iii','com.liferay.portal.model.Contact.suffix'),(11022,'iv','com.liferay.portal.model.Contact.suffix'),(11023,'jr','com.liferay.portal.model.Contact.suffix'),(11024,'phd','com.liferay.portal.model.Contact.suffix'),(11025,'sr','com.liferay.portal.model.Contact.suffix'),(11026,'blog','com.liferay.portal.model.Contact.website'),(11027,'business','com.liferay.portal.model.Contact.website'),(11028,'other','com.liferay.portal.model.Contact.website'),(11029,'personal','com.liferay.portal.model.Contact.website'),(12000,'billing','com.liferay.portal.model.Organization.address'),(12001,'other','com.liferay.portal.model.Organization.address'),(12002,'p-o-box','com.liferay.portal.model.Organization.address'),(12003,'shipping','com.liferay.portal.model.Organization.address'),(12004,'email-address','com.liferay.portal.model.Organization.emailAddress'),(12005,'email-address-2','com.liferay.portal.model.Organization.emailAddress'),(12006,'email-address-3','com.liferay.portal.model.Organization.emailAddress'),(12007,'fax','com.liferay.portal.model.Organization.phone'),(12008,'local','com.liferay.portal.model.Organization.phone'),(12009,'other','com.liferay.portal.model.Organization.phone'),(12010,'toll-free','com.liferay.portal.model.Organization.phone'),(12011,'tty','com.liferay.portal.model.Organization.phone'),(12012,'administrative','com.liferay.portal.model.Organization.service'),(12013,'contracts','com.liferay.portal.model.Organization.service'),(12014,'donation','com.liferay.portal.model.Organization.service'),(12015,'retail','com.liferay.portal.model.Organization.service'),(12016,'training','com.liferay.portal.model.Organization.service'),(12017,'full-member','com.liferay.portal.model.Organization.status'),(12018,'provisional-member','com.liferay.portal.model.Organization.status'),(12019,'intranet','com.liferay.portal.model.Organization.website'),(12020,'public','com.liferay.portal.model.Organization.website');
/*!40000 ALTER TABLE `listtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lock_`
--

DROP TABLE IF EXISTS `lock_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lock_` (
  `uuid_` varchar(75) DEFAULT NULL,
  `lockId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `className` varchar(75) DEFAULT NULL,
  `key_` varchar(200) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `inheritable` tinyint(4) DEFAULT NULL,
  `expirationDate` datetime DEFAULT NULL,
  PRIMARY KEY (`lockId`),
  UNIQUE KEY `IX_228562AD` (`className`,`key_`),
  KEY `IX_E3F1286B` (`expirationDate`),
  KEY `IX_13C5CD3A` (`uuid_`),
  KEY `IX_2C418EAE` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lock_`
--

LOCK TABLES `lock_` WRITE;
/*!40000 ALTER TABLE `lock_` DISABLE KEYS */;
/*!40000 ALTER TABLE `lock_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marketplace_app`
--

DROP TABLE IF EXISTS `marketplace_app`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marketplace_app` (
  `uuid_` varchar(75) DEFAULT NULL,
  `appId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `remoteAppId` bigint(20) DEFAULT NULL,
  `title` varchar(75) DEFAULT NULL,
  `description` longtext,
  `category` varchar(75) DEFAULT NULL,
  `iconURL` longtext,
  `version` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`appId`),
  KEY `IX_94A7EF25` (`category`),
  KEY `IX_865B7BD5` (`companyId`),
  KEY `IX_20F14D93` (`remoteAppId`),
  KEY `IX_3E667FE1` (`uuid_`),
  KEY `IX_A7807DA7` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marketplace_app`
--

LOCK TABLES `marketplace_app` WRITE;
/*!40000 ALTER TABLE `marketplace_app` DISABLE KEYS */;
/*!40000 ALTER TABLE `marketplace_app` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marketplace_module`
--

DROP TABLE IF EXISTS `marketplace_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marketplace_module` (
  `uuid_` varchar(75) DEFAULT NULL,
  `moduleId` bigint(20) NOT NULL,
  `appId` bigint(20) DEFAULT NULL,
  `bundleSymbolicName` varchar(500) DEFAULT NULL,
  `bundleVersion` varchar(75) DEFAULT NULL,
  `contextName` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`moduleId`),
  KEY `IX_7DC16D26` (`appId`),
  KEY `IX_5848F52D` (`appId`,`bundleSymbolicName`,`bundleVersion`),
  KEY `IX_C6938724` (`appId`,`contextName`),
  KEY `IX_DD03D499` (`bundleSymbolicName`),
  KEY `IX_F2F1E964` (`contextName`),
  KEY `IX_A7EFD80E` (`uuid_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marketplace_module`
--

LOCK TABLES `marketplace_module` WRITE;
/*!40000 ALTER TABLE `marketplace_module` DISABLE KEYS */;
/*!40000 ALTER TABLE `marketplace_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mbban`
--

DROP TABLE IF EXISTS `mbban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mbban` (
  `uuid_` varchar(75) DEFAULT NULL,
  `banId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `banUserId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`banId`),
  UNIQUE KEY `IX_8ABC4E3B` (`groupId`,`banUserId`),
  UNIQUE KEY `IX_2A3B68F6` (`uuid_`,`groupId`),
  KEY `IX_69951A25` (`banUserId`),
  KEY `IX_5C3FF12A` (`groupId`),
  KEY `IX_48814BBA` (`userId`),
  KEY `IX_8A13C634` (`uuid_`),
  KEY `IX_4F841574` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mbban`
--

LOCK TABLES `mbban` WRITE;
/*!40000 ALTER TABLE `mbban` DISABLE KEYS */;
/*!40000 ALTER TABLE `mbban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mbcategory`
--

DROP TABLE IF EXISTS `mbcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mbcategory` (
  `uuid_` varchar(75) DEFAULT NULL,
  `categoryId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `parentCategoryId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `description` longtext,
  `displayStyle` varchar(75) DEFAULT NULL,
  `threadCount` int(11) DEFAULT NULL,
  `messageCount` int(11) DEFAULT NULL,
  `lastPostDate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`categoryId`),
  UNIQUE KEY `IX_F7D28C2F` (`uuid_`,`groupId`),
  KEY `IX_BC735DCF` (`companyId`),
  KEY `IX_E15A5DB5` (`companyId`,`status`),
  KEY `IX_BB870C11` (`groupId`),
  KEY `IX_ED292508` (`groupId`,`parentCategoryId`),
  KEY `IX_C295DBEE` (`groupId`,`parentCategoryId`,`status`),
  KEY `IX_DA84A9F7` (`groupId`,`status`),
  KEY `IX_C2626EDB` (`uuid_`),
  KEY `IX_13DF4E6D` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mbcategory`
--

LOCK TABLES `mbcategory` WRITE;
/*!40000 ALTER TABLE `mbcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `mbcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mbdiscussion`
--

DROP TABLE IF EXISTS `mbdiscussion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mbdiscussion` (
  `uuid_` varchar(75) DEFAULT NULL,
  `discussionId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `threadId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`discussionId`),
  UNIQUE KEY `IX_33A4DE38` (`classNameId`,`classPK`),
  UNIQUE KEY `IX_B5CA2DC` (`threadId`),
  UNIQUE KEY `IX_F7AAC799` (`uuid_`,`groupId`),
  KEY `IX_79D0120B` (`classNameId`),
  KEY `IX_5477D431` (`uuid_`),
  KEY `IX_7E965757` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mbdiscussion`
--

LOCK TABLES `mbdiscussion` WRITE;
/*!40000 ALTER TABLE `mbdiscussion` DISABLE KEYS */;
INSERT INTO `mbdiscussion` VALUES ('4be0d192-254e-43f3-9004-a7e724bef27a',20180,0,0,20158,'','2016-06-30 20:51:59','2016-06-30 20:51:59',20002,20175,20178),('6ae59a53-cbe4-4f12-8eca-0414588d833c',20189,0,0,20158,'','2016-06-30 20:52:00','2016-06-30 20:52:00',20002,20184,20187),('3b7625fa-212f-45f1-863c-e56ccef208e2',20326,0,0,20158,'','2016-06-30 20:52:07','2016-06-30 20:52:07',20002,20320,20323),('223e5f59-0586-43c8-8390-2c6c622e4a78',20337,0,0,20158,'','2016-06-30 20:52:09','2016-06-30 20:52:09',20002,20332,20335),('b3a72580-6828-489c-beed-d4dad54aaf35',20347,0,0,20158,'','2016-06-30 20:52:11','2016-06-30 20:52:11',20002,20342,20345),('3d88eee4-4fe3-4fc7-8a0b-e010854ffb91',20366,0,0,20158,'','2016-06-30 20:52:14','2016-06-30 20:52:14',20002,20361,20364),('f7269f9c-9730-4891-aefc-6edbb10ecdae',20374,0,0,20158,'','2016-06-30 20:52:16','2016-06-30 20:52:16',20002,20369,20372),('964e3336-94a2-4cf2-badd-4294205ac334',20392,0,0,20158,'','2016-06-30 20:52:17','2016-06-30 20:52:17',20002,20387,20390),('7f2cf1d7-12d9-4b0f-9461-eee26875018c',20401,0,0,20158,'','2016-06-30 20:52:19','2016-06-30 20:52:19',20002,20396,20399),('dc51b4f5-5cff-4a8f-8509-9465cdddad6a',20409,0,0,20158,'','2016-06-30 20:52:21','2016-06-30 20:52:21',20002,20404,20407),('5e4b9c7d-cc48-44d8-bc81-4654deabc337',20521,0,0,20198,'Test Test','2016-06-30 20:53:46','2016-06-30 20:53:46',20002,20516,20519),('f937a2aa-c8cc-42a2-9000-bbbcf6541d31',20527,0,0,20198,'Test Test','2016-06-30 20:53:47','2016-06-30 20:53:47',20002,20522,20525),('687a45de-cf8a-408b-bee0-045cdacb62e3',20620,0,0,20198,'Test Test','2016-07-01 09:14:34','2016-07-01 09:14:34',20002,20615,20618),('000d9772-b72c-4b4a-bc87-77b35111e2b2',20626,0,0,20198,'Test Test','2016-07-01 09:15:08','2016-07-01 09:15:08',20002,20621,20624),('fbc1bf80-fddf-4245-87c4-8fda970bd259',20632,0,0,20198,'Test Test','2016-07-01 09:15:26','2016-07-01 09:15:26',20002,20627,20630),('960f2e5f-3f6d-4448-a444-493b6d192ea7',20638,0,0,20198,'Test Test','2016-07-01 09:15:50','2016-07-01 09:15:50',20002,20633,20636),('c50e98bb-7293-47c1-9970-88a232379bd7',20644,0,0,20198,'Test Test','2016-07-01 09:16:13','2016-07-01 09:16:13',20002,20639,20642),('dc91f95f-216d-4788-8583-9cb775545823',20650,0,0,20198,'Test Test','2016-07-01 09:17:03','2016-07-01 09:17:03',20002,20645,20648),('7987e02e-a328-4abc-a583-fe0b01fd0924',20656,0,0,20198,'Test Test','2016-07-01 09:17:15','2016-07-01 09:17:15',20002,20651,20654),('163b91a8-43d8-4d5a-825d-48e6a8404009',20662,0,0,20198,'Test Test','2016-07-01 09:17:40','2016-07-01 09:17:40',20002,20657,20660),('2955c1b6-f48d-4a94-b191-640d4ac351d6',20668,0,0,20198,'Test Test','2016-07-01 09:17:59','2016-07-01 09:17:59',20002,20663,20666),('3af3c921-6584-4b05-b1c1-56298994c74d',20674,0,0,20198,'Test Test','2016-07-01 09:18:17','2016-07-01 09:18:17',20002,20669,20672),('956977da-ec7a-42a1-ae6a-7919b2fbefc3',20680,0,0,20198,'Test Test','2016-07-01 09:18:33','2016-07-01 09:18:33',20002,20675,20678),('ae45a144-2fad-41ec-ab92-0fd86f1ce9a2',20686,0,0,20198,'Test Test','2016-07-01 09:18:54','2016-07-01 09:18:54',20002,20681,20684),('a27362c2-450e-440c-aef4-6fc7f6c1e64e',20692,0,0,20198,'Test Test','2016-07-01 09:19:11','2016-07-01 09:19:11',20002,20687,20690),('a40fee18-5008-4c9b-9726-65b5d77b983d',20698,0,0,20198,'Test Test','2016-07-01 09:19:28','2016-07-01 09:19:28',20002,20693,20696),('d358598f-6082-400b-a2f4-e7048213b4d4',20704,0,0,20198,'Test Test','2016-07-01 09:19:41','2016-07-01 09:19:41',20002,20699,20702),('007cc84b-94ac-43c5-b853-c59e6724d840',20718,0,0,20198,'Test Test','2016-07-01 09:28:45','2016-07-01 09:28:45',20002,20713,20716),('df2a3a1a-71fb-4478-bfee-3b31c47bdb32',20724,0,0,20198,'Test Test','2016-07-01 09:28:57','2016-07-01 09:28:57',20002,20719,20722),('6d86d5bd-f2e3-419b-98c6-6c6e0ee07619',20730,0,0,20198,'Test Test','2016-07-01 09:29:21','2016-07-01 09:29:21',20002,20725,20728),('94570cd4-ad9d-4a29-aa5b-30fc617c91c9',20744,0,0,20198,'Test Test','2016-07-01 09:32:54','2016-07-01 09:32:54',20002,20739,20742),('559c73a1-b23b-4d2d-ac19-420bfa955e08',20750,0,0,20198,'Test Test','2016-07-01 09:33:22','2016-07-01 09:33:22',20002,20745,20748),('eb1eee96-d44d-4336-af8c-3f56885178b6',20756,0,0,20198,'Test Test','2016-07-01 09:33:35','2016-07-01 09:33:35',20002,20751,20754),('4de0d890-f603-4a43-a2e7-6315c06cc683',20762,0,0,20198,'Test Test','2016-07-01 09:33:49','2016-07-01 09:33:49',20002,20757,20760),('c3dec992-2b5b-41a8-a5a0-81a2338d5663',20768,0,0,20198,'Test Test','2016-07-01 09:34:00','2016-07-01 09:34:00',20002,20763,20766),('9540ca80-3b2d-430a-a852-7549ac527e39',20774,0,0,20198,'Test Test','2016-07-01 09:34:08','2016-07-01 09:34:08',20002,20769,20772),('fc517881-c37f-4fef-880c-f16e35c2be29',20780,0,0,20198,'Test Test','2016-07-01 09:34:33','2016-07-01 09:34:33',20002,20775,20778),('b3332652-0710-40c6-a375-be20cb93190f',20788,0,0,20198,'Test Test','2016-07-01 09:35:17','2016-07-01 09:35:17',20002,20783,20786),('145cf366-0458-4906-8267-a502c5b09afc',20794,0,0,20198,'Test Test','2016-07-01 09:35:29','2016-07-01 09:35:29',20002,20789,20792),('6f711500-3e6b-4aaf-8cf0-91054013159c',20800,0,0,20198,'Test Test','2016-07-01 09:36:01','2016-07-01 09:36:01',20002,20795,20798),('0cf41d69-0505-411d-a23a-ac1f132358fd',20806,0,0,20198,'Test Test','2016-07-01 09:36:13','2016-07-01 09:36:13',20002,20801,20804),('141a7c28-1fea-450f-a1b3-6e4eecb7861f',20812,0,0,20198,'Test Test','2016-07-01 09:36:26','2016-07-01 09:36:26',20002,20807,20810),('10079424-93c0-4ca5-967f-1b5707c3b771',20818,0,0,20198,'Test Test','2016-07-01 09:36:39','2016-07-01 09:36:39',20002,20813,20816),('ac649ffe-9727-48f1-9776-6198eda1f14d',20826,0,0,20198,'Test Test','2016-07-01 09:42:09','2016-07-01 09:42:09',20002,20821,20824),('f70e9c1c-8fa5-4dbf-80b5-f3d8d925065b',21143,0,0,20198,'Test Test','2016-07-05 20:00:49','2016-07-05 20:00:49',20002,21138,21141),('2f0f4cb7-186c-43f0-80b0-5ae8155d639d',21149,0,0,20198,'Test Test','2016-07-05 20:01:12','2016-07-05 20:01:12',20002,21144,21147),('f6d54635-d16b-4a5c-9e71-297781113936',21155,0,0,20198,'Test Test','2016-07-05 20:01:28','2016-07-05 20:01:28',20002,21150,21153),('fec002cf-72b0-4997-a9f7-7e1863639bb3',21161,0,0,20198,'Test Test','2016-07-05 20:02:32','2016-07-05 20:02:32',20002,21156,21159),('b4abe9dd-577c-43e3-b974-80a51942ad44',21173,0,0,20939,'杨志杰','2016-07-05 20:32:14','2016-07-05 20:32:14',20002,21168,21171),('4983f89b-02a0-4a6c-aadf-b15bf2f59a54',21179,0,0,20939,'杨志杰','2016-07-05 20:32:15','2016-07-05 20:32:15',20002,21174,21177);
/*!40000 ALTER TABLE `mbdiscussion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mbmailinglist`
--

DROP TABLE IF EXISTS `mbmailinglist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mbmailinglist` (
  `uuid_` varchar(75) DEFAULT NULL,
  `mailingListId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `categoryId` bigint(20) DEFAULT NULL,
  `emailAddress` varchar(75) DEFAULT NULL,
  `inProtocol` varchar(75) DEFAULT NULL,
  `inServerName` varchar(75) DEFAULT NULL,
  `inServerPort` int(11) DEFAULT NULL,
  `inUseSSL` tinyint(4) DEFAULT NULL,
  `inUserName` varchar(75) DEFAULT NULL,
  `inPassword` varchar(75) DEFAULT NULL,
  `inReadInterval` int(11) DEFAULT NULL,
  `outEmailAddress` varchar(75) DEFAULT NULL,
  `outCustom` tinyint(4) DEFAULT NULL,
  `outServerName` varchar(75) DEFAULT NULL,
  `outServerPort` int(11) DEFAULT NULL,
  `outUseSSL` tinyint(4) DEFAULT NULL,
  `outUserName` varchar(75) DEFAULT NULL,
  `outPassword` varchar(75) DEFAULT NULL,
  `allowAnonymous` tinyint(4) DEFAULT NULL,
  `active_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`mailingListId`),
  UNIQUE KEY `IX_76CE9CDD` (`groupId`,`categoryId`),
  UNIQUE KEY `IX_E858F170` (`uuid_`,`groupId`),
  KEY `IX_BFEB984F` (`active_`),
  KEY `IX_4115EC7A` (`uuid_`),
  KEY `IX_FC61676E` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mbmailinglist`
--

LOCK TABLES `mbmailinglist` WRITE;
/*!40000 ALTER TABLE `mbmailinglist` DISABLE KEYS */;
/*!40000 ALTER TABLE `mbmailinglist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mbmessage`
--

DROP TABLE IF EXISTS `mbmessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mbmessage` (
  `uuid_` varchar(75) DEFAULT NULL,
  `messageId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `categoryId` bigint(20) DEFAULT NULL,
  `threadId` bigint(20) DEFAULT NULL,
  `rootMessageId` bigint(20) DEFAULT NULL,
  `parentMessageId` bigint(20) DEFAULT NULL,
  `subject` varchar(75) DEFAULT NULL,
  `body` longtext,
  `format` varchar(75) DEFAULT NULL,
  `anonymous` tinyint(4) DEFAULT NULL,
  `priority` double DEFAULT NULL,
  `allowPingbacks` tinyint(4) DEFAULT NULL,
  `answer` tinyint(4) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`messageId`),
  UNIQUE KEY `IX_8D12316E` (`uuid_`,`groupId`),
  KEY `IX_51A8D44D` (`classNameId`,`classPK`),
  KEY `IX_F6687633` (`classNameId`,`classPK`,`status`),
  KEY `IX_B1432D30` (`companyId`),
  KEY `IX_1AD93C16` (`companyId`,`status`),
  KEY `IX_5B153FB2` (`groupId`),
  KEY `IX_1073AB9F` (`groupId`,`categoryId`),
  KEY `IX_4257DB85` (`groupId`,`categoryId`,`status`),
  KEY `IX_B674AB58` (`groupId`,`categoryId`,`threadId`),
  KEY `IX_CBFDBF0A` (`groupId`,`categoryId`,`threadId`,`answer`),
  KEY `IX_385E123E` (`groupId`,`categoryId`,`threadId`,`status`),
  KEY `IX_ED39AC98` (`groupId`,`status`),
  KEY `IX_8EB8C5EC` (`groupId`,`userId`),
  KEY `IX_377858D2` (`groupId`,`userId`,`status`),
  KEY `IX_75B95071` (`threadId`),
  KEY `IX_9D7C3B23` (`threadId`,`answer`),
  KEY `IX_A7038CD7` (`threadId`,`parentMessageId`),
  KEY `IX_9DC8E57` (`threadId`,`status`),
  KEY `IX_7A040C32` (`userId`),
  KEY `IX_59F9CE5C` (`userId`,`classNameId`),
  KEY `IX_ABEB6D07` (`userId`,`classNameId`,`classPK`),
  KEY `IX_4A4BB4ED` (`userId`,`classNameId`,`classPK`,`status`),
  KEY `IX_3321F142` (`userId`,`classNameId`,`status`),
  KEY `IX_C57B16BC` (`uuid_`),
  KEY `IX_57CA9FEC` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mbmessage`
--

LOCK TABLES `mbmessage` WRITE;
/*!40000 ALTER TABLE `mbmessage` DISABLE KEYS */;
INSERT INTO `mbmessage` VALUES ('b0f75e85-9652-41b5-8b62-e2fcc53f5bdf',20177,20172,20154,20158,'','2016-06-30 20:51:58','2016-06-30 20:51:58',20002,20175,-1,20178,20177,0,'20175','20175','bbcode',1,0,0,0,0,20158,'','2016-06-30 20:51:59'),('089e724b-260e-4671-9bd5-210fae19bdc9',20186,20181,20154,20158,'','2016-06-30 20:52:00','2016-06-30 20:52:00',20002,20184,-1,20187,20186,0,'20184','20184','bbcode',1,0,0,0,0,20158,'','2016-06-30 20:52:00'),('3c70f0b4-bf26-46c7-83ff-f691d746faad',20322,20317,20154,20158,'','2016-06-30 20:52:07','2016-06-30 20:52:07',20002,20320,-1,20323,20322,0,'20320','20320','bbcode',1,0,0,0,0,20158,'','2016-06-30 20:52:07'),('28a22d2d-9a52-4768-b292-515d00c66ff7',20334,20329,20154,20158,'','2016-06-30 20:52:09','2016-06-30 20:52:09',20002,20332,-1,20335,20334,0,'20332','20332','bbcode',1,0,0,0,0,20158,'','2016-06-30 20:52:09'),('957677a7-8c11-4987-90b2-f42ad3fc323a',20344,20339,20154,20158,'','2016-06-30 20:52:11','2016-06-30 20:52:11',20002,20342,-1,20345,20344,0,'20342','20342','bbcode',1,0,0,0,0,20158,'','2016-06-30 20:52:11'),('22919673-c8e0-431b-a45a-4880846b975d',20363,20350,20154,20158,'','2016-06-30 20:52:14','2016-06-30 20:52:14',20002,20361,-1,20364,20363,0,'20361','20361','bbcode',1,0,0,0,0,20158,'','2016-06-30 20:52:14'),('3188693b-f110-4428-b546-20d1b8147ea7',20371,20350,20154,20158,'','2016-06-30 20:52:16','2016-06-30 20:52:16',20002,20369,-1,20372,20371,0,'20369','20369','bbcode',1,0,0,0,0,20158,'','2016-06-30 20:52:16'),('5024c7f1-756a-4bb5-84d1-40208be4bdce',20389,20376,20154,20158,'','2016-06-30 20:52:17','2016-06-30 20:52:17',20002,20387,-1,20390,20389,0,'20387','20387','bbcode',1,0,0,0,0,20158,'','2016-06-30 20:52:17'),('083451d7-46ca-43f8-bb20-4d4a26743265',20398,20376,20154,20158,'','2016-06-30 20:52:19','2016-06-30 20:52:19',20002,20396,-1,20399,20398,0,'20396','20396','bbcode',1,0,0,0,0,20158,'','2016-06-30 20:52:19'),('938bce00-c350-4c33-bf8f-cb441717daac',20406,20376,20154,20158,'','2016-06-30 20:52:21','2016-06-30 20:52:21',20002,20404,-1,20407,20406,0,'20404','20404','bbcode',1,0,0,0,0,20158,'','2016-06-30 20:52:21'),('48261069-2927-4b3b-81ed-78be2f305da3',20518,20201,20154,20198,'Test Test','2016-06-30 20:53:46','2016-06-30 20:53:46',20002,20516,-1,20519,20518,0,'20516','20516','bbcode',0,0,0,0,0,20198,'Test Test','2016-06-30 20:53:46'),('8b5fbac7-5d78-49dd-961f-36f9563e5abd',20524,20201,20154,20198,'Test Test','2016-06-30 20:53:47','2016-06-30 20:53:47',20002,20522,-1,20525,20524,0,'20522','20522','bbcode',0,0,0,0,0,20198,'Test Test','2016-06-30 20:53:47'),('b4f82a08-2d22-4a3f-8f8b-1436a5ad178e',20617,20608,20154,20198,'Test Test','2016-07-01 09:14:33','2016-07-01 09:14:33',20002,20615,-1,20618,20617,0,'20615','20615','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:14:33'),('facf1101-4988-4643-a400-1c1a32569f1f',20623,20608,20154,20198,'Test Test','2016-07-01 09:15:08','2016-07-01 09:15:08',20002,20621,-1,20624,20623,0,'20621','20621','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:15:08'),('a4e68502-1d58-4a54-820c-6dececc8d893',20629,20608,20154,20198,'Test Test','2016-07-01 09:15:26','2016-07-01 09:15:26',20002,20627,-1,20630,20629,0,'20627','20627','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:15:26'),('956e4a10-57d7-4ac7-95bf-e256562310ae',20635,20608,20154,20198,'Test Test','2016-07-01 09:15:50','2016-07-01 09:15:50',20002,20633,-1,20636,20635,0,'20633','20633','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:15:50'),('6c150942-5db5-4d6f-9250-89a10a90b92b',20641,20608,20154,20198,'Test Test','2016-07-01 09:16:13','2016-07-01 09:16:13',20002,20639,-1,20642,20641,0,'20639','20639','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:16:13'),('31c0b2f0-7c84-467c-87f7-2a2ef33b2738',20647,20608,20154,20198,'Test Test','2016-07-01 09:17:03','2016-07-01 09:17:03',20002,20645,-1,20648,20647,0,'20645','20645','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:17:03'),('d4b60fac-f720-4046-9c6c-fb1f3fe61dc0',20653,20608,20154,20198,'Test Test','2016-07-01 09:17:15','2016-07-01 09:17:15',20002,20651,-1,20654,20653,0,'20651','20651','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:17:15'),('8acebfec-0261-428c-88c5-cf743812b4e8',20659,20608,20154,20198,'Test Test','2016-07-01 09:17:40','2016-07-01 09:17:40',20002,20657,-1,20660,20659,0,'20657','20657','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:17:40'),('772103bf-59c7-4c76-8260-b58057c7e30c',20665,20608,20154,20198,'Test Test','2016-07-01 09:17:59','2016-07-01 09:17:59',20002,20663,-1,20666,20665,0,'20663','20663','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:17:59'),('b5523f30-bb9d-461e-a8b2-78c735412e04',20671,20608,20154,20198,'Test Test','2016-07-01 09:18:17','2016-07-01 09:18:17',20002,20669,-1,20672,20671,0,'20669','20669','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:18:17'),('69c9a80b-e930-434d-a41f-d547c19c65c2',20677,20608,20154,20198,'Test Test','2016-07-01 09:18:33','2016-07-01 09:18:33',20002,20675,-1,20678,20677,0,'20675','20675','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:18:33'),('d3023429-e3dc-4843-a974-fecfabb97491',20683,20608,20154,20198,'Test Test','2016-07-01 09:18:54','2016-07-01 09:18:54',20002,20681,-1,20684,20683,0,'20681','20681','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:18:54'),('c5366872-d488-4d67-83c4-d2063e0e572c',20689,20608,20154,20198,'Test Test','2016-07-01 09:19:10','2016-07-01 09:19:10',20002,20687,-1,20690,20689,0,'20687','20687','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:19:11'),('798631e9-c4b0-4813-9ed3-e19ff34de68e',20695,20608,20154,20198,'Test Test','2016-07-01 09:19:27','2016-07-01 09:19:27',20002,20693,-1,20696,20695,0,'20693','20693','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:19:27'),('c3c1f1ce-7987-4093-8f9a-2fc3ed01c8ee',20701,20608,20154,20198,'Test Test','2016-07-01 09:19:41','2016-07-01 09:19:41',20002,20699,-1,20702,20701,0,'20699','20699','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:19:41'),('efa79655-a00c-444c-b46d-dc270d8eca2b',20715,20608,20154,20198,'Test Test','2016-07-01 09:28:45','2016-07-01 09:28:45',20002,20713,-1,20716,20715,0,'20713','20713','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:28:45'),('b58f3630-409b-4fb8-984b-9b24d662d269',20721,20608,20154,20198,'Test Test','2016-07-01 09:28:57','2016-07-01 09:28:57',20002,20719,-1,20722,20721,0,'20719','20719','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:28:57'),('eabff6d3-d8b7-4bfc-a7fe-44632710b808',20727,20608,20154,20198,'Test Test','2016-07-01 09:29:21','2016-07-01 09:29:21',20002,20725,-1,20728,20727,0,'20725','20725','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:29:21'),('1351c3df-57ea-4a3d-a3c3-6f931758de9c',20741,20735,20154,20198,'Test Test','2016-07-01 09:32:54','2016-07-01 09:32:54',20002,20739,-1,20742,20741,0,'20739','20739','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:32:54'),('342fd65e-02ca-4464-8568-2e2ee4e3acde',20747,20735,20154,20198,'Test Test','2016-07-01 09:33:22','2016-07-01 09:33:22',20002,20745,-1,20748,20747,0,'20745','20745','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:33:22'),('430c78a4-48fd-45e6-90d4-018acca3c74f',20753,20735,20154,20198,'Test Test','2016-07-01 09:33:35','2016-07-01 09:33:35',20002,20751,-1,20754,20753,0,'20751','20751','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:33:35'),('4985eb57-af43-441c-8cba-27ebb3de6b1c',20759,20735,20154,20198,'Test Test','2016-07-01 09:33:49','2016-07-01 09:33:49',20002,20757,-1,20760,20759,0,'20757','20757','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:33:49'),('39f8ac13-9653-4277-a82b-40d9d1d0a132',20765,20735,20154,20198,'Test Test','2016-07-01 09:34:00','2016-07-01 09:34:00',20002,20763,-1,20766,20765,0,'20763','20763','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:34:00'),('a6a79111-a05c-4d54-916a-e79dec90bc41',20771,20735,20154,20198,'Test Test','2016-07-01 09:34:08','2016-07-01 09:34:08',20002,20769,-1,20772,20771,0,'20769','20769','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:34:08'),('a119bf69-3a3c-43ea-bd9c-6befde4c47ba',20777,20735,20154,20198,'Test Test','2016-07-01 09:34:33','2016-07-01 09:34:33',20002,20775,-1,20778,20777,0,'20775','20775','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:34:33'),('80aaa4d9-6815-4e4a-8cea-5e5418abba1f',20785,20731,20154,20198,'Test Test','2016-07-01 09:35:16','2016-07-01 09:35:16',20002,20783,-1,20786,20785,0,'20783','20783','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:35:17'),('f6944be3-7797-4bd8-bc2b-c7f5c8e56f11',20791,20731,20154,20198,'Test Test','2016-07-01 09:35:29','2016-07-01 09:35:29',20002,20789,-1,20792,20791,0,'20789','20789','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:35:29'),('fb06cf4c-e30a-41f9-a2ad-2445ef5c11ef',20797,20731,20154,20198,'Test Test','2016-07-01 09:36:01','2016-07-01 09:36:01',20002,20795,-1,20798,20797,0,'20795','20795','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:36:01'),('4ff66e7f-9219-4a33-9ba8-d2e73842e861',20803,20731,20154,20198,'Test Test','2016-07-01 09:36:13','2016-07-01 09:36:13',20002,20801,-1,20804,20803,0,'20801','20801','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:36:13'),('ba6d965f-199e-4abb-b8a9-52dbc78a43af',20809,20731,20154,20198,'Test Test','2016-07-01 09:36:26','2016-07-01 09:36:26',20002,20807,-1,20810,20809,0,'20807','20807','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:36:26'),('97446fdc-b778-47f8-a48a-9d4b4a670119',20815,20731,20154,20198,'Test Test','2016-07-01 09:36:39','2016-07-01 09:36:39',20002,20813,-1,20816,20815,0,'20813','20813','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:36:39'),('3bd5c3e9-358c-4659-a846-6f2052fc07b5',20823,20731,20154,20198,'Test Test','2016-07-01 09:42:09','2016-07-01 09:42:09',20002,20821,-1,20824,20823,0,'20821','20821','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-01 09:42:09'),('6a6d9bdb-a404-4d9b-a59f-204e2c79426c',21140,20731,20154,20198,'Test Test','2016-07-05 20:00:49','2016-07-05 20:00:49',20002,21138,-1,21141,21140,0,'21138','21138','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-05 20:00:49'),('865aa995-b491-4f19-a6ed-73b0b1dc6e2b',21146,20731,20154,20198,'Test Test','2016-07-05 20:01:12','2016-07-05 20:01:12',20002,21144,-1,21147,21146,0,'21144','21144','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-05 20:01:12'),('4547e974-1044-4304-a082-d86af606a2f9',21152,20731,20154,20198,'Test Test','2016-07-05 20:01:28','2016-07-05 20:01:28',20002,21150,-1,21153,21152,0,'21150','21150','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-05 20:01:28'),('09762421-bf94-4e8d-a5d6-26a0b1efdcd3',21158,20731,20154,20198,'Test Test','2016-07-05 20:02:32','2016-07-05 20:02:32',20002,21156,-1,21159,21158,0,'21156','21156','bbcode',0,0,0,0,0,20198,'Test Test','2016-07-05 20:02:32'),('f00028c1-e2cc-4aca-bc6c-2130c1163292',21170,20941,20154,20939,'杨志杰','2016-07-05 20:32:14','2016-07-05 20:32:14',20002,21168,-1,21171,21170,0,'21168','21168','bbcode',0,0,0,0,0,20939,'杨志杰','2016-07-05 20:32:14'),('699be20b-6043-4bf1-82da-2f67f6e8173d',21176,20941,20154,20939,'杨志杰','2016-07-05 20:32:15','2016-07-05 20:32:15',20002,21174,-1,21177,21176,0,'21174','21174','bbcode',0,0,0,0,0,20939,'杨志杰','2016-07-05 20:32:15');
/*!40000 ALTER TABLE `mbmessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mbstatsuser`
--

DROP TABLE IF EXISTS `mbstatsuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mbstatsuser` (
  `statsUserId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `messageCount` int(11) DEFAULT NULL,
  `lastPostDate` datetime DEFAULT NULL,
  PRIMARY KEY (`statsUserId`),
  UNIQUE KEY `IX_9168E2C9` (`groupId`,`userId`),
  KEY `IX_A00A898F` (`groupId`),
  KEY `IX_D33A5445` (`groupId`,`userId`,`messageCount`),
  KEY `IX_847F92B5` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mbstatsuser`
--

LOCK TABLES `mbstatsuser` WRITE;
/*!40000 ALTER TABLE `mbstatsuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `mbstatsuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mbthread`
--

DROP TABLE IF EXISTS `mbthread`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mbthread` (
  `uuid_` varchar(75) DEFAULT NULL,
  `threadId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `categoryId` bigint(20) DEFAULT NULL,
  `rootMessageId` bigint(20) DEFAULT NULL,
  `rootMessageUserId` bigint(20) DEFAULT NULL,
  `messageCount` int(11) DEFAULT NULL,
  `viewCount` int(11) DEFAULT NULL,
  `lastPostByUserId` bigint(20) DEFAULT NULL,
  `lastPostDate` datetime DEFAULT NULL,
  `priority` double DEFAULT NULL,
  `question` tinyint(4) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`threadId`),
  UNIQUE KEY `IX_3A200B7B` (`uuid_`,`groupId`),
  KEY `IX_41F6DC8A` (`categoryId`,`priority`),
  KEY `IX_95C0EA45` (`groupId`),
  KEY `IX_9A2D11B2` (`groupId`,`categoryId`),
  KEY `IX_50F1904A` (`groupId`,`categoryId`,`lastPostDate`),
  KEY `IX_485F7E98` (`groupId`,`categoryId`,`status`),
  KEY `IX_E1E7142B` (`groupId`,`status`),
  KEY `IX_AEDD9CB5` (`lastPostDate`,`priority`),
  KEY `IX_CC993ECB` (`rootMessageId`),
  KEY `IX_7E264A0F` (`uuid_`),
  KEY `IX_F8CA2AB9` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mbthread`
--

LOCK TABLES `mbthread` WRITE;
/*!40000 ALTER TABLE `mbthread` DISABLE KEYS */;
INSERT INTO `mbthread` VALUES ('3b1797f6-5b3a-4bf2-9613-9cfdeefbf60f',20178,20172,20154,20158,'','2016-06-30 20:51:58','2016-06-30 20:51:59',-1,20177,20158,1,0,0,'2016-06-30 20:51:59',0,0,0,20158,'','2016-06-30 20:51:59'),('95194b39-8e8a-43cc-ad02-d2211a46f9f5',20187,20181,20154,20158,'','2016-06-30 20:52:00','2016-06-30 20:52:00',-1,20186,20158,1,0,0,'2016-06-30 20:52:00',0,0,0,20158,'','2016-06-30 20:52:00'),('211c409e-5834-4e48-b0e0-d373f5afb6c3',20323,20317,20154,20158,'','2016-06-30 20:52:07','2016-06-30 20:52:07',-1,20322,20158,1,0,0,'2016-06-30 20:52:07',0,0,0,20158,'','2016-06-30 20:52:07'),('e1dac14b-78e7-4bde-8466-551e3439db06',20335,20329,20154,20158,'','2016-06-30 20:52:09','2016-06-30 20:52:09',-1,20334,20158,1,0,0,'2016-06-30 20:52:09',0,0,0,20158,'','2016-06-30 20:52:09'),('42084bbd-e790-4451-a287-117bf5232ff0',20345,20339,20154,20158,'','2016-06-30 20:52:11','2016-06-30 20:52:11',-1,20344,20158,1,0,0,'2016-06-30 20:52:11',0,0,0,20158,'','2016-06-30 20:52:11'),('5ca5fc7d-f164-48f3-aefc-1373a69d4288',20364,20350,20154,20158,'','2016-06-30 20:52:14','2016-06-30 20:52:14',-1,20363,20158,1,0,0,'2016-06-30 20:52:14',0,0,0,20158,'','2016-06-30 20:52:14'),('437f90de-41fd-440d-ad98-0489fc569fc4',20372,20350,20154,20158,'','2016-06-30 20:52:16','2016-06-30 20:52:16',-1,20371,20158,1,0,0,'2016-06-30 20:52:16',0,0,0,20158,'','2016-06-30 20:52:16'),('1825bae7-b7a3-46fe-bd67-e7bc937e3bfb',20390,20376,20154,20158,'','2016-06-30 20:52:17','2016-06-30 20:52:17',-1,20389,20158,1,0,0,'2016-06-30 20:52:17',0,0,0,20158,'','2016-06-30 20:52:17'),('6c47ec06-45cb-43dc-a26c-316d80907697',20399,20376,20154,20158,'','2016-06-30 20:52:19','2016-06-30 20:52:19',-1,20398,20158,1,0,0,'2016-06-30 20:52:19',0,0,0,20158,'','2016-06-30 20:52:19'),('512a380a-7bd2-424b-b77e-2abb6a397bb9',20407,20376,20154,20158,'','2016-06-30 20:52:21','2016-06-30 20:52:21',-1,20406,20158,1,0,0,'2016-06-30 20:52:21',0,0,0,20158,'','2016-06-30 20:52:21'),('5158c3d2-4961-48dc-9943-46c1d59a1715',20519,20201,20154,20198,'Test Test','2016-06-30 20:53:46','2016-06-30 20:53:46',-1,20518,20198,1,0,20198,'2016-06-30 20:53:46',0,0,0,20198,'Test Test','2016-06-30 20:53:46'),('6a6e5c1f-69c5-42c3-926e-bc378b619ef7',20525,20201,20154,20198,'Test Test','2016-06-30 20:53:47','2016-06-30 20:53:47',-1,20524,20198,1,0,20198,'2016-06-30 20:53:47',0,0,0,20198,'Test Test','2016-06-30 20:53:47'),('4dcf1b3b-f07a-430d-911a-9ec483c97ff5',20618,20608,20154,20198,'Test Test','2016-07-01 09:14:33','2016-07-01 09:14:33',-1,20617,20198,1,0,20198,'2016-07-01 09:14:33',0,0,0,20198,'Test Test','2016-07-01 09:14:33'),('d29f3bab-f727-44a4-87fe-a87649b061eb',20624,20608,20154,20198,'Test Test','2016-07-01 09:15:08','2016-07-01 09:15:08',-1,20623,20198,1,0,20198,'2016-07-01 09:15:08',0,0,0,20198,'Test Test','2016-07-01 09:15:08'),('a15f8e92-9f4f-4d6c-9fcd-decead0a18fc',20630,20608,20154,20198,'Test Test','2016-07-01 09:15:26','2016-07-01 09:15:26',-1,20629,20198,1,0,20198,'2016-07-01 09:15:26',0,0,0,20198,'Test Test','2016-07-01 09:15:26'),('d9a89340-b6d9-41e6-b62f-6c6eb2be7e90',20636,20608,20154,20198,'Test Test','2016-07-01 09:15:50','2016-07-01 09:15:50',-1,20635,20198,1,0,20198,'2016-07-01 09:15:50',0,0,0,20198,'Test Test','2016-07-01 09:15:50'),('feb5d401-7de9-41b9-88fb-da69b41872c3',20642,20608,20154,20198,'Test Test','2016-07-01 09:16:13','2016-07-01 09:16:13',-1,20641,20198,1,0,20198,'2016-07-01 09:16:13',0,0,0,20198,'Test Test','2016-07-01 09:16:13'),('2fca9823-9738-42ad-a2c1-3a355dbd152a',20648,20608,20154,20198,'Test Test','2016-07-01 09:17:03','2016-07-01 09:17:03',-1,20647,20198,1,0,20198,'2016-07-01 09:17:03',0,0,0,20198,'Test Test','2016-07-01 09:17:03'),('6608759a-d875-4103-a644-4ac2a08572f2',20654,20608,20154,20198,'Test Test','2016-07-01 09:17:15','2016-07-01 09:17:15',-1,20653,20198,1,0,20198,'2016-07-01 09:17:15',0,0,0,20198,'Test Test','2016-07-01 09:17:15'),('898852cf-d281-4814-bde4-6f50b14c840b',20660,20608,20154,20198,'Test Test','2016-07-01 09:17:40','2016-07-01 09:17:40',-1,20659,20198,1,0,20198,'2016-07-01 09:17:40',0,0,0,20198,'Test Test','2016-07-01 09:17:40'),('248b924d-a347-4a6c-b81e-6f05a66fd722',20666,20608,20154,20198,'Test Test','2016-07-01 09:17:59','2016-07-01 09:17:59',-1,20665,20198,1,0,20198,'2016-07-01 09:17:59',0,0,0,20198,'Test Test','2016-07-01 09:17:59'),('c9d7d98d-dd3a-4ffd-8fc0-8d1c2c0a0a78',20672,20608,20154,20198,'Test Test','2016-07-01 09:18:17','2016-07-01 09:18:17',-1,20671,20198,1,0,20198,'2016-07-01 09:18:17',0,0,0,20198,'Test Test','2016-07-01 09:18:17'),('88c57974-a60c-4b96-b84a-4a12eada103b',20678,20608,20154,20198,'Test Test','2016-07-01 09:18:33','2016-07-01 09:18:33',-1,20677,20198,1,0,20198,'2016-07-01 09:18:33',0,0,0,20198,'Test Test','2016-07-01 09:18:33'),('7020000f-2c10-4f11-b6ee-8174d2bb6ce1',20684,20608,20154,20198,'Test Test','2016-07-01 09:18:54','2016-07-01 09:18:54',-1,20683,20198,1,0,20198,'2016-07-01 09:18:54',0,0,0,20198,'Test Test','2016-07-01 09:18:54'),('debc7ad9-78b1-42bf-8960-12efa17277c1',20690,20608,20154,20198,'Test Test','2016-07-01 09:19:10','2016-07-01 09:19:11',-1,20689,20198,1,0,20198,'2016-07-01 09:19:11',0,0,0,20198,'Test Test','2016-07-01 09:19:11'),('27b92dcf-2dff-46c3-a01a-9d44ccf253ae',20696,20608,20154,20198,'Test Test','2016-07-01 09:19:27','2016-07-01 09:19:27',-1,20695,20198,1,0,20198,'2016-07-01 09:19:27',0,0,0,20198,'Test Test','2016-07-01 09:19:27'),('afacf45e-b268-46e9-9a4a-bd3a522431ea',20702,20608,20154,20198,'Test Test','2016-07-01 09:19:41','2016-07-01 09:19:41',-1,20701,20198,1,0,20198,'2016-07-01 09:19:41',0,0,0,20198,'Test Test','2016-07-01 09:19:41'),('7dc674e7-5e4f-4144-a2c8-9236743ff2b7',20716,20608,20154,20198,'Test Test','2016-07-01 09:28:45','2016-07-01 09:28:45',-1,20715,20198,1,0,20198,'2016-07-01 09:28:45',0,0,0,20198,'Test Test','2016-07-01 09:28:45'),('c0bc75df-e6c7-4c1f-afb1-4eed6a439528',20722,20608,20154,20198,'Test Test','2016-07-01 09:28:57','2016-07-01 09:28:57',-1,20721,20198,1,0,20198,'2016-07-01 09:28:57',0,0,0,20198,'Test Test','2016-07-01 09:28:57'),('69ecc119-230d-4edf-af54-7591efdaf418',20728,20608,20154,20198,'Test Test','2016-07-01 09:29:21','2016-07-01 09:29:21',-1,20727,20198,1,0,20198,'2016-07-01 09:29:21',0,0,0,20198,'Test Test','2016-07-01 09:29:21'),('2bf2e424-b0e3-4d0f-99d4-68b0e2c0bd87',20742,20735,20154,20198,'Test Test','2016-07-01 09:32:54','2016-07-01 09:32:54',-1,20741,20198,1,0,20198,'2016-07-01 09:32:54',0,0,0,20198,'Test Test','2016-07-01 09:32:54'),('2859aede-f14b-44a0-84a4-5376af511c64',20748,20735,20154,20198,'Test Test','2016-07-01 09:33:22','2016-07-01 09:33:22',-1,20747,20198,1,0,20198,'2016-07-01 09:33:22',0,0,0,20198,'Test Test','2016-07-01 09:33:22'),('3f007f19-3a13-41fb-a1da-3a698e1126cb',20754,20735,20154,20198,'Test Test','2016-07-01 09:33:35','2016-07-01 09:33:35',-1,20753,20198,1,0,20198,'2016-07-01 09:33:35',0,0,0,20198,'Test Test','2016-07-01 09:33:35'),('a4464013-af1f-4261-9535-a86e6baba914',20760,20735,20154,20198,'Test Test','2016-07-01 09:33:49','2016-07-01 09:33:49',-1,20759,20198,1,0,20198,'2016-07-01 09:33:49',0,0,0,20198,'Test Test','2016-07-01 09:33:49'),('345e4850-ee19-42dc-a242-7b785791149f',20766,20735,20154,20198,'Test Test','2016-07-01 09:34:00','2016-07-01 09:34:00',-1,20765,20198,1,0,20198,'2016-07-01 09:34:00',0,0,0,20198,'Test Test','2016-07-01 09:34:00'),('0fc008b2-6986-4370-96a0-7c5987ac1bd9',20772,20735,20154,20198,'Test Test','2016-07-01 09:34:08','2016-07-01 09:34:08',-1,20771,20198,1,0,20198,'2016-07-01 09:34:08',0,0,0,20198,'Test Test','2016-07-01 09:34:08'),('3844d8e6-f1b9-4bbd-8eda-da0320179cf1',20778,20735,20154,20198,'Test Test','2016-07-01 09:34:33','2016-07-01 09:34:33',-1,20777,20198,1,0,20198,'2016-07-01 09:34:33',0,0,0,20198,'Test Test','2016-07-01 09:34:33'),('becc7cc2-f80b-4dd1-933a-8f75199f49b8',20786,20731,20154,20198,'Test Test','2016-07-01 09:35:16','2016-07-01 09:35:17',-1,20785,20198,1,0,20198,'2016-07-01 09:35:17',0,0,0,20198,'Test Test','2016-07-01 09:35:17'),('a2796d4a-1bfb-48c1-bcbc-4a95651abd2e',20792,20731,20154,20198,'Test Test','2016-07-01 09:35:29','2016-07-01 09:35:29',-1,20791,20198,1,0,20198,'2016-07-01 09:35:29',0,0,0,20198,'Test Test','2016-07-01 09:35:29'),('4ca3a91d-1104-4bad-a949-b5a54a640e8b',20798,20731,20154,20198,'Test Test','2016-07-01 09:36:01','2016-07-01 09:36:01',-1,20797,20198,1,0,20198,'2016-07-01 09:36:01',0,0,0,20198,'Test Test','2016-07-01 09:36:01'),('2ad0a938-69a9-400a-beb0-a3e81068a446',20804,20731,20154,20198,'Test Test','2016-07-01 09:36:13','2016-07-01 09:36:13',-1,20803,20198,1,0,20198,'2016-07-01 09:36:13',0,0,0,20198,'Test Test','2016-07-01 09:36:13'),('80054729-4818-4998-881a-3e2838750065',20810,20731,20154,20198,'Test Test','2016-07-01 09:36:26','2016-07-01 09:36:26',-1,20809,20198,1,0,20198,'2016-07-01 09:36:26',0,0,0,20198,'Test Test','2016-07-01 09:36:26'),('347513f0-74ac-4ce7-b044-64b10199a999',20816,20731,20154,20198,'Test Test','2016-07-01 09:36:39','2016-07-01 09:36:39',-1,20815,20198,1,0,20198,'2016-07-01 09:36:39',0,0,0,20198,'Test Test','2016-07-01 09:36:39'),('2c98b0de-9b44-4d88-9a4b-fe2c00f996ee',20824,20731,20154,20198,'Test Test','2016-07-01 09:42:09','2016-07-01 09:42:09',-1,20823,20198,1,0,20198,'2016-07-01 09:42:09',0,0,0,20198,'Test Test','2016-07-01 09:42:09'),('a5324fc3-2bbd-426b-b304-6df9a1d972de',21141,20731,20154,20198,'Test Test','2016-07-05 20:00:49','2016-07-05 20:00:49',-1,21140,20198,1,0,20198,'2016-07-05 20:00:49',0,0,0,20198,'Test Test','2016-07-05 20:00:49'),('94b68ae7-e3fc-4e76-8741-cb69697d0346',21147,20731,20154,20198,'Test Test','2016-07-05 20:01:12','2016-07-05 20:01:12',-1,21146,20198,1,0,20198,'2016-07-05 20:01:12',0,0,0,20198,'Test Test','2016-07-05 20:01:12'),('f71c63df-7b3b-429b-9b35-a1c6fff3d45e',21153,20731,20154,20198,'Test Test','2016-07-05 20:01:28','2016-07-05 20:01:28',-1,21152,20198,1,0,20198,'2016-07-05 20:01:28',0,0,0,20198,'Test Test','2016-07-05 20:01:28'),('c005bd3d-6751-4be2-9362-83825c745162',21159,20731,20154,20198,'Test Test','2016-07-05 20:02:32','2016-07-05 20:02:32',-1,21158,20198,1,0,20198,'2016-07-05 20:02:32',0,0,0,20198,'Test Test','2016-07-05 20:02:32'),('c06e15ae-192e-4eae-a0ef-122bd3f0286a',21171,20941,20154,20939,'杨志杰','2016-07-05 20:32:14','2016-07-05 20:32:14',-1,21170,20939,1,0,20939,'2016-07-05 20:32:14',0,0,0,20939,'杨志杰','2016-07-05 20:32:14'),('50fe11f8-9ca3-4744-a22f-7797ac3695fd',21177,20941,20154,20939,'杨志杰','2016-07-05 20:32:15','2016-07-05 20:32:15',-1,21176,20939,1,0,20939,'2016-07-05 20:32:15',0,0,0,20939,'杨志杰','2016-07-05 20:32:15');
/*!40000 ALTER TABLE `mbthread` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mbthreadflag`
--

DROP TABLE IF EXISTS `mbthreadflag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mbthreadflag` (
  `uuid_` varchar(75) DEFAULT NULL,
  `threadFlagId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `threadId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`threadFlagId`),
  UNIQUE KEY `IX_33781904` (`userId`,`threadId`),
  UNIQUE KEY `IX_FEB0FC87` (`uuid_`,`groupId`),
  KEY `IX_8CB0A24A` (`threadId`),
  KEY `IX_A28004B` (`userId`),
  KEY `IX_F36BBB83` (`uuid_`),
  KEY `IX_DCE308C5` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mbthreadflag`
--

LOCK TABLES `mbthreadflag` WRITE;
/*!40000 ALTER TABLE `mbthreadflag` DISABLE KEYS */;
/*!40000 ALTER TABLE `mbthreadflag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mdraction`
--

DROP TABLE IF EXISTS `mdraction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mdraction` (
  `uuid_` varchar(75) DEFAULT NULL,
  `actionId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `ruleGroupInstanceId` bigint(20) DEFAULT NULL,
  `name` longtext,
  `description` longtext,
  `type_` varchar(255) DEFAULT NULL,
  `typeSettings` longtext,
  PRIMARY KEY (`actionId`),
  UNIQUE KEY `IX_75BE36AD` (`uuid_`,`groupId`),
  KEY `IX_FD90786C` (`ruleGroupInstanceId`),
  KEY `IX_77BB5E9D` (`uuid_`),
  KEY `IX_C58A516B` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mdraction`
--

LOCK TABLES `mdraction` WRITE;
/*!40000 ALTER TABLE `mdraction` DISABLE KEYS */;
/*!40000 ALTER TABLE `mdraction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mdrrule`
--

DROP TABLE IF EXISTS `mdrrule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mdrrule` (
  `uuid_` varchar(75) DEFAULT NULL,
  `ruleId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `ruleGroupId` bigint(20) DEFAULT NULL,
  `name` longtext,
  `description` longtext,
  `type_` varchar(255) DEFAULT NULL,
  `typeSettings` longtext,
  PRIMARY KEY (`ruleId`),
  UNIQUE KEY `IX_F3EFDCB3` (`uuid_`,`groupId`),
  KEY `IX_4F4293F1` (`ruleGroupId`),
  KEY `IX_EA63B9D7` (`uuid_`),
  KEY `IX_7DEA8DF1` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mdrrule`
--

LOCK TABLES `mdrrule` WRITE;
/*!40000 ALTER TABLE `mdrrule` DISABLE KEYS */;
/*!40000 ALTER TABLE `mdrrule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mdrrulegroup`
--

DROP TABLE IF EXISTS `mdrrulegroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mdrrulegroup` (
  `uuid_` varchar(75) DEFAULT NULL,
  `ruleGroupId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `name` longtext,
  `description` longtext,
  PRIMARY KEY (`ruleGroupId`),
  UNIQUE KEY `IX_46665CC4` (`uuid_`,`groupId`),
  KEY `IX_5849891C` (`groupId`),
  KEY `IX_7F26B2A6` (`uuid_`),
  KEY `IX_CC14DC2` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mdrrulegroup`
--

LOCK TABLES `mdrrulegroup` WRITE;
/*!40000 ALTER TABLE `mdrrulegroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `mdrrulegroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mdrrulegroupinstance`
--

DROP TABLE IF EXISTS `mdrrulegroupinstance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mdrrulegroupinstance` (
  `uuid_` varchar(75) DEFAULT NULL,
  `ruleGroupInstanceId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `ruleGroupId` bigint(20) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`ruleGroupInstanceId`),
  UNIQUE KEY `IX_808A0036` (`classNameId`,`classPK`,`ruleGroupId`),
  UNIQUE KEY `IX_9CBC6A39` (`uuid_`,`groupId`),
  KEY `IX_C95A08D8` (`classNameId`,`classPK`),
  KEY `IX_AFF28547` (`groupId`),
  KEY `IX_22DAB85C` (`groupId`,`classNameId`,`classPK`),
  KEY `IX_BF3E642B` (`ruleGroupId`),
  KEY `IX_B6A6BD91` (`uuid_`),
  KEY `IX_25C9D1F7` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mdrrulegroupinstance`
--

LOCK TABLES `mdrrulegroupinstance` WRITE;
/*!40000 ALTER TABLE `mdrrulegroupinstance` DISABLE KEYS */;
/*!40000 ALTER TABLE `mdrrulegroupinstance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membershiprequest`
--

DROP TABLE IF EXISTS `membershiprequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membershiprequest` (
  `membershipRequestId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `comments` longtext,
  `replyComments` longtext,
  `replyDate` datetime DEFAULT NULL,
  `replierUserId` bigint(20) DEFAULT NULL,
  `statusId` int(11) DEFAULT NULL,
  PRIMARY KEY (`membershipRequestId`),
  KEY `IX_8A1CC4B` (`groupId`),
  KEY `IX_C28C72EC` (`groupId`,`statusId`),
  KEY `IX_35AA8FA6` (`groupId`,`userId`,`statusId`),
  KEY `IX_66D70879` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membershiprequest`
--

LOCK TABLES `membershiprequest` WRITE;
/*!40000 ALTER TABLE `membershiprequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `membershiprequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications_usernotificationevent`
--

DROP TABLE IF EXISTS `notifications_usernotificationevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notifications_usernotificationevent` (
  `notificationEventId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userNotificationEventId` bigint(20) DEFAULT NULL,
  `timestamp` bigint(20) DEFAULT NULL,
  `delivered` tinyint(4) DEFAULT NULL,
  `actionRequired` tinyint(4) DEFAULT NULL,
  `archived` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`notificationEventId`),
  UNIQUE KEY `IX_DC9FCEDC` (`userNotificationEventId`),
  KEY `IX_93C52776` (`userId`,`actionRequired`),
  KEY `IX_36E5AE4C` (`userId`,`actionRequired`,`archived`),
  KEY `IX_73C065F0` (`userId`,`delivered`,`actionRequired`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications_usernotificationevent`
--

LOCK TABLES `notifications_usernotificationevent` WRITE;
/*!40000 ALTER TABLE `notifications_usernotificationevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `notifications_usernotificationevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oa_deptwork`
--

DROP TABLE IF EXISTS `oa_deptwork`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oa_deptwork` (
  `deptWorkId` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  `deptId` bigint(20) DEFAULT NULL,
  `deptName` varchar(75) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `status` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`deptWorkId`),
  KEY `IX_8494C0D` (`deptName`),
  KEY `IX_7C6E7D13` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oa_deptwork`
--

LOCK TABLES `oa_deptwork` WRITE;
/*!40000 ALTER TABLE `oa_deptwork` DISABLE KEYS */;
/*!40000 ALTER TABLE `oa_deptwork` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oa_deptworkitem`
--

DROP TABLE IF EXISTS `oa_deptworkitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oa_deptworkitem` (
  `deptWorkItemId` bigint(20) NOT NULL,
  `deptWorkId` bigint(20) DEFAULT NULL,
  `sortNo` int(11) DEFAULT NULL,
  `dutyPerosn` varchar(75) DEFAULT NULL,
  `mainWork` tinyint(4) DEFAULT NULL,
  `schedule` varchar(75) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `agentPerson` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`deptWorkItemId`),
  KEY `IX_6C5391C1` (`deptWorkId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oa_deptworkitem`
--

LOCK TABLES `oa_deptworkitem` WRITE;
/*!40000 ALTER TABLE `oa_deptworkitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `oa_deptworkitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oa_dispatch`
--

DROP TABLE IF EXISTS `oa_dispatch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oa_dispatch` (
  `dispatchId` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  `rocordType` bigint(20) DEFAULT NULL,
  `securityLevel` bigint(20) DEFAULT NULL,
  `organaAbbreviation` bigint(20) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `serialNo` int(11) DEFAULT NULL,
  `title` varchar(75) DEFAULT NULL,
  `sendOrgan` varchar(75) DEFAULT NULL,
  `ccOrgan` varchar(75) DEFAULT NULL,
  `writtenOrgan` varchar(75) DEFAULT NULL,
  `writtenDate` datetime DEFAULT NULL,
  `urgencyDegree` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`dispatchId`),
  KEY `IX_93A71FFB` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oa_dispatch`
--

LOCK TABLES `oa_dispatch` WRITE;
/*!40000 ALTER TABLE `oa_dispatch` DISABLE KEYS */;
INSERT INTO `oa_dispatch` VALUES (21192,20198,'Test Test','2016-07-05 20:59:23','2016-07-05 20:59:23',21016,21023,21028,21011,0,'','','','','2016-07-05 20:59:23',21031);
/*!40000 ALTER TABLE `oa_dispatch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oa_leaderwork`
--

DROP TABLE IF EXISTS `oa_leaderwork`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oa_leaderwork` (
  `userId` bigint(20) NOT NULL,
  `workDate` datetime NOT NULL,
  `amOrPm` bigint(20) NOT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`userId`,`workDate`,`amOrPm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oa_leaderwork`
--

LOCK TABLES `oa_leaderwork` WRITE;
/*!40000 ALTER TABLE `oa_leaderwork` DISABLE KEYS */;
/*!40000 ALTER TABLE `oa_leaderwork` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oa_officesupply`
--

DROP TABLE IF EXISTS `oa_officesupply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oa_officesupply` (
  `officeSupplyId` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `model` varchar(75) DEFAULT NULL,
  `unit` varchar(75) DEFAULT NULL,
  `unitPrice` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`officeSupplyId`),
  KEY `IX_37CD3B3D` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oa_officesupply`
--

LOCK TABLES `oa_officesupply` WRITE;
/*!40000 ALTER TABLE `oa_officesupply` DISABLE KEYS */;
/*!40000 ALTER TABLE `oa_officesupply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oa_officesupplyapply`
--

DROP TABLE IF EXISTS `oa_officesupplyapply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oa_officesupplyapply` (
  `officeSupplyApplyId` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  `deptId` bigint(20) DEFAULT NULL,
  `deptName` varchar(75) DEFAULT NULL,
  `applicantId` bigint(20) DEFAULT NULL,
  `applicantName` varchar(75) DEFAULT NULL,
  `introductions` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`officeSupplyApplyId`),
  KEY `IX_C4DEFA41` (`applicantName`),
  KEY `IX_BB2AFEC0` (`deptName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oa_officesupplyapply`
--

LOCK TABLES `oa_officesupplyapply` WRITE;
/*!40000 ALTER TABLE `oa_officesupplyapply` DISABLE KEYS */;
/*!40000 ALTER TABLE `oa_officesupplyapply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oa_officesupplyapplyitem`
--

DROP TABLE IF EXISTS `oa_officesupplyapplyitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oa_officesupplyapplyitem` (
  `officeSupplyApplyItemId` bigint(20) NOT NULL,
  `name` varchar(75) DEFAULT NULL,
  `model` varchar(75) DEFAULT NULL,
  `unit` varchar(75) DEFAULT NULL,
  `unitPrice` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`officeSupplyApplyItemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oa_officesupplyapplyitem`
--

LOCK TABLES `oa_officesupplyapplyitem` WRITE;
/*!40000 ALTER TABLE `oa_officesupplyapplyitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `oa_officesupplyapplyitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oa_officesupplyrequisition`
--

DROP TABLE IF EXISTS `oa_officesupplyrequisition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oa_officesupplyrequisition` (
  `officeSupplyRequisitionId` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  `deptId` bigint(20) DEFAULT NULL,
  `deptName` varchar(75) DEFAULT NULL,
  `applicantId` bigint(20) DEFAULT NULL,
  `applicantName` varchar(75) DEFAULT NULL,
  `introductions` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`officeSupplyRequisitionId`),
  KEY `IX_75394CD3` (`applicantName`),
  KEY `IX_B47D8EE` (`deptName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oa_officesupplyrequisition`
--

LOCK TABLES `oa_officesupplyrequisition` WRITE;
/*!40000 ALTER TABLE `oa_officesupplyrequisition` DISABLE KEYS */;
/*!40000 ALTER TABLE `oa_officesupplyrequisition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oa_officesupplyrequisitionitem`
--

DROP TABLE IF EXISTS `oa_officesupplyrequisitionitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oa_officesupplyrequisitionitem` (
  `officeSupplyRequisitionItemId` bigint(20) NOT NULL,
  `name` varchar(75) DEFAULT NULL,
  `model` varchar(75) DEFAULT NULL,
  `unit` varchar(75) DEFAULT NULL,
  `unitPrice` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `officeSupplyRequisitionId` bigint(20) DEFAULT NULL,
  `officeSupplyId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`officeSupplyRequisitionItemId`),
  KEY `IX_D0E357DF` (`officeSupplyRequisitionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oa_officesupplyrequisitionitem`
--

LOCK TABLES `oa_officesupplyrequisitionitem` WRITE;
/*!40000 ALTER TABLE `oa_officesupplyrequisitionitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `oa_officesupplyrequisitionitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oa_vehiclerequisition`
--

DROP TABLE IF EXISTS `oa_vehiclerequisition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oa_vehiclerequisition` (
  `vehicleRequisitionId` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  `applicantDeptId` bigint(20) DEFAULT NULL,
  `applicantDeptName` varchar(75) DEFAULT NULL,
  `applicantId` bigint(20) DEFAULT NULL,
  `applicantName` varchar(75) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `passengerNum` int(11) DEFAULT NULL,
  `reason` varchar(1000) DEFAULT NULL,
  `destination` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`vehicleRequisitionId`),
  KEY `IX_F44F99BA` (`applicantName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oa_vehiclerequisition`
--

LOCK TABLES `oa_vehiclerequisition` WRITE;
/*!40000 ALTER TABLE `oa_vehiclerequisition` DISABLE KEYS */;
/*!40000 ALTER TABLE `oa_vehiclerequisition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opensocial_gadget`
--

DROP TABLE IF EXISTS `opensocial_gadget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opensocial_gadget` (
  `uuid_` varchar(75) DEFAULT NULL,
  `gadgetId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `url` longtext,
  `portletCategoryNames` longtext,
  PRIMARY KEY (`gadgetId`),
  KEY `IX_729869EE` (`companyId`),
  KEY `IX_E1F8627A` (`uuid_`),
  KEY `IX_3C79316E` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opensocial_gadget`
--

LOCK TABLES `opensocial_gadget` WRITE;
/*!40000 ALTER TABLE `opensocial_gadget` DISABLE KEYS */;
/*!40000 ALTER TABLE `opensocial_gadget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opensocial_oauthconsumer`
--

DROP TABLE IF EXISTS `opensocial_oauthconsumer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opensocial_oauthconsumer` (
  `oAuthConsumerId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `gadgetKey` varchar(75) DEFAULT NULL,
  `serviceName` varchar(75) DEFAULT NULL,
  `consumerKey` varchar(75) DEFAULT NULL,
  `consumerSecret` longtext,
  `keyType` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`oAuthConsumerId`),
  KEY `IX_47206618` (`gadgetKey`),
  KEY `IX_8E715BF8` (`gadgetKey`,`serviceName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opensocial_oauthconsumer`
--

LOCK TABLES `opensocial_oauthconsumer` WRITE;
/*!40000 ALTER TABLE `opensocial_oauthconsumer` DISABLE KEYS */;
/*!40000 ALTER TABLE `opensocial_oauthconsumer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opensocial_oauthtoken`
--

DROP TABLE IF EXISTS `opensocial_oauthtoken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opensocial_oauthtoken` (
  `oAuthTokenId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `gadgetKey` varchar(75) DEFAULT NULL,
  `serviceName` varchar(75) DEFAULT NULL,
  `moduleId` bigint(20) DEFAULT NULL,
  `accessToken` varchar(75) DEFAULT NULL,
  `tokenName` varchar(75) DEFAULT NULL,
  `tokenSecret` varchar(75) DEFAULT NULL,
  `sessionHandle` varchar(75) DEFAULT NULL,
  `expiration` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`oAuthTokenId`),
  KEY `IX_6C8CCC3D` (`gadgetKey`,`serviceName`),
  KEY `IX_CDD35402` (`userId`,`gadgetKey`,`serviceName`,`moduleId`,`tokenName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opensocial_oauthtoken`
--

LOCK TABLES `opensocial_oauthtoken` WRITE;
/*!40000 ALTER TABLE `opensocial_oauthtoken` DISABLE KEYS */;
/*!40000 ALTER TABLE `opensocial_oauthtoken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization_`
--

DROP TABLE IF EXISTS `organization_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organization_` (
  `uuid_` varchar(75) DEFAULT NULL,
  `organizationId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `parentOrganizationId` bigint(20) DEFAULT NULL,
  `treePath` longtext,
  `name` varchar(100) DEFAULT NULL,
  `type_` varchar(75) DEFAULT NULL,
  `recursable` tinyint(4) DEFAULT NULL,
  `regionId` bigint(20) DEFAULT NULL,
  `countryId` bigint(20) DEFAULT NULL,
  `statusId` int(11) DEFAULT NULL,
  `comments` longtext,
  PRIMARY KEY (`organizationId`),
  UNIQUE KEY `IX_E301BDF5` (`companyId`,`name`),
  KEY `IX_834BCEB6` (`companyId`),
  KEY `IX_418E4522` (`companyId`,`parentOrganizationId`),
  KEY `IX_396D6B42` (`uuid_`),
  KEY `IX_A9D85BA6` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization_`
--

LOCK TABLES `organization_` WRITE;
/*!40000 ALTER TABLE `organization_` DISABLE KEYS */;
INSERT INTO `organization_` VALUES ('48933aa6-117b-490d-8e7e-12eb11b6cf58',20855,20154,20198,'Test Test','2016-07-01 10:10:00','2016-07-01 10:10:00',0,'/20855/','上海市交通建设工程管理中心','regular-organization',1,0,0,12017,''),('c6885686-f7c6-425a-bcc6-4c975059f053',20861,20154,20198,'Test Test','2016-07-01 10:12:59','2016-07-01 10:12:59',20855,'/20855/20861/','中心领导','regular-organization',1,0,0,12017,''),('cb5da9d7-a70e-4645-aeca-ebc0793972ce',20867,20154,20198,'Test Test','2016-07-01 10:13:35','2016-07-01 10:13:35',20855,'/20855/20867/','办公室','regular-organization',1,0,0,12017,''),('3333b6d3-1ea4-4b01-8033-f1f6ac768ee0',20873,20154,20198,'Test Test','2016-07-01 10:13:56','2016-07-01 10:14:33',20855,'/20855/20873/','组织人事科（监察室）','regular-organization',1,0,0,12017,''),('a75e6221-1205-4c64-8a85-a84ac42b434a',20881,20154,20198,'Test Test','2016-07-01 10:14:52','2016-07-01 10:14:52',20855,'/20855/20881/','财务科','regular-organization',1,0,0,12017,''),('a612be48-cffd-4817-a893-8a7bc052cfa9',20887,20154,20198,'Test Test','2016-07-01 10:15:08','2016-07-01 10:15:08',20855,'/20855/20887/','市场监管科','regular-organization',1,0,0,12017,''),('2ed474e1-179e-4ecd-aa20-62c824dc2c3e',20893,20154,20198,'Test Test','2016-07-01 10:15:35','2016-07-01 10:15:35',20855,'/20855/20893/','科技信息科','regular-organization',1,0,0,12017,''),('888d1563-be04-4075-90fd-328c51ce3bd8',20899,20154,20198,'Test Test','2016-07-01 10:16:07','2016-07-01 10:16:07',20855,'/20855/20899/','综合管理科（执法监督科）','regular-organization',1,0,0,12017,''),('488e6c9b-ee55-4a57-b807-7aef669fe25d',20905,20154,20198,'Test Test','2016-07-01 10:16:31','2016-07-01 10:16:31',20855,'/20855/20905/','交通工程科','regular-organization',1,0,0,12017,''),('21c3440d-9b4e-4ef7-9d45-4fbab0a8a134',20911,20154,20198,'Test Test','2016-07-01 10:16:48','2016-07-01 10:16:48',20855,'/20855/20911/','市政工程科','regular-organization',1,0,0,12017,'');
/*!40000 ALTER TABLE `organization_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orggrouprole`
--

DROP TABLE IF EXISTS `orggrouprole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orggrouprole` (
  `organizationId` bigint(20) NOT NULL,
  `groupId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`organizationId`,`groupId`,`roleId`),
  KEY `IX_4A527DD3` (`groupId`),
  KEY `IX_AB044D1C` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orggrouprole`
--

LOCK TABLES `orggrouprole` WRITE;
/*!40000 ALTER TABLE `orggrouprole` DISABLE KEYS */;
/*!40000 ALTER TABLE `orggrouprole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orglabor`
--

DROP TABLE IF EXISTS `orglabor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orglabor` (
  `orgLaborId` bigint(20) NOT NULL,
  `organizationId` bigint(20) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `sunOpen` int(11) DEFAULT NULL,
  `sunClose` int(11) DEFAULT NULL,
  `monOpen` int(11) DEFAULT NULL,
  `monClose` int(11) DEFAULT NULL,
  `tueOpen` int(11) DEFAULT NULL,
  `tueClose` int(11) DEFAULT NULL,
  `wedOpen` int(11) DEFAULT NULL,
  `wedClose` int(11) DEFAULT NULL,
  `thuOpen` int(11) DEFAULT NULL,
  `thuClose` int(11) DEFAULT NULL,
  `friOpen` int(11) DEFAULT NULL,
  `friClose` int(11) DEFAULT NULL,
  `satOpen` int(11) DEFAULT NULL,
  `satClose` int(11) DEFAULT NULL,
  PRIMARY KEY (`orgLaborId`),
  KEY `IX_6AF0D434` (`organizationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orglabor`
--

LOCK TABLES `orglabor` WRITE;
/*!40000 ALTER TABLE `orglabor` DISABLE KEYS */;
INSERT INTO `orglabor` VALUES (20880,20873,12012,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1);
/*!40000 ALTER TABLE `orglabor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passwordpolicy`
--

DROP TABLE IF EXISTS `passwordpolicy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passwordpolicy` (
  `uuid_` varchar(75) DEFAULT NULL,
  `passwordPolicyId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `defaultPolicy` tinyint(4) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `description` longtext,
  `changeable` tinyint(4) DEFAULT NULL,
  `changeRequired` tinyint(4) DEFAULT NULL,
  `minAge` bigint(20) DEFAULT NULL,
  `checkSyntax` tinyint(4) DEFAULT NULL,
  `allowDictionaryWords` tinyint(4) DEFAULT NULL,
  `minAlphanumeric` int(11) DEFAULT NULL,
  `minLength` int(11) DEFAULT NULL,
  `minLowerCase` int(11) DEFAULT NULL,
  `minNumbers` int(11) DEFAULT NULL,
  `minSymbols` int(11) DEFAULT NULL,
  `minUpperCase` int(11) DEFAULT NULL,
  `regex` varchar(75) DEFAULT NULL,
  `history` tinyint(4) DEFAULT NULL,
  `historyCount` int(11) DEFAULT NULL,
  `expireable` tinyint(4) DEFAULT NULL,
  `maxAge` bigint(20) DEFAULT NULL,
  `warningTime` bigint(20) DEFAULT NULL,
  `graceLimit` int(11) DEFAULT NULL,
  `lockout` tinyint(4) DEFAULT NULL,
  `maxFailure` int(11) DEFAULT NULL,
  `lockoutDuration` bigint(20) DEFAULT NULL,
  `requireUnlock` tinyint(4) DEFAULT NULL,
  `resetFailureCount` bigint(20) DEFAULT NULL,
  `resetTicketMaxAge` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`passwordPolicyId`),
  UNIQUE KEY `IX_3FBFA9F4` (`companyId`,`name`),
  KEY `IX_8FEE65F5` (`companyId`),
  KEY `IX_2C1142E` (`companyId`,`defaultPolicy`),
  KEY `IX_51437A01` (`uuid_`),
  KEY `IX_E4D7EF87` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passwordpolicy`
--

LOCK TABLES `passwordpolicy` WRITE;
/*!40000 ALTER TABLE `passwordpolicy` DISABLE KEYS */;
INSERT INTO `passwordpolicy` VALUES ('d8dea20f-7888-4953-b95b-0083fd6fc388',20197,20154,20158,'','2016-06-30 20:52:00','2016-06-30 20:52:00',1,'Default Password Policy','Default Password Policy',1,1,0,0,1,0,6,0,1,0,1,'(?=.{4})(?:[a-zA-Z0-9]*)',0,6,0,8640000,86400,0,0,3,0,1,600,86400);
/*!40000 ALTER TABLE `passwordpolicy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passwordpolicyrel`
--

DROP TABLE IF EXISTS `passwordpolicyrel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passwordpolicyrel` (
  `passwordPolicyRelId` bigint(20) NOT NULL,
  `passwordPolicyId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`passwordPolicyRelId`),
  UNIQUE KEY `IX_C3A17327` (`classNameId`,`classPK`),
  KEY `IX_CD25266E` (`passwordPolicyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passwordpolicyrel`
--

LOCK TABLES `passwordpolicyrel` WRITE;
/*!40000 ALTER TABLE `passwordpolicyrel` DISABLE KEYS */;
/*!40000 ALTER TABLE `passwordpolicyrel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passwordtracker`
--

DROP TABLE IF EXISTS `passwordtracker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passwordtracker` (
  `passwordTrackerId` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `password_` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`passwordTrackerId`),
  KEY `IX_326F75BD` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passwordtracker`
--

LOCK TABLES `passwordtracker` WRITE;
/*!40000 ALTER TABLE `passwordtracker` DISABLE KEYS */;
/*!40000 ALTER TABLE `passwordtracker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `uuid_` varchar(75) DEFAULT NULL,
  `phoneId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `number_` varchar(75) DEFAULT NULL,
  `extension` varchar(75) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `primary_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`phoneId`),
  KEY `IX_9F704A14` (`companyId`),
  KEY `IX_A2E4AFBA` (`companyId`,`classNameId`),
  KEY `IX_9A53569` (`companyId`,`classNameId`,`classPK`),
  KEY `IX_812CE07A` (`companyId`,`classNameId`,`classPK`,`primary_`),
  KEY `IX_F202B9CE` (`userId`),
  KEY `IX_EA6245A0` (`uuid_`),
  KEY `IX_B271FA88` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pluginsetting`
--

DROP TABLE IF EXISTS `pluginsetting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pluginsetting` (
  `pluginSettingId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `pluginId` varchar(75) DEFAULT NULL,
  `pluginType` varchar(75) DEFAULT NULL,
  `roles` longtext,
  `active_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`pluginSettingId`),
  UNIQUE KEY `IX_7171B2E8` (`companyId`,`pluginId`,`pluginType`),
  KEY `IX_B9746445` (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pluginsetting`
--

LOCK TABLES `pluginsetting` WRITE;
/*!40000 ALTER TABLE `pluginsetting` DISABLE KEYS */;
/*!40000 ALTER TABLE `pluginsetting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pollschoice`
--

DROP TABLE IF EXISTS `pollschoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pollschoice` (
  `uuid_` varchar(75) DEFAULT NULL,
  `choiceId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `questionId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `description` longtext,
  PRIMARY KEY (`choiceId`),
  UNIQUE KEY `IX_D76DD2CF` (`questionId`,`name`),
  UNIQUE KEY `IX_C222BD31` (`uuid_`,`groupId`),
  KEY `IX_EC370F10` (`questionId`),
  KEY `IX_6660B399` (`uuid_`),
  KEY `IX_8AE746EF` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pollschoice`
--

LOCK TABLES `pollschoice` WRITE;
/*!40000 ALTER TABLE `pollschoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `pollschoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pollsquestion`
--

DROP TABLE IF EXISTS `pollsquestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pollsquestion` (
  `uuid_` varchar(75) DEFAULT NULL,
  `questionId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `title` longtext,
  `description` longtext,
  `expirationDate` datetime DEFAULT NULL,
  `lastVoteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`questionId`),
  UNIQUE KEY `IX_F3C9F36` (`uuid_`,`groupId`),
  KEY `IX_9FF342EA` (`groupId`),
  KEY `IX_51F087F4` (`uuid_`),
  KEY `IX_F910BBB4` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pollsquestion`
--

LOCK TABLES `pollsquestion` WRITE;
/*!40000 ALTER TABLE `pollsquestion` DISABLE KEYS */;
/*!40000 ALTER TABLE `pollsquestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pollsvote`
--

DROP TABLE IF EXISTS `pollsvote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pollsvote` (
  `uuid_` varchar(75) DEFAULT NULL,
  `voteId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `questionId` bigint(20) DEFAULT NULL,
  `choiceId` bigint(20) DEFAULT NULL,
  `voteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`voteId`),
  UNIQUE KEY `IX_1BBFD4D3` (`questionId`,`userId`),
  UNIQUE KEY `IX_A88C673A` (`uuid_`,`groupId`),
  KEY `IX_D5DF7B54` (`choiceId`),
  KEY `IX_12112599` (`questionId`),
  KEY `IX_FD32EB70` (`uuid_`),
  KEY `IX_7D8E92B8` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pollsvote`
--

LOCK TABLES `pollsvote` WRITE;
/*!40000 ALTER TABLE `pollsvote` DISABLE KEYS */;
/*!40000 ALTER TABLE `pollsvote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portalpreferences`
--

DROP TABLE IF EXISTS `portalpreferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `portalpreferences` (
  `portalPreferencesId` bigint(20) NOT NULL,
  `ownerId` bigint(20) DEFAULT NULL,
  `ownerType` int(11) DEFAULT NULL,
  `preferences` longtext,
  PRIMARY KEY (`portalPreferencesId`),
  KEY `IX_D1F795F1` (`ownerId`,`ownerType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portalpreferences`
--

LOCK TABLES `portalpreferences` WRITE;
/*!40000 ALTER TABLE `portalpreferences` DISABLE KEYS */;
INSERT INTO `portalpreferences` VALUES (20160,20154,1,'<portlet-preferences><preference><name>company.security.strangers.verify</name><value>false</value></preference><preference><name>locales</name><value>zh_CN</value></preference><preference><name>ldap.server.ids</name><value></value></preference><preference><name>admin.analytics.types</name><value>google[$NEW_LINE$]piwik</value></preference><preference><name>admin.email.password.reset.subject</name><value>[$PORTAL_URL$]: Reset Your Password</value></preference><preference><name>admin.email.user.added.subject</name><value>[$PORTAL_URL$]: Your New Account</value></preference><preference><name>admin.email.password.sent.body</name><value>Dear [$TO_NAME$],&lt;br /&gt;[$NEW_LINE$]&lt;br /&gt;[$NEW_LINE$]Your new password for [$PORTAL_URL$] is [$USER_PASSWORD$].&lt;br /&gt;[$NEW_LINE$]&lt;br /&gt;[$NEW_LINE$]The request for a new password was made from [$REMOTE_ADDRESS$] / [$REMOTE_HOST$].&lt;br /&gt;[$NEW_LINE$]&lt;br /&gt;[$NEW_LINE$]Sincerely,&lt;br /&gt;[$NEW_LINE$][$FROM_NAME$]&lt;br /&gt;[$NEW_LINE$][$FROM_ADDRESS$]&lt;br /&gt;[$NEW_LINE$][$PORTAL_URL$]</value></preference><preference><name>admin.email.verification.subject</name><value>[$PORTAL_URL$]: Email Address Verification</value></preference><preference><name>admin.default.role.names</name><value>Power User[$NEW_LINE$]User</value></preference><preference><name>company.security.strangers.with.mx</name><value>true</value></preference><preference><name>company.security.auto.login</name><value>true</value></preference><preference><name>company.security.site.logo</name><value>true</value></preference><preference><name>admin.email.password.sent.subject</name><value>[$PORTAL_URL$]: Your New Password</value></preference><preference><name>admin.email.password.reset.body</name><value>Dear [$TO_NAME$],&lt;br /&gt;[$NEW_LINE$]&lt;br /&gt;[$NEW_LINE$]You can reset your password for [$PORTAL_URL$] at [$PASSWORD_RESET_URL$].&lt;br /&gt;[$NEW_LINE$]&lt;br /&gt;[$NEW_LINE$]The request for a new password was made from [$REMOTE_ADDRESS$] / [$REMOTE_HOST$].&lt;br /&gt;[$NEW_LINE$]&lt;br /&gt;[$NEW_LINE$]Sincerely,&lt;br /&gt;[$NEW_LINE$][$FROM_NAME$]&lt;br /&gt;[$NEW_LINE$][$FROM_ADDRESS$]&lt;br /&gt;[$NEW_LINE$][$PORTAL_URL$]</value></preference><preference><name>company.security.send.password</name><value>true</value></preference><preference><name>admin.email.verification.body</name><value>Dear [$TO_NAME$],&lt;br /&gt;[$NEW_LINE$]&lt;br /&gt;[$NEW_LINE$]Please verify your email address for [$PORTAL_URL$] at [$EMAIL_VERIFICATION_URL$].&lt;br /&gt;[$NEW_LINE$]&lt;br /&gt;[$NEW_LINE$]Your verification code is [$EMAIL_VERIFICATION_CODE$] Sincerely,&lt;br /&gt;[$NEW_LINE$][$FROM_NAME$]&lt;br /&gt;[$NEW_LINE$][$FROM_ADDRESS$]&lt;br /&gt;[$NEW_LINE$][$PORTAL_URL$]</value></preference><preference><name>admin.email.user.added.no.password.body</name><value>Dear [$TO_NAME$],&lt;br /&gt;[$NEW_LINE$]&lt;br /&gt;[$NEW_LINE$]Welcome! You recently created an account at [$PORTAL_URL$].&lt;br /&gt;[$NEW_LINE$]&lt;br /&gt;[$NEW_LINE$]Sincerely,&lt;br /&gt;[$NEW_LINE$][$FROM_NAME$]&lt;br /&gt;[$NEW_LINE$][$FROM_ADDRESS$]&lt;br /&gt;[$NEW_LINE$][$PORTAL_URL$]</value></preference><preference><name>admin.email.user.added.body</name><value>Dear [$TO_NAME$],&lt;br /&gt;[$NEW_LINE$]&lt;br /&gt;[$NEW_LINE$]Welcome! You recently created an account at [$PORTAL_URL$]. Your password is [$USER_PASSWORD$]. Enjoy!&lt;br /&gt;[$NEW_LINE$]&lt;br /&gt;[$NEW_LINE$]Sincerely,&lt;br /&gt;[$NEW_LINE$][$FROM_NAME$]&lt;br /&gt;[$NEW_LINE$][$FROM_ADDRESS$]&lt;br /&gt;[$NEW_LINE$][$PORTAL_URL$]</value></preference><preference><name>company.security.strangers</name><value>true</value></preference><preference><name>company.security.auth.type</name><value>screenName</value></preference></portlet-preferences>'),(20199,0,1,'<portlet-preferences />'),(20436,20155,1,'<portlet-preferences />'),(20528,20198,4,'<portlet-preferences><preference><name>com.liferay.portal.util.SessionClicks#usersAdminOrganizationsPanel</name><value>closed</value></preference><preference><name>com.liferay.portal.util.SessionClicks#panel-manage-site_administration.pages</name><value>closed</value></preference><preference><name>125#users-order-by-col</name><value>name</value></preference><preference><name>com.liferay.portal.util.SessionTreeJSClicks#layoutsTree</name><value>8,5,14,</value></preference><preference><name>com.liferay.portal.util.SessionClicks#panel-manage-site_administration.configuration</name><value>open</value></preference><preference><name>com.liferay.portal.util.SessionClicks#_145_portletCategory4</name><value>closed</value></preference><preference><name>128#roles-order-by-col</name><value>title</value></preference><preference><name>com.liferay.portal.util.SessionClicks#_145_portletCategory12</name><value>open</value></preference><preference><name>125#organizations-order-by-col</name><value>name</value></preference><preference><name>128#roles-order-by-type</name><value>asc</value></preference><preference><name>com.liferay.portal.util.SessionClicks#_145_portletCategory2</name><value>closed</value></preference><preference><name>com.liferay.portal.util.SessionClicks#usersAdminUsersPanel</name><value>open</value></preference><preference><name>125#organizations-order-by-type</name><value>asc</value></preference><preference><name>com.liferay.portal.util.SessionClicks#_145_portletCategory11</name><value>closed</value></preference><preference><name>com.liferay.portal.util.SessionClicks#_145_portletCategory6</name><value>closed</value></preference><preference><name>com.liferay.portal.util.SessionClicks#_145_portletCategory3</name><value>closed</value></preference><preference><name>com.liferay.portal.util.SessionClicks#_145_portletCategory0</name><value>closed</value></preference><preference><name>com.liferay.portal.util.SessionClicks#liferay_addpanel_tab</name><value>applications</value></preference><preference><name>125#users-order-by-type</name><value>asc</value></preference><preference><name>com.liferay.portal.util.SessionClicks#p_auth</name><value>CdqPXxF3</value></preference><preference><name>com.liferay.portal.util.SessionClicks#_145_portletCategory5</name><value>closed</value></preference><preference><name>com.liferay.portal.util.SessionClicks#_145_portletCategory10</name><value>closed</value></preference></portlet-preferences>'),(20529,20158,4,'<portlet-preferences />'),(20860,20855,6,'<portlet-preferences><preference><name>reminderQueries_en_US</name><value></value></preference><preference><name>reminderQueries_ca_ES</name><value></value></preference><preference><name>reminderQueries_hu_HU</name><value></value></preference><preference><name>reminderQueries_fi_FI</name><value></value></preference><preference><name>reminderQueries_es_ES</name><value></value></preference><preference><name>reminderQueries_iw_IL</name><value></value></preference><preference><name>reminderQueries</name><value>NULL_VALUE</value></preference><preference><name>reminderQueries_pt_BR</name><value></value></preference><preference><name>reminderQueries_fr_FR</name><value></value></preference><preference><name>reminderQueries_ja_JP</name><value></value></preference><preference><name>reminderQueries_de_DE</name><value></value></preference></portlet-preferences>'),(20866,20861,6,'<portlet-preferences><preference><name>reminderQueries_en_US</name><value></value></preference><preference><name>reminderQueries_ca_ES</name><value></value></preference><preference><name>reminderQueries_hu_HU</name><value></value></preference><preference><name>reminderQueries_fi_FI</name><value></value></preference><preference><name>reminderQueries_es_ES</name><value></value></preference><preference><name>reminderQueries_iw_IL</name><value></value></preference><preference><name>reminderQueries</name><value>NULL_VALUE</value></preference><preference><name>reminderQueries_pt_BR</name><value></value></preference><preference><name>reminderQueries_fr_FR</name><value></value></preference><preference><name>reminderQueries_ja_JP</name><value></value></preference><preference><name>reminderQueries_de_DE</name><value></value></preference></portlet-preferences>'),(20872,20867,6,'<portlet-preferences><preference><name>reminderQueries_en_US</name><value></value></preference><preference><name>reminderQueries_ca_ES</name><value></value></preference><preference><name>reminderQueries_hu_HU</name><value></value></preference><preference><name>reminderQueries_fi_FI</name><value></value></preference><preference><name>reminderQueries_es_ES</name><value></value></preference><preference><name>reminderQueries_iw_IL</name><value></value></preference><preference><name>reminderQueries</name><value>NULL_VALUE</value></preference><preference><name>reminderQueries_pt_BR</name><value></value></preference><preference><name>reminderQueries_fr_FR</name><value></value></preference><preference><name>reminderQueries_ja_JP</name><value></value></preference><preference><name>reminderQueries_de_DE</name><value></value></preference></portlet-preferences>'),(20878,20873,6,'<portlet-preferences><preference><name>reminderQueries_en_US</name><value></value></preference><preference><name>reminderQueries_ca_ES</name><value></value></preference><preference><name>reminderQueries_hu_HU</name><value></value></preference><preference><name>reminderQueries_fi_FI</name><value></value></preference><preference><name>reminderQueries_es_ES</name><value></value></preference><preference><name>reminderQueries_iw_IL</name><value></value></preference><preference><name>reminderQueries</name><value></value></preference><preference><name>reminderQueries_pt_BR</name><value></value></preference><preference><name>reminderQueries_fr_FR</name><value></value></preference><preference><name>reminderQueries_ja_JP</name><value></value></preference><preference><name>reminderQueries_de_DE</name><value></value></preference></portlet-preferences>'),(20886,20881,6,'<portlet-preferences><preference><name>reminderQueries_en_US</name><value></value></preference><preference><name>reminderQueries_ca_ES</name><value></value></preference><preference><name>reminderQueries_hu_HU</name><value></value></preference><preference><name>reminderQueries_fi_FI</name><value></value></preference><preference><name>reminderQueries_es_ES</name><value></value></preference><preference><name>reminderQueries_iw_IL</name><value></value></preference><preference><name>reminderQueries</name><value>NULL_VALUE</value></preference><preference><name>reminderQueries_pt_BR</name><value></value></preference><preference><name>reminderQueries_fr_FR</name><value></value></preference><preference><name>reminderQueries_ja_JP</name><value></value></preference><preference><name>reminderQueries_de_DE</name><value></value></preference></portlet-preferences>'),(20892,20887,6,'<portlet-preferences><preference><name>reminderQueries_en_US</name><value></value></preference><preference><name>reminderQueries_ca_ES</name><value></value></preference><preference><name>reminderQueries_hu_HU</name><value></value></preference><preference><name>reminderQueries_fi_FI</name><value></value></preference><preference><name>reminderQueries_es_ES</name><value></value></preference><preference><name>reminderQueries_iw_IL</name><value></value></preference><preference><name>reminderQueries</name><value>NULL_VALUE</value></preference><preference><name>reminderQueries_pt_BR</name><value></value></preference><preference><name>reminderQueries_fr_FR</name><value></value></preference><preference><name>reminderQueries_ja_JP</name><value></value></preference><preference><name>reminderQueries_de_DE</name><value></value></preference></portlet-preferences>'),(20898,20893,6,'<portlet-preferences><preference><name>reminderQueries_en_US</name><value></value></preference><preference><name>reminderQueries_ca_ES</name><value></value></preference><preference><name>reminderQueries_hu_HU</name><value></value></preference><preference><name>reminderQueries_fi_FI</name><value></value></preference><preference><name>reminderQueries_es_ES</name><value></value></preference><preference><name>reminderQueries_iw_IL</name><value></value></preference><preference><name>reminderQueries</name><value>NULL_VALUE</value></preference><preference><name>reminderQueries_pt_BR</name><value></value></preference><preference><name>reminderQueries_fr_FR</name><value></value></preference><preference><name>reminderQueries_ja_JP</name><value></value></preference><preference><name>reminderQueries_de_DE</name><value></value></preference></portlet-preferences>'),(20904,20899,6,'<portlet-preferences><preference><name>reminderQueries_en_US</name><value></value></preference><preference><name>reminderQueries_ca_ES</name><value></value></preference><preference><name>reminderQueries_hu_HU</name><value></value></preference><preference><name>reminderQueries_fi_FI</name><value></value></preference><preference><name>reminderQueries_es_ES</name><value></value></preference><preference><name>reminderQueries_iw_IL</name><value></value></preference><preference><name>reminderQueries</name><value>NULL_VALUE</value></preference><preference><name>reminderQueries_pt_BR</name><value></value></preference><preference><name>reminderQueries_fr_FR</name><value></value></preference><preference><name>reminderQueries_ja_JP</name><value></value></preference><preference><name>reminderQueries_de_DE</name><value></value></preference></portlet-preferences>'),(20910,20905,6,'<portlet-preferences><preference><name>reminderQueries_en_US</name><value></value></preference><preference><name>reminderQueries_ca_ES</name><value></value></preference><preference><name>reminderQueries_hu_HU</name><value></value></preference><preference><name>reminderQueries_fi_FI</name><value></value></preference><preference><name>reminderQueries_es_ES</name><value></value></preference><preference><name>reminderQueries_iw_IL</name><value></value></preference><preference><name>reminderQueries</name><value>NULL_VALUE</value></preference><preference><name>reminderQueries_pt_BR</name><value></value></preference><preference><name>reminderQueries_fr_FR</name><value></value></preference><preference><name>reminderQueries_ja_JP</name><value></value></preference><preference><name>reminderQueries_de_DE</name><value></value></preference></portlet-preferences>'),(20916,20911,6,'<portlet-preferences><preference><name>reminderQueries_en_US</name><value></value></preference><preference><name>reminderQueries_ca_ES</name><value></value></preference><preference><name>reminderQueries_hu_HU</name><value></value></preference><preference><name>reminderQueries_fi_FI</name><value></value></preference><preference><name>reminderQueries_es_ES</name><value></value></preference><preference><name>reminderQueries_iw_IL</name><value></value></preference><preference><name>reminderQueries</name><value>NULL_VALUE</value></preference><preference><name>reminderQueries_pt_BR</name><value></value></preference><preference><name>reminderQueries_fr_FR</name><value></value></preference><preference><name>reminderQueries_ja_JP</name><value></value></preference><preference><name>reminderQueries_de_DE</name><value></value></preference></portlet-preferences>'),(21180,20939,4,'<portlet-preferences />');
/*!40000 ALTER TABLE `portalpreferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portlet`
--

DROP TABLE IF EXISTS `portlet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `portlet` (
  `id_` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `portletId` varchar(200) DEFAULT NULL,
  `roles` longtext,
  `active_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id_`),
  UNIQUE KEY `IX_12B5E51D` (`companyId`,`portletId`),
  KEY `IX_80CC9508` (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portlet`
--

LOCK TABLES `portlet` WRITE;
/*!40000 ALTER TABLE `portlet` DISABLE KEYS */;
INSERT INTO `portlet` VALUES (20205,20154,'98','',0),(20206,20154,'183','',1),(20207,20154,'66','',1),(20208,20154,'180','',1),(20209,20154,'27','',1),(20210,20154,'152','',1),(20211,20154,'134','',1),(20212,20154,'130','',1),(20213,20154,'122','',1),(20214,20154,'36','',1),(20215,20154,'26','',1),(20216,20154,'175','',1),(20217,20154,'153','',1),(20218,20154,'64','',1),(20219,20154,'129','',1),(20220,20154,'182','',1),(20221,20154,'179','',1),(20222,20154,'173','',0),(20223,20154,'100','',1),(20224,20154,'19','',1),(20225,20154,'157','',1),(20226,20154,'181','',1),(20227,20154,'128','',1),(20228,20154,'154','',1),(20229,20154,'148','',1),(20230,20154,'11','',1),(20231,20154,'29','',1),(20232,20154,'158','',1),(20233,20154,'178','',1),(20234,20154,'58','',1),(20235,20154,'71','',1),(20236,20154,'97','',1),(20237,20154,'39','',1),(20238,20154,'85','',1),(20239,20154,'118','',1),(20240,20154,'107','',1),(20241,20154,'30','',1),(20242,20154,'184','',1),(20243,20154,'147','',1),(20244,20154,'48','',1),(20245,20154,'125','',1),(20246,20154,'161','',1),(20247,20154,'146','',1),(20248,20154,'62','',0),(20249,20154,'162','',1),(20250,20154,'176','',1),(20251,20154,'108','',1),(20252,20154,'187','',1),(20253,20154,'84','',1),(20254,20154,'101','',1),(20255,20154,'121','',1),(20256,20154,'143','',1),(20257,20154,'77','',1),(20258,20154,'167','',1),(20259,20154,'115','',1),(20260,20154,'56','',1),(20261,20154,'16','',1),(20262,20154,'3','',1),(20263,20154,'20','',1),(20264,20154,'23','',1),(20265,20154,'83','',1),(20266,20154,'99','',1),(20267,20154,'186','',1),(20268,20154,'194','',1),(20269,20154,'70','',1),(20270,20154,'164','',1),(20271,20154,'141','',1),(20272,20154,'9','',1),(20273,20154,'28','',1),(20274,20154,'137','',1),(20275,20154,'15','',1),(20276,20154,'47','',1),(20277,20154,'116','',1),(20278,20154,'82','',1),(20279,20154,'151','',1),(20280,20154,'54','',1),(20281,20154,'34','',1),(20282,20154,'132','',1),(20283,20154,'169','',1),(20284,20154,'61','',1),(20285,20154,'73','',1),(20286,20154,'50','',1),(20287,20154,'127','',1),(20288,20154,'193','',1),(20289,20154,'31','',1),(20290,20154,'25','',1),(20291,20154,'166','',1),(20292,20154,'33','',1),(20293,20154,'150','',1),(20294,20154,'114','',1),(20295,20154,'149','',1),(20296,20154,'67','',1),(20297,20154,'110','',1),(20298,20154,'59','',1),(20299,20154,'135','',1),(20300,20154,'188','',1),(20301,20154,'131','',1),(20302,20154,'102','',1),(20449,20154,'1_WAR_calendarportlet','',1),(20500,20154,'1_WAR_notificationsportlet','',1),(20505,20154,'4_WAR_opensocialportlet','',1),(20506,20154,'2_WAR_opensocialportlet','',1),(20507,20154,'1_WAR_opensocialportlet','',1),(20508,20154,'3_WAR_opensocialportlet','',1),(20515,20154,'1_WAR_webformportlet','',1),(21008,20154,'dictionary_WAR_sysportlet','',1),(21110,20154,'leaderweeklywork_WAR_oaportlet','',1),(21111,20154,'officesupply_WAR_oaportlet','',1),(21112,20154,'vehiclerequisition_WAR_oaportlet','',1),(21113,20154,'senddispatch_WAR_oaportlet','',1),(21114,20154,'deptweeklywork_WAR_oaportlet','',1);
/*!40000 ALTER TABLE `portlet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portletitem`
--

DROP TABLE IF EXISTS `portletitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `portletitem` (
  `portletItemId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `portletId` varchar(200) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`portletItemId`),
  KEY `IX_96BDD537` (`groupId`,`classNameId`),
  KEY `IX_D699243F` (`groupId`,`name`,`portletId`,`classNameId`),
  KEY `IX_2C61314E` (`groupId`,`portletId`),
  KEY `IX_E922D6C0` (`groupId`,`portletId`,`classNameId`),
  KEY `IX_8E71167F` (`groupId`,`portletId`,`classNameId`,`name`),
  KEY `IX_33B8CE8D` (`groupId`,`portletId`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portletitem`
--

LOCK TABLES `portletitem` WRITE;
/*!40000 ALTER TABLE `portletitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `portletitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portletpreferences`
--

DROP TABLE IF EXISTS `portletpreferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `portletpreferences` (
  `portletPreferencesId` bigint(20) NOT NULL,
  `ownerId` bigint(20) DEFAULT NULL,
  `ownerType` int(11) DEFAULT NULL,
  `plid` bigint(20) DEFAULT NULL,
  `portletId` varchar(200) DEFAULT NULL,
  `preferences` longtext,
  PRIMARY KEY (`portletPreferencesId`),
  UNIQUE KEY `IX_C7057FF7` (`ownerId`,`ownerType`,`plid`,`portletId`),
  KEY `IX_E4F13E6E` (`ownerId`,`ownerType`,`plid`),
  KEY `IX_C9A3FCE2` (`ownerId`,`ownerType`,`portletId`),
  KEY `IX_D5EDA3A1` (`ownerType`,`plid`,`portletId`),
  KEY `IX_A3B2A80C` (`ownerType`,`portletId`),
  KEY `IX_F15C1C4F` (`plid`),
  KEY `IX_D340DB76` (`plid`,`portletId`),
  KEY `IX_8E6DA3A1` (`portletId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portletpreferences`
--

LOCK TABLES `portletpreferences` WRITE;
/*!40000 ALTER TABLE `portletpreferences` DISABLE KEYS */;
INSERT INTO `portletpreferences` VALUES (20327,0,3,20320,'148_INSTANCE_mWmqEdahLqMP','<portlet-preferences><preference><name>showAssetCount</name><value>true</value></preference><preference><name>showZeroAssetCount</name><value>false</value></preference><preference><name>classNameId</name><value>20007</value></preference><preference><name>displayStyle</name><value>cloud</value></preference><preference><name>maxAssetTags</name><value>10</value></preference></portlet-preferences>'),(20348,0,3,20342,'141_INSTANCE_2rhnCUy2CIOc','<portlet-preferences><preference><name>showAssetCount</name><value>true</value></preference><preference><name>classNameId</name><value>20016</value></preference></portlet-preferences>'),(20367,0,3,20361,'3','<portlet-preferences><preference><name>portletSetupShowBorders</name><value>false</value></preference></portlet-preferences>'),(20368,0,3,20361,'101_INSTANCE_3Ehai8qFPPux','<portlet-preferences><preference><name>portletSetupUseCustomTitle</name><value>true</value></preference><preference><name>portletSetupTitle_zh_CN</name><value>Upcoming Events</value></preference><preference><name>anyAssetType</name><value>false</value></preference></portlet-preferences>'),(20393,0,3,20387,'3','<portlet-preferences><preference><name>portletSetupShowBorders</name><value>false</value></preference></portlet-preferences>'),(20394,0,3,20387,'82','<portlet-preferences><preference><name>displayStyle</name><value>3</value></preference></portlet-preferences>'),(20395,0,3,20387,'101_INSTANCE_5r2gG79nrjNw','<portlet-preferences><preference><name>portletSetupUseCustomTitle</name><value>true</value></preference><preference><name>portletSetupTitle_zh_CN</name><value>Recent Content</value></preference></portlet-preferences>'),(20402,0,3,20396,'20','<portlet-preferences><preference><name>portletSetupShowBorders</name><value>false</value></preference></portlet-preferences>'),(20403,0,3,20396,'101_INSTANCE_nODfUxlvAneS','<portlet-preferences><preference><name>portletSetupUseCustomTitle</name><value>true</value></preference><preference><name>portletSetupTitle_zh_CN</name><value>Upcoming Events</value></preference><preference><name>anyAssetType</name><value>false</value></preference></portlet-preferences>'),(20410,0,3,20404,'39_INSTANCE_hdT9AX4ACu96','<portlet-preferences><preference><name>portletSetupUseCustomTitle</name><value>true</value></preference><preference><name>expandedEntriesPerFeed</name><value>3</value></preference><preference><name>urls</name><value>http://partners.userland.com/nytRss/technology.xml</value></preference><preference><name>portletSetupTitle_zh_CN</name><value>Technology news</value></preference><preference><name>entriesPerFeed</name><value>4</value></preference></portlet-preferences>'),(20411,0,3,20404,'39_INSTANCE_F26XmskYlWyj','<portlet-preferences><preference><name>portletSetupUseCustomTitle</name><value>true</value></preference><preference><name>expandedEntriesPerFeed</name><value>0</value></preference><preference><name>urls</name><value>http://www.liferay.com/en/about-us/news/-/blogs/rss</value></preference><preference><name>titles</name><value>Liferay Press Releases</value></preference><preference><name>portletSetupTitle_zh_CN</name><value>Liferay news</value></preference><preference><name>entriesPerFeed</name><value>4</value></preference></portlet-preferences>'),(20530,0,3,20184,'145','<portlet-preferences />'),(20601,0,3,20184,'2_WAR_notificationsportlet','<portlet-preferences />'),(20603,0,3,20175,'190','<portlet-preferences />'),(20604,0,3,20175,'145','<portlet-preferences />'),(20605,0,3,20175,'2_WAR_notificationsportlet','<portlet-preferences />'),(20606,0,3,20175,'134','<portlet-preferences />'),(20607,0,3,20175,'130','<portlet-preferences />'),(20612,0,3,20175,'160','<portlet-preferences />'),(20613,0,3,20175,'165','<portlet-preferences />'),(20614,0,3,20175,'156','<portlet-preferences />'),(20705,0,3,20621,'145','<portlet-preferences />'),(20706,0,3,20621,'2_WAR_notificationsportlet','<portlet-preferences />'),(20707,0,3,20663,'145','<portlet-preferences />'),(20708,0,3,20663,'2_WAR_notificationsportlet','<portlet-preferences />'),(20709,0,3,20681,'145','<portlet-preferences />'),(20710,0,3,20681,'2_WAR_notificationsportlet','<portlet-preferences />'),(20711,0,3,20687,'145','<portlet-preferences />'),(20712,0,3,20687,'2_WAR_notificationsportlet','<portlet-preferences />'),(20781,0,3,20175,'15','<portlet-preferences />'),(20782,20194,2,0,'15','<portlet-preferences />'),(20819,0,3,20783,'145','<portlet-preferences />'),(20820,0,3,20783,'2_WAR_notificationsportlet','<portlet-preferences />'),(20829,0,3,20184,'184_INSTANCE_MCoV5B8xsCQ3','<portlet-preferences />'),(20830,0,3,20739,'145','<portlet-preferences />'),(20831,0,3,20739,'2_WAR_notificationsportlet','<portlet-preferences />'),(20832,0,3,20739,'58','<portlet-preferences />'),(20833,0,3,20821,'145','<portlet-preferences />'),(20834,0,3,20821,'2_WAR_notificationsportlet','<portlet-preferences />'),(20835,0,3,20821,'58','<portlet-preferences />'),(20836,0,3,20615,'145','<portlet-preferences />'),(20837,0,3,20615,'2_WAR_notificationsportlet','<portlet-preferences />'),(20838,0,3,20615,'58','<portlet-preferences />'),(20839,0,3,20175,'3_WAR_marketplaceportlet','<portlet-preferences />'),(20840,20198,4,20175,'3_WAR_marketplaceportlet','<portlet-preferences />'),(20841,0,3,20175,'135','<portlet-preferences />'),(20842,0,3,20175,'151','<portlet-preferences />'),(20843,0,3,20175,'137','<portlet-preferences />'),(20844,0,3,20175,'125','<portlet-preferences />'),(20845,0,3,20175,'86','<portlet-preferences />'),(20917,0,3,20627,'145','<portlet-preferences />'),(20918,0,3,20627,'2_WAR_notificationsportlet','<portlet-preferences />'),(20919,0,3,20645,'145','<portlet-preferences />'),(20920,0,3,20645,'2_WAR_notificationsportlet','<portlet-preferences />'),(20921,0,3,20657,'145','<portlet-preferences />'),(20922,0,3,20657,'2_WAR_notificationsportlet','<portlet-preferences />'),(20923,0,3,20669,'145','<portlet-preferences />'),(20924,0,3,20669,'2_WAR_notificationsportlet','<portlet-preferences />'),(20925,0,3,20719,'145','<portlet-preferences />'),(20926,0,3,20719,'2_WAR_notificationsportlet','<portlet-preferences />'),(20927,0,3,20725,'145','<portlet-preferences />'),(20928,0,3,20725,'2_WAR_notificationsportlet','<portlet-preferences />'),(20929,0,3,20633,'145','<portlet-preferences />'),(20930,0,3,20633,'2_WAR_notificationsportlet','<portlet-preferences />'),(20931,0,3,20639,'145','<portlet-preferences />'),(20932,0,3,20639,'2_WAR_notificationsportlet','<portlet-preferences />'),(20933,0,3,20693,'145','<portlet-preferences />'),(20934,0,3,20693,'2_WAR_notificationsportlet','<portlet-preferences />'),(20935,0,3,20699,'145','<portlet-preferences />'),(20936,0,3,20699,'2_WAR_notificationsportlet','<portlet-preferences />'),(20937,0,3,20175,'128','<portlet-preferences />'),(21001,0,3,20516,'145','<portlet-preferences />'),(21002,0,3,20516,'2_WAR_notificationsportlet','<portlet-preferences />'),(21003,0,3,20175,'2','<portlet-preferences />'),(21006,0,3,20713,'145','<portlet-preferences />'),(21007,0,3,20713,'2_WAR_notificationsportlet','<portlet-preferences />'),(21009,0,3,20725,'dictionary_WAR_sysportlet','<portlet-preferences />'),(21115,0,3,20645,'leaderweeklywork_WAR_oaportlet','<portlet-preferences />'),(21116,0,3,20657,'vehiclerequisition_WAR_oaportlet','<portlet-preferences />'),(21117,0,3,20675,'145','<portlet-preferences />'),(21118,0,3,20675,'2_WAR_notificationsportlet','<portlet-preferences />'),(21119,0,3,20719,'senddispatch_WAR_oaportlet','<portlet-preferences />'),(21120,0,3,20175,'174','<portlet-preferences />'),(21121,0,3,20669,'officesupply_WAR_oaportlet','<portlet-preferences />'),(21122,0,3,20813,'145','<portlet-preferences />'),(21123,0,3,20813,'2_WAR_notificationsportlet','<portlet-preferences />'),(21124,0,3,20813,'dictionary_WAR_sysportlet','<portlet-preferences />'),(21125,0,3,20807,'145','<portlet-preferences />'),(21126,0,3,20807,'2_WAR_notificationsportlet','<portlet-preferences />'),(21135,0,3,20801,'145','<portlet-preferences />'),(21136,0,3,20801,'2_WAR_notificationsportlet','<portlet-preferences />'),(21137,20731,2,0,'15','<portlet-preferences />'),(21162,0,3,21156,'145','<portlet-preferences />'),(21163,0,3,21156,'2_WAR_notificationsportlet','<portlet-preferences />'),(21164,0,3,20789,'145','<portlet-preferences />'),(21165,0,3,20789,'2_WAR_notificationsportlet','<portlet-preferences />'),(21166,0,3,20795,'145','<portlet-preferences />'),(21167,0,3,20795,'2_WAR_notificationsportlet','<portlet-preferences />'),(21183,0,3,20175,'127','<portlet-preferences />'),(21184,0,3,21138,'145','<portlet-preferences />'),(21185,0,3,21138,'2_WAR_notificationsportlet','<portlet-preferences />'),(21186,0,3,21144,'145','<portlet-preferences />'),(21187,0,3,21144,'2_WAR_notificationsportlet','<portlet-preferences />'),(21188,0,3,20745,'145','<portlet-preferences />'),(21189,0,3,20745,'2_WAR_notificationsportlet','<portlet-preferences />'),(21190,0,3,20775,'145','<portlet-preferences />'),(21191,0,3,20775,'2_WAR_notificationsportlet','<portlet-preferences />');
/*!40000 ALTER TABLE `portletpreferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartz_blob_triggers`
--

DROP TABLE IF EXISTS `quartz_blob_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quartz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` longblob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartz_blob_triggers`
--

LOCK TABLES `quartz_blob_triggers` WRITE;
/*!40000 ALTER TABLE `quartz_blob_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `quartz_blob_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartz_calendars`
--

DROP TABLE IF EXISTS `quartz_calendars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quartz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` longblob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartz_calendars`
--

LOCK TABLES `quartz_calendars` WRITE;
/*!40000 ALTER TABLE `quartz_calendars` DISABLE KEYS */;
/*!40000 ALTER TABLE `quartz_calendars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartz_cron_triggers`
--

DROP TABLE IF EXISTS `quartz_cron_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quartz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(200) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartz_cron_triggers`
--

LOCK TABLES `quartz_cron_triggers` WRITE;
/*!40000 ALTER TABLE `quartz_cron_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `quartz_cron_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartz_fired_triggers`
--

DROP TABLE IF EXISTS `quartz_fired_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quartz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(20) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` tinyint(4) DEFAULT NULL,
  `REQUESTS_RECOVERY` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IX_BE3835E5` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IX_4BD722BM` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IX_204D31E8` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IX_339E078M` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IX_5005E3AF` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IX_BC2F03B0` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartz_fired_triggers`
--

LOCK TABLES `quartz_fired_triggers` WRITE;
/*!40000 ALTER TABLE `quartz_fired_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `quartz_fired_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartz_job_details`
--

DROP TABLE IF EXISTS `quartz_job_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quartz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` tinyint(4) NOT NULL,
  `IS_NONCONCURRENT` tinyint(4) NOT NULL,
  `IS_UPDATE_DATA` tinyint(4) NOT NULL,
  `REQUESTS_RECOVERY` tinyint(4) NOT NULL,
  `JOB_DATA` longblob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IX_88328984` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IX_779BCA37` (`SCHED_NAME`,`REQUESTS_RECOVERY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartz_job_details`
--

LOCK TABLES `quartz_job_details` WRITE;
/*!40000 ALTER TABLE `quartz_job_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `quartz_job_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartz_locks`
--

DROP TABLE IF EXISTS `quartz_locks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quartz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartz_locks`
--

LOCK TABLES `quartz_locks` WRITE;
/*!40000 ALTER TABLE `quartz_locks` DISABLE KEYS */;
/*!40000 ALTER TABLE `quartz_locks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartz_paused_trigger_grps`
--

DROP TABLE IF EXISTS `quartz_paused_trigger_grps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quartz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartz_paused_trigger_grps`
--

LOCK TABLES `quartz_paused_trigger_grps` WRITE;
/*!40000 ALTER TABLE `quartz_paused_trigger_grps` DISABLE KEYS */;
/*!40000 ALTER TABLE `quartz_paused_trigger_grps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartz_scheduler_state`
--

DROP TABLE IF EXISTS `quartz_scheduler_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quartz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(20) NOT NULL,
  `CHECKIN_INTERVAL` bigint(20) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartz_scheduler_state`
--

LOCK TABLES `quartz_scheduler_state` WRITE;
/*!40000 ALTER TABLE `quartz_scheduler_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `quartz_scheduler_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartz_simple_triggers`
--

DROP TABLE IF EXISTS `quartz_simple_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quartz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(20) NOT NULL,
  `REPEAT_INTERVAL` bigint(20) NOT NULL,
  `TIMES_TRIGGERED` bigint(20) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartz_simple_triggers`
--

LOCK TABLES `quartz_simple_triggers` WRITE;
/*!40000 ALTER TABLE `quartz_simple_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `quartz_simple_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartz_simprop_triggers`
--

DROP TABLE IF EXISTS `quartz_simprop_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quartz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` tinyint(4) DEFAULT NULL,
  `BOOL_PROP_2` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartz_simprop_triggers`
--

LOCK TABLES `quartz_simprop_triggers` WRITE;
/*!40000 ALTER TABLE `quartz_simprop_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `quartz_simprop_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartz_triggers`
--

DROP TABLE IF EXISTS `quartz_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quartz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(20) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(20) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(20) NOT NULL,
  `END_TIME` bigint(20) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` int(11) DEFAULT NULL,
  `JOB_DATA` longblob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IX_186442A4` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IX_1BA1F9DC` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IX_91CA7CCE` (`SCHED_NAME`,`TRIGGER_GROUP`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`,`MISFIRE_INSTR`),
  KEY `IX_D219AFDE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IX_A85822A0` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IX_8AA50BE1` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IX_EEFE382A` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IX_F026CF4C` (`SCHED_NAME`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IX_F2DD7C7E` (`SCHED_NAME`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`,`MISFIRE_INSTR`),
  KEY `IX_1F92813C` (`SCHED_NAME`,`NEXT_FIRE_TIME`,`MISFIRE_INSTR`),
  KEY `IX_99108B6E` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IX_CD7132D0` (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartz_triggers`
--

LOCK TABLES `quartz_triggers` WRITE;
/*!40000 ALTER TABLE `quartz_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `quartz_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ratingsentry`
--

DROP TABLE IF EXISTS `ratingsentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ratingsentry` (
  `entryId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `score` double DEFAULT NULL,
  PRIMARY KEY (`entryId`),
  UNIQUE KEY `IX_B47E3C11` (`userId`,`classNameId`,`classPK`),
  KEY `IX_16184D57` (`classNameId`,`classPK`),
  KEY `IX_A1A8CB8B` (`classNameId`,`classPK`,`score`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ratingsentry`
--

LOCK TABLES `ratingsentry` WRITE;
/*!40000 ALTER TABLE `ratingsentry` DISABLE KEYS */;
/*!40000 ALTER TABLE `ratingsentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ratingsstats`
--

DROP TABLE IF EXISTS `ratingsstats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ratingsstats` (
  `statsId` bigint(20) NOT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `totalEntries` int(11) DEFAULT NULL,
  `totalScore` double DEFAULT NULL,
  `averageScore` double DEFAULT NULL,
  PRIMARY KEY (`statsId`),
  UNIQUE KEY `IX_A6E99284` (`classNameId`,`classPK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ratingsstats`
--

LOCK TABLES `ratingsstats` WRITE;
/*!40000 ALTER TABLE `ratingsstats` DISABLE KEYS */;
/*!40000 ALTER TABLE `ratingsstats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `regionId` bigint(20) NOT NULL,
  `countryId` bigint(20) DEFAULT NULL,
  `regionCode` varchar(75) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `active_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`regionId`),
  UNIQUE KEY `IX_A2635F5C` (`countryId`,`regionCode`),
  KEY `IX_2D9A426F` (`active_`),
  KEY `IX_16D87CA7` (`countryId`),
  KEY `IX_11FB3E42` (`countryId`,`active_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1001,1,'AB','Alberta',1),(1002,1,'BC','British Columbia',1),(1003,1,'MB','Manitoba',1),(1004,1,'NB','New Brunswick',1),(1005,1,'NL','Newfoundland and Labrador',1),(1006,1,'NT','Northwest Territories',1),(1007,1,'NS','Nova Scotia',1),(1008,1,'NU','Nunavut',1),(1009,1,'ON','Ontario',1),(1010,1,'PE','Prince Edward Island',1),(1011,1,'QC','Quebec',1),(1012,1,'SK','Saskatchewan',1),(1013,1,'YT','Yukon',1),(2001,2,'CN-34','Anhui',1),(2002,2,'CN-92','Aomen',1),(2003,2,'CN-11','Beijing',1),(2004,2,'CN-50','Chongqing',1),(2005,2,'CN-35','Fujian',1),(2006,2,'CN-62','Gansu',1),(2007,2,'CN-44','Guangdong',1),(2008,2,'CN-45','Guangxi',1),(2009,2,'CN-52','Guizhou',1),(2010,2,'CN-46','Hainan',1),(2011,2,'CN-13','Hebei',1),(2012,2,'CN-23','Heilongjiang',1),(2013,2,'CN-41','Henan',1),(2014,2,'CN-42','Hubei',1),(2015,2,'CN-43','Hunan',1),(2016,2,'CN-32','Jiangsu',1),(2017,2,'CN-36','Jiangxi',1),(2018,2,'CN-22','Jilin',1),(2019,2,'CN-21','Liaoning',1),(2020,2,'CN-15','Nei Mongol',1),(2021,2,'CN-64','Ningxia',1),(2022,2,'CN-63','Qinghai',1),(2023,2,'CN-61','Shaanxi',1),(2024,2,'CN-37','Shandong',1),(2025,2,'CN-31','Shanghai',1),(2026,2,'CN-14','Shanxi',1),(2027,2,'CN-51','Sichuan',1),(2028,2,'CN-71','Taiwan',1),(2029,2,'CN-12','Tianjin',1),(2030,2,'CN-91','Xianggang',1),(2031,2,'CN-65','Xinjiang',1),(2032,2,'CN-54','Xizang',1),(2033,2,'CN-53','Yunnan',1),(2034,2,'CN-33','Zhejiang',1),(3001,3,'A','Alsace',1),(3002,3,'B','Aquitaine',1),(3003,3,'C','Auvergne',1),(3004,3,'P','Basse-Normandie',1),(3005,3,'D','Bourgogne',1),(3006,3,'E','Bretagne',1),(3007,3,'F','Centre',1),(3008,3,'G','Champagne-Ardenne',1),(3009,3,'H','Corse',1),(3010,3,'GF','Guyane',1),(3011,3,'I','Franche Comté',1),(3012,3,'GP','Guadeloupe',1),(3013,3,'Q','Haute-Normandie',1),(3014,3,'J','Île-de-France',1),(3015,3,'K','Languedoc-Roussillon',1),(3016,3,'L','Limousin',1),(3017,3,'M','Lorraine',1),(3018,3,'MQ','Martinique',1),(3019,3,'N','Midi-Pyrénées',1),(3020,3,'O','Nord Pas de Calais',1),(3021,3,'R','Pays de la Loire',1),(3022,3,'S','Picardie',1),(3023,3,'T','Poitou-Charentes',1),(3024,3,'U','Provence-Alpes-Côte-d\'Azur',1),(3025,3,'RE','Réunion',1),(3026,3,'V','Rhône-Alpes',1),(4001,4,'BW','Baden-Württemberg',1),(4002,4,'BY','Bayern',1),(4003,4,'BE','Berlin',1),(4004,4,'BB','Brandenburg',1),(4005,4,'HB','Bremen',1),(4006,4,'HH','Hamburg',1),(4007,4,'HE','Hessen',1),(4008,4,'MV','Mecklenburg-Vorpommern',1),(4009,4,'NI','Niedersachsen',1),(4010,4,'NW','Nordrhein-Westfalen',1),(4011,4,'RP','Rheinland-Pfalz',1),(4012,4,'SL','Saarland',1),(4013,4,'SN','Sachsen',1),(4014,4,'ST','Sachsen-Anhalt',1),(4015,4,'SH','Schleswig-Holstein',1),(4016,4,'TH','Thüringen',1),(8001,8,'AG','Agrigento',1),(8002,8,'AL','Alessandria',1),(8003,8,'AN','Ancona',1),(8004,8,'AO','Aosta',1),(8005,8,'AR','Arezzo',1),(8006,8,'AP','Ascoli Piceno',1),(8007,8,'AT','Asti',1),(8008,8,'AV','Avellino',1),(8009,8,'BA','Bari',1),(8010,8,'BT','Barletta-Andria-Trani',1),(8011,8,'BL','Belluno',1),(8012,8,'BN','Benevento',1),(8013,8,'BG','Bergamo',1),(8014,8,'BI','Biella',1),(8015,8,'BO','Bologna',1),(8016,8,'BZ','Bolzano',1),(8017,8,'BS','Brescia',1),(8018,8,'BR','Brindisi',1),(8019,8,'CA','Cagliari',1),(8020,8,'CL','Caltanissetta',1),(8021,8,'CB','Campobasso',1),(8022,8,'CI','Carbonia-Iglesias',1),(8023,8,'CE','Caserta',1),(8024,8,'CT','Catania',1),(8025,8,'CZ','Catanzaro',1),(8026,8,'CH','Chieti',1),(8027,8,'CO','Como',1),(8028,8,'CS','Cosenza',1),(8029,8,'CR','Cremona',1),(8030,8,'KR','Crotone',1),(8031,8,'CN','Cuneo',1),(8032,8,'EN','Enna',1),(8033,8,'FM','Fermo',1),(8034,8,'FE','Ferrara',1),(8035,8,'FI','Firenze',1),(8036,8,'FG','Foggia',1),(8037,8,'FC','Forli-Cesena',1),(8038,8,'FR','Frosinone',1),(8039,8,'GE','Genova',1),(8040,8,'GO','Gorizia',1),(8041,8,'GR','Grosseto',1),(8042,8,'IM','Imperia',1),(8043,8,'IS','Isernia',1),(8044,8,'AQ','L\'Aquila',1),(8045,8,'SP','La Spezia',1),(8046,8,'LT','Latina',1),(8047,8,'LE','Lecce',1),(8048,8,'LC','Lecco',1),(8049,8,'LI','Livorno',1),(8050,8,'LO','Lodi',1),(8051,8,'LU','Lucca',1),(8052,8,'MC','Macerata',1),(8053,8,'MN','Mantova',1),(8054,8,'MS','Massa-Carrara',1),(8055,8,'MT','Matera',1),(8056,8,'MA','Medio Campidano',1),(8057,8,'ME','Messina',1),(8058,8,'MI','Milano',1),(8059,8,'MO','Modena',1),(8060,8,'MB','Monza e Brianza',1),(8061,8,'NA','Napoli',1),(8062,8,'NO','Novara',1),(8063,8,'NU','Nuoro',1),(8064,8,'OG','Ogliastra',1),(8065,8,'OT','Olbia-Tempio',1),(8066,8,'OR','Oristano',1),(8067,8,'PD','Padova',1),(8068,8,'PA','Palermo',1),(8069,8,'PR','Parma',1),(8070,8,'PV','Pavia',1),(8071,8,'PG','Perugia',1),(8072,8,'PU','Pesaro e Urbino',1),(8073,8,'PE','Pescara',1),(8074,8,'PC','Piacenza',1),(8075,8,'PI','Pisa',1),(8076,8,'PT','Pistoia',1),(8077,8,'PN','Pordenone',1),(8078,8,'PZ','Potenza',1),(8079,8,'PO','Prato',1),(8080,8,'RG','Ragusa',1),(8081,8,'RA','Ravenna',1),(8082,8,'RC','Reggio Calabria',1),(8083,8,'RE','Reggio Emilia',1),(8084,8,'RI','Rieti',1),(8085,8,'RN','Rimini',1),(8086,8,'RM','Roma',1),(8087,8,'RO','Rovigo',1),(8088,8,'SA','Salerno',1),(8089,8,'SS','Sassari',1),(8090,8,'SV','Savona',1),(8091,8,'SI','Siena',1),(8092,8,'SR','Siracusa',1),(8093,8,'SO','Sondrio',1),(8094,8,'TA','Taranto',1),(8095,8,'TE','Teramo',1),(8096,8,'TR','Terni',1),(8097,8,'TO','Torino',1),(8098,8,'TP','Trapani',1),(8099,8,'TN','Trento',1),(8100,8,'TV','Treviso',1),(8101,8,'TS','Trieste',1),(8102,8,'UD','Udine',1),(8103,8,'VA','Varese',1),(8104,8,'VE','Venezia',1),(8105,8,'VB','Verbano-Cusio-Ossola',1),(8106,8,'VC','Vercelli',1),(8107,8,'VR','Verona',1),(8108,8,'VV','Vibo Valentia',1),(8109,8,'VI','Vicenza',1),(8110,8,'VT','Viterbo',1),(11001,11,'DR','Drenthe',1),(11002,11,'FL','Flevoland',1),(11003,11,'FR','Friesland',1),(11004,11,'GE','Gelderland',1),(11005,11,'GR','Groningen',1),(11006,11,'LI','Limburg',1),(11007,11,'NB','Noord-Brabant',1),(11008,11,'NH','Noord-Holland',1),(11009,11,'OV','Overijssel',1),(11010,11,'UT','Utrecht',1),(11011,11,'ZE','Zeeland',1),(11012,11,'ZH','Zuid-Holland',1),(15001,15,'AN','Andalusia',1),(15002,15,'AR','Aragon',1),(15003,15,'AS','Asturias',1),(15004,15,'IB','Balearic Islands',1),(15005,15,'PV','Basque Country',1),(15006,15,'CN','Canary Islands',1),(15007,15,'CB','Cantabria',1),(15008,15,'CL','Castile and Leon',1),(15009,15,'CM','Castile-La Mancha',1),(15010,15,'CT','Catalonia',1),(15011,15,'CE','Ceuta',1),(15012,15,'EX','Extremadura',1),(15013,15,'GA','Galicia',1),(15014,15,'LO','La Rioja',1),(15015,15,'M','Madrid',1),(15016,15,'ML','Melilla',1),(15017,15,'MU','Murcia',1),(15018,15,'NA','Navarra',1),(15019,15,'VC','Valencia',1),(19001,19,'AL','Alabama',1),(19002,19,'AK','Alaska',1),(19003,19,'AZ','Arizona',1),(19004,19,'AR','Arkansas',1),(19005,19,'CA','California',1),(19006,19,'CO','Colorado',1),(19007,19,'CT','Connecticut',1),(19008,19,'DC','District of Columbia',1),(19009,19,'DE','Delaware',1),(19010,19,'FL','Florida',1),(19011,19,'GA','Georgia',1),(19012,19,'HI','Hawaii',1),(19013,19,'ID','Idaho',1),(19014,19,'IL','Illinois',1),(19015,19,'IN','Indiana',1),(19016,19,'IA','Iowa',1),(19017,19,'KS','Kansas',1),(19018,19,'KY','Kentucky ',1),(19019,19,'LA','Louisiana ',1),(19020,19,'ME','Maine',1),(19021,19,'MD','Maryland',1),(19022,19,'MA','Massachusetts',1),(19023,19,'MI','Michigan',1),(19024,19,'MN','Minnesota',1),(19025,19,'MS','Mississippi',1),(19026,19,'MO','Missouri',1),(19027,19,'MT','Montana',1),(19028,19,'NE','Nebraska',1),(19029,19,'NV','Nevada',1),(19030,19,'NH','New Hampshire',1),(19031,19,'NJ','New Jersey',1),(19032,19,'NM','New Mexico',1),(19033,19,'NY','New York',1),(19034,19,'NC','North Carolina',1),(19035,19,'ND','North Dakota',1),(19036,19,'OH','Ohio',1),(19037,19,'OK','Oklahoma ',1),(19038,19,'OR','Oregon',1),(19039,19,'PA','Pennsylvania',1),(19040,19,'PR','Puerto Rico',1),(19041,19,'RI','Rhode Island',1),(19042,19,'SC','South Carolina',1),(19043,19,'SD','South Dakota',1),(19044,19,'TN','Tennessee',1),(19045,19,'TX','Texas',1),(19046,19,'UT','Utah',1),(19047,19,'VT','Vermont',1),(19048,19,'VA','Virginia',1),(19049,19,'WA','Washington',1),(19050,19,'WV','West Virginia',1),(19051,19,'WI','Wisconsin',1),(19052,19,'WY','Wyoming',1),(32001,32,'ACT','Australian Capital Territory',1),(32002,32,'NSW','New South Wales',1),(32003,32,'NT','Northern Territory',1),(32004,32,'QLD','Queensland',1),(32005,32,'SA','South Australia',1),(32006,32,'TAS','Tasmania',1),(32007,32,'VIC','Victoria',1),(32008,32,'WA','Western Australia',1),(144001,144,'MX-AGS','Aguascalientes',1),(144002,144,'MX-BCN','Baja California',1),(144003,144,'MX-BCS','Baja California Sur',1),(144004,144,'MX-CAM','Campeche',1),(144005,144,'MX-CHP','Chiapas',1),(144006,144,'MX-CHI','Chihuahua',1),(144007,144,'MX-COA','Coahuila',1),(144008,144,'MX-COL','Colima',1),(144009,144,'MX-DUR','Durango',1),(144010,144,'MX-GTO','Guanajuato',1),(144011,144,'MX-GRO','Guerrero',1),(144012,144,'MX-HGO','Hidalgo',1),(144013,144,'MX-JAL','Jalisco',1),(144014,144,'MX-MEX','Mexico',1),(144015,144,'MX-MIC','Michoacan',1),(144016,144,'MX-MOR','Morelos',1),(144017,144,'MX-NAY','Nayarit',1),(144018,144,'MX-NLE','Nuevo Leon',1),(144019,144,'MX-OAX','Oaxaca',1),(144020,144,'MX-PUE','Puebla',1),(144021,144,'MX-QRO','Queretaro',1),(144023,144,'MX-ROO','Quintana Roo',1),(144024,144,'MX-SLP','San Luis Potosí',1),(144025,144,'MX-SIN','Sinaloa',1),(144026,144,'MX-SON','Sonora',1),(144027,144,'MX-TAB','Tabasco',1),(144028,144,'MX-TAM','Tamaulipas',1),(144029,144,'MX-TLX','Tlaxcala',1),(144030,144,'MX-VER','Veracruz',1),(144031,144,'MX-YUC','Yucatan',1),(144032,144,'MX-ZAC','Zacatecas',1),(164001,164,'01','Østfold',1),(164002,164,'02','Akershus',1),(164003,164,'03','Oslo',1),(164004,164,'04','Hedmark',1),(164005,164,'05','Oppland',1),(164006,164,'06','Buskerud',1),(164007,164,'07','Vestfold',1),(164008,164,'08','Telemark',1),(164009,164,'09','Aust-Agder',1),(164010,164,'10','Vest-Agder',1),(164011,164,'11','Rogaland',1),(164012,164,'12','Hordaland',1),(164013,164,'14','Sogn og Fjordane',1),(164014,164,'15','Møre of Romsdal',1),(164015,164,'16','Sør-Trøndelag',1),(164016,164,'17','Nord-Trøndelag',1),(164017,164,'18','Nordland',1),(164018,164,'19','Troms',1),(164019,164,'20','Finnmark',1),(202001,202,'AG','Aargau',1),(202002,202,'AR','Appenzell Ausserrhoden',1),(202003,202,'AI','Appenzell Innerrhoden',1),(202004,202,'BL','Basel-Landschaft',1),(202005,202,'BS','Basel-Stadt',1),(202006,202,'BE','Bern',1),(202007,202,'FR','Fribourg',1),(202008,202,'GE','Geneva',1),(202009,202,'GL','Glarus',1),(202010,202,'GR','Graubünden',1),(202011,202,'JU','Jura',1),(202012,202,'LU','Lucerne',1),(202013,202,'NE','Neuchâtel',1),(202014,202,'NW','Nidwalden',1),(202015,202,'OW','Obwalden',1),(202016,202,'SH','Schaffhausen',1),(202017,202,'SZ','Schwyz',1),(202018,202,'SO','Solothurn',1),(202019,202,'SG','St. Gallen',1),(202020,202,'TG','Thurgau',1),(202021,202,'TI','Ticino',1),(202022,202,'UR','Uri',1),(202023,202,'VS','Valais',1),(202024,202,'VD','Vaud',1),(202025,202,'ZG','Zug',1),(202026,202,'ZH','Zürich',1);
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `release_`
--

DROP TABLE IF EXISTS `release_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `release_` (
  `releaseId` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `servletContextName` varchar(75) DEFAULT NULL,
  `buildNumber` int(11) DEFAULT NULL,
  `buildDate` datetime DEFAULT NULL,
  `verified` tinyint(4) DEFAULT NULL,
  `state_` int(11) DEFAULT NULL,
  `testString` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`releaseId`),
  UNIQUE KEY `IX_8BD6BCA7` (`servletContextName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `release_`
--

LOCK TABLES `release_` WRITE;
/*!40000 ALTER TABLE `release_` DISABLE KEYS */;
INSERT INTO `release_` VALUES (1,'2016-06-30 20:47:30','2016-07-05 18:14:37','portal',6205,'2016-07-05 18:14:37',1,0,'You take the blue pill, the story ends, you wake up in your bed and believe whatever you want to believe. You take the red pill, you stay in Wonderland, and I show you how deep the rabbit hole goes.'),(20440,'2016-06-30 20:52:29','2016-07-05 18:15:26','marketplace-portlet',100,NULL,1,0,''),(20448,'2016-06-30 20:52:45','2016-07-05 18:15:29','calendar-portlet',102,NULL,1,0,''),(20467,'2016-06-30 20:53:21','2016-07-05 18:15:38','kaleo-web',110,NULL,1,0,''),(20499,'2016-06-30 20:53:26','2016-07-05 18:15:44','notifications-portlet',110,NULL,1,0,''),(20514,'2016-06-30 20:53:42','2016-07-05 18:16:10','sync-web',101,NULL,1,0,'');
/*!40000 ALTER TABLE `release_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repository`
--

DROP TABLE IF EXISTS `repository`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `repository` (
  `uuid_` varchar(75) DEFAULT NULL,
  `repositoryId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `description` longtext,
  `portletId` varchar(200) DEFAULT NULL,
  `typeSettings` longtext,
  `dlFolderId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`repositoryId`),
  UNIQUE KEY `IX_60C8634C` (`groupId`,`name`,`portletId`),
  UNIQUE KEY `IX_11641E26` (`uuid_`,`groupId`),
  KEY `IX_5253B1FA` (`groupId`),
  KEY `IX_74C17B04` (`uuid_`),
  KEY `IX_F543EA4` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repository`
--

LOCK TABLES `repository` WRITE;
/*!40000 ALTER TABLE `repository` DISABLE KEYS */;
INSERT INTO `repository` VALUES ('3d51a199-579b-44f4-a22f-571387521111',20847,20194,20154,20158,'','2016-07-01 10:09:15','2016-07-01 10:09:15',20846,'20','','20','',20848);
/*!40000 ALTER TABLE `repository` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repositoryentry`
--

DROP TABLE IF EXISTS `repositoryentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `repositoryentry` (
  `uuid_` varchar(75) DEFAULT NULL,
  `repositoryEntryId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `repositoryId` bigint(20) DEFAULT NULL,
  `mappedId` varchar(75) DEFAULT NULL,
  `manualCheckInRequired` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`repositoryEntryId`),
  UNIQUE KEY `IX_9BDCF489` (`repositoryId`,`mappedId`),
  UNIQUE KEY `IX_354AA664` (`uuid_`,`groupId`),
  KEY `IX_B7034B27` (`repositoryId`),
  KEY `IX_B9B1506` (`uuid_`),
  KEY `IX_D3B9AF62` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repositoryentry`
--

LOCK TABLES `repositoryentry` WRITE;
/*!40000 ALTER TABLE `repositoryentry` DISABLE KEYS */;
/*!40000 ALTER TABLE `repositoryentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resourceaction`
--

DROP TABLE IF EXISTS `resourceaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resourceaction` (
  `resourceActionId` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `actionId` varchar(75) DEFAULT NULL,
  `bitwiseValue` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`resourceActionId`),
  UNIQUE KEY `IX_EDB9986E` (`name`,`actionId`),
  KEY `IX_81F2DB09` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resourceaction`
--

LOCK TABLES `resourceaction` WRITE;
/*!40000 ALTER TABLE `resourceaction` DISABLE KEYS */;
INSERT INTO `resourceaction` VALUES (1,'1_WAR_marketplaceportlet','VIEW',1),(2,'1_WAR_marketplaceportlet','ADD_TO_PAGE',2),(3,'1_WAR_marketplaceportlet','CONFIGURATION',4),(4,'1_WAR_marketplaceportlet','PERMISSIONS',8),(5,'1_WAR_marketplaceportlet','PREFERENCES',16),(6,'1_WAR_marketplaceportlet','ACCESS_IN_CONTROL_PANEL',32),(7,'2_WAR_marketplaceportlet','VIEW',1),(8,'2_WAR_marketplaceportlet','ADD_TO_PAGE',2),(9,'2_WAR_marketplaceportlet','CONFIGURATION',4),(10,'2_WAR_marketplaceportlet','PERMISSIONS',8),(11,'2_WAR_marketplaceportlet','PREFERENCES',16),(12,'2_WAR_marketplaceportlet','ACCESS_IN_CONTROL_PANEL',32),(13,'3_WAR_marketplaceportlet','VIEW',1),(14,'3_WAR_marketplaceportlet','ADD_TO_PAGE',2),(15,'3_WAR_marketplaceportlet','CONFIGURATION',4),(16,'3_WAR_marketplaceportlet','PERMISSIONS',8),(17,'3_WAR_marketplaceportlet','PREFERENCES',16),(18,'3_WAR_marketplaceportlet','ACCESS_IN_CONTROL_PANEL',32),(19,'1_WAR_calendarportlet','ACCESS_IN_CONTROL_PANEL',2),(20,'1_WAR_calendarportlet','ADD_TO_PAGE',4),(21,'1_WAR_calendarportlet','CONFIGURATION',8),(22,'1_WAR_calendarportlet','VIEW',1),(23,'1_WAR_calendarportlet','PERMISSIONS',16),(24,'1_WAR_calendarportlet','PREFERENCES',32),(25,'com.liferay.calendar.model.CalendarResource','ADD_CALENDAR',2),(26,'com.liferay.calendar.model.CalendarResource','DELETE',4),(27,'com.liferay.calendar.model.CalendarResource','UPDATE',8),(28,'com.liferay.calendar.model.CalendarResource','VIEW',1),(29,'com.liferay.calendar.model.CalendarResource','PERMISSIONS',16),(30,'com.liferay.calendar.model.Calendar','DELETE',2),(31,'com.liferay.calendar.model.Calendar','MANAGE_BOOKINGS',4),(32,'com.liferay.calendar.model.Calendar','PERMISSIONS',8),(33,'com.liferay.calendar.model.Calendar','UPDATE',16),(34,'com.liferay.calendar.model.Calendar','VIEW',1),(35,'com.liferay.calendar.model.Calendar','VIEW_BOOKING_DETAILS',32),(36,'com.liferay.calendar','ADD_RESOURCE',2),(37,'com.liferay.calendar','PERMISSIONS',4),(38,'com.liferay.calendar.model.CalendarBooking','ADD_DISCUSSION',2),(39,'com.liferay.calendar.model.CalendarBooking','DELETE_DISCUSSION',4),(40,'com.liferay.calendar.model.CalendarBooking','PERMISSIONS',8),(41,'com.liferay.calendar.model.CalendarBooking','UPDATE_DISCUSSION',16),(42,'2_WAR_notificationsportlet','VIEW',1),(43,'2_WAR_notificationsportlet','ADD_TO_PAGE',2),(44,'2_WAR_notificationsportlet','CONFIGURATION',4),(45,'2_WAR_notificationsportlet','PERMISSIONS',8),(46,'2_WAR_notificationsportlet','PREFERENCES',16),(47,'2_WAR_notificationsportlet','ACCESS_IN_CONTROL_PANEL',32),(48,'1_WAR_notificationsportlet','VIEW',1),(49,'1_WAR_notificationsportlet','ADD_TO_PAGE',2),(50,'1_WAR_notificationsportlet','CONFIGURATION',4),(51,'1_WAR_notificationsportlet','PERMISSIONS',8),(52,'1_WAR_notificationsportlet','PREFERENCES',16),(53,'1_WAR_notificationsportlet','ACCESS_IN_CONTROL_PANEL',32),(54,'4_WAR_opensocialportlet','ACCESS_IN_CONTROL_PANEL',2),(55,'4_WAR_opensocialportlet','CONFIGURATION',4),(56,'4_WAR_opensocialportlet','VIEW',1),(57,'4_WAR_opensocialportlet','PERMISSIONS',8),(58,'4_WAR_opensocialportlet','PREFERENCES',16),(59,'2_WAR_opensocialportlet','ADD_TO_PAGE',2),(60,'2_WAR_opensocialportlet','CONFIGURATION',4),(61,'2_WAR_opensocialportlet','VIEW',1),(62,'2_WAR_opensocialportlet','PERMISSIONS',8),(63,'2_WAR_opensocialportlet','PREFERENCES',16),(64,'2_WAR_opensocialportlet','ACCESS_IN_CONTROL_PANEL',32),(65,'1_WAR_opensocialportlet','ACCESS_IN_CONTROL_PANEL',2),(66,'1_WAR_opensocialportlet','CONFIGURATION',4),(67,'1_WAR_opensocialportlet','VIEW',1),(68,'1_WAR_opensocialportlet','PERMISSIONS',8),(69,'1_WAR_opensocialportlet','PREFERENCES',16),(70,'com.liferay.opensocial.model.Gadget','DELETE',2),(71,'com.liferay.opensocial.model.Gadget','PERMISSIONS',4),(72,'com.liferay.opensocial.model.Gadget','UPDATE',8),(73,'com.liferay.opensocial.model.Gadget','VIEW',1),(74,'com.liferay.opensocial','PERMISSIONS',2),(75,'com.liferay.opensocial','PUBLISH_GADGET',4),(76,'3_WAR_opensocialportlet','ADD_TO_PAGE',2),(77,'3_WAR_opensocialportlet','CONFIGURATION',4),(78,'3_WAR_opensocialportlet','VIEW',1),(79,'3_WAR_opensocialportlet','PERMISSIONS',8),(80,'3_WAR_opensocialportlet','PREFERENCES',16),(81,'3_WAR_opensocialportlet','ACCESS_IN_CONTROL_PANEL',32),(82,'1_WAR_webformportlet','VIEW',1),(83,'1_WAR_webformportlet','ADD_TO_PAGE',2),(84,'1_WAR_webformportlet','CONFIGURATION',4),(85,'1_WAR_webformportlet','PERMISSIONS',8),(86,'1_WAR_webformportlet','PREFERENCES',16),(87,'1_WAR_webformportlet','ACCESS_IN_CONTROL_PANEL',32),(101,'98','ACCESS_IN_CONTROL_PANEL',2),(102,'98','ADD_TO_PAGE',4),(103,'98','CONFIGURATION',8),(104,'98','VIEW',1),(105,'98','PERMISSIONS',16),(106,'98','PREFERENCES',32),(107,'com.liferay.portlet.softwarecatalog.model.SCFrameworkVersion','DELETE',2),(108,'com.liferay.portlet.softwarecatalog.model.SCFrameworkVersion','PERMISSIONS',4),(109,'com.liferay.portlet.softwarecatalog.model.SCFrameworkVersion','UPDATE',8),(110,'com.liferay.portlet.softwarecatalog','ADD_FRAMEWORK_VERSION',2),(111,'com.liferay.portlet.softwarecatalog','ADD_PRODUCT_ENTRY',4),(112,'com.liferay.portlet.softwarecatalog','PERMISSIONS',8),(113,'com.liferay.portlet.softwarecatalog.model.SCLicense','DELETE',2),(114,'com.liferay.portlet.softwarecatalog.model.SCLicense','PERMISSIONS',4),(115,'com.liferay.portlet.softwarecatalog.model.SCLicense','UPDATE',8),(116,'com.liferay.portlet.softwarecatalog.model.SCLicense','VIEW',1),(117,'com.liferay.portlet.softwarecatalog.model.SCProductEntry','ADD_DISCUSSION',2),(118,'com.liferay.portlet.softwarecatalog.model.SCProductEntry','DELETE',4),(119,'com.liferay.portlet.softwarecatalog.model.SCProductEntry','DELETE_DISCUSSION',8),(120,'com.liferay.portlet.softwarecatalog.model.SCProductEntry','PERMISSIONS',16),(121,'com.liferay.portlet.softwarecatalog.model.SCProductEntry','UPDATE',32),(122,'com.liferay.portlet.softwarecatalog.model.SCProductEntry','UPDATE_DISCUSSION',64),(123,'com.liferay.portlet.softwarecatalog.model.SCProductEntry','VIEW',1),(124,'183','VIEW',1),(125,'183','ADD_TO_PAGE',2),(126,'183','CONFIGURATION',4),(127,'183','PERMISSIONS',8),(128,'183','PREFERENCES',16),(129,'183','ACCESS_IN_CONTROL_PANEL',32),(130,'66','VIEW',1),(131,'66','ADD_TO_PAGE',2),(132,'66','CONFIGURATION',4),(133,'66','PERMISSIONS',8),(134,'66','PREFERENCES',16),(135,'66','ACCESS_IN_CONTROL_PANEL',32),(136,'156','VIEW',1),(137,'156','ADD_TO_PAGE',2),(138,'156','CONFIGURATION',4),(139,'156','PERMISSIONS',8),(140,'156','PREFERENCES',16),(141,'156','ACCESS_IN_CONTROL_PANEL',32),(142,'com.liferay.portal.model.Layout','ADD_DISCUSSION',2),(143,'com.liferay.portal.model.Layout','ADD_LAYOUT',4),(144,'com.liferay.portal.model.Layout','CONFIGURE_PORTLETS',8),(145,'com.liferay.portal.model.Layout','CUSTOMIZE',16),(146,'com.liferay.portal.model.Layout','DELETE',32),(147,'com.liferay.portal.model.Layout','DELETE_DISCUSSION',64),(148,'com.liferay.portal.model.Layout','PERMISSIONS',128),(149,'com.liferay.portal.model.Layout','UPDATE',256),(150,'com.liferay.portal.model.Layout','UPDATE_DISCUSSION',512),(151,'com.liferay.portal.model.Layout','VIEW',1),(152,'com.liferay.portal.model.LayoutBranch','DELETE',2),(153,'com.liferay.portal.model.LayoutBranch','PERMISSIONS',4),(154,'com.liferay.portal.model.LayoutBranch','UPDATE',8),(155,'com.liferay.portal.model.LayoutSetBranch','DELETE',2),(156,'com.liferay.portal.model.LayoutSetBranch','MERGE',4),(157,'com.liferay.portal.model.LayoutSetBranch','PERMISSIONS',8),(158,'com.liferay.portal.model.LayoutSetBranch','UPDATE',16),(159,'com.liferay.portal.model.Group','ADD_COMMUNITY',2),(160,'com.liferay.portal.model.Group','ADD_LAYOUT',4),(161,'com.liferay.portal.model.Group','ADD_LAYOUT_BRANCH',8),(162,'com.liferay.portal.model.Group','ADD_LAYOUT_SET_BRANCH',16),(163,'com.liferay.portal.model.Group','ASSIGN_MEMBERS',32),(164,'com.liferay.portal.model.Group','ASSIGN_USER_ROLES',64),(165,'com.liferay.portal.model.Group','CONFIGURE_PORTLETS',128),(166,'com.liferay.portal.model.Group','DELETE',256),(167,'com.liferay.portal.model.Group','EXPORT_IMPORT_LAYOUTS',512),(168,'com.liferay.portal.model.Group','EXPORT_IMPORT_PORTLET_INFO',1024),(169,'com.liferay.portal.model.Group','MANAGE_ANNOUNCEMENTS',2048),(170,'com.liferay.portal.model.Group','MANAGE_ARCHIVED_SETUPS',4096),(171,'com.liferay.portal.model.Group','MANAGE_LAYOUTS',8192),(172,'com.liferay.portal.model.Group','MANAGE_STAGING',16384),(173,'com.liferay.portal.model.Group','MANAGE_SUBGROUPS',32768),(174,'com.liferay.portal.model.Group','MANAGE_TEAMS',65536),(175,'com.liferay.portal.model.Group','PERMISSIONS',131072),(176,'com.liferay.portal.model.Group','PREVIEW_IN_DEVICE',262144),(177,'com.liferay.portal.model.Group','PUBLISH_STAGING',524288),(178,'com.liferay.portal.model.Group','PUBLISH_TO_REMOTE',1048576),(179,'com.liferay.portal.model.Group','UPDATE',2097152),(180,'com.liferay.portal.model.Group','VIEW',1),(181,'com.liferay.portal.model.Group','VIEW_MEMBERS',4194304),(182,'com.liferay.portal.model.Group','VIEW_SITE_ADMINISTRATION',8388608),(183,'com.liferay.portal.model.Group','VIEW_STAGING',16777216),(184,'180','VIEW',1),(185,'180','ADD_TO_PAGE',2),(186,'180','CONFIGURATION',4),(187,'180','PERMISSIONS',8),(188,'180','PREFERENCES',16),(189,'180','ACCESS_IN_CONTROL_PANEL',32),(190,'152','ACCESS_IN_CONTROL_PANEL',2),(191,'152','CONFIGURATION',4),(192,'152','VIEW',1),(193,'152','PERMISSIONS',8),(194,'152','PREFERENCES',16),(195,'27','VIEW',1),(196,'27','ADD_TO_PAGE',2),(197,'27','CONFIGURATION',4),(198,'27','PERMISSIONS',8),(199,'27','PREFERENCES',16),(200,'27','ACCESS_IN_CONTROL_PANEL',32),(201,'88','VIEW',1),(202,'88','ADD_TO_PAGE',2),(203,'88','CONFIGURATION',4),(204,'88','PERMISSIONS',8),(205,'88','PREFERENCES',16),(206,'88','ACCESS_IN_CONTROL_PANEL',32),(207,'134','ACCESS_IN_CONTROL_PANEL',2),(208,'134','CONFIGURATION',4),(209,'134','VIEW',1),(210,'134','PERMISSIONS',8),(211,'134','PREFERENCES',16),(212,'130','ACCESS_IN_CONTROL_PANEL',2),(213,'130','CONFIGURATION',4),(214,'130','VIEW',1),(215,'130','PERMISSIONS',8),(216,'130','PREFERENCES',16),(217,'122','ADD_PORTLET_DISPLAY_TEMPLATE',2),(218,'122','CONFIGURATION',4),(219,'122','VIEW',1),(220,'122','ADD_TO_PAGE',8),(221,'122','PERMISSIONS',16),(222,'122','PREFERENCES',32),(223,'122','ACCESS_IN_CONTROL_PANEL',64),(224,'36','ADD_PORTLET_DISPLAY_TEMPLATE',2),(225,'36','ADD_TO_PAGE',4),(226,'36','CONFIGURATION',8),(227,'36','VIEW',1),(228,'36','PERMISSIONS',16),(229,'36','PREFERENCES',32),(230,'36','ACCESS_IN_CONTROL_PANEL',64),(231,'com.liferay.portlet.wiki.model.WikiPage','ADD_DISCUSSION',2),(232,'com.liferay.portlet.wiki.model.WikiPage','DELETE',4),(233,'com.liferay.portlet.wiki.model.WikiPage','DELETE_DISCUSSION',8),(234,'com.liferay.portlet.wiki.model.WikiPage','PERMISSIONS',16),(235,'com.liferay.portlet.wiki.model.WikiPage','SUBSCRIBE',32),(236,'com.liferay.portlet.wiki.model.WikiPage','UPDATE',64),(237,'com.liferay.portlet.wiki.model.WikiPage','UPDATE_DISCUSSION',128),(238,'com.liferay.portlet.wiki.model.WikiPage','VIEW',1),(239,'com.liferay.portlet.wiki.model.WikiNode','ADD_ATTACHMENT',2),(240,'com.liferay.portlet.wiki.model.WikiNode','ADD_PAGE',4),(241,'com.liferay.portlet.wiki.model.WikiNode','DELETE',8),(242,'com.liferay.portlet.wiki.model.WikiNode','IMPORT',16),(243,'com.liferay.portlet.wiki.model.WikiNode','PERMISSIONS',32),(244,'com.liferay.portlet.wiki.model.WikiNode','SUBSCRIBE',64),(245,'com.liferay.portlet.wiki.model.WikiNode','UPDATE',128),(246,'com.liferay.portlet.wiki.model.WikiNode','VIEW',1),(247,'com.liferay.portlet.wiki','ADD_NODE',2),(248,'com.liferay.portlet.wiki','PERMISSIONS',4),(249,'26','VIEW',1),(250,'26','ADD_TO_PAGE',2),(251,'26','CONFIGURATION',4),(252,'26','PERMISSIONS',8),(253,'26','PREFERENCES',16),(254,'26','ACCESS_IN_CONTROL_PANEL',32),(255,'190','VIEW',1),(256,'190','ADD_TO_PAGE',2),(257,'190','CONFIGURATION',4),(258,'190','PERMISSIONS',8),(259,'190','PREFERENCES',16),(260,'190','ACCESS_IN_CONTROL_PANEL',32),(261,'175','VIEW',1),(262,'175','ADD_TO_PAGE',2),(263,'175','CONFIGURATION',4),(264,'175','PERMISSIONS',8),(265,'175','PREFERENCES',16),(266,'175','ACCESS_IN_CONTROL_PANEL',32),(267,'64','VIEW',1),(268,'64','ADD_TO_PAGE',2),(269,'64','CONFIGURATION',4),(270,'64','PERMISSIONS',8),(271,'64','PREFERENCES',16),(272,'64','ACCESS_IN_CONTROL_PANEL',32),(273,'153','ACCESS_IN_CONTROL_PANEL',2),(274,'153','ADD_TO_PAGE',4),(275,'153','CONFIGURATION',8),(276,'153','VIEW',1),(277,'153','PERMISSIONS',16),(278,'153','PREFERENCES',32),(279,'182','VIEW',1),(280,'182','ADD_TO_PAGE',2),(281,'182','CONFIGURATION',4),(282,'182','PERMISSIONS',8),(283,'182','PREFERENCES',16),(284,'182','ACCESS_IN_CONTROL_PANEL',32),(285,'129','ACCESS_IN_CONTROL_PANEL',2),(286,'129','CONFIGURATION',4),(287,'129','VIEW',1),(288,'129','PERMISSIONS',8),(289,'129','PREFERENCES',16),(290,'com.liferay.portal.model.PasswordPolicy','ASSIGN_MEMBERS',2),(291,'com.liferay.portal.model.PasswordPolicy','DELETE',4),(292,'com.liferay.portal.model.PasswordPolicy','PERMISSIONS',8),(293,'com.liferay.portal.model.PasswordPolicy','UPDATE',16),(294,'com.liferay.portal.model.PasswordPolicy','VIEW',1),(295,'179','ACCESS_IN_CONTROL_PANEL',2),(296,'179','CONFIGURATION',4),(297,'179','VIEW',1),(298,'179','PERMISSIONS',8),(299,'179','PREFERENCES',16),(300,'173','VIEW',1),(301,'173','ADD_TO_PAGE',2),(302,'173','CONFIGURATION',4),(303,'173','PERMISSIONS',8),(304,'173','PREFERENCES',16),(305,'173','ACCESS_IN_CONTROL_PANEL',32),(306,'100','VIEW',1),(307,'100','ADD_TO_PAGE',2),(308,'100','CONFIGURATION',4),(309,'100','PERMISSIONS',8),(310,'100','PREFERENCES',16),(311,'100','ACCESS_IN_CONTROL_PANEL',32),(312,'157','ACCESS_IN_CONTROL_PANEL',2),(313,'157','CONFIGURATION',4),(314,'157','VIEW',1),(315,'157','PERMISSIONS',8),(316,'157','PREFERENCES',16),(317,'19','ADD_TO_PAGE',2),(318,'19','CONFIGURATION',4),(319,'19','VIEW',1),(320,'19','PERMISSIONS',8),(321,'19','PREFERENCES',16),(322,'19','ACCESS_IN_CONTROL_PANEL',32),(323,'com.liferay.portlet.messageboards.model.MBCategory','ADD_FILE',2),(324,'com.liferay.portlet.messageboards.model.MBCategory','ADD_MESSAGE',4),(325,'com.liferay.portlet.messageboards.model.MBCategory','ADD_SUBCATEGORY',8),(326,'com.liferay.portlet.messageboards.model.MBCategory','DELETE',16),(327,'com.liferay.portlet.messageboards.model.MBCategory','LOCK_THREAD',32),(328,'com.liferay.portlet.messageboards.model.MBCategory','MOVE_THREAD',64),(329,'com.liferay.portlet.messageboards.model.MBCategory','PERMISSIONS',128),(330,'com.liferay.portlet.messageboards.model.MBCategory','REPLY_TO_MESSAGE',256),(331,'com.liferay.portlet.messageboards.model.MBCategory','SUBSCRIBE',512),(332,'com.liferay.portlet.messageboards.model.MBCategory','UPDATE',1024),(333,'com.liferay.portlet.messageboards.model.MBCategory','UPDATE_THREAD_PRIORITY',2048),(334,'com.liferay.portlet.messageboards.model.MBCategory','VIEW',1),(335,'com.liferay.portlet.messageboards','ADD_CATEGORY',2),(336,'com.liferay.portlet.messageboards','ADD_FILE',4),(337,'com.liferay.portlet.messageboards','ADD_MESSAGE',8),(338,'com.liferay.portlet.messageboards','BAN_USER',16),(339,'com.liferay.portlet.messageboards','MOVE_THREAD',32),(340,'com.liferay.portlet.messageboards','LOCK_THREAD',64),(341,'com.liferay.portlet.messageboards','PERMISSIONS',128),(342,'com.liferay.portlet.messageboards','REPLY_TO_MESSAGE',256),(343,'com.liferay.portlet.messageboards','SUBSCRIBE',512),(344,'com.liferay.portlet.messageboards','UPDATE_THREAD_PRIORITY',1024),(345,'com.liferay.portlet.messageboards','VIEW',1),(346,'com.liferay.portlet.messageboards.model.MBThread','SUBSCRIBE',2),(347,'com.liferay.portlet.messageboards.model.MBThread','VIEW',1),(348,'com.liferay.portlet.messageboards.model.MBThread','PERMISSIONS',4),(349,'com.liferay.portlet.messageboards.model.MBMessage','DELETE',2),(350,'com.liferay.portlet.messageboards.model.MBMessage','PERMISSIONS',4),(351,'com.liferay.portlet.messageboards.model.MBMessage','SUBSCRIBE',8),(352,'com.liferay.portlet.messageboards.model.MBMessage','UPDATE',16),(353,'com.liferay.portlet.messageboards.model.MBMessage','VIEW',1),(354,'160','VIEW',1),(355,'160','ADD_TO_PAGE',2),(356,'160','CONFIGURATION',4),(357,'160','PERMISSIONS',8),(358,'160','PREFERENCES',16),(359,'160','ACCESS_IN_CONTROL_PANEL',32),(360,'181','VIEW',1),(361,'181','ADD_TO_PAGE',2),(362,'181','CONFIGURATION',4),(363,'181','PERMISSIONS',8),(364,'181','PREFERENCES',16),(365,'181','ACCESS_IN_CONTROL_PANEL',32),(366,'128','ACCESS_IN_CONTROL_PANEL',2),(367,'128','CONFIGURATION',4),(368,'128','VIEW',1),(369,'128','PERMISSIONS',8),(370,'128','PREFERENCES',16),(371,'com.liferay.portal.model.Role','ASSIGN_MEMBERS',2),(372,'com.liferay.portal.model.Role','DEFINE_PERMISSIONS',4),(373,'com.liferay.portal.model.Role','DELETE',8),(374,'com.liferay.portal.model.Role','MANAGE_ANNOUNCEMENTS',16),(375,'com.liferay.portal.model.Role','PERMISSIONS',32),(376,'com.liferay.portal.model.Role','UPDATE',64),(377,'com.liferay.portal.model.Role','VIEW',1),(378,'86','VIEW',1),(379,'86','ADD_TO_PAGE',2),(380,'86','CONFIGURATION',4),(381,'86','PERMISSIONS',8),(382,'86','PREFERENCES',16),(383,'86','ACCESS_IN_CONTROL_PANEL',32),(384,'154','ACCESS_IN_CONTROL_PANEL',2),(385,'154','CONFIGURATION',4),(386,'154','VIEW',1),(387,'154','PERMISSIONS',8),(388,'154','PREFERENCES',16),(389,'148','VIEW',1),(390,'148','ADD_TO_PAGE',2),(391,'148','CONFIGURATION',4),(392,'148','PERMISSIONS',8),(393,'148','PREFERENCES',16),(394,'148','ACCESS_IN_CONTROL_PANEL',32),(395,'11','ADD_TO_PAGE',2),(396,'11','CONFIGURATION',4),(397,'11','VIEW',1),(398,'11','PERMISSIONS',8),(399,'11','PREFERENCES',16),(400,'11','ACCESS_IN_CONTROL_PANEL',32),(401,'29','ADD_TO_PAGE',2),(402,'29','CONFIGURATION',4),(403,'29','VIEW',1),(404,'29','PERMISSIONS',8),(405,'29','PREFERENCES',16),(406,'29','ACCESS_IN_CONTROL_PANEL',32),(407,'174','VIEW',1),(408,'174','ADD_TO_PAGE',2),(409,'174','CONFIGURATION',4),(410,'174','PERMISSIONS',8),(411,'174','PREFERENCES',16),(412,'174','ACCESS_IN_CONTROL_PANEL',32),(413,'com.liferay.portal.model.Team','ASSIGN_MEMBERS',2),(414,'com.liferay.portal.model.Team','DELETE',4),(415,'com.liferay.portal.model.Team','PERMISSIONS',8),(416,'com.liferay.portal.model.Team','UPDATE',16),(417,'com.liferay.portal.model.Team','VIEW',1),(418,'158','ACCESS_IN_CONTROL_PANEL',2),(419,'158','ADD_TO_PAGE',4),(420,'158','CONFIGURATION',8),(421,'158','VIEW',1),(422,'158','PERMISSIONS',16),(423,'158','PREFERENCES',32),(424,'178','CONFIGURATION',2),(425,'178','VIEW',1),(426,'178','ADD_TO_PAGE',4),(427,'178','PERMISSIONS',8),(428,'178','PREFERENCES',16),(429,'178','ACCESS_IN_CONTROL_PANEL',32),(430,'com.liferay.portlet.mobiledevicerules','ADD_RULE_GROUP',2),(431,'com.liferay.portlet.mobiledevicerules','ADD_RULE_GROUP_INSTANCE',4),(432,'com.liferay.portlet.mobiledevicerules','CONFIGURATION',8),(433,'com.liferay.portlet.mobiledevicerules','VIEW',1),(434,'com.liferay.portlet.mobiledevicerules','PERMISSIONS',16),(435,'com.liferay.portlet.mobiledevicerules.model.MDRRuleGroup','DELETE',2),(436,'com.liferay.portlet.mobiledevicerules.model.MDRRuleGroup','PERMISSIONS',4),(437,'com.liferay.portlet.mobiledevicerules.model.MDRRuleGroup','UPDATE',8),(438,'com.liferay.portlet.mobiledevicerules.model.MDRRuleGroup','VIEW',1),(439,'com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance','DELETE',2),(440,'com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance','PERMISSIONS',4),(441,'com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance','UPDATE',8),(442,'com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance','VIEW',1),(443,'124','VIEW',1),(444,'124','ADD_TO_PAGE',2),(445,'124','CONFIGURATION',4),(446,'124','PERMISSIONS',8),(447,'124','PREFERENCES',16),(448,'124','ACCESS_IN_CONTROL_PANEL',32),(449,'58','ADD_TO_PAGE',2),(450,'58','CONFIGURATION',4),(451,'58','VIEW',1),(452,'58','PERMISSIONS',8),(453,'58','PREFERENCES',16),(454,'58','ACCESS_IN_CONTROL_PANEL',32),(455,'97','VIEW',1),(456,'97','ADD_TO_PAGE',2),(457,'97','CONFIGURATION',4),(458,'97','PERMISSIONS',8),(459,'97','PREFERENCES',16),(460,'97','ACCESS_IN_CONTROL_PANEL',32),(461,'71','ADD_TO_PAGE',2),(462,'71','CONFIGURATION',4),(463,'71','VIEW',1),(464,'71','PERMISSIONS',8),(465,'71','PREFERENCES',16),(466,'71','ACCESS_IN_CONTROL_PANEL',32),(467,'39','VIEW',1),(468,'39','ADD_TO_PAGE',2),(469,'39','CONFIGURATION',4),(470,'39','PERMISSIONS',8),(471,'39','PREFERENCES',16),(472,'39','ACCESS_IN_CONTROL_PANEL',32),(473,'185','VIEW',1),(474,'185','ADD_TO_PAGE',2),(475,'185','CONFIGURATION',4),(476,'185','PERMISSIONS',8),(477,'185','PREFERENCES',16),(478,'185','ACCESS_IN_CONTROL_PANEL',32),(479,'170','VIEW',1),(480,'170','ADD_TO_PAGE',2),(481,'170','CONFIGURATION',4),(482,'170','PERMISSIONS',8),(483,'170','PREFERENCES',16),(484,'170','ACCESS_IN_CONTROL_PANEL',32),(485,'85','ADD_TO_PAGE',2),(486,'85','CONFIGURATION',4),(487,'85','VIEW',1),(488,'85','PERMISSIONS',8),(489,'85','PREFERENCES',16),(490,'85','ADD_PORTLET_DISPLAY_TEMPLATE',32),(491,'85','ACCESS_IN_CONTROL_PANEL',64),(492,'118','VIEW',1),(493,'118','ADD_TO_PAGE',2),(494,'118','CONFIGURATION',4),(495,'118','PERMISSIONS',8),(496,'118','PREFERENCES',16),(497,'118','ACCESS_IN_CONTROL_PANEL',32),(498,'107','VIEW',1),(499,'107','ADD_TO_PAGE',2),(500,'107','CONFIGURATION',4),(501,'107','PERMISSIONS',8),(502,'107','PREFERENCES',16),(503,'107','ACCESS_IN_CONTROL_PANEL',32),(504,'30','VIEW',1),(505,'30','ADD_TO_PAGE',2),(506,'30','CONFIGURATION',4),(507,'30','PERMISSIONS',8),(508,'30','PREFERENCES',16),(509,'30','ACCESS_IN_CONTROL_PANEL',32),(510,'184','ADD_TO_PAGE',2),(511,'184','CONFIGURATION',4),(512,'184','VIEW',1),(513,'184','PERMISSIONS',8),(514,'184','PREFERENCES',16),(515,'184','ACCESS_IN_CONTROL_PANEL',32),(516,'147','ACCESS_IN_CONTROL_PANEL',2),(517,'147','CONFIGURATION',4),(518,'147','VIEW',1),(519,'147','PERMISSIONS',8),(520,'147','PREFERENCES',16),(521,'com.liferay.portlet.asset','ADD_TAG',2),(522,'com.liferay.portlet.asset','PERMISSIONS',4),(523,'com.liferay.portlet.asset','ADD_CATEGORY',8),(524,'com.liferay.portlet.asset','ADD_VOCABULARY',16),(525,'com.liferay.portlet.asset.model.AssetCategory','ADD_CATEGORY',2),(526,'com.liferay.portlet.asset.model.AssetCategory','DELETE',4),(527,'com.liferay.portlet.asset.model.AssetCategory','PERMISSIONS',8),(528,'com.liferay.portlet.asset.model.AssetCategory','UPDATE',16),(529,'com.liferay.portlet.asset.model.AssetCategory','VIEW',1),(530,'com.liferay.portlet.asset.model.AssetVocabulary','DELETE',2),(531,'com.liferay.portlet.asset.model.AssetVocabulary','PERMISSIONS',4),(532,'com.liferay.portlet.asset.model.AssetVocabulary','UPDATE',8),(533,'com.liferay.portlet.asset.model.AssetVocabulary','VIEW',1),(534,'48','VIEW',1),(535,'48','ADD_TO_PAGE',2),(536,'48','CONFIGURATION',4),(537,'48','PERMISSIONS',8),(538,'48','PREFERENCES',16),(539,'48','ACCESS_IN_CONTROL_PANEL',32),(540,'125','ACCESS_IN_CONTROL_PANEL',2),(541,'125','CONFIGURATION',4),(542,'125','EXPORT_USER',8),(543,'125','VIEW',1),(544,'125','PERMISSIONS',16),(545,'125','PREFERENCES',32),(546,'com.liferay.portal.model.User','DELETE',2),(547,'com.liferay.portal.model.User','IMPERSONATE',4),(548,'com.liferay.portal.model.User','PERMISSIONS',8),(549,'com.liferay.portal.model.User','UPDATE',16),(550,'com.liferay.portal.model.User','VIEW',1),(551,'com.liferay.portal.model.Organization','ADD_ORGANIZATION',2),(552,'com.liferay.portal.model.Organization','ASSIGN_MEMBERS',4),(553,'com.liferay.portal.model.Organization','ASSIGN_USER_ROLES',8),(554,'com.liferay.portal.model.Organization','DELETE',16),(555,'com.liferay.portal.model.Organization','MANAGE_ANNOUNCEMENTS',32),(556,'com.liferay.portal.model.Organization','MANAGE_SUBORGANIZATIONS',64),(557,'com.liferay.portal.model.Organization','MANAGE_USERS',128),(558,'com.liferay.portal.model.Organization','PERMISSIONS',256),(559,'com.liferay.portal.model.Organization','UPDATE',512),(560,'com.liferay.portal.model.Organization','VIEW',1),(561,'com.liferay.portal.model.Organization','VIEW_MEMBERS',1024),(562,'161','ACCESS_IN_CONTROL_PANEL',2),(563,'161','CONFIGURATION',4),(564,'161','VIEW',1),(565,'161','PERMISSIONS',8),(566,'161','PREFERENCES',16),(567,'com.liferay.portlet.blogs','ADD_ENTRY',2),(568,'com.liferay.portlet.blogs','PERMISSIONS',4),(569,'com.liferay.portlet.blogs','SUBSCRIBE',8),(570,'com.liferay.portlet.blogs.model.BlogsEntry','ADD_DISCUSSION',2),(571,'com.liferay.portlet.blogs.model.BlogsEntry','DELETE',4),(572,'com.liferay.portlet.blogs.model.BlogsEntry','DELETE_DISCUSSION',8),(573,'com.liferay.portlet.blogs.model.BlogsEntry','PERMISSIONS',16),(574,'com.liferay.portlet.blogs.model.BlogsEntry','UPDATE',32),(575,'com.liferay.portlet.blogs.model.BlogsEntry','UPDATE_DISCUSSION',64),(576,'com.liferay.portlet.blogs.model.BlogsEntry','VIEW',1),(577,'146','ACCESS_IN_CONTROL_PANEL',2),(578,'146','CONFIGURATION',4),(579,'146','VIEW',1),(580,'146','PERMISSIONS',8),(581,'146','PREFERENCES',16),(582,'com.liferay.portal.model.LayoutPrototype','DELETE',2),(583,'com.liferay.portal.model.LayoutPrototype','PERMISSIONS',4),(584,'com.liferay.portal.model.LayoutPrototype','UPDATE',8),(585,'com.liferay.portal.model.LayoutPrototype','VIEW',1),(586,'62','VIEW',1),(587,'62','ADD_TO_PAGE',2),(588,'62','CONFIGURATION',4),(589,'62','PERMISSIONS',8),(590,'62','PREFERENCES',16),(591,'62','ACCESS_IN_CONTROL_PANEL',32),(592,'162','ACCESS_IN_CONTROL_PANEL',2),(593,'162','CONFIGURATION',4),(594,'162','VIEW',1),(595,'162','PERMISSIONS',8),(596,'162','PREFERENCES',16),(597,'176','VIEW',1),(598,'176','ADD_TO_PAGE',2),(599,'176','CONFIGURATION',4),(600,'176','PERMISSIONS',8),(601,'176','PREFERENCES',16),(602,'176','ACCESS_IN_CONTROL_PANEL',32),(603,'172','VIEW',1),(604,'172','ADD_TO_PAGE',2),(605,'172','CONFIGURATION',4),(606,'172','PERMISSIONS',8),(607,'172','PREFERENCES',16),(608,'172','ACCESS_IN_CONTROL_PANEL',32),(609,'187','ADD_TO_PAGE',2),(610,'187','CONFIGURATION',4),(611,'187','VIEW',1),(612,'187','PERMISSIONS',8),(613,'187','PREFERENCES',16),(614,'187','ACCESS_IN_CONTROL_PANEL',32),(615,'108','VIEW',1),(616,'108','ADD_TO_PAGE',2),(617,'108','CONFIGURATION',4),(618,'108','PERMISSIONS',8),(619,'108','PREFERENCES',16),(620,'108','ACCESS_IN_CONTROL_PANEL',32),(621,'139','ACCESS_IN_CONTROL_PANEL',2),(622,'139','ADD_EXPANDO',4),(623,'139','CONFIGURATION',8),(624,'139','VIEW',1),(625,'139','PERMISSIONS',16),(626,'139','PREFERENCES',32),(627,'com.liferay.portlet.expando.model.ExpandoColumn','DELETE',2),(628,'com.liferay.portlet.expando.model.ExpandoColumn','PERMISSIONS',4),(629,'com.liferay.portlet.expando.model.ExpandoColumn','UPDATE',8),(630,'com.liferay.portlet.expando.model.ExpandoColumn','VIEW',1),(631,'84','ADD_ENTRY',2),(632,'84','ADD_TO_PAGE',4),(633,'84','CONFIGURATION',8),(634,'84','VIEW',1),(635,'84','PERMISSIONS',16),(636,'84','PREFERENCES',32),(637,'84','ACCESS_IN_CONTROL_PANEL',64),(638,'com.liferay.portlet.announcements.model.AnnouncementsEntry','DELETE',2),(639,'com.liferay.portlet.announcements.model.AnnouncementsEntry','UPDATE',4),(640,'com.liferay.portlet.announcements.model.AnnouncementsEntry','VIEW',1),(641,'com.liferay.portlet.announcements.model.AnnouncementsEntry','PERMISSIONS',8),(642,'101','ADD_PORTLET_DISPLAY_TEMPLATE',2),(643,'101','ADD_TO_PAGE',4),(644,'101','CONFIGURATION',8),(645,'101','SUBSCRIBE',16),(646,'101','VIEW',1),(647,'101','PERMISSIONS',32),(648,'101','PREFERENCES',64),(649,'101','ACCESS_IN_CONTROL_PANEL',128),(650,'121','VIEW',1),(651,'121','ADD_TO_PAGE',2),(652,'121','CONFIGURATION',4),(653,'121','PERMISSIONS',8),(654,'121','PREFERENCES',16),(655,'121','ACCESS_IN_CONTROL_PANEL',32),(656,'49','VIEW',1),(657,'49','ADD_TO_PAGE',2),(658,'49','CONFIGURATION',4),(659,'49','PERMISSIONS',8),(660,'49','PREFERENCES',16),(661,'49','ACCESS_IN_CONTROL_PANEL',32),(662,'143','VIEW',1),(663,'143','ADD_TO_PAGE',2),(664,'143','CONFIGURATION',4),(665,'143','PERMISSIONS',8),(666,'143','PREFERENCES',16),(667,'143','ACCESS_IN_CONTROL_PANEL',32),(668,'167','ACCESS_IN_CONTROL_PANEL',2),(669,'167','ADD_TO_PAGE',4),(670,'167','CONFIGURATION',8),(671,'167','VIEW',1),(672,'167','PERMISSIONS',16),(673,'167','PREFERENCES',32),(674,'com.liferay.portlet.dynamicdatalists','ADD_RECORD_SET',2),(675,'com.liferay.portlet.dynamicdatalists','ADD_STRUCTURE',4),(676,'com.liferay.portlet.dynamicdatalists','ADD_TEMPLATE',8),(677,'com.liferay.portlet.dynamicdatalists','PERMISSIONS',16),(678,'com.liferay.portlet.dynamicdatalists.model.DDLRecordSet','ADD_RECORD',2),(679,'com.liferay.portlet.dynamicdatalists.model.DDLRecordSet','DELETE',4),(680,'com.liferay.portlet.dynamicdatalists.model.DDLRecordSet','PERMISSIONS',8),(681,'com.liferay.portlet.dynamicdatalists.model.DDLRecordSet','UPDATE',16),(682,'com.liferay.portlet.dynamicdatalists.model.DDLRecordSet','VIEW',1),(683,'77','VIEW',1),(684,'77','ADD_TO_PAGE',2),(685,'77','CONFIGURATION',4),(686,'77','PERMISSIONS',8),(687,'77','PREFERENCES',16),(688,'77','ACCESS_IN_CONTROL_PANEL',32),(689,'115','VIEW',1),(690,'115','ADD_TO_PAGE',2),(691,'115','CONFIGURATION',4),(692,'115','PERMISSIONS',8),(693,'115','PREFERENCES',16),(694,'115','ACCESS_IN_CONTROL_PANEL',32),(695,'56','ADD_TO_PAGE',2),(696,'56','CONFIGURATION',4),(697,'56','VIEW',1),(698,'56','PERMISSIONS',8),(699,'56','PREFERENCES',16),(700,'56','ACCESS_IN_CONTROL_PANEL',32),(701,'142','VIEW',1),(702,'142','ADD_TO_PAGE',2),(703,'142','CONFIGURATION',4),(704,'142','PERMISSIONS',8),(705,'142','PREFERENCES',16),(706,'142','ACCESS_IN_CONTROL_PANEL',32),(707,'16','PREFERENCES',2),(708,'16','GUEST_PREFERENCES',4),(709,'16','VIEW',1),(710,'16','ADD_TO_PAGE',8),(711,'16','CONFIGURATION',16),(712,'16','PERMISSIONS',32),(713,'16','ACCESS_IN_CONTROL_PANEL',64),(714,'3','VIEW',1),(715,'3','ADD_TO_PAGE',2),(716,'3','CONFIGURATION',4),(717,'3','PERMISSIONS',8),(718,'3','PREFERENCES',16),(719,'3','ACCESS_IN_CONTROL_PANEL',32),(720,'23','VIEW',1),(721,'23','ADD_TO_PAGE',2),(722,'23','CONFIGURATION',4),(723,'23','PERMISSIONS',8),(724,'23','PREFERENCES',16),(725,'23','ACCESS_IN_CONTROL_PANEL',32),(726,'20','ACCESS_IN_CONTROL_PANEL',2),(727,'20','ADD_PORTLET_DISPLAY_TEMPLATE',4),(728,'20','ADD_TO_PAGE',8),(729,'20','CONFIGURATION',16),(730,'20','VIEW',1),(731,'20','PERMISSIONS',32),(732,'20','PREFERENCES',64),(733,'com.liferay.portlet.documentlibrary.model.DLFolder','ACCESS',2),(734,'com.liferay.portlet.documentlibrary.model.DLFolder','ADD_DOCUMENT',4),(735,'com.liferay.portlet.documentlibrary.model.DLFolder','ADD_SHORTCUT',8),(736,'com.liferay.portlet.documentlibrary.model.DLFolder','ADD_SUBFOLDER',16),(737,'com.liferay.portlet.documentlibrary.model.DLFolder','DELETE',32),(738,'com.liferay.portlet.documentlibrary.model.DLFolder','PERMISSIONS',64),(739,'com.liferay.portlet.documentlibrary.model.DLFolder','UPDATE',128),(740,'com.liferay.portlet.documentlibrary.model.DLFolder','VIEW',1),(741,'com.liferay.portlet.documentlibrary','ADD_DOCUMENT',2),(742,'com.liferay.portlet.documentlibrary','ADD_DOCUMENT_TYPE',4),(743,'com.liferay.portlet.documentlibrary','ADD_FOLDER',8),(744,'com.liferay.portlet.documentlibrary','ADD_REPOSITORY',16),(745,'com.liferay.portlet.documentlibrary','ADD_STRUCTURE',32),(746,'com.liferay.portlet.documentlibrary','ADD_SHORTCUT',64),(747,'com.liferay.portlet.documentlibrary','PERMISSIONS',128),(748,'com.liferay.portlet.documentlibrary','SUBSCRIBE',256),(749,'com.liferay.portlet.documentlibrary','UPDATE',512),(750,'com.liferay.portlet.documentlibrary','VIEW',1),(751,'com.liferay.portlet.documentlibrary.model.DLFileEntry','ADD_DISCUSSION',2),(752,'com.liferay.portlet.documentlibrary.model.DLFileEntry','DELETE',4),(753,'com.liferay.portlet.documentlibrary.model.DLFileEntry','DELETE_DISCUSSION',8),(754,'com.liferay.portlet.documentlibrary.model.DLFileEntry','OVERRIDE_CHECKOUT',16),(755,'com.liferay.portlet.documentlibrary.model.DLFileEntry','PERMISSIONS',32),(756,'com.liferay.portlet.documentlibrary.model.DLFileEntry','UPDATE',64),(757,'com.liferay.portlet.documentlibrary.model.DLFileEntry','UPDATE_DISCUSSION',128),(758,'com.liferay.portlet.documentlibrary.model.DLFileEntry','VIEW',1),(759,'com.liferay.portlet.documentlibrary.model.DLFileShortcut','DELETE',2),(760,'com.liferay.portlet.documentlibrary.model.DLFileShortcut','PERMISSIONS',4),(761,'com.liferay.portlet.documentlibrary.model.DLFileShortcut','UPDATE',8),(762,'com.liferay.portlet.documentlibrary.model.DLFileShortcut','VIEW',1),(763,'com.liferay.portlet.documentlibrary.model.DLFileEntryType','DELETE',2),(764,'com.liferay.portlet.documentlibrary.model.DLFileEntryType','PERMISSIONS',4),(765,'com.liferay.portlet.documentlibrary.model.DLFileEntryType','UPDATE',8),(766,'com.liferay.portlet.documentlibrary.model.DLFileEntryType','VIEW',1),(767,'145','VIEW',1),(768,'145','ADD_TO_PAGE',2),(769,'145','CONFIGURATION',4),(770,'145','PERMISSIONS',8),(771,'145','PREFERENCES',16),(772,'145','ACCESS_IN_CONTROL_PANEL',32),(773,'83','ADD_ENTRY',2),(774,'83','ADD_TO_PAGE',4),(775,'83','CONFIGURATION',8),(776,'83','VIEW',1),(777,'83','PERMISSIONS',16),(778,'83','PREFERENCES',32),(779,'83','ACCESS_IN_CONTROL_PANEL',64),(780,'194','VIEW',1),(781,'194','ADD_TO_PAGE',2),(782,'194','CONFIGURATION',4),(783,'194','PERMISSIONS',8),(784,'194','PREFERENCES',16),(785,'194','ACCESS_IN_CONTROL_PANEL',32),(786,'186','ADD_TO_PAGE',2),(787,'186','CONFIGURATION',4),(788,'186','VIEW',1),(789,'186','PERMISSIONS',8),(790,'186','PREFERENCES',16),(791,'186','ACCESS_IN_CONTROL_PANEL',32),(792,'164','VIEW',1),(793,'164','ADD_TO_PAGE',2),(794,'164','CONFIGURATION',4),(795,'164','PERMISSIONS',8),(796,'164','PREFERENCES',16),(797,'164','ACCESS_IN_CONTROL_PANEL',32),(798,'99','ACCESS_IN_CONTROL_PANEL',2),(799,'99','CONFIGURATION',4),(800,'99','VIEW',1),(801,'99','PERMISSIONS',8),(802,'99','PREFERENCES',16),(803,'com.liferay.portlet.asset.model.AssetTag','DELETE',2),(804,'com.liferay.portlet.asset.model.AssetTag','PERMISSIONS',4),(805,'com.liferay.portlet.asset.model.AssetTag','UPDATE',8),(806,'com.liferay.portlet.asset.model.AssetTag','VIEW',1),(807,'70','VIEW',1),(808,'70','ADD_TO_PAGE',2),(809,'70','CONFIGURATION',4),(810,'70','PERMISSIONS',8),(811,'70','PREFERENCES',16),(812,'70','ACCESS_IN_CONTROL_PANEL',32),(813,'141','ADD_PORTLET_DISPLAY_TEMPLATE',2),(814,'141','CONFIGURATION',4),(815,'141','VIEW',1),(816,'141','ADD_TO_PAGE',8),(817,'141','PERMISSIONS',16),(818,'141','PREFERENCES',32),(819,'141','ACCESS_IN_CONTROL_PANEL',64),(820,'9','VIEW',1),(821,'9','ADD_TO_PAGE',2),(822,'9','CONFIGURATION',4),(823,'9','PERMISSIONS',8),(824,'9','PREFERENCES',16),(825,'9','ACCESS_IN_CONTROL_PANEL',32),(826,'137','ACCESS_IN_CONTROL_PANEL',2),(827,'137','CONFIGURATION',4),(828,'137','VIEW',1),(829,'137','PERMISSIONS',8),(830,'137','PREFERENCES',16),(831,'28','ACCESS_IN_CONTROL_PANEL',2),(832,'28','ADD_TO_PAGE',4),(833,'28','CONFIGURATION',8),(834,'28','VIEW',1),(835,'28','PERMISSIONS',16),(836,'28','PREFERENCES',32),(837,'com.liferay.portlet.bookmarks.model.BookmarksFolder','ACCESS',2),(838,'com.liferay.portlet.bookmarks.model.BookmarksFolder','ADD_ENTRY',4),(839,'com.liferay.portlet.bookmarks.model.BookmarksFolder','ADD_SUBFOLDER',8),(840,'com.liferay.portlet.bookmarks.model.BookmarksFolder','DELETE',16),(841,'com.liferay.portlet.bookmarks.model.BookmarksFolder','PERMISSIONS',32),(842,'com.liferay.portlet.bookmarks.model.BookmarksFolder','SUBSCRIBE',64),(843,'com.liferay.portlet.bookmarks.model.BookmarksFolder','UPDATE',128),(844,'com.liferay.portlet.bookmarks.model.BookmarksFolder','VIEW',1),(845,'com.liferay.portlet.bookmarks','ADD_ENTRY',2),(846,'com.liferay.portlet.bookmarks','ADD_FOLDER',4),(847,'com.liferay.portlet.bookmarks','PERMISSIONS',8),(848,'com.liferay.portlet.bookmarks','SUBSCRIBE',16),(849,'com.liferay.portlet.bookmarks','VIEW',1),(850,'com.liferay.portlet.bookmarks.model.BookmarksEntry','DELETE',2),(851,'com.liferay.portlet.bookmarks.model.BookmarksEntry','PERMISSIONS',4),(852,'com.liferay.portlet.bookmarks.model.BookmarksEntry','SUBSCRIBE',8),(853,'com.liferay.portlet.bookmarks.model.BookmarksEntry','UPDATE',16),(854,'com.liferay.portlet.bookmarks.model.BookmarksEntry','VIEW',1),(855,'133','VIEW',1),(856,'133','ADD_TO_PAGE',2),(857,'133','CONFIGURATION',4),(858,'133','PERMISSIONS',8),(859,'133','PREFERENCES',16),(860,'133','ACCESS_IN_CONTROL_PANEL',32),(861,'116','VIEW',1),(862,'116','ADD_TO_PAGE',2),(863,'116','CONFIGURATION',4),(864,'116','PERMISSIONS',8),(865,'116','PREFERENCES',16),(866,'116','ACCESS_IN_CONTROL_PANEL',32),(867,'47','VIEW',1),(868,'47','ADD_TO_PAGE',2),(869,'47','CONFIGURATION',4),(870,'47','PERMISSIONS',8),(871,'47','PREFERENCES',16),(872,'47','ACCESS_IN_CONTROL_PANEL',32),(873,'15','ACCESS_IN_CONTROL_PANEL',2),(874,'15','ADD_TO_PAGE',4),(875,'15','CONFIGURATION',8),(876,'15','VIEW',1),(877,'15','PERMISSIONS',16),(878,'15','PREFERENCES',32),(879,'com.liferay.portlet.journal.model.JournalFeed','DELETE',2),(880,'com.liferay.portlet.journal.model.JournalFeed','PERMISSIONS',4),(881,'com.liferay.portlet.journal.model.JournalFeed','UPDATE',8),(882,'com.liferay.portlet.journal.model.JournalFeed','VIEW',1),(883,'com.liferay.portlet.journal.model.JournalArticle','ADD_DISCUSSION',2),(884,'com.liferay.portlet.journal.model.JournalArticle','DELETE',4),(885,'com.liferay.portlet.journal.model.JournalArticle','DELETE_DISCUSSION',8),(886,'com.liferay.portlet.journal.model.JournalArticle','EXPIRE',16),(887,'com.liferay.portlet.journal.model.JournalArticle','PERMISSIONS',32),(888,'com.liferay.portlet.journal.model.JournalArticle','UPDATE',64),(889,'com.liferay.portlet.journal.model.JournalArticle','UPDATE_DISCUSSION',128),(890,'com.liferay.portlet.journal.model.JournalArticle','VIEW',1),(891,'com.liferay.portlet.journal','ADD_ARTICLE',2),(892,'com.liferay.portlet.journal','ADD_FEED',4),(893,'com.liferay.portlet.journal','ADD_FOLDER',8),(894,'com.liferay.portlet.journal','ADD_STRUCTURE',16),(895,'com.liferay.portlet.journal','ADD_TEMPLATE',32),(896,'com.liferay.portlet.journal','SUBSCRIBE',64),(897,'com.liferay.portlet.journal','VIEW',1),(898,'com.liferay.portlet.journal','PERMISSIONS',128),(899,'com.liferay.portlet.journal.model.JournalStructure','DELETE',2),(900,'com.liferay.portlet.journal.model.JournalStructure','PERMISSIONS',4),(901,'com.liferay.portlet.journal.model.JournalStructure','UPDATE',8),(902,'com.liferay.portlet.journal.model.JournalStructure','VIEW',1),(903,'com.liferay.portlet.journal.model.JournalFolder','ACCESS',2),(904,'com.liferay.portlet.journal.model.JournalFolder','ADD_ARTICLE',4),(905,'com.liferay.portlet.journal.model.JournalFolder','ADD_SUBFOLDER',8),(906,'com.liferay.portlet.journal.model.JournalFolder','DELETE',16),(907,'com.liferay.portlet.journal.model.JournalFolder','PERMISSIONS',32),(908,'com.liferay.portlet.journal.model.JournalFolder','UPDATE',64),(909,'com.liferay.portlet.journal.model.JournalFolder','VIEW',1),(910,'com.liferay.portlet.journal.model.JournalTemplate','DELETE',2),(911,'com.liferay.portlet.journal.model.JournalTemplate','PERMISSIONS',4),(912,'com.liferay.portlet.journal.model.JournalTemplate','UPDATE',8),(913,'com.liferay.portlet.journal.model.JournalTemplate','VIEW',1),(914,'82','VIEW',1),(915,'82','ADD_TO_PAGE',2),(916,'82','CONFIGURATION',4),(917,'82','PERMISSIONS',8),(918,'82','PREFERENCES',16),(919,'82','ACCESS_IN_CONTROL_PANEL',32),(920,'103','VIEW',1),(921,'103','ADD_TO_PAGE',2),(922,'103','CONFIGURATION',4),(923,'103','PERMISSIONS',8),(924,'103','PREFERENCES',16),(925,'103','ACCESS_IN_CONTROL_PANEL',32),(926,'151','ACCESS_IN_CONTROL_PANEL',2),(927,'151','CONFIGURATION',4),(928,'151','VIEW',1),(929,'151','PERMISSIONS',8),(930,'151','PREFERENCES',16),(931,'140','ACCESS_IN_CONTROL_PANEL',2),(932,'140','CONFIGURATION',4),(933,'140','VIEW',1),(934,'140','PERMISSIONS',8),(935,'140','PREFERENCES',16),(936,'54','VIEW',1),(937,'54','ADD_TO_PAGE',2),(938,'54','CONFIGURATION',4),(939,'54','PERMISSIONS',8),(940,'54','PREFERENCES',16),(941,'54','ACCESS_IN_CONTROL_PANEL',32),(942,'169','VIEW',1),(943,'169','ADD_TO_PAGE',2),(944,'169','CONFIGURATION',4),(945,'169','PERMISSIONS',8),(946,'169','PREFERENCES',16),(947,'169','ACCESS_IN_CONTROL_PANEL',32),(948,'com.liferay.portlet.dynamicdatamapping.model.DDMTemplate','DELETE',2),(949,'com.liferay.portlet.dynamicdatamapping.model.DDMTemplate','PERMISSIONS',4),(950,'com.liferay.portlet.dynamicdatamapping.model.DDMTemplate','UPDATE',8),(951,'com.liferay.portlet.dynamicdatamapping.model.DDMTemplate','VIEW',1),(952,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure','DELETE',2),(953,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure','PERMISSIONS',4),(954,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure','UPDATE',8),(955,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure','VIEW',1),(956,'132','ACCESS_IN_CONTROL_PANEL',2),(957,'132','CONFIGURATION',4),(958,'132','VIEW',1),(959,'132','PERMISSIONS',8),(960,'132','PREFERENCES',16),(961,'34','ADD_TO_PAGE',2),(962,'34','CONFIGURATION',4),(963,'34','VIEW',1),(964,'34','PERMISSIONS',8),(965,'34','PREFERENCES',16),(966,'34','ACCESS_IN_CONTROL_PANEL',32),(967,'com.liferay.portlet.shopping','ADD_CATEGORY',2),(968,'com.liferay.portlet.shopping','ADD_ITEM',4),(969,'com.liferay.portlet.shopping','MANAGE_COUPONS',8),(970,'com.liferay.portlet.shopping','MANAGE_ORDERS',16),(971,'com.liferay.portlet.shopping','PERMISSIONS',32),(972,'com.liferay.portlet.shopping','VIEW',1),(973,'com.liferay.portlet.shopping.model.ShoppingCategory','ADD_ITEM',2),(974,'com.liferay.portlet.shopping.model.ShoppingCategory','ADD_SUBCATEGORY',4),(975,'com.liferay.portlet.shopping.model.ShoppingCategory','DELETE',8),(976,'com.liferay.portlet.shopping.model.ShoppingCategory','PERMISSIONS',16),(977,'com.liferay.portlet.shopping.model.ShoppingCategory','UPDATE',32),(978,'com.liferay.portlet.shopping.model.ShoppingCategory','VIEW',1),(979,'com.liferay.portlet.shopping.model.ShoppingOrder','DELETE',2),(980,'com.liferay.portlet.shopping.model.ShoppingOrder','PERMISSIONS',4),(981,'com.liferay.portlet.shopping.model.ShoppingOrder','UPDATE',8),(982,'com.liferay.portlet.shopping.model.ShoppingOrder','VIEW',1),(983,'com.liferay.portlet.shopping.model.ShoppingItem','DELETE',2),(984,'com.liferay.portlet.shopping.model.ShoppingItem','PERMISSIONS',4),(985,'com.liferay.portlet.shopping.model.ShoppingItem','UPDATE',8),(986,'com.liferay.portlet.shopping.model.ShoppingItem','VIEW',1),(987,'61','VIEW',1),(988,'61','ADD_TO_PAGE',2),(989,'61','CONFIGURATION',4),(990,'61','PERMISSIONS',8),(991,'61','PREFERENCES',16),(992,'61','ACCESS_IN_CONTROL_PANEL',32),(993,'73','ADD_TO_PAGE',2),(994,'73','CONFIGURATION',4),(995,'73','VIEW',1),(996,'73','PERMISSIONS',8),(997,'73','PREFERENCES',16),(998,'73','ACCESS_IN_CONTROL_PANEL',32),(999,'193','VIEW',1),(1000,'193','ADD_TO_PAGE',2),(1001,'193','CONFIGURATION',4),(1002,'193','PERMISSIONS',8),(1003,'193','PREFERENCES',16),(1004,'193','ACCESS_IN_CONTROL_PANEL',32),(1005,'127','VIEW',1),(1006,'127','ADD_TO_PAGE',2),(1007,'127','CONFIGURATION',4),(1008,'127','PERMISSIONS',8),(1009,'127','PREFERENCES',16),(1010,'127','ACCESS_IN_CONTROL_PANEL',32),(1011,'com.liferay.portal.model.UserGroup','ASSIGN_MEMBERS',2),(1012,'com.liferay.portal.model.UserGroup','DELETE',4),(1013,'com.liferay.portal.model.UserGroup','MANAGE_ANNOUNCEMENTS',8),(1014,'com.liferay.portal.model.UserGroup','PERMISSIONS',16),(1015,'com.liferay.portal.model.UserGroup','UPDATE',32),(1016,'com.liferay.portal.model.UserGroup','VIEW',1),(1017,'com.liferay.portal.model.UserGroup','VIEW_MEMBERS',64),(1018,'50','VIEW',1),(1019,'50','ADD_TO_PAGE',2),(1020,'50','CONFIGURATION',4),(1021,'50','PERMISSIONS',8),(1022,'50','PREFERENCES',16),(1023,'50','ACCESS_IN_CONTROL_PANEL',32),(1024,'31','VIEW',1),(1025,'31','ADD_TO_PAGE',2),(1026,'31','CONFIGURATION',4),(1027,'31','PERMISSIONS',8),(1028,'31','PREFERENCES',16),(1029,'31','ACCESS_IN_CONTROL_PANEL',32),(1030,'165','VIEW',1),(1031,'165','ADD_TO_PAGE',2),(1032,'165','CONFIGURATION',4),(1033,'165','PERMISSIONS',8),(1034,'165','PREFERENCES',16),(1035,'165','ACCESS_IN_CONTROL_PANEL',32),(1036,'25','ACCESS_IN_CONTROL_PANEL',2),(1037,'25','CONFIGURATION',4),(1038,'25','VIEW',1),(1039,'25','PERMISSIONS',8),(1040,'25','PREFERENCES',16),(1041,'com.liferay.portlet.polls','ADD_QUESTION',2),(1042,'com.liferay.portlet.polls','PERMISSIONS',4),(1043,'com.liferay.portlet.polls.model.PollsQuestion','ADD_VOTE',2),(1044,'com.liferay.portlet.polls.model.PollsQuestion','DELETE',4),(1045,'com.liferay.portlet.polls.model.PollsQuestion','PERMISSIONS',8),(1046,'com.liferay.portlet.polls.model.PollsQuestion','UPDATE',16),(1047,'com.liferay.portlet.polls.model.PollsQuestion','VIEW',1),(1048,'192','VIEW',1),(1049,'192','ADD_TO_PAGE',2),(1050,'192','CONFIGURATION',4),(1051,'192','PERMISSIONS',8),(1052,'192','PREFERENCES',16),(1053,'192','ACCESS_IN_CONTROL_PANEL',32),(1054,'166','ACCESS_IN_CONTROL_PANEL',2),(1055,'166','ADD_TO_PAGE',4),(1056,'166','CONFIGURATION',8),(1057,'166','VIEW',1),(1058,'166','PERMISSIONS',16),(1059,'166','PREFERENCES',32),(1060,'90','ADD_COMMUNITY',2),(1061,'90','ADD_GENERAL_ANNOUNCEMENTS',4),(1062,'90','ADD_LAYOUT_PROTOTYPE',8),(1063,'90','ADD_LAYOUT_SET_PROTOTYPE',16),(1064,'90','ADD_LICENSE',32),(1065,'90','ADD_ORGANIZATION',64),(1066,'90','ADD_PASSWORD_POLICY',128),(1067,'90','ADD_ROLE',256),(1068,'90','ADD_USER',512),(1069,'90','ADD_USER_GROUP',1024),(1070,'90','CONFIGURATION',2048),(1071,'90','EXPORT_USER',4096),(1072,'90','IMPERSONATE',8192),(1073,'90','UNLINK_LAYOUT_SET_PROTOTYPE',16384),(1074,'90','VIEW_CONTROL_PANEL',32768),(1075,'90','ADD_TO_PAGE',65536),(1076,'90','PERMISSIONS',131072),(1077,'90','PREFERENCES',262144),(1078,'90','VIEW',1),(1079,'90','ACCESS_IN_CONTROL_PANEL',524288),(1080,'150','ACCESS_IN_CONTROL_PANEL',2),(1081,'150','CONFIGURATION',4),(1082,'150','VIEW',1),(1083,'150','PERMISSIONS',8),(1084,'150','PREFERENCES',16),(1085,'113','VIEW',1),(1086,'113','ADD_TO_PAGE',2),(1087,'113','CONFIGURATION',4),(1088,'113','PERMISSIONS',8),(1089,'113','PREFERENCES',16),(1090,'113','ACCESS_IN_CONTROL_PANEL',32),(1091,'33','ADD_PORTLET_DISPLAY_TEMPLATE',2),(1092,'33','ADD_TO_PAGE',4),(1093,'33','CONFIGURATION',8),(1094,'33','VIEW',1),(1095,'33','PERMISSIONS',16),(1096,'33','PREFERENCES',32),(1097,'33','ACCESS_IN_CONTROL_PANEL',64),(1098,'2','ACCESS_IN_CONTROL_PANEL',2),(1099,'2','CONFIGURATION',4),(1100,'2','VIEW',1),(1101,'2','PERMISSIONS',8),(1102,'2','PREFERENCES',16),(1103,'191','VIEW',1),(1104,'191','ADD_TO_PAGE',2),(1105,'191','CONFIGURATION',4),(1106,'191','PERMISSIONS',8),(1107,'191','PREFERENCES',16),(1108,'191','ACCESS_IN_CONTROL_PANEL',32),(1109,'119','VIEW',1),(1110,'119','ADD_TO_PAGE',2),(1111,'119','CONFIGURATION',4),(1112,'119','PERMISSIONS',8),(1113,'119','PREFERENCES',16),(1114,'119','ACCESS_IN_CONTROL_PANEL',32),(1115,'114','VIEW',1),(1116,'114','ADD_TO_PAGE',2),(1117,'114','CONFIGURATION',4),(1118,'114','PERMISSIONS',8),(1119,'114','PREFERENCES',16),(1120,'114','ACCESS_IN_CONTROL_PANEL',32),(1121,'149','ACCESS_IN_CONTROL_PANEL',2),(1122,'149','CONFIGURATION',4),(1123,'149','VIEW',1),(1124,'149','PERMISSIONS',8),(1125,'149','PREFERENCES',16),(1126,'com.liferay.portal.model.LayoutSetPrototype','DELETE',2),(1127,'com.liferay.portal.model.LayoutSetPrototype','PERMISSIONS',4),(1128,'com.liferay.portal.model.LayoutSetPrototype','UPDATE',8),(1129,'com.liferay.portal.model.LayoutSetPrototype','VIEW',1),(1130,'67','VIEW',1),(1131,'67','ADD_TO_PAGE',2),(1132,'67','CONFIGURATION',4),(1133,'67','PERMISSIONS',8),(1134,'67','PREFERENCES',16),(1135,'67','ACCESS_IN_CONTROL_PANEL',32),(1136,'110','VIEW',1),(1137,'110','ADD_TO_PAGE',2),(1138,'110','CONFIGURATION',4),(1139,'110','PERMISSIONS',8),(1140,'110','PREFERENCES',16),(1141,'110','ACCESS_IN_CONTROL_PANEL',32),(1142,'135','ACCESS_IN_CONTROL_PANEL',2),(1143,'135','CONFIGURATION',4),(1144,'135','VIEW',1),(1145,'135','PERMISSIONS',8),(1146,'135','PREFERENCES',16),(1147,'59','VIEW',1),(1148,'59','ADD_TO_PAGE',2),(1149,'59','CONFIGURATION',4),(1150,'59','PERMISSIONS',8),(1151,'59','PREFERENCES',16),(1152,'59','ACCESS_IN_CONTROL_PANEL',32),(1153,'188','ADD_TO_PAGE',2),(1154,'188','CONFIGURATION',4),(1155,'188','VIEW',1),(1156,'188','PERMISSIONS',8),(1157,'188','PREFERENCES',16),(1158,'188','ACCESS_IN_CONTROL_PANEL',32),(1159,'131','ACCESS_IN_CONTROL_PANEL',2),(1160,'131','CONFIGURATION',4),(1161,'131','VIEW',1),(1162,'131','PERMISSIONS',8),(1163,'131','PREFERENCES',16),(1164,'102','VIEW',1),(1165,'102','ADD_TO_PAGE',2),(1166,'102','CONFIGURATION',4),(1167,'102','PERMISSIONS',8),(1168,'102','PREFERENCES',16),(1169,'102','ACCESS_IN_CONTROL_PANEL',32),(1201,'dictionary_WAR_sysportlet','VIEW',1),(1202,'dictionary_WAR_sysportlet','ADD_TO_PAGE',2),(1203,'dictionary_WAR_sysportlet','CONFIGURATION',4),(1204,'dictionary_WAR_sysportlet','PERMISSIONS',8),(1205,'dictionary_WAR_sysportlet','PREFERENCES',16),(1206,'dictionary_WAR_sysportlet','ACCESS_IN_CONTROL_PANEL',32),(1301,'leaderweeklywork_WAR_oaportlet','VIEW',1),(1302,'leaderweeklywork_WAR_oaportlet','ADD_TO_PAGE',2),(1303,'leaderweeklywork_WAR_oaportlet','CONFIGURATION',4),(1304,'leaderweeklywork_WAR_oaportlet','PERMISSIONS',8),(1305,'leaderweeklywork_WAR_oaportlet','PREFERENCES',16),(1306,'leaderweeklywork_WAR_oaportlet','ACCESS_IN_CONTROL_PANEL',32),(1307,'officesupply_WAR_oaportlet','VIEW',1),(1308,'officesupply_WAR_oaportlet','ADD_TO_PAGE',2),(1309,'officesupply_WAR_oaportlet','CONFIGURATION',4),(1310,'officesupply_WAR_oaportlet','PERMISSIONS',8),(1311,'officesupply_WAR_oaportlet','PREFERENCES',16),(1312,'officesupply_WAR_oaportlet','ACCESS_IN_CONTROL_PANEL',32),(1313,'vehiclerequisition_WAR_oaportlet','VIEW',1),(1314,'vehiclerequisition_WAR_oaportlet','ADD_TO_PAGE',2),(1315,'vehiclerequisition_WAR_oaportlet','CONFIGURATION',4),(1316,'vehiclerequisition_WAR_oaportlet','PERMISSIONS',8),(1317,'vehiclerequisition_WAR_oaportlet','PREFERENCES',16),(1318,'vehiclerequisition_WAR_oaportlet','ACCESS_IN_CONTROL_PANEL',32),(1319,'senddispatch_WAR_oaportlet','VIEW',1),(1320,'senddispatch_WAR_oaportlet','ADD_TO_PAGE',2),(1321,'senddispatch_WAR_oaportlet','CONFIGURATION',4),(1322,'senddispatch_WAR_oaportlet','PERMISSIONS',8),(1323,'senddispatch_WAR_oaportlet','PREFERENCES',16),(1324,'senddispatch_WAR_oaportlet','ACCESS_IN_CONTROL_PANEL',32),(1325,'deptweeklywork_WAR_oaportlet','VIEW',1),(1326,'deptweeklywork_WAR_oaportlet','ADD_TO_PAGE',2),(1327,'deptweeklywork_WAR_oaportlet','CONFIGURATION',4),(1328,'deptweeklywork_WAR_oaportlet','PERMISSIONS',8),(1329,'deptweeklywork_WAR_oaportlet','PREFERENCES',16),(1330,'deptweeklywork_WAR_oaportlet','ACCESS_IN_CONTROL_PANEL',32);
/*!40000 ALTER TABLE `resourceaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resourceblock`
--

DROP TABLE IF EXISTS `resourceblock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resourceblock` (
  `resourceBlockId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `permissionsHash` varchar(75) DEFAULT NULL,
  `referenceCount` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`resourceBlockId`),
  UNIQUE KEY `IX_AEEA209C` (`companyId`,`groupId`,`name`,`permissionsHash`),
  KEY `IX_DA30B086` (`companyId`,`groupId`,`name`),
  KEY `IX_2D4CC782` (`companyId`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resourceblock`
--

LOCK TABLES `resourceblock` WRITE;
/*!40000 ALTER TABLE `resourceblock` DISABLE KEYS */;
/*!40000 ALTER TABLE `resourceblock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resourceblockpermission`
--

DROP TABLE IF EXISTS `resourceblockpermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resourceblockpermission` (
  `resourceBlockPermissionId` bigint(20) NOT NULL,
  `resourceBlockId` bigint(20) DEFAULT NULL,
  `roleId` bigint(20) DEFAULT NULL,
  `actionIds` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`resourceBlockPermissionId`),
  UNIQUE KEY `IX_D63D20BB` (`resourceBlockId`,`roleId`),
  KEY `IX_4AB3756` (`resourceBlockId`),
  KEY `IX_20A2E3D9` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resourceblockpermission`
--

LOCK TABLES `resourceblockpermission` WRITE;
/*!40000 ALTER TABLE `resourceblockpermission` DISABLE KEYS */;
/*!40000 ALTER TABLE `resourceblockpermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resourcepermission`
--

DROP TABLE IF EXISTS `resourcepermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resourcepermission` (
  `resourcePermissionId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `scope` int(11) DEFAULT NULL,
  `primKey` varchar(255) DEFAULT NULL,
  `roleId` bigint(20) DEFAULT NULL,
  `ownerId` bigint(20) DEFAULT NULL,
  `actionIds` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`resourcePermissionId`),
  UNIQUE KEY `IX_8D83D0CE` (`companyId`,`name`,`scope`,`primKey`,`roleId`),
  KEY `IX_60B99860` (`companyId`,`name`,`scope`),
  KEY `IX_2200AA69` (`companyId`,`name`,`scope`,`primKey`),
  KEY `IX_26284944` (`companyId`,`primKey`),
  KEY `IX_A37A0588` (`roleId`),
  KEY `IX_F4555981` (`scope`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resourcepermission`
--

LOCK TABLES `resourcepermission` WRITE;
/*!40000 ALTER TABLE `resourcepermission` DISABLE KEYS */;
INSERT INTO `resourcepermission` VALUES (1,20154,'2',1,'20154',20165,0,2),(2,20154,'140',1,'20154',20165,0,2),(3,20154,'158',1,'20154',20165,0,6),(4,20154,'153',1,'20154',20165,0,6),(5,20154,'com.liferay.portal.model.Role',4,'20161',20165,0,1),(6,20154,'com.liferay.portal.model.Role',4,'20162',20165,0,1),(7,20154,'com.liferay.portal.model.Role',4,'20163',20165,0,1),(8,20154,'com.liferay.portal.model.Role',4,'20164',20165,0,1),(9,20154,'com.liferay.portal.model.Role',4,'20165',20165,0,1),(10,20154,'com.liferay.portal.model.Role',4,'20166',20165,0,1),(11,20154,'com.liferay.portal.model.Role',4,'20167',20165,0,1),(12,20154,'com.liferay.portal.model.Role',4,'20168',20165,0,1),(13,20154,'com.liferay.portal.model.Role',4,'20169',20165,0,1),(14,20154,'com.liferay.portal.model.Role',4,'20170',20165,0,1),(15,20154,'com.liferay.portal.model.Role',4,'20171',20165,0,1),(16,20154,'com.liferay.portal.model.Layout',4,'20175',20163,20158,1023),(17,20154,'com.liferay.portal.model.Layout',4,'20175',20170,0,19),(18,20154,'com.liferay.portal.model.Layout',4,'20175',20162,0,1),(19,20154,'com.liferay.portal.model.Layout',4,'20184',20163,20158,1023),(20,20154,'com.liferay.portal.model.Layout',4,'20184',20170,0,19),(21,20154,'com.liferay.portal.model.Layout',4,'20184',20162,0,1),(22,20154,'com.liferay.portal.model.Layout',2,'20191',20165,0,1),(23,20154,'com.liferay.portlet.blogs',2,'20191',20165,0,14),(24,20154,'98',2,'20191',20164,0,2),(25,20154,'183',2,'20191',20164,0,32),(26,20154,'152',2,'20191',20164,0,2),(27,20154,'182',2,'20191',20164,0,32),(28,20154,'179',2,'20191',20164,0,2),(29,20154,'173',2,'20191',20164,0,32),(30,20154,'154',2,'20191',20164,0,2),(31,20154,'178',2,'20191',20164,0,32),(32,20154,'147',2,'20191',20164,0,2),(33,20154,'161',2,'20191',20164,0,2),(34,20154,'162',2,'20191',20164,0,2),(35,20154,'167',2,'20191',20164,0,2),(36,20154,'20',2,'20191',20164,0,2),(37,20154,'99',2,'20191',20164,0,2),(38,20154,'28',2,'20191',20164,0,2),(39,20154,'15',2,'20191',20164,0,2),(40,20154,'25',2,'20191',20164,0,2),(41,20154,'com.liferay.portal.model.Group',2,'20191',20164,0,8396800),(42,20154,'com.liferay.portlet.asset',2,'20191',20164,0,30),(43,20154,'com.liferay.portlet.blogs',2,'20191',20164,0,14),(44,20154,'com.liferay.portlet.bookmarks',2,'20191',20164,0,31),(45,20154,'com.liferay.portlet.documentlibrary',2,'20191',20164,0,1023),(46,20154,'com.liferay.portlet.journal',2,'20191',20164,0,255),(47,20154,'com.liferay.portlet.messageboards',2,'20191',20164,0,2047),(48,20154,'com.liferay.portlet.polls',2,'20191',20164,0,6),(49,20154,'com.liferay.portlet.wiki',2,'20191',20164,0,6),(50,20154,'com.liferay.portal.model.User',4,'20198',20163,20198,31),(51,20154,'98',1,'20154',20164,0,4),(52,20154,'98',1,'20154',20165,0,4),(53,20154,'183',1,'20154',20161,0,2),(54,20154,'66',1,'20154',20164,0,2),(55,20154,'66',1,'20154',20165,0,2),(56,20154,'180',1,'20154',20162,0,2),(57,20154,'180',1,'20154',20164,0,2),(58,20154,'180',1,'20154',20165,0,2),(59,20154,'27',1,'20154',20164,0,2),(60,20154,'27',1,'20154',20165,0,2),(61,20154,'122',1,'20154',20162,0,8),(62,20154,'122',1,'20154',20164,0,8),(63,20154,'122',1,'20154',20165,0,8),(64,20154,'36',1,'20154',20164,0,4),(65,20154,'36',1,'20154',20165,0,4),(66,20154,'26',1,'20154',20164,0,2),(67,20154,'26',1,'20154',20165,0,2),(68,20154,'175',1,'20154',20162,0,2),(69,20154,'175',1,'20154',20164,0,2),(70,20154,'175',1,'20154',20165,0,2),(71,20154,'153',1,'20154',20164,0,4),(72,20154,'64',1,'20154',20162,0,2),(73,20154,'64',1,'20154',20164,0,2),(74,20154,'64',1,'20154',20165,0,2),(75,20154,'182',1,'20154',20164,0,2),(76,20154,'182',1,'20154',20165,0,2),(77,20154,'173',1,'20154',20162,0,2),(78,20154,'173',1,'20154',20164,0,2),(79,20154,'173',1,'20154',20165,0,2),(80,20154,'100',1,'20154',20164,0,2),(81,20154,'100',1,'20154',20165,0,2),(82,20154,'19',1,'20154',20164,0,2),(83,20154,'19',1,'20154',20165,0,2),(84,20154,'181',1,'20154',20162,0,2),(85,20154,'181',1,'20154',20164,0,2),(86,20154,'181',1,'20154',20165,0,2),(87,20154,'148',1,'20154',20162,0,2),(88,20154,'148',1,'20154',20164,0,2),(89,20154,'148',1,'20154',20165,0,2),(90,20154,'11',1,'20154',20164,0,2),(91,20154,'11',1,'20154',20165,0,2),(92,20154,'29',1,'20154',20164,0,2),(93,20154,'29',1,'20154',20165,0,2),(94,20154,'158',1,'20154',20164,0,4),(95,20154,'178',1,'20154',20164,0,4),(96,20154,'178',1,'20154',20165,0,4),(97,20154,'58',1,'20154',20162,0,2),(98,20154,'58',1,'20154',20164,0,2),(99,20154,'58',1,'20154',20165,0,2),(100,20154,'71',1,'20154',20162,0,2),(101,20154,'71',1,'20154',20164,0,2),(102,20154,'71',1,'20154',20165,0,2),(103,20154,'97',1,'20154',20164,0,2),(104,20154,'97',1,'20154',20165,0,2),(105,20154,'39',1,'20154',20164,0,2),(106,20154,'39',1,'20154',20165,0,2),(107,20154,'85',1,'20154',20162,0,2),(108,20154,'85',1,'20154',20164,0,2),(109,20154,'85',1,'20154',20165,0,2),(110,20154,'118',1,'20154',20162,0,2),(111,20154,'118',1,'20154',20164,0,2),(112,20154,'118',1,'20154',20165,0,2),(113,20154,'107',1,'20154',20164,0,2),(114,20154,'107',1,'20154',20165,0,2),(115,20154,'30',1,'20154',20164,0,2),(116,20154,'30',1,'20154',20165,0,2),(117,20154,'184',1,'20154',20162,0,2),(118,20154,'184',1,'20154',20164,0,2),(119,20154,'184',1,'20154',20165,0,2),(120,20154,'48',1,'20154',20164,0,2),(121,20154,'48',1,'20154',20165,0,2),(122,20154,'62',1,'20154',20164,0,2),(123,20154,'62',1,'20154',20165,0,2),(124,20154,'176',1,'20154',20161,0,2),(125,20154,'108',1,'20154',20164,0,2),(126,20154,'108',1,'20154',20165,0,2),(127,20154,'187',1,'20154',20164,0,2),(128,20154,'187',1,'20154',20165,0,2),(129,20154,'84',1,'20154',20164,0,4),(130,20154,'84',1,'20154',20165,0,4),(131,20154,'101',1,'20154',20162,0,4),(132,20154,'101',1,'20154',20164,0,4),(133,20154,'101',1,'20154',20165,0,4),(134,20154,'121',1,'20154',20162,0,2),(135,20154,'121',1,'20154',20164,0,2),(136,20154,'121',1,'20154',20165,0,2),(137,20154,'143',1,'20154',20162,0,2),(138,20154,'143',1,'20154',20164,0,2),(139,20154,'143',1,'20154',20165,0,2),(140,20154,'77',1,'20154',20162,0,2),(141,20154,'77',1,'20154',20164,0,2),(142,20154,'77',1,'20154',20165,0,2),(143,20154,'167',1,'20154',20164,0,4),(144,20154,'167',1,'20154',20165,0,4),(145,20154,'115',1,'20154',20162,0,2),(146,20154,'115',1,'20154',20164,0,2),(147,20154,'115',1,'20154',20165,0,2),(148,20154,'56',1,'20154',20162,0,2),(149,20154,'56',1,'20154',20164,0,2),(150,20154,'56',1,'20154',20165,0,2),(151,20154,'16',1,'20154',20164,0,8),(152,20154,'16',1,'20154',20165,0,8),(153,20154,'3',1,'20154',20162,0,2),(154,20154,'3',1,'20154',20164,0,2),(155,20154,'3',1,'20154',20165,0,2),(156,20154,'20',1,'20154',20162,0,8),(157,20154,'20',1,'20154',20164,0,8),(158,20154,'20',1,'20154',20165,0,8),(159,20154,'23',1,'20154',20164,0,2),(160,20154,'23',1,'20154',20165,0,2),(161,20154,'83',1,'20154',20164,0,4),(162,20154,'83',1,'20154',20165,0,4),(163,20154,'186',1,'20154',20164,0,2),(164,20154,'186',1,'20154',20165,0,2),(165,20154,'194',1,'20154',20162,0,2),(166,20154,'194',1,'20154',20164,0,2),(167,20154,'194',1,'20154',20165,0,2),(168,20154,'70',1,'20154',20164,0,2),(169,20154,'70',1,'20154',20165,0,2),(170,20154,'164',1,'20154',20162,0,2),(171,20154,'164',1,'20154',20164,0,2),(172,20154,'164',1,'20154',20165,0,2),(173,20154,'141',1,'20154',20162,0,8),(174,20154,'141',1,'20154',20164,0,8),(175,20154,'141',1,'20154',20165,0,8),(176,20154,'9',1,'20154',20161,0,2),(177,20154,'28',1,'20154',20164,0,4),(178,20154,'28',1,'20154',20165,0,4),(179,20154,'15',1,'20154',20164,0,4),(180,20154,'15',1,'20154',20165,0,4),(181,20154,'47',1,'20154',20162,0,2),(182,20154,'47',1,'20154',20164,0,2),(183,20154,'47',1,'20154',20165,0,2),(184,20154,'116',1,'20154',20162,0,2),(185,20154,'116',1,'20154',20164,0,2),(186,20154,'116',1,'20154',20165,0,2),(187,20154,'82',1,'20154',20162,0,2),(188,20154,'82',1,'20154',20164,0,2),(189,20154,'82',1,'20154',20165,0,2),(190,20154,'54',1,'20154',20164,0,2),(191,20154,'54',1,'20154',20165,0,2),(192,20154,'34',1,'20154',20164,0,2),(193,20154,'34',1,'20154',20165,0,2),(194,20154,'169',1,'20154',20164,0,2),(195,20154,'169',1,'20154',20165,0,2),(196,20154,'61',1,'20154',20164,0,2),(197,20154,'61',1,'20154',20165,0,2),(198,20154,'73',1,'20154',20162,0,2),(199,20154,'73',1,'20154',20164,0,2),(200,20154,'73',1,'20154',20165,0,2),(201,20154,'50',1,'20154',20162,0,2),(202,20154,'50',1,'20154',20164,0,2),(203,20154,'50',1,'20154',20165,0,2),(204,20154,'127',1,'20154',20161,0,2),(205,20154,'193',1,'20154',20162,0,2),(206,20154,'193',1,'20154',20164,0,2),(207,20154,'193',1,'20154',20165,0,2),(208,20154,'31',1,'20154',20162,0,2),(209,20154,'31',1,'20154',20164,0,2),(210,20154,'31',1,'20154',20165,0,2),(211,20154,'166',1,'20154',20164,0,4),(212,20154,'166',1,'20154',20165,0,4),(213,20154,'33',1,'20154',20162,0,4),(214,20154,'33',1,'20154',20164,0,4),(215,20154,'33',1,'20154',20165,0,4),(216,20154,'114',1,'20154',20162,0,2),(217,20154,'114',1,'20154',20164,0,2),(218,20154,'114',1,'20154',20165,0,2),(219,20154,'67',1,'20154',20164,0,2),(220,20154,'67',1,'20154',20165,0,2),(221,20154,'110',1,'20154',20164,0,2),(222,20154,'110',1,'20154',20165,0,2),(223,20154,'59',1,'20154',20164,0,2),(224,20154,'59',1,'20154',20165,0,2),(225,20154,'188',1,'20154',20164,0,2),(226,20154,'188',1,'20154',20165,0,2),(227,20154,'102',1,'20154',20161,0,2),(228,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20303',20163,20158,15),(229,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20303',20165,0,1),(230,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20303',20162,0,1),(231,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20304',20163,20158,15),(232,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20304',20165,0,1),(233,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20304',20162,0,1),(234,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20305',20163,20158,15),(235,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20305',20165,0,1),(236,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20305',20162,0,1),(237,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20307',20163,20158,15),(238,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20307',20165,0,1),(239,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20307',20162,0,1),(240,20154,'com.liferay.portlet.documentlibrary.model.DLFileEntryType',4,'20306',20163,20158,15),(241,20154,'com.liferay.portlet.documentlibrary.model.DLFileEntryType',4,'20306',20165,0,1),(242,20154,'com.liferay.portlet.documentlibrary.model.DLFileEntryType',4,'20306',20162,0,1),(243,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20309',20163,20158,15),(244,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20309',20165,0,1),(245,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20309',20162,0,1),(246,20154,'com.liferay.portlet.documentlibrary.model.DLFileEntryType',4,'20308',20163,20158,15),(247,20154,'com.liferay.portlet.documentlibrary.model.DLFileEntryType',4,'20308',20165,0,1),(248,20154,'com.liferay.portlet.documentlibrary.model.DLFileEntryType',4,'20308',20162,0,1),(249,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20311',20163,20158,15),(250,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20311',20165,0,1),(251,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20311',20162,0,1),(252,20154,'com.liferay.portlet.documentlibrary.model.DLFileEntryType',4,'20310',20163,20158,15),(253,20154,'com.liferay.portlet.documentlibrary.model.DLFileEntryType',4,'20310',20165,0,1),(254,20154,'com.liferay.portlet.documentlibrary.model.DLFileEntryType',4,'20310',20162,0,1),(255,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20313',20163,20158,15),(256,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20313',20165,0,1),(257,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20313',20162,0,1),(258,20154,'com.liferay.portlet.documentlibrary.model.DLFileEntryType',4,'20312',20163,20158,15),(259,20154,'com.liferay.portlet.documentlibrary.model.DLFileEntryType',4,'20312',20165,0,1),(260,20154,'com.liferay.portlet.documentlibrary.model.DLFileEntryType',4,'20312',20162,0,1),(261,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20315',20163,20158,15),(262,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20315',20165,0,1),(263,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20315',20162,0,1),(264,20154,'com.liferay.portal.model.LayoutPrototype',4,'20316',20163,20158,15),(265,20154,'com.liferay.portal.model.Layout',4,'20320',20163,20158,1023),(266,20154,'com.liferay.portal.model.Layout',4,'20320',20170,0,19),(267,20154,'com.liferay.portlet.asset.model.AssetVocabulary',4,'20324',20163,20158,15),(268,20154,'33',4,'20320_LAYOUT_33',20163,0,127),(269,20154,'33',4,'20320_LAYOUT_33',20170,0,1),(270,20154,'33',4,'20320_LAYOUT_33',20162,0,1),(271,20154,'com.liferay.portlet.blogs',4,'20317',20163,0,14),(272,20154,'148',4,'20320_LAYOUT_148_INSTANCE_mWmqEdahLqMP',20163,0,63),(273,20154,'148',4,'20320_LAYOUT_148_INSTANCE_mWmqEdahLqMP',20170,0,1),(274,20154,'148',4,'20320_LAYOUT_148_INSTANCE_mWmqEdahLqMP',20162,0,1),(275,20154,'114',4,'20320_LAYOUT_114',20163,0,63),(276,20154,'114',4,'20320_LAYOUT_114',20170,0,1),(277,20154,'114',4,'20320_LAYOUT_114',20162,0,1),(278,20154,'com.liferay.portal.model.LayoutPrototype',4,'20328',20163,20158,15),(279,20154,'com.liferay.portal.model.Layout',4,'20332',20163,20158,1023),(280,20154,'com.liferay.portal.model.Layout',4,'20332',20170,0,19),(281,20154,'141',4,'20332_LAYOUT_141_INSTANCE_4CcB7CrDn3FC',20163,0,127),(282,20154,'141',4,'20332_LAYOUT_141_INSTANCE_4CcB7CrDn3FC',20170,0,1),(283,20154,'141',4,'20332_LAYOUT_141_INSTANCE_4CcB7CrDn3FC',20162,0,1),(284,20154,'122',4,'20332_LAYOUT_122_INSTANCE_4wErzgn4RIBU',20163,0,127),(285,20154,'122',4,'20332_LAYOUT_122_INSTANCE_4wErzgn4RIBU',20170,0,1),(286,20154,'122',4,'20332_LAYOUT_122_INSTANCE_4wErzgn4RIBU',20162,0,1),(287,20154,'3',4,'20332_LAYOUT_3',20163,0,63),(288,20154,'3',4,'20332_LAYOUT_3',20170,0,1),(289,20154,'3',4,'20332_LAYOUT_3',20162,0,1),(290,20154,'101',4,'20332_LAYOUT_101_INSTANCE_T4YbeRawCGZn',20163,0,255),(291,20154,'101',4,'20332_LAYOUT_101_INSTANCE_T4YbeRawCGZn',20170,0,17),(292,20154,'101',4,'20332_LAYOUT_101_INSTANCE_T4YbeRawCGZn',20162,0,1),(293,20154,'com.liferay.portal.model.LayoutPrototype',4,'20338',20163,20158,15),(294,20154,'com.liferay.portal.model.Layout',4,'20342',20163,20158,1023),(295,20154,'com.liferay.portal.model.Layout',4,'20342',20170,0,19),(296,20154,'36',4,'20342_LAYOUT_36',20163,0,127),(297,20154,'36',4,'20342_LAYOUT_36',20170,0,1),(298,20154,'36',4,'20342_LAYOUT_36',20162,0,1),(299,20154,'com.liferay.portlet.wiki',4,'20339',20163,0,6),(300,20154,'122',4,'20342_LAYOUT_122_INSTANCE_C8oODZqdkH2l',20163,0,127),(301,20154,'122',4,'20342_LAYOUT_122_INSTANCE_C8oODZqdkH2l',20170,0,1),(302,20154,'122',4,'20342_LAYOUT_122_INSTANCE_C8oODZqdkH2l',20162,0,1),(303,20154,'141',4,'20342_LAYOUT_141_INSTANCE_2rhnCUy2CIOc',20163,0,127),(304,20154,'141',4,'20342_LAYOUT_141_INSTANCE_2rhnCUy2CIOc',20170,0,1),(305,20154,'141',4,'20342_LAYOUT_141_INSTANCE_2rhnCUy2CIOc',20162,0,1),(306,20154,'com.liferay.portal.model.LayoutSetPrototype',4,'20349',20163,20158,15),(310,20154,'com.liferay.portal.model.Layout',4,'20361',20163,20158,1023),(311,20154,'com.liferay.portal.model.Layout',4,'20361',20170,0,19),(312,20154,'com.liferay.portal.model.Layout',4,'20361',20162,0,1),(313,20154,'19',4,'20361_LAYOUT_19',20163,0,63),(314,20154,'19',4,'20361_LAYOUT_19',20170,0,1),(315,20154,'19',4,'20361_LAYOUT_19',20162,0,1),(316,20154,'com.liferay.portlet.messageboards',4,'20350',20163,0,2047),(317,20154,'com.liferay.portlet.messageboards',4,'20350',20170,0,781),(318,20154,'com.liferay.portlet.messageboards',4,'20350',20162,0,1),(319,20154,'3',4,'20361_LAYOUT_3',20163,0,63),(320,20154,'3',4,'20361_LAYOUT_3',20170,0,1),(321,20154,'3',4,'20361_LAYOUT_3',20162,0,1),(322,20154,'59',4,'20361_LAYOUT_59_INSTANCE_2BDkFraUiWdr',20163,0,63),(323,20154,'59',4,'20361_LAYOUT_59_INSTANCE_2BDkFraUiWdr',20170,0,1),(324,20154,'59',4,'20361_LAYOUT_59_INSTANCE_2BDkFraUiWdr',20162,0,1),(325,20154,'com.liferay.portlet.polls',4,'20350',20163,0,6),(326,20154,'180',4,'20361_LAYOUT_180',20163,0,63),(327,20154,'180',4,'20361_LAYOUT_180',20170,0,1),(328,20154,'180',4,'20361_LAYOUT_180',20162,0,1),(329,20154,'101',4,'20361_LAYOUT_101_INSTANCE_3Ehai8qFPPux',20163,0,255),(330,20154,'101',4,'20361_LAYOUT_101_INSTANCE_3Ehai8qFPPux',20170,0,17),(331,20154,'101',4,'20361_LAYOUT_101_INSTANCE_3Ehai8qFPPux',20162,0,1),(332,20154,'com.liferay.portal.model.Layout',4,'20369',20163,20158,1023),(333,20154,'com.liferay.portal.model.Layout',4,'20369',20170,0,19),(334,20154,'com.liferay.portal.model.Layout',4,'20369',20162,0,1),(335,20154,'36',4,'20369_LAYOUT_36',20163,0,127),(336,20154,'36',4,'20369_LAYOUT_36',20170,0,1),(337,20154,'36',4,'20369_LAYOUT_36',20162,0,1),(338,20154,'com.liferay.portlet.wiki',4,'20350',20163,0,6),(339,20154,'122',4,'20369_LAYOUT_122_INSTANCE_xCrdj2xoHDuF',20163,0,127),(340,20154,'122',4,'20369_LAYOUT_122_INSTANCE_xCrdj2xoHDuF',20170,0,1),(341,20154,'122',4,'20369_LAYOUT_122_INSTANCE_xCrdj2xoHDuF',20162,0,1),(342,20154,'148',4,'20369_LAYOUT_148_INSTANCE_qeZx14WKqejB',20163,0,63),(343,20154,'148',4,'20369_LAYOUT_148_INSTANCE_qeZx14WKqejB',20170,0,1),(344,20154,'148',4,'20369_LAYOUT_148_INSTANCE_qeZx14WKqejB',20162,0,1),(345,20154,'com.liferay.portal.model.LayoutSetPrototype',4,'20375',20163,20158,15),(349,20154,'com.liferay.portal.model.Layout',4,'20387',20163,20158,1023),(350,20154,'com.liferay.portal.model.Layout',4,'20387',20170,0,19),(351,20154,'com.liferay.portal.model.Layout',4,'20387',20162,0,1),(352,20154,'116',4,'20387_LAYOUT_116',20163,0,63),(353,20154,'116',4,'20387_LAYOUT_116',20170,0,1),(354,20154,'116',4,'20387_LAYOUT_116',20162,0,1),(355,20154,'3',4,'20387_LAYOUT_3',20163,0,63),(356,20154,'3',4,'20387_LAYOUT_3',20170,0,1),(357,20154,'3',4,'20387_LAYOUT_3',20162,0,1),(358,20154,'82',4,'20387_LAYOUT_82',20163,0,63),(359,20154,'82',4,'20387_LAYOUT_82',20170,0,1),(360,20154,'82',4,'20387_LAYOUT_82',20162,0,1),(361,20154,'101',4,'20387_LAYOUT_101_INSTANCE_5r2gG79nrjNw',20163,0,255),(362,20154,'101',4,'20387_LAYOUT_101_INSTANCE_5r2gG79nrjNw',20170,0,17),(363,20154,'101',4,'20387_LAYOUT_101_INSTANCE_5r2gG79nrjNw',20162,0,1),(364,20154,'com.liferay.portal.model.Layout',4,'20396',20163,20158,1023),(365,20154,'com.liferay.portal.model.Layout',4,'20396',20170,0,19),(366,20154,'com.liferay.portal.model.Layout',4,'20396',20162,0,1),(367,20154,'20',4,'20396_LAYOUT_20',20163,0,127),(368,20154,'20',4,'20396_LAYOUT_20',20170,0,1),(369,20154,'20',4,'20396_LAYOUT_20',20162,0,1),(370,20154,'com.liferay.portlet.documentlibrary',4,'20376',20163,0,1023),(371,20154,'com.liferay.portlet.documentlibrary',4,'20376',20170,0,331),(372,20154,'com.liferay.portlet.documentlibrary',4,'20376',20162,0,1),(373,20154,'101',4,'20396_LAYOUT_101_INSTANCE_nODfUxlvAneS',20163,0,255),(374,20154,'101',4,'20396_LAYOUT_101_INSTANCE_nODfUxlvAneS',20170,0,17),(375,20154,'101',4,'20396_LAYOUT_101_INSTANCE_nODfUxlvAneS',20162,0,1),(376,20154,'com.liferay.portal.model.Layout',4,'20404',20163,20158,1023),(377,20154,'com.liferay.portal.model.Layout',4,'20404',20170,0,19),(378,20154,'com.liferay.portal.model.Layout',4,'20404',20162,0,1),(379,20154,'39',4,'20404_LAYOUT_39_INSTANCE_hdT9AX4ACu96',20163,0,63),(380,20154,'39',4,'20404_LAYOUT_39_INSTANCE_hdT9AX4ACu96',20170,0,1),(381,20154,'39',4,'20404_LAYOUT_39_INSTANCE_hdT9AX4ACu96',20162,0,1),(382,20154,'39',4,'20404_LAYOUT_39_INSTANCE_F26XmskYlWyj',20163,0,63),(383,20154,'39',4,'20404_LAYOUT_39_INSTANCE_F26XmskYlWyj',20170,0,1),(384,20154,'39',4,'20404_LAYOUT_39_INSTANCE_F26XmskYlWyj',20162,0,1),(385,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20412',20163,20158,15),(386,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20413',20163,20158,15),(387,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20414',20163,20158,15),(388,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20415',20163,20158,15),(389,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20416',20163,20158,15),(390,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMStructure',4,'20417',20163,20158,15),(391,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMTemplate',4,'20418',20163,20158,15),(392,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMTemplate',4,'20420',20163,20158,15),(393,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMTemplate',4,'20423',20163,20158,15),(394,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMTemplate',4,'20425',20163,20158,15),(395,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMTemplate',4,'20427',20163,20158,15),(396,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMTemplate',4,'20429',20163,20158,15),(397,20154,'com.liferay.portlet.dynamicdatamapping.model.DDMTemplate',4,'20431',20163,20158,15),(398,20154,'com.liferay.portlet.expando.model.ExpandoColumn',4,'20442',20163,0,15),(399,20154,'1_WAR_calendarportlet',1,'20154',20161,0,4),(400,20154,'1_WAR_calendarportlet',1,'20154',20162,0,4),(401,20154,'1_WAR_calendarportlet',1,'20154',20164,0,4),(402,20154,'1_WAR_calendarportlet',1,'20154',20165,0,4),(403,20154,'1_WAR_notificationsportlet',1,'20154',20161,0,2),(404,20154,'1_WAR_notificationsportlet',1,'20154',20162,0,2),(405,20154,'1_WAR_notificationsportlet',1,'20154',20164,0,2),(406,20154,'1_WAR_notificationsportlet',1,'20154',20165,0,2),(407,20154,'2_WAR_opensocialportlet',1,'20154',20161,0,2),(408,20154,'2_WAR_opensocialportlet',1,'20154',20162,0,2),(409,20154,'2_WAR_opensocialportlet',1,'20154',20164,0,2),(410,20154,'2_WAR_opensocialportlet',1,'20154',20165,0,2),(411,20154,'3_WAR_opensocialportlet',1,'20154',20161,0,2),(412,20154,'3_WAR_opensocialportlet',1,'20154',20162,0,2),(413,20154,'3_WAR_opensocialportlet',1,'20154',20164,0,2),(414,20154,'3_WAR_opensocialportlet',1,'20154',20165,0,2),(415,20154,'1_WAR_webformportlet',1,'20154',20161,0,2),(416,20154,'1_WAR_webformportlet',1,'20154',20162,0,2),(417,20154,'1_WAR_webformportlet',1,'20154',20164,0,2),(418,20154,'1_WAR_webformportlet',1,'20154',20165,0,2),(419,20154,'com.liferay.portal.model.Layout',4,'20516',20163,20198,1023),(420,20154,'com.liferay.portal.model.Layout',4,'20522',20163,20198,1023),(421,20154,'com.liferay.portal.model.Layout',4,'20522',20165,0,19),(422,20154,'com.liferay.portal.model.Layout',4,'20522',20162,0,1),(424,20154,'58',4,'20184_LAYOUT_58',20163,0,63),(426,20154,'58',4,'20184_LAYOUT_58',20170,0,1),(428,20154,'58',4,'20184_LAYOUT_58',20162,0,1),(429,20154,'145',4,'20184_LAYOUT_145',20163,0,63),(430,20154,'145',4,'20184_LAYOUT_145',20170,0,1),(431,20154,'145',4,'20184_LAYOUT_145',20162,0,1),(501,20154,'2_WAR_notificationsportlet',4,'20184_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(502,20154,'2_WAR_notificationsportlet',4,'20184_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(503,20154,'2_WAR_notificationsportlet',4,'20184_LAYOUT_2_WAR_notificationsportlet',20162,0,1),(504,20154,'com.liferay.portal.model.Group',4,'20608',20163,0,33554431),(505,20154,'com.liferay.portal.model.Layout',4,'20615',20163,20198,1023),(506,20154,'com.liferay.portal.model.Layout',4,'20615',20170,0,19),(507,20154,'com.liferay.portal.model.Layout',4,'20615',20162,0,1),(508,20154,'com.liferay.portal.model.Layout',4,'20621',20163,20198,1023),(509,20154,'com.liferay.portal.model.Layout',4,'20621',20170,0,19),(510,20154,'com.liferay.portal.model.Layout',4,'20627',20163,20198,1023),(511,20154,'com.liferay.portal.model.Layout',4,'20627',20170,0,19),(512,20154,'com.liferay.portal.model.Layout',4,'20633',20163,20198,1023),(513,20154,'com.liferay.portal.model.Layout',4,'20633',20170,0,19),(514,20154,'com.liferay.portal.model.Layout',4,'20639',20163,20198,1023),(515,20154,'com.liferay.portal.model.Layout',4,'20639',20170,0,19),(516,20154,'com.liferay.portal.model.Layout',4,'20645',20163,20198,1023),(517,20154,'com.liferay.portal.model.Layout',4,'20645',20170,0,19),(518,20154,'com.liferay.portal.model.Layout',4,'20651',20163,20198,1023),(519,20154,'com.liferay.portal.model.Layout',4,'20651',20170,0,19),(520,20154,'com.liferay.portal.model.Layout',4,'20657',20163,20198,1023),(521,20154,'com.liferay.portal.model.Layout',4,'20657',20170,0,19),(522,20154,'com.liferay.portal.model.Layout',4,'20663',20163,20198,1023),(523,20154,'com.liferay.portal.model.Layout',4,'20663',20170,0,19),(524,20154,'com.liferay.portal.model.Layout',4,'20669',20163,20198,1023),(525,20154,'com.liferay.portal.model.Layout',4,'20669',20170,0,19),(526,20154,'com.liferay.portal.model.Layout',4,'20675',20163,20198,1023),(527,20154,'com.liferay.portal.model.Layout',4,'20675',20170,0,19),(528,20154,'com.liferay.portal.model.Layout',4,'20681',20163,20198,1023),(529,20154,'com.liferay.portal.model.Layout',4,'20681',20170,0,19),(530,20154,'com.liferay.portal.model.Layout',4,'20687',20163,20198,1023),(531,20154,'com.liferay.portal.model.Layout',4,'20687',20170,0,19),(532,20154,'com.liferay.portal.model.Layout',4,'20693',20163,20198,1023),(533,20154,'com.liferay.portal.model.Layout',4,'20693',20170,0,19),(534,20154,'com.liferay.portal.model.Layout',4,'20699',20163,20198,1023),(535,20154,'com.liferay.portal.model.Layout',4,'20699',20170,0,19),(536,20154,'145',4,'20621_LAYOUT_145',20163,0,63),(537,20154,'145',4,'20621_LAYOUT_145',20170,0,1),(538,20154,'2_WAR_notificationsportlet',4,'20621_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(539,20154,'2_WAR_notificationsportlet',4,'20621_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(540,20154,'145',4,'20663_LAYOUT_145',20163,0,63),(541,20154,'145',4,'20663_LAYOUT_145',20170,0,1),(542,20154,'2_WAR_notificationsportlet',4,'20663_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(543,20154,'2_WAR_notificationsportlet',4,'20663_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(544,20154,'145',4,'20681_LAYOUT_145',20163,0,63),(545,20154,'145',4,'20681_LAYOUT_145',20170,0,1),(546,20154,'2_WAR_notificationsportlet',4,'20681_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(547,20154,'2_WAR_notificationsportlet',4,'20681_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(548,20154,'145',4,'20687_LAYOUT_145',20163,0,63),(549,20154,'145',4,'20687_LAYOUT_145',20170,0,1),(550,20154,'2_WAR_notificationsportlet',4,'20687_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(551,20154,'2_WAR_notificationsportlet',4,'20687_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(552,20154,'com.liferay.portal.model.Layout',4,'20713',20163,20198,1023),(553,20154,'com.liferay.portal.model.Layout',4,'20713',20170,0,19),(554,20154,'com.liferay.portal.model.Layout',4,'20719',20163,20198,1023),(555,20154,'com.liferay.portal.model.Layout',4,'20719',20170,0,19),(556,20154,'com.liferay.portal.model.Layout',4,'20725',20163,20198,1023),(557,20154,'com.liferay.portal.model.Layout',4,'20725',20170,0,19),(558,20154,'com.liferay.portal.model.Group',4,'20731',20163,0,33554431),(559,20154,'com.liferay.portal.model.Group',4,'20735',20163,0,33554431),(560,20154,'com.liferay.portal.model.Layout',4,'20739',20163,20198,1023),(561,20154,'com.liferay.portal.model.Layout',4,'20739',20170,0,19),(562,20154,'com.liferay.portal.model.Layout',4,'20739',20162,0,1),(563,20154,'com.liferay.portal.model.Layout',4,'20745',20163,20198,1023),(564,20154,'com.liferay.portal.model.Layout',4,'20745',20170,0,19),(565,20154,'com.liferay.portal.model.Layout',4,'20751',20163,20198,1023),(566,20154,'com.liferay.portal.model.Layout',4,'20751',20170,0,19),(567,20154,'com.liferay.portal.model.Layout',4,'20757',20163,20198,1023),(568,20154,'com.liferay.portal.model.Layout',4,'20757',20170,0,19),(569,20154,'com.liferay.portal.model.Layout',4,'20763',20163,20198,1023),(570,20154,'com.liferay.portal.model.Layout',4,'20763',20170,0,19),(571,20154,'com.liferay.portal.model.Layout',4,'20769',20163,20198,1023),(572,20154,'com.liferay.portal.model.Layout',4,'20769',20170,0,19),(573,20154,'com.liferay.portal.model.Layout',4,'20775',20163,20198,1023),(574,20154,'com.liferay.portal.model.Layout',4,'20775',20170,0,19),(575,20154,'com.liferay.portal.model.Layout',4,'20775',20162,0,1),(576,20154,'com.liferay.portlet.journal',4,'20194',20163,0,255),(577,20154,'com.liferay.portlet.journal',4,'20194',20165,0,1),(578,20154,'com.liferay.portlet.journal',4,'20194',20162,0,1),(579,20154,'com.liferay.portal.model.Layout',4,'20783',20163,20198,1023),(580,20154,'com.liferay.portal.model.Layout',4,'20783',20170,0,19),(581,20154,'com.liferay.portal.model.Layout',4,'20789',20163,20198,1023),(582,20154,'com.liferay.portal.model.Layout',4,'20789',20170,0,19),(583,20154,'com.liferay.portal.model.Layout',4,'20795',20163,20198,1023),(584,20154,'com.liferay.portal.model.Layout',4,'20795',20170,0,19),(585,20154,'com.liferay.portal.model.Layout',4,'20801',20163,20198,1023),(586,20154,'com.liferay.portal.model.Layout',4,'20801',20170,0,19),(587,20154,'com.liferay.portal.model.Layout',4,'20807',20163,20198,1023),(588,20154,'com.liferay.portal.model.Layout',4,'20807',20170,0,19),(589,20154,'com.liferay.portal.model.Layout',4,'20813',20163,20198,1023),(590,20154,'com.liferay.portal.model.Layout',4,'20813',20170,0,19),(591,20154,'145',4,'20783_LAYOUT_145',20163,0,63),(592,20154,'145',4,'20783_LAYOUT_145',20170,0,1),(593,20154,'2_WAR_notificationsportlet',4,'20783_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(594,20154,'2_WAR_notificationsportlet',4,'20783_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(595,20154,'com.liferay.portal.model.Layout',4,'20821',20163,20198,1023),(596,20154,'com.liferay.portal.model.Layout',4,'20821',20170,0,19),(597,20154,'com.liferay.portal.model.Layout',4,'20821',20162,0,1),(598,20154,'com.liferay.portlet.journal',4,'20181',20163,0,255),(599,20154,'com.liferay.portlet.journal',4,'20181',20170,0,1),(600,20154,'com.liferay.portlet.journal',4,'20181',20162,0,1),(601,20154,'com.liferay.portlet.documentlibrary',4,'20181',20163,0,1023),(602,20154,'com.liferay.portlet.documentlibrary',4,'20181',20170,0,331),(603,20154,'com.liferay.portlet.documentlibrary',4,'20181',20162,0,1),(606,20154,'184',4,'20184_LAYOUT_184_INSTANCE_MCoV5B8xsCQ3',20163,0,63),(607,20154,'184',4,'20184_LAYOUT_184_INSTANCE_MCoV5B8xsCQ3',20170,0,1),(608,20154,'184',4,'20184_LAYOUT_184_INSTANCE_MCoV5B8xsCQ3',20162,0,1),(609,20154,'145',4,'20739_LAYOUT_145',20163,0,63),(610,20154,'145',4,'20739_LAYOUT_145',20170,0,1),(611,20154,'145',4,'20739_LAYOUT_145',20162,0,1),(612,20154,'2_WAR_notificationsportlet',4,'20739_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(613,20154,'2_WAR_notificationsportlet',4,'20739_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(614,20154,'2_WAR_notificationsportlet',4,'20739_LAYOUT_2_WAR_notificationsportlet',20162,0,1),(615,20154,'com.liferay.portlet.journal',4,'20735',20163,0,255),(616,20154,'com.liferay.portlet.journal',4,'20735',20170,0,1),(617,20154,'com.liferay.portlet.journal',4,'20735',20162,0,1),(618,20154,'com.liferay.portlet.documentlibrary',4,'20735',20163,0,1023),(619,20154,'com.liferay.portlet.documentlibrary',4,'20735',20170,0,331),(620,20154,'com.liferay.portlet.documentlibrary',4,'20735',20162,0,1),(621,20154,'58',4,'20739_LAYOUT_58',20163,0,63),(622,20154,'58',4,'20739_LAYOUT_58',20170,0,1),(623,20154,'58',4,'20739_LAYOUT_58',20162,0,1),(624,20154,'49',4,'20739_LAYOUT_49',20163,0,63),(625,20154,'49',4,'20739_LAYOUT_49',20170,0,1),(626,20154,'49',4,'20739_LAYOUT_49',20162,0,1),(627,20154,'145',4,'20821_LAYOUT_145',20163,0,63),(628,20154,'145',4,'20821_LAYOUT_145',20170,0,1),(629,20154,'145',4,'20821_LAYOUT_145',20162,0,1),(630,20154,'2_WAR_notificationsportlet',4,'20821_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(631,20154,'2_WAR_notificationsportlet',4,'20821_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(632,20154,'2_WAR_notificationsportlet',4,'20821_LAYOUT_2_WAR_notificationsportlet',20162,0,1),(633,20154,'com.liferay.portlet.journal',4,'20731',20163,0,255),(634,20154,'com.liferay.portlet.journal',4,'20731',20170,0,1),(635,20154,'com.liferay.portlet.journal',4,'20731',20162,0,1),(636,20154,'com.liferay.portlet.documentlibrary',4,'20731',20163,0,1023),(637,20154,'com.liferay.portlet.documentlibrary',4,'20731',20170,0,331),(638,20154,'com.liferay.portlet.documentlibrary',4,'20731',20162,0,1),(639,20154,'58',4,'20821_LAYOUT_58',20163,0,63),(640,20154,'58',4,'20821_LAYOUT_58',20170,0,1),(641,20154,'58',4,'20821_LAYOUT_58',20162,0,1),(642,20154,'49',4,'20821_LAYOUT_49',20163,0,63),(643,20154,'49',4,'20821_LAYOUT_49',20170,0,1),(644,20154,'49',4,'20821_LAYOUT_49',20162,0,1),(645,20154,'49',4,'20783_LAYOUT_49',20163,0,63),(646,20154,'49',4,'20783_LAYOUT_49',20170,0,1),(647,20154,'145',4,'20615_LAYOUT_145',20163,0,63),(648,20154,'145',4,'20615_LAYOUT_145',20170,0,1),(649,20154,'145',4,'20615_LAYOUT_145',20162,0,1),(650,20154,'2_WAR_notificationsportlet',4,'20615_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(651,20154,'2_WAR_notificationsportlet',4,'20615_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(652,20154,'2_WAR_notificationsportlet',4,'20615_LAYOUT_2_WAR_notificationsportlet',20162,0,1),(653,20154,'com.liferay.portlet.journal',4,'20608',20163,0,255),(654,20154,'com.liferay.portlet.journal',4,'20608',20170,0,1),(655,20154,'com.liferay.portlet.journal',4,'20608',20162,0,1),(656,20154,'com.liferay.portlet.documentlibrary',4,'20608',20163,0,1023),(657,20154,'com.liferay.portlet.documentlibrary',4,'20608',20170,0,331),(658,20154,'com.liferay.portlet.documentlibrary',4,'20608',20162,0,1),(659,20154,'58',4,'20615_LAYOUT_58',20163,0,63),(660,20154,'58',4,'20615_LAYOUT_58',20170,0,1),(661,20154,'58',4,'20615_LAYOUT_58',20162,0,1),(662,20154,'49',4,'20615_LAYOUT_49',20163,0,63),(663,20154,'49',4,'20615_LAYOUT_49',20170,0,1),(664,20154,'49',4,'20615_LAYOUT_49',20162,0,1),(665,20154,'49',4,'20184_LAYOUT_49',20163,0,63),(666,20154,'49',4,'20184_LAYOUT_49',20170,0,1),(667,20154,'49',4,'20184_LAYOUT_49',20162,0,1),(668,20154,'com.liferay.portlet.documentlibrary.model.DLFolder',4,'20848',20163,20158,255),(669,20154,'com.liferay.portlet.documentlibrary.model.DLFolder',4,'20848',20165,0,29),(670,20154,'com.liferay.portlet.documentlibrary.model.DLFolder',4,'20848',20162,0,1),(671,20154,'com.liferay.portlet.documentlibrary.model.DLFolder',4,'20849',20163,20198,255),(672,20154,'com.liferay.portlet.documentlibrary.model.DLFolder',4,'20849',20165,0,29),(673,20154,'com.liferay.portlet.documentlibrary.model.DLFolder',4,'20849',20162,0,1),(674,20154,'com.liferay.portlet.documentlibrary.model.DLFolder',4,'20850',20163,20198,255),(675,20154,'com.liferay.portlet.documentlibrary.model.DLFolder',4,'20850',20165,0,29),(676,20154,'com.liferay.portlet.documentlibrary.model.DLFolder',4,'20850',20162,0,1),(678,20154,'com.liferay.portlet.documentlibrary.model.DLFolder',4,'20852',20163,20198,255),(679,20154,'com.liferay.portlet.documentlibrary.model.DLFolder',4,'20852',20165,0,29),(680,20154,'com.liferay.portlet.documentlibrary.model.DLFolder',4,'20852',20162,0,1),(681,20154,'com.liferay.portal.model.Group',4,'20856',20163,0,33554431),(682,20154,'com.liferay.portal.model.Organization',4,'20855',20163,20198,2047),(683,20154,'com.liferay.portal.model.Group',4,'20862',20163,0,33554431),(684,20154,'com.liferay.portal.model.Organization',4,'20861',20163,20198,2047),(685,20154,'com.liferay.portal.model.Group',4,'20868',20163,0,33554431),(686,20154,'com.liferay.portal.model.Organization',4,'20867',20163,20198,2047),(687,20154,'com.liferay.portal.model.Group',4,'20874',20163,0,33554431),(688,20154,'com.liferay.portal.model.Organization',4,'20873',20163,20198,2047),(689,20154,'com.liferay.portal.model.Group',4,'20882',20163,0,33554431),(690,20154,'com.liferay.portal.model.Organization',4,'20881',20163,20198,2047),(691,20154,'com.liferay.portal.model.Group',4,'20888',20163,0,33554431),(692,20154,'com.liferay.portal.model.Organization',4,'20887',20163,20198,2047),(693,20154,'com.liferay.portal.model.Group',4,'20894',20163,0,33554431),(694,20154,'com.liferay.portal.model.Organization',4,'20893',20163,20198,2047),(695,20154,'com.liferay.portal.model.Group',4,'20900',20163,0,33554431),(696,20154,'com.liferay.portal.model.Organization',4,'20899',20163,20198,2047),(697,20154,'com.liferay.portal.model.Group',4,'20906',20163,0,33554431),(698,20154,'com.liferay.portal.model.Organization',4,'20905',20163,20198,2047),(699,20154,'com.liferay.portal.model.Group',4,'20912',20163,0,33554431),(700,20154,'com.liferay.portal.model.Organization',4,'20911',20163,20198,2047),(701,20154,'145',4,'20627_LAYOUT_145',20163,0,63),(702,20154,'145',4,'20627_LAYOUT_145',20170,0,1),(703,20154,'2_WAR_notificationsportlet',4,'20627_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(704,20154,'2_WAR_notificationsportlet',4,'20627_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(705,20154,'145',4,'20645_LAYOUT_145',20163,0,63),(706,20154,'145',4,'20645_LAYOUT_145',20170,0,1),(707,20154,'2_WAR_notificationsportlet',4,'20645_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(708,20154,'2_WAR_notificationsportlet',4,'20645_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(709,20154,'145',4,'20657_LAYOUT_145',20163,0,63),(710,20154,'145',4,'20657_LAYOUT_145',20170,0,1),(711,20154,'2_WAR_notificationsportlet',4,'20657_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(712,20154,'2_WAR_notificationsportlet',4,'20657_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(713,20154,'145',4,'20669_LAYOUT_145',20163,0,63),(714,20154,'145',4,'20669_LAYOUT_145',20170,0,1),(715,20154,'2_WAR_notificationsportlet',4,'20669_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(716,20154,'2_WAR_notificationsportlet',4,'20669_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(717,20154,'145',4,'20719_LAYOUT_145',20163,0,63),(718,20154,'145',4,'20719_LAYOUT_145',20170,0,1),(719,20154,'2_WAR_notificationsportlet',4,'20719_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(720,20154,'2_WAR_notificationsportlet',4,'20719_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(721,20154,'145',4,'20725_LAYOUT_145',20163,0,63),(722,20154,'145',4,'20725_LAYOUT_145',20170,0,1),(723,20154,'2_WAR_notificationsportlet',4,'20725_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(724,20154,'2_WAR_notificationsportlet',4,'20725_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(725,20154,'49',4,'20621_LAYOUT_49',20163,0,63),(726,20154,'49',4,'20621_LAYOUT_49',20170,0,1),(727,20154,'145',4,'20633_LAYOUT_145',20163,0,63),(728,20154,'145',4,'20633_LAYOUT_145',20170,0,1),(729,20154,'2_WAR_notificationsportlet',4,'20633_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(730,20154,'2_WAR_notificationsportlet',4,'20633_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(731,20154,'145',4,'20639_LAYOUT_145',20163,0,63),(732,20154,'145',4,'20639_LAYOUT_145',20170,0,1),(733,20154,'2_WAR_notificationsportlet',4,'20639_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(734,20154,'2_WAR_notificationsportlet',4,'20639_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(735,20154,'145',4,'20693_LAYOUT_145',20163,0,63),(736,20154,'145',4,'20693_LAYOUT_145',20170,0,1),(737,20154,'2_WAR_notificationsportlet',4,'20693_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(738,20154,'2_WAR_notificationsportlet',4,'20693_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(739,20154,'145',4,'20699_LAYOUT_145',20163,0,63),(740,20154,'145',4,'20699_LAYOUT_145',20170,0,1),(741,20154,'2_WAR_notificationsportlet',4,'20699_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(742,20154,'2_WAR_notificationsportlet',4,'20699_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(743,20154,'com.liferay.portal.model.Role',4,'20938',20163,20198,127),(744,20154,'com.liferay.portal.model.User',4,'20939',20163,20198,31),(801,20154,'29',4,'20516_LAYOUT_29',20163,0,63),(802,20154,'23',4,'20516_LAYOUT_23',20163,0,63),(803,20154,'82',4,'20516_LAYOUT_82',20163,0,63),(804,20154,'11',4,'20516_LAYOUT_11',20163,0,63),(805,20154,'29',4,'20516_LAYOUT_29',20165,0,1),(806,20154,'82',4,'20516_LAYOUT_82',20165,0,1),(807,20154,'23',4,'20516_LAYOUT_23',20165,0,1),(808,20154,'145',4,'20516_LAYOUT_145',20163,0,63),(809,20154,'145',4,'20516_LAYOUT_145',20165,0,1),(810,20154,'2_WAR_notificationsportlet',4,'20516_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(811,20154,'2_WAR_notificationsportlet',4,'20516_LAYOUT_2_WAR_notificationsportlet',20165,0,1),(812,20154,'145',4,'20713_LAYOUT_145',20163,0,63),(813,20154,'145',4,'20713_LAYOUT_145',20170,0,1),(814,20154,'2_WAR_notificationsportlet',4,'20713_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(815,20154,'2_WAR_notificationsportlet',4,'20713_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(816,20154,'dictionary_WAR_sysportlet',1,'20154',20161,0,2),(817,20154,'dictionary_WAR_sysportlet',1,'20154',20162,0,2),(818,20154,'dictionary_WAR_sysportlet',1,'20154',20164,0,2),(819,20154,'dictionary_WAR_sysportlet',1,'20154',20165,0,2),(820,20154,'dictionary_WAR_sysportlet',4,'20725_LAYOUT_dictionary_WAR_sysportlet',20163,0,63),(821,20154,'dictionary_WAR_sysportlet',4,'20725_LAYOUT_dictionary_WAR_sysportlet',20170,0,1),(822,20154,'49',4,'20725_LAYOUT_49',20163,0,63),(823,20154,'49',4,'20725_LAYOUT_49',20170,0,1),(901,20154,'leaderweeklywork_WAR_oaportlet',1,'20154',20161,0,2),(902,20154,'leaderweeklywork_WAR_oaportlet',1,'20154',20162,0,2),(903,20154,'leaderweeklywork_WAR_oaportlet',1,'20154',20164,0,2),(904,20154,'leaderweeklywork_WAR_oaportlet',1,'20154',20165,0,2),(905,20154,'officesupply_WAR_oaportlet',1,'20154',20161,0,2),(906,20154,'officesupply_WAR_oaportlet',1,'20154',20162,0,2),(907,20154,'officesupply_WAR_oaportlet',1,'20154',20164,0,2),(908,20154,'officesupply_WAR_oaportlet',1,'20154',20165,0,2),(909,20154,'vehiclerequisition_WAR_oaportlet',1,'20154',20161,0,2),(910,20154,'vehiclerequisition_WAR_oaportlet',1,'20154',20162,0,2),(911,20154,'vehiclerequisition_WAR_oaportlet',1,'20154',20164,0,2),(912,20154,'vehiclerequisition_WAR_oaportlet',1,'20154',20165,0,2),(913,20154,'senddispatch_WAR_oaportlet',1,'20154',20161,0,2),(914,20154,'senddispatch_WAR_oaportlet',1,'20154',20162,0,2),(915,20154,'senddispatch_WAR_oaportlet',1,'20154',20164,0,2),(916,20154,'senddispatch_WAR_oaportlet',1,'20154',20165,0,2),(917,20154,'deptweeklywork_WAR_oaportlet',1,'20154',20161,0,2),(918,20154,'deptweeklywork_WAR_oaportlet',1,'20154',20162,0,2),(919,20154,'deptweeklywork_WAR_oaportlet',1,'20154',20164,0,2),(920,20154,'deptweeklywork_WAR_oaportlet',1,'20154',20165,0,2),(921,20154,'leaderweeklywork_WAR_oaportlet',4,'20645_LAYOUT_leaderweeklywork_WAR_oaportlet',20163,0,63),(922,20154,'leaderweeklywork_WAR_oaportlet',4,'20645_LAYOUT_leaderweeklywork_WAR_oaportlet',20170,0,1),(923,20154,'vehiclerequisition_WAR_oaportlet',4,'20657_LAYOUT_vehiclerequisition_WAR_oaportlet',20163,0,63),(924,20154,'vehiclerequisition_WAR_oaportlet',4,'20657_LAYOUT_vehiclerequisition_WAR_oaportlet',20170,0,1),(925,20154,'145',4,'20675_LAYOUT_145',20163,0,63),(926,20154,'145',4,'20675_LAYOUT_145',20170,0,1),(927,20154,'2_WAR_notificationsportlet',4,'20675_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(928,20154,'2_WAR_notificationsportlet',4,'20675_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(929,20154,'senddispatch_WAR_oaportlet',4,'20719_LAYOUT_senddispatch_WAR_oaportlet',20163,0,63),(930,20154,'senddispatch_WAR_oaportlet',4,'20719_LAYOUT_senddispatch_WAR_oaportlet',20170,0,1),(931,20154,'officesupply_WAR_oaportlet',4,'20669_LAYOUT_officesupply_WAR_oaportlet',20163,0,63),(932,20154,'officesupply_WAR_oaportlet',4,'20669_LAYOUT_officesupply_WAR_oaportlet',20170,0,1),(933,20154,'49',4,'20669_LAYOUT_49',20163,0,63),(934,20154,'49',4,'20669_LAYOUT_49',20170,0,1),(935,20154,'145',4,'20813_LAYOUT_145',20163,0,63),(936,20154,'145',4,'20813_LAYOUT_145',20170,0,1),(937,20154,'2_WAR_notificationsportlet',4,'20813_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(938,20154,'2_WAR_notificationsportlet',4,'20813_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(939,20154,'dictionary_WAR_sysportlet',4,'20813_LAYOUT_dictionary_WAR_sysportlet',20163,0,63),(940,20154,'dictionary_WAR_sysportlet',4,'20813_LAYOUT_dictionary_WAR_sysportlet',20170,0,1),(941,20154,'145',4,'20807_LAYOUT_145',20163,0,63),(942,20154,'145',4,'20807_LAYOUT_145',20170,0,1),(943,20154,'2_WAR_notificationsportlet',4,'20807_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(944,20154,'2_WAR_notificationsportlet',4,'20807_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(945,20154,'145',4,'20801_LAYOUT_145',20163,0,63),(946,20154,'145',4,'20801_LAYOUT_145',20170,0,1),(947,20154,'2_WAR_notificationsportlet',4,'20801_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(948,20154,'2_WAR_notificationsportlet',4,'20801_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(949,20154,'com.liferay.portal.model.Layout',4,'21138',20163,20198,1023),(950,20154,'com.liferay.portal.model.Layout',4,'21138',20170,0,19),(951,20154,'com.liferay.portal.model.Layout',4,'21144',20163,20198,1023),(952,20154,'com.liferay.portal.model.Layout',4,'21144',20170,0,19),(953,20154,'com.liferay.portal.model.Layout',4,'21150',20163,20198,1023),(954,20154,'com.liferay.portal.model.Layout',4,'21150',20170,0,19),(955,20154,'com.liferay.portal.model.Layout',4,'21156',20163,20198,1023),(956,20154,'com.liferay.portal.model.Layout',4,'21156',20170,0,19),(957,20154,'145',4,'21156_LAYOUT_145',20163,0,63),(958,20154,'145',4,'21156_LAYOUT_145',20170,0,1),(959,20154,'2_WAR_notificationsportlet',4,'21156_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(960,20154,'2_WAR_notificationsportlet',4,'21156_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(961,20154,'145',4,'20789_LAYOUT_145',20163,0,63),(962,20154,'145',4,'20789_LAYOUT_145',20170,0,1),(963,20154,'2_WAR_notificationsportlet',4,'20789_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(964,20154,'2_WAR_notificationsportlet',4,'20789_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(965,20154,'145',4,'20795_LAYOUT_145',20163,0,63),(966,20154,'145',4,'20795_LAYOUT_145',20170,0,1),(967,20154,'2_WAR_notificationsportlet',4,'20795_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(968,20154,'2_WAR_notificationsportlet',4,'20795_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(969,20154,'49',4,'20789_LAYOUT_49',20163,0,63),(970,20154,'49',4,'20789_LAYOUT_49',20170,0,1),(971,20154,'49',4,'20813_LAYOUT_49',20163,0,63),(972,20154,'49',4,'20813_LAYOUT_49',20170,0,1),(973,20154,'86',4,'20645_LAYOUT_86',20163,0,63),(974,20154,'86',4,'20645_LAYOUT_86',20170,0,1),(975,20154,'com.liferay.portal.model.Layout',4,'21168',20163,20939,1023),(976,20154,'com.liferay.portal.model.Layout',4,'21174',20163,20939,1023),(977,20154,'com.liferay.portal.model.Layout',4,'21174',20165,0,19),(978,20154,'com.liferay.portal.model.Layout',4,'21174',20162,0,1),(979,20154,'145',4,'21138_LAYOUT_145',20163,0,63),(980,20154,'145',4,'21138_LAYOUT_145',20170,0,1),(981,20154,'2_WAR_notificationsportlet',4,'21138_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(982,20154,'2_WAR_notificationsportlet',4,'21138_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(983,20154,'145',4,'21144_LAYOUT_145',20163,0,63),(984,20154,'145',4,'21144_LAYOUT_145',20170,0,1),(985,20154,'2_WAR_notificationsportlet',4,'21144_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(986,20154,'2_WAR_notificationsportlet',4,'21144_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(987,20154,'49',4,'20801_LAYOUT_49',20163,0,63),(988,20154,'49',4,'20801_LAYOUT_49',20170,0,1),(989,20154,'145',4,'20745_LAYOUT_145',20163,0,63),(990,20154,'145',4,'20745_LAYOUT_145',20170,0,1),(991,20154,'2_WAR_notificationsportlet',4,'20745_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(992,20154,'2_WAR_notificationsportlet',4,'20745_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(993,20154,'49',4,'20745_LAYOUT_49',20163,0,63),(994,20154,'49',4,'20745_LAYOUT_49',20170,0,1),(995,20154,'145',4,'20775_LAYOUT_145',20163,0,63),(996,20154,'145',4,'20775_LAYOUT_145',20170,0,1),(997,20154,'145',4,'20775_LAYOUT_145',20162,0,1),(998,20154,'2_WAR_notificationsportlet',4,'20775_LAYOUT_2_WAR_notificationsportlet',20163,0,63),(999,20154,'2_WAR_notificationsportlet',4,'20775_LAYOUT_2_WAR_notificationsportlet',20170,0,1),(1000,20154,'2_WAR_notificationsportlet',4,'20775_LAYOUT_2_WAR_notificationsportlet',20162,0,1);
/*!40000 ALTER TABLE `resourcepermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resourcetypepermission`
--

DROP TABLE IF EXISTS `resourcetypepermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resourcetypepermission` (
  `resourceTypePermissionId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `roleId` bigint(20) DEFAULT NULL,
  `actionIds` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`resourceTypePermissionId`),
  UNIQUE KEY `IX_BA497163` (`companyId`,`groupId`,`name`,`roleId`),
  KEY `IX_7D81F66F` (`companyId`,`name`,`roleId`),
  KEY `IX_A82690E2` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resourcetypepermission`
--

LOCK TABLES `resourcetypepermission` WRITE;
/*!40000 ALTER TABLE `resourcetypepermission` DISABLE KEYS */;
/*!40000 ALTER TABLE `resourcetypepermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_`
--

DROP TABLE IF EXISTS `role_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_` (
  `uuid_` varchar(75) DEFAULT NULL,
  `roleId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `title` longtext,
  `description` longtext,
  `type_` int(11) DEFAULT NULL,
  `subtype` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `IX_A88E424E` (`companyId`,`classNameId`,`classPK`),
  UNIQUE KEY `IX_EBC931B8` (`companyId`,`name`),
  KEY `IX_449A10B9` (`companyId`),
  KEY `IX_F3E1C6FC` (`companyId`,`type_`),
  KEY `IX_F436EC8E` (`name`),
  KEY `IX_5EB4E2FB` (`subtype`),
  KEY `IX_F92B66E6` (`type_`),
  KEY `IX_CBE204` (`type_`,`subtype`),
  KEY `IX_26DB26C5` (`uuid_`),
  KEY `IX_B9FF6043` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_`
--

LOCK TABLES `role_` WRITE;
/*!40000 ALTER TABLE `role_` DISABLE KEYS */;
INSERT INTO `role_` VALUES ('a83b5749-ac9c-4248-b70c-f1d6d7d20b40',20161,20154,20158,'','2016-06-30 20:51:57','2016-06-30 20:51:57',20004,20161,'Administrator','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Administrators are super users who can do anything.</Description></root>',1,''),('5241ffb8-443c-4210-a496-20f36349f887',20162,20154,20158,'','2016-06-30 20:51:57','2016-06-30 20:51:57',20004,20162,'Guest','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Unauthenticated users always have this role.</Description></root>',1,''),('7cf9dd52-c329-4e04-8575-daad97bbc28d',20163,20154,20158,'','2016-06-30 20:51:57','2016-06-30 20:51:57',20004,20163,'Owner','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">This is an implied role with respect to the objects users create.</Description></root>',1,''),('84e73cf7-489b-42db-a52f-3544cc579aff',20164,20154,20158,'','2016-06-30 20:51:57','2016-06-30 20:51:57',20004,20164,'Power User','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Power Users have their own personal site.</Description></root>',1,''),('3709b8ad-7894-4ca0-8271-4793df104430',20165,20154,20158,'','2016-06-30 20:51:57','2016-06-30 20:51:57',20004,20165,'User','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Authenticated users should be assigned this role.</Description></root>',1,''),('38d2f5cc-8817-448a-a927-4b7292f29065',20166,20154,20158,'','2016-06-30 20:51:57','2016-06-30 20:51:57',20004,20166,'Organization Administrator','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Organization Administrators are super users of their organization but cannot make other users into Organization Administrators.</Description></root>',3,''),('e3e376a2-617d-4f11-83ec-07db1363dae3',20167,20154,20158,'','2016-06-30 20:51:57','2016-06-30 20:51:57',20004,20167,'Organization Owner','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Organization Owners are super users of their organization and can assign organization roles to users.</Description></root>',3,''),('018604e6-e6b8-4491-b5a4-14a00098c530',20168,20154,20158,'','2016-06-30 20:51:58','2016-06-30 20:51:58',20004,20168,'Organization User','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">All users who belong to an organization have this role within that organization.</Description></root>',3,''),('a4351c84-7a41-4285-83d3-13e300bf8545',20169,20154,20158,'','2016-06-30 20:51:58','2016-06-30 20:51:58',20004,20169,'Site Administrator','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Site Administrators are super users of their site but cannot make other users into Site Administrators.</Description></root>',2,''),('008de444-20d8-4bea-9b0e-7355a0358508',20170,20154,20158,'','2016-06-30 20:51:58','2016-06-30 20:51:58',20004,20170,'Site Member','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">All users who belong to a site have this role within that site.</Description></root>',2,''),('7c6979c0-b141-4a9c-b63d-7e665c77de04',20171,20154,20158,'','2016-06-30 20:51:58','2016-06-30 20:51:58',20004,20171,'Site Owner','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Site Owners are super users of their site and can assign site roles to users.</Description></root>',2,''),('148c27cf-50de-4bfb-8a39-267e787fe474',20486,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24',20004,20486,'Organization Content Reviewer','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Autogenerated role from workflow definition</Description></root>',3,''),('3fd2468f-e6e0-46d0-af58-eab956ab4328',20488,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24',20004,20488,'Site Content Reviewer','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Autogenerated role from workflow definition</Description></root>',2,''),('fff9cb14-df64-457c-8d7a-67a94dfdfffa',20490,20154,20158,'','2016-06-30 20:53:24','2016-06-30 20:53:24',20004,20490,'Portal Content Reviewer','','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Autogenerated role from workflow definition</Description></root>',1,''),('4ae0f97b-72f2-4928-8805-f4457853dc29',20938,20154,20198,'Test Test','2016-07-01 14:48:28','2016-07-01 14:49:03',20004,20938,'中心领导','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Title language-id=\"zh_CN\">中心领导</Title></root>','<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"zh_CN\" default-locale=\"zh_CN\"><Description language-id=\"zh_CN\">上海市交通建设工程管理中心中心领导</Description></root>',3,'');
/*!40000 ALTER TABLE `role_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scframeworkversi_scproductvers`
--

DROP TABLE IF EXISTS `scframeworkversi_scproductvers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scframeworkversi_scproductvers` (
  `frameworkVersionId` bigint(20) NOT NULL,
  `productVersionId` bigint(20) NOT NULL,
  PRIMARY KEY (`frameworkVersionId`,`productVersionId`),
  KEY `IX_3BB93ECA` (`frameworkVersionId`),
  KEY `IX_E8D33FF9` (`productVersionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scframeworkversi_scproductvers`
--

LOCK TABLES `scframeworkversi_scproductvers` WRITE;
/*!40000 ALTER TABLE `scframeworkversi_scproductvers` DISABLE KEYS */;
/*!40000 ALTER TABLE `scframeworkversi_scproductvers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scframeworkversion`
--

DROP TABLE IF EXISTS `scframeworkversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scframeworkversion` (
  `frameworkVersionId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `url` longtext,
  `active_` tinyint(4) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`frameworkVersionId`),
  KEY `IX_C98C0D78` (`companyId`),
  KEY `IX_272991FA` (`groupId`),
  KEY `IX_6E1764F` (`groupId`,`active_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scframeworkversion`
--

LOCK TABLES `scframeworkversion` WRITE;
/*!40000 ALTER TABLE `scframeworkversion` DISABLE KEYS */;
/*!40000 ALTER TABLE `scframeworkversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sclicense`
--

DROP TABLE IF EXISTS `sclicense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sclicense` (
  `licenseId` bigint(20) NOT NULL,
  `name` varchar(75) DEFAULT NULL,
  `url` longtext,
  `openSource` tinyint(4) DEFAULT NULL,
  `active_` tinyint(4) DEFAULT NULL,
  `recommended` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`licenseId`),
  KEY `IX_1C841592` (`active_`),
  KEY `IX_5327BB79` (`active_`,`recommended`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sclicense`
--

LOCK TABLES `sclicense` WRITE;
/*!40000 ALTER TABLE `sclicense` DISABLE KEYS */;
/*!40000 ALTER TABLE `sclicense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sclicenses_scproductentries`
--

DROP TABLE IF EXISTS `sclicenses_scproductentries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sclicenses_scproductentries` (
  `licenseId` bigint(20) NOT NULL,
  `productEntryId` bigint(20) NOT NULL,
  PRIMARY KEY (`licenseId`,`productEntryId`),
  KEY `IX_27006638` (`licenseId`),
  KEY `IX_D7710A66` (`productEntryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sclicenses_scproductentries`
--

LOCK TABLES `sclicenses_scproductentries` WRITE;
/*!40000 ALTER TABLE `sclicenses_scproductentries` DISABLE KEYS */;
/*!40000 ALTER TABLE `sclicenses_scproductentries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scproductentry`
--

DROP TABLE IF EXISTS `scproductentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scproductentry` (
  `productEntryId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `type_` varchar(75) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `shortDescription` longtext,
  `longDescription` longtext,
  `pageURL` longtext,
  `author` varchar(75) DEFAULT NULL,
  `repoGroupId` varchar(75) DEFAULT NULL,
  `repoArtifactId` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`productEntryId`),
  KEY `IX_5D25244F` (`companyId`),
  KEY `IX_72F87291` (`groupId`),
  KEY `IX_98E6A9CB` (`groupId`,`userId`),
  KEY `IX_7311E812` (`repoGroupId`,`repoArtifactId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scproductentry`
--

LOCK TABLES `scproductentry` WRITE;
/*!40000 ALTER TABLE `scproductentry` DISABLE KEYS */;
/*!40000 ALTER TABLE `scproductentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scproductscreenshot`
--

DROP TABLE IF EXISTS `scproductscreenshot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scproductscreenshot` (
  `productScreenshotId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `productEntryId` bigint(20) DEFAULT NULL,
  `thumbnailId` bigint(20) DEFAULT NULL,
  `fullImageId` bigint(20) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`productScreenshotId`),
  KEY `IX_AE8224CC` (`fullImageId`),
  KEY `IX_467956FD` (`productEntryId`),
  KEY `IX_DA913A55` (`productEntryId`,`priority`),
  KEY `IX_6C572DAC` (`thumbnailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scproductscreenshot`
--

LOCK TABLES `scproductscreenshot` WRITE;
/*!40000 ALTER TABLE `scproductscreenshot` DISABLE KEYS */;
/*!40000 ALTER TABLE `scproductscreenshot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scproductversion`
--

DROP TABLE IF EXISTS `scproductversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scproductversion` (
  `productVersionId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `productEntryId` bigint(20) DEFAULT NULL,
  `version` varchar(75) DEFAULT NULL,
  `changeLog` longtext,
  `downloadPageURL` longtext,
  `directDownloadURL` varchar(2000) DEFAULT NULL,
  `repoStoreArtifact` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`productVersionId`),
  KEY `IX_8377A211` (`productEntryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scproductversion`
--

LOCK TABLES `scproductversion` WRITE;
/*!40000 ALTER TABLE `scproductversion` DISABLE KEYS */;
/*!40000 ALTER TABLE `scproductversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicecomponent`
--

DROP TABLE IF EXISTS `servicecomponent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicecomponent` (
  `serviceComponentId` bigint(20) NOT NULL,
  `buildNamespace` varchar(75) DEFAULT NULL,
  `buildNumber` bigint(20) DEFAULT NULL,
  `buildDate` bigint(20) DEFAULT NULL,
  `data_` longtext,
  PRIMARY KEY (`serviceComponentId`),
  UNIQUE KEY `IX_4F0315B8` (`buildNamespace`,`buildNumber`),
  KEY `IX_7338606F` (`buildNamespace`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicecomponent`
--

LOCK TABLES `servicecomponent` WRITE;
/*!40000 ALTER TABLE `servicecomponent` DISABLE KEYS */;
INSERT INTO `servicecomponent` VALUES (20439,'Marketplace',4,1410828214125,'<?xml version=\"1.0\"?>\n\n<data>\n	<tables-sql><![CDATA[create table Marketplace_App (\n	uuid_ VARCHAR(75) null,\n	appId LONG not null primary key,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	remoteAppId LONG,\n	title VARCHAR(75) null,\n	description STRING null,\n	category VARCHAR(75) null,\n	iconURL STRING null,\n	version VARCHAR(75) null\n);\n\ncreate table Marketplace_Module (\n	uuid_ VARCHAR(75) null,\n	moduleId LONG not null primary key,\n	appId LONG,\n	bundleSymbolicName VARCHAR(500) null,\n	bundleVersion VARCHAR(75) null,\n	contextName VARCHAR(75) null\n);]]></tables-sql>\n	<sequences-sql><![CDATA[]]></sequences-sql>\n	<indexes-sql><![CDATA[create index IX_94A7EF25 on Marketplace_App (category);\ncreate index IX_865B7BD5 on Marketplace_App (companyId);\ncreate index IX_20F14D93 on Marketplace_App (remoteAppId);\ncreate index IX_3E667FE1 on Marketplace_App (uuid_);\ncreate index IX_A7807DA7 on Marketplace_App (uuid_, companyId);\n\ncreate index IX_7DC16D26 on Marketplace_Module (appId);\ncreate index IX_5848F52D on Marketplace_Module (appId, bundleSymbolicName, bundleVersion);\ncreate index IX_C6938724 on Marketplace_Module (appId, contextName);\ncreate index IX_DD03D499 on Marketplace_Module (bundleSymbolicName);\ncreate index IX_F2F1E964 on Marketplace_Module (contextName);\ncreate index IX_A7EFD80E on Marketplace_Module (uuid_);]]></indexes-sql>\n</data>'),(20447,'Calendar',4,1424703239325,'<?xml version=\"1.0\"?>\n\n<data>\n	<tables-sql><![CDATA[create table Calendar (\n	uuid_ VARCHAR(75) null,\n	calendarId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	resourceBlockId LONG,\n	calendarResourceId LONG,\n	name STRING null,\n	description STRING null,\n	timeZoneId VARCHAR(75) null,\n	color INTEGER,\n	defaultCalendar BOOLEAN,\n	enableComments BOOLEAN,\n	enableRatings BOOLEAN\n);\n\ncreate table CalendarBooking (\n	uuid_ VARCHAR(75) null,\n	calendarBookingId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	resourceBlockId LONG,\n	calendarId LONG,\n	calendarResourceId LONG,\n	parentCalendarBookingId LONG,\n	vEventUid VARCHAR(255) null,\n	title STRING null,\n	description TEXT null,\n	location STRING null,\n	startTime LONG,\n	endTime LONG,\n	allDay BOOLEAN,\n	recurrence STRING null,\n	firstReminder LONG,\n	firstReminderType VARCHAR(75) null,\n	secondReminder LONG,\n	secondReminderType VARCHAR(75) null,\n	status INTEGER,\n	statusByUserId LONG,\n	statusByUserName VARCHAR(75) null,\n	statusDate DATE null\n);\n\ncreate table CalendarNotificationTemplate (\n	uuid_ VARCHAR(75) null,\n	calendarNotificationTemplateId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	calendarId LONG,\n	notificationType VARCHAR(75) null,\n	notificationTypeSettings VARCHAR(75) null,\n	notificationTemplateType VARCHAR(75) null,\n	subject VARCHAR(75) null,\n	body TEXT null\n);\n\ncreate table CalendarResource (\n	uuid_ VARCHAR(75) null,\n	calendarResourceId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	resourceBlockId LONG,\n	classNameId LONG,\n	classPK LONG,\n	classUuid VARCHAR(75) null,\n	code_ VARCHAR(75) null,\n	name STRING null,\n	description STRING null,\n	active_ BOOLEAN\n);]]></tables-sql>\n	<sequences-sql><![CDATA[]]></sequences-sql>\n	<indexes-sql><![CDATA[create index IX_B53EB0E1 on Calendar (groupId, calendarResourceId);\ncreate index IX_97FC174E on Calendar (groupId, calendarResourceId, defaultCalendar);\ncreate index IX_F0FAF226 on Calendar (resourceBlockId);\ncreate index IX_96C8590 on Calendar (uuid_);\ncreate index IX_97656498 on Calendar (uuid_, companyId);\ncreate unique index IX_3AE311A on Calendar (uuid_, groupId);\n\ncreate index IX_D300DFCE on CalendarBooking (calendarId);\ncreate unique index IX_113A264E on CalendarBooking (calendarId, parentCalendarBookingId);\ncreate index IX_470170B4 on CalendarBooking (calendarId, status);\ncreate unique index IX_8B23DA0E on CalendarBooking (calendarId, vEventUid);\ncreate index IX_B198FFC on CalendarBooking (calendarResourceId);\ncreate index IX_57EBF55B on CalendarBooking (parentCalendarBookingId);\ncreate index IX_F7B8A941 on CalendarBooking (parentCalendarBookingId, status);\ncreate index IX_22DFDB49 on CalendarBooking (resourceBlockId);\ncreate index IX_F6E8EE73 on CalendarBooking (uuid_);\ncreate index IX_A21D9FD5 on CalendarBooking (uuid_, companyId);\ncreate unique index IX_F4C61797 on CalendarBooking (uuid_, groupId);\n\ncreate index IX_A412E5B6 on CalendarNotificationTemplate (calendarId);\ncreate index IX_7727A482 on CalendarNotificationTemplate (calendarId, notificationType, notificationTemplateType);\ncreate index IX_A2D4D78B on CalendarNotificationTemplate (uuid_);\ncreate index IX_4D7D97BD on CalendarNotificationTemplate (uuid_, companyId);\ncreate unique index IX_4012E97F on CalendarNotificationTemplate (uuid_, groupId);\n\ncreate index IX_76DDD0F7 on CalendarResource (active_);\ncreate unique index IX_16A12327 on CalendarResource (classNameId, classPK);\ncreate index IX_4470A59D on CalendarResource (companyId, code_, active_);\ncreate index IX_1243D698 on CalendarResource (groupId);\ncreate index IX_40678371 on CalendarResource (groupId, active_);\ncreate index IX_55C2F8AA on CalendarResource (groupId, code_);\ncreate index IX_8BCB4D38 on CalendarResource (resourceBlockId);\ncreate index IX_150E2F22 on CalendarResource (uuid_);\ncreate index IX_56A06BC6 on CalendarResource (uuid_, companyId);\ncreate unique index IX_4ABD2BC8 on CalendarResource (uuid_, groupId);]]></indexes-sql>\n</data>'),(20466,'Kaleo',8,1425595080483,'<?xml version=\"1.0\"?>\n\n<data>\n	<tables-sql><![CDATA[create table KaleoAction (\n	kaleoActionId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoClassName VARCHAR(200) null,\n	kaleoClassPK LONG,\n	kaleoDefinitionId LONG,\n	kaleoNodeName VARCHAR(200) null,\n	name VARCHAR(200) null,\n	description STRING null,\n	executionType VARCHAR(20) null,\n	script TEXT null,\n	scriptLanguage VARCHAR(75) null,\n	scriptRequiredContexts STRING null,\n	priority INTEGER\n);\n\ncreate table KaleoCondition (\n	kaleoConditionId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoDefinitionId LONG,\n	kaleoNodeId LONG,\n	script TEXT null,\n	scriptLanguage VARCHAR(75) null,\n	scriptRequiredContexts STRING null\n);\n\ncreate table KaleoDefinition (\n	kaleoDefinitionId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	name VARCHAR(200) null,\n	title STRING null,\n	description STRING null,\n	content TEXT null,\n	version INTEGER,\n	active_ BOOLEAN,\n	startKaleoNodeId LONG\n);\n\ncreate table KaleoInstance (\n	kaleoInstanceId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoDefinitionId LONG,\n	kaleoDefinitionName VARCHAR(200) null,\n	kaleoDefinitionVersion INTEGER,\n	rootKaleoInstanceTokenId LONG,\n	className VARCHAR(200) null,\n	classPK LONG,\n	completed BOOLEAN,\n	completionDate DATE null,\n	workflowContext TEXT null\n);\n\ncreate table KaleoInstanceToken (\n	kaleoInstanceTokenId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoDefinitionId LONG,\n	kaleoInstanceId LONG,\n	parentKaleoInstanceTokenId LONG,\n	currentKaleoNodeId LONG,\n	currentKaleoNodeName VARCHAR(200) null,\n	className VARCHAR(200) null,\n	classPK LONG,\n	completed BOOLEAN,\n	completionDate DATE null\n);\n\ncreate table KaleoLog (\n	kaleoLogId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoClassName VARCHAR(200) null,\n	kaleoClassPK LONG,\n	kaleoDefinitionId LONG,\n	kaleoInstanceId LONG,\n	kaleoInstanceTokenId LONG,\n	kaleoTaskInstanceTokenId LONG,\n	kaleoNodeName VARCHAR(200) null,\n	terminalKaleoNode BOOLEAN,\n	kaleoActionId LONG,\n	kaleoActionName VARCHAR(200) null,\n	kaleoActionDescription STRING null,\n	previousKaleoNodeId LONG,\n	previousKaleoNodeName VARCHAR(200) null,\n	previousAssigneeClassName VARCHAR(200) null,\n	previousAssigneeClassPK LONG,\n	currentAssigneeClassName VARCHAR(200) null,\n	currentAssigneeClassPK LONG,\n	type_ VARCHAR(50) null,\n	comment_ TEXT null,\n	startDate DATE null,\n	endDate DATE null,\n	duration LONG,\n	workflowContext TEXT null\n);\n\ncreate table KaleoNode (\n	kaleoNodeId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoDefinitionId LONG,\n	name VARCHAR(200) null,\n	metadata STRING null,\n	description STRING null,\n	type_ VARCHAR(20) null,\n	initial_ BOOLEAN,\n	terminal BOOLEAN\n);\n\ncreate table KaleoNotification (\n	kaleoNotificationId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoClassName VARCHAR(200) null,\n	kaleoClassPK LONG,\n	kaleoDefinitionId LONG,\n	kaleoNodeName VARCHAR(200) null,\n	name VARCHAR(200) null,\n	description STRING null,\n	executionType VARCHAR(20) null,\n	template TEXT null,\n	templateLanguage VARCHAR(75) null,\n	notificationTypes VARCHAR(25) null\n);\n\ncreate table KaleoNotificationRecipient (\n	kaleoNotificationRecipientId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoDefinitionId LONG,\n	kaleoNotificationId LONG,\n	recipientClassName VARCHAR(200) null,\n	recipientClassPK LONG,\n	recipientRoleType INTEGER,\n	address VARCHAR(255) null\n);\n\ncreate table KaleoTask (\n	kaleoTaskId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoDefinitionId LONG,\n	kaleoNodeId LONG,\n	name VARCHAR(200) null,\n	description STRING null\n);\n\ncreate table KaleoTaskAssignment (\n	kaleoTaskAssignmentId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoClassName VARCHAR(200) null,\n	kaleoClassPK LONG,\n	kaleoDefinitionId LONG,\n	kaleoNodeId LONG,\n	assigneeClassName VARCHAR(200) null,\n	assigneeClassPK LONG,\n	assigneeActionId VARCHAR(75) null,\n	assigneeScript TEXT null,\n	assigneeScriptLanguage VARCHAR(75) null,\n	assigneeScriptRequiredContexts STRING null\n);\n\ncreate table KaleoTaskAssignmentInstance (\n	kaleoTaskAssignmentInstanceId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoDefinitionId LONG,\n	kaleoInstanceId LONG,\n	kaleoInstanceTokenId LONG,\n	kaleoTaskInstanceTokenId LONG,\n	kaleoTaskId LONG,\n	kaleoTaskName VARCHAR(200) null,\n	assigneeClassName VARCHAR(200) null,\n	assigneeClassPK LONG,\n	completed BOOLEAN,\n	completionDate DATE null\n);\n\ncreate table KaleoTaskInstanceToken (\n	kaleoTaskInstanceTokenId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoDefinitionId LONG,\n	kaleoInstanceId LONG,\n	kaleoInstanceTokenId LONG,\n	kaleoTaskId LONG,\n	kaleoTaskName VARCHAR(200) null,\n	className VARCHAR(200) null,\n	classPK LONG,\n	completionUserId LONG,\n	completed BOOLEAN,\n	completionDate DATE null,\n	dueDate DATE null,\n	workflowContext TEXT null\n);\n\ncreate table KaleoTimer (\n	kaleoTimerId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoClassName VARCHAR(200) null,\n	kaleoClassPK LONG,\n	kaleoDefinitionId LONG,\n	name VARCHAR(75) null,\n	blocking BOOLEAN,\n	description STRING null,\n	duration DOUBLE,\n	scale VARCHAR(75) null,\n	recurrenceDuration DOUBLE,\n	recurrenceScale VARCHAR(75) null\n);\n\ncreate table KaleoTimerInstanceToken (\n	kaleoTimerInstanceTokenId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoClassName VARCHAR(200) null,\n	kaleoClassPK LONG,\n	kaleoDefinitionId LONG,\n	kaleoInstanceId LONG,\n	kaleoInstanceTokenId LONG,\n	kaleoTaskInstanceTokenId LONG,\n	kaleoTimerId LONG,\n	kaleoTimerName VARCHAR(200) null,\n	blocking BOOLEAN,\n	completionUserId LONG,\n	completed BOOLEAN,\n	completionDate DATE null,\n	workflowContext TEXT null\n);\n\ncreate table KaleoTransition (\n	kaleoTransitionId LONG not null primary key,\n	groupId LONG,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(200) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	kaleoDefinitionId LONG,\n	kaleoNodeId LONG,\n	name VARCHAR(200) null,\n	description STRING null,\n	sourceKaleoNodeId LONG,\n	sourceKaleoNodeName VARCHAR(200) null,\n	targetKaleoNodeId LONG,\n	targetKaleoNodeName VARCHAR(200) null,\n	defaultTransition BOOLEAN\n);]]></tables-sql>\n	<sequences-sql><![CDATA[]]></sequences-sql>\n	<indexes-sql><![CDATA[create index IX_50E9112C on KaleoAction (companyId);\ncreate index IX_170EFD7A on KaleoAction (kaleoClassName, kaleoClassPK);\ncreate index IX_4B2545E8 on KaleoAction (kaleoClassName, kaleoClassPK, executionType);\ncreate index IX_F95A622 on KaleoAction (kaleoDefinitionId);\n\ncreate index IX_FEE46067 on KaleoCondition (companyId);\ncreate index IX_DC978A5D on KaleoCondition (kaleoDefinitionId);\ncreate index IX_86CBD4C on KaleoCondition (kaleoNodeId);\n\ncreate index IX_40B9112F on KaleoDefinition (companyId);\ncreate index IX_408542BA on KaleoDefinition (companyId, active_);\ncreate index IX_76C781AE on KaleoDefinition (companyId, name);\ncreate index IX_4C23F11B on KaleoDefinition (companyId, name, active_);\ncreate index IX_EC14F81A on KaleoDefinition (companyId, name, version);\n\ncreate index IX_58D85ECB on KaleoInstance (className, classPK);\ncreate index IX_5F2FCD2D on KaleoInstance (companyId);\ncreate index IX_BF5839F8 on KaleoInstance (companyId, kaleoDefinitionName, kaleoDefinitionVersion, completionDate);\ncreate index IX_C6D7A867 on KaleoInstance (companyId, userId);\ncreate index IX_4DA4D123 on KaleoInstance (kaleoDefinitionId);\ncreate index IX_ACF16238 on KaleoInstance (kaleoDefinitionId, completed);\n\ncreate index IX_153721BE on KaleoInstanceToken (companyId);\ncreate index IX_4A86923B on KaleoInstanceToken (companyId, parentKaleoInstanceTokenId);\ncreate index IX_360D34D9 on KaleoInstanceToken (companyId, parentKaleoInstanceTokenId, completionDate);\ncreate index IX_7BDB04B4 on KaleoInstanceToken (kaleoDefinitionId);\ncreate index IX_F42AAFF6 on KaleoInstanceToken (kaleoInstanceId);\n\ncreate index IX_73B5F4DE on KaleoLog (companyId);\ncreate index IX_E66A153A on KaleoLog (kaleoClassName, kaleoClassPK, kaleoInstanceTokenId, type_);\ncreate index IX_6C64B7D4 on KaleoLog (kaleoDefinitionId);\ncreate index IX_5BC6AB16 on KaleoLog (kaleoInstanceId);\ncreate index IX_470B9FF8 on KaleoLog (kaleoInstanceTokenId, type_);\ncreate index IX_B0CDCA38 on KaleoLog (kaleoTaskInstanceTokenId);\n\ncreate index IX_C4E9ACE0 on KaleoNode (companyId);\ncreate index IX_F28C443E on KaleoNode (companyId, kaleoDefinitionId);\ncreate index IX_32E94DD6 on KaleoNode (kaleoDefinitionId);\n\ncreate index IX_38829497 on KaleoNotification (companyId);\ncreate index IX_902D342F on KaleoNotification (kaleoClassName, kaleoClassPK);\ncreate index IX_F3362E93 on KaleoNotification (kaleoClassName, kaleoClassPK, executionType);\ncreate index IX_4B968E8D on KaleoNotification (kaleoDefinitionId);\n\ncreate index IX_2C8C4AF4 on KaleoNotificationRecipient (companyId);\ncreate index IX_AA6697EA on KaleoNotificationRecipient (kaleoDefinitionId);\ncreate index IX_7F4FED02 on KaleoNotificationRecipient (kaleoNotificationId);\n\ncreate index IX_E1F8B23D on KaleoTask (companyId);\ncreate index IX_3FFA633 on KaleoTask (kaleoDefinitionId);\ncreate index IX_77B3F1A2 on KaleoTask (kaleoNodeId);\n\ncreate index IX_611732B0 on KaleoTaskAssignment (companyId);\ncreate index IX_D835C576 on KaleoTaskAssignment (kaleoClassName, kaleoClassPK);\ncreate index IX_1087068E on KaleoTaskAssignment (kaleoClassName, kaleoClassPK, assigneeClassName);\ncreate index IX_575C03A6 on KaleoTaskAssignment (kaleoDefinitionId);\n\ncreate index IX_945F4EB7 on KaleoTaskAssignmentInstance (assigneeClassName);\ncreate index IX_3BD436FD on KaleoTaskAssignmentInstance (assigneeClassName, assigneeClassPK);\ncreate index IX_6E3CDA1B on KaleoTaskAssignmentInstance (companyId);\ncreate index IX_38A47B17 on KaleoTaskAssignmentInstance (groupId, assigneeClassPK);\ncreate index IX_C851011 on KaleoTaskAssignmentInstance (kaleoDefinitionId);\ncreate index IX_67A9EE93 on KaleoTaskAssignmentInstance (kaleoInstanceId);\ncreate index IX_D4C2235B on KaleoTaskAssignmentInstance (kaleoTaskInstanceTokenId);\n\ncreate index IX_A3271995 on KaleoTaskInstanceToken (className, classPK);\ncreate index IX_997FE723 on KaleoTaskInstanceToken (companyId);\ncreate index IX_608E9519 on KaleoTaskInstanceToken (kaleoDefinitionId);\ncreate index IX_2CE1159B on KaleoTaskInstanceToken (kaleoInstanceId);\ncreate index IX_B857A115 on KaleoTaskInstanceToken (kaleoInstanceId, kaleoTaskId);\n\ncreate index IX_4DE6A889 on KaleoTimer (kaleoClassName, kaleoClassPK);\ncreate index IX_1A479F32 on KaleoTimer (kaleoClassName, kaleoClassPK, blocking);\n\ncreate index IX_DB96C55B on KaleoTimerInstanceToken (kaleoInstanceId);\ncreate index IX_DB279423 on KaleoTimerInstanceToken (kaleoInstanceTokenId, completed);\ncreate index IX_9932524C on KaleoTimerInstanceToken (kaleoInstanceTokenId, completed, blocking);\ncreate index IX_13A5BA2C on KaleoTimerInstanceToken (kaleoInstanceTokenId, kaleoTimerId);\n\ncreate index IX_41D6C6D on KaleoTransition (companyId);\ncreate index IX_479F3063 on KaleoTransition (kaleoDefinitionId);\ncreate index IX_A392DFD2 on KaleoTransition (kaleoNodeId);\ncreate index IX_A38E2194 on KaleoTransition (kaleoNodeId, defaultTransition);\ncreate index IX_85268A11 on KaleoTransition (kaleoNodeId, name);]]></indexes-sql>\n</data>'),(20474,'Notification',1,1409250476826,'<?xml version=\"1.0\"?>\n\n<data>\n	<tables-sql><![CDATA[create table Notifications_UserNotificationEvent (\n	notificationEventId LONG not null primary key,\n	companyId LONG,\n	userId LONG,\n	userNotificationEventId LONG,\n	timestamp LONG,\n	delivered BOOLEAN,\n	actionRequired BOOLEAN,\n	archived BOOLEAN\n);]]></tables-sql>\n	<sequences-sql><![CDATA[]]></sequences-sql>\n	<indexes-sql><![CDATA[create index IX_93C52776 on Notifications_UserNotificationEvent (userId, actionRequired);\ncreate index IX_36E5AE4C on Notifications_UserNotificationEvent (userId, actionRequired, archived);\ncreate index IX_73C065F0 on Notifications_UserNotificationEvent (userId, delivered, actionRequired);\ncreate unique index IX_DC9FCEDC on Notifications_UserNotificationEvent (userNotificationEventId);]]></indexes-sql>\n</data>'),(20504,'OpenSocial',4,1343264401607,'<?xml version=\"1.0\"?>\n\n<data>\n	<tables-sql><![CDATA[create table OpenSocial_Gadget (\n	uuid_ VARCHAR(75) null,\n	gadgetId LONG not null primary key,\n	companyId LONG,\n	createDate DATE null,\n	modifiedDate DATE null,\n	name VARCHAR(75) null,\n	url STRING null,\n	portletCategoryNames STRING null\n);\n\ncreate table OpenSocial_OAuthConsumer (\n	oAuthConsumerId LONG not null primary key,\n	companyId LONG,\n	createDate DATE null,\n	modifiedDate DATE null,\n	gadgetKey VARCHAR(75) null,\n	serviceName VARCHAR(75) null,\n	consumerKey VARCHAR(75) null,\n	consumerSecret TEXT null,\n	keyType VARCHAR(75) null\n);\n\ncreate table OpenSocial_OAuthToken (\n	oAuthTokenId LONG not null primary key,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createDate DATE null,\n	modifiedDate DATE null,\n	gadgetKey VARCHAR(75) null,\n	serviceName VARCHAR(75) null,\n	moduleId LONG,\n	accessToken VARCHAR(75) null,\n	tokenName VARCHAR(75) null,\n	tokenSecret VARCHAR(75) null,\n	sessionHandle VARCHAR(75) null,\n	expiration LONG\n);]]></tables-sql>\n	<sequences-sql><![CDATA[]]></sequences-sql>\n	<indexes-sql><![CDATA[create index IX_729869EE on OpenSocial_Gadget (companyId);\ncreate unique index IX_A6A89EB1 on OpenSocial_Gadget (companyId, url);\ncreate index IX_E1F8627A on OpenSocial_Gadget (uuid_);\ncreate index IX_3C79316E on OpenSocial_Gadget (uuid_, companyId);\n\ncreate index IX_47206618 on OpenSocial_OAuthConsumer (gadgetKey);\ncreate index IX_8E715BF8 on OpenSocial_OAuthConsumer (gadgetKey, serviceName);\n\ncreate index IX_6C8CCC3D on OpenSocial_OAuthToken (gadgetKey, serviceName);\ncreate index IX_CDD35402 on OpenSocial_OAuthToken (userId, gadgetKey, serviceName, moduleId, tokenName);]]></indexes-sql>\n</data>'),(20513,'Sync',6,1445034861916,'<?xml version=\"1.0\"?>\n\n<data>\n	<tables-sql><![CDATA[create table SyncDLFileVersionDiff (\n	syncDLFileVersionDiffId LONG not null primary key,\n	fileEntryId LONG,\n	sourceFileVersionId LONG,\n	targetFileVersionId LONG,\n	dataFileEntryId LONG,\n	size_ LONG,\n	expirationDate DATE null\n);\n\ncreate table SyncDLObject (\n	syncDLObjectId LONG not null primary key,\n	companyId LONG,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createTime LONG,\n	modifiedTime LONG,\n	repositoryId LONG,\n	parentFolderId LONG,\n	treePath STRING null,\n	name VARCHAR(255) null,\n	extension VARCHAR(75) null,\n	mimeType VARCHAR(75) null,\n	description STRING null,\n	changeLog VARCHAR(75) null,\n	extraSettings TEXT null,\n	version VARCHAR(75) null,\n	versionId LONG,\n	size_ LONG,\n	checksum VARCHAR(75) null,\n	event VARCHAR(75) null,\n	lastPermissionChangeDate DATE null,\n	lockExpirationDate DATE null,\n	lockUserId LONG,\n	lockUserName VARCHAR(75) null,\n	type_ VARCHAR(75) null,\n	typePK LONG,\n	typeUuid VARCHAR(75) null\n);]]></tables-sql>\n	<sequences-sql><![CDATA[]]></sequences-sql>\n	<indexes-sql><![CDATA[create index IX_A9B43C55 on SyncDLFileVersionDiff (expirationDate);\ncreate index IX_F832A75D on SyncDLFileVersionDiff (fileEntryId);\ncreate unique index IX_AC4C7667 on SyncDLFileVersionDiff (fileEntryId, sourceFileVersionId, targetFileVersionId);\n\ncreate index IX_980323CB on SyncDLObject (modifiedTime, repositoryId);\ncreate index IX_8D4FDC9F on SyncDLObject (modifiedTime, repositoryId, event);\ncreate index IX_A3ACE372 on SyncDLObject (modifiedTime, repositoryId, parentFolderId);\ncreate index IX_F174AD48 on SyncDLObject (repositoryId, parentFolderId);\ncreate index IX_3BE7BB8D on SyncDLObject (repositoryId, parentFolderId, type_);\ncreate index IX_57F62914 on SyncDLObject (repositoryId, type_);\ncreate unique index IX_E3F57BD6 on SyncDLObject (type_, typePK);\ncreate index IX_28CD54BB on SyncDLObject (type_, version);\ncreate index IX_1CCA3B5 on SyncDLObject (version, type_);]]></indexes-sql>\n</data>'),(21005,'sys',28,1467601652004,'<?xml version=\"1.0\"?>\n\n<data>\n	<tables-sql><![CDATA[create table sys_Dictionary (\n	dictionaryId LONG not null primary key,\n	groupId LONG,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createTime DATE null,\n	modifiedTime DATE null,\n	code_ VARCHAR(75) null,\n	name VARCHAR(75) null,\n	isLeaf BOOLEAN,\n	sortNo INTEGER,\n	desc_ STRING null,\n	tag VARCHAR(75) null,\n	isValid BOOLEAN,\n	treePath VARCHAR(75) null,\n	sortPath VARCHAR(75) null,\n	customContent STRING null,\n	parentId LONG\n);]]></tables-sql>\n	<sequences-sql><![CDATA[]]></sequences-sql>\n	<indexes-sql><![CDATA[create index IX_956EB3D6 on sys_Dictionary (code_, groupId);\ncreate index IX_12AC8186 on sys_Dictionary (groupId, code_);\ncreate index IX_30C35755 on sys_Dictionary (groupId, parentId);\ncreate index IX_F29A0FED on sys_Dictionary (groupId, parentId, isValid);\ncreate index IX_DA76306E on sys_Dictionary (groupId, parentId, name, code_);\ncreate index IX_C5F19EC7 on sys_Dictionary (parentId);\ncreate index IX_349C85C3 on sys_Dictionary (parentId, groupId);\ncreate index IX_784008BB on sys_Dictionary (parentId, isValid);\ncreate index IX_2F740E4F on sys_Dictionary (parentId, isValid, groupId);]]></indexes-sql>\n</data>'),(21109,'oa',23,1467619993438,'<?xml version=\"1.0\"?>\n\n<data>\n	<tables-sql><![CDATA[create table oa_DeptWork (\n	deptWorkId LONG not null primary key,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createTime DATE null,\n	modifiedTime DATE null,\n	deptId LONG,\n	deptName VARCHAR(75) null,\n	startDate DATE null,\n	endDate DATE null,\n	status VARCHAR(75) null\n);\n\ncreate table oa_DeptWorkItem (\n	deptWorkItemId LONG not null primary key,\n	deptWorkId LONG,\n	sortNo INTEGER,\n	dutyPerosn VARCHAR(75) null,\n	mainWork BOOLEAN,\n	schedule VARCHAR(75) null,\n	content VARCHAR(1000) null,\n	agentPerson VARCHAR(75) null\n);\n\ncreate table oa_Dispatch (\n	dispatchId LONG not null primary key,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createTime DATE null,\n	modifiedTime DATE null,\n	rocordType LONG,\n	securityLevel LONG,\n	organaAbbreviation LONG,\n	year INTEGER,\n	serialNo INTEGER,\n	title VARCHAR(75) null,\n	sendOrgan VARCHAR(75) null,\n	ccOrgan VARCHAR(75) null,\n	writtenOrgan VARCHAR(75) null,\n	writtenDate DATE null,\n	urgencyDegree LONG\n);\n\ncreate table oa_LeaderWork (\n	userId LONG not null,\n	workDate DATE not null,\n	amOrPm LONG not null,\n	userName VARCHAR(75) null,\n	createTime DATE null,\n	modifiedTime DATE null,\n	content VARCHAR(1000) null,\n	primary key (userId, workDate, amOrPm)\n);\n\ncreate table oa_OfficeSupply (\n	officeSupplyId LONG not null primary key,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createTime DATE null,\n	modifiedTime DATE null,\n	name VARCHAR(75) null,\n	model VARCHAR(75) null,\n	unit VARCHAR(75) null,\n	unitPrice DOUBLE,\n	quantity INTEGER\n);\n\ncreate table oa_OfficeSupplyApply (\n	officeSupplyApplyId LONG not null primary key,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createTime DATE null,\n	modifiedTime DATE null,\n	deptId LONG,\n	deptName VARCHAR(75) null,\n	applicantId LONG,\n	applicantName VARCHAR(75) null,\n	introductions VARCHAR(2000) null\n);\n\ncreate table oa_OfficeSupplyApplyItem (\n	officeSupplyApplyItemId LONG not null primary key,\n	name VARCHAR(75) null,\n	model VARCHAR(75) null,\n	unit VARCHAR(75) null,\n	unitPrice DOUBLE,\n	quantity INTEGER\n);\n\ncreate table oa_OfficeSupplyRequisition (\n	officeSupplyRequisitionId LONG not null primary key,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createTime DATE null,\n	modifiedTime DATE null,\n	deptId LONG,\n	deptName VARCHAR(75) null,\n	applicantId LONG,\n	applicantName VARCHAR(75) null,\n	introductions VARCHAR(75) null\n);\n\ncreate table oa_OfficeSupplyRequisitionItem (\n	officeSupplyRequisitionItemId LONG not null primary key,\n	name VARCHAR(75) null,\n	model VARCHAR(75) null,\n	unit VARCHAR(75) null,\n	unitPrice DOUBLE,\n	quantity INTEGER,\n	officeSupplyRequisitionId LONG,\n	officeSupplyId LONG\n);\n\ncreate table oa_VehicleRequisition (\n	vehicleRequisitionId LONG not null primary key,\n	userId LONG,\n	userName VARCHAR(75) null,\n	createTime DATE null,\n	modifiedTime DATE null,\n	applicantDeptId LONG,\n	applicantDeptName VARCHAR(75) null,\n	applicantId LONG,\n	applicantName VARCHAR(75) null,\n	startTime DATE null,\n	endTime DATE null,\n	passengerNum INTEGER,\n	reason VARCHAR(1000) null,\n	destination VARCHAR(200) null\n);]]></tables-sql>\n	<sequences-sql><![CDATA[]]></sequences-sql>\n	<indexes-sql><![CDATA[create index IX_8494C0D on oa_DeptWork (deptName);\ncreate index IX_7C6E7D13 on oa_DeptWork (userName);\n\ncreate index IX_6C5391C1 on oa_DeptWorkItem (deptWorkId);\n\ncreate index IX_93A71FFB on oa_Dispatch (title);\n\ncreate index IX_37CD3B3D on oa_OfficeSupply (name);\n\ncreate index IX_C4DEFA41 on oa_OfficeSupplyApply (applicantName);\ncreate index IX_BB2AFEC0 on oa_OfficeSupplyApply (deptName);\n\ncreate index IX_75394CD3 on oa_OfficeSupplyRequisition (applicantName);\ncreate index IX_B47D8EE on oa_OfficeSupplyRequisition (deptName);\n\ncreate index IX_D0E357DF on oa_OfficeSupplyRequisitionItem (officeSupplyRequisitionId);\n\ncreate index IX_F44F99BA on oa_VehicleRequisition (applicantName);]]></indexes-sql>\n</data>');
/*!40000 ALTER TABLE `servicecomponent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shard`
--

DROP TABLE IF EXISTS `shard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shard` (
  `shardId` bigint(20) NOT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`shardId`),
  KEY `IX_DA5F4359` (`classNameId`,`classPK`),
  KEY `IX_941BA8C3` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shard`
--

LOCK TABLES `shard` WRITE;
/*!40000 ALTER TABLE `shard` DISABLE KEYS */;
INSERT INTO `shard` VALUES (20155,20025,20154,'default');
/*!40000 ALTER TABLE `shard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingcart`
--

DROP TABLE IF EXISTS `shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingcart` (
  `cartId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `itemIds` longtext,
  `couponCodes` varchar(75) DEFAULT NULL,
  `altShipping` int(11) DEFAULT NULL,
  `insure` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`cartId`),
  UNIQUE KEY `IX_FC46FE16` (`groupId`,`userId`),
  KEY `IX_C28B41DC` (`groupId`),
  KEY `IX_54101CC8` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcart`
--

LOCK TABLES `shoppingcart` WRITE;
/*!40000 ALTER TABLE `shoppingcart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingcategory`
--

DROP TABLE IF EXISTS `shoppingcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingcategory` (
  `categoryId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `parentCategoryId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `description` longtext,
  PRIMARY KEY (`categoryId`),
  KEY `IX_5F615D3E` (`groupId`),
  KEY `IX_6A84467D` (`groupId`,`name`),
  KEY `IX_1E6464F5` (`groupId`,`parentCategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcategory`
--

LOCK TABLES `shoppingcategory` WRITE;
/*!40000 ALTER TABLE `shoppingcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingcoupon`
--

DROP TABLE IF EXISTS `shoppingcoupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingcoupon` (
  `couponId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `code_` varchar(75) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `description` longtext,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `active_` tinyint(4) DEFAULT NULL,
  `limitCategories` longtext,
  `limitSkus` longtext,
  `minOrder` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `discountType` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`couponId`),
  UNIQUE KEY `IX_DC60CFAE` (`code_`),
  KEY `IX_3251AF16` (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcoupon`
--

LOCK TABLES `shoppingcoupon` WRITE;
/*!40000 ALTER TABLE `shoppingcoupon` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingcoupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingitem`
--

DROP TABLE IF EXISTS `shoppingitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingitem` (
  `itemId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `categoryId` bigint(20) DEFAULT NULL,
  `sku` varchar(75) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `description` longtext,
  `properties` longtext,
  `fields_` tinyint(4) DEFAULT NULL,
  `fieldsQuantities` longtext,
  `minQuantity` int(11) DEFAULT NULL,
  `maxQuantity` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `taxable` tinyint(4) DEFAULT NULL,
  `shipping` double DEFAULT NULL,
  `useShippingFormula` tinyint(4) DEFAULT NULL,
  `requiresShipping` tinyint(4) DEFAULT NULL,
  `stockQuantity` int(11) DEFAULT NULL,
  `featured_` tinyint(4) DEFAULT NULL,
  `sale_` tinyint(4) DEFAULT NULL,
  `smallImage` tinyint(4) DEFAULT NULL,
  `smallImageId` bigint(20) DEFAULT NULL,
  `smallImageURL` longtext,
  `mediumImage` tinyint(4) DEFAULT NULL,
  `mediumImageId` bigint(20) DEFAULT NULL,
  `mediumImageURL` longtext,
  `largeImage` tinyint(4) DEFAULT NULL,
  `largeImageId` bigint(20) DEFAULT NULL,
  `largeImageURL` longtext,
  PRIMARY KEY (`itemId`),
  UNIQUE KEY `IX_1C717CA6` (`companyId`,`sku`),
  KEY `IX_FEFE7D76` (`groupId`,`categoryId`),
  KEY `IX_903DC750` (`largeImageId`),
  KEY `IX_D217AB30` (`mediumImageId`),
  KEY `IX_FF203304` (`smallImageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingitem`
--

LOCK TABLES `shoppingitem` WRITE;
/*!40000 ALTER TABLE `shoppingitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingitemfield`
--

DROP TABLE IF EXISTS `shoppingitemfield`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingitemfield` (
  `itemFieldId` bigint(20) NOT NULL,
  `itemId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `values_` longtext,
  `description` longtext,
  PRIMARY KEY (`itemFieldId`),
  KEY `IX_6D5F9B87` (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingitemfield`
--

LOCK TABLES `shoppingitemfield` WRITE;
/*!40000 ALTER TABLE `shoppingitemfield` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingitemfield` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingitemprice`
--

DROP TABLE IF EXISTS `shoppingitemprice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingitemprice` (
  `itemPriceId` bigint(20) NOT NULL,
  `itemId` bigint(20) DEFAULT NULL,
  `minQuantity` int(11) DEFAULT NULL,
  `maxQuantity` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `taxable` tinyint(4) DEFAULT NULL,
  `shipping` double DEFAULT NULL,
  `useShippingFormula` tinyint(4) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemPriceId`),
  KEY `IX_EA6FD516` (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingitemprice`
--

LOCK TABLES `shoppingitemprice` WRITE;
/*!40000 ALTER TABLE `shoppingitemprice` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingitemprice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingorder`
--

DROP TABLE IF EXISTS `shoppingorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingorder` (
  `orderId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `number_` varchar(75) DEFAULT NULL,
  `tax` double DEFAULT NULL,
  `shipping` double DEFAULT NULL,
  `altShipping` varchar(75) DEFAULT NULL,
  `requiresShipping` tinyint(4) DEFAULT NULL,
  `insure` tinyint(4) DEFAULT NULL,
  `insurance` double DEFAULT NULL,
  `couponCodes` varchar(75) DEFAULT NULL,
  `couponDiscount` double DEFAULT NULL,
  `billingFirstName` varchar(75) DEFAULT NULL,
  `billingLastName` varchar(75) DEFAULT NULL,
  `billingEmailAddress` varchar(75) DEFAULT NULL,
  `billingCompany` varchar(75) DEFAULT NULL,
  `billingStreet` varchar(75) DEFAULT NULL,
  `billingCity` varchar(75) DEFAULT NULL,
  `billingState` varchar(75) DEFAULT NULL,
  `billingZip` varchar(75) DEFAULT NULL,
  `billingCountry` varchar(75) DEFAULT NULL,
  `billingPhone` varchar(75) DEFAULT NULL,
  `shipToBilling` tinyint(4) DEFAULT NULL,
  `shippingFirstName` varchar(75) DEFAULT NULL,
  `shippingLastName` varchar(75) DEFAULT NULL,
  `shippingEmailAddress` varchar(75) DEFAULT NULL,
  `shippingCompany` varchar(75) DEFAULT NULL,
  `shippingStreet` varchar(75) DEFAULT NULL,
  `shippingCity` varchar(75) DEFAULT NULL,
  `shippingState` varchar(75) DEFAULT NULL,
  `shippingZip` varchar(75) DEFAULT NULL,
  `shippingCountry` varchar(75) DEFAULT NULL,
  `shippingPhone` varchar(75) DEFAULT NULL,
  `ccName` varchar(75) DEFAULT NULL,
  `ccType` varchar(75) DEFAULT NULL,
  `ccNumber` varchar(75) DEFAULT NULL,
  `ccExpMonth` int(11) DEFAULT NULL,
  `ccExpYear` int(11) DEFAULT NULL,
  `ccVerNumber` varchar(75) DEFAULT NULL,
  `comments` longtext,
  `ppTxnId` varchar(75) DEFAULT NULL,
  `ppPaymentStatus` varchar(75) DEFAULT NULL,
  `ppPaymentGross` double DEFAULT NULL,
  `ppReceiverEmail` varchar(75) DEFAULT NULL,
  `ppPayerEmail` varchar(75) DEFAULT NULL,
  `sendOrderEmail` tinyint(4) DEFAULT NULL,
  `sendShippingEmail` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  UNIQUE KEY `IX_D7D6E87A` (`number_`),
  KEY `IX_1D15553E` (`groupId`),
  KEY `IX_119B5630` (`groupId`,`userId`,`ppPaymentStatus`),
  KEY `IX_F474FD89` (`ppTxnId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingorder`
--

LOCK TABLES `shoppingorder` WRITE;
/*!40000 ALTER TABLE `shoppingorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingorderitem`
--

DROP TABLE IF EXISTS `shoppingorderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingorderitem` (
  `orderItemId` bigint(20) NOT NULL,
  `orderId` bigint(20) DEFAULT NULL,
  `itemId` varchar(75) DEFAULT NULL,
  `sku` varchar(75) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `description` longtext,
  `properties` longtext,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `shippedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`orderItemId`),
  KEY `IX_B5F82C7A` (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingorderitem`
--

LOCK TABLES `shoppingorderitem` WRITE;
/*!40000 ALTER TABLE `shoppingorderitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingorderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socialactivity`
--

DROP TABLE IF EXISTS `socialactivity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socialactivity` (
  `activityId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `createDate` bigint(20) DEFAULT NULL,
  `activitySetId` bigint(20) DEFAULT NULL,
  `mirrorActivityId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `parentClassNameId` bigint(20) DEFAULT NULL,
  `parentClassPK` bigint(20) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  `extraData` longtext,
  `receiverUserId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`activityId`),
  UNIQUE KEY `IX_8F32DEC9` (`groupId`,`userId`,`createDate`,`classNameId`,`classPK`,`type_`,`receiverUserId`),
  KEY `IX_F542E9BC` (`activitySetId`),
  KEY `IX_82E39A0C` (`classNameId`),
  KEY `IX_A853C757` (`classNameId`,`classPK`),
  KEY `IX_D0E9029E` (`classNameId`,`classPK`,`type_`),
  KEY `IX_64B1BC66` (`companyId`),
  KEY `IX_2A2468` (`groupId`),
  KEY `IX_FB604DC7` (`groupId`,`userId`,`classNameId`,`classPK`,`type_`,`receiverUserId`),
  KEY `IX_1271F25F` (`mirrorActivityId`),
  KEY `IX_1F00C374` (`mirrorActivityId`,`classNameId`,`classPK`),
  KEY `IX_121CA3CB` (`receiverUserId`),
  KEY `IX_3504B8BC` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socialactivity`
--

LOCK TABLES `socialactivity` WRITE;
/*!40000 ALTER TABLE `socialactivity` DISABLE KEYS */;
/*!40000 ALTER TABLE `socialactivity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socialactivityachievement`
--

DROP TABLE IF EXISTS `socialactivityachievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socialactivityachievement` (
  `activityAchievementId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `createDate` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `firstInGroup` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`activityAchievementId`),
  UNIQUE KEY `IX_D4390CAA` (`groupId`,`userId`,`name`),
  KEY `IX_E14B1F1` (`groupId`),
  KEY `IX_83E16F2F` (`groupId`,`firstInGroup`),
  KEY `IX_8F6408F0` (`groupId`,`name`),
  KEY `IX_C8FD892B` (`groupId`,`userId`),
  KEY `IX_AABC18E9` (`groupId`,`userId`,`firstInGroup`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socialactivityachievement`
--

LOCK TABLES `socialactivityachievement` WRITE;
/*!40000 ALTER TABLE `socialactivityachievement` DISABLE KEYS */;
/*!40000 ALTER TABLE `socialactivityachievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socialactivitycounter`
--

DROP TABLE IF EXISTS `socialactivitycounter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socialactivitycounter` (
  `activityCounterId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `ownerType` int(11) DEFAULT NULL,
  `currentValue` int(11) DEFAULT NULL,
  `totalValue` int(11) DEFAULT NULL,
  `graceValue` int(11) DEFAULT NULL,
  `startPeriod` int(11) DEFAULT NULL,
  `endPeriod` int(11) DEFAULT NULL,
  `active_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`activityCounterId`),
  UNIQUE KEY `IX_1B7E3B67` (`groupId`,`classNameId`,`classPK`,`name`,`ownerType`,`endPeriod`),
  UNIQUE KEY `IX_374B35AE` (`groupId`,`classNameId`,`classPK`,`name`,`ownerType`,`startPeriod`),
  KEY `IX_A4B9A23B` (`classNameId`,`classPK`),
  KEY `IX_D6666704` (`groupId`),
  KEY `IX_926CDD04` (`groupId`,`classNameId`,`classPK`,`ownerType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socialactivitycounter`
--

LOCK TABLES `socialactivitycounter` WRITE;
/*!40000 ALTER TABLE `socialactivitycounter` DISABLE KEYS */;
/*!40000 ALTER TABLE `socialactivitycounter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socialactivitylimit`
--

DROP TABLE IF EXISTS `socialactivitylimit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socialactivitylimit` (
  `activityLimitId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `activityType` int(11) DEFAULT NULL,
  `activityCounterName` varchar(75) DEFAULT NULL,
  `value` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`activityLimitId`),
  UNIQUE KEY `IX_F1C1A617` (`groupId`,`userId`,`classNameId`,`classPK`,`activityType`,`activityCounterName`),
  KEY `IX_B15863FA` (`classNameId`,`classPK`),
  KEY `IX_18D4BAE5` (`groupId`),
  KEY `IX_6F9EDE9F` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socialactivitylimit`
--

LOCK TABLES `socialactivitylimit` WRITE;
/*!40000 ALTER TABLE `socialactivitylimit` DISABLE KEYS */;
/*!40000 ALTER TABLE `socialactivitylimit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socialactivityset`
--

DROP TABLE IF EXISTS `socialactivityset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socialactivityset` (
  `activitySetId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `createDate` bigint(20) DEFAULT NULL,
  `modifiedDate` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  `extraData` longtext,
  `activityCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`activitySetId`),
  KEY `IX_4460FA14` (`classNameId`,`classPK`,`type_`),
  KEY `IX_9E13F2DE` (`groupId`),
  KEY `IX_9BE30DDF` (`groupId`,`userId`,`classNameId`,`type_`),
  KEY `IX_F71071BD` (`groupId`,`userId`,`type_`),
  KEY `IX_F80C4386` (`userId`),
  KEY `IX_62AC101A` (`userId`,`classNameId`,`classPK`,`type_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socialactivityset`
--

LOCK TABLES `socialactivityset` WRITE;
/*!40000 ALTER TABLE `socialactivityset` DISABLE KEYS */;
/*!40000 ALTER TABLE `socialactivityset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socialactivitysetting`
--

DROP TABLE IF EXISTS `socialactivitysetting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socialactivitysetting` (
  `activitySettingId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `activityType` int(11) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `value` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`activitySettingId`),
  KEY `IX_8BE5F230` (`groupId`),
  KEY `IX_384788CD` (`groupId`,`activityType`),
  KEY `IX_9D22151E` (`groupId`,`classNameId`),
  KEY `IX_1E9CF33B` (`groupId`,`classNameId`,`activityType`),
  KEY `IX_D984AABA` (`groupId`,`classNameId`,`activityType`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socialactivitysetting`
--

LOCK TABLES `socialactivitysetting` WRITE;
/*!40000 ALTER TABLE `socialactivitysetting` DISABLE KEYS */;
/*!40000 ALTER TABLE `socialactivitysetting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socialrelation`
--

DROP TABLE IF EXISTS `socialrelation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socialrelation` (
  `uuid_` varchar(75) DEFAULT NULL,
  `relationId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `createDate` bigint(20) DEFAULT NULL,
  `userId1` bigint(20) DEFAULT NULL,
  `userId2` bigint(20) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  PRIMARY KEY (`relationId`),
  UNIQUE KEY `IX_12A92145` (`userId1`,`userId2`,`type_`),
  KEY `IX_61171E99` (`companyId`),
  KEY `IX_95135D1C` (`companyId`,`type_`),
  KEY `IX_C31A64C6` (`type_`),
  KEY `IX_5A40CDCC` (`userId1`),
  KEY `IX_4B52BE89` (`userId1`,`type_`),
  KEY `IX_B5C9C690` (`userId1`,`userId2`),
  KEY `IX_5A40D18D` (`userId2`),
  KEY `IX_3F9C2FA8` (`userId2`,`type_`),
  KEY `IX_F0CA24A5` (`uuid_`),
  KEY `IX_5B30F663` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socialrelation`
--

LOCK TABLES `socialrelation` WRITE;
/*!40000 ALTER TABLE `socialrelation` DISABLE KEYS */;
/*!40000 ALTER TABLE `socialrelation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socialrequest`
--

DROP TABLE IF EXISTS `socialrequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socialrequest` (
  `uuid_` varchar(75) DEFAULT NULL,
  `requestId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `createDate` bigint(20) DEFAULT NULL,
  `modifiedDate` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  `extraData` longtext,
  `receiverUserId` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`requestId`),
  UNIQUE KEY `IX_36A90CA7` (`userId`,`classNameId`,`classPK`,`type_`,`receiverUserId`),
  UNIQUE KEY `IX_4F973EFE` (`uuid_`,`groupId`),
  KEY `IX_D3425487` (`classNameId`,`classPK`,`type_`,`receiverUserId`,`status`),
  KEY `IX_A90FE5A0` (`companyId`),
  KEY `IX_32292ED1` (`receiverUserId`),
  KEY `IX_D9380CB7` (`receiverUserId`,`status`),
  KEY `IX_80F7A9C2` (`userId`),
  KEY `IX_CC86A444` (`userId`,`classNameId`,`classPK`,`type_`,`status`),
  KEY `IX_AB5906A8` (`userId`,`status`),
  KEY `IX_49D5872C` (`uuid_`),
  KEY `IX_8D42897C` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socialrequest`
--

LOCK TABLES `socialrequest` WRITE;
/*!40000 ALTER TABLE `socialrequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `socialrequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription`
--

DROP TABLE IF EXISTS `subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subscription` (
  `subscriptionId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `frequency` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`subscriptionId`),
  UNIQUE KEY `IX_2E1A92D4` (`companyId`,`userId`,`classNameId`,`classPK`),
  KEY `IX_786D171A` (`companyId`,`classNameId`,`classPK`),
  KEY `IX_54243AFD` (`userId`),
  KEY `IX_E8F34171` (`userId`,`classNameId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription`
--

LOCK TABLES `subscription` WRITE;
/*!40000 ALTER TABLE `subscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syncdlfileversiondiff`
--

DROP TABLE IF EXISTS `syncdlfileversiondiff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syncdlfileversiondiff` (
  `syncDLFileVersionDiffId` bigint(20) NOT NULL,
  `fileEntryId` bigint(20) DEFAULT NULL,
  `sourceFileVersionId` bigint(20) DEFAULT NULL,
  `targetFileVersionId` bigint(20) DEFAULT NULL,
  `dataFileEntryId` bigint(20) DEFAULT NULL,
  `size_` bigint(20) DEFAULT NULL,
  `expirationDate` datetime DEFAULT NULL,
  PRIMARY KEY (`syncDLFileVersionDiffId`),
  UNIQUE KEY `IX_AC4C7667` (`fileEntryId`,`sourceFileVersionId`,`targetFileVersionId`),
  KEY `IX_A9B43C55` (`expirationDate`),
  KEY `IX_F832A75D` (`fileEntryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syncdlfileversiondiff`
--

LOCK TABLES `syncdlfileversiondiff` WRITE;
/*!40000 ALTER TABLE `syncdlfileversiondiff` DISABLE KEYS */;
/*!40000 ALTER TABLE `syncdlfileversiondiff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syncdlobject`
--

DROP TABLE IF EXISTS `syncdlobject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syncdlobject` (
  `syncDLObjectId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createTime` bigint(20) DEFAULT NULL,
  `modifiedTime` bigint(20) DEFAULT NULL,
  `repositoryId` bigint(20) DEFAULT NULL,
  `parentFolderId` bigint(20) DEFAULT NULL,
  `treePath` longtext,
  `name` varchar(255) DEFAULT NULL,
  `extension` varchar(75) DEFAULT NULL,
  `mimeType` varchar(75) DEFAULT NULL,
  `description` longtext,
  `changeLog` varchar(75) DEFAULT NULL,
  `extraSettings` longtext,
  `version` varchar(75) DEFAULT NULL,
  `versionId` bigint(20) DEFAULT NULL,
  `size_` bigint(20) DEFAULT NULL,
  `checksum` varchar(75) DEFAULT NULL,
  `event` varchar(75) DEFAULT NULL,
  `lastPermissionChangeDate` datetime DEFAULT NULL,
  `lockExpirationDate` datetime DEFAULT NULL,
  `lockUserId` bigint(20) DEFAULT NULL,
  `lockUserName` varchar(75) DEFAULT NULL,
  `type_` varchar(75) DEFAULT NULL,
  `typePK` bigint(20) DEFAULT NULL,
  `typeUuid` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`syncDLObjectId`),
  UNIQUE KEY `IX_E3F57BD6` (`type_`,`typePK`),
  KEY `IX_980323CB` (`modifiedTime`,`repositoryId`),
  KEY `IX_8D4FDC9F` (`modifiedTime`,`repositoryId`,`event`),
  KEY `IX_A3ACE372` (`modifiedTime`,`repositoryId`,`parentFolderId`),
  KEY `IX_F174AD48` (`repositoryId`,`parentFolderId`),
  KEY `IX_3BE7BB8D` (`repositoryId`,`parentFolderId`,`type_`),
  KEY `IX_57F62914` (`repositoryId`,`type_`),
  KEY `IX_28CD54BB` (`type_`,`version`),
  KEY `IX_1CCA3B5` (`version`,`type_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syncdlobject`
--

LOCK TABLES `syncdlobject` WRITE;
/*!40000 ALTER TABLE `syncdlobject` DISABLE KEYS */;
/*!40000 ALTER TABLE `syncdlobject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dictionary`
--

DROP TABLE IF EXISTS `sys_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dictionary` (
  `dictionaryId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  `code_` varchar(75) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `isLeaf` tinyint(4) DEFAULT NULL,
  `sortNo` int(11) DEFAULT NULL,
  `desc_` longtext,
  `tag` varchar(75) DEFAULT NULL,
  `isValid` tinyint(4) DEFAULT NULL,
  `treePath` varchar(75) DEFAULT NULL,
  `sortPath` varchar(75) DEFAULT NULL,
  `customContent` longtext,
  `parentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`dictionaryId`),
  KEY `IX_956EB3D6` (`code_`,`groupId`),
  KEY `IX_12AC8186` (`groupId`,`code_`),
  KEY `IX_30C35755` (`groupId`,`parentId`),
  KEY `IX_F29A0FED` (`groupId`,`parentId`,`isValid`),
  KEY `IX_DA76306E` (`groupId`,`parentId`,`name`,`code_`),
  KEY `IX_C5F19EC7` (`parentId`),
  KEY `IX_349C85C3` (`parentId`,`groupId`),
  KEY `IX_784008BB` (`parentId`,`isValid`),
  KEY `IX_2F740E4F` (`parentId`,`isValid`,`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dictionary`
--

LOCK TABLES `sys_dictionary` WRITE;
/*!40000 ALTER TABLE `sys_dictionary` DISABLE KEYS */;
INSERT INTO `sys_dictionary` VALUES (21010,20608,20198,'Test Test','2016-07-05 16:14:05','2016-07-05 16:15:25','year','年份',0,1,'','',1,'/21010/','/00001/','',0),(21011,20608,20198,'Test Test','2016-07-05 16:14:23','2016-07-05 16:15:25','','2014',1,1,'','',1,'/21010/21011/','/00001/00001/','',21010),(21012,20608,20198,'Test Test','2016-07-05 16:14:28','2016-07-05 16:15:25','2015','2015',1,2,'','',1,'/21010/21012/','/00001/00002/','',21010),(21013,20608,20198,'Test Test','2016-07-05 16:14:34','2016-07-05 16:15:25','2016','2016',1,3,'','',1,'/21010/21013/','/00001/00003/','',21010),(21014,20608,20198,'Test Test','2016-07-05 16:14:43','2016-07-05 16:15:25','2017','2017',1,4,'','',1,'/21010/21014/','/00001/00004/','',21010),(21015,20608,20198,'Test Test','2016-07-05 16:15:11','2016-07-05 20:30:26','rocordType','文种',0,2,'','',1,'/21015/','/00002/','',0),(21016,20608,20198,'Test Test','2016-07-05 16:15:59','2016-07-05 20:30:26','xingzheng','行政',1,1,'','',1,'/21015/21016/','/00002/00001/','',21015),(21017,20608,20198,'Test Test','2016-07-05 16:16:47','2016-07-05 20:30:26','dangwei','党委',1,2,'','',1,'/21015/21017/','/00002/00002/','',21015),(21018,20608,20198,'Test Test','2016-07-05 16:16:59','2016-07-05 20:30:26','gonghui','工会',1,3,'','',1,'/21015/21018/','/00002/00003/','',21015),(21019,20608,20198,'Test Test','2016-07-05 16:17:11','2016-07-05 20:30:26','bangongshi','办公室',1,4,'','',1,'/21015/21019/','/00002/00004/','',21015),(21020,20608,20198,'Test Test','2016-07-05 16:17:25','2016-07-05 20:30:26','jiyao','纪要',1,5,'','',1,'/21015/21020/','/00002/00005/','',21015),(21021,20608,20198,'Test Test','2016-07-05 16:17:39','2016-07-05 20:30:26','hangdaozhongxin','航道中心',1,6,'','',1,'/21015/21021/','/00002/00006/','',21015),(21022,20608,20198,'Test Test','2016-07-05 16:18:01','2016-07-05 16:18:37','securityLevel','密级',0,3,'','',1,'/21022/','/00003/','',0),(21023,20608,20198,'Test Test','2016-07-05 16:18:13','2016-07-05 16:18:13','jimi','机密',1,1,'','',1,'/21022/21023/','/00003/00001/','',21022),(21024,20608,20198,'Test Test','2016-07-05 16:18:20','2016-07-05 16:18:20','baomi','保密',1,2,'','',1,'/21022/21024/','/00003/00002/','',21022),(21025,20608,20198,'Test Test','2016-07-05 16:18:29','2016-07-05 16:18:29','yiban','一般',1,3,'','',1,'/21022/21025/','/00003/00003/','',21022),(21026,20608,20198,'Test Test','2016-07-05 16:18:37','2016-07-05 16:18:37','gongkai','公开',1,4,'','',1,'/21022/21026/','/00003/00004/','',21022),(21027,20608,20198,'Test Test','2016-07-05 16:19:12','2016-07-05 20:40:16','organaAbbreviation','代字',0,4,'','',1,'/21027/','/00004/','',0),(21028,20608,20198,'Test Test','2016-07-05 16:19:24','2016-07-05 20:40:16','hujiaojianguan','沪交建管',1,1,'','',1,'/21027/21028/','/00004/00001/','',21027),(21029,20608,20198,'Test Test','2016-07-05 16:19:45','2016-07-05 20:40:16','hujiaojianguanban','沪交建管办',1,2,'','',1,'/21027/21029/','/00004/00002/','',21027),(21030,20608,20198,'Test Test','2016-07-05 16:19:59','2016-07-05 16:20:38','urgencyDegree','紧急程度',0,5,'','',1,'/21030/','/00005/','',0),(21031,20608,20198,'Test Test','2016-07-05 16:20:16','2016-07-05 16:20:16','teji','特急',1,1,'','',1,'/21030/21031/','/00005/00001/','',21030),(21032,20608,20198,'Test Test','2016-07-05 16:20:22','2016-07-05 16:20:22','jinji','紧急',1,2,'','',1,'/21030/21032/','/00005/00002/','',21030),(21033,20608,20198,'Test Test','2016-07-05 16:20:38','2016-07-05 16:20:38','changgui','常规',1,3,'','',1,'/21030/21033/','/00005/00003/','',21030),(21127,20731,20198,'Test Test','2016-07-05 19:09:36','2016-07-05 19:15:20','ProjectType','施工许可项目类型',0,1,'','',1,'/21127/','/00001/','',0),(21128,20731,20198,'Test Test','2016-07-05 19:11:08','2016-07-05 19:16:32','','公路',1,2,'','',1,'/21127/21128/','/00001/00002/','',21127),(21129,20731,20198,'Test Test','2016-07-05 19:13:59','2016-07-05 19:16:17','','航道',1,1,'','',1,'/21127/21129/','/00001/00001/','',21127),(21130,20731,20198,'Test Test','2016-07-05 19:14:08','2016-07-05 19:14:08','','港口设施',1,3,'','',1,'/21127/21130/','/00001/00003/','',21127),(21131,20731,20198,'Test Test','2016-07-05 19:14:29','2016-07-05 19:14:55','','市政基础设施-隧道',1,4,'','',1,'/21127/21131/','/00001/00004/','',21127),(21132,20731,20198,'Test Test','2016-07-05 19:14:43','2016-07-05 19:14:43','','市政基础设施-轨道',1,5,'','',1,'/21127/21132/','/00001/00005/','',21127),(21133,20731,20198,'Test Test','2016-07-05 19:15:11','2016-07-05 19:15:11','','市政基础设施-公交场站',1,6,'','',1,'/21127/21133/','/00001/00006/','',21127),(21134,20731,20198,'Test Test','2016-07-05 19:15:20','2016-07-05 19:15:20','','市政基础设施-城市道路',1,7,'','',1,'/21127/21134/','/00001/00007/','',21127);
/*!40000 ALTER TABLE `sys_dictionary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemevent`
--

DROP TABLE IF EXISTS `systemevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systemevent` (
  `systemEventId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `classUuid` varchar(75) DEFAULT NULL,
  `referrerClassNameId` bigint(20) DEFAULT NULL,
  `parentSystemEventId` bigint(20) DEFAULT NULL,
  `systemEventSetKey` bigint(20) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  `extraData` longtext,
  PRIMARY KEY (`systemEventId`),
  KEY `IX_72D73D39` (`groupId`),
  KEY `IX_7A2F0ECE` (`groupId`,`classNameId`,`classPK`),
  KEY `IX_FFCBB747` (`groupId`,`classNameId`,`classPK`,`type_`),
  KEY `IX_A19C89FF` (`groupId`,`systemEventSetKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemevent`
--

LOCK TABLES `systemevent` WRITE;
/*!40000 ALTER TABLE `systemevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `systemevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `teamId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `description` longtext,
  PRIMARY KEY (`teamId`),
  UNIQUE KEY `IX_143DC786` (`groupId`,`name`),
  KEY `IX_AE6E9907` (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `ticketId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `key_` varchar(75) DEFAULT NULL,
  `type_` int(11) DEFAULT NULL,
  `extraInfo` longtext,
  `expirationDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ticketId`),
  KEY `IX_1E8DFB2E` (`classNameId`,`classPK`,`type_`),
  KEY `IX_B2468446` (`key_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (20853,20154,'2016-07-01 10:09:17',20005,20198,'dafd5e16-152a-464a-bd5d-de14b30f1c9d',2,'','2016-07-01 10:39:17'),(20854,20154,'2016-07-01 10:09:36',20005,20198,'6825c1f3-1728-46cc-b3c2-40278af80fea',2,'','2016-07-01 10:39:36');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trashentry`
--

DROP TABLE IF EXISTS `trashentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trashentry` (
  `entryId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `systemEventSetKey` bigint(20) DEFAULT NULL,
  `typeSettings` longtext,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`entryId`),
  UNIQUE KEY `IX_B35F73D5` (`classNameId`,`classPK`),
  KEY `IX_2674F2A8` (`companyId`),
  KEY `IX_526A032A` (`groupId`),
  KEY `IX_FC4EEA64` (`groupId`,`classNameId`),
  KEY `IX_6CAAE2E8` (`groupId`,`createDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trashentry`
--

LOCK TABLES `trashentry` WRITE;
/*!40000 ALTER TABLE `trashentry` DISABLE KEYS */;
/*!40000 ALTER TABLE `trashentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trashversion`
--

DROP TABLE IF EXISTS `trashversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trashversion` (
  `versionId` bigint(20) NOT NULL,
  `entryId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `typeSettings` longtext,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`versionId`),
  UNIQUE KEY `IX_D639348C` (`entryId`,`classNameId`,`classPK`),
  KEY `IX_630A643B` (`classNameId`,`classPK`),
  KEY `IX_55D44577` (`entryId`),
  KEY `IX_72D58D37` (`entryId`,`classNameId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trashversion`
--

LOCK TABLES `trashversion` WRITE;
/*!40000 ALTER TABLE `trashversion` DISABLE KEYS */;
/*!40000 ALTER TABLE `trashversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_`
--

DROP TABLE IF EXISTS `user_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_` (
  `uuid_` varchar(75) DEFAULT NULL,
  `userId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `defaultUser` tinyint(4) DEFAULT NULL,
  `contactId` bigint(20) DEFAULT NULL,
  `password_` varchar(75) DEFAULT NULL,
  `passwordEncrypted` tinyint(4) DEFAULT NULL,
  `passwordReset` tinyint(4) DEFAULT NULL,
  `passwordModifiedDate` datetime DEFAULT NULL,
  `digest` varchar(255) DEFAULT NULL,
  `reminderQueryQuestion` varchar(75) DEFAULT NULL,
  `reminderQueryAnswer` varchar(75) DEFAULT NULL,
  `graceLoginCount` int(11) DEFAULT NULL,
  `screenName` varchar(75) DEFAULT NULL,
  `emailAddress` varchar(75) DEFAULT NULL,
  `facebookId` bigint(20) DEFAULT NULL,
  `ldapServerId` bigint(20) DEFAULT NULL,
  `openId` varchar(1024) DEFAULT NULL,
  `portraitId` bigint(20) DEFAULT NULL,
  `languageId` varchar(75) DEFAULT NULL,
  `timeZoneId` varchar(75) DEFAULT NULL,
  `greeting` varchar(255) DEFAULT NULL,
  `comments` longtext,
  `firstName` varchar(75) DEFAULT NULL,
  `middleName` varchar(75) DEFAULT NULL,
  `lastName` varchar(75) DEFAULT NULL,
  `jobTitle` varchar(100) DEFAULT NULL,
  `loginDate` datetime DEFAULT NULL,
  `loginIP` varchar(75) DEFAULT NULL,
  `lastLoginDate` datetime DEFAULT NULL,
  `lastLoginIP` varchar(75) DEFAULT NULL,
  `lastFailedLoginDate` datetime DEFAULT NULL,
  `failedLoginAttempts` int(11) DEFAULT NULL,
  `lockout` tinyint(4) DEFAULT NULL,
  `lockoutDate` datetime DEFAULT NULL,
  `agreedToTermsOfUse` tinyint(4) DEFAULT NULL,
  `emailAddressVerified` tinyint(4) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `IX_615E9F7A` (`companyId`,`emailAddress`),
  UNIQUE KEY `IX_C5806019` (`companyId`,`screenName`),
  UNIQUE KEY `IX_9782AD88` (`companyId`,`userId`),
  UNIQUE KEY `IX_5ADBE171` (`contactId`),
  KEY `IX_3A1E834E` (`companyId`),
  KEY `IX_740C4D0C` (`companyId`,`createDate`),
  KEY `IX_BCFDA257` (`companyId`,`createDate`,`modifiedDate`),
  KEY `IX_6EF03E4E` (`companyId`,`defaultUser`),
  KEY `IX_1D731F03` (`companyId`,`facebookId`),
  KEY `IX_EE8ABD19` (`companyId`,`modifiedDate`),
  KEY `IX_F6039434` (`companyId`,`status`),
  KEY `IX_762F63C6` (`emailAddress`),
  KEY `IX_A18034A4` (`portraitId`),
  KEY `IX_E0422BDA` (`uuid_`),
  KEY `IX_405CC0E` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_`
--

LOCK TABLES `user_` WRITE;
/*!40000 ALTER TABLE `user_` DISABLE KEYS */;
INSERT INTO `user_` VALUES ('21a0bb50-4802-4995-9008-cec74a55fa19',20158,20154,'2016-06-30 20:51:57','2016-06-30 20:51:57',1,20159,'password',0,0,NULL,'5533ed38b5e33c076a804bb4bca644f9,4ab65718846308d51294d0f4dfbb74c2,4ab65718846308d51294d0f4dfbb74c2','','',0,'20158','default@liferay.com',0,0,'',0,'zh_CN','Asia/Shanghai','欢迎！','','','','','','2016-07-01 20:07:48','192.168.1.216','2016-06-30 20:51:57','192.168.1.216',NULL,0,0,NULL,1,0,0),('d7b06915-181d-4d23-9831-af3d920503ef',20198,20154,'2016-06-30 20:52:00','2016-06-30 20:52:23',0,20200,'AAAAoAAB9AD+DuhXk8x+ENaN+6LJhTj6iIqBrsBaF2FLFnut',1,0,'2016-07-01 09:05:05','43e1caee0f13b4576cdc1a845c35aea3,ce348fdaff13513e20fba3e96eeee5d6,3b399e692a990aa8fed3868969fa8306','what-is-your-father\'s-middle-name','test',0,'test','test@liferay.com',0,-1,'',0,'zh_CN','Asia/Shanghai','欢迎 Test Test！','','Test','','Test','','2016-07-05 20:40:45','192.168.1.62','2016-07-05 20:31:24','192.168.1.62','2016-07-05 19:59:36',0,0,NULL,0,1,0),('f4b995b4-2238-4833-b610-98f97c9e5639',20939,20154,'2016-07-01 14:50:31','2016-07-05 20:32:03',0,20940,'AAAAoAAB9AAtYxaxe4XqDGSd4YbyLz8A1xDUx6vWVYJ+pRbU',1,0,'2016-07-05 20:32:22','','what-is-your-father\'s-middle-name','test',0,'yangzhijie','yangzhijie@liferay.com',0,-1,'',0,'zh_CN','Asia/Shanghai','欢迎 杨志杰！','','杨志杰','','','','2016-07-05 20:32:14','192.168.1.62','2016-07-05 20:32:14','192.168.1.62','2016-07-05 20:31:14',0,0,NULL,0,0,0);
/*!40000 ALTER TABLE `user_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usergroup`
--

DROP TABLE IF EXISTS `usergroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usergroup` (
  `uuid_` varchar(75) DEFAULT NULL,
  `userGroupId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `parentUserGroupId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `description` longtext,
  `addedByLDAPImport` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`userGroupId`),
  UNIQUE KEY `IX_23EAD0D` (`companyId`,`name`),
  KEY `IX_524FEFCE` (`companyId`),
  KEY `IX_69771487` (`companyId`,`parentUserGroupId`),
  KEY `IX_5F1DD85A` (`uuid_`),
  KEY `IX_72394F8E` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usergroup`
--

LOCK TABLES `usergroup` WRITE;
/*!40000 ALTER TABLE `usergroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `usergroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usergroupgrouprole`
--

DROP TABLE IF EXISTS `usergroupgrouprole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usergroupgrouprole` (
  `userGroupId` bigint(20) NOT NULL,
  `groupId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`userGroupId`,`groupId`,`roleId`),
  KEY `IX_CCBE4063` (`groupId`),
  KEY `IX_CAB0CCC8` (`groupId`,`roleId`),
  KEY `IX_1CDF88C` (`roleId`),
  KEY `IX_DCDED558` (`userGroupId`),
  KEY `IX_73C52252` (`userGroupId`,`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usergroupgrouprole`
--

LOCK TABLES `usergroupgrouprole` WRITE;
/*!40000 ALTER TABLE `usergroupgrouprole` DISABLE KEYS */;
/*!40000 ALTER TABLE `usergroupgrouprole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usergrouprole`
--

DROP TABLE IF EXISTS `usergrouprole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usergrouprole` (
  `userId` bigint(20) NOT NULL,
  `groupId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`,`groupId`,`roleId`),
  KEY `IX_1B988D7A` (`groupId`),
  KEY `IX_871412DF` (`groupId`,`roleId`),
  KEY `IX_887A2C95` (`roleId`),
  KEY `IX_887BE56A` (`userId`),
  KEY `IX_4D040680` (`userId`,`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usergrouprole`
--

LOCK TABLES `usergrouprole` WRITE;
/*!40000 ALTER TABLE `usergrouprole` DISABLE KEYS */;
INSERT INTO `usergrouprole` VALUES (20198,20608,20171),(20198,20731,20171),(20198,20735,20171),(20198,20856,20167),(20198,20862,20167),(20939,20862,20938),(20198,20868,20167),(20198,20874,20167),(20198,20882,20167),(20198,20888,20167),(20198,20894,20167),(20198,20900,20167),(20198,20906,20167),(20198,20912,20167);
/*!40000 ALTER TABLE `usergrouprole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usergroups_teams`
--

DROP TABLE IF EXISTS `usergroups_teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usergroups_teams` (
  `teamId` bigint(20) NOT NULL,
  `userGroupId` bigint(20) NOT NULL,
  PRIMARY KEY (`teamId`,`userGroupId`),
  KEY `IX_31FB0B08` (`teamId`),
  KEY `IX_7F187E63` (`userGroupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usergroups_teams`
--

LOCK TABLES `usergroups_teams` WRITE;
/*!40000 ALTER TABLE `usergroups_teams` DISABLE KEYS */;
/*!40000 ALTER TABLE `usergroups_teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useridmapper`
--

DROP TABLE IF EXISTS `useridmapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useridmapper` (
  `userIdMapperId` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `type_` varchar(75) DEFAULT NULL,
  `description` varchar(75) DEFAULT NULL,
  `externalUserId` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`userIdMapperId`),
  UNIQUE KEY `IX_41A32E0D` (`type_`,`externalUserId`),
  UNIQUE KEY `IX_D1C44A6E` (`userId`,`type_`),
  KEY `IX_E60EA987` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useridmapper`
--

LOCK TABLES `useridmapper` WRITE;
/*!40000 ALTER TABLE `useridmapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `useridmapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usernotificationdelivery`
--

DROP TABLE IF EXISTS `usernotificationdelivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usernotificationdelivery` (
  `userNotificationDeliveryId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `portletId` varchar(200) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `notificationType` int(11) DEFAULT NULL,
  `deliveryType` int(11) DEFAULT NULL,
  `deliver` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`userNotificationDeliveryId`),
  UNIQUE KEY `IX_8B6E3ACE` (`userId`,`portletId`,`classNameId`,`notificationType`,`deliveryType`),
  KEY `IX_C648700A` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usernotificationdelivery`
--

LOCK TABLES `usernotificationdelivery` WRITE;
/*!40000 ALTER TABLE `usernotificationdelivery` DISABLE KEYS */;
/*!40000 ALTER TABLE `usernotificationdelivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usernotificationevent`
--

DROP TABLE IF EXISTS `usernotificationevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usernotificationevent` (
  `uuid_` varchar(75) DEFAULT NULL,
  `userNotificationEventId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `type_` varchar(75) DEFAULT NULL,
  `timestamp` bigint(20) DEFAULT NULL,
  `deliverBy` bigint(20) DEFAULT NULL,
  `delivered` tinyint(4) DEFAULT NULL,
  `payload` longtext,
  `archived` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`userNotificationEventId`),
  KEY `IX_3E5D78C4` (`userId`),
  KEY `IX_3DBB361A` (`userId`,`archived`),
  KEY `IX_24F1BF0` (`userId`,`delivered`),
  KEY `IX_ECD8CFEA` (`uuid_`),
  KEY `IX_A6BAFDFE` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usernotificationevent`
--

LOCK TABLES `usernotificationevent` WRITE;
/*!40000 ALTER TABLE `usernotificationevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `usernotificationevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_groups`
--

DROP TABLE IF EXISTS `users_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_groups` (
  `groupId` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL,
  PRIMARY KEY (`groupId`,`userId`),
  KEY `IX_C4F9E699` (`groupId`),
  KEY `IX_F10B6C6B` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_groups`
--

LOCK TABLES `users_groups` WRITE;
/*!40000 ALTER TABLE `users_groups` DISABLE KEYS */;
INSERT INTO `users_groups` VALUES (20181,20198),(20608,20198),(20731,20198),(20735,20198);
/*!40000 ALTER TABLE `users_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_orgs`
--

DROP TABLE IF EXISTS `users_orgs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_orgs` (
  `organizationId` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL,
  PRIMARY KEY (`organizationId`,`userId`),
  KEY `IX_7EF4EC0E` (`organizationId`),
  KEY `IX_FB646CA6` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_orgs`
--

LOCK TABLES `users_orgs` WRITE;
/*!40000 ALTER TABLE `users_orgs` DISABLE KEYS */;
INSERT INTO `users_orgs` VALUES (20861,20939);
/*!40000 ALTER TABLE `users_orgs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_roles` (
  `roleId` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL,
  PRIMARY KEY (`roleId`,`userId`),
  KEY `IX_C19E5F31` (`roleId`),
  KEY `IX_C1A01806` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (20161,20198),(20162,20158),(20164,20198),(20164,20939),(20165,20198),(20165,20939);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_teams`
--

DROP TABLE IF EXISTS `users_teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_teams` (
  `teamId` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL,
  PRIMARY KEY (`teamId`,`userId`),
  KEY `IX_4D06AD51` (`teamId`),
  KEY `IX_A098EFBF` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_teams`
--

LOCK TABLES `users_teams` WRITE;
/*!40000 ALTER TABLE `users_teams` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_usergroups`
--

DROP TABLE IF EXISTS `users_usergroups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_usergroups` (
  `userId` bigint(20) NOT NULL,
  `userGroupId` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`,`userGroupId`),
  KEY `IX_66FF2503` (`userGroupId`),
  KEY `IX_BE8102D6` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_usergroups`
--

LOCK TABLES `users_usergroups` WRITE;
/*!40000 ALTER TABLE `users_usergroups` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_usergroups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertracker`
--

DROP TABLE IF EXISTS `usertracker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertracker` (
  `userTrackerId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `sessionId` varchar(200) DEFAULT NULL,
  `remoteAddr` varchar(75) DEFAULT NULL,
  `remoteHost` varchar(75) DEFAULT NULL,
  `userAgent` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`userTrackerId`),
  KEY `IX_29BA1CF5` (`companyId`),
  KEY `IX_46B0AE8E` (`sessionId`),
  KEY `IX_E4EFBA8D` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertracker`
--

LOCK TABLES `usertracker` WRITE;
/*!40000 ALTER TABLE `usertracker` DISABLE KEYS */;
/*!40000 ALTER TABLE `usertracker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertrackerpath`
--

DROP TABLE IF EXISTS `usertrackerpath`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertrackerpath` (
  `userTrackerPathId` bigint(20) NOT NULL,
  `userTrackerId` bigint(20) DEFAULT NULL,
  `path_` longtext,
  `pathDate` datetime DEFAULT NULL,
  PRIMARY KEY (`userTrackerPathId`),
  KEY `IX_14D8BCC0` (`userTrackerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertrackerpath`
--

LOCK TABLES `usertrackerpath` WRITE;
/*!40000 ALTER TABLE `usertrackerpath` DISABLE KEYS */;
/*!40000 ALTER TABLE `usertrackerpath` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `virtualhost`
--

DROP TABLE IF EXISTS `virtualhost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `virtualhost` (
  `virtualHostId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `layoutSetId` bigint(20) DEFAULT NULL,
  `hostname` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`virtualHostId`),
  UNIQUE KEY `IX_A083D394` (`companyId`,`layoutSetId`),
  UNIQUE KEY `IX_431A3960` (`hostname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `virtualhost`
--

LOCK TABLES `virtualhost` WRITE;
/*!40000 ALTER TABLE `virtualhost` DISABLE KEYS */;
INSERT INTO `virtualhost` VALUES (20157,20154,0,'localhost');
/*!40000 ALTER TABLE `virtualhost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `webdavprops`
--

DROP TABLE IF EXISTS `webdavprops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `webdavprops` (
  `webDavPropsId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `props` longtext,
  PRIMARY KEY (`webDavPropsId`),
  UNIQUE KEY `IX_97DFA146` (`classNameId`,`classPK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webdavprops`
--

LOCK TABLES `webdavprops` WRITE;
/*!40000 ALTER TABLE `webdavprops` DISABLE KEYS */;
/*!40000 ALTER TABLE `webdavprops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `website`
--

DROP TABLE IF EXISTS `website`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `website` (
  `uuid_` varchar(75) DEFAULT NULL,
  `websiteId` bigint(20) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `url` longtext,
  `typeId` int(11) DEFAULT NULL,
  `primary_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`websiteId`),
  KEY `IX_96F07007` (`companyId`),
  KEY `IX_4F0F0CA7` (`companyId`,`classNameId`),
  KEY `IX_F960131C` (`companyId`,`classNameId`,`classPK`),
  KEY `IX_1AA07A6D` (`companyId`,`classNameId`,`classPK`,`primary_`),
  KEY `IX_F75690BB` (`userId`),
  KEY `IX_76F15D13` (`uuid_`),
  KEY `IX_712BCD35` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `website`
--

LOCK TABLES `website` WRITE;
/*!40000 ALTER TABLE `website` DISABLE KEYS */;
/*!40000 ALTER TABLE `website` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wikinode`
--

DROP TABLE IF EXISTS `wikinode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wikinode` (
  `uuid_` varchar(75) DEFAULT NULL,
  `nodeId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `description` longtext,
  `lastPostDate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`nodeId`),
  UNIQUE KEY `IX_920CD8B1` (`groupId`,`name`),
  UNIQUE KEY `IX_7609B2AE` (`uuid_`,`groupId`),
  KEY `IX_5D6FE3F0` (`companyId`),
  KEY `IX_B54332D6` (`companyId`,`status`),
  KEY `IX_B480A672` (`groupId`),
  KEY `IX_23325358` (`groupId`,`status`),
  KEY `IX_6C112D7C` (`uuid_`),
  KEY `IX_E0E6D12C` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wikinode`
--

LOCK TABLES `wikinode` WRITE;
/*!40000 ALTER TABLE `wikinode` DISABLE KEYS */;
/*!40000 ALTER TABLE `wikinode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wikipage`
--

DROP TABLE IF EXISTS `wikipage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wikipage` (
  `uuid_` varchar(75) DEFAULT NULL,
  `pageId` bigint(20) NOT NULL,
  `resourcePrimKey` bigint(20) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `nodeId` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `version` double DEFAULT NULL,
  `minorEdit` tinyint(4) DEFAULT NULL,
  `content` longtext,
  `summary` longtext,
  `format` varchar(75) DEFAULT NULL,
  `head` tinyint(4) DEFAULT NULL,
  `parentTitle` varchar(255) DEFAULT NULL,
  `redirectTitle` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusByUserId` bigint(20) DEFAULT NULL,
  `statusByUserName` varchar(75) DEFAULT NULL,
  `statusDate` datetime DEFAULT NULL,
  PRIMARY KEY (`pageId`),
  UNIQUE KEY `IX_3D4AF476` (`nodeId`,`title`,`version`),
  UNIQUE KEY `IX_2CD67C81` (`resourcePrimKey`,`nodeId`,`version`),
  UNIQUE KEY `IX_899D3DFB` (`uuid_`,`groupId`),
  KEY `IX_A2001730` (`format`),
  KEY `IX_16E99B0A` (`groupId`,`nodeId`,`head`),
  KEY `IX_BA72B89A` (`groupId`,`nodeId`,`head`,`parentTitle`,`status`),
  KEY `IX_E0092FF0` (`groupId`,`nodeId`,`head`,`status`),
  KEY `IX_941E429C` (`groupId`,`nodeId`,`status`),
  KEY `IX_5FF21CE6` (`groupId`,`nodeId`,`title`,`head`),
  KEY `IX_CAA451D6` (`groupId`,`userId`,`nodeId`,`status`),
  KEY `IX_C8A9C476` (`nodeId`),
  KEY `IX_E7F635CA` (`nodeId`,`head`),
  KEY `IX_65E84AF4` (`nodeId`,`head`,`parentTitle`),
  KEY `IX_9F7655DA` (`nodeId`,`head`,`parentTitle`,`status`),
  KEY `IX_64CCB282` (`nodeId`,`head`,`redirectTitle`),
  KEY `IX_40F94F68` (`nodeId`,`head`,`redirectTitle`,`status`),
  KEY `IX_432F0AB0` (`nodeId`,`head`,`status`),
  KEY `IX_46EEF3C8` (`nodeId`,`parentTitle`),
  KEY `IX_1ECC7656` (`nodeId`,`redirectTitle`),
  KEY `IX_546F2D5C` (`nodeId`,`status`),
  KEY `IX_997EEDD2` (`nodeId`,`title`),
  KEY `IX_E745EA26` (`nodeId`,`title`,`head`),
  KEY `IX_BEA33AB8` (`nodeId`,`title`,`status`),
  KEY `IX_85E7CC76` (`resourcePrimKey`),
  KEY `IX_B771D67` (`resourcePrimKey`,`nodeId`),
  KEY `IX_E1F55FB` (`resourcePrimKey`,`nodeId`,`head`),
  KEY `IX_94D1054D` (`resourcePrimKey`,`nodeId`,`status`),
  KEY `IX_1725355C` (`resourcePrimKey`,`status`),
  KEY `IX_FBBE7C96` (`userId`,`nodeId`,`status`),
  KEY `IX_9C0E478F` (`uuid_`),
  KEY `IX_5DC4BD39` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wikipage`
--

LOCK TABLES `wikipage` WRITE;
/*!40000 ALTER TABLE `wikipage` DISABLE KEYS */;
/*!40000 ALTER TABLE `wikipage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wikipageresource`
--

DROP TABLE IF EXISTS `wikipageresource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wikipageresource` (
  `uuid_` varchar(75) DEFAULT NULL,
  `resourcePrimKey` bigint(20) NOT NULL,
  `nodeId` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`resourcePrimKey`),
  UNIQUE KEY `IX_21277664` (`nodeId`,`title`),
  KEY `IX_BE898221` (`uuid_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wikipageresource`
--

LOCK TABLES `wikipageresource` WRITE;
/*!40000 ALTER TABLE `wikipageresource` DISABLE KEYS */;
/*!40000 ALTER TABLE `wikipageresource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflowdefinitionlink`
--

DROP TABLE IF EXISTS `workflowdefinitionlink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflowdefinitionlink` (
  `workflowDefinitionLinkId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `typePK` bigint(20) DEFAULT NULL,
  `workflowDefinitionName` varchar(75) DEFAULT NULL,
  `workflowDefinitionVersion` int(11) DEFAULT NULL,
  PRIMARY KEY (`workflowDefinitionLinkId`),
  KEY `IX_A8B0D276` (`companyId`),
  KEY `IX_A4DB1F0F` (`companyId`,`workflowDefinitionName`,`workflowDefinitionVersion`),
  KEY `IX_B6EE8C9E` (`groupId`,`companyId`,`classNameId`),
  KEY `IX_1E5B9905` (`groupId`,`companyId`,`classNameId`,`classPK`),
  KEY `IX_705B40EE` (`groupId`,`companyId`,`classNameId`,`classPK`,`typePK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflowdefinitionlink`
--

LOCK TABLES `workflowdefinitionlink` WRITE;
/*!40000 ALTER TABLE `workflowdefinitionlink` DISABLE KEYS */;
/*!40000 ALTER TABLE `workflowdefinitionlink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflowinstancelink`
--

DROP TABLE IF EXISTS `workflowinstancelink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflowinstancelink` (
  `workflowInstanceLinkId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `workflowInstanceId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`workflowInstanceLinkId`),
  KEY `IX_415A7007` (`groupId`,`companyId`,`classNameId`,`classPK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflowinstancelink`
--

LOCK TABLES `workflowinstancelink` WRITE;
/*!40000 ALTER TABLE `workflowinstancelink` DISABLE KEYS */;
/*!40000 ALTER TABLE `workflowinstancelink` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-06  9:43:13
