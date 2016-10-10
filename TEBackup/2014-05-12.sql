-- MySQL dump 10.13  Distrib 5.5.29, for Win64 (x86)
--
-- Host: localhost    Database: te
-- ------------------------------------------------------
-- Server version	5.5.29

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
-- Table structure for table `mst_customer`
--

DROP TABLE IF EXISTS `mst_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_customer` (
  `CUSTOMER_NO` int(11) NOT NULL AUTO_INCREMENT,
  `BR_NO` varchar(15) DEFAULT NULL,
  `NAME` varchar(50) NOT NULL,
  `DOB` date NOT NULL,
  `PHONE` varchar(10) NOT NULL,
  `EMAIL` varchar(40) DEFAULT NULL,
  `TYPE_NO` int(11) NOT NULL,
  `FLAG` varchar(2) NOT NULL,
  `DATE_CREATED` date NOT NULL,
  `DATE_UPDATED` date DEFAULT NULL,
  `DATE_DELETED` date DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_NO`),
  KEY `MST_CUSTOMER_FK1` (`TYPE_NO`),
  CONSTRAINT `MST_CUSTOMER_FK1` FOREIGN KEY (`TYPE_NO`) REFERENCES `mst_type` (`TYPE_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_customer`
--

LOCK TABLES `mst_customer` WRITE;
/*!40000 ALTER TABLE `mst_customer` DISABLE KEYS */;
INSERT INTO `mst_customer` VALUES (1,'100000000000002','Dexter','2014-05-05','6532655487','dexter@g.com',2,'I','2014-05-08','2014-05-08',NULL),(2,'100000000000000','Deedee','2014-05-02','9887656662','dd@g.com',3,'U','2014-05-08','2014-05-10',NULL),(3,'','mandark','2014-05-08','9865326598','mandark@g.com',1,'I','2014-05-09',NULL,NULL);
/*!40000 ALTER TABLE `mst_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_lap`
--

DROP TABLE IF EXISTS `mst_lap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_lap` (
  `SL_NO` int(11) NOT NULL AUTO_INCREMENT,
  `NO_OF_LAPS` int(11) NOT NULL,
  `FEE` int(11) NOT NULL,
  `TYPE_NO` int(11) NOT NULL,
  `FLAG` varchar(2) NOT NULL,
  `DATE_CREATED` date NOT NULL,
  `DATE_UPDATED` date DEFAULT NULL,
  `DATE_DELETED` date DEFAULT NULL,
  PRIMARY KEY (`SL_NO`),
  KEY `MST_LAP_FK1` (`TYPE_NO`),
  CONSTRAINT `MST_LAP_FK1` FOREIGN KEY (`TYPE_NO`) REFERENCES `mst_type` (`TYPE_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_lap`
--

LOCK TABLES `mst_lap` WRITE;
/*!40000 ALTER TABLE `mst_lap` DISABLE KEYS */;
INSERT INTO `mst_lap` VALUES (1,5,100,1,'I','2014-05-01',NULL,NULL),(2,5,90,2,'I','2014-05-01',NULL,NULL),(3,5,80,3,'I','2014-05-01',NULL,NULL),(4,8,250,1,'U','2014-05-01','2014-05-01',NULL),(5,8,225,2,'U','2014-05-01','2014-05-01',NULL),(6,8,200,3,'I','2014-05-01',NULL,NULL);
/*!40000 ALTER TABLE `mst_lap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_login`
--

DROP TABLE IF EXISTS `mst_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_login` (
  `PASSWORD` varchar(15) NOT NULL,
  `ACCESS` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_login`
--

LOCK TABLES `mst_login` WRITE;
/*!40000 ALTER TABLE `mst_login` DISABLE KEYS */;
INSERT INTO `mst_login` VALUES ('1234','Main'),('qwer','Tran');
/*!40000 ALTER TABLE `mst_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_min_sc`
--

DROP TABLE IF EXISTS `mst_min_sc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_min_sc` (
  `SL_NO` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE_NO` int(11) NOT NULL,
  `FEE` int(11) NOT NULL,
  `FLAG` varchar(2) NOT NULL,
  `DATE_CREATED` date NOT NULL,
  `DATE_UPDATED` date DEFAULT NULL,
  `DATE_DELETED` date DEFAULT NULL,
  PRIMARY KEY (`SL_NO`),
  KEY `MST_MIN_SC_FK1` (`TYPE_NO`),
  CONSTRAINT `MST_MIN_SC_FK1` FOREIGN KEY (`TYPE_NO`) REFERENCES `mst_type` (`TYPE_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_min_sc`
--

LOCK TABLES `mst_min_sc` WRITE;
/*!40000 ALTER TABLE `mst_min_sc` DISABLE KEYS */;
INSERT INTO `mst_min_sc` VALUES (1,2,8000,'D','2014-05-08','2014-05-08','2014-05-08'),(2,3,17000,'U','2014-05-08','2014-05-08',NULL),(3,2,5000,'I','2014-05-08',NULL,NULL);
/*!40000 ALTER TABLE `mst_min_sc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_tax`
--

DROP TABLE IF EXISTS `mst_tax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_tax` (
  `TAX_NO` int(11) NOT NULL AUTO_INCREMENT,
  `TAX` decimal(5,2) NOT NULL,
  `FLAG` varchar(2) NOT NULL,
  `DATE_CREATED` date NOT NULL,
  `DATE_UPDATED` date DEFAULT NULL,
  `DATE_DELETED` date DEFAULT NULL,
  PRIMARY KEY (`TAX_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_tax`
--

LOCK TABLES `mst_tax` WRITE;
/*!40000 ALTER TABLE `mst_tax` DISABLE KEYS */;
INSERT INTO `mst_tax` VALUES (1,15.00,'U','2005-08-14','2014-05-08',NULL);
/*!40000 ALTER TABLE `mst_tax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_type`
--

DROP TABLE IF EXISTS `mst_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_type` (
  `TYPE_NO` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL,
  `TYPE` varchar(10) NOT NULL,
  `FLAG` varchar(2) NOT NULL,
  `DATE_CREATED` date NOT NULL,
  `DATE_UPDATED` date DEFAULT NULL,
  `DATE_DELETED` date DEFAULT NULL,
  PRIMARY KEY (`TYPE_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_type`
--

LOCK TABLES `mst_type` WRITE;
/*!40000 ALTER TABLE `mst_type` DISABLE KEYS */;
INSERT INTO `mst_type` VALUES (1,'CASUAL','CASUAL','U','2014-05-01','2014-05-01',NULL),(2,'1/2 YEAR MEMBER','PRIVILEGE','I','2014-05-01',NULL,NULL),(3,'1 YEAR MEMBER','PRIVILEGE','U','2014-05-01','2014-05-01',NULL),(4,'CASUAL','PRIVILEGE','D','2014-05-04',NULL,'2014-05-04'),(5,'CASUAL1','CASUAL','D','2014-05-08',NULL,'2014-05-08');
/*!40000 ALTER TABLE `mst_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trn_account`
--

DROP TABLE IF EXISTS `trn_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trn_account` (
  `SL_NO` int(11) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_NO` int(11) NOT NULL,
  `DATE` date NOT NULL,
  `AMOUNT` decimal(8,2) NOT NULL,
  `FLAG` varchar(2) NOT NULL,
  `DATE_CREATED` date NOT NULL,
  `DATE_UPDATED` date DEFAULT NULL,
  `DATE_DELETED` date DEFAULT NULL,
  PRIMARY KEY (`SL_NO`),
  KEY `TRN_ACCOUNT_FK1` (`CUSTOMER_NO`),
  CONSTRAINT `TRN_ACCOUNT_FK1` FOREIGN KEY (`CUSTOMER_NO`) REFERENCES `mst_customer` (`CUSTOMER_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_account`
--

LOCK TABLES `trn_account` WRITE;
/*!40000 ALTER TABLE `trn_account` DISABLE KEYS */;
INSERT INTO `trn_account` VALUES (1,2,'2014-05-08',10000.00,'I','2014-05-08',NULL,NULL),(2,1,'2014-05-08',10000.00,'I','2014-05-08',NULL,NULL),(3,2,'2014-05-08',15000.00,'I','2014-05-08',NULL,NULL);
/*!40000 ALTER TABLE `trn_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trn_history`
--

DROP TABLE IF EXISTS `trn_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trn_history` (
  `SL_NO` int(11) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_NO` int(11) NOT NULL,
  `DATE` date NOT NULL,
  `NO_OF_LAPS` int(11) NOT NULL,
  `FEE` decimal(7,2) NOT NULL,
  `FLAG` varchar(2) NOT NULL,
  `DATE_CREATED` date NOT NULL,
  `DATE_UPDATED` date DEFAULT NULL,
  `DATE_DELETED` date DEFAULT NULL,
  PRIMARY KEY (`SL_NO`),
  KEY `TRN_HISTORY_FK1` (`CUSTOMER_NO`),
  CONSTRAINT `TRN_HISTORY_FK1` FOREIGN KEY (`CUSTOMER_NO`) REFERENCES `mst_customer` (`CUSTOMER_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_history`
--

LOCK TABLES `trn_history` WRITE;
/*!40000 ALTER TABLE `trn_history` DISABLE KEYS */;
INSERT INTO `trn_history` VALUES (1,1,'2014-05-08',5,115.00,'I','2014-05-08',NULL,NULL),(2,1,'2014-05-08',5,100.00,'I','2014-05-08',NULL,NULL),(3,2,'2014-05-08',8,258.75,'I','2014-05-08',NULL,NULL),(4,2,'2014-05-08',8,225.00,'I','2014-05-08',NULL,NULL),(5,2,'2014-05-08',8,225.00,'I','2014-05-08',NULL,NULL),(6,2,'2014-05-08',8,258.75,'I','2014-05-08',NULL,NULL),(7,2,'2014-05-08',5,103.50,'I','2014-05-08',NULL,NULL),(8,3,'2014-05-09',5,115.00,'I','2014-05-09',NULL,NULL);
/*!40000 ALTER TABLE `trn_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-12 13:18:50
