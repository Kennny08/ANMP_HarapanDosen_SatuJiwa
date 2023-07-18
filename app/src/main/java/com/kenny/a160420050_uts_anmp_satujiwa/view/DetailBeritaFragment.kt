package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.FragmentDetailBeritaBinding
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailBeritaViewModel
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailDonasiViewModel

class DetailBeritaFragment : Fragment() {

    private lateinit var viewModel: DetailBeritaViewModel
    private lateinit var dataBinding: FragmentDetailBeritaBinding
    private var beritaId : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentDetailBeritaBinding>(inflater, R.layout.fragment_detail_berita, container, false)
        return dataBinding.root
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
        viewModel.beritaLD.observe(viewLifecycleOwner, Observer {
            dataBinding.berita = it
        })
    }
}