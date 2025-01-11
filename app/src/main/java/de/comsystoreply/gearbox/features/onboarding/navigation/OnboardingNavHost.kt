package de.comsystoreply.gearbox.features.onboarding.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.comsystoreply.gearbox.features.onboarding.ui.screen.FirstOnboardingScreen
import de.comsystoreply.gearbox.features.onboarding.ui.screen.SecondOnboardingScreen
import de.comsystoreply.gearbox.features.onboarding.ui.screen.ThirdOnboardingScreen
import de.comsystoreply.gearbox.navigation.FirstOnboardingScreen
import de.comsystoreply.gearbox.navigation.SecondOnboardingScreen
import de.comsystoreply.gearbox.navigation.ThirdOnboardingScreen

@Composable
fun OnboardingNavHost(
    navController: NavHostController = rememberNavController(),
    onOnboardingComplete: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = FirstOnboardingScreen,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        }
    ) {
        composable<FirstOnboardingScreen> {
            FirstOnboardingScreen(
                onNextPressed = {
                    navController.navigate(SecondOnboardingScreen) {
                        launchSingleTop = true
                    }
                }
            )
        }
        
        composable<SecondOnboardingScreen> {
            SecondOnboardingScreen(
                onNextPressed = {
                    navController.navigate(ThirdOnboardingScreen) {
                        launchSingleTop = true
                    }
                }
            )
        }
        
        composable<ThirdOnboardingScreen> {
            ThirdOnboardingScreen(
                onGetStartedPressed = {
                    onOnboardingComplete()
                }
            )
        }
    }
}