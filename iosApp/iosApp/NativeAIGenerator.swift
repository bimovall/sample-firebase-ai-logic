//
//  NativeAIGenerator.swift
//  iosApp
//
//  Created by Bimo Vallentino Achmad on 11/01/26.
//

import ComposeApp
import FirebaseAILogic

class NativeAIGenerator: NativeAIGeneratorProvider {
    
    
    func generateText(text: String) async throws -> String {
        // Initialize the Gemini Developer API backend service
        let ai = FirebaseAI.firebaseAI(backend: .googleAI())

        // Create a `GenerativeModel` instance with a model that supports your use case
        let model = ai.generativeModel(modelName: "gemini-2.5-flash")
        // To generate text output, call generateContent with the text input
        let response = try await model.generateContent(text)
        print(response.text ?? "No text in response.")
        
        return response.text ?? ""
    }
}
