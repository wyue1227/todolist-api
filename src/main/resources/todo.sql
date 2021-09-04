/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/ todo /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE todo;

DROP TABLE IF EXISTS todolist;
CREATE TABLE `todolist` (
  `todo_id` int NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `plan_time` datetime DEFAULT NULL COMMENT '计划完成时间',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `remark` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL COMMENT '状态',
  `section_id` int DEFAULT NULL COMMENT '类别',
  PRIMARY KEY (`todo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
INSERT INTO todolist(todo_id,create_time,update_time,plan_time,finish_time,content,remark,status,section_id) VALUES(1,'2021-09-01 11:35:55','2021-09-01 11:35:55','1986-10-20 23:36:44','1983-07-12 06:43:05','euzlf','qusbp',0,0),(2,'2021-09-01 11:35:55','2021-09-01 11:35:55','1981-06-22 09:18:10','1983-09-25 15:49:13','dgutp','tntwt',0,0),(3,'2021-09-01 11:35:55','2021-09-01 11:35:55','2000-12-25 17:37:00','2003-07-07 08:54:37','ylstr','pkrmj',1,0),(4,'2021-09-01 11:35:55','2021-09-01 11:35:55','2013-10-13 21:53:49','1988-01-23 17:53:45','adudc','hoteh',0,0),(5,'2021-09-01 11:35:55','2021-09-01 11:35:55','1988-11-16 05:32:11','1971-08-21 11:20:35','fmfdq','uuijz',0,0),(6,'2021-09-01 11:35:55','2021-09-01 11:35:55','2004-06-10 04:38:44','2005-07-07 20:09:41','ikhlw','xylfd',0,0),(7,'2021-09-01 11:35:55','2021-09-01 11:35:55','2008-06-10 03:09:34','1974-01-12 04:18:39','mexpu','jwuuq',1,0),(8,'2021-09-01 11:35:55','2021-09-01 11:35:55','1976-08-04 15:55:30','2021-04-08 04:37:12','oeosm','xhpsv',1,0),(9,'2021-09-01 11:35:55','2021-09-01 11:35:55','2020-10-12 22:19:27','1972-09-21 05:38:12','aqutp','fphcz',1,0),(10,'2021-09-01 11:35:55','2021-09-01 11:35:55','2015-11-22 03:01:44','1999-01-27 19:36:47','bxkyf','sdeuu',1,0),(12,'2021-09-01 16:09:51','2021-09-01 16:09:51',NULL,NULL,'content','remark',0,0),(15,'2021-09-01 16:32:42','2021-09-01 19:00:22',NULL,NULL,'update content','remark',0,0),(16,'2021-09-02 12:48:42','2021-09-02 14:19:54','2021-09-02 13:49:00',NULL,'update content','remark content',0,1);