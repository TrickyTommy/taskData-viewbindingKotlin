package com.example.tommybinding

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST


public interface ApiInterface {

    @GET("users")
    fun getDatas(): Call<ArrayList<Datas>>
}
