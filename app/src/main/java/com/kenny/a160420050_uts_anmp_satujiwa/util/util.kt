package com.kenny.a160420050_uts_anmp_satujiwa.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.model.SatuJiwaDatabase

fun ImageView.loadImage(url:String?, progressBar: ProgressBar){
    Picasso.get()
        .load(url).resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
            }
        })
}

fun ImageView.loadImageDonatur(url:String?, progressBar: ProgressBar){
    Picasso.get()
        .load(url).resize(80, 80)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
            }
        })
}

val DB_NAME = "satujiwadb"

fun buildDB(context: Context):SatuJiwaDatabase{
    val db = Room.databaseBuilder(context, SatuJiwaDatabase::class.java, DB_NAME).createFromAsset("satujiwadb.db").addMigrations(
        MIGRATION_1_2, MIGRATION_2_3).build()

    return db
}

val MIGRATION_1_2 = object:Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE donatur ADD COLUMN namaDonasi TEXT DEFAULT '' not null"
        )
    }
}

val MIGRATION_2_3 = object:Migration(2,3){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE donatur ADD COLUMN fotoDonasi TEXT DEFAULT '' not null"
        )
    }
}

@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadPhotoURL(view:ImageView, url:String?, pb:ProgressBar){
    view.loadImage(url, pb)
}