# TestArtBookKotlin

## Overview
### Architecture
This project follows MVVM

### API Calls
Using the following APIs:
- https://pixabay.com/api/?key=API_KEY&q={$term}


## Technology
### Presentation
- [View Binding](https://developer.android.com/topic/libraries/view-binding) - generates binding classes which hold reference to XML id'd elements
- [Recycler View](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView) - Displays lists of elements
- [Swipe Refresh Layout](https://developer.android.com/training/swipe/add-swipe-interface) - Library that supports swipe to refresh on lists
- [Diff Util](https://developer.android.com/reference/androidx/recyclerview/widget/DiffUtil) - Utility class that effeciently calculates differences between two lists
- [Search View](https://developer.android.com/training/search/setup) - Adds search interface in app bar
- [Hilt](https://dagger.dev/hilt/) - Dependency Injection library based on dagger
- [Jetpack Navigation](https://developer.android.com/guide/navigation/navigation-getting-started) - Navigation library
- [SafeArgs](https://developer.android.com/guide/navigation/navigation-getting-started#ensure_type-safety_by_using_safe_args) - Type safe navigation

### Persistence
- [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite abstraction library

### Networking
- [Retrofit](https://square.github.io/retrofit/) - Rest Client

### Testing
- [Junit](https://junit.org/junit4/) - unit testing library
- [kotlinx-coroutines-test](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-test/) - used for `runBlockingTest`
- [Espresso](https://developer.android.com/training/testing/espresso) - integration testing library
- [Espresso with Hilt](https://developer.android.com/training/dependency-injection/hilt-testing) - espresso with hilt support
