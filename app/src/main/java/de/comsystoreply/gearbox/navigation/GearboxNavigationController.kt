package de.comsystoreply.gearbox.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
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


sealed class ScreenRoutes(val route: String) {

    //* Onboarding screen routes
    data object Onboarding : ScreenRoutes("onboarding")
    data object FirstOnboarding : ScreenRoutes("onboarding-first")
    data object SecondOnboarding : ScreenRoutes("onboarding-second")

    //* Auth screen routes
    data object Login : ScreenRoutes("login")

    //* Home screen routes
    data object Home : ScreenRoutes("home")
    data object Blog : ScreenRoutes("blog")
    data object Garage : ScreenRoutes("garage")
}

fun NavGraphBuilder.onboardingDestination(navController: NavHostController) {
    navigation(
        startDestination = ScreenRoutes.FirstOnboarding.route,
        route = ScreenRoutes.Onboarding.route,
    ) {
        composable(route = ScreenRoutes.FirstOnboarding.route) {
            FirstOnboardingScreen(
                onNextPressed = { navController.navigate(route = ScreenRoutes.SecondOnboarding.route) }
            )
        }
        composable(route = ScreenRoutes.SecondOnboarding.route) {
            SecondOnboardingScreen(
                onNextPressed = { navController.navigate(route = ScreenRoutes.Login.route) }
            )
        }
    }
}


fun NavGraphBuilder.loginDestination(navController: NavHostController) {
    composable(route = ScreenRoutes.Login.route) {
        LoginScreen(
            onButtonPressed = { navController.navigate(ScreenRoutes.FirstOnboarding.route) },
            onLoginPressed = {
                navController.popBackStack(
                    route = ScreenRoutes.Onboarding.route,
                    inclusive = true,
                )
                navController.navigate(ScreenRoutes.Home.route) {
                    popUpTo(route = ScreenRoutes.Home.route)

                }
            }
        )
    }
}

@Composable
fun RootNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenRoutes.Onboarding.route) {
        onboardingDestination(navController)
        loginDestination(navController)
        composable(route = ScreenRoutes.Home.route) {
            HomeScreen(
                logout = {
                    navController.navigate(ScreenRoutes.Login.route) {
                        popUpTo(0) { }
                    }
                }
            )
        }
    }
}


@Composable
fun HomeNavGraph(navController: NavHostController, logout: () -> Unit) {
    NavHost(
        navController = navController,
        route = ScreenRoutes.Home.route,
        startDestination = ScreenRoutes.Blog.route
    ) {
        composable(route = ScreenRoutes.Blog.route) {
            BlogScreen()
        }
        composable(route = ScreenRoutes.Garage.route) {
            ProfileScreen()
        }
    }
}