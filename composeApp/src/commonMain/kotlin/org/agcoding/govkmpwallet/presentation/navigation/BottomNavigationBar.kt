package org.agcoding.govkmpwallet.presentation.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.agcoding.govkmpwallet.data.BottomNavItem
import org.agcoding.govkmpwallet.data.Route
import org.agcoding.govkmpwallet.ui.theme.primaryDark
import org.jetbrains.compose.resources.painterResource

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<BottomNavItem>,
) {
    BottomNavigation(
        backgroundColor = primaryDark,
        modifier = Modifier.height(64.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            val isSelected = currentRoute == item.route.route
            val color = if (isSelected) Color.White else Color.Gray
            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route.route) {
                        popUpTo(navController.graph.startDestinationRoute ?: Route.Home.route)
                        launchSingleTop = true
                    }
                },
                unselectedContentColor = color,
                selectedContentColor = color,
                icon = {
                    Icon(
                        painterResource(item.icon),
                        contentDescription = null,
                        tint = color
                    )
                },
                label = {
                    Text(
                        item.label,
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = color,
                            textAlign = TextAlign.Center
                        )
                    )
                },
            )
        }
    }
}