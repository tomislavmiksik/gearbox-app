package de.comsystoreply.gearbox.features.home.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import de.comsystoreply.gearbox.R
import de.comsystoreply.gearbox.features.home.ui.viewmodel.HomeViewModel
import de.comsystoreply.gearbox.navigation.BlogScreen
import de.comsystoreply.gearbox.navigation.HomeNavigation
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    logout: () -> Unit,
    viewModel: HomeViewModel = koinViewModel<HomeViewModel>()
) {
    val navController = rememberNavController()

    val bottomNavItems = listOf(
        BottomNavItems(
            title = stringResource(R.string.nav_blogs),
            icon = Icons.Outlined.Newspaper,
            onClick = {
                navController.navigate(BlogScreen) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                    restoreState = true
                }
            }
        ),
        BottomNavItems(
            title = stringResource(R.string.nav_garage),
            icon = Icons.Outlined.Settings,
            onClick = {
                navController.navigate(de.comsystoreply.gearbox.navigation.GarageScreen) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                    restoreState = true
                }
            }
        ),
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = bottomNavItems,
                currentDestination = navController.currentBackStackEntryAsState().value?.destination
            )
        }
    ) { paddingValues ->
        HomeNavigation(
            navController = navController, 
            logout = logout,
            contentPadding = paddingValues
        )
    }
}


@Composable
fun BottomNavigationBar(
    items: List<BottomNavItems>,
    currentDestination: NavDestination?
) {
    NavigationBar {
        items.forEach { item ->
            val selected = currentDestination?.route?.contains(item.destinationName) == true
            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) {
                        item.onClick()
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                }
            )
        }
    }
}

data class BottomNavItems(
    val title: String,
    val icon: ImageVector,
    val onClick: () -> Unit,
    val destinationName: String = title.lowercase()
)