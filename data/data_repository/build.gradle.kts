
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.example.data_repository"
    compileSdk = 34

    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
}
kapt {
    correctErrorTypes = true
}
dependencies {

    implementation(project(":toplevel:resources"))
    implementation(project(":data:preferences"))
    implementation(project(":data:paging"))
    api(project(":domain:domain_repository"))
    api(project(":api_interaction_helper:retrofit"))
    testImplementation(project(":test"))
    testImplementation(project(":data:remote"))
    //Unit test
    testImplementation(kotlin("test"))
    testImplementation(libs.bundles.test)
    testRuntimeOnly(libs.junit.jupiter.engine)

    libs.bundles.apply {
        implementation(hilt)
        implementation(coroutines)
        implementation(arrow)
    }
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.paging)

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}