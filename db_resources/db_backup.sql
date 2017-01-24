-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: db_sntndr01
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `tb_pantalla`
--

DROP TABLE IF EXISTS `tb_pantalla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pantalla` (
  `ID_PANTALLA` mediumint(9) NOT NULL AUTO_INCREMENT,
  `OPCION` varchar(50) NOT NULL,
  `PADRE` varchar(50) NOT NULL,
  `IDX_OPCION` int(11) NOT NULL,
  `IDX_PADRE` int(11) NOT NULL,
  `CONTROLLER` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_PANTALLA`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pantalla`
--

LOCK TABLES `tb_pantalla` WRITE;
/*!40000 ALTER TABLE `tb_pantalla` DISABLE KEYS */;
INSERT INTO `tb_pantalla` VALUES (1,'Foliador de Documentos','Herramientas',1,1,'archivos.htm'),(2,'Certificadores','Opciones',1,2,'certificadores.htm'),(3,'Bitacora','Opciones',2,2,'bitacora.htm'),(5,'Usuarios','Accesos',1,1,'usuarios.htm'),(6,'Perfiles','Accesos',1,2,'perfiles.htm');
/*!40000 ALTER TABLE `tb_pantalla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_perfil`
--

DROP TABLE IF EXISTS `tb_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_perfil` (
  `ID_PERFIL` mediumint(9) NOT NULL AUTO_INCREMENT,
  `PERFIL` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_PERFIL`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_perfil`
--

LOCK TABLES `tb_perfil` WRITE;
/*!40000 ALTER TABLE `tb_perfil` DISABLE KEYS */;
INSERT INTO `tb_perfil` VALUES (1,'Paginador'),(2,'Administrador');
/*!40000 ALTER TABLE `tb_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_perfil_pantalla`
--

DROP TABLE IF EXISTS `tb_perfil_pantalla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_perfil_pantalla` (
  `ID_PP` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PERFIL` mediumint(9) NOT NULL,
  `ID_PANTALLA` mediumint(9) NOT NULL,
  PRIMARY KEY (`ID_PP`),
  KEY `ID_PANTALLA` (`ID_PANTALLA`),
  KEY `ID_PERFIL` (`ID_PERFIL`),
  CONSTRAINT `tb_perfil_pantalla_ibfk_1` FOREIGN KEY (`ID_PANTALLA`) REFERENCES `tb_pantalla` (`ID_PANTALLA`),
  CONSTRAINT `tb_perfil_pantalla_ibfk_2` FOREIGN KEY (`ID_PERFIL`) REFERENCES `tb_perfil` (`ID_PERFIL`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_perfil_pantalla`
--

LOCK TABLES `tb_perfil_pantalla` WRITE;
/*!40000 ALTER TABLE `tb_perfil_pantalla` DISABLE KEYS */;
INSERT INTO `tb_perfil_pantalla` VALUES (1,1,1),(2,1,2),(3,1,3),(4,2,5),(5,2,6);
/*!40000 ALTER TABLE `tb_perfil_pantalla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_usuario` (
  `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(100) NOT NULL,
  `EMAIL` varchar(60) NOT NULL,
  `PASSWORD` varchar(60) NOT NULL,
  `ID_PERFIL` mediumint(9) NOT NULL,
  `INTENTO` int(4) DEFAULT '0',
  `PREGUNTA` varchar(100) DEFAULT NULL,
  `RESPUESTA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  KEY `fk_UsuarioPerfil` (`ID_PERFIL`),
  CONSTRAINT `fk_UsuarioPerfil` FOREIGN KEY (`ID_PERFIL`) REFERENCES `tb_perfil` (`ID_PERFIL`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'Oscar Martinez Acosta','oscar@mt.com','s1santan',1,NULL,NULL,NULL),(2,'Administrador','admin@admin','admin1',2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-08  8:02:01
