package com.example.tommybinding


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


public class ApiClient {
    public var BASE_URL: String = "https://reqres.in/api/"
    public var retrofit: Retrofit? = null

    public fun getApiClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }
}