package com.musasoydas.sozlukapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.musasoydas.sozlukapp.databinding.ActivityKelimlerDetayBinding

class KelimelerDetayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKelimlerDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityKelimlerDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kelime=intent.getSerializableExtra("kelime") as Kelimeler


        with(binding)
        {
            textViewIngilizce.text=kelime.ingilizce
            textViewTurkce.text=kelime.turkce
        }



    }
}