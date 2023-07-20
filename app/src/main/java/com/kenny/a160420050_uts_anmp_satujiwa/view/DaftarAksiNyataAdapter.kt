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
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.DaftarAksinyataItemBinding
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.DaftarDonasiItemBinding
import com.kenny.a160420050_uts_anmp_satujiwa.model.Berita
import com.kenny.a160420050_uts_anmp_satujiwa.model.Donasi
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage
import java.math.BigDecimal

class DaftarAksiNyataAdapter (val daftarAksiNyata: ArrayList<Donasi>) :
    RecyclerView.Adapter<DaftarAksiNyataAdapter.AksiNyataViewHolder>(), AksiNyataItemInterface {
    class AksiNyataViewHolder(var view: DaftarAksinyataItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AksiNyataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<DaftarAksinyataItemBinding>(inflater, R.layout.daftar_aksinyata_item, parent, false)
        return AksiNyataViewHolder(view)
    }

    override fun onBindViewHolder(holder: AksiNyataViewHolder, position: Int) {
        holder.view.aksinyata = daftarAksiNyata[position]
        holder.view.detailAksiNyataListener = this

        val terkumpul = BigDecimal(daftarAksiNyata[position].donasiTerkumpul)
        holder.itemView.findViewById<TextView>(R.id.txtDanaTerkumpulAksiNyata).text = "Dana Terkumpul Rp "+ terkumpul.toString()
    }

    override fun getItemCount(): Int {
        return daftarAksiNyata.size
    }

    fun updateDaftarAksiNyata(newDaftarAksiNyata: List<Donasi>) {
        daftarAksiNyata.clear()
        daftarAksiNyata.addAll(newDaftarAksiNyata)
        notifyDataSetChanged()
    }

    override fun onAksiNyataDetailClick(v: View) {
        val action = DaftarAksiNyataFragmentDirections.actionDetailAksiNyata(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}