import com.android.build.api.dsl.ApplicationExtension
import com.wycrm.plugin.configureKotlinAndroid
import org.gradle.api.Incubating
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getting

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<ApplicationExtension> {

                configureKotlinAndroid(this)
                with(defaultConfig) {
                    targetSdk = 34
                    vectorDrawables{
                        useSupportLibrary = true
                    }
                    ndk {
                        abiFilters += listOf("armeabi", "x86", "armeabi-v7a", "x86_64", "arm64-v8a")
                    }

                }

                buildTypes {
                    release {
                        isMinifyEnabled = true
                    }
                }
            }

        }
    }
}