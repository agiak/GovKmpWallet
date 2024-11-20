package org.agcoding.govkmpwallet.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.agcoding.govkmpwallet.presentation.ProfileViewModel
import org.agcoding.govkmpwallet.ui.theme.primary
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TicketDetailsScreen(
    profileViewModel: ProfileViewModel
) {
    val profile by profileViewModel.profile.collectAsState()

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .background(primary) // Dark blue background similar to the images
            .verticalScroll(scrollState)
            .padding(
                vertical = 16.dp,
                horizontal = 24.dp
            )
    ) {
        // First section (First image content)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            TicketDetailRow(label = "ΚΑΤΟΧΟΣ ΕΙΣΙΤΗΡΙΟΥ", value = profile?.splitFullName() ?: "")
            TicketDetailRow(label = "ΚΩΔΙΚΟΣ ΕΙΣΙΤΗΡΙΟΥ", value = profile?.ticketNumber ?: "")
            TicketDetailRow(
                label = "ΕΚΔΗΛΩΣΗ",
                value = "ΚΑΕ ΠΑΝΑΘΗΝΑΙΚΟΣ\nΑΚΤΩΡ ΕΙΣΙΤΗΡΙΑ\nΔΙΑΡΚΕΙΑΣ 2024-2025"
            )
            TicketDetailRow(label = "ΙΣΧΥΣ ΜΕΧΡΙ", value = "01/08/2025")
            TicketDetailRow(label = "ΓΗΠΕΔΟ", value = "Κλειστό Γήπεδο Μπάσκετ\n(Ο.Α.Κ.Α.)")
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                profile?.let {
                    with(it.seat) {
                        SeatItem(label = "ΘΥΡΑ", value = door)
                        SeatItem(label = "ΤΜΗΜΑ", value = department)
                        SeatItem(label = "ΣΕΙΡΑ", value = row)
                        SeatItem(label = "ΘΕΣΗ", value = number)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(8.dp))

        TicketDetailRow(label = "ΤΥΠΟΣ ΕΙΣΙΤΗΡΙΟΥ", value = "ΔΙΑΡΚΕΙΑΣ")
    }
}

@Composable
fun SeatItem(label: String, value: String) {
    Column {
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color(0xFFB0BEC5), // Gray text color for the labels
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            fontSize = 18.sp,
            color = Color.White, // White text color for the values
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun TicketDetailRow(label: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color(0xFFB0BEC5), // Gray text color for the labels
            fontWeight = FontWeight.Thin
        )
        Text(
            text = value,
            fontSize = 24.sp,
            style = TextStyle(
                lineHeight = 32.sp // Adjust the value as needed
            ),
            color = Color.White, // White text color for the values
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview
@Composable
fun PreviewTicketDetailsScreen() {
    TicketDetailsScreen(ProfileViewModel())
}