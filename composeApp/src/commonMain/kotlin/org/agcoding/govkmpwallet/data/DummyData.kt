package org.agcoding.govkmpwallet.data

import androidx.compose.ui.input.key.Key.Companion.R
import govkmpwallet.composeapp.generated.resources.Res
import govkmpwallet.composeapp.generated.resources.ic_qr


val AG = Profile(
    qrId = Res.drawable.ic_qr,
    firstName = "ΑΝΑΣΤΑΣΙΟΣ",
    lastName = "ΓΙΑΚΟΥΜΑΤΟΣ",
    ticketNumber = "111111111",
    qrNumber = "1111111-0",
    seat = SeatDetails(
        row = "1",
        number = "1",
        department = "225Β",
        door = "27"
    )
)

val TG = Profile(
    qrId = Res.drawable.ic_qr,
    firstName = "ΤΑΣΟΣ",
    lastName = "ΓΙΑΚΟΥΜΑΤΟΣ",
    ticketNumber = "11111111",
    qrNumber = "1111111-0",
    seat = SeatDetails(
        row = "2",
        number = "2",
        department = "225Β",
        door = "27"
    )
)

val availableProfiles = listOf(AG, TG)