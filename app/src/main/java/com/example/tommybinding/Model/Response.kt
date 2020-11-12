package com.example.tommybinding.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Response(
	val lastName: String,
	val id: Int,
	val avatar: String,
	val firstName: String,
	val email: String
): Parcelable {
	val baseUrl get() = "https://reqres.in/api/"
}
