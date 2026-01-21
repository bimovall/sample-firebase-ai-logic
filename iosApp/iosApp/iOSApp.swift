import SwiftUI
import FirebaseCore
import ComposeApp

@main
struct iOSApp: App {
    
    init() {
        FirebaseApp.configure()
        AIGenerator_iosKt.setNativeAIGeneratorProvider(provider: NativeAIGenerator())
    }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
