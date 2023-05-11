package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailBeritaViewModel
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailDonasiViewModel

class DetailBeritaFragment : Fragment() {

    private lateinit var viewModel: DetailBeritaViewModel
    private var beritaId : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailBeritaViewModel::class.java)
        if(arguments != null) {
            beritaId =
                DetailBeritaFragmentArgs.fromBundle(requireArguments()).beritaId
            viewModel.fetch(beritaId)
        }

        observeViewModel(view)
    }

    fun observeViewModel(view: View) {
        val txtDetailJudulBerita = view.findViewById<TextView>(R.id.txtDetailJudulBerita)
        val txtDetailTanggalBerita = view.findViewById<TextView>(R.id.txtDetailTanggalBerita)
        val txtDetailNamaPenulisBerita =view.findViewById<TextView>(R.id.txtDetailNamaPenulisBerita)
        val txtDetailIsiBerita = view.findViewById<TextView>(R.id.txtDetailIsiBerita)
        val imgDetailBerita = view.findViewById<ImageView>(R.id.imgDetailBerita)
        val progressBarDetailImageBerita = view.findViewById<ProgressBar>(R.id.progressBarDetailImageBerita)


        viewModel.beritaLD.observe(viewLifecycleOwner, Observer {
            var berita = it
            txtDetailJudulBerita.text = berita.judulBerita
            txtDetailTanggalBerita.text = berita.tanggalBerita
            txtDetailNamaPenulisBerita.text = berita.namaPenulis
            txtDetailIsiBerita.text = berita.isiBerita
            imgDetailBerita.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/" + berita.gambarBerita, progressBarDetailImageBerita)

        })

    }


}