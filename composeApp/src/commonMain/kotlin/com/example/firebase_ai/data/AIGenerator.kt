package com.example.firebase_ai.data

expect class AIGenerator() {
    suspend fun generateText(text: String): Result<String>
}