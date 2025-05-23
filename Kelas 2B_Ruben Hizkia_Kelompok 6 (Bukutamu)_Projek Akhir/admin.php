<!-- panggil file header -->
<?php include "header.php"; ?>

<?php

// uji jika tombool simpan diklik
if (isset($_POST['bsimpan'])) {
    $tgl = date('Y-m-d');

    // htmlspecialchars agar inputan lebih aman dari injection
    $nama = htmlspecialchars($_POST['nama'], ENT_QUOTES);
    $alamat = htmlspecialchars($_POST['alamat'], ENT_QUOTES);
    $tujuan = htmlspecialchars($_POST['tujuan'], ENT_QUOTES);
    $nope = htmlspecialchars($_POST['nope'], ENT_QUOTES);

    // Proses upload file
    $upload_dir = "uploads/";
    if (!is_dir($upload_dir)) {
        mkdir($upload_dir, 0777, true); // Buat folder jika belum ada
    }

    $fotopengunjung = $_FILES['fotopengunjung']['name'];
    $tmp_file = $_FILES['fotopengunjung']['tmp_name'];
    $target_file = $upload_dir . basename($fotopengunjung);

    // Validasi ekstensi file
    $allowed_ext = ['jpg', 'jpeg', 'png', 'gif'];
    $file_ext = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));

    if (in_array($file_ext, $allowed_ext)) {
        if (move_uploaded_file($tmp_file, $target_file)) {
            // Simpan data ke database setelah file berhasil diunggah
            $simpan = mysqli_query(
                $koneksi,
                "INSERT INTO tb_tamu VALUES (
                    '', 
                    '$tgl', 
                    '$nama', 
                    '$alamat', 
                    '$tujuan', 
                    '$nope', 
                    '$fotopengunjung'
                )"
            );

            if ($simpan) {
                echo "<script>alert('Data tersimpan!'); document.location='admin.php';</script>";
                exit;
            } else {
                echo "<script>alert('Gagal menyimpan data ke database!');</script>";
                die("Error DB: " . mysqli_error($koneksi));
            }
        } else {
            echo "<script>alert('Gagal upload file foto!');</script>";
        }
    } else {
        echo "<script>alert('Hanya file gambar (jpg/jpeg/png/gif) yang diizinkan!');</script>";
    }
}

?>

<!-- Head -->
<div class="head text-center">
    <img src="assets/img/logo_Unmer_resmi.png" width="150" alt="">
    <h2 class="text-white"><b>Sistem Informasi Buku Tamu</b><br> Universitas Merdeka Malang</h2>
    <br>
</div>
<!-- End Head -->

<!-- Awal Row -->
<div class="row mt-2">
    <!-- col-lg-7 -->
    <div class="col-lg-7 mb-3">
        <div class="card shadow bg-gradient-light">
            <!-- card body -->
            <div class="card-body">
                <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Identitas Pengunjung</h1>
                </div>
                <form class="user" method="POST" action="" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="text" class="form-control form-control-user" name="nama"
                            placeholder="Nama Pengunjung" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control form-control-user" name="alamat"
                            placeholder="Alamat Pengunjung" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control form-control-user" name="tujuan"
                            placeholder="Tujuan Pengunjung" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control form-control-user" name="nope"
                            placeholder="No.HP Pengunjung" required>
                    </div>
                    <div class="form-group">
                        <label for="file">Upload Foto</label>
                        <input type="file" class="btn btn-secondary btn-user btn-block" name="fotopengunjung" required
                            accept="image/*">
                    </div>

                    <button type="submit" name="bsimpan" class="btn btn-primary btn-user btn-block">Simpan Data</button>
                </form>
                <hr>
                <div class="text-center">
                    <a class="small" href="#">By. Ruben,Hizkia,Intan,Aulia | 2023 -
                        <?= date('Y') ?>
                    </a>
                </div>
            </div>
            <!-- End card body -->
        </div>
    </div>
    <!-- End col-lg-7 -->

    <!-- col-lg-5 -->
    <div class="col-lg-5 mb-3">
        <!-- Card -->
        <div class="card shadow bg-gradient-light">
            <!-- card body -->
            <div class="card-body">
                <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Statistik Pengunjung</h1>
                </div>
                <?php
                // Deklarasi tanggal
                
                // menampilkan tanggal sekarang
                $tgl_sekarang = date('Y-m-d');

                // Menampilkan tangga kemarin
                $kemarin = date('Y-m-d', strtotime('-1 day', strtotime(date('Y-m-d'))));

                // Mendapatkan 6 hari sebelum tanggal sekarang
                $seminggu = date('Y-m-d h:i:s', strtotime('-1 week +1 day', strtotime($tgl_sekarang)));

                $sekarang = date('Y-m-d h:i:s');

                // Persiapan query tampilkan jumlah data pengunjung
                
                $tgl_sekarang = mysqli_fetch_array(
                    mysqli_query(
                        $koneksi,
                        "SELECT count(*) FROM tb_tamu WHERE tanggal like '%$tgl_sekarang%'"
                    )
                );

                $kemarin = mysqli_fetch_array(
                    mysqli_query(
                        $koneksi,
                        "SELECT count(*) FROM tb_tamu WHERE tanggal like '%$kemarin%'"
                    )
                );

                $seminggu = mysqli_fetch_array(
                    mysqli_query(
                        $koneksi,
                        "SELECT count(*) FROM tb_tamu WHERE tanggal BETWEEN '$seminggu' and '$sekarang'"
                    )
                );

                $bulan_ini = date('m');

                $sebulan = mysqli_fetch_array(
                    mysqli_query(
                        $koneksi,
                        "SELECT count(*) FROM tb_tamu WHERE month(tanggal) = '$bulan_ini'"
                    )
                );

                $keseluruhan = mysqli_fetch_array(
                    mysqli_query(
                        $koneksi,
                        "SELECT count(*) FROM tb_tamu"
                    )
                );



                ?>
                <table class="table table-bordered">
                    <tr>
                        <td>Hari ini</td>
                        <td>:
                            <?= $tgl_sekarang[0] ?>
                        </td>
                    </tr>
                    <tr>
                        <td>Kemarin</td>
                        <td>:
                            <?= $kemarin[0] ?>
                        </td>
                    </tr>
                    <tr>
                        <td>Minggu ini</td>
                        <td>:
                            <?= $seminggu[0] ?>
                        </td>
                    </tr>
                    <tr>
                        <td>Bulan ini</td>
                        <td>:
                            <?= $sebulan[0] ?>
                        </td>
                    </tr>
                    <tr>
                        <td>Keseluruhan</td>
                        <td>:
                            <?= $keseluruhan[0] ?>
                        </td>
                    </tr>
                </table>
            </div>
            <!-- End card body -->
        </div>
        <!-- End card -->
    </div>
    <!-- end col-lg-5 -->


</div>
<!-- End Row -->

<!-- DataTales Example -->
<br>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Data Pengunjung Hari ini [
            <?= date('d-m-Y') ?>]
        </h6>
    </div>
    <div class="card-body">
        <a href="rekapitulasi.php" class="btn btn-success mb-3"><i class="fa fa-table"></i> Rekapitulasi Pengunjung</a>
        <a href="logout.php" class="btn btn-danger mb-3"><i class="fa fa-sign-out-alt"></i> Logout</a>

        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Tanggal</th>
                        <th>Nama Pengunjung</th>
                        <th>Alamat</th>
                        <th>Tujuan</th>
                        <th>No. HP</th>
                        <th>Foto</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    $tgl = date('Y-m-d'); //2023-06-27
                    $tampil = mysqli_query($koneksi, "SELECT * FROM tb_tamu where tanggal like '%$tgl%' order by id desc");
                    $no = 1;
                    while ($data = mysqli_fetch_array($tampil)) {
                        ?>
                        <tr>
                            <td>
                                <?= $no++ ?>
                            </td>
                            <td>
                                <?= $data['tanggal'] ?>
                            </td>
                            <td>
                                <?= $data['nama'] ?>
                            </td>
                            <td>
                                <?= $data['alamat'] ?>
                            </td>
                            <td>
                                <?= $data['tujuan'] ?>
                            </td>
                            <td>
                                <?= $data['nope'] ?>
                            </td>
                            <td>
                                <?php
                                if (!empty($data['fotopengunjung'])) {
                                    echo '<img src="uploads/' . $data['fotopengunjung'] . '"
                                    style="width: 100px; height: auto; 
                                    border-radius: 5px;"class="img-thumbnail">';
                                } else {
                                    echo 'Tidak ada foto';
                                }
                                ?>
                            </td>
                        </tr>
                    <?php } ?>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
<br>

<!-- panggil file footer -->
<?php include "footer.php"; ?>