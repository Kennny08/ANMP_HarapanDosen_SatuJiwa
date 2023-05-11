package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage


class EditProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imgEditProfilePengguna = view.findViewById<ImageView>(R.id.imgEditProfilePengguna)
        val progressBarImageEditProfilPengguna = view.findViewById<ProgressBar>(R.id.progressBarImageEditProfilPengguna)

        imgEditProfilePengguna.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/kenny.jpg", progressBarImageEditProfilPengguna)
    }
}