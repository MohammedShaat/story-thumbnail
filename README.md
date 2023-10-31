# Story Thumbnail
**Story Thumbnail** is a library designed to assist Android developers in generating a thumbnail for a story. This thumbnail displays an image with stroke/dashes corresponding to the number of stories.

<img src="https://github.com/MohammedShaat/pendulum/assets/62177897/0525e0a6-b1fb-4047-8b34-6f7c7351297c" width="200">

---

## How To Install
<img src="https://img.shields.io/badge/jitpack-1.0.0-green">


### Step 1
Add the JitPack repository to your project-level build.gradle / settings.gradle  file
```gradle
dependencyResolutionManagement {
    repositories {
        ...
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

### Step 2
Add the dependency to your app-level build.gradle file
```gradle
dependencies {
    ...
    implementation 'com.github.MohammedShaat:story-thumbnail:1.0.0'
}
```

## How To Use
Just import `StoryThumbnail` composable function and set it up.

**Example**
```kotlin
StoryThumbnail(
    count = 5,
    seen = 3,
    content = {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
        )
    },
    modifier = Modifier.size(150.dp),
    onClick = { },
    seenColor = Color.Green,
    unSeenColor = Color.Gray,
    width = 3.dp,
    spacing = 2.dp,
)

```

### Description
|Argument|Description|
|-|-|
|count|Total number of stories|
|seen|Number of seen stories|
|content|Content to display, usually an image|
|onClick|Will be called when user clicks on the element|
|seenColor|Dash color of seen stories|
|unSeenColor|Dash color of unseen stories|
|width|Width of dashes|
|spacing|Space between dashes|