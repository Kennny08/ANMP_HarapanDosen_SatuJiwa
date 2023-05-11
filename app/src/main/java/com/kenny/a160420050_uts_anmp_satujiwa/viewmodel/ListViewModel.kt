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

class ListViewModel(application: Application) : AndroidViewModel(application) {
    val donasisLD = MutableLiveData<ArrayList<Donasi>>()
    val donasiLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

    fun refresh() {
        donasiLoadErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url =  "https://projectfspf.000webhostapp.com/projectutsanmp/donasi.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Donasi>>() {}.type
                val result = Gson().fromJson<List<Donasi>>(it, sType)
                donasisLD.value =
                    result as ArrayList<Donasi> /* = java.util.ArrayList<com.kenny.a160420050_week4.model.Student> */

                loadingLD.value = false
                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
                donasiLoadErrorLD.value = true
                loadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

}