-- MySQL dump 10.13  Distrib 5.6.28, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: DocArchive
-- ------------------------------------------------------
-- Server version	5.6.28-0ubuntu0.15.04.1

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
-- Table structure for table `document_detail`
--

DROP TABLE IF EXISTS `document_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime NOT NULL,
  `doc_name` varchar(255) NOT NULL,
  `doc_purpose` varchar(255) NOT NULL,
  `file_path` varchar(255) NOT NULL,
  `modified_by` varchar(255) NOT NULL,
  `modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_detail`
--

LOCK TABLES `document_detail` WRITE;
/*!40000 ALTER TABLE `document_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `document_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_metadata`
--

DROP TABLE IF EXISTS `document_metadata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document_metadata` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `col_name` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime NOT NULL,
  `documentdetails_id` bigint(20) NOT NULL,
  `meta_value` varchar(255) NOT NULL,
  `modified_by` varchar(255) NOT NULL,
  `modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pvgkiv3muhwbxvjp3lbg1m1pv` (`documentdetails_id`),
  CONSTRAINT `FK_pvgkiv3muhwbxvjp3lbg1m1pv` FOREIGN KEY (`documentdetails_id`) REFERENCES `document_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_metadata`
--

LOCK TABLES `document_metadata` WRITE;
/*!40000 ALTER TABLE `document_metadata` DISABLE KEYS */;
/*!40000 ALTER TABLE `document_metadata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sec_role`
--

DROP TABLE IF EXISTS `sec_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sec_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `authority` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_oah023x2ltqw09mdue7w0mcxb` (`authority`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sec_role`
--

LOCK TABLES `sec_role` WRITE;
/*!40000 ALTER TABLE `sec_role` DISABLE KEYS */;
INSERT INTO `sec_role` VALUES (1,0,'ROLE_ROYALTY'),(2,0,'ROLE_COMMON');
/*!40000 ALTER TABLE `sec_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sec_user`
--

DROP TABLE IF EXISTS `sec_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sec_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `account_expired` bit(1) NOT NULL,
  `account_locked` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `password_expired` bit(1) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5ctbdrlf3eismye20vsdtk8w8` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sec_user`
--

LOCK TABLES `sec_user` WRITE;
/*!40000 ALTER TABLE `sec_user` DISABLE KEYS */;
INSERT INTO `sec_user` VALUES (1,0,'\0','\0','','$2a$10$tqo7gr/iDQaMSzPh.lhdWuT/e2H8PKcpx3nKGa7sk87EPW0NPsMOe','\0','admin'),(2,0,'\0','\0','','$2a$10$BQrXbgE0MWLc4mBEHqG7aOg.THnGFfhvS6F589aFPWKkg.m5.2qIS','\0','user'),(3,0,'\0','\0','','$2a$10$zbcfOzjxTWdyA7z1uP90Ye6cONaBMpkptOQgv1tn9aMi1aWFaEDMm','\0','deepak');
/*!40000 ALTER TABLE `sec_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sec_user_sec_role`
--

DROP TABLE IF EXISTS `sec_user_sec_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sec_user_sec_role` (
  `sec_user_id` bigint(20) NOT NULL,
  `sec_role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`sec_user_id`,`sec_role_id`),
  KEY `FK_bshvqhdx8h9mb4rrbo1ahnp7q` (`sec_role_id`),
  CONSTRAINT `FK_bshvqhdx8h9mb4rrbo1ahnp7q` FOREIGN KEY (`sec_role_id`) REFERENCES `sec_role` (`id`),
  CONSTRAINT `FK_f1eew3u65ajs3e50xvacwgron` FOREIGN KEY (`sec_user_id`) REFERENCES `sec_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sec_user_sec_role`
--

LOCK TABLES `sec_user_sec_role` WRITE;
/*!40000 ALTER TABLE `sec_user_sec_role` DISABLE KEYS */;
INSERT INTO `sec_user_sec_role` VALUES (1,1),(1,2),(2,2),(3,2);
/*!40000 ALTER TABLE `sec_user_sec_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-17 15:09:57
