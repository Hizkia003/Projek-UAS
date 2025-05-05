<?php
// buat session start
session_start();
include "koneksi.php";

// Uji jika session telah di set atau tidak
if (
    empty($_SESSION['username'])
    or empty($_SESSION['password'])
    or empty($_SESSION['nama_pengguna'])
) {
    echo "<script>
        alert('Maaf, untuk mengakses halaman ini, Anda diharuskan Login terlebih dahulu..!!');
        document.location='index.php';</script>";
}
?>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sistem informasi Buku Tamu</title>

    <!-- Buat Favicon  -->
    <link rel="icon" href="assets/img/Logo_Unmer_resmi.png" type="image/x-icon">

    <!-- Custom fonts for this template-->
    <link href="assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="assets/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="assets/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

    <style>
        /* Ubah warna tulisan input dan placeholder */
        .form-control-user {
            color: rgb(0, 0, 0) !important;
            /* Warna tulisan putih */
            background-color: #d1d1d1 !important;
            /* Latar gelap untuk kontras */
        }

        /* Ubah warna placeholder */
        .form-control-user::placeholder {
            color: #495057 !important;
            /* Warna placeholder abu-abu muda */
            opacity: 1;
            /* Pastikan placeholder tidak transparan */
        }

        .img-thumbnail {
            transition: transform .2s;
            cursor: zoom-in;
        }

        .img-thumbnail:hover {
            transform: scale(2);
            z-index: 9999;
            position: relative;
        }
    </style>

</head>

<body class="bg-gradient-success">
    <!-- container -->
    <div class="container">
        <?php include "koneksi.php"; ?>