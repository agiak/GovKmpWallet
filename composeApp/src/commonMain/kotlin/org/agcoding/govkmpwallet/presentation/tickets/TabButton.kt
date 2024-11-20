package org.agcoding.govkmpwallet.presentation.tickets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.agcoding.govkmpwallet.ui.theme.primary
import org.agcoding.govkmpwallet.ui.theme.primaryLight
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TabButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isSelected) primaryLight else primary,
            contentColor = if (isSelected) Color.White else Color.White
        ),
        border = if (!isSelected) BorderStroke(2.dp, Color.White) else null,
        modifier = Modifier
            .padding(horizontal = 22.dp)
            .height(48.dp)
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            maxLines = 1,
            fontWeight = FontWeight.Bold
        )
    }
}



