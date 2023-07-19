package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        dataBinding.user = User("", "", "", "", "")
        dataBinding.registerListener = this
    }

    override fun onRegRegisterClick(v: View, user: User) {
        val confPassword = dataBinding.confPassword
        Log.d("Password", "pass: " + user.password)
        Log.d("Password", "confpass: " + confPassword)
        if(user.name!="" && user.username!="" && user.password!="" && user.phoneNumber != "" && user.address !="") {
            if (confPassword == user.password) {
                viewModel.register(user)
                Toast.makeText(this, "Register Berhasil! Silakan Lakukan Login", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                this.finish()
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
}