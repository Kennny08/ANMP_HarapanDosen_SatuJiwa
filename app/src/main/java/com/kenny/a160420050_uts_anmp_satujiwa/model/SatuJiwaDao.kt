package com.kenny.a160420050_uts_anmp_satujiwa.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DonasiDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg donasi: Donasi)

    @Query("SELECT * from donasi where status=1")
    fun selectAllDonasi(): List<Donasi>

    @Query("SELECT * from donasi where status=0")
    fun selectAllAksiNyata(): List<Donasi>

    @Query("SELECT * from donasi WHERE uuid=:id")
    fun selectSpecifiedDonasi(id:Int): Donasi
}

@Dao
interface DonaturDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg donatur: Donatur)

    @Query("SELECT * from donatur")
    fun selectAllDonatur(): List<Donatur>
}

@Dao
interface BeritaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg berita: Berita)

    @Query("SELECT * from berita")
    fun selectAllBerita(): List<Berita>

    @Query("SELECT * from berita WHERE uuid=:id")
    fun selectSpecifiedBerita(id:Int): Berita
}

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg user: User)

    @Query("SELECT * from user")
    fun selectAllUser(): List<User>

    @Query("SELECT * from user where username=:username and password=:password")
    fun login(username:String, password:String) : User

    @Query("SELECT * from user WHERE uuid=:id")
    fun selectAllUser(id:Int): User

    @Query("UPDATE user SET phoneNumber=:phoneNumber, address=:address WHERE uuid =:id")
    fun updateProfile(phoneNumber: String, address: String, id: Int)
}