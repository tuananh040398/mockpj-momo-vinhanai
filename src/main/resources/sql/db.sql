DROP DATABASE IF EXISTS `Mock_Project`;

CREATE DATABASE `Mock_Project`;

USE `Mock_Project`;

CREATE TABLE `Account` (
                           id 					int AUTO_INCREMENT PRIMARY KEY,
                           username 			VARCHAR(50) UNIQUE NOT NULL,
                           `password` 			VARCHAR(50) NOT NULL,
                           full_name			VARCHAR(100) NOT NULL,
                           phone				VARCHAR(20) NOT NULL,
                           email				VARCHAR(50),
                           address 			    VARCHAR(500),
                           `role`				ENUM('ADMIN', 'CUSTOMER') DEFAULT('USER'),
                           cash				    INT UNSIGNED DEFAULT(0)
);

CREATE TABLE `Organization` (
                                id 					INT AUTO_INCREMENT PRIMARY KEY,
                                logo				VARCHAR(255),
                                `name`				VARCHAR(255) UNIQUE NOT NULL,
                                information			VARCHAR(2000)
);

CREATE TABLE `Product` (
                           id 					INT AUTO_INCREMENT PRIMARY KEY,
                           title 				VARCHAR(300) NOT NULL,
                           image 				VARCHAR(255),
                           content 			    TEXT,
                           organization_id 	    INT NOT NULL,
                           cash 				INT UNSIGNED DEFAULT(0),
                           max_cash 			INT UNSIGNED NOT NULL,
                           product_type 		ENUM('VTE', 'NGNKT', 'BHN', 'HCKK', 'HTGD', 'DTCSVC', 'CTDV', 'BVMT'),
                           create_date 		    DATE NOT NULL,
                           expired_date 		DATE NOT NULL,
                           `status`		        ENUM('WAITING', 'ACCEPT') DEFAULT('WAITING'),
                           FOREIGN KEY(organization_id) REFERENCES `Organization`(id) ON DELETE CASCADE
);

CREATE TABLE `Donation` (
                            id 					INT AUTO_INCREMENT PRIMARY KEY,
                            donate_by			INT NOT NULL,
                            product_id			INT NOT NULL,
                            cash                INT UNSIGNED NOT NULL,
                            create_date			DATE,
                            FOREIGN KEY(donate_by) REFERENCES `Account`(id) ON DELETE NO ACTION,
                            FOREIGN KEY(product_id) REFERENCES `Product`(id) ON DELETE CASCADE
);

INSERT INTO `mock_project`.`account` (`id`, `username`, `password`, `full_name`, `phone`, `email`, `address`, `role`, `cash`) VALUES ('1', 'admin', 'admin', 'admin', '0123456789', 'admin@gmail.com', 'admin-home', 'ADMIN', '0');
INSERT INTO `mock_project`.`account` (`id`, `username`, `password`, `full_name`, `phone`, `email`, `address`, `role`, `cash`) VALUES ('2', 'customer', 'customer', 'customer', '0123456789', 'customer@gmail.com', 'customer-home', 'CUSTOMER', '0');
INSERT INTO `mock_project`.`account` (`id`, `username`, `password`, `full_name`, `phone`, `email`, `address`, `role`, `cash`) VALUES ('3', 'customer2', 'customer2', 'customer2', '0123456789', 'customer2@gmail.com', 'customer-home', 'CUSTOMER', '0');


INSERT INTO `mock_project`.`organization` (`id`, `logo`, `name`, `information`) VALUES ('1', 'Logo', 'Trung tâm Tương Lai', 'Trung tâm Giáo dục Sức khỏe và Phát triển Cộng đồng Tương Lai (Trung tâm Tương Lai) thành lập năm 2011 là tổ chức xã hội với sứ mệnh hoạt động vì trẻ em và thanh thiếu niên có hoàn cảnh đặc biệt. Trung tâm Tương Lai không chỉ giúp đỡ về mặt tài chính mà còn quan tâm giúp đỡ trẻ em và thanh thiếu niên về hướng nghiệp, kỹ năng sống và vui chơi giải trí lành mạnh.');
INSERT INTO `mock_project`.`organization` (`id`, `logo`, `name`, `information`) VALUES ('2', 'Logo', 'Sức Mạnh 2000 - Ánh sáng núi rừng', '“Sức mạnh 2000 – Tiền lẻ mỗi ngày Triệu người chung tay Xây nghìn trường mới” được phát động ngày 27/02/2020 là dự án gây quỹ tiếp theo của Dự Án Ánh Sáng Núi Rừng ra đời năm 2009 dưới sự phối hợp, triển khai của Trung tâm tình nguyện Quốc gia.');
INSERT INTO `mock_project`.`organization` (`id`, `logo`, `name`, `information`) VALUES ('3', 'Logo', 'Operation Smile', 'Operation Smile (Phẫu Thuật Nụ Cười) là một tổ chức phi chính phủ quốc tế lâu đời chuyên cung cấp các ca phẫu thuật và chăm sóc y tế an toàn miễn phí nhằm nâng cao sức khoẻ và thay đổi cuộc đời cho hàng ngàn trẻ em và thanh thiếu niên bị các dị tật vùng hàm mặt tại hơn 60 quốc gia trên thế giới.');

INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('1', 'Chung tay thắp sáng 20 nụ cười cho các em bé mang dị tật hàm mặt cùng Operation Smile Vietnam', 'image', 'Dương Thanh Trường là một cậu bé năm nay đã 13 tuổi, đến vá vòm trong chương trình đầu tháng 5 tại bệnh viện Đại học Y dược thành phố Hồ Chí Minh. Sinh ra với dị tật hở môi và hở hàm ếch, mẹ của Trường bỏ em lại với ba và bà nội. Vì nhà khó khăn, ba của em đi làm thợ hồ ở Bình Dương để có tiền trang trải. Đều đặn mỗi tháng anh đều gửi tiền về cho hai bà cháu, nhưng cũng mấy tháng mới tranh thủ về thăm mẹ, thăm con được một lần. Thế nên hai bà cháu nương tựa vào nhau suốt bao năm nay. Để có thêm tiền chợ, bà nội hàng ngày đều đi lựa mủ cao su, nhận được một ngày 65 ngàn đồng. ', '3', '0', '200000000', 'VTE', '2023-06-06 09:44:08', '2023-06-30 09:44:08', 'ACCEPT');