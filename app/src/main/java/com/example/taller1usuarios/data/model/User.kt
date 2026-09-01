package com.example.taller1usuarios.data.model

import kotlinx.serialization.Serializable

/** Información que la aplicación necesita de cada usuario de DummyJSON. */
@Serializable
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val image: String,
    val phone: String,
    val email: String,
    val age: Int,
    val gender: String,
    val height: Double,
    val weight: Double,
    val university: String,
    val company: Company,
) {
    val fullName: String
        get() = "$firstName $lastName"
}

@Serializable
data class Company(
    val name: String,
)

@Serializable
data class UsersResponse(
    val users: List<User>,
    val total: Int,
    val skip: Int,
    val limit: Int,
)
