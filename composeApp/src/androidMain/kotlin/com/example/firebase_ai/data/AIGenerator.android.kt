package com.example.firebase_ai.data

import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend

actual class AIGenerator actual constructor() {
    actual suspend fun generateText(text: String): Result<String> {
        val model = Firebase.ai(backend = GenerativeBackend.googleAI())
            .generativeModel("gemini-2.5-flash")
        return try {
            val response = model.generateContent(
                text
            )
            Result.success(response.text.orEmpty())
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}