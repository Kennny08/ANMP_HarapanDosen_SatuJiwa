package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.navigation.Navigation
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnEditProfile = view.findViewById<Button>(R.id.btnEditProfile)
        val btnProfileAboutSatuJiwa = view.findViewById<Button>(R.id.btnProfileAboutSatuJiwa)
        val btnDaftarDonasiSaya = view.findViewById<Button>(R.id.btnDaftarDonasiSaya)
        val imgProfilePengguna = view.findViewById<ImageView>(R.id.imgProfilePengguna)
        val progressBarImagePenggunaProfile = view.findViewById<ProgressBar>(R.id.progressBarImagePenggunaProfile)
        val imgProfileSatuJiwaLogo = view.findViewById<ImageView>(R.id.imgProfileSatuJiwaLogo)
        val progressBarLogoSatuJiwa = view.findViewById<ProgressBar>(R.id.progressBarLogoSatuJiwa)

        imgProfilePengguna.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/kenny.jpg", progressBarImagePenggunaProfile)
        imgProfileSatuJiwaLogo.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/logosatujiwa.png", progressBarLogoSatuJiwa)

//        btnEditProfile.setOnClickListener{
//            val action = ProfileFragmentDirections.actionProfileEditProfile()
//            Navigation.findNavController(it).navigate(action)
//        }
        btnProfileAboutSatuJiwa.setOnClickListener{
            val action = ProfileFragmentDirections.actionProfileAbout()
            Navigation.findNavController(it).navigate(action)
        }

        btnDaftarDonasiSaya.setOnClickListener{
            val action = ProfileFragmentDirections.actionDaftarDonasiSaya()
            Navigation.findNavController(it).navigate(action)
        }
    }
}