package org.agcoding.govkmpwallet.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import org.agcoding.govkmpwallet.data.BottomNavItem
import org.agcoding.govkmpwallet.data.Route
import org.agcoding.govkmpwallet.presentation.ProfileViewModel
import org.agcoding.govkmpwallet.presentation.details.TicketScreen
import org.agcoding.govkmpwallet.presentation.home.HomeScreen
import org.agcoding.govkmpwallet.presentation.more.MoreScreen
import org.agcoding.govkmpwallet.presentation.qr.QrScreen
import org.agcoding.govkmpwallet.presentation.scan.ScanScreen
import org.agcoding.govkmpwallet.presentation.tickets.TicketsScreen

@Composable
fun BottomNavigationComponent(
    profileViewModel: ProfileViewModel,
) {
    val navController = rememberNavController()
    var showBottomBar by remember { mutableStateOf(true) }

    val bottomItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Tickets,
        BottomNavItem.Scan,
        BottomNavItem.More
    )

    Scaffold(
        bottomBar = {
            if (showBottomBar) BottomNavigationBar(navController, bottomItems)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.Home.route,
            modifier = Modifier
                .background(color = Color.White)
                .padding(innerPadding)
        ) {
            composable(Route.Home.route){
                showBottomBar = true
                HomeScreen(profileViewModel)
            }
            composable(Route.Ticket.route) {
                showBottomBar = false
                TicketScreen(
                    profileViewModel = profileViewModel,
                    onBackClick = { navController.navigateUp() },
                    onMoreClick = {},
                    onZoomClick = {
                        navController.navigate(Route.Details.route)
                    }
                )
            }
            composable(Route.Tickets.route) {
                showBottomBar = true
                TicketsScreen(
                    profileViewModel = profileViewModel,
                    navigateToDetails = { navController.navigate(Route.Ticket.route) }
                )
            }
            composable(Route.Scan.route) {
                showBottomBar = true
                ScanScreen()
            }
            composable(Route.More.route) {
                showBottomBar = true
                MoreScreen(profileViewModel)
            }
            dialog(Route.Details.route) {
                showBottomBar = false
                QrScreen(
                    profileViewModel = profileViewModel,
                    onDismiss = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}