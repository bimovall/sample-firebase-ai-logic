package com.example.firebase_ai.data

actual class AIGenerator actual constructor() {

    actual suspend fun generateText(text: String): Result<String> {
        return try {
            Result.success(nativeAIGeneratorProvider?.generateText(text).orEmpty())
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}

private var nativeAIGeneratorProvider: NativeAIGeneratorProvider? = null

fun setNativeAIGeneratorProvider(provider: NativeAIGeneratorProvider) {
    nativeAIGeneratorProvider = provider
}

interface NativeAIGeneratorProvider {
    suspend fun generateText(text: String): String
}