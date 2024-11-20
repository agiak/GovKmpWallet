package org.agcoding.govkmpwallet.presentation.tickets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.agcoding.govkmpwallet.presentation.ProfileViewModel

@Preview
@Composable
fun PreviewTicketsScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        TicketsScreen(
            profileViewModel = ProfileViewModel(),
            navigateToDetails = {}
        )
    }
}