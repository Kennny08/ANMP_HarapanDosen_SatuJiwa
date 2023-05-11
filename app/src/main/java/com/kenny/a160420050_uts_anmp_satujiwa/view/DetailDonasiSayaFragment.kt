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
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailDonasiSayaViewModel
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailDonasiViewModel


class DetailDonasiSayaFragment : Fragment() {

    private lateinit var viewModel: DetailDonasiSayaViewModel
    private var donasiSayaId : String = ""
    private val daftarDonatur = DaftarDonaturAdapter(arrayListOf())
    private val daftarPenyaluranDana = DaftarPenyaluranDanaAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_donasi_saya, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailDonasiSayaViewModel::class.java)
        if(arguments != null) {
            donasiSayaId =
                DetailDonasiSayaFragmentArgs.fromBundle(requireArguments()).donasisayaId
            viewModel.fetch(donasiSayaId)
        }

        val recyclerViewDetailDonatur = view.findViewById<RecyclerView>(R.id.recyclerViewDetailDonaturDonasiSaya)
        recyclerViewDetailDonatur.layoutManager = LinearLayoutManager(context)
        recyclerViewDetailDonatur.adapter = daftarDonatur

        val recylerViewDetailPenyaluranDana = view.findViewById<RecyclerView>(R.id.recylerViewDetailPenyaluranDanaDonasiSaya)
        recylerViewDetailPenyaluranDana.layoutManager = LinearLayoutManager(context)
        recylerViewDetailPenyaluranDana.adapter = daftarPenyaluranDana

        observeViewModel(view)
    }

    fun observeViewModel(view: View){
        val txtDetailNamaDonasiSaya = view.findViewById<TextView>(R.id.txtDetailNamaDonasiSaya)
        val txtDetailProgressDonasiSaya = view.findViewById<TextView>(R.id.txtDetailProgressDonasiSaya)
        val txtDetailSisaHariDonasiSaya = view.findViewById<TextView>(R.id.txtDetailSisaHariDonasiSaya)
        val progressBarDetailDonasiSaya = view.findViewById<ProgressBar>(R.id.progressBarDetailDonasiSaya)
        val txtDetailTargetDonasiSaya = view.findViewById<TextView>(R.id.txtDetailTargetDonasiSaya)
        val txtDetailTargetTanggalDonasiSaya = view.findViewById<TextView>(R.id.txtDetailTargetTanggalDonasiSaya)
        val imgDetailDonasiSaya = view.findViewById<ImageView>(R.id.imgDetailDonasiSaya)
        val imgDetailPenggalangDonasiSaya = view.findViewById<ImageView>(R.id.imgDetailPenggalangDonasiSaya)
        val progressBarDetailImageDonasiSaya = view.findViewById<ProgressBar>(R.id.progressBarDetailImageDonasiSaya)
        val progressBarDetailImagePenggalangDonasiSaya = view.findViewById<ProgressBar>(R.id.progressBarDetailImagePenggalangDonasiSaya)

        val txtDetailNamaPenggalangDonasiSaya = view.findViewById<TextView>(R.id.txtDetailNamaPenggalangDonasiSaya)
        val txtDetailTanggalPenggalanganDonasiSaya = view.findViewById<TextView>(R.id.txtDetailTanggalPenggalanganDonasiSaya)
        val txtDetailDeskripsiDonasiSaya = view.findViewById<TextView>(R.id.txtDetailDeskripsiDonasiSaya)
        val txtDetailTotalDonaturDonasiSaya = view.findViewById<TextView>(R.id.txtDetailTotalDonaturDonasiSaya)


        viewModel.donasiSayaLD.observe(viewLifecycleOwner, Observer{
            var donasi = it
            txtDetailNamaDonasiSaya.text = donasi.namaDonasi
            txtDetailProgressDonasiSaya.text = "Rp. " + donasi.donasiTerkumpul
            txtDetailSisaHariDonasiSaya.text = donasi.sisaHari + " hari lagi"
            var targetDonasi = donasi.targetDonasi.toString().toDouble()
            var progress:Double = (donasi.donasiTerkumpul.toString().toDouble() / targetDonasi) * 100
            progressBarDetailDonasiSaya.setProgress(progress.toInt())
            txtDetailTargetDonasiSaya.text = "Terkumpul dari Rp. " + donasi.targetDonasi
            txtDetailTargetTanggalDonasiSaya.text = donasi.tanggalTargetPenggalangan
            txtDetailNamaPenggalangDonasiSaya.text = donasi.namaPenggalang
            txtDetailTanggalPenggalanganDonasiSaya.text = "Tanggal Penggalangan : " + donasi.tanggalPenggalanganDana
            txtDetailDeskripsiDonasiSaya.text = donasi.deskripsiDonasi
            txtDetailTotalDonaturDonasiSaya.text = "( " + donasi.daftarDonatur?.size.toString() + " Donatur )"
            imgDetailDonasiSaya.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/" + donasi.fotoDonasi, progressBarDetailImageDonasiSaya)
            imgDetailPenggalangDonasiSaya.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/" + donasi.fotoPenggalang, progressBarDetailImagePenggalangDonasiSaya)
        })

        viewModel.donaturLD.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                daftarDonatur.updateDaftarDonatur(it)
            }
        })

        viewModel.penyaluranDanaLD.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                daftarPenyaluranDana.updateDaftarPenyaluranDana(it)
            }
        })
    }

}