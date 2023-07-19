package com.kenny.a160420050_uts_anmp_satujiwa.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.kenny.a160420050_uts_anmp_satujiwa.model.User
import com.kenny.a160420050_uts_anmp_satujiwa.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ProfileViewModel(application:Application):AndroidViewModel(application), CoroutineScope{
    private var job = Job()
    val userLD = MutableLiveData<User>()


    fun update(phoneNumber:String, address:String, id:Int) {
        launch {
            val db = buildDB(getApplication())
            db.userDao().updateProfile(phoneNumber, address, id)
        }
    }

    fun updateAll(phoneNumber:String, address:String, password:String, id:Int)
    {
        launch {
            val db = buildDB(getApplication())
            db.userDao().updateProfileAll(phoneNumber, address, password, id)
        }
    }

    fun fetch(uuid:Int) {
        launch {
            val db = buildDB(getApplication())
            userLD.postValue(db.userDao().selectAllUser(uuid))
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
}
