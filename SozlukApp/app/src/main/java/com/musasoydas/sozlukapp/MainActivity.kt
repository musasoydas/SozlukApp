package com.musasoydas.sozlukapp

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.musasoydas.sozlukapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var adapter: KelimelerAdapter
    private lateinit var kelimerListesi: ArrayList<Kelimeler>
    private lateinit var binding: ActivityMainBinding
    private lateinit var kelimlerDao: KelimerDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        kelimlerDao = ApiUtils.getKelimeler()
        binding.toolbar.setTitle("Sözlük Uygulaması")
        setSupportActionBar(binding.toolbar)

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)

        tumKelimler()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list, menu)
        val item = menu?.findItem(R.id.menu_ara)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        aramaYap(query)
        // kelimeyi yazıp araya basıca çalışır
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        //her etkileşimde çalışır harf bas harf sil
        aramaYap(newText)
        return true
    }

    fun tumKelimler() {

        kelimlerDao.tumKelimeler().enqueue(object : Callback<Kelime> {
            override fun onResponse(call: Call<Kelime>?, response: Response<Kelime>) {
                //kelimler başarı şekilde gelirse ne olsun

                var gelenKelime = response.body()?.kelimeler
                gelenKelime.let {
                    adapter = KelimelerAdapter(this@MainActivity, gelenKelime!!)
                    binding.rv.adapter = adapter
                }


            }

            override fun onFailure(call: Call<Kelime>?, t: Throwable?) {
                //kelimler gelirken hata olursa ne olsun

            }

        })
    }

    fun aramaYap(arananKelime: String) {

        kelimlerDao.kelimeAra(arananKelime).enqueue(object : Callback<Kelime> {
            override fun onResponse(call: Call<Kelime>?, response: Response<Kelime>?) {
                //kelimler başarı şekilde gelirse ne olsun

                var gelenKelime = response?.body()?.kelimeler
                if(gelenKelime!=null)
                {
                    adapter = KelimelerAdapter(this@MainActivity, gelenKelime)
                    binding.rv.adapter = adapter
                }else{
                    Log.e("eror","kelime null")
                }
            }

            override fun onFailure(call: Call<Kelime>?, t: Throwable?) {
                //kelimler gelirken hata olursa ne olsun
            }

        })


    }
}
