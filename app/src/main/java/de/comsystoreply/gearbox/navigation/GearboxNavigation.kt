package de.comsystoreply.gearbox.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import de.comsystoreply.gearbox.features.blogs.presentation.BlogScreen
import de.comsystoreply.gearbox.features.home.presentation.HomeScreen
import de.comsystoreply.gearbox.features.login.presentation.LoginScreen
import de.comsystoreply.gearbox.features.onboarding.presentation.FirstOnboardingScreen
import de.comsystoreply.gearbox.features.onboarding.presentation.SecondOnboardingScreen
import de.comsystoreply.gearbox.features.profile.presentation.ProfileScreen

@Composable
fun GearboxNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = OnboardingGraph,
        enterTransition = { fadeIn(animationSpec = tween(200)) },
        exitTransition = { fadeOut(animationSpec = tween(200)) }
    ) {
        navigation<OnboardingGraph>(
            startDestination = FirstOnboardingScreen
        ) {
            composable<FirstOnboardingScreen> {
                FirstOnboardingScreen(
                    onNextPressed = {
                        navController.navigate(SecondOnboardingScreen)
                    },
                    routeName = "FirstOnboarding"
                )
            }
            composable<SecondOnboardingScreen> {
                SecondOnboardingScreen(
                    onNextPressed = {
                        navController.navigate(LoginScreen)
                    },
                    routeName = "SecondOnboarding"
                )
            }
        }
        
        composable<LoginScreen> {
            LoginScreen(
                onButtonPressed = {
                    navController.navigate(FirstOnboardingScreen)
                },
                onLoginPressed = {
                    navController.navigate(HomeGraph) {
                        popUpTo(OnboardingGraph) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
        
        composable<HomeGraph> {
            HomeScreen(
                logout = {
                    navController.navigate(LoginScreen) {
                        popUpTo(HomeGraph) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Composable
fun HomeNavigation(
    navController: NavHostController = rememberNavController(),
    logout: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = BlogScreen,
        enterTransition = { fadeIn(animationSpec = tween(150)) },
        exitTransition = { fadeOut(animationSpec = tween(150)) }
    ) {
        composable<BlogScreen> {
            BlogScreen()
        }
        composable<GarageScreen> {
            ProfileScreen()
        }
    }
}