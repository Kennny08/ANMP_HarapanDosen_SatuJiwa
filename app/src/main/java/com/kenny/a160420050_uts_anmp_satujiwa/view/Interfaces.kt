package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.view.View
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donatur
import com.kenny.a160420050_uts_anmp_satujiwa.model.User

interface ActivityLoginTodoInterface{
    fun onLoginClick(v: View, user :User)
    fun onGoRegisterClick(v:View)
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
    fun onDonasiNominalSatuClick(v:View, donatur:Donatur)
    fun onDonasiNominalDuaClick(v:View, donatur:Donatur)
    fun onDonasiNominalTigaClick(v:View, donatur:Donatur)
}

interface ProfileInterface{
    fun onEditProfileClick(v:View)
    fun onDonasiSayaClick(v:View)
    fun onAboutSatuJiwaClick(v:View)
    fun onLogoutClick(v:View)
}

interface RegisterInterface{
    fun onRegRegisterClick(v:View, user: User)
    fun onGoLoginClick(v:View)
}
