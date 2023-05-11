package com.kenny.a160420050_uts_anmp_satujiwa.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.kenny.a160420050_uts_anmp_satujiwa.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        navController =
            (supportFragmentManager.findFragmentById(R.id.hostFragment) as
                    NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController)

        val navView = findViewById<NavigationView>(R.id.navView)
        NavigationUI.setupWithNavController(navView, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNav.setupWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return  NavigationUI.navigateUp(navController, drawerLayout) || navController.navigateUp()
    }

}