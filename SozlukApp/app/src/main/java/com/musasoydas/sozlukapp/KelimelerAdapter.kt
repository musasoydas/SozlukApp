package com.musasoydas.sozlukapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.musasoydas.sozlukapp.databinding.RecyclerRowBinding

class KelimelerAdapter(val mContext: Context,val kelimelerListe: List<Kelimeler>) :
    RecyclerView.Adapter<KelimelerAdapter.KelimeViewHolder>() {
    inner class KelimeViewHolder(val binding: RecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KelimeViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KelimeViewHolder(binding)
    }

    override fun getItemCount(): Int {
            return kelimelerListe.size
    }

    override fun onBindViewHolder(holder: KelimeViewHolder, position: Int) {
        with(holder.binding)
        {
            textViewIngilizce.text= kelimelerListe.get(position).ingilizce
            textViewTurkce.text= kelimelerListe.get(position).turkce

            kelimeCard.setOnClickListener {
                val intent=Intent(mContext,KelimelerDetayActivity::class.java)
                intent.putExtra("kelime", kelimelerListe.get(position))
                mContext.startActivity(intent)
            }
        }
    }

}