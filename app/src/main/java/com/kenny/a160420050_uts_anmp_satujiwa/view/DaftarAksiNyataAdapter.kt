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

class DaftarAksiNyataAdapter (val daftarAksiNyata: ArrayList<Donasi>) :
    RecyclerView.Adapter<DaftarAksiNyataAdapter.AksiNyataViewHolder>() {
    class AksiNyataViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AksiNyataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.daftar_aksinyata_item, parent, false)
        return AksiNyataViewHolder(view)
    }

    override fun onBindViewHolder(holder: AksiNyataViewHolder, position: Int) {
        val txtNamaPenggalangAksiNyata = holder.view.findViewById<TextView>(R.id.txtNamaPenggalangAksiNyata)
        val txtNamaAksiNyata = holder.view.findViewById<TextView>(R.id.txtNamaAksiNyata)
        val txtTanggalTargetAksiNyata = holder.view.findViewById<TextView>(R.id.txtTanggalTargetAksiNyata)

        val progressBarImageAksiNyata = holder.view.findViewById<ProgressBar>(R.id.progressBarImageAksiNyata)
        val txtDanaTerkumpulAksiNyata = holder.view.findViewById<TextView>(R.id.txtDanaTerkumpulAksiNyata)

        val btnDetailAksiNyata = holder.view.findViewById<Button>(R.id.btnDetailAksiNyata)
        val imgAksiNyata = holder.view.findViewById<ImageView>(R.id.imgAksiNyata)

        imgAksiNyata.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/" + daftarAksiNyata[position].fotoDonasi, progressBarImageAksiNyata)
        txtNamaPenggalangAksiNyata.text = daftarAksiNyata[position].namaPenggalang
        txtNamaAksiNyata.text = daftarAksiNyata[position].namaDonasi
        txtDanaTerkumpulAksiNyata.text = "Rp. " + daftarAksiNyata[position].donasiTerkumpul
        txtTanggalTargetAksiNyata.text = daftarAksiNyata[position].tanggalTargetPenggalangan


        btnDetailAksiNyata.setOnClickListener{
            val action = DaftarAksiNyataFragmentDirections.actionDetailAksiNyata(daftarAksiNyata[position].uuid.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return daftarAksiNyata.size
    }

    fun updateDaftarAksiNyata(newDaftarAksiNyata: ArrayList<Donasi>) {
        daftarAksiNyata.clear()
        daftarAksiNyata.addAll(newDaftarAksiNyata)
        notifyDataSetChanged()
    }
}