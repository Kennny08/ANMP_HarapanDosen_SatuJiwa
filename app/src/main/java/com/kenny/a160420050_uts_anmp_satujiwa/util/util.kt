package com.kenny.a160420050_uts_anmp_satujiwa.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.kenny.a160420050_uts_anmp_satujiwa.R


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