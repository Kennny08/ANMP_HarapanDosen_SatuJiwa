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


class AboutSatuJiwaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_satu_jiwa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imgAboutSatuJiwa = view.findViewById<ImageView>(R.id.imgAboutSatuJiwa)
        val progressBarImageAboutSatuJiwa = view.findViewById<ProgressBar>(R.id.progressBarImageAboutSatuJiwa)

        imgAboutSatuJiwa.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/logosatujiwa.png", progressBarImageAboutSatuJiwa)
    }
}