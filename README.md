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
- **Architecture**: Clean Architecture with MVI pattern
- **State Management**: StateFlow with reactive UI updates
- **Dependency Injection**: Koin (factory pattern for ViewModels)
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
│   ├── features/                    # Feature modules
│   │   ├── onboarding/
│   │   │   ├── ui/screen/          # Onboarding screens
│   │   │   └── navigation/         # Onboarding navigation
│   │   ├── login/
│   │   │   └── ui/
│   │   │       ├── screen/         # Login screen
│   │   │       └── viewmodel/      # Login ViewModel & state
│   │   ├── home/
│   │   │   └── ui/
│   │   │       ├── screen/         # Home screen
│   │   │       └── viewmodel/      # Home ViewModel & state
│   │   ├── blogs/
│   │   │   └── ui/screen/          # Blog screens
│   │   └── profile/
│   │       └── ui/screen/          # Profile screens
│   ├── navigation/                  # App navigation setup
│   ├── di/                         # Koin dependency injection
│   ├── domain/                     # Business logic & models
│   └── ui/                         # Theme & shared components
│       ├── components/             # Reusable UI components
│       │   ├── buttons/           # Button components
│       │   ├── inputs/            # Input components
│       │   ├── text/              # Text components
│       │   └── indicators/        # Indicator components
│       └── theme/                 # Material 3 theming
```

## Architecture Highlights

- **Feature-based organization**: Each feature has its own `ui/screen` and `ui/viewmodel` structure
- **MVI Pattern**: ViewModels use StateFlow with sealed interface intents for reactive state management
- **Shared UI Components**: Reusable Material 3 components following design system principles
- **Type-safe Navigation**: Kotlin Serialization destinations with smooth animations
- **Edge-to-edge Design**: Proper safe area handling with modern Android UI patterns

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request