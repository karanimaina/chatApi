package com.example

import com.example.model.userStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRoute() {
    get{
        if (userStorage.isNotEmpty()) {
            call.respond(userStorage)
        } else {
            call.respondText("No users found", status = HttpStatusCode.OK)
        }
    }
    get("{id}"){

    }
    post {

    }
    delete("{id?}") {

    }
}