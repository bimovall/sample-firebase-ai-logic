package com.example.firebase_ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val model = Firebase.ai(backend = GenerativeBackend.googleAI())
            .generativeModel("gemini-2.5-flash")
        setContent {
            App()
        }

        // Provide a prompt that contains text
        val prompt = "Write a story about a magic backpack."

        // To generate text output, call generateContent with the text input
        lifecycleScope.launch {
            val response = model.generateContent(prompt)
            print(response.text)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}