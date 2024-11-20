package org.agcoding.govkmpwallet.data

import org.jetbrains.compose.resources.DrawableResource

data class Profile(
    val qrId: DrawableResource,
    val firstName: String,
    val lastName: String,
    val ticketNumber: String,
    val qrNumber: String,
    val seat: SeatDetails
) {
    fun getFullName(): String = "$firstName $lastName"

    fun splitFullName(): String = "$firstName\n$lastName"
}

data class SeatDetails(
    val row: String,
    val number: String,
    val department: String,
    val door: String,
)