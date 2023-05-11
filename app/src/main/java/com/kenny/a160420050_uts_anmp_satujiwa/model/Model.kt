package com.kenny.a160420050_uts_anmp_satujiwa.model

data class Donasi(
    val id:String?,
    val namaDonasi:String?,
    val fotoDonasi:String?,
    val namaPenggalang:String?,
    val fotoPenggalang:String?,
    val tanggalPenggalanganDana:String?,
    val tanggalTargetPenggalangan:String?,
    val sisaHari:String?,
    val targetDonasi:String?,
    val donasiTerkumpul:String?,
    val jumlahDonatur:String?,
    val deskripsiDonasi:String?,
    val penyaluranDana:ArrayList<PenyaluranDana>?,
    val daftarDonatur: ArrayList<Donatur>?
)

data class Donatur(
    val namaDonatur:String?,
    val fotoDonatur:String?,
    val jumlahDonasi:String?,
    val tanggalDonasi : String?

)

data class PenyaluranDana(
    val namaPenerima:String?,
    val tanggalTerima:String?,
    val donasiDiterima:String?,
    val penggunaanDana:String?,
)

data class Berita(
    val id:String?,
    val judulBerita:String?,
    val namaPenulis:String?,
    val tanggalBerita:String?,
    val gambarBerita:String?,
    val isiBerita:String?
)

data class AksiNyata(
    val id:String?,
    val namaAksiNyata:String?,
    val fotoAksiNyata:String?,
    val namaPenggalang:String?,
    val fotoPenggalang:String?,
    val tanggalPenggalanganDana:String?,
    val tanggalTargetPenggalangan:String?,
    val donasiTerkumpul:String?,
    val deskripsiAksiNyata:String?,
    val penyaluranDana:ArrayList<PenyaluranDana>?,
    val daftarDonatur: ArrayList<Donatur>?
)

data class DonasiSaya(
    val id:String?,
    val namaDonasi:String?,
    val fotoDonasi:String?,
    val namaPenggalang:String?,
    val fotoPenggalang:String?,
    val tanggalPenggalanganDana:String?,
    val tanggalTargetPenggalangan:String?,
    val sisaHari:String?,
    val targetDonasi:String?,
    val donasiTerkumpul:String?,
    val jumlahDonatur:String?,
    val deskripsiDonasi:String?,
    val penyaluranDana:ArrayList<PenyaluranDana>?,
    val daftarDonatur: ArrayList<Donatur>?
)