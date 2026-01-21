package com.example.firebase_ai

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform