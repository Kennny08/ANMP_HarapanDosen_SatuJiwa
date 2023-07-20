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
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DaftarBeritaViewModel
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.ListViewModel


class DaftarBeritaFragment : Fragment() {
    private lateinit var viewModel: DaftarBeritaViewModel
    private val daftarBeritaAdapter = DaftarBeritaAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DaftarBeritaViewModel::class.java)
        viewModel.refresh()

        val recView = view.findViewById<RecyclerView>(R.id.recyclerViewBerita)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = daftarBeritaAdapter

        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayoutDaftarBerita)
        swipe.setOnRefreshListener {
            recView.visibility = View.GONE
            val txtError = view.findViewById<TextView>(R.id.txtErrorLoadDaftarBerita)
            txtError.visibility = View.GONE
            val progressLoad = view.findViewById<ProgressBar>(R.id.progressBarLoadDaftarBerita)

            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            swipe.isRefreshing = false

        }
        observeViewModel(view)
    }

    fun observeViewModel(view: View){
        val recyclerViewBerita = view.findViewById<RecyclerView>(R.id.recyclerViewBerita)
        val progressBarLoadDaftarBerita = view.findViewById<ProgressBar>(R.id.progressBarLoadDaftarBerita)
        val txtErrorLoadDaftarBerita = view.findViewById<TextView>(R.id.txtErrorLoadDaftarBerita)

        viewModel.beritaLD.observe(viewLifecycleOwner, Observer {
            daftarBeritaAdapter.updateDaftarBerita(it)
        })

        viewModel.beritaLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtErrorLoadDaftarBerita.visibility = View.VISIBLE
            } else {
                txtErrorLoadDaftarBerita.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recyclerViewBerita.visibility = View.GONE
                progressBarLoadDaftarBerita.visibility = View.VISIBLE
            } else {
                recyclerViewBerita.visibility = View.VISIBLE
                progressBarLoadDaftarBerita.visibility = View.GONE
            }
        })
    }


}