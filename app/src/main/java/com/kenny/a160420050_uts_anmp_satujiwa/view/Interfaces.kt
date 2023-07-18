package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.view.View
import com.kenny.a160420050_uts_anmp_satujiwa.model.User

interface BeritaItemInterface{
    fun onClick(v:View)
}

interface ProfileEditInterface{
    fun simpanClick(v:View, user: User)
}

interface DonasiItemInterface{
    fun onDonasiDetailClick(v:View)
}
