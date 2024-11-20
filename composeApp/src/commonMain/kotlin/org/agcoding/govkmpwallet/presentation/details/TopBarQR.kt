package org.agcoding.govkmpwallet.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.agcoding.govkmpwallet.presentation.ProfileViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun QrComponent(
    profileViewModel: ProfileViewModel,
    onBackClick: () -> Unit,
    onZoomClick: () -> Unit,
    onMoreClick: () -> Unit,
) {
    val profile by profileViewModel.profile.collectAsState()

    Column(
        modifier = Modifier
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        TopBar(
            onBackClick = onBackClick,
            onZoomClick = onZoomClick,
            onMoreClick = onMoreClick,
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(profile.qrId),
            contentDescription = "QR Code",
            modifier = Modifier.size(124.dp),
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Ticket Number
        Text(
            text = profile.qrNumber,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun PreviewQrTicketScreen() {
    QrComponent(
        profileViewModel = ProfileViewModel(),
        onBackClick = { /* Handle back click */ },
        onZoomClick = { /* Handle zoom click */ },
        onMoreClick = { /* Handle more click */ },
    )
}