package de.comsystoreply.gearbox.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

class NavigationActions(private val navController: NavController) {
    
    fun navigateToOnboarding() {
        navController.navigate(OnboardingGraph) {
            popUpTo(0) { inclusive = true }
            launchSingleTop = true
        }
    }
    
    fun navigateToLogin() {
        navController.navigate(LoginScreen) {
            launchSingleTop = true
        }
    }
    
    fun navigateToFirstOnboarding() {
        navController.navigate(FirstOnboardingScreen) {
            launchSingleTop = true
        }
    }
    
    fun navigateToSecondOnboarding() {
        navController.navigate(SecondOnboardingScreen) {
            launchSingleTop = true
        }
    }
    
    fun navigateToHome() {
        navController.navigate(HomeGraph) {
            popUpTo(OnboardingGraph) { inclusive = true }
            launchSingleTop = true
        }
    }
    
    fun navigateToBlogs() {
        navController.navigate(BlogScreen) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    
    fun navigateToGarage() {
        navController.navigate(GarageScreen) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    
    fun navigateBack() {
        navController.popBackStack()
    }
}