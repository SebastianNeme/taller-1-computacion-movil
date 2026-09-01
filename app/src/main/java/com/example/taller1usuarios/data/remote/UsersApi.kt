package com.example.taller1usuarios.data.remote

import com.example.taller1usuarios.data.model.User
import com.example.taller1usuarios.data.model.UsersResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal interface UsersDataSource {
    suspend fun fetchUsers(): List<User>
}

internal object UsersApi : UsersDataSource {
    private const val USERS_URL = "https://dummyjson.com/user?limit=120"

    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                },
            )
        }
    }

    override suspend fun fetchUsers(): List<User> {
        val response = client.get(USERS_URL)
        check(response.status.isSuccess()) {
            "La API respondió con el código ${response.status.value}."
        }
        return response.body<UsersResponse>().users
    }
}
