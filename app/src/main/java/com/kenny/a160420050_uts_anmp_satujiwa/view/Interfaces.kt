package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.view.View
import com.kenny.a160420050_uts_anmp_satujiwa.model.User

interface ActivityLoginTodoInterface{
    fun onLoginClick(v: View, user :User)
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


interface AksiNyataItemInterface {
    fun onAksiNyataDetailClick(v: View)
}

interface DetailDonasiInterface{
    fun onDonasiNominalSatuClick(v:View)
    fun onDonasiNominalDuaClick(v:View)
    fun onDonasiNominalTigaClick(v:View)
}

interface ProfileInterface{
    fun onEditProfileClick(v:View)
    fun onDonasiSayaClick(v:View)
    fun onAboutSatuJiwaClick(v:View)
    fun onLogoutClick(v:View)
}
