package de.comsystoreply.gearbox.features.home.presentation

//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import de.comsystoreply.gearbox.navigation.HomeNavGraph
import de.comsystoreply.gearbox.navigation.ScreenRoutes
import de.comsystoreply.gearbox.ui.theme.DarkBlue
import de.comsystoreply.gearbox.ui.theme.LightGray

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(logout: () -> Unit) {
    val navController = rememberNavController()

    val bottomNavItems = mutableListOf(
        BottomNavItems.BlogItem,
        BottomNavItems.ProfileItem,
    )
    Scaffold(
        bottomBar = { BottomNavigationBar(bottomNavItems, navController) }
    ) { _ ->
        HomeNavGraph(navController = navController, logout)
    }

}


@Composable
fun BottomNavigationBar(
    items: List<BottomNavItems>,
    navController: NavController,
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { item ->
            val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        modifier = Modifier,
                        contentDescription = item.title,
                        tint = if (selected) DarkBlue else LightGray
                    )
                }
            )
        }
    }
}

sealed class BottomNavItems(
    val title: String,
    val route: String,
    val icon: ImageVector
) {
    data object BlogItem : BottomNavItems(
        title = "Blogs",
        route = ScreenRoutes.Blog.route,
        icon = Icons.Outlined.Newspaper
    )

    data object ProfileItem : BottomNavItems(
        title = "Garage",
        route = ScreenRoutes.Garage.route,
        icon = Icons.Outlined.Settings
    )
}