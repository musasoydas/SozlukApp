package com.musasoydas.sozlukapp

class ApiUtils {
    //static olarak yapmak için yani sınıftan hemen ulaşabilmek için
    companion object{
        val BASE_URL="http://kasimadalan.pe.hu/"

        fun getKelimeler():KelimerDAO{
            return RetrofitClient.getClient(BASE_URL).create(KelimerDAO::class.java)
        }
    }
}