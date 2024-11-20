# Gearbox

An Android automotive companion app built with Jetpack Compose and modern Android development practices.

## Features

- **Onboarding Experience**: Smooth introduction flow for new users
- **Blog Section**: Stay updated with automotive content and news
- **Garage Management**: Personal space for automotive enthusiasts
- **Multi-language Support**: Available in English, German, and Spanish
- **Modern UI**: Edge-to-edge design with Material 3 components

## Tech Stack

- **UI**: Jetpack Compose with Material 3
- **Architecture**: Clean Architecture with MVVM pattern
- **Dependency Injection**: Koin
- **Navigation**: Type-safe navigation with Kotlin Serialization
- **Build**: Gradle with Kotlin DSL

## Getting Started

1. Clone the repository
2. Open in Android Studio
3. Sync project with Gradle files
4. Run the app on an emulator or device

## Requirements

- Android Studio Hedgehog or newer
- Android SDK 34
- Minimum SDK 24

## Project Structure

```
app/
├── src/main/java/de/comsystoreply/gearbox/
│   ├── features/          # Feature modules
│   │   ├── onboarding/    # User onboarding flow
│   │   ├── login/         # Authentication
│   │   ├── home/          # Main dashboard
│   │   ├── blogs/         # Blog content
│   │   └── profile/       # User profile & garage
│   ├── navigation/        # App navigation setup
│   ├── di/               # Dependency injection modules
│   └── ui/               # Theme and common UI components
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request