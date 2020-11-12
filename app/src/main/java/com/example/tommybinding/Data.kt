package com.example.tommybinding

import com.google.gson.annotations.SerializedName


data class Datas (
//    public var id: String? = null
//    @SerializedName("hospital_name")
//    public var hospitalName: String? = null
//    public var address: String? = null

    @field:SerializedName("last_name")
    val lastName: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("avatar")
    val avatar: String,

    @field:SerializedName("first_name")
    val firstName: String,

    @field:SerializedName("email")
    val email: String
)