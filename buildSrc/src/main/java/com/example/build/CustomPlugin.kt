package com.example.build

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.withType(AppPlugin::class.java) {
            val extension = project.extensions.getByName("android") as BaseAppModuleExtension

            // new Variant API. Everything in there is incubating
            extension.onVariants {
                // disable all unit tests for apps (only using instrumentation tests
                unitTest {
                    enabled = false
                }
            }
        }

        project.plugins.withType(LibraryPlugin::class.java) {
            val extension = project.extensions.getByName("android") as LibraryExtension

            // new Variant API. Everything in there is incubating
            extension.onVariants.withBuildType("debug") {
                // Disable instrumentatation for debug
                androidTest {
                    enabled = false
                }

            }

            extension.onVariants.withBuildType("release") {
                // Disable unit test for release
                unitTest {
                    enabled = false
                }

            }

        }
    }
}
