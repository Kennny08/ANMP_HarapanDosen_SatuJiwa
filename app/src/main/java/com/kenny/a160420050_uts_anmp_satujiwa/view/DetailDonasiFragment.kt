package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.FragmentDetailAksiNyataBinding
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.FragmentDetailDonasiBinding
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailDonasiViewModel
import kotlin.math.log


class DetailDonasiFragment : Fragment(), DetailDonasiInterface {
    private lateinit var viewModel: DetailDonasiViewModel
    private var donasiId : Int=0
    private lateinit var dataBinding: FragmentDetailDonasiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_detail_donasi, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentDetailDonasiBinding>(inflater, R.layout.fragment_detail_donasi, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailDonasiViewModel::class.java)
        if(arguments != null) {
            donasiId =
                DetailDonasiFragmentArgs.fromBundle(requireArguments()).donasiId
            viewModel.fetch(donasiId)
        }
        observeViewModel(view)
    }


    fun observeViewModel(view: View){
        viewModel.donasisLD.observe(viewLifecycleOwner, Observer {
            dataBinding.donasi = it
            val progress = view.findViewById<ProgressBar>(R.id.progressBarDetailDonasi)
            val hasil = Math.ceil(it.donasiTerkumpul*100/it.targetDonasi)
            progress.setProgress(hasil.toInt())
        })
    }

    override fun onDonasiNominalSatuClick(v: View) {
        Log.d("hello", "onDonasiNominalSatuClick: ")
    }

    override fun onDonasiNominalDuaClick(v: View) {
        Toast.makeText(v.context, "500k", Toast.LENGTH_SHORT).show()
    }

    override fun onDonasiNominalTigaClick(v: View) {
        Toast.makeText(v.context, "1000k", Toast.LENGTH_SHORT).show()
    }
}