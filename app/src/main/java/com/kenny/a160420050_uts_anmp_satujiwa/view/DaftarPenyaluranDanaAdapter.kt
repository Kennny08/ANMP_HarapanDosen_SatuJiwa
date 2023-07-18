package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donatur

class DaftarPenyaluranDanaAdapter(val daftarPenyaluranDana: ArrayList<String>) :
    RecyclerView.Adapter<DaftarPenyaluranDanaAdapter.PenyaluranDanaViewHolder>() {
    class PenyaluranDanaViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenyaluranDanaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.daftar_penyalurandana_item, parent, false)
        return PenyaluranDanaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PenyaluranDanaViewHolder, position: Int) {
//        val txtNamaPenerimaDana = holder.view.findViewById<TextView>(R.id.txtNamaPenerimaDana)
//        val txtJumlahPenyaluranDana = holder.view.findViewById<TextView>(R.id.txtJumlahPenyaluranDana)
//        val txtTanggalPenyaluranDana = holder.view.findViewById<TextView>(R.id.txtTanggalPenyaluranDana)
//        val txtPenggunaanDana = holder.view.findViewById<TextView>(R.id.txtPenggunaanDana)
//
//        txtNamaPenerimaDana.text = "Disalurkan kepada " + daftarPenyaluranDana[position].namaPenerima
//        txtJumlahPenyaluranDana.text = "Donasi : " + daftarPenyaluranDana[position].donasiDiterima
//        txtTanggalPenyaluranDana.text = daftarPenyaluranDana[position].tanggalTerima
//        txtPenggunaanDana.text = "Penggunaan dana untuk " + daftarPenyaluranDana[position].penggunaanDana
    }

    override fun getItemCount(): Int {
        return daftarPenyaluranDana.size
    }
//
//    fun updateDaftarPenyaluranDana(newDaftarPenyaluranDana: ArrayList<PenyaluranDana>) {
//        daftarPenyaluranDana.clear()
//        daftarPenyaluranDana.addAll(newDaftarPenyaluranDana)
//        notifyDataSetChanged()
//    }
}