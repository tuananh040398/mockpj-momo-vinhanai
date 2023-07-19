DROP DATABASE IF EXISTS `Mock_Project`;

CREATE DATABASE `Mock_Project`;

USE `Mock_Project`;

CREATE TABLE `Account` (
                           id 					INT AUTO_INCREMENT PRIMARY KEY,
                           username 			VARCHAR(50) UNIQUE NOT NULL,
                           `password` 			VARCHAR(255) NOT NULL,
                           full_name			VARCHAR(100) NOT NULL,
                           phone				VARCHAR(20) NOT NULL,
                           email				VARCHAR(50),
                           address 			    VARCHAR(500),
                           `role`				ENUM('ADMIN', 'CUSTOMER') DEFAULT('CUSTOMER'),
                           cash				    LONG DEFAULT(0)
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
                           image 				VARCHAR(700),
                           content 			    TEXT,
                           organization_id 	    INT NOT NULL,
                           cash 				LONG DEFAULT(0),
                           max_cash 			LONG NOT NULL,
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
                            cash                LONG NOT NULL,
                            donate_type			ENUM('VNPAY', 'MOMO'),
                            create_date			DATE,
                            FOREIGN KEY(donate_by) REFERENCES `Account`(id) ON DELETE NO ACTION,
                            FOREIGN KEY(product_id) REFERENCES `Product`(id) ON DELETE CASCADE
);

CREATE TABLE `token` (
                         id 					INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         token 				    VARCHAR(500) NOT NULL,
                         user_agent 			VARCHAR(500) NOT NULL,
                         is_black_list 		    TINYINT(1) DEFAULT NULL,
                         refresh_time 		    DATETIME DEFAULT NULL,
                         expiration 			DATETIME DEFAULT NULL,
                         UNIQUE KEY token (token)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `mock_project`.`account` (`id`, `username`, `password`, `full_name`, `phone`, `email`, `address`, `role`, `cash`) VALUES ('1', 'admin', '$2a$12$yEjaS6GbHpCote.2WE/Tp.l1iuJ0MTqgMKCm6QLpNRMqF.6qflloy', 'admin', '0123456789', 'admin@gmail.com', 'admin-home', 'ADMIN', '1000000000');
INSERT INTO `mock_project`.`account` (`id`, `username`, `password`, `full_name`, `phone`, `email`, `address`, `role`, `cash`) VALUES ('2', 'customer', '$2a$12$yEjaS6GbHpCote.2WE/Tp.l1iuJ0MTqgMKCm6QLpNRMqF.6qflloy', 'customer', '0123456789', 'customer@gmail.com', 'customer-home', 'CUSTOMER', '50000000');
INSERT INTO `mock_project`.`account` (`id`, `username`, `password`, `full_name`, `phone`, `email`, `address`, `role`, `cash`) VALUES ('3', 'customer2', '$2a$12$yEjaS6GbHpCote.2WE/Tp.l1iuJ0MTqgMKCm6QLpNRMqF.6qflloy', 'customer2', '0123456789', 'customer2@gmail.com', 'customer-home', 'CUSTOMER', '50000000');
INSERT INTO `mock_project`.`account` (`id`, `username`, `password`, `full_name`, `phone`, `email`, `address`, `role`, `cash`) VALUES ('4', 'customer3', '$2a$12$yEjaS6GbHpCote.2WE/Tp.l1iuJ0MTqgMKCm6QLpNRMqF.6qflloy', 'customer3', '0123456789', 'customer3@gmail.com', 'customer3-address', 'CUSTOMER', '50000000');
INSERT INTO `mock_project`.`account` (`id`, `username`, `password`, `full_name`, `phone`, `email`, `address`, `role`, `cash`) VALUES ('5', 'tuananh', '$2a$12$yEjaS6GbHpCote.2WE/Tp.l1iuJ0MTqgMKCm6QLpNRMqF.6qflloy', 'tuananh', '0123456789', 'tuananh@gmail.com', 'tuananh-address', 'CUSTOMER', '50000000');
INSERT INTO `mock_project`.`account` (`id`, `username`, `password`, `full_name`, `phone`, `email`, `address`, `role`, `cash`) VALUES ('6', 'tuananh123', '$2a$12$yEjaS6GbHpCote.2WE/Tp.l1iuJ0MTqgMKCm6QLpNRMqF.6qflloy', 'tuananh123', '0123456789', 'tuananh123@gmail.com', 'tuananh123-address', 'CUSTOMER', '50000000');
INSERT INTO `mock_project`.`account` (`id`, `username`, `password`, `full_name`, `phone`, `email`, `address`, `role`, `cash`) VALUES ('7', 'vimomo', '$2a$12$yEjaS6GbHpCote.2WE/Tp.l1iuJ0MTqgMKCm6QLpNRMqF.6qflloy', 'vimomo', '0123456789', 'vimomo@gmaill.com', 'vimomo-address', 'CUSTOMER', '50000000');
INSERT INTO `mock_project`.`account` (`id`, `username`, `password`, `full_name`, `phone`, `email`, `address`, `role`, `cash`) VALUES ('8', 'khabanh', '$2a$12$yEjaS6GbHpCote.2WE/Tp.l1iuJ0MTqgMKCm6QLpNRMqF.6qflloy', 'khabanh', '0123456789', 'khabanh@gmail.com', 'khabanh-address', 'CUSTOMER', '50000000');
INSERT INTO `mock_project`.`account` (`id`, `username`, `password`, `full_name`, `phone`, `email`, `address`, `role`, `cash`) VALUES ('9', 'ronaldo', '$2a$12$yEjaS6GbHpCote.2WE/Tp.l1iuJ0MTqgMKCm6QLpNRMqF.6qflloy', 'ronaldo', '0123456789', 'ronaldo@gmail.com', 'ronaldo-address', 'CUSTOMER', '50000000');
INSERT INTO `mock_project`.`account` (`id`, `username`, `password`, `full_name`, `phone`, `email`, `address`, `role`, `cash`) VALUES ('10', 'vinfast', '$2a$12$yEjaS6GbHpCote.2WE/Tp.l1iuJ0MTqgMKCm6QLpNRMqF.6qflloy', 'vinfast', '0123456789', 'vinfast@gmail.com', 'vinfast-address', 'CUSTOMER', '50000000');


INSERT INTO `mock_project`.`organization` (`id`, `logo`, `name`, `information`) VALUES ('1', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230609111954-638219063944529196.jpg', 'Trung tâm Tương Lai', 'Trung tâm Giáo dục Sức khỏe và Phát triển Cộng đồng Tương Lai (Trung tâm Tương Lai) thành lập năm 2011 là tổ chức xã hội với sứ mệnh hoạt động vì trẻ em và thanh thiếu niên có hoàn cảnh đặc biệt. Trung tâm Tương Lai không chỉ giúp đỡ về mặt tài chính mà còn quan tâm giúp đỡ trẻ em và thanh thiếu niên về hướng nghiệp, kỹ năng sống và vui chơi giải trí lành mạnh.');
INSERT INTO `mock_project`.`organization` (`id`, `logo`, `name`, `information`) VALUES ('2', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230529101856-638209523369392191.png', 'Sức Mạnh 2000 - Ánh sáng núi rừng', '“Sức mạnh 2000 – Tiền lẻ mỗi ngày Triệu người chung tay Xây nghìn trường mới” được phát động ngày 27/02/2020 là dự án gây quỹ tiếp theo của Dự Án Ánh Sáng Núi Rừng ra đời năm 2009 dưới sự phối hợp, triển khai của Trung tâm tình nguyện Quốc gia.');
INSERT INTO `mock_project`.`organization` (`id`, `logo`, `name`, `information`) VALUES ('3', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230531140049-638211384492513899.png', 'Operation Smile', 'Operation Smile (Phẫu Thuật Nụ Cười) là một tổ chức phi chính phủ quốc tế lâu đời chuyên cung cấp các ca phẫu thuật và chăm sóc y tế an toàn miễn phí nhằm nâng cao sức khoẻ và thay đổi cuộc đời cho hàng ngàn trẻ em và thanh thiếu niên bị các dị tật vùng hàm mặt tại hơn 60 quốc gia trên thế giới.');
INSERT INTO `mock_project`.`organization` (`id`, `logo`, `name`, `information`) VALUES ('4', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230508141805-638191522857273367.jpg', 'Quỹ Hy Vọng - Hope Foundation', 'Ra đời năm 2017, Quỹ Hy Vọng là một quỹ xã hội - từ thiện hoạt động vì cộng đồng, không vì lợi nhuận, được vận hành bởi Báo điện tử VnExpress và Công ty cổ phần FPT. Quỹ Hy vọng theo đuổi hai mục tiêu: hỗ trợ các hoàn cảnh khó khăn và tạo động lực phát triển.');
INSERT INTO `mock_project`.`organization` (`id`, `logo`, `name`, `information`) VALUES ('5', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230529153438-638209712784911432.png', 'DNXH Nhịp tim Việt Nam', 'Được thành lập vào năm 2006, Nhịp tim Việt Nam tài trợ chi phí phẫu thuật tim cho trẻ em nghèo mắc bệnh tim bẩm sinh tại Việt Nam.');
INSERT INTO `mock_project`.`organization` (`id`, `logo`, `name`, `information`) VALUES ('6', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230524134601-638205327618895746.png', 'Thư Viện Ước Mơ', 'Doanh nghiệp xã hội THƯ VIỆN ƯỚC MƠ là doanh nghiệp xã hội đăng ký theo luật doanh nghiệp Việt Nam hiện hành. Tiền thân của doanh nghiệp Xã hội Thư viện Ước mơ là dự án Thư viện Ước mơ do bà Nguyễn Phi Vân - Chủ tịch Hiệp hội Đầu tư Thiên thần Việt Nam sáng lập năm 2014.');


INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('1', 'Chung tay thắp sáng 20 nụ cười cho các em bé mang dị tật hàm mặt cùng Operation Smile Vietnam', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230609111947-638219063876865197.jpg', 'Dương Thanh Trường là một cậu bé năm nay đã 13 tuổi, đến vá vòm trong chương trình đầu tháng 5 tại bệnh viện Đại học Y dược thành phố Hồ Chí Minh. Sinh ra với dị tật hở môi và hở hàm ếch, mẹ của Trường bỏ em lại với ba và bà nội. Vì nhà khó khăn, ba của em đi làm thợ hồ ở Bình Dương để có tiền trang trải. Đều đặn mỗi tháng anh đều gửi tiền về cho hai bà cháu, nhưng cũng mấy tháng mới tranh thủ về thăm mẹ, thăm con được một lần. Thế nên hai bà cháu nương tựa vào nhau suốt bao năm nay. Để có thêm tiền chợ, bà nội hàng ngày đều đi lựa mủ cao su, nhận được một ngày 65 ngàn đồng. ', '3', '1350000', '200000000', 'VTE', '2023-06-06 09:44:08', '2023-07-30 09:44:08', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('2', 'Chung tay xây cầu mới an toàn kiên cố cho người dân bản Háng Rống, xã Pu Nhi, huyện Điện Biên Đông, tỉnh Điện Biên', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230531140040-638211384405958621.jpg', 'Pu Nhi là một xã đặc biệt khó khăn nằm cheo leo trên đỉnh núi cùng tên ở phía Tây của huyện Điện Biên Đông, tỉnh Điện Biên. Xã có 20 bản với hơn 1.000 hộ, hơn 5.000 nhân khẩu, tỷ lệ hộ nghèo chiếm tới 65% dân số, trình độ dân trí không đồng đều. Do phong tục tập quán còn nhiều lạc hậu nên kinh tế của xã còn gặp nhiều khó khăn vất vả, Bản Háng Rống là một trong những bản khó khăn nhất của xã Pu Nhi. Mặc dù đã có nhiều chính sách về chuyển đổi cơ cấu kinh tế nhưng người dân nơi đây vẫn chưa thoát khỏi cái nghèo cái khổ. Những ngôi nhà của người dân được chắp vá bằng các mảnh gỗ đơn sơ, hay những phòng học được quây tạm bằng tấm bạt mỏng mảnh chẳng đủ che nắng chắn gió cũng đủ để nhận thấy điều kiện kinh tế của bà con đồng bào người HMông ở đây vô cùng nghèo nàn và vất vả. Địa hình ở bản Háng Rống đa phần là núi cao cách trở khiến cho giao thông đi lại vô cùng khó khăn. Đặc biệt nhất là cây cầu dân sinh ở bản Háng Rống - cây cầu bắc qua suối được dựng tạm bằng những cây luồng cột tạm với nhau, hai đầu cầu là 2 cây gỗ được dân bản trồng xuống đất. Nằm cách trung tâm xã Pu Nhi khoảng 16km, cây cầu tạm này hiện đang phục vụ nhu cầu đi lại của 70 hộ dân với khoảng 400 nhân khẩu bản Háng Rống, trong đó có khoảng 20 học sinh và trẻ mẫu giáo đi học qua cầu mỗi ngày. Nếu cây cầu hỏng mà chưa có kinh phí để kịp sửa chữa thì người dân và học sinh đành phải lội qua khe suối để đi lại. Khi mùa mưa về, nước suối chảy xiết, tình trạng lũ ống lũ quét thường xuyên xảy ra sẽ gây nguy hiểm về tính mạng nên người dân thường hạn chế đi lại mỗi khi nước đổ về, điều đó ảnh hưởng trực tiếp đến việc giao thương phát triển kinh tế cũng như học hành của con em trong bản. ', '2', '50000', '120000', 'DTCSVC', '2023-06-06 15:12:41', '2023-08-06 15:12:41', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('3', 'Chung tay xây điểm trường Nà Tấu dành tặng mới cho các em học sinh nghèo khó khăn (Đợt 1)', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230529153430-638209712702063429.jpg', 'Hiện các em học sinh Nà Tấu đang học tại 5 phòng học lắp ghép, thế nhưng diện tích không đủ cho các em một không gian thoải mái và an toàn. Trong khi đó, 2 phòng ở của giáo viên được làm tạm bằng gỗ, mái lợp bằng tấm lợp được dân bản tự làm và đưa vào sử dụng từ năm 2003, hiện tại đã xuống cấp, hư hỏng nặng, không đảm bảo an toàn. Chừng 5 giờ chiều, cô trò nhỏ Sộng Thị Pả Dạy – hiện đang học lớp 5, xách cặp ra khỏi lớp, đợi em gái học lớp 2 cùng về phòng trọ. Pả Dạy và em gái là con em của đồng bào người dân tộc Mông, đang sinh sống tại xã Đứa Mòn, huyện Sông Mã, Sơn La. Hiện nay cả 2 em đều học tại điểm trường Nà Tấu thuộc trường Tiểu học Đứa Mòn, huyện Sông Mã. Căn phòng trọ chừng 6m2, kê vừa ba mảnh gỗ xếp liền để làm giường là nơi ở của hai chị em và bốn nữ sinh khác, cách điểm trường khoảng chừng 16m. Dưới gầm giường chất đầy củi khô được bổ sẵn, do bố mẹ các em đèo từ trên núi xuống. Nhanh chóng cởi áo khoác, Pả Dạy đổ gạo vào chiếc nồi gang rồi mang đi vo. Thoăn thoắt đôi tay, em bê củi ra bếp, nhóm lửa nấu.', '4', '60000', '150000000', 'HTGD', '2023-06-06 15:25:33', '2023-07-07 15:25:33', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('4', 'Xây dựng 9 thư viện ước mơ - Trao tri thức cho các em dân tộc thiểu số ở Lạng Sơn, Bắc Giang, Bắc Ninh và Bình Phước', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230529101843-638209523237676498.jpg', 'Lạng Sơn là một tỉnh miền núi, biên giới phía Bắc của Việt Nam, với dân số hơn 782 nghìn người. Trong đó, đồng bào dân tộc thiểu số chiếm hơn 83% tổng dân số toàn tỉnh. Tuy nhiên, giáo dục cấp 1 tại Lạng Sơn đang gặp phải nhiều khó khăn do thiếu hụt tài liệu và sách vở, đặc biệt là đối với các em học sinh thuộc dân tộc thiểu số. Theo báo cáo của Báo Dân tộc, hiện nay vẫn còn nhiều khó khăn trong việc phát triển hệ thống thư viện. Nhiều thư viện cấp huyện trong tỉnh đang trong tình trạng xuống cấp và không có đủ điều kiện để tổ chức các hoạt động nâng cao văn hóa đọc cho người dân, đặc biệt là các em học sinh - sinh viên. Mặc dù các đầu sách về kinh tế, văn hóa, tiểu thuyết và văn học đều có đầy đủ, nhưng do cơ sở vật chất của thư viện hạn hẹp nên chỉ một số ít đầu sách được trưng bày, còn lại phải nằm trong bao tải hoặc trong góc nhà. (Nguồn: https://baodantoc.vn)', '6', '70000', '187000000', 'NGNKT', '2023-06-16', '2023-08-03', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('5', 'Tặng học bổng và truyền thông kỹ năng phòng chống xâm hại, bạo lực cho các em học sinh có hoàn cảnh đặc biệt tại xã Phú Thuận, huyện Phú Tân, tỉnh Cà Mau', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230524134553-638205327530739422.jpg', '❤️ Cùng gây quỹ tặng 15 suất học bổng và truyền thông kỹ năng phòng chống xâm hại, bạo lực cho các em học sinh có hoàn cảnh đặc biệt giúp các em có thêm cơ hội hướng về tương lai. Xã Phú Tân, Huyện Phú Tân là một địa phương vùng sâu, vùng xa thuộc tỉnh Cà Mau. Tình hình phát triển kinh tế xã hội của xã còn gặp nhiều khó khăn. Đa phần người dân mưu sinh kiếm sống bằng nghề làm vuông, thu nhập phụ thuộc vào kết quả thu hoạch của từng mùa vụ, nên đời sống kinh tế bấp bênh. Trong những năm qua tình hình dịch Covid19 diễn biến phức tạp đã ảnh hưởng rất lớn đến công ăn việc làm và đời sống của người dân, đặc biệt đối với trẻ em vùng sâu vùng xa của xã, điều kiện đến trường cũng gặp rất nhiều khó khăn do phụ thuộc vào kinh tế từ gia đình. Hơn lúc nào hết, các em rất cần nhận được sự quan tâm, tiếp sức từ cộng đồng để có thêm cơ hội và nghị lực bước tiếp con đường học hành những chặng đường tương lai phía trước. ', '1', '80000', '30000000', 'BHN', '2023-06-16', '2023-08-29', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('6', 'Gây quỹ Tết Thiếu nhi hỗ trợ chi phí khám và điều trị cho 100 trẻ mồ côi và trẻ em khó khăn bị ảnh hưởng bởi đại dịch tại huyện Bình Chánh', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230524133557-638205321572175182.jpg', 'Kể từ khi đại dịch bùng phát, biết bao sinh mạng đã bị cướp đi, đẩy hàng nghìn trẻ em rơi vào hoàn cảnh mồ côi do mất đi cha, mẹ, người thân, hoặc người nuôi dưỡng hoặc rơi vào hoàn cảnh khó khăn do ảnh hưởng của đại dịch. Để vượt qua những mất mát không thể nào bù đắp được và những khó khăn này, các em luôn cần sự đồng hành, quan tâm, và chăm sóc từ xã hội để vững bước trên chặng đường trưởng thành.  Chương trình “Care to Rise – Yêu thương Nâng bước” là một sáng kiến của Thành Đoàn TP.HCM và VinaCapital Foundation (VCF), với sự đồng hành của Doanh nghiệp Xã hội Nhịp tim Việt Nam, nhằm hỗ trợ tâm lý, chăm sóc sức khỏe, và hỗ trợ giáo dục miễn phí cho trẻ mồ côi hậu Covid-19 và trẻ em có hoàn cảnh khó khăn chịu ảnh hưởng bởi dịch bệnh tại TP.HCM.', '5', '90000', '100000000', 'HCKK', '2023-06-16', '2023-08-28', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('7', 'Tặng 30 suất học bổng và truyền thông kỹ năng phòng chống xâm hại, bạo lực trẻ em cho học sinh có hoàn cảnh đặc biệt tại huyện Cần Giờ, TP.HCM', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230523100909-638204333498077143.jpg', 'Đại dịch Covid – 19 đã càn quét 4 đợt liên tục tại nhiều tỉnh thành trong cả nước. Trong đó TP.HCM bị ảnh hưởng nặng nề với 618.347 ca tính tới ngày 10/01/2023. Huyện Cần Giờ là một trong những huyện cũng chịu ảnh hưởng với hơn 22.473 ca nhiễm, đặc biệt có rất nhiều đối tượng là trẻ em.  Những hoàn cảnh khó khăn bị ảnh hưởng bởi dịch Covid - 19 : Người dân huyện Cần Giờ chủ yếu là sống bằng nghề đi biển, làm lưới, làm muối và lao động tự do. Ảnh hưởng của dịch Covid – 19 khiến thu nhập của người dân nơi đây vô cùng bấp bênh. Cũng chính vì kinh tế gia đình khó khăn cho nên ảnh hưởng đến việc chăm lo ăn uống, sinh hoạt và học tập của nhiều trẻ em đang trong độ tuổi đến trường. Hơn lúc nào hết, trẻ em rất cần nhận được sự quan tâm, tiếp sức từ cộng đồng để có thêm cơ hội và nghị lực bước tiếp những chặng đường tri thức. Đặc biệt hơn là để chuẩn bị hành trang cho tương lai phía trước.', '1', '100000', '30000000', 'CTDV', '2023-06-16', '2023-08-20', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('8', 'Cùng quyên góp tặng thư viện sách và tập huấn kỹ năng sống cho học sinh có hoàn cảnh khó khăn tại trường THCS Mương Mán, Bình Thuận', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230522142651-638203624113792643.jpg', '❤️ Cùng gây quỹ tặng thư viện sách và tổ chức tập huấn kỹ năng sống cho học sinh có hoàn cảnh khó khăn tại trường THCS Mương Mán, Hàm Thuận Nam, Bình Thuận.', '1', '110000', '30000000', 'BVMT', '2023-06-16', '2023-08-10', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('9', 'Chung tay xây tặng Nhà Hạnh Phúc cho cô học trò nghèo hiếu học Hồ Thị Yến tại Quảng Bình', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230519152342-638201066229767192.jpg', 'Em Hồ Thị Yến sinh năm 2016, hiện đang sinh sống ở Bản Bãi Dinh, xã Dân Hóa, huyện Minh Hóa, tỉnh Quảng Bình. Em Yến đang là học sinh lớp 1 tại Trường Tiểu học Bãi Dinh. Không được may mắn như nhiều bạn bè cùng trang lứa khác, năm em lên 6 tuổi, chuẩn bị bước vào lớp 1 thì mẹ em mất do bệnh tật, để lại bố và em sống cảnh gà trống nuôi con. Thế nhưng bố em năm nay 38 tuổi và đầu óc luôn không được tỉnh táo và minh mẫn. Vì thế hiện nay em Yến đang sống cùng chú. Chú em thuộc diện gia đình hộ nghèo, và bệnh tật cũng quấn thân quanh năm, vì thế mà cái ăn cái mặc của cả gia đình cũng vô cùng khó khăn. Dù sức khỏe yếu kém là thế, nhưng thương cháu, thương anh, chú của em vẫn cố gắng trồng sắn trên rẫy để có thu nhập ra vào. Hơn nữa chú còn phụ giúp việc trong bản cho gia đình nào cần thuê người. Thu nhập bấp bênh, nhưng chi phí học tập cho em, chi phí thuốc men cho bố em vẫn cần phải có. Khó khăn chồng chất khó khăn khiến cuộc sống của cả gia đình đè nặng lên đôi vai người chú.', '2', '120000', '80000000', 'VTE', '2023-06-16', '2023-08-28', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('10', 'Xây nhà hạnh phúc tặng em học sinh mồ côi cha Y Ngọc Ánh ở Mường Hoong - Đăk Glei - Kon Tum', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230515144537-638197587378662872.jpg', 'Thôn Làng Mới, xã Mường Hoong, huyện Đăk Glei, tỉnh Kon Tum có 144 hộ với 478 nhân khẩu, trong đó 91% hộ dân là đồng bào dân tộc thiểu số. Đời sống bà con chủ yếu dựa vào sản xuất nông nghiệp và thu nhập từ sản phẩm phụ dưới tán rừng trồng cây dược liệu, nhận khoanh nuôi, quản lý bảo vệ rừng.  Em Y Ngọc Ánh là người đồng bào Xê Đăng, sinh năm 2015, hiện đang sống cùng mẹ và anh trai ở thôn Làng Mới. Anh trai em vừa học xong lớp 5, còn em hiện đang theo lớp 1B của trường Tiểu học xã Mường Hoong. Bố em mất sớm, nên từ ngày bố mất một mình mẹ em nuôi hai anh em ăn học và tần tảo sớm hôm lo cho kinh tế của cả gia đình. Mẹ em là nông dân nên công việc chủ yếu là làm nông, vì thế đồng ra đồng vào trong nhà phụ thuộc cả vào mùa vụ, không có nguồn thu nhập ổn định.', '2', '130000', '80000000', 'NGNKT', '2023-06-16', '2023-08-10', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('11', 'Trao tặng 10 ca phẫu thuật thay đổi cuộc đời cho các em bé hở môi, hàm ếch', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230522151542-638203653421970967.jpg', 'Trong năm 2022, cộng đồng Heo Đất MoMo đã chung tay cùng Operation Smile giúp cho 565 em bé ở khắp Việt Nam của nhận được nụ cười mới. Đây là một kết quả vô cùng phấn khởi cho người nhà, gia đình các em. Đặc biệt là những trái tim nhân ái đã chung tay làm nên những điều kì diệu, thay đổi cuộc đời các em qua những ca phẫu thuật điều trị hở môi, hàm ếch miễn phí, an toàn. Cụ thể, trong năm 2022, chúng ta có tổng cộng 22 chương trình, cộng đồng Heo Đất MoMo đóng góp được gần 27 triệu Heo Vàng. Ngoài ra, cộng đồng đã kết nối cùng với 9 đối tác doanh nghiệp để thực hiện hoá giấc mơ nụ cười cho các em. ', '3', '0', '100000000', 'BHN', '2023-06-16', '2023-08-15', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('12', 'Thể thao thay đổi cuộc đời - Mang đến cuộc đời mới cho 10 em bé hở môi, hàm ếch', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230511094948-638193953881866685.jpg', 'Là một tổ chức y tế lâu năm, Operation Smile hiểu tầm quan trọng của sức khỏe đối với chất lượng cuộc sống của mỗi người. Vì thế mà trong gần 10 năm qua, Operation Smile đã cổ vũ cho các phong trào chạy bộ trên khắp đất nước, và mang thêm nhiều ý nghĩa cho các chương trình chạy bộ đó. Đối với tổ chức và rất nhiều bạn bè, những người ủng hộ, thể thao mang ý nghĩa đặc biệt hơn khi sự rèn luyện và y chí chinh phục của người tham gia sẽ góp phần mang lại nụ cười mới, cuộc đời mới cho các trẻ em không may mắn sinh ra mắc các dị tật hàm mặt.  Ca sĩ Đức Tuấn - người được biết đến không chỉ qua giọng hát đầy nội lực và tình cảm, anh còn biết đến vì những hoạt động tích cực cùng Operation Smile và đặc biệt là trong các hoạt động thể thao. Với anh, nụ cười của các em nhỏ, cơ hội được sống, có bạn bè và được tới trường luôn là động lực để anh cố gắng hoàn thành sứ mệnh của mình trên đường chạy.', '3', '5000', '120000000', 'HCKK', '2023-06-16', '2023-08-05', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('13', 'Cùng Quỹ Hy Vọng xây mới nhà vệ sinh cho các em học sinh huyện Mường Nhé, tỉnh Điện Biên', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230427165245-638182111653596945.jpg', 'Quá tải, xuống cấp, hư hỏng... là tình trạng chung của nhiều nhà vệ sinh trường học vùng cao, trong đó có huyện Mường Nhé, tỉnh Điện Biên. Tại điểm trường Nậm Mì 1 (Trung tâm), thuộc trường Tiểu học Huổi Lếch, huyện Mường Nhé, hơn 300 em học sinh và gần 20 giáo viên sử dụng chung một nhà vệ sinh quây tạm bằng tôn. Hệ thống xử lý chất thải, thoát nước còn chưa được xử lý.  Tại điểm trường Huổi Pinh, thuộc trường Tiểu học Mường Toong 1, nhà vệ sinh từng có nhưng qua thời gian, nay đã xuống cấp và hư hỏng trầm trọng, gần như không sử dụng được.', '4', '0', '150000000', 'HTGD', '2023-06-16', '2023-08-25', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('14', 'Cùng dự án “Thay áo mới trường em” chung tay khoác áo mới cho các ngôi trường ẩm mốc ở Lệ Thuỷ', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230427134953-638182001931203057.jpg', 'Trên hành trình 5 năm xây trường cho học sinh vùng khó khăn, chúng tôi - Quỹ Hy Vọng - nhận thấy bên cạnh những ngôi trường tranh, ván gỗ, sụt lún cần được xây mới để đảm bảo an toàn, có rất nhiều trường học đã xây dựng kiên cố nhưng xuống cấp, rêu phong sau nhiều năm. Nếu được sửa sang, sơn mới đã có thể tạo nên bộ mặt mới, giúp cải thiện chất lượng cơ sở vật chất và bảo vệ công trình lâu dài hơn. Với ý nghĩa đó, chúng tôi đã đưa dự án “Thay áo mới trường em\" đến Lệ Thủy - một trong những huyện khó khăn của tỉnh Quảng Bình, thường xuyên chịu ảnh hưởng của thiên tai, lũ lụt. Đặc biệt, trận lụt lịch sử năm 2020 đã gây hậu quả nặng nề cho vùng đất trũng này. Tình trạng ngập lụt thường xuyên khiến cơ sở vật chất của trường học, nhất là những trường cũ nhanh xuống cấp, hư hỏng. Sau lũ rất nhiều trường học bị thấm nước, tường nứt nẻ, rêu mốc.', '4', '15000', '140000000', 'DTCSVC', '2023-06-16', '2023-08-30', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('15', 'Hỗ trợ thiết bị chăm sóc trẻ sơ sinh cho Trung tâm Y tế huyện Điện Biên Đông, Điện Biên', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-230215135642-638120662021465935.jpg', 'Điện Biên Đông là một huyện của tỉnh Điện Biên, thuộc vùng núi phía bắc có địa hình núi non hiểm trở, bị chia cắt bởi nhiều khe suối, vực sâu, đồi núi chiếm 90% đất tự nhiên. Đây là nơi sinh sống của gần 54.000 người thuộc 6 đồng bào dân tộc: Mông, Thái, Lào, Khơ Mú, Sinh Mun, Kinh và các dân tộc khác. Trong đó người Mông chiếm đa số với hơn 53%. Năm 2021, Điện Biên Đông nằm trong danh sách một trong 74 huyện nghèo nhất của cả nước theo quyết định số 353 của Thủ tướng Chính phủ.', '5', '25000', '245000000', 'CTDV', '2023-06-16', '2023-08-03', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('16', 'Gây quỹ góp phần hỗ trợ chi phí tổ chức Ngày hội Ước mơ 2023 cho 49 bạn nữ sinh dân tộc thiểu số có hoàn cảnh khó khăn', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-221208104509-638060931095470412.jpg', 'Tại Việt Nam, trẻ em gái và phụ nữ đồng bào dân tộc thiểu số thuộc nhóm đối tượng yếu thế và dễ bị tổn thương phải chịu nhiều thiệt thòi, chịu sự bất bình đẳng về giới từ trong gia đình đến ngoài xã hội, Những định kiến, hủ tục lạc hậu, nạn tảo hôn, hôn nhân cận huyết là những yếu tố cản trở cơ hội được tiếp cận giáo dục, phát triển cá nhân và cộng đồng của phụ nữ và trẻ em gái dân tộc thiểu số.  Theo thống kê, tỉ lệ bỏ học ở trẻ em dân tộc thiểu số cao gấp 3 lần so với trung bình cả nước. Trẻ em gái tại các vùng dân tộc thiểu số có tỉ lệ bỏ học cao gấp đôi và tỉ lệ kết hôn dưới 16 tuổi cao gấp 3,4 lần trẻ em trai. Việc kết hôn sớm dẫn đến hệ quả mang thai và sinh con khi các em đang còn ở tuổi vị thành niên. So với nhóm bà mẹ sinh con ngoài 20 tuổi, tử vong do thai sản ở nhóm tuổi từ 15 đến 19 cao gấp 2 lần và ở trẻ em gái dưới 15 tuổi cao gấp 4 lần. Tảo hôn cũng chính là một trong những nguyên nhân dẫn đến tình trạng bỏ học ở trẻ em gái dân tộc thiểu số, nó đã tước đi hy vọng, ước mơ và tương lai của nhiều em nhỏ.', '5', '35000', '150000000', 'BVMT', '2023-06-16', '2023-08-08', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('17', 'Mang 5 Thư Viện Ước Mơ đến các em nhỏ vùng thiểu số khó khăn ở KonTum, Quảng Nam và Quảng Ngãi', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-221017170056-638016228564558770.jpg', 'Theo số liệu của Tổng cục Thống kê tính đến cuối năm 2021, tỉ lệ dân tộc thiểu số tại tỉnh Kon Tum là khoảng 54,9%. Tuy nhiên, nếu tính đến các khu vực khó khăn tại tỉnh, tỉ lệ này có thể còn cao hơn. Toàn tỉnh có tổng số 46.132 hộ khó khăn, trong đó có khoảng 70% là các hộ thuộc đồng bào dân tộc thiểu số.  Có hai vấn đề lớn nhất mà sở Giáo Dục Tỉnh Kon Tum cần đối mặt là thiếu cơ sở vật chất và thiếu giáo viên. Để bảo đảm cơ sở vật chất, hạ tầng kỹ thuật, các trường thuộc tỉnh Kon Tum đã tận dụng nhà rông, các hội trường thôn làng và huy động sức dân để mở các lớp học. ', '6', '45000', '104000000', 'VTE', '2023-06-16', '2023-08-13', 'ACCEPT');
INSERT INTO `mock_project`.`product` (`id`, `title`, `image`, `content`, `organization_id`, `cash`, `max_cash`, `product_type`, `create_date`, `expired_date`, `status`) VALUES ('18', 'Mang 10 thư viện đến trẻ em ở vùng khó khăn phía Bắc gồm Hà Giang và Bắc Ninh', 'https://homepage.momocdn.net/blogscontents/momo-upload-api-220819141457-637965152978262151.jpg', 'Ở Hà Giang hiện có 192 xã đồng bào vùng dân tộc, với trên 1.300 thôn bản đặc biệt khó khăn. Tỷ lệ hộ nghèo tới hơn 45%, thu nhập trung bình đầu người chỉ vỏn vẹn 25 triệu/ năm. Có trường có lớp học khang trang để con em trong gia đình có thể theo đuổi giấc mơ con chữ, vẫn là ước mong của đồng bào sinh sống tại vùng cao núi đá nơi đây. Hà Giang là một trong những địa phương khó khăn nhất của cả nước với đồng bào dân tộc thiểu số chiếm tỷ lệ cao. Không chỉ vậy điều kiện cơ sở vật chất, giao thông cũng còn nhiều vấn đề nan giải chưa thể khắc phục. Đây cũng chính là nguyên nhân chủ yếu gây cản trở sự phát triển giáo dục tại tỉnh Hà Giang.', '6', '0', '208000000', 'NGNKT', '2023-06-16', '2023-08-18', 'ACCEPT');


INSERT INTO `mock_project`.`donation` (`donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('2', '1', '1000000', 'MOMO', '2023-06-01');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('2', '1', '1', '200000', 'MOMO','2023-06-01');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('3', '3', '1', '50000', 'MOMO','2023-06-01');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('4', '4', '1', '10000', 'MOMO','2023-06-01');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('5', '5', '1', '20000', 'MOMO','2023-06-01');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('6', '6', '1', '30000', 'MOMO','2023-06-02');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('7', '7', '1', '40000', 'MOMO','2023-06-02');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('8', '1', '2', '50000', 'VNPAY','2023-06-02');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('9', '1', '3', '60000', 'VNPAY','2023-06-02');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('10', '1', '4', '70000', 'VNPAY','2023-06-02');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('11', '1', '5', '80000', 'MOMO','2023-06-03');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('12', '1', '6', '90000', 'MOMO','2023-06-03');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('13', '1', '7', '100000', 'VNPAY','2023-06-03');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('14', '1', '8', '110000', 'MOMO','2023-06-03');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('15', '1', '9', '120000', 'MOMO','2023-06-03');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('16', '1', '10', '130000', 'VNPAY','2023-06-04');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('17', '2', '12', '5000', 'MOMO','2023-06-04');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('18', '3', '14', '15000', 'MOMO','2023-06-04');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('19', '8', '15', '25000', 'VNPAY','2023-06-04');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('20', '9', '16', '35000', 'MOMO','2023-06-04');
INSERT INTO `mock_project`.`donation` (`id`, `donate_by`, `product_id`, `cash`, `donate_type`,`create_date`) VALUES ('21', '10', '17', '45000', 'VNPAY','2023-06-04');

