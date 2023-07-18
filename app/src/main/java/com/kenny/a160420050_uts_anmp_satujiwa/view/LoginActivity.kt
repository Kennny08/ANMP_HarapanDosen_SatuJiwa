package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
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

class LoginActivity : AppCompatActivity(), FragmentLoginTodoInterface {

    private lateinit var dataBinding:ActivityLoginBinding
    private lateinit var viewModel:LoginViewModel
    private lateinit var curUser : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)

        dataBinding.user = User("", "", "", "", "")
        dataBinding.loginlistener = this
    }

//    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
////        return super.onCreateView(name, context, attrs)
//        dataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_login, null, false)
//        return dataBinding.root
//
//    }

    override fun onLoginClick(v: View) {
        Toast.makeText(v.context, "Bisa", Toast.LENGTH_SHORT).show()
//        viewModel.login(user)
//
//        var checkUser = viewModel.userLD as User
//
//        if (curUser.username == checkUser.username){
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            this.finish()
//        }
        //        observeViewModel()
    }

//    fun observeViewModel(){
//        viewModel.userLD.observe(viewL, Observer {
//            curUser = it
//
//        })
//    }


}