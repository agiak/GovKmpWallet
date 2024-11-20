package org.agcoding.govkmpwallet.data

import govkmpwallet.composeapp.generated.resources.Res
import govkmpwallet.composeapp.generated.resources.ic_document
import govkmpwallet.composeapp.generated.resources.ic_nav_more
import govkmpwallet.composeapp.generated.resources.ic_nav_scan
import govkmpwallet.composeapp.generated.resources.ic_nav_tickets
import org.jetbrains.compose.resources.DrawableResource

sealed class BottomNavItem(val route: Route, val icon: DrawableResource, val label: String) {
    data object Home : BottomNavItem(Route.Home, Res.drawable.ic_document, "Εγγραφα")
    data object Tickets : BottomNavItem(Route.Tickets, Res.drawable.ic_nav_tickets, "Εισητήρια")
    data object Scan : BottomNavItem(Route.Scan, Res.drawable.ic_nav_scan, "Έλεγχος")
    data object More : BottomNavItem(Route.More, Res.drawable.ic_nav_more, "Περισσότερα")
}