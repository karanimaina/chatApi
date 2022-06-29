package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class User(val id:String,val first:String, val last:String, val profession:String,val age:String,val marital:String,val hobby:String, val email:String)

val userStorage  = mutableListOf<User>()
