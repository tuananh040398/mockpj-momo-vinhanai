DROP DATABASE IF EXISTS `Mock_Project`;

CREATE DATABASE `Mock_Project`;

USE `Mock_Project`;

CREATE TABLE `Account` (
                           id 					int AUTO_INCREMENT PRIMARY KEY,
                           username 			VARCHAR(50) UNIQUE NOT NULL,
                           `password` 			VARCHAR(50) NOT NULL,
                           full_name			VARCHAR(100) NOT NULL,
                           address 			    VARCHAR(500),
                           `role`				ENUM('ADMIN', 'USER') NOT NULL,
                           coin				    INT UNSIGNED DEFAULT(0)
);

CREATE TABLE `Organize` (
                            id 					INT AUTO_INCREMENT PRIMARY KEY,
                            `name`				VARCHAR(255) UNIQUE NOT NULL,
                            information			VARCHAR(2000)
);

CREATE TABLE `Product` (
                           id 					INT AUTO_INCREMENT PRIMARY KEY,
                           title 				VARCHAR(300) NOT NULL,
                           image 				VARCHAR(255) NOT NULL,
                           content 			    VARCHAR(10000) NOT NULL,
                           organize_id 		    INT NOT NULL,
                           cash 				INT UNSIGNED DEFAULT(0),
                           max_cash 			INT UNSIGNED NOT NULL,
                           type_product 		ENUM('Vì Trẻ Em', 'Người Già, Người Khuyết Tật', 'Bệnh Hiểm Nghèo', 'Hoàn Cảnh Khó Khăn', 'Hỗ Trợ Giáo Dục', 'Đầu Tư Cơ Sở Vật Chất', 'Cứu Trợ Động Vật', 'Bảo Vệ Môi Trường'),
                           create_date 		    DATE NOT NULL,
                           expired_date 		DATE NOT NULL,
                           confirm				ENUM('WAITING', 'ACCEPT') DEFAULT('WAITING'),
                           FOREIGN KEY(organize_id) REFERENCES `Organize`(id) ON DELETE CASCADE
);

CREATE TABLE `Donate` (
                          id 					INT AUTO_INCREMENT PRIMARY KEY,
                          donate_by			    INT NOT NULL,
                          product_id			INT NOT NULL,
                          create_date			DATE,
                          FOREIGN KEY(donate_by) REFERENCES `Account`(id) ON DELETE NO ACTION,
                          FOREIGN KEY(product_id) REFERENCES `Product`(id) ON DELETE CASCADE
);