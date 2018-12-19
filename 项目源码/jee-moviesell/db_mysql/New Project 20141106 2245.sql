-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.50-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema jeemoviesell
--

CREATE DATABASE IF NOT EXISTS jeemoviesell;
USE jeemoviesell;

--
-- Definition of table `administraors`
--

DROP TABLE IF EXISTS `administraors`;
CREATE TABLE `administraors` (
  `ano` int(11) NOT NULL AUTO_INCREMENT,
  `aaccount` varchar(20) NOT NULL,
  `apass` varchar(20) NOT NULL,
  PRIMARY KEY (`ano`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用于存放管理员的信息';

--
-- Dumping data for table `administraors`
--

/*!40000 ALTER TABLE `administraors` DISABLE KEYS */;
INSERT INTO `administraors` (`ano`,`aaccount`,`apass`) VALUES 
 (1,'admin','admin');
/*!40000 ALTER TABLE `administraors` ENABLE KEYS */;


--
-- Definition of table `cities`
--

DROP TABLE IF EXISTS `cities`;
CREATE TABLE `cities` (
  `cno` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) NOT NULL,
  `cprovince` varchar(20) NOT NULL,
  PRIMARY KEY (`cno`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='用于存放有电影院的城市';

--
-- Dumping data for table `cities`
--

/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` (`cno`,`cname`,`cprovince`) VALUES 
 (5,'天津','天津'),
 (7,' 北京','北京'),
 (9,'辽宁','辽宁'),
 (15,'ajax1','浙江'),
 (17,'打发似的','新疆');
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;


--
-- Definition of table `movies`
--

DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies` (
  `mno` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(45) NOT NULL,
  `mtype` varchar(45) NOT NULL,
  `mstarttime` date NOT NULL,
  `mendtime` date NOT NULL,
  `mroles` text NOT NULL,
  `mdirector` varchar(45) NOT NULL,
  `mcountry` varchar(20) NOT NULL,
  `mversion` varchar(20) NOT NULL,
  `mlength` int(11) NOT NULL,
  `minformation` text NOT NULL,
  `mlikerate` int(11) NOT NULL,
  `mposter` varchar(60) NOT NULL,
  `mspecial` varchar(30) NOT NULL,
  PRIMARY KEY (`mno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用于保存单个电影的详情信息';

--
-- Dumping data for table `movies`
--

/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` (`mno`,`mname`,`mtype`,`mstarttime`,`mendtime`,`mroles`,`mdirector`,`mcountry`,`mversion`,`mlength`,`minformation`,`mlikerate`,`mposter`,`mspecial`) VALUES 
 (1,'Hello World','动作/恐怖','2014-10-26','2015-12-11','额外任务其二斯蒂芬森达烦烦撒凡','但凡','ing','2d',120,'倒萨额外的第三附属',88,'E:\\Program Files\\qq\\QQProtect\\Bin\\QQProtect.dll','防守对方'),
 (2,'阿奇','为止','2014-06-30','2028-11-17','过分过分的','点点滴滴','额','3d',342,'韦尔奇哇啊',324,'E:\\Program Files\\qq\\QQProtect\\Bin\\common.dll','萨芬');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;


--
-- Definition of table `showmoive`
--

DROP TABLE IF EXISTS `showmoive`;
CREATE TABLE `showmoive` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `tno` int(11) DEFAULT NULL,
  `mno` int(11) DEFAULT NULL,
  `shallno` int(11) NOT NULL,
  `stime` datetime NOT NULL,
  `sprice` float NOT NULL,
  `sseatsatust1` varchar(45) NOT NULL,
  `sseatsatust2` varchar(45) NOT NULL,
  `sseatsatust3` varchar(45) NOT NULL,
  `sseatsatust4` varchar(45) NOT NULL,
  `sseatsatust5` varchar(45) NOT NULL,
  `sseatsatust6` varchar(45) NOT NULL,
  `sseatsatust7` varchar(45) NOT NULL,
  `sseatsatust8` varchar(45) NOT NULL,
  `sseatsatust9` varchar(45) NOT NULL,
  `slanguage` varchar(10) NOT NULL,
  PRIMARY KEY (`sno`),
  KEY `FK_MNO` (`mno`),
  KEY `FK_TNO` (`tno`),
  CONSTRAINT `FK_MNO` FOREIGN KEY (`mno`) REFERENCES `movies` (`mno`),
  CONSTRAINT `FK_TNO` FOREIGN KEY (`tno`) REFERENCES `theatres` (`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用于保存电影放映相关信息';

--
-- Dumping data for table `showmoive`
--

/*!40000 ALTER TABLE `showmoive` DISABLE KEYS */;
INSERT INTO `showmoive` (`sno`,`tno`,`mno`,`shallno`,`stime`,`sprice`,`sseatsatust1`,`sseatsatust2`,`sseatsatust3`,`sseatsatust4`,`sseatsatust5`,`sseatsatust6`,`sseatsatust7`,`sseatsatust8`,`sseatsatust9`,`slanguage`) VALUES 
 (1,1,1,5,'2014-11-06 22:21:22',100,'0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0','engs'),
 (2,2,1,1,'2014-11-11 00:00:00',120,'0-0-0-0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0-0-0-0','0-0-0-0-0-0-0-0-0-0-0','ggg');
/*!40000 ALTER TABLE `showmoive` ENABLE KEYS */;


--
-- Definition of table `theatres`
--

DROP TABLE IF EXISTS `theatres`;
CREATE TABLE `theatres` (
  `tno` int(11) NOT NULL AUTO_INCREMENT,
  `cno` int(11) DEFAULT NULL,
  `tname` varchar(45) NOT NULL,
  `taddress` varchar(60) NOT NULL,
  `tintro` text NOT NULL,
  `thallnumber` int(11) NOT NULL,
  `ttel` varchar(30) NOT NULL,
  `tseatnumber` int(11) NOT NULL,
  `tspecialinfo` text,
  `tparkloc` text,
  `tbusinfo` text,
  PRIMARY KEY (`tno`),
  KEY `FK_CTNO` (`cno`),
  CONSTRAINT `FK_CTNO` FOREIGN KEY (`cno`) REFERENCES `cities` (`cno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用于保存单个电影院的详情';

--
-- Dumping data for table `theatres`
--

/*!40000 ALTER TABLE `theatres` DISABLE KEYS */;
INSERT INTO `theatres` (`tno`,`cno`,`tname`,`taddress`,`tintro`,`thallnumber`,`ttel`,`tseatnumber`,`tspecialinfo`,`tparkloc`,`tbusinfo`) VALUES 
 (1,5,'源','演员第三附属的','让俄双方商定锁',8,'23234234',3423,'结尾曲日前','倒萨','散打凡'),
 (2,7,'吞吞吐吐','第三附属',' 富士达',45,'76867',65876,' 苏打粉',' 散打',' 第三方');
/*!40000 ALTER TABLE `theatres` ENABLE KEYS */;


--
-- Definition of table `ticketorders`
--

DROP TABLE IF EXISTS `ticketorders`;
CREATE TABLE `ticketorders` (
  `ono` int(11) NOT NULL AUTO_INCREMENT,
  `uno` int(11) DEFAULT NULL,
  `sno` int(11) DEFAULT NULL,
  `obizcode` varchar(60) NOT NULL,
  `opayway` varchar(20) NOT NULL,
  `ostatus` varchar(20) NOT NULL,
  `otime` datetime NOT NULL,
  `opayplatform` varchar(20) NOT NULL,
  `ocount` int(11) NOT NULL,
  `oquantity1` int(11) NOT NULL,
  `oquantity2` int(11) NOT NULL,
  `oconvertcode` varchar(6) NOT NULL,
  `opaymoney` float NOT NULL,
  PRIMARY KEY (`ono`),
  KEY `FK_SNO` (`sno`),
  KEY `FK_UNO` (`uno`),
  CONSTRAINT `FK_SNO` FOREIGN KEY (`sno`) REFERENCES `showmoive` (`sno`),
  CONSTRAINT `FK_UNO` FOREIGN KEY (`uno`) REFERENCES `users` (`uno`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用于保存订单';

--
-- Dumping data for table `ticketorders`
--

/*!40000 ALTER TABLE `ticketorders` DISABLE KEYS */;
INSERT INTO `ticketorders` (`ono`,`uno`,`sno`,`obizcode`,`opayway`,`ostatus`,`otime`,`opayplatform`,`ocount`,`oquantity1`,`oquantity2`,`oconvertcode`,`opaymoney`) VALUES 
 (1,1,2,'6546','支付宝','已支付','2014-10-30 14:20:00','网上',2,0,0,'reradf',200);
/*!40000 ALTER TABLE `ticketorders` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `uno` int(11) NOT NULL AUTO_INCREMENT,
  `uemail` varchar(45) NOT NULL,
  `uname` varchar(45) NOT NULL,
  `usex` char(6) NOT NULL,
  `ubirthday` date NOT NULL,
  `upass` varchar(20) NOT NULL,
  `ulevel` int(11) NOT NULL,
  `uleveltime` int(11) NOT NULL,
  `uintegral` int(11) NOT NULL,
  PRIMARY KEY (`uno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用于保存用户的详细信息';

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`uno`,`uemail`,`uname`,`usex`,`ubirthday`,`upass`,`ulevel`,`uleveltime`,`uintegral`) VALUES 
 (1,'123','万达会员03456','男','2014-11-05','3',1,9999,0),
 (2,'3434@q','万达会员3456','男','2014-11-05','6',1,9999,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
