package com.kenny.a160420050_uts_anmp_satujiwa.view

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

class DaftarDonasiAdapter(val daftarDonasi: ArrayList<Donasi>) :
    RecyclerView.Adapter<DaftarDonasiAdapter.DonasiViewHolder>(), DonasiItemInterface {
    class DonasiViewHolder(var view: DaftarDonasiItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonasiViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.daftar_donasi_item, parent, false)
        val view = DataBindingUtil.inflate<DaftarDonasiItemBinding>(inflater, R.layout.daftar_donasi_item, parent, false)
        return DonasiViewHolder(view)

    }

    override fun onBindViewHolder(holder: DonasiViewHolder, position: Int) {
        holder.view.donasi = daftarDonasi[position]
        holder.view.donasiListener = this
//        val txtNamaPenggalang = holder.view.findViewById<TextView>(R.id.txtNamaPenggalang)
//        val txtNamaDonasi = holder.view.findViewById<TextView>(R.id.txtNamaDonasi)
//        val progressBarDonasi = holder.view.findViewById<ProgressBar>(R.id.progressBarDonasi)
//        val progressBarImageDonasi = holder.view.findViewById<ProgressBar>(R.id.progressBarImageDonasi)
//        val txtDanaTerkumpul = holder.view.findViewById<TextView>(R.id.txtDanaTerkumpul)
//        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
//        val imgDonasi = holder.view.findViewById<ImageView>(R.id.imgDonasi)
//
//        imgDonasi.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/" + daftarDonasi[position].fotoDonasi, progressBarImageDonasi)
//        txtNamaPenggalang.text = daftarDonasi[position].namaPenggalang
//        txtNamaDonasi.text = daftarDonasi[position].namaDonasi
//        txtDanaTerkumpul.text = "Rp. " + daftarDonasi[position].donasiTerkumpul
//        var targetDonasi = daftarDonasi[position].targetDonasi.toString().toDouble()
//        var progress:Double = (daftarDonasi[position].donasiTerkumpul.toString().toDouble() / targetDonasi) * 100
//        progressBarDonasi.setProgress(progress.toInt())
//
//        btnDetail.setOnClickListener{
//            val action = HomeFragmentDirections.actionDetailDonasi(daftarDonasi[position].uuid.toString())
//            Navigation.findNavController(it).navigate(action)
//        }

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
        val action = HomeFragmentDirections.actionDetailDonasi(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}