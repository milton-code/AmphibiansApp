
# AmphibiansApp

Android app that displays a list of amphibians retrieved from a RESTful web service using the Retrofit library, the images were loaded into the UI using the Coil library.


## Key Features

- The app uses the Retrofit library to retrieve a JSON list of amphibians from a RESTful web service, in which each amphibian has its own image URL.
- The app uses the Coil library to load and display the images into the UI using the URLs.
- The app handles exceptions like running it with no internet connection, showing an error message instead of crashing.

## Tech Stack

**Client:** Kotlin, Jetpack Compose, Retrofit, Coil

**Server:** REST API

**Pattern Design:** Model - View - ViewModel



## Screenshots

![App Screenshot](https://github.com/milton-code/AmphibiansApp/blob/8f96518e22b7d28c69e9418bd12597b4311f9da2/amphibianlist_success.jpeg)
![App Screenshot](https://github.com/milton-code/AmphibiansApp/blob/8f96518e22b7d28c69e9418bd12597b4311f9da2/amphibianlist_error.jpeg)

