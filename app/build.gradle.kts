plugins { id("com.android.application") }
android {
    namespace = "com.example.autopilot"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.autopilot"
        minSdk = 26
        targetSdk = 34
        versionCode = 4
        versionName = "4.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
