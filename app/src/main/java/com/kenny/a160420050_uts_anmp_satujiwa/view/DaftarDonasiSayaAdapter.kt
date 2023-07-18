package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donasi
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage

class DaftarDonasiSayaAdapter(val daftarDonasiSaya: ArrayList<Donasi>) :
    RecyclerView.Adapter<DaftarDonasiSayaAdapter.DonasiSayaViewHolder>() {
    class DonasiSayaViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonasiSayaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.daftar_donasisaya_item, parent, false)
        return DonasiSayaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DonasiSayaViewHolder, position: Int) {
        val txtNamaPenggalangDonasiSaya = holder.view.findViewById<TextView>(R.id.txtNamaPenggalangDonasiSaya)
        val txtNamaDonasiSaya = holder.view.findViewById<TextView>(R.id.txtNamaDonasiSaya)
        val progressBarDonasiSaya = holder.view.findViewById<ProgressBar>(R.id.progressBarDonasiSaya)
        val progressBarImageDonasiSaya = holder.view.findViewById<ProgressBar>(R.id.progressBarImageDonasiSaya)
        val txtDanaTerkumpulDonasiSaya = holder.view.findViewById<TextView>(R.id.txtDanaTerkumpulDonasiSaya)
        val txtTargetHariDonasiSaya = holder.view.findViewById<TextView>(R.id.txtTargetHariDonasiSaya)
        val btnDetailDonasiSaya = holder.view.findViewById<Button>(R.id.btnDetailDonasiSaya)
        val imgDonasiSaya = holder.view.findViewById<ImageView>(R.id.imgDonasiSaya)

        imgDonasiSaya.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/" + daftarDonasiSaya[position].fotoDonasi, progressBarImageDonasiSaya)
        txtNamaPenggalangDonasiSaya.text = daftarDonasiSaya[position].namaPenggalang
        txtNamaDonasiSaya.text = daftarDonasiSaya[position].namaDonasi
        txtDanaTerkumpulDonasiSaya.text = "Rp. " + daftarDonasiSaya[position].donasiTerkumpul
        var targetDonasi = daftarDonasiSaya[position].targetDonasi.toString().toDouble()
        var progress:Double = (daftarDonasiSaya[position].donasiTerkumpul.toString().toDouble() / targetDonasi) * 100
        progressBarDonasiSaya.setProgress(progress.toInt())

        btnDetailDonasiSaya.setOnClickListener{
            val action = DaftarDonasiSayaFragmentDirections.actionDetailDonasiSaya(daftarDonasiSaya[position].uuid.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return daftarDonasiSaya.size
    }

    fun updateDaftarDonasiSaya(newDaftarDonasiSaya: List<Donasi>) {
        daftarDonasiSaya.clear()
        daftarDonasiSaya.addAll(newDaftarDonasiSaya)
        notifyDataSetChanged()
    }


}