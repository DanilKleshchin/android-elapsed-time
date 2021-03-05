# android-elapsed-time [![](https://jitpack.io/v/DanilKleshchin/android-elapsed-time.svg)](https://jitpack.io/#DanilKleshchin/android-elapsed-time)

A tiny library for displaying the elapsed time at a given time stamp for Android OS.

## Example

![Alt text](/screenshot/screenshot.png?raw=true)

## Add dependencies
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
 Add the dependency:
```gradle
dependencies {
    implementation 'com.github.DanilKleshchin:android-elapsed-time:{version}'
}
```

## Usage
```kotlin
val resources = context.resources // All strings are stored in the Android plurals res directory.
val dateTime = "22/12/2021 22:13:08"
val timestamp = getTimestampFromDateTime( // pattern_2 and getTimestampFromDateTime() are included in the lib
            dateTime = dateTime,
            dateTimePattern = pattern_2,
            timeZone = TimeZone.getTimeZone("GMT+4"), //The timezone param is optional
            locale = Locale("de") //The locale param is optional
    )
val currentTime = System.currentTimeMillis() // You can use your own timestamp

val elapsedTime = getElapsedTimeString(timestamp, currentTime, resources) // "1 day ago"
```

The _getElapsedTimeString()_ method returns a string of elapsed time based on the device locale.

## Supported languages
* English
* German
* Russian
