package org.agcoding.govkmpwallet.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import govkmpwallet.composeapp.generated.resources.Res
import govkmpwallet.composeapp.generated.resources.ic_back_ios
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TopBar(
    onBackClick: () -> Unit,
    onZoomClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_back_ios),
            contentDescription = "Back button",
            tint = Color.Black,
            modifier = Modifier
                .clickable { onBackClick() }
                .size(28.dp)
        )
        Text(
            text = "Εισιτήριο",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        )
        Row {
            IconButton(onClick = { onZoomClick() }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Zoom",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* Handle more action */ }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewTopBar() {
    TopBar(
        onBackClick = { /* Handle back click */ },
        onZoomClick = { /* Handle zoom click */ },
        onMoreClick = { /* Handle more click */ },
    )
}