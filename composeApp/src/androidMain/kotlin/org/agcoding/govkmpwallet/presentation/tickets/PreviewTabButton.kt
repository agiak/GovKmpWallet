package org.agcoding.govkmpwallet.presentation.tickets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.agcoding.govkmpwallet.ui.theme.primary

@Preview
@Composable
fun PreviewButton() {
    MaterialTheme {
        Box (
            modifier = Modifier.background(primary)
        ) {
            TabButton(
                text = "Active",
                isSelected = false,
            ) { }
        }
    }
}