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

class LoginViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    val userLD = MutableLiveData<User>()

    fun login(user: User) {
        launch {
            val db = buildDB(getApplication())
            userLD.postValue(db.userDao().login(user.username, user.password))

        }
    }
}