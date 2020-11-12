package com.example.tommybinding


import com.example.tommybinding.Model.UsersApi
import com.example.tommybinding.UsersService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private val BASE_URL = "https://reqres.in/api/"

    @Provides
    fun provideUsersApi(): UsersApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(UsersApi::class.java)
    }

    @Provides
    fun provideUsersService(): UsersService {
        return UsersService()
    }
}