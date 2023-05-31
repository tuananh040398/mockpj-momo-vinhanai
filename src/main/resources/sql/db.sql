DROP DATABASE IF EXISTS `Mock_Project`;

CREATE DATABASE `Mock_Project`;

USE `Mock_Project`;

CREATE TABLE `Account` (
                           id 					int AUTO_INCREMENT PRIMARY KEY,
                           username 			VARCHAR(50) UNIQUE NOT NULL,
                           `password` 			VARCHAR(50) NOT NULL,
                           address 			    VARCHAR(500),
                           `fullname`           VARCHAR(255) NOT NULL,
                           address              VARCHAR(255),
                           `role`				ENUM('ADMIN', 'CUSTOMER') NOT NULL,
                           coin                 INT DEFAULT(0)
);

CREATE TABLE `Product` (
                           id 					INT AUTO_INCREMENT PRIMARY KEY,
                           title 				VARCHAR(300) NOT NULL,
                           image 				VARCHAR(255) NOT NULL,
                           content 			    VARCHAR(20000) NOT NULL,
                           oranize_id           INT NOT NULL,
                           cash 				INT UNSIGNED DEFAULT(0),
                           max_cash 			INT UNSIGNED NOT NULL,
                           type_product 		ENUM('Vì Trẻ Em', 'Người Già, Người Khuyết Tật', 'Bệnh Hiểm Nghèo', 'Hoàn Cảnh Khó Khăn', 'Hỗ Trợ Giáo Dục', 'Đầu Tư Cơ Sở Vật Chất', 'Cứu Trợ Động Vật', 'Bảo Vệ Môi Trường'),
                           create_date 		    DATE NOT NULL,
                           expired_date 		DATE NOT NULL
);

CREATE TABLE `Organize` (

)