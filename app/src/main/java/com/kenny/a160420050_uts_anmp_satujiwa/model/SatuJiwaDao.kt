package com.kenny.a160420050_uts_anmp_satujiwa.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DonasiDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg donasi: Donasi)

    @Query("SELECT * from donasi")
    fun selectAllDonasi(): List<Donasi>
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
}

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg user: User)

    @Query("SELECT * from user")
    fun selectAllUser(): List<User>
}