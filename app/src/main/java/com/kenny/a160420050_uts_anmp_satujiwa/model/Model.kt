package com.kenny.a160420050_uts_anmp_satujiwa.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Donasi(
    @ColumnInfo(name="namaDonasi")
    val namaDonasi:String,
    @ColumnInfo(name="fotoDonasi")
    val fotoDonasi:String,
    @ColumnInfo(name="namaPenggalang")
    val namaPenggalang:String,
    @ColumnInfo(name="fotoPenggalang")
    val fotoPenggalang:String,
    @ColumnInfo(name="tanggalPenggalangDana")
    val tanggalPenggalanganDana:String,
    @ColumnInfo(name="tanggalTargetPenggalangan")
    val tanggalTargetPenggalangan:String,
    @ColumnInfo(name="sisaHari")
    val sisaHari:Int,
    @ColumnInfo(name="targetDonasi")
    val targetDonasi:Double,
    @ColumnInfo(name="donasiTerkumpul")
    val donasiTerkumpul:Double,
    @ColumnInfo(name="jumlahDonatur")
    val jumlahDonatur:Int,
    @ColumnInfo(name="deskripsiDonasi")
    val deskripsiDonasi:String,
    @ColumnInfo(name="status")
    val status:Int=1
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int=0
}

@Entity
data class Donatur(
    @ColumnInfo(name="idDonatur")
    val idDonatur:Int,
    @ColumnInfo(name="idDonasi")
    val idDonasi:Int,
    @ColumnInfo(name="jumlahDonasi")
    val jumlahDonasi:Double,
    @ColumnInfo(name="tanggalDonasi")
    val tanggalDonasi : String
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int=0
}

@Entity
data class Berita(
    @ColumnInfo(name="judulBerita")
    val judulBerita:String,
    @ColumnInfo(name="namaPenulis")
    val namaPenulis:String,
    @ColumnInfo(name="tanggalBerita")
    val tanggalBerita:String,
    @ColumnInfo(name="gambarBerita")
    val gambarBerita:String,
    @ColumnInfo(name="isiBerita")
    val isiBerita:String
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int=0
}

@Entity
data class User(
    @ColumnInfo(name="name")
    val judulBerita:String,
    @ColumnInfo(name="phoneNumber")
    val phoneNumber:String,
    @ColumnInfo(name="address")
    val address:String,
    @ColumnInfo(name="username")
    val username:String,
    @ColumnInfo(name="password")
    val password:String
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int=0
}