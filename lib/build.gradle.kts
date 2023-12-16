plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
    id("kotlin-kapt")
    id("org.greenrobot.greendao")
}

android {
    namespace = "dora.cache.greendao"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    greendao {
        schemaVersion = 1
        daoPackage = "dora.cache.greendao"
        targetGenDir = File("src/main/java")
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("com.github.dora4:dcache-android:1.8.5")
    val greendao_version = "3.3.0"
    api("org.greenrobot:greendao:$greendao_version")
    api("org.greenrobot:greendao-generator:$greendao_version")
}

afterEvaluate {
    publishing {
        publications {
            register("release", MavenPublication::class) {
                from(components["release"])
                groupId = "com.github.dora4"
                artifactId = "dcache-greendao-support"
                version = "1.2"
            }
        }
    }
}