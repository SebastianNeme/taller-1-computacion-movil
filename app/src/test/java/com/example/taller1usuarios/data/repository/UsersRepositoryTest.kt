package com.example.taller1usuarios.data.repository

import com.example.taller1usuarios.data.model.Company
import com.example.taller1usuarios.data.model.User
import com.example.taller1usuarios.data.remote.UsersDataSource
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class UsersRepositoryTest {
    @Test
    fun concurrentRequestsUseTheDataSourceOnlyOnce() = runTest {
        val source = CountingDataSource(listOf(sampleUser()))
        val repository = UsersRepository(source)

        val results = List(5) { async { repository.getUsers() } }.awaitAll()

        assertEquals(1, source.calls)
        assertTrue(results.all { it.getOrThrow().single().id == 1 })
    }

    @Test
    fun aFailureIsAlsoCachedToRespectTheSingleRequestRule() = runTest {
        val source = CountingDataSource(error = IllegalStateException("Sin conexión"))
        val repository = UsersRepository(source)

        val first = repository.getUsers()
        val second = repository.getUsers()

        assertEquals(1, source.calls)
        assertTrue(first.isFailure)
        assertTrue(second.isFailure)
    }

    private class CountingDataSource(
        private val users: List<User> = emptyList(),
        private val error: Throwable? = null,
    ) : UsersDataSource {
        var calls: Int = 0
            private set

        override suspend fun fetchUsers(): List<User> {
            calls += 1
            error?.let { throw it }
            return users
        }
    }

    private fun sampleUser() = User(
        id = 1,
        firstName = "Emily",
        lastName = "Johnson",
        image = "https://example.com/emily.png",
        phone = "+1 555 0100",
        email = "emily@example.com",
        age = 28,
        gender = "female",
        height = 168.5,
        weight = 61.2,
        university = "Example University",
        company = Company(name = "Example Inc"),
    )
}
