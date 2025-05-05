CREATE DATABASE IF NOT EXISTS `db_bukutamu`;
USE `db_bukutamu`;

-- Tabel tamu
CREATE TABLE `tb_tamu` (
  `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
  `tanggal` DATE NOT NULL,
  `nama` VARCHAR(100) NOT NULL,
  `alamat` TEXT NOT NULL,
  `tujuan` TEXT NOT NULL,
  `nope` VARCHAR(15) NOT NULL,
  `fotopengunjung` VARCHAR(255) NOT NULL
);

-- Tabel user (password: md5("admin"))
CREATE TABLE `tb_user` (
  `id_user` INT(11) AUTO_INCREMENT PRIMARY KEY,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `nama_pengguna` VARCHAR(100) NOT NULL,
  `status` ENUM('Aktif','Nonaktif') DEFAULT 'Aktif'
);

-- Contoh data user
INSERT INTO `tb_user` (`username`, `password`, `nama_pengguna`, `status`) 
VALUES ('admin', MD5('admin'), 'Administrator', 'Aktif');