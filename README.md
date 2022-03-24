# CryptoSample
A sample app showing cyptocurrency list from SQLite database. Dataset is prepared in `prepopulate.db` file.

## Architecture
The architecture of the application is based, apply and strictly complies with each of the following points:
-   A single-activity architecture, using the [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started) to manage fragment operations.
-   [Clean architecture](http://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) allows app to scale with maintainable codebase. It proves very useful when working on apps with longer development lifecycle and a bigger team.
-   [Modular app architecture](https://proandroiddev.com/build-a-modular-android-app-architecture-25342d99de82) allows to be developed features in isolation, independently from other features.
-   [Model-View-ViewModel](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel) (MVVM) pattern facilites a [separation](https://en.wikipedia.org/wiki/Separation_of_concerns) of development of the graphical user interface.

## Modules

Modules are collection of source files and build settings that allow you to divide a project into discrete units of functionality. In this case apart from dividing by functionality/responsibility, existing the following dependence between them.

### App module
`:app` module is an [com.android.application](https://developer.android.com/studio/build/), which is needed to create the app bundle.  It is also responsible for initiating the dependency graph, [play core](https://developer.android.com/reference/com/google/android/play/core/release-notes) and another project global libraries, differentiating especially between different app environments.

### Data module
`:data` module is an [com.android.library](https://developer.android.com/studio/projects/android-library)  for serving network requests or accessing to the database. Providing the data source for the many features that require it.

### Domain module
`:domain` module is an [com.android.library](https://developer.android.com/studio/projects/android-library) for bridging between presentation and data layer so that the consumer app does not know any concrete implementations. It is the most effective if we can share this module across platforms.

### Feature modules
`:feature` modules are [com.android.dynamic-feature](https://developer.android.com/studio/projects/dynamic-delivery). It is essentially a gradle module which can be downloaded independently from the base application module. It can hold code and resources and include dependencies, just like any other gradle module.

## Dependency Management
-   External dependencies (libraries) are defined using [versions catalog](https://docs.gradle.org/7.2/userguide/platforms.html) with [the libs.versions.toml file](https://docs.gradle.org/7.2/userguide/platforms.html#sub:conventional-dependencies-toml).
-   Each `:feature` module depends on the `app:` module, so dependencies are shared without need to add them explicitly in each feature module.

## Tech-stack
### Programming language
- [Kotlin](https://kotlinlang.org) 100%
### Dependencies
-   [Jetpack](https://developer.android.com/jetpack):
    -   [Android KTX](https://developer.android.com/kotlin/ktx.html) - provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
    -   [AndroidX](https://developer.android.com/jetpack/androidx) - major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    -   [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    -   [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
    -   [Navigation](https://developer.android.com/guide/navigation/) - helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer.
    -   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
    -   [Room](https://developer.android.com/jetpack/androidx/releases/room) - a persistance library that provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
-   [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - managing background threads with simplified code and reducing needs for callbacks.
-   [Koin](https://github.com/InsertKoinIO/koin) - dependency injector for replacement all FactoryFactory classes.
