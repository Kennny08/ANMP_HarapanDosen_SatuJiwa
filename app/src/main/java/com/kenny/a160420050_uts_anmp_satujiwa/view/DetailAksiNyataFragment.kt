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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.FragmentDetailAksiNyataBinding
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.FragmentDetailBeritaBinding
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailAksiNyataViewModel
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailBeritaViewModel
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailDonasiViewModel


class DetailAksiNyataFragment : Fragment() {

    private lateinit var viewModel: DetailAksiNyataViewModel
    private lateinit var dataBinding: FragmentDetailAksiNyataBinding
    private var aksiNyataId : String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentDetailAksiNyataBinding>(inflater, R.layout.fragment_detail_aksi_nyata, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailAksiNyataViewModel::class.java)
        if(arguments != null) {
            aksiNyataId =
                DetailAksiNyataFragmentArgs.fromBundle(requireArguments()).aksiNyataId
            viewModel.fetch(aksiNyataId)
        }

        observeViewModel(view)
    }

    fun observeViewModel(view: View){
        viewModel.aksiNyataLD.observe(viewLifecycleOwner, Observer {
            dataBinding.aksinyata = it
        })
    }
}