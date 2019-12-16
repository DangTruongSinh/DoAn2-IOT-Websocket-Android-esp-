-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th12 16, 2019 lúc 09:17 AM
-- Phiên bản máy phục vụ: 8.0.16
-- Phiên bản PHP: 7.0.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `doan2`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `username`, `password`) VALUES
(1, 'dangtruongsinh', '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thietbibattat`
--

CREATE TABLE `thietbibattat` (
  `id` bigint(20) NOT NULL,
  `ten` varchar(50) DEFAULT NULL,
  `trangthai` tinyint(1) DEFAULT NULL,
  `chedo` tinyint(1) DEFAULT NULL,
  `thoigianmo` time DEFAULT NULL,
  `thoigiantat` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `thietbibattat`
--

INSERT INTO `thietbibattat` (`id`, `ten`, `trangthai`, `chedo`, `thoigianmo`, `thoigiantat`) VALUES
(1, 'den1', 1, 0, '15:37:00', '00:30:00'),
(2, 'den2', 1, 0, '15:37:00', '00:30:00'),
(3, 'quat', 1, 0, '15:37:00', '00:30:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thietbicambien`
--

CREATE TABLE `thietbicambien` (
  `id` bigint(20) NOT NULL,
  `ten` varchar(50) DEFAULT NULL,
  `giatri` int(11) DEFAULT NULL,
  `thoigiandoc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `thietbicambien`
--

INSERT INTO `thietbicambien` (`id`, `ten`, `giatri`, `thoigiandoc`) VALUES
(1, 'cbnhietdo', 25, 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `thietbibattat`
--
ALTER TABLE `thietbibattat`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `thietbicambien`
--
ALTER TABLE `thietbicambien`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `thietbibattat`
--
ALTER TABLE `thietbibattat`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `thietbicambien`
--
ALTER TABLE `thietbicambien`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
