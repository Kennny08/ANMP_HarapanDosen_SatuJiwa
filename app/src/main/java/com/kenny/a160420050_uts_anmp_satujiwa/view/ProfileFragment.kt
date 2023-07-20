package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.FragmentDetailDonasiBinding
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.FragmentProfileBinding
import com.kenny.a160420050_uts_anmp_satujiwa.model.User
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), ProfileInterface {

    private lateinit var dataBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//        return inflater.inflate(R.layout.fragment_profile, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentProfileBinding>(inflater, R.layout.fragment_profile, container, false)
        return dataBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedFile = "com.kenny.a160420050_uts_anmp_satujiwa"
        val shared: SharedPreferences = requireActivity().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        var name = shared.getString("name", "")
//        val txtNamaPengguna = view.findViewById<TextView>(R.id.txtNamaPengguna)
//        txtNamaPengguna.text = name

        dataBinding.user = name?.let { User(it, "", "", "", "") }

        dataBinding.editListener = this
        dataBinding.aboutSatuJiwaListener = this
        dataBinding.logoutListener = this
        dataBinding.donasiSayaListener = this

        val imgProfilePengguna = view.findViewById<ImageView>(R.id.imgProfilePengguna)
        val progressBarImagePenggunaProfile = view.findViewById<ProgressBar>(R.id.progressBarImagePenggunaProfile)
        imgProfilePengguna.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/logosatujiwa.png", progressBarImagePenggunaProfile)

//        btnEditProfile.setOnClickListener{
//            val action = ProfileFragmentDirections.actionProfileEditProfile()
//            Navigation.findNavController(it).navigate(action)
//        }
//        btnProfileAboutSatuJiwa.setOnClickListener{
//            val action = ProfileFragmentDirections.actionProfileAbout()
//            Navigation.findNavController(it).navigate(action)
//        }
//
//        btnDaftarDonasiSaya.setOnClickListener{
//            val action = ProfileFragmentDirections.actionDaftarDonasiSaya()
//            Navigation.findNavController(it).navigate(action)
//        }
    }

    override fun onEditProfileClick(v: View) {
        val sharedFile = "com.kenny.a160420050_uts_anmp_satujiwa"
        val shared: SharedPreferences = requireActivity().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        val uuid = shared.getString("uuid", "")?.toInt()
            val action = uuid?.let { ProfileFragmentDirections.actionProfileEditProfile(it) }
        if (action != null) {
            Navigation.findNavController(v).navigate(action)
        }
    }

    override fun onDonasiSayaClick(v: View) {
        val action = ProfileFragmentDirections.actionDaftarDonasiSaya()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onAboutSatuJiwaClick(v: View) {
        val action = ProfileFragmentDirections.actionProfileAbout()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onLogoutClick(v: View) {
        val sharedFile = "com.kenny.a160420050_uts_anmp_satujiwa"
        val shared: SharedPreferences = requireActivity().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        var editor:SharedPreferences.Editor = shared.edit()
        editor.putString("uuid", "")
        editor.putString("username", "")
        editor.putString("name", "")
        editor.apply()
        val intent = Intent(v.context, LoginActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }
}