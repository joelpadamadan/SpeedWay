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
  `MEMBERSHIP_DATE` date DEFAULT NULL,
  `DATE_UPDATED` date DEFAULT NULL,
  `DATE_DELETED` date DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_NO`),
  KEY `MST_CUSTOMER_FK1` (`TYPE_NO`),
  CONSTRAINT `MST_CUSTOMER_FK1` FOREIGN KEY (`TYPE_NO`) REFERENCES `mst_type` (`TYPE_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_customer`
--

LOCK TABLES `mst_customer` WRITE;
/*!40000 ALTER TABLE `mst_customer` DISABLE KEYS */;
INSERT INTO `mst_customer` VALUES (1,'','dexter','2014-05-15','9895281499','dexter@g.com',1,'I','2014-05-15',NULL,NULL,NULL),(2,'','deedee','2014-05-15','9633493265','dd@g.com',1,'I','2014-05-15',NULL,NULL,NULL),(3,'100000000000000','mandark','2014-05-15','8281774241','mandark@g.com',4,'I','2014-05-15','2015-06-01','2015-06-01',NULL),(4,'100000000000001','casper','2014-05-15','9995034655','casper@g.com',1,'I','2014-05-15','2014-05-15',NULL,NULL),(5,'','Scoobee doo','2014-05-16','9645969777','sc@g.com',1,'I','2014-05-16',NULL,NULL,NULL),(6,'100000000000003','Jetson','2014-05-16','8281071144','j@g.com',4,'I','2014-05-16','2014-05-16',NULL,NULL),(7,'','Jonny Bravo','2014-05-16','9999999999','john@g.com',1,'I','2014-05-16',NULL,NULL,NULL),(8,'','He-Man','2014-05-16','8888888888','heman@g.com',1,'I','2014-05-16',NULL,NULL,NULL),(11,'100000000000004','Garfield','2014-05-16','7777777777','garfield@g.com',4,'I','2014-05-16','2014-05-16',NULL,NULL),(12,'','Chipmunk','2014-05-16','6666666666','chipmunk@g.com',1,'I','2014-05-16',NULL,NULL,NULL),(22,'','Blossom','2014-05-16','5555555555','blossom@g.com',1,'I','2014-05-16',NULL,NULL,NULL),(23,'100000000000005','Chandler','2014-05-16','4444444444','chandler@g.com',4,'I','2014-05-16','2014-05-16',NULL,NULL);
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
  `NO_OF_LAPS` varchar(5) NOT NULL,
  `FEE` int(11) NOT NULL,
  `TYPE_NO` int(11) NOT NULL,
  `FLAG` varchar(2) NOT NULL,
  `DATE_CREATED` date NOT NULL,
  `DATE_UPDATED` date DEFAULT NULL,
  `DATE_DELETED` date DEFAULT NULL,
  PRIMARY KEY (`SL_NO`),
  KEY `MST_LAP_FK1` (`TYPE_NO`),
  CONSTRAINT `MST_LAP_FK1` FOREIGN KEY (`TYPE_NO`) REFERENCES `mst_type` (`TYPE_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_lap`
--

LOCK TABLES `mst_lap` WRITE;
/*!40000 ALTER TABLE `mst_lap` DISABLE KEYS */;
INSERT INTO `mst_lap` VALUES (1,'5',250,1,'U','2014-05-15','2014-05-15',NULL),(2,'10',500,1,'U','2014-05-15','2014-05-15',NULL),(3,'5C',250,3,'I','2014-05-15',NULL,NULL),(4,'10C',500,3,'I','2014-05-15',NULL,NULL),(5,'5',200,3,'I','2014-05-15',NULL,NULL),(6,'10',400,3,'I','2014-05-15',NULL,NULL),(7,'5C',250,4,'I','2014-05-15',NULL,NULL),(8,'10C',500,4,'I','2014-05-15',NULL,NULL),(9,'5',200,4,'I','2014-05-15',NULL,NULL),(10,'10',400,4,'I','2014-05-15',NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_min_sc`
--

LOCK TABLES `mst_min_sc` WRITE;
/*!40000 ALTER TABLE `mst_min_sc` DISABLE KEYS */;
INSERT INTO `mst_min_sc` VALUES (1,3,5200,'U','2014-05-15','2014-05-15',NULL),(2,4,10400,'I','2014-05-15',NULL,NULL);
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
INSERT INTO `mst_tax` VALUES (1,30.00,'U','2005-08-14','2014-05-15',NULL);
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
  `VALIDITY` int(11) NOT NULL,
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
INSERT INTO `mst_type` VALUES (1,'CASUAL','CASUAL',0,'U','2014-05-15','2014-05-15',NULL),(2,'1 YR. MEMBERSHIP','PRIVILEGE',12,'D','2014-05-15',NULL,'2014-05-15'),(3,'1/2 YR. MEMBERSHIP','PRIVILEGE',6,'I','2014-05-15',NULL,NULL),(4,'1 YR. MEMBERSHIP','PRIVILEGE',12,'U','2014-05-15','2014-05-15',NULL),(5,'ASDASD','PRIVILEGE',33,'D','2014-05-15',NULL,'2014-05-15');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_account`
--

LOCK TABLES `trn_account` WRITE;
/*!40000 ALTER TABLE `trn_account` DISABLE KEYS */;
INSERT INTO `trn_account` VALUES (1,3,'2014-05-15',10400.00,'I','2014-05-15',NULL,NULL),(2,3,'2015-06-01',10400.00,'I','2015-06-01',NULL,NULL),(3,3,'2015-06-01',10400.00,'I','2015-06-01',NULL,NULL),(4,4,'2014-05-15',5200.00,'I','2014-05-15',NULL,NULL),(5,6,'2014-05-16',10400.00,'I','2014-05-16',NULL,NULL),(6,11,'2014-05-16',10400.00,'I','2014-05-16',NULL,NULL),(7,23,'2014-05-16',10400.00,'I','2014-05-16',NULL,NULL);
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
  `NO_OF_LAPS` varchar(5) NOT NULL,
  `FEE` decimal(7,2) NOT NULL,
  `FLAG` varchar(2) NOT NULL,
  `DATE_CREATED` date NOT NULL,
  `DATE_UPDATED` date DEFAULT NULL,
  `DATE_DELETED` date DEFAULT NULL,
  PRIMARY KEY (`SL_NO`),
  KEY `TRN_HISTORY_FK1` (`CUSTOMER_NO`),
  CONSTRAINT `TRN_HISTORY_FK1` FOREIGN KEY (`CUSTOMER_NO`) REFERENCES `mst_customer` (`CUSTOMER_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_history`
--

LOCK TABLES `trn_history` WRITE;
/*!40000 ALTER TABLE `trn_history` DISABLE KEYS */;
INSERT INTO `trn_history` VALUES (1,23,'2014-05-17','10C',650.00,'I','2014-05-17',NULL,NULL);
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

-- Dump completed on 2014-05-17  7:08:47
