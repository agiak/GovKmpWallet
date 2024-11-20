package org.agcoding.govkmpwallet.presentation.tickets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.agcoding.govkmpwallet.ui.theme.primary

@Preview
@Composable
fun PreviewTabButton() {
    MaterialTheme {
        var isSelected by remember { mutableStateOf(1) }
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(primary),
            horizontalArrangement = Arrangement.spacedBy(-24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TabButton("Active", isSelected = isSelected == 1, onClick = {
                // Handle click
                isSelected = 1
            })
            TabButton("Cancel", isSelected = isSelected == 2, onClick = {
                // Handle click
                isSelected = 2
            })
            TabButton("Requests", isSelected = isSelected == 3, onClick = {
                // Handle click
                isSelected = 3
            })
        }
    }
}