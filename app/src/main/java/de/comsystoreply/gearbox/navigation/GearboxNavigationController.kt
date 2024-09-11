package de.comsystoreply.gearbox.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import de.comsystoreply.gearbox.features.login.presentation.LoginScreen
import de.comsystoreply.gearbox.features.onboarding.presentation.FirstOnboardingScreen
import de.comsystoreply.gearbox.features.onboarding.presentation.SecondOnboardingScreen
import kotlinx.serialization.Serializable


@Serializable
object Onboarding

@Serializable
object FirstOnboarding

@Serializable
object SecondOnboarding

fun NavGraphBuilder.onboardingDestination(navController: NavHostController) {
    navigation<Onboarding>(startDestination = FirstOnboarding) {
        composable<FirstOnboarding> {
            FirstOnboardingScreen(
                onNextPressed = { navController.navigate(route = SecondOnboarding) }
            )
        }
        composable<SecondOnboarding> {
            SecondOnboardingScreen(
                onNextPressed = { navController.navigate(route = Login) }
            )
        }
    }
}


@Serializable
object Login

fun NavGraphBuilder.loginDestination(navController: NavHostController) {
    composable<Login> {
        LoginScreen(
            onButtonPressed = { navController.navigate(FirstOnboarding) }
        )
    }
}


@Composable
fun RootNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Onboarding) {
        loginDestination(navController)
        onboardingDestination(navController)
    }
}