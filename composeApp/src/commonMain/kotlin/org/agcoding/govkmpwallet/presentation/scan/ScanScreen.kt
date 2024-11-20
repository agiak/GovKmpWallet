package org.agcoding.govkmpwallet.presentation.scan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.agcoding.govkmpwallet.ui.theme.primary
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ScanScreen() {
    Box(
        modifier = Modifier
            .background(primary)
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = "Scan Screen",
            color = Color.White
        )
    }
}

@Preview
@Composable
fun ScanScreenPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        ScanScreen()
    }
}