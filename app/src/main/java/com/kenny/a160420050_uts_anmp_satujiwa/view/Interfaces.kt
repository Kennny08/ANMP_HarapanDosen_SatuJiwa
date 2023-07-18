package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.view.View
import com.kenny.a160420050_uts_anmp_satujiwa.model.User

interface FragmentLoginTodoInterface{
    fun onLoginClick(v: View)
}

interface BeritaItemInterface{
    fun onClick(v:View)
}

interface ProfileEditInterface{
    fun simpanClick(v:View, user: User)
}

interface DonasiItemInterface{
    fun onDonasiDetailClick(v:View)
}

interface AksiNyataItemInterface{
    fun onAksiNyataDetailClick(v:View)
}
