package com.example.tommybinding.Model

import com.google.gson.annotations.SerializedName

class Data(
    @SerializedName("data")
    val users: List<User>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("page")
    val page: Int
)
