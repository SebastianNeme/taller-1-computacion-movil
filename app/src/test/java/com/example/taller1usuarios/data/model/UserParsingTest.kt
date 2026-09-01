package com.example.taller1usuarios.data.model

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class UserParsingTest {
    private val jsonFormat = Json { ignoreUnknownKeys = true }

    @Test
    fun responseIsParsedWhileUnknownFieldsAreIgnored() {
        val json = """
            {
              "users": [{
                "id": 1,
                "firstName": "Emily",
                "lastName": "Johnson",
                "image": "https://example.com/emily.png",
                "phone": "+1 555 0100",
                "email": "emily@example.com",
                "age": 28,
                "gender": "female",
                "height": 168.5,
                "weight": 61.2,
                "university": "Example University",
                "company": { "name": "Example Inc", "department": "Engineering" },
                "unknownField": true
              }],
              "total": 1,
              "skip": 0,
              "limit": 120
            }
        """.trimIndent()

        val response = jsonFormat.decodeFromString<UsersResponse>(json)

        assertEquals("Emily Johnson", response.users.single().fullName)
        assertEquals("Example Inc", response.users.single().company.name)
        assertEquals(120, response.limit)
    }
}
