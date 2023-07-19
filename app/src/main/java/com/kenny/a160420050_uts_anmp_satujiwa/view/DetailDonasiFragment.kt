package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.LogPrinter
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
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.FragmentDetailAksiNyataBinding
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.FragmentDetailDonasiBinding
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donatur
import com.kenny.a160420050_uts_anmp_satujiwa.util.SatuJiwaWorker
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DetailDonasiViewModel
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit
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
        dataBinding = DataBindingUtil.inflate<FragmentDetailDonasiBinding>(inflater, R.layout.fragment_detail_donasi, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.detailListener = this
        viewModel = ViewModelProvider(this).get(DetailDonasiViewModel::class.java)
        if(arguments != null) {
            donasiId =
                DetailDonasiFragmentArgs.fromBundle(requireArguments()).donasiId
            viewModel.fetch(donasiId)
        }

        val sharedFile = "com.kenny.a160420050_uts_anmp_satujiwa"
        val shared: SharedPreferences = requireActivity().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        val uuid = shared.getString("uuid", "")?.toInt()
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val current = formatter.format(time)
        if (uuid != null) {
            dataBinding.donatur = Donatur(uuid.toInt(), donasiId, 0.0, current.toString())
        }
        observeViewModel(view)
    }


    fun observeViewModel(view: View){
        viewModel.donasisLD.observe(viewLifecycleOwner, Observer {
            dataBinding.donasi = it
            val target = BigDecimal(it.targetDonasi)
            view.findViewById<TextView>(R.id.txtDetailTargetDonasi).text = "Terkumpul dari Rp "+ target.toString()

            val terkumpul = BigDecimal(it.donasiTerkumpul)
            view.findViewById<TextView>(R.id.txtDetailProgressDonasi).text = "Rp "+ terkumpul.toString()

            val progress = view.findViewById<ProgressBar>(R.id.progressBarDetailDonasi)
            val hasil = Math.ceil(it.donasiTerkumpul*100/it.targetDonasi)
            progress.setProgress(hasil.toInt())
        })
    }

    override fun onDonasiNominalSatuClick(v: View, donatur:Donatur) {
        viewModel.update100(donasiId)
        donatur.jumlahDonasi = 100000.0
        viewModel.insert100(donatur)
        Toast.makeText(view?.context, "Berhasil Donasi Rp 100k", Toast.LENGTH_SHORT).show()

        val myWorkRequest = OneTimeWorkRequestBuilder<SatuJiwaWorker>()
            .setInitialDelay(2, TimeUnit.SECONDS)
            .setInputData(workDataOf("title" to "Terima Kasih Orang Baik!", "message" to "Terima kasih karena anda telah berdonasi pada donasi ${dataBinding.donasi!!.namaDonasi} senilai Rp 100.000"))
            .build()

        WorkManager.getInstance(requireContext()).enqueue(myWorkRequest)
        viewModel.fetch(donasiId)
    }

    override fun onDonasiNominalDuaClick(v: View, donatur:Donatur) {
        donatur.jumlahDonasi = 500000.0
        viewModel.update500(donasiId)
        viewModel.insert500(donatur)
        Toast.makeText(view?.context, "Berhasil Donasi Rp 500k", Toast.LENGTH_SHORT).show()

        val myWorkRequest = OneTimeWorkRequestBuilder<SatuJiwaWorker>()
            .setInitialDelay(2, TimeUnit.SECONDS)
            .setInputData(workDataOf("title" to "Terima Kasih Orang Baik!", "message" to "Terima kasih karena anda telah berdonasi pada donasi ${dataBinding.donasi!!.namaDonasi} senilai Rp 500.000"))
            .build()

        WorkManager.getInstance(requireContext()).enqueue(myWorkRequest)
        viewModel.fetch(donasiId)
    }

    override fun onDonasiNominalTigaClick(v: View, donatur:Donatur) {
        viewModel.update1000(donasiId)
        donatur.jumlahDonasi = 1000000.0
        viewModel.insert1000(donatur)
        Toast.makeText(view?.context, "Berhasil Donasi Rp 1000k", Toast.LENGTH_SHORT).show()

        val myWorkRequest = OneTimeWorkRequestBuilder<SatuJiwaWorker>()
            .setInitialDelay(2, TimeUnit.SECONDS)
            .setInputData(workDataOf("title" to "Terima Kasih Orang Baik!", "message" to "Terima kasih karena anda telah berdonasi pada donasi ${dataBinding.donasi!!.namaDonasi} senilai Rp 1.000.000"))
            .build()

        WorkManager.getInstance(requireContext()).enqueue(myWorkRequest)
        viewModel.fetch(donasiId)
    }
}