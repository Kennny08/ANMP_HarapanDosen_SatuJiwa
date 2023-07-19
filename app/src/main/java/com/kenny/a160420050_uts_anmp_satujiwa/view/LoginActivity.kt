package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.ActivityLoginBinding
import com.kenny.a160420050_uts_anmp_satujiwa.model.User
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(), ActivityLoginTodoInterface {

    private lateinit var dataBinding:ActivityLoginBinding
    private lateinit var viewModel:LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var sharedFile = "com.kenny.a160420050_uts_anmp_satujiwa"
        var shared: SharedPreferences = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)

        var username = shared.getString("username", "")
        if(username!="")
        {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        dataBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        dataBinding.user = User("", "", "", "", "")
        dataBinding.loginlistener = this
        observeViewModel()
    }



    override fun onLoginClick(v: View, user:User) {
        viewModel.login(user)
    }

    override fun onGoRegisterClick(v: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun observeViewModel(){
        viewModel.userLD.observe(this, Observer {
            if (it == null){
                Toast.makeText(this, "Username atau Password Salah!", Toast.LENGTH_SHORT).show()
                dataBinding.user = User("", "", "", "", "")

            }else{
                var sharedFile = "com.kenny.a160420050_uts_anmp_satujiwa"
                var shared: SharedPreferences = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
                var editor:SharedPreferences.Editor = shared.edit()
                editor.putString("uuid", it.uuid.toString())
                editor.putString("username", it.username)
                editor.putString("name", it.name)
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                this.finish()
            }

        })
    }


}