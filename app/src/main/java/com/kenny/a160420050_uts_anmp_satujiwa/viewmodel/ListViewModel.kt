package com.kenny.a160420050_uts_anmp_satujiwa.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donasi
import com.kenny.a160420050_uts_anmp_satujiwa.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    val donasisLD = MutableLiveData<List<Donasi>>()
    val donasiLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()

    override val coroutineContext:CoroutineContext
    get() = job + Dispatchers.IO

    fun refresh() {
        donasiLoadErrorLD.value = false
        loadingLD.value = true

        launch{
            val db = buildDB(getApplication())
            donasisLD.postValue(db.donasiDao().selectAllDonasi())
        }
        loadingLD.value = false
    }

}