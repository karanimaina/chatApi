package com.example.model

data class User(val id:String,val firstName:String, val lastName:String, val profession:String,val age:String,val maritalStatus:String,val hobby:String, val email:String)

val userStorage  = mutableListOf<User>()
