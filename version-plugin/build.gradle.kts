plugins {
    `kotlin-dsl`
}



java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

gradlePlugin {
    plugins {
        register("application") {
            id = "com.wycrm.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidCompose") {
            id = "com.wycrm.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
        register("androidRoom") {
            id = "com.wycrm.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("androidHilt"){
            id = "com.wycrm.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

    }


}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)
}