package com.kenny.a160420050_uts_anmp_satujiwa.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donasi
import com.kenny.a160420050_uts_anmp_satujiwa.model.DonasiSaya
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donatur
import com.kenny.a160420050_uts_anmp_satujiwa.model.PenyaluranDana

class DetailDonasiSayaViewModel(application: Application) : AndroidViewModel(application){
    val donasiSayaLD = MutableLiveData<DonasiSaya>()
    val donaturLD = MutableLiveData<ArrayList<Donatur>?>()
    val penyaluranDanaLD = MutableLiveData<ArrayList<PenyaluranDana>?>()
    val donasiSayaLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

    fun fetch(idDonasi:String) {
        donasiSayaLoadErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url =  "https://projectfspf.000webhostapp.com/projectutsanmp/donasisaya.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<DonasiSaya>>() {}.type
                val result = Gson().fromJson<List<DonasiSaya>>(it, sType)
                val daftarDonasi = result as ArrayList<DonasiSaya>
                for (donasi in daftarDonasi){
                    if (donasi.id ==  idDonasi){
                        donasiSayaLD.value = donasi
                        donaturLD.value = donasi.daftarDonatur
                        penyaluranDanaLD.value = donasi.penyaluranDana
                        break
                    }
                }
                loadingLD.value = false
                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
                donasiSayaLoadErrorLD.value = false
                loadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}