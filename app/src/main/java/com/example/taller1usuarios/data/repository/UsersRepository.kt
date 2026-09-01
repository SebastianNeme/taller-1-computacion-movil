package com.example.taller1usuarios.data.repository

import com.example.taller1usuarios.data.model.User
import com.example.taller1usuarios.data.remote.UsersApi
import com.example.taller1usuarios.data.remote.UsersDataSource
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * Guarda en memoria el resultado de la consulta. De esta forma, abrir el detalle o volver
 * a la lista nunca produce una segunda petición a DummyJSON.
 */
class UsersRepository internal constructor(
    private val dataSource: UsersDataSource,
) {
    private val mutex = Mutex()
    private var cachedResult: Result<List<User>>? = null

    suspend fun getUsers(): Result<List<User>> = mutex.withLock {
        cachedResult ?: runCatching { dataSource.fetchUsers() }
            .also { cachedResult = it }
    }

    companion object {
        val Default: UsersRepository by lazy { UsersRepository(UsersApi) }
    }
}
