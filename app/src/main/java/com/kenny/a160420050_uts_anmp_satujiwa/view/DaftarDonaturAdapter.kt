package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.DaftarBeritaItemBinding
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.DaftarDonaturItemBinding
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donasi
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donatur
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImageDonatur
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.DaftarDonasiSayaViewModel

class DaftarDonaturAdapter(val daftarDonatur: ArrayList<Donatur>) :
    RecyclerView.Adapter<DaftarDonaturAdapter.DonaturViewHolder>() {
    class DonaturViewHolder(var view: DaftarDonaturItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonaturViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<DaftarDonaturItemBinding>(inflater, R.layout.daftar_donatur_item, parent, false)
        return DonaturViewHolder(view)
    }

    override fun onBindViewHolder(holder: DonaturViewHolder, position: Int) {
        holder.view.donatur = daftarDonatur[position]



    }

    override fun getItemCount(): Int {
        return daftarDonatur.size
    }

    fun updateDaftarDonatur(newDaftarDonatur: List<Donatur>) {
        daftarDonatur.clear()
        daftarDonatur.addAll(newDaftarDonatur)
        notifyDataSetChanged()
    }
}