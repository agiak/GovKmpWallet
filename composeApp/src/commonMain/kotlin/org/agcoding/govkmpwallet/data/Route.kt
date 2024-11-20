package org.agcoding.govkmpwallet.data

import kotlinx.serialization.Serializable

@Serializable
sealed class Route(val route: String) {
    @Serializable
    data object Home : Route( "home")
    @Serializable
    data object Ticket : Route("ticket")
    @Serializable
    data object Tickets : Route( "tickets")
    @Serializable
    data object Details : Route("details")
    @Serializable
    data object More : Route("more")
    @Serializable
    data object Scan : Route("scan")
}