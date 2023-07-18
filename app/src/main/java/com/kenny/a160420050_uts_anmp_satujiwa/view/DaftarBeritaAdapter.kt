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
import com.kenny.a160420050_uts_anmp_satujiwa.model.Berita
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donasi
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage

class DaftarBeritaAdapter(val daftarBerita: ArrayList<Berita>) :
    RecyclerView.Adapter<DaftarBeritaAdapter.BeritaViewHolder>() {
    class BeritaViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.daftar_berita_item, parent, false)
        return BeritaViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        val imgBerita = holder.view.findViewById<ImageView>(R.id.imgBerita)
        val txtJudulBerita = holder.view.findViewById<TextView>(R.id.txtJudulBerita)
        val txtNamaPenulisBerita = holder.view.findViewById<TextView>(R.id.txtNamaPenulisBerita)
        val txtTanggalBerita = holder.view.findViewById<TextView>(R.id.txtTanggalBerita)
        val btnBacaBerita = holder.view.findViewById<Button>(R.id.btnBacaBerita)
        val progressBarImageBerita = holder.view.findViewById<ProgressBar>(R.id.progressBarImageBerita)


        imgBerita.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/" + daftarBerita[position].gambarBerita, progressBarImageBerita)
        txtJudulBerita.text = daftarBerita[position].judulBerita
        txtTanggalBerita.text = daftarBerita[position].tanggalBerita
        txtNamaPenulisBerita.text = daftarBerita[position].namaPenulis


        btnBacaBerita.setOnClickListener{
            val action = DaftarBeritaFragmentDirections.actionDetailBerita(daftarBerita[position].uuid.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return daftarBerita.size
    }

    fun updateDaftarBerita(newDaftarBerita: ArrayList<Berita>) {
        daftarBerita.clear()
        daftarBerita.addAll(newDaftarBerita)
        notifyDataSetChanged()
    }
}