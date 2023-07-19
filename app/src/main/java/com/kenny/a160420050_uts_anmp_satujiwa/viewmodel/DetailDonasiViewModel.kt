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
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donatur
import com.kenny.a160420050_uts_anmp_satujiwa.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

//import com.kenny.a160420050_uts_anmp_satujiwa.model.PenyaluranDana

class DetailDonasiViewModel(application: Application
) : AndroidViewModel(application), CoroutineScope{
    val donasisLD = MutableLiveData<Donasi>()
    val donasiLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()
    override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.IO

    fun fetch(idDonasi:Int) {
        donasiLoadErrorLD.value = false
        loadingLD.value = true
        launch {
            val db = buildDB(getApplication())
            donasisLD.postValue(db.donasiDao().selectSpecifiedDonasi(idDonasi))
        }
        loadingLD.value = false
    }
    fun update100(idDonasi:Int) {
        donasiLoadErrorLD.value = false
        loadingLD.value = true
        launch {
            val db = buildDB(getApplication())
            db.donasiDao().updateDonasiTerkumpul100(idDonasi)
        }
        loadingLD.value = false
    }
    fun update500(idDonasi:Int) {
        donasiLoadErrorLD.value = false
        loadingLD.value = true
        launch {
            val db = buildDB(getApplication())
            db.donasiDao().updateDonasiTerkumpul500(idDonasi)
        }
        loadingLD.value = false
    }
    fun update1000(idDonasi:Int) {
        donasiLoadErrorLD.value = false
        loadingLD.value = true
        launch {
            val db = buildDB(getApplication())
            db.donasiDao().updateDonasiTerkumpul1000(idDonasi)
        }
        loadingLD.value = false
    }
    fun insert100(donatur: Donatur){
        donasiLoadErrorLD.value = false
        loadingLD.value = true
        launch {
            val db = buildDB(getApplication())
            db.donaturDao().insertAll(donatur)
        }
        loadingLD.value = false
    }
    fun insert500(donatur: Donatur){
        donasiLoadErrorLD.value = false
        loadingLD.value = true
        launch {
            val db = buildDB(getApplication())
            db.donaturDao().insertAll(donatur)
        }
        loadingLD.value = false
    }
    fun insert1000(donatur: Donatur){
        donasiLoadErrorLD.value = false
        loadingLD.value = true
        launch {
            val db = buildDB(getApplication())
            db.donaturDao().insertAll(donatur)
        }
        loadingLD.value = false
    }
}