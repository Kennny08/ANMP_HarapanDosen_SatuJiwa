package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donasi
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donatur
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImageDonatur

class DaftarDonaturAdapter(val daftarDonatur: ArrayList<Donatur>) :
    RecyclerView.Adapter<DaftarDonaturAdapter.DonaturViewHolder>() {
    class DonaturViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonaturViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.daftar_donatur_item, parent, false)
        return DonaturViewHolder(view)
    }

    override fun onBindViewHolder(holder: DonaturViewHolder, position: Int) {
        val imgDetailDonasiDonatur = holder.view.findViewById<ImageView>(R.id.imgDetailDonasiDonatur)
        val txtDetailNamaDonatur = holder.view.findViewById<TextView>(R.id.txtDetailNamaDonatur)
        val txtDetailTanggalDonatur = holder.view.findViewById<TextView>(R.id.txtDetailTanggalDonatur)
        val txtDetailJumlahDonasiDonatur = holder.view.findViewById<TextView>(R.id.txtDetailJumlahDonasiDonatur)
        val progressBarImageDonatur = holder.view.findViewById<ProgressBar>(R.id.progressBarImageDonatur)


        txtDetailNamaDonatur.text = daftarDonatur[position].idDonatur.toString()
        txtDetailTanggalDonatur.text = "Donasi pada : " + daftarDonatur[position].tanggalDonasi
        txtDetailJumlahDonasiDonatur.text = "Jumlah : Rp. " + daftarDonatur[position].jumlahDonasi

    }

    override fun getItemCount(): Int {
        return daftarDonatur.size
    }

    fun updateDaftarDonatur(newDaftarDonatur: ArrayList<Donatur>) {
        daftarDonatur.clear()
        daftarDonatur.addAll(newDaftarDonatur)
        notifyDataSetChanged()
    }
}