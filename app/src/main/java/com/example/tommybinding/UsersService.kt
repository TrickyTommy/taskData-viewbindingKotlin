package com.example.tommybinding


import androidx.work.Data
import com.example.tommybinding.DaggerApiComponent
import com.example.tommybinding.Model.*

import io.reactivex.Single
import javax.inject.Inject

class UsersService {

    @Inject
    lateinit var api: UsersApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getUsers(): Single<Data> {
        return api.getUsers()
    }
}