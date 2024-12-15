package de.comsystoreply.gearbox.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Destination

@Serializable
data object OnboardingGraph : Destination

@Serializable
data object FirstOnboardingScreen : Destination

@Serializable
data object SecondOnboardingScreen : Destination

@Serializable
data object LoginScreen : Destination

@Serializable
data object HomeGraph : Destination

@Serializable
data object BlogScreen : Destination

@Serializable
data object GarageScreen : Destination