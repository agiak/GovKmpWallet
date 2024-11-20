package org.agcoding.govkmpwallet.presentation.tickets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.agcoding.govkmpwallet.presentation.ProfileViewModel
import org.agcoding.govkmpwallet.presentation.components.AddButton
import org.agcoding.govkmpwallet.ui.theme.primary
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TicketsScreen(
    profileViewModel: ProfileViewModel,
    navigateToDetails: () -> Unit
) {

    val profile by profileViewModel.profile.collectAsState()

    Box(
        modifier = Modifier
            .background(primary)
            .padding(
                vertical = 32.dp,
                horizontal = 16.dp
            )
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TitleRow()

            Spacer(modifier = Modifier.height(24.dp))

            TabRow(
                onActiveSelected = { /* Handle click */ },
                onCancelSelected = { /* Handle click */ },
                onRequestsSelected = { /* Handle click */ }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                shape = RoundedCornerShape(12.dp),
                onClick = { navigateToDetails() },
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Text(
                        style = TextStyle(
                            fontSize = 13.sp
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        text = "ΠΑΝΑΘΗΝΑΙΚΟΣ ΑΚΤΩΡ ΕΙΣΗΤΗΡΙΑ ΔΙΑΡΚΕΙΑΣ 2024...",
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        text = profile.getFullName(),
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.LightGray,
                            fontWeight = FontWeight.Light
                        ),
                        text = "Ισχύς μέχρι 01/08/2025",
                    )
                }
            }

//            IconButton(
//                onClick = { navigateToDetails() },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(76.dp)
//            ) {
//                Icon(
//                    painterResource(R.drawable.ic_ticket),
//                    contentDescription = "Ticket",
//                    tint = Color.Unspecified,
//                    modifier = Modifier.fillMaxSize()
//                )
//            }
        }
    }
}

@Composable
fun TitleRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Εισητήρια",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White,
            )
        )
        AddButton()
    }
}

@Composable
fun TabRow(
    onActiveSelected: () -> Unit,
    onCancelSelected: () -> Unit,
    onRequestsSelected: () -> Unit
) {
    var isSelected by remember { mutableIntStateOf(1) }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy((-24).dp)
    ) {
        TabButton("Ενεργά", isSelected = isSelected == 1, onClick = {
            isSelected = 1
            onActiveSelected()
        })
        TabButton("Άκυρα", isSelected = isSelected == 2, onClick = {
            isSelected = 2
            onCancelSelected()
        })
        TabButton("Αιτήματα", isSelected = isSelected == 3, onClick = {
            isSelected = 3
            onRequestsSelected()
        })
    }
}

