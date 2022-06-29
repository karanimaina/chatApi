package com.example

import com.example.model.User
import com.example.model.userStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRoute() {
    route("/user"){
    get{
        if (userStorage.isNotEmpty()) {
            call.respond(userStorage)
        } else {
            call.respondText("No users found", status = HttpStatusCode.OK)
        }
    }
    get("{id?}"){
        val id  = call.parameters["id"]?:return@get call.respondText ("missing id ", status = HttpStatusCode.BadRequest )
        val user = userStorage.find { it.id== id }  ?: return@get call.respondText("No users with the given Id", status = HttpStatusCode.NotFound)
        call.respond(user)

    }

    post {
    val user  = call.receive<User>()
        userStorage.add(user)
        call.respondText("User stored successfully", status = HttpStatusCode.Created)
    }
    delete("{id?}") {
     val id = call.parameters["id"]?:return@delete call.respond(HttpStatusCode.BadRequest)
        if (userStorage.removeIf{it.id==id }){
            call.respondText  ("user removed successfully",status= HttpStatusCode.Accepted)
        }else {
            call.respondText  ("user Not found" , status = HttpStatusCode.NotFound)
        }
}
}}