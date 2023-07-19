package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donasi
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donatur
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DaftarDonasiSayaViewModel
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.ListViewModel


class DaftarDonasiSayaFragment : Fragment() {
    private lateinit var viewModel: DaftarDonasiSayaViewModel
    private val daftarDonasiSayaAdapter = DaftarDonaturAdapter(arrayListOf())



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_donasi_saya, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DaftarDonasiSayaViewModel::class.java)
        val sharedFile = "com.kenny.a160420050_uts_anmp_satujiwa"
        val shared: SharedPreferences = requireActivity().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        val uuid = shared.getString("uuid", "")?.toInt()
        if (uuid != null) {
            viewModel.refresh(uuid)
        }

        val recView = view.findViewById<RecyclerView>(R.id.recyclerViewDaftarDonasiSaya)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = daftarDonasiSayaAdapter
        observeViewModel(view)
    }

    fun observeViewModel(view: View){

        val recyclerViewDaftarDonasiSaya = view.findViewById<RecyclerView>(R.id.recyclerViewDaftarDonasiSaya)
        val progressBarLoadDaftarDonasiSaya = view.findViewById<ProgressBar>(R.id.progressBarLoadDaftarDonasiSaya)
        val txtErrorDaftarDonasiSaya = view.findViewById<TextView>(R.id.txtErrorDaftarDonasiSaya)


        viewModel.donasiSayaLD.observe(viewLifecycleOwner, Observer {
            daftarDonasiSayaAdapter.updateDaftarDonatur(it)
        })

        viewModel.donasiSayaLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtErrorDaftarDonasiSaya.visibility = View.VISIBLE
            } else {
                txtErrorDaftarDonasiSaya.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recyclerViewDaftarDonasiSaya.visibility = View.GONE
                progressBarLoadDaftarDonasiSaya.visibility = View.VISIBLE
            } else {
                recyclerViewDaftarDonasiSaya.visibility = View.VISIBLE
                progressBarLoadDaftarDonasiSaya.visibility = View.GONE
            }
        })


    }
}