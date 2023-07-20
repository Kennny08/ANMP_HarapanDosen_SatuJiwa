package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.DaftarDonasiItemBinding
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donasi
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage
import java.math.BigDecimal

class DaftarDonasiAdapter(val daftarDonasi: ArrayList<Donasi>) :
    RecyclerView.Adapter<DaftarDonasiAdapter.DonasiViewHolder>(), DonasiItemInterface {
    class DonasiViewHolder(var view: DaftarDonasiItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonasiViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<DaftarDonasiItemBinding>(inflater, R.layout.daftar_donasi_item, parent, false)
        return DonasiViewHolder(view)

    }

    override fun onBindViewHolder(holder: DonasiViewHolder, position: Int) {
        holder.view.donasi = daftarDonasi[position]
        holder.view.donasiListener = this

        val terkumpul = BigDecimal(daftarDonasi[position].targetDonasi)
        holder.itemView.findViewById<TextView>(R.id.txtDanaTerkumpul).text = "Dana dibutuhkan : Rp "+ terkumpul.toString()

        val progress = holder.itemView.findViewById<ProgressBar>(R.id.progressBarDonasi)
        val hasil = Math.ceil(daftarDonasi[position].donasiTerkumpul*100/daftarDonasi[position].targetDonasi)
        progress.setProgress(hasil.toInt())
    }

    override fun getItemCount(): Int {
        return daftarDonasi.size
    }

    fun updateDaftarDonasi(newDaftarDonasi: List<Donasi>) {
        daftarDonasi.clear()
        daftarDonasi.addAll(newDaftarDonasi)
        notifyDataSetChanged()
    }

    override fun onDonasiDetailClick(v: View) {
        val action = HomeFragmentDirections.actionDetailDonasi(v.tag.toString().toInt())
        Navigation.findNavController(v).navigate(action)
    }
}