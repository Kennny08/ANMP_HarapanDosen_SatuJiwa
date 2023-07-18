package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.os.Bundle
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
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DaftarAksiNyataViewModel
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.ListViewModel


class DaftarAksiNyataFragment : Fragment() {

    private lateinit var viewModel:DaftarAksiNyataViewModel
    private val daftarAksiNyataAdapter = DaftarAksiNyataAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_aksi_nyata, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DaftarAksiNyataViewModel::class.java)
        viewModel.refresh()
        val recView = view.findViewById<RecyclerView>(R.id.recyclerViewDaftarAksiNyata)

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = daftarAksiNyataAdapter
        observeViewModel(view)

        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayoutDaftarAksiNyata)
        swipe.setOnRefreshListener {
            recView.visibility = View.GONE
            val txtError = view.findViewById<TextView>(R.id.txtErrorLoadDaftarAksiNyata)
            txtError.visibility = View.GONE
            val progressLoad = view.findViewById<ProgressBar>(R.id.progressBarLoadDaftarAksiNyata)

            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            swipe.isRefreshing = false

        }
    }

    fun observeViewModel(view: View){
        val recyclerViewDaftarAksiNyata = view.findViewById<RecyclerView>(R.id.recyclerViewDaftarAksiNyata)
        val progressBarLoadDaftarAksiNyata = view.findViewById<ProgressBar>(R.id.progressBarLoadDaftarAksiNyata)
        val txtErrorLoadDaftarAksiNyata = view.findViewById<TextView>(R.id.txtErrorLoadDaftarAksiNyata)

        viewModel.aksiNyataLD.observe(viewLifecycleOwner, Observer {
            daftarAksiNyataAdapter.updateDaftarAksiNyata(it)
        })

        viewModel.aksiNyataLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtErrorLoadDaftarAksiNyata.visibility = View.VISIBLE
            } else {
                txtErrorLoadDaftarAksiNyata.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recyclerViewDaftarAksiNyata.visibility = View.GONE
                progressBarLoadDaftarAksiNyata.visibility = View.VISIBLE
            } else {
                recyclerViewDaftarAksiNyata.visibility = View.VISIBLE
                progressBarLoadDaftarAksiNyata.visibility = View.GONE
            }
        })
    }

}