# test-variant-filter-4.0-sample
 
This small sample shows how to use the new variant API
to filter out test components of a variant that is not filtered out.

File [buildSrc/src/main/java/com/example/build/CustomPlugin.kt](buildSrc/src/main/java/com/example/build/CustomPlugin.kt) shows
how to disable the android test and/or the unit test component of a variant

How to verify:
- running `./gradlew app:testDebugUnitTest app:testReleaseUnitTest` will fail
- running `./gradle lib:assembleDebugAndroidTest` will fail

Note that connectedCheck, assembleAndroidTest are still present but they do nothing.
