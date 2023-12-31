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
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.DaftarBeritaItemBinding
import com.kenny.a160420050_uts_anmp_satujiwa.model.Berita
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donasi
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage

class DaftarBeritaAdapter(val daftarBerita: ArrayList<Berita>) :
    RecyclerView.Adapter<DaftarBeritaAdapter.BeritaViewHolder>(), BeritaItemInterface {
    class BeritaViewHolder(var view: DaftarBeritaItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<DaftarBeritaItemBinding>(inflater, R.layout.daftar_berita_item, parent, false)
        return BeritaViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        holder.view.berita = daftarBerita[position]
        holder.view.clickListener = this
    }

    override fun getItemCount(): Int {
        return daftarBerita.size
    }

    fun updateDaftarBerita(newDaftarBerita: List<Berita>) {
        daftarBerita.clear()
        daftarBerita.addAll(newDaftarBerita)
        notifyDataSetChanged()
    }

    override fun onClick(v: View) {
        val action = DaftarBeritaFragmentDirections.actionDetailBerita(v.tag.toString().toInt())
        Navigation.findNavController(v).navigate(action)
    }
}