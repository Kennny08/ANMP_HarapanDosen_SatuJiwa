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
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailAksiNyataViewModel
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailDonasiViewModel


class DetailAksiNyataFragment : Fragment() {

    private lateinit var viewModel: DetailAksiNyataViewModel
    private var aksiNyataId : String = ""
    private val daftarDonatur = DaftarDonaturAdapter(arrayListOf())
    private val daftarPenyaluranDana = DaftarPenyaluranDanaAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_aksi_nyata, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel = ViewModelProvider(this).get(DetailAksiNyataViewModel::class.java)
//        if(arguments != null) {
//            aksiNyataId =
//                DetailAksiNyataFragmentArgs.fromBundle(requireArguments()).aksiNyataId
//            viewModel.fetch(aksiNyataId)
//        }
//
//        val recyclerViewDetailDonaturAksiNyata = view.findViewById<RecyclerView>(R.id.recyclerViewDetailDonaturAksiNyata)
//        recyclerViewDetailDonaturAksiNyata.layoutManager = LinearLayoutManager(context)
//        recyclerViewDetailDonaturAksiNyata.adapter = daftarDonatur
//
//        val recylerViewDetailPenyaluranDanaAksiNyata = view.findViewById<RecyclerView>(R.id.recylerViewDetailPenyaluranDanaAksiNyata)
//        recylerViewDetailPenyaluranDanaAksiNyata.layoutManager = LinearLayoutManager(context)
//        recylerViewDetailPenyaluranDanaAksiNyata.adapter = daftarPenyaluranDana
//
//        observeViewModel(view)
    }

    fun observeViewModel(view: View){
//        val txtDetailNamaAksiNyata = view.findViewById<TextView>(R.id.txtDetailNamaAksiNyata)
//        val txtDetailDonasiTerkumpulAksiNyata = view.findViewById<TextView>(R.id.txtDetailDonasiTerkumpulAksiNyata)
//
//        val txtDetailTargetTanggalAksiNyata = view.findViewById<TextView>(R.id.txtDetailTargetTanggalAksiNyata)
//        val imgDetailAksiNyata = view.findViewById<ImageView>(R.id.imgDetailAksiNyata)
//        val imgDetailPenggalangAksiNyata = view.findViewById<ImageView>(R.id.imgDetailPenggalangAksiNyata)
//        val progressBarDetailImageAksiNyata = view.findViewById<ProgressBar>(R.id.progressBarDetailImageAksiNyata)
//        val progressBarDetailImagePenggalangAksiNyata = view.findViewById<ProgressBar>(R.id.progressBarDetailImagePenggalangAksiNyata)
//
//        val txtDetailNamaPenggalangAksiNyata = view.findViewById<TextView>(R.id.txtDetailNamaPenggalangAksiNyata)
//        val txtDetailTanggalPenggalanganAksiNyata = view.findViewById<TextView>(R.id.txtDetailTanggalPenggalanganAksiNyata)
//        val txtDetailDeskripsiAksiNyata = view.findViewById<TextView>(R.id.txtDetailDeskripsiAksiNyata)
//        val txtDetailTotalDonaturAksiNyata = view.findViewById<TextView>(R.id.txtDetailTotalDonaturAksiNyata)
//
//
//        viewModel.aksiNyataLD.observe(viewLifecycleOwner, Observer{
//            var aksiNyata = it
//            txtDetailNamaAksiNyata.text = aksiNyata.namaAksiNyata
//            txtDetailTargetTanggalAksiNyata.text = "Donasi ditutup pada " + aksiNyata.tanggalTargetPenggalangan
//            txtDetailDonasiTerkumpulAksiNyata.text = "terkumpul Rp. " + aksiNyata.donasiTerkumpul
//            txtDetailNamaPenggalangAksiNyata.text = aksiNyata.namaPenggalang
//            txtDetailTanggalPenggalanganAksiNyata.text = "Tanggal Penggalangan : " + aksiNyata.tanggalPenggalanganDana
//            txtDetailDeskripsiAksiNyata.text = aksiNyata.deskripsiAksiNyata
//            txtDetailTotalDonaturAksiNyata.text = "( " + aksiNyata.daftarDonatur?.size.toString() + " Donatur )"
//            imgDetailAksiNyata.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/" + aksiNyata.fotoAksiNyata, progressBarDetailImageAksiNyata)
//            imgDetailPenggalangAksiNyata.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/" + aksiNyata.fotoPenggalang, progressBarDetailImagePenggalangAksiNyata)
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