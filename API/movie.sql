-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 30, 2021 lúc 10:40 AM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `movie`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cast`
--

CREATE TABLE `cast` (
  `id` int(11) NOT NULL,
  `create_at` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `update_at` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `cast`
--

INSERT INTO `cast` (`id`, `create_at`, `description`, `image`, `name`, `update_at`) VALUES
(1, NULL, 'Russell Brand', NULL, 'Russell Brand', NULL),
(2, NULL, 'Steve Carell', NULL, 'Steve Carell', NULL),
(3, NULL, 'Jason Segel', NULL, 'Jason Segel', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `create_at` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `update_at` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `create_at`, `image`, `name`, `update_at`) VALUES
(1, NULL, NULL, 'Hài hước', NULL),
(2, NULL, NULL, 'Hành động', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `director`
--

CREATE TABLE `director` (
  `id` int(11) NOT NULL,
  `create_at` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `update_at` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `director`
--

INSERT INTO `director` (`id`, `create_at`, `description`, `image`, `name`, `update_at`) VALUES
(1, NULL, 'Chris Renaud', NULL, 'Chris Renaud', NULL),
(2, NULL, 'Shawn Levy', NULL, 'Shawn Levy', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `movie`
--

CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `create_at` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `update_at` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `view` int(11) DEFAULT NULL,
  `categoryid` int(11) DEFAULT NULL,
  `directorid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `movie`
--

INSERT INTO `movie` (`id`, `create_at`, `description`, `duration`, `name`, `thumbnail`, `update_at`, `url`, `view`, `categoryid`, `directorid`) VALUES
(1, '2020-09-03', 'Phim về Gru-một tên tội phạm khét tiếng và đám tay chân robot tí hon chuyên đi đánh cắp những biểu tượng nổi tiếng của thế giới. Thế nhưng tiếng xấu của Gru bị suy giảm bởi Vector - tên trộm trẻ tuổi đã đánh cắp kim tự tháp Ai Cập. Bởi vậy để lấy lại danh tiếng của mình, Gru đã nghĩ đến một kế hoạch có một không hai: đánh cắp mặt trăng.', 95, 'Despicable Me', 'http://10.0.2.2:8081/images/movies/img6.jpg', '2020-09-03', NULL, 0, 1, 1),
(2, '2020-09-02', 'Anh chàng gác đêm Michael một lần nữa sẽ theo viện bảo tàng đến xứ sở hoa anh đào để công tác. Không quên mang theo những người bạn tí hon của mình, và đặc biệt là tấm bài vị thần kì quý giả của vua Ai Cập. Cùng những nhân vật sống dậy từ bảo tàng, MicheaAnh chàng gác đêm Michael một lần nữa sẽ theo viện bảo tàng đến xứ sở hoa anh đào để công tác. Không quên mang theo những người bạn tí hon của mình, và đặc biệt là tấm bài vị thần kì quý giả của vua Ai Cập. Cùng những nhân vật sống dậy từ bảo tàng, Micheal bắt đầu một chuyến phiêu lưu đầy hài hước.', 100, 'Night At The Museum: Secret Of The Tomb', 'http://10.0.2.2:8081/images/movies/img4.jpg', '2020-09-02', NULL, 0, 2, 2),
(3, '2020-09-01', 'Một người nửa nhân loại nửa Atlantis bước chân vào hành trình xác định xem mình có phải là vị vua xứng đáng của thế giới Atlantis.', 120, 'Aquaman', 'http://10.0.2.2:8081/images/movies/img7.jpg', '2020-09-01', NULL, 1, 2, 2),
(4, '2020-09-03', 'Một sai lầm tệ hại đã khiến con gái bạn thân của thợ săn quỷ Constatine bị hôn mê. Hai người bước vào hành trình đầy hiểm nguy để giành lại linh hồn cô bé.', 90, 'Constantine: City Of Demons', 'http://10.0.2.2:8081/images/movies/img5.jpg', '2020-09-03', NULL, 5, 2, 2),
(5, '2020-09-03', 'Sau khi sát hại một thành viên của tổ chức sát thủ quốc tế, mạng của John Wick được treo giá 14 triệu USD, và một đạo quân săn tiền thưởng liền bám riết lấy anh.', 110, 'John Wick Chapter 3: Parabellum', 'http://10.0.2.2:8081/images/movies/img1.jpg', '2020-09-03', NULL, 100, 2, 1),
(6, '2020-09-01', 'Một sát thủ về hưu bị buộc phải chạy trốn và nhận ra anh phải đối đầu với địch thủ ghê gớm nhất - bản sao trẻ trung hơn của mình.', 95, 'Gemini Man', 'http://10.0.2.2:8081/images/movies/img2.jpg', '2020-09-01', NULL, 200, 2, 2),
(7, '2020-09-02', 'Một nhân viên Mật vụ bị kết tội oan chạy đua với thời gian để cứu Tổng thống và đất nước khỏi hiểm họa trong lúc trốn tránh chính cơ quan của mình và FBI.', 95, 'Angel Has Fallen', 'http://10.0.2.2:8081/images/movies/img3.jpg', '2020-09-02', NULL, 150, 2, 1),
(8, '2020-08-29', 'Khi tìm kiếm manh mối về vụ mất tích của người cha là nhà thám hiểm, cô gái Lara thông minh và can đảm bước vào hành trình tìm kiếm lăng mộ mất tích mà cha cô đang bỏ dở.', 100, 'Tomb Raider', 'http://10.0.2.2:8081/images/movies/img8.jpg', '2020-08-29', NULL, 20, 2, 1),
(9, '2020-09-03', 'Bị chẩn đoán mắc bệnh hiểm nghèo, một cựu tội phạm cố gắng hàn gắn với con trai trong lúc lên kế hoạch trả thù băng đảng cũ.', 110, 'A Score To Settle', 'http://10.0.2.2:8081/images/movies/img9.jpg', '2020-09-03', NULL, 120, 2, 1),
(10, '2020-09-03', 'Khi một kẻ vô chính phủ được cải tạo gien chiếm được một vũ khí sinh học nguy hiểm có thể làm thay đổi cả thế giới, một nhân viên hành pháp phải hợp lực cùng một kẻ ngoài vòng pháp luật để đánh bại hắn.', 100, 'Fast & Furious: Hobbs & Shaw', 'http://10.0.2.2:8081/images/movies/img10.jpg', '2020-09-03', NULL, 120, 2, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `movie_cast`
--

CREATE TABLE `movie_cast` (
  `movieid` int(11) NOT NULL,
  `castid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `movie_cast`
--

INSERT INTO `movie_cast` (`movieid`, `castid`) VALUES
(6, 1),
(6, 2),
(7, 2),
(7, 3),
(9, 1),
(9, 3),
(10, 2),
(10, 3),
(5, 1),
(5, 2),
(8, 1),
(4, 3),
(3, 1),
(3, 2),
(1, 1),
(1, 2),
(1, 3),
(2, 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cast`
--
ALTER TABLE `cast`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKeryblahh21x5l6f0nfsu8v0n7` (`categoryid`),
  ADD KEY `FKq867msy9fpdbt7odcgrl16jx3` (`directorid`);

--
-- Chỉ mục cho bảng `movie_cast`
--
ALTER TABLE `movie_cast`
  ADD KEY `FKierla4vj0rc5myy2xkperpwjg` (`castid`),
  ADD KEY `FK3rie7r8vlrhdcqy99y67cafmy` (`movieid`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cast`
--
ALTER TABLE `cast`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `director`
--
ALTER TABLE `director`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `movie`
--
ALTER TABLE `movie`
  ADD CONSTRAINT `FKeryblahh21x5l6f0nfsu8v0n7` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FKq867msy9fpdbt7odcgrl16jx3` FOREIGN KEY (`directorid`) REFERENCES `director` (`id`);

--
-- Các ràng buộc cho bảng `movie_cast`
--
ALTER TABLE `movie_cast`
  ADD CONSTRAINT `FK3rie7r8vlrhdcqy99y67cafmy` FOREIGN KEY (`movieid`) REFERENCES `movie` (`id`),
  ADD CONSTRAINT `FKierla4vj0rc5myy2xkperpwjg` FOREIGN KEY (`castid`) REFERENCES `cast` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
