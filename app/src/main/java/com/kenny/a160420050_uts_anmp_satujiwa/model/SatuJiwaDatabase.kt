package com.kenny.a160420050_uts_anmp_satujiwa.model

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kenny.a160420050_uts_anmp_satujiwa.util.MIGRATION_1_2
import com.kenny.a160420050_uts_anmp_satujiwa.util.MIGRATION_2_3

@Database(entities= arrayOf(Donasi::class, Donatur::class, Berita::class, User::class), version=3)
abstract class SatuJiwaDatabase: RoomDatabase() {
    abstract fun donasiDao():DonasiDao
    abstract fun donaturDao():DonaturDao
    abstract fun beritaDao():BeritaDao
    abstract fun userDao():UserDao

    companion object{
        @Volatile private var instance:SatuJiwaDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            SatuJiwaDatabase::class.java, "satujiwadb")
            .createFromAsset("satujiwadb.db")
            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
            .build()

        operator fun invoke(context: Context){
            if(instance != null){
                synchronized(LOCK){
                    instance?: buildDatabase(context).also{
                        instance = it
                    }
                }
            }
        }
    }
}
//
//@Database(entities= arrayOf(Donatur::class), version=1)
//abstract class DonaturDatabase: RoomDatabase() {
//    abstract fun donaturDao():DonaturDao
//
//    companion object{
//        @Volatile private var instance:DonaturDatabase ?= null
//        private val LOCK = Any()
//
//        private fun buildDatabase(context: Context) = Room.databaseBuilder(
//            context.applicationContext,
//            DonaturDatabase::class.java, "satujiwadb").build()
//
//        operator fun invoke(context: Context){
//            if(instance != null){
//                synchronized(LOCK){
//                    instance?: buildDatabase(context).also{
//                        instance = it
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Database(entities= arrayOf(), version=1)
//abstract class BeritaDatabase: RoomDatabase() {
//
//
//    companion object{
//        @Volatile private var instance:BeritaDatabase ?= null
//        private val LOCK = Any()
//
//        private fun buildDatabase(context: Context) = Room.databaseBuilder(
//            context.applicationContext,
//            BeritaDatabase::class.java, "satujiwadb").build()
//
//        operator fun invoke(context: Context){
//            if(instance != null){
//                synchronized(LOCK){
//                    instance?: buildDatabase(context).also{
//                        instance = it
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Database(entities= arrayOf(), version=1)
//abstract class UserDatabase: RoomDatabase() {
//
//
//    companion object{
//        @Volatile private var instance:UserDatabase ?= null
//        private val LOCK = Any()
//
//        private fun buildDatabase(context: Context) = Room.databaseBuilder(
//            context.applicationContext,
//            UserDatabase::class.java, "satujiwadb").build()
//
//        operator fun invoke(context: Context){
//            if(instance != null){
//                synchronized(LOCK){
//                    instance?: buildDatabase(context).also{
//                        instance = it
//                    }
//                }
//            }
//        }
//    }
//}