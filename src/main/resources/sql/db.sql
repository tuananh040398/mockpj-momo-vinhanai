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
INSERT INTO `mock_project`.`organization` (`id`, `logo`, `name`, `information`) VALUES ('4', 'Logo', 'Quỹ Hy Vọng - Hope Foundation', 'Ra đời năm 2017, Quỹ Hy Vọng là một quỹ xã hội - từ thiện hoạt động vì cộng đồng, không vì lợi nhuận, được vận hành bởi Báo điện tử VnExpress và Công ty cổ phần FPT. Quỹ Hy vọng theo đuổi hai mục tiêu: hỗ trợ các hoàn cảnh khó khăn và tạo động lực phát triển.');

INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('1', 'Chung tay thắp sáng 20 nụ cười cho các em bé mang dị tật hàm mặt cùng Operation Smile Vietnam', 'image', 'Dương Thanh Trường là một cậu bé năm nay đã 13 tuổi, đến vá vòm trong chương trình đầu tháng 5 tại bệnh viện Đại học Y dược thành phố Hồ Chí Minh. Sinh ra với dị tật hở môi và hở hàm ếch, mẹ của Trường bỏ em lại với ba và bà nội. Vì nhà khó khăn, ba của em đi làm thợ hồ ở Bình Dương để có tiền trang trải. Đều đặn mỗi tháng anh đều gửi tiền về cho hai bà cháu, nhưng cũng mấy tháng mới tranh thủ về thăm mẹ, thăm con được một lần. Thế nên hai bà cháu nương tựa vào nhau suốt bao năm nay. Để có thêm tiền chợ, bà nội hàng ngày đều đi lựa mủ cao su, nhận được một ngày 65 ngàn đồng. ', '3', '0', '200000000', 'VTE', '2023-06-06 09:44:08', '2023-07-30 09:44:08', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('2', 'Chung tay xây cầu mới an toàn kiên cố cho người dân bản Háng Rống, xã Pu Nhi, huyện Điện Biên Đông, tỉnh Điện Biên', 'image', 'Pu Nhi là một xã đặc biệt khó khăn nằm cheo leo trên đỉnh núi cùng tên ở phía Tây của huyện Điện Biên Đông, tỉnh Điện Biên. Xã có 20 bản với hơn 1.000 hộ, hơn 5.000 nhân khẩu, tỷ lệ hộ nghèo chiếm tới 65% dân số, trình độ dân trí không đồng đều. Do phong tục tập quán còn nhiều lạc hậu nên kinh tế của xã còn gặp nhiều khó khăn vất vả, Bản Háng Rống là một trong những bản khó khăn nhất của xã Pu Nhi. Mặc dù đã có nhiều chính sách về chuyển đổi cơ cấu kinh tế nhưng người dân nơi đây vẫn chưa thoát khỏi cái nghèo cái khổ. Những ngôi nhà của người dân được chắp vá bằng các mảnh gỗ đơn sơ, hay những phòng học được quây tạm bằng tấm bạt mỏng mảnh chẳng đủ che nắng chắn gió cũng đủ để nhận thấy điều kiện kinh tế của bà con đồng bào người HMông ở đây vô cùng nghèo nàn và vất vả. Địa hình ở bản Háng Rống đa phần là núi cao cách trở khiến cho giao thông đi lại vô cùng khó khăn. Đặc biệt nhất là cây cầu dân sinh ở bản Háng Rống - cây cầu bắc qua suối được dựng tạm bằng những cây luồng cột tạm với nhau, hai đầu cầu là 2 cây gỗ được dân bản trồng xuống đất. Nằm cách trung tâm xã Pu Nhi khoảng 16km, cây cầu tạm này hiện đang phục vụ nhu cầu đi lại của 70 hộ dân với khoảng 400 nhân khẩu bản Háng Rống, trong đó có khoảng 20 học sinh và trẻ mẫu giáo đi học qua cầu mỗi ngày. Nếu cây cầu hỏng mà chưa có kinh phí để kịp sửa chữa thì người dân và học sinh đành phải lội qua khe suối để đi lại. Khi mùa mưa về, nước suối chảy xiết, tình trạng lũ ống lũ quét thường xuyên xảy ra sẽ gây nguy hiểm về tính mạng nên người dân thường hạn chế đi lại mỗi khi nước đổ về, điều đó ảnh hưởng trực tiếp đến việc giao thương phát triển kinh tế cũng như học hành của con em trong bản. ', '2', '0', '120000', 'DTCSVC', '2023-06-06 15:12:41', '2023-08-06 15:12:41', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('3', 'Chung tay xây điểm trường Nà Tấu dành tặng mới cho các em học sinh nghèo khó khăn (Đợt 1)', 'image', 'Hiện các em học sinh Nà Tấu đang học tại 5 phòng học lắp ghép, thế nhưng diện tích không đủ cho các em một không gian thoải mái và an toàn. Trong khi đó, 2 phòng ở của giáo viên được làm tạm bằng gỗ, mái lợp bằng tấm lợp được dân bản tự làm và đưa vào sử dụng từ năm 2003, hiện tại đã xuống cấp, hư hỏng nặng, không đảm bảo an toàn. Chừng 5 giờ chiều, cô trò nhỏ Sộng Thị Pả Dạy – hiện đang học lớp 5, xách cặp ra khỏi lớp, đợi em gái học lớp 2 cùng về phòng trọ. Pả Dạy và em gái là con em của đồng bào người dân tộc Mông, đang sinh sống tại xã Đứa Mòn, huyện Sông Mã, Sơn La. Hiện nay cả 2 em đều học tại điểm trường Nà Tấu thuộc trường Tiểu học Đứa Mòn, huyện Sông Mã. Căn phòng trọ chừng 6m2, kê vừa ba mảnh gỗ xếp liền để làm giường là nơi ở của hai chị em và bốn nữ sinh khác, cách điểm trường khoảng chừng 16m. Dưới gầm giường chất đầy củi khô được bổ sẵn, do bố mẹ các em đèo từ trên núi xuống. Nhanh chóng cởi áo khoác, Pả Dạy đổ gạo vào chiếc nồi gang rồi mang đi vo. Thoăn thoắt đôi tay, em bê củi ra bếp, nhóm lửa nấu.', '4', '0', '150000000', 'HTGD', '2023-06-06 15:25:33', '2023-07-07 15:25:33', 'ACCEPT');

INSERT INTO `mock_project`.`donation` (`donate_by`, `product_id`, `cash`, `create_date`) VALUES ('2', '1', '1000000', '2023-06-06 15:50:45');
