package org.agcoding.govkmpwallet.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import org.agcoding.govkmpwallet.presentation.ProfileViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TicketScreen(
    profileViewModel: ProfileViewModel,
    onBackClick: () -> Unit,
    onZoomClick: () -> Unit,
    onMoreClick: () -> Unit,
) {
    Column {
        QrComponent(
            profileViewModel = profileViewModel,
            onBackClick = onBackClick,
            onZoomClick = onZoomClick,
            onMoreClick = onMoreClick,
        )
        TicketDetailsScreen(
            profileViewModel = profileViewModel
        )
    }
}

@Preview
@Composable
fun PreviewTicketScreen() {
    TicketScreen(
        profileViewModel = ProfileViewModel(),
        onBackClick = { /* Handle back click */ },
        onZoomClick = { /* Handle zoom click */ },
        onMoreClick = { /* Handle more click */ },
    )
}