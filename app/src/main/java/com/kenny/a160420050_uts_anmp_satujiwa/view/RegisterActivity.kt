package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.ActivityLoginBinding
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.ActivityRegisterBinding
import com.kenny.a160420050_uts_anmp_satujiwa.model.User
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.LoginViewModel
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity(), RegisterInterface {

    private lateinit var dataBinding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel
    private lateinit var newUser:User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        dataBinding.user = User("", "", "", "", "")
        dataBinding.registerListener = this

        observeViewModel()
    }

    override fun onRegRegisterClick(v: View, user: User) {
        val confPassword = dataBinding.confPassword
        if(user.name!="" && user.username!="" && user.password!="" && user.phoneNumber != "" && user.address !="") {
            if (confPassword == user.password) {
                viewModel.checkUsername(user)
                newUser = user
            } else {
                Toast.makeText(this, "Konfirmasi Password Tidak Cocok", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(this, "Data Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onGoLoginClick(v: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        this.finish()
    }

    fun observeViewModel(){
        viewModel.userLD.observe(this, Observer {
            if (it != null){
                Toast.makeText(this, "Username atau Nomor Telepon telah terdaftar!", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.register(newUser)
                Toast.makeText(this, "Register Berhasil! Silakan Lakukan Login", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                this.finish()
            }

        })
    }
}