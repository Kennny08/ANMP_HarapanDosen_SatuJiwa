package com.kenny.a160420050_uts_anmp_satujiwa.view

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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.ListViewModel

class HomeFragment : Fragment() {

    private lateinit var viewModel:ListViewModel
    private val daftarDonasiAdapter = DaftarDonasiAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        val recView = view.findViewById<RecyclerView>(R.id.recycleViewDonasi)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = daftarDonasiAdapter

        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayoutDonasi)
        swipe.setOnRefreshListener {
            recView.visibility = View.GONE
            val txtError = view.findViewById<TextView>(R.id.txtErrorDaftarDonasi)
            txtError.visibility = View.GONE
            val progressLoad = view.findViewById<ProgressBar>(R.id.progressBarLoadDaftarDonasi)

            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            swipe.isRefreshing = false

        }
        observeViewModel(view)
    }

    fun observeViewModel(view: View){

        val recylerViewDonasi = view.findViewById<RecyclerView>(R.id.recycleViewDonasi)
        val progressBarLoadDaftarDonasi = view.findViewById<ProgressBar>(R.id.progressBarLoadDaftarDonasi)
        val txtErrorDaftarDonasi = view.findViewById<TextView>(R.id.txtErrorDaftarDonasi)

        viewModel.donasisLD.observe(viewLifecycleOwner, Observer {
            daftarDonasiAdapter.updateDaftarDonasi(it)
        })

        viewModel.donasiLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtErrorDaftarDonasi.visibility = View.VISIBLE
            } else {
                txtErrorDaftarDonasi.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recylerViewDonasi.visibility = View.GONE
                progressBarLoadDaftarDonasi.visibility = View.VISIBLE
            } else {
                recylerViewDonasi.visibility = View.VISIBLE
                progressBarLoadDaftarDonasi.visibility = View.GONE
            }
        })


    }



}