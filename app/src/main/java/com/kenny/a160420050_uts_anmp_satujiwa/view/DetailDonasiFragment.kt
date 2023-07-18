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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailDonasiViewModel


class DetailDonasiFragment : Fragment() {
    private lateinit var viewModel: DetailDonasiViewModel
    private var donasiId : String = ""
    private val daftarDonatur = DaftarDonaturAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_donasi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailDonasiViewModel::class.java)
        if(arguments != null) {
            donasiId =
                DetailDonasiFragmentArgs.fromBundle(requireArguments()).donasiId
            viewModel.fetch(donasiId)
        }
//
//        val recyclerViewDetailDonatur = view.findViewById<RecyclerView>(R.id.recyclerViewDetailDonatur)
//        recyclerViewDetailDonatur.layoutManager = LinearLayoutManager(context)
//        recyclerViewDetailDonatur.adapter = daftarDonatur
//
//        val recylerViewDetailPenyaluranDana = view.findViewById<RecyclerView>(R.id.recylerViewDetailPenyaluranDana)
//        recylerViewDetailPenyaluranDana.layoutManager = LinearLayoutManager(context)
//        recylerViewDetailPenyaluranDana.adapter = daftarPenyaluranDana
//
//        observeViewModel(view)

    }


    fun observeViewModel(view: View){
//        val txtDetailNama = view.findViewById<TextView>(R.id.txtDetailNamaDonasi)
//        val txtDetailProgressDonasi = view.findViewById<TextView>(R.id.txtDetailProgressDonasi)
//        val txtDetailSisaHari = view.findViewById<TextView>(R.id.txtDetailSisaHari)
//        val progressBarDetailDonasi = view.findViewById<ProgressBar>(R.id.progressBarDetailDonasi)
//        val txtDetailTargetDonasi = view.findViewById<TextView>(R.id.txtDetailTargetDonasi)
//        val txtDetailTargetTanggal = view.findViewById<TextView>(R.id.txtDetailTargetTanggal)
//        val imgDetailDonasi = view.findViewById<ImageView>(R.id.imgDetailDonasi)
//        val imgDetailPenggalang = view.findViewById<ImageView>(R.id.imgDetailPenggalang)
//        val progressBarDetailImageDonasi = view.findViewById<ProgressBar>(R.id.progressBarDetailImageDonasi)
//        val progressBarDetailImagePenggalang = view.findViewById<ProgressBar>(R.id.progressBarDetailImagePenggalang)
//
//        val txtDetailNamaPenggalang = view.findViewById<TextView>(R.id.txtDetailNamaPenggalang)
//        val txtDetailTanggalPenggalangan = view.findViewById<TextView>(R.id.txtDetailTanggalPenggalangan)
//        val txtDetailDeskripsiDonasi = view.findViewById<TextView>(R.id.txtDetailDeskripsiDonasi)
//        val txtDetailTotalDonatur = view.findViewById<TextView>(R.id.txtDetailTotalDonatur)

//
//        viewModel.donasisLD.observe(viewLifecycleOwner, Observer{
//            var donasi = it
//            txtDetailNama.text = donasi.namaDonasi
//            txtDetailProgressDonasi.text = "Rp. " + donasi.donasiTerkumpul
//            txtDetailSisaHari.text = donasi.sisaHari + " hari lagi"
//            var targetDonasi = donasi.targetDonasi.toString().toDouble()
//            var progress:Double = (donasi.donasiTerkumpul.toString().toDouble() / targetDonasi) * 100
//            progressBarDetailDonasi.setProgress(progress.toInt())
//            txtDetailTargetDonasi.text = "Terkumpul dari Rp. " + donasi.targetDonasi
//            txtDetailTargetTanggal.text = donasi.tanggalTargetPenggalangan
//            txtDetailNamaPenggalang.text = donasi.namaPenggalang
//            txtDetailTanggalPenggalangan.text = "Tanggal Penggalangan : " + donasi.tanggalPenggalanganDana
//            txtDetailDeskripsiDonasi.text = donasi.deskripsiDonasi
//            txtDetailTotalDonatur.text = "( " + donasi.daftarDonatur?.size.toString() + " Donatur )"
//            imgDetailDonasi.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/" + donasi.fotoDonasi, progressBarDetailImageDonasi)
//            imgDetailPenggalang.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/" + donasi.fotoPenggalang, progressBarDetailImagePenggalang)
//        })
//
//        viewModel.donaturLD.observe(viewLifecycleOwner, Observer {
//            if (it != null) {
//                daftarDonatur.updateDaftarDonatur(it)
//            }
//        })
//
//        viewModel.penyaluranDanaLD.observe(viewLifecycleOwner, Observer {
//            if (it != null) {
//                daftarPenyaluranDana.updateDaftarPenyaluranDana(it)
//            }
//        })
    }
}