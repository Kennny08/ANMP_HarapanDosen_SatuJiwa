package com.kenny.a160420050_uts_anmp_satujiwa.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Donasi(
    @ColumnInfo(name="namaDonasi")
    var namaDonasi:String,
    @ColumnInfo(name="fotoDonasi")
    var fotoDonasi:String,
    @ColumnInfo(name="namaPenggalang")
    var namaPenggalang:String,
    @ColumnInfo(name="fotoPenggalang")
    var fotoPenggalang:String,
    @ColumnInfo(name="tanggalPenggalangDana")
    var tanggalPenggalanganDana:String,
    @ColumnInfo(name="tanggalTargetPenggalangan")
    var tanggalTargetPenggalangan:String,
    @ColumnInfo(name="targetDonasi")
    var targetDonasi:Double,
    @ColumnInfo(name="donasiTerkumpul")
    var donasiTerkumpul:Double,
    @ColumnInfo(name="jumlahDonatur")
    var jumlahDonatur:Int,
    @ColumnInfo(name="deskripsiDonasi")
    var deskripsiDonasi:String,
    @ColumnInfo(name="status")
    var status:Int=1
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int=0
}

@Entity
data class Donatur(
    @ColumnInfo(name="idDonatur")
    var idDonatur:Int,
    @ColumnInfo(name="idDonasi")
    var idDonasi:Int,
    @ColumnInfo(name="namaDonasi")
    var namaDonasi:String,
    @ColumnInfo(name="fotoDonasi")
    var fotoDonasi:String,
    @ColumnInfo(name="jumlahDonasi")
    var jumlahDonasi:Double,
    @ColumnInfo(name="tanggalDonasi")
    var tanggalDonasi : String
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int=0
}

@Entity
data class Berita(
    @ColumnInfo(name="judulBerita")
    var judulBerita:String,
    @ColumnInfo(name="namaPenulis")
    var namaPenulis:String,
    @ColumnInfo(name="tanggalBerita")
    var tanggalBerita:String,
    @ColumnInfo(name="gambarBerita")
    var gambarBerita:String,
    @ColumnInfo(name="isiBerita")
    var isiBerita:String
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int=0
}

@Entity
data class User(
    @ColumnInfo(name="name")
    var name:String,
    @ColumnInfo(name="phoneNumber")
    var phoneNumber:String,
    @ColumnInfo(name="address")
    var address:String,
    @ColumnInfo(name="username")
    var username:String,
    @ColumnInfo(name="password")
    var password:String
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int=0
}