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
//import com.kenny.a160420050_uts_anmp_satujiwa.model.AksiNyata
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donasi
import com.kenny.a160420050_uts_anmp_satujiwa.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DaftarAksiNyataViewModel(application: Application) : AndroidViewModel(application), CoroutineScope{
    val aksiNyataLD = MutableLiveData<List<Donasi>>()
    val aksiNyataLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun refresh() {
        aksiNyataLoadErrorLD.value = false
        loadingLD.value = true

        launch {
            val db = buildDB(getApplication())

            aksiNyataLD.postValue(db.donasiDao().selectAllAksiNyata())
        }
        loadingLD.value = false
    }
}