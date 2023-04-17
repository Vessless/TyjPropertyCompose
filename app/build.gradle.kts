
plugins {
    id("com.wycrm.application")
    id("com.wycrm.android.compose")
    id("com.wycrm.android.room")
    id("com.wycrm.android.hilt")
}

android{
    namespace = "com.wycrm.tyjpropertycompose"

    defaultConfig{
        applicationId = "com.wycrm.tyjpropertycompose"
        versionCode = 1
        versionName = "1.0"
    }
}
dependencies{
    //compose
    implementation(libs.accompanist.flowlayout)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.runtime.livedata)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.ui.util)
    implementation(libs.androidx.metrics)
    implementation(libs.androidx.tracing.ktx)
    debugApi(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.lifecycle.livedata.ktx)


    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
    //图片加载框架
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.coil.kt.svg)

    //网络
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
}


