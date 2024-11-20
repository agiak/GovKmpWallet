package org.agcoding.govkmpwallet.presentation.qr

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import org.jetbrains.compose.resources.painterResource
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.agcoding.govkmpwallet.ui.theme.primaryLight
import govkmpwallet.composeapp.generated.resources.Res
import govkmpwallet.composeapp.generated.resources.ic_qr
import org.agcoding.govkmpwallet.presentation.ProfileViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun QrScreen(
    profileViewModel: ProfileViewModel,
    onDismiss: () -> Unit
) {
    val profile by profileViewModel.profile.collectAsState()

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .padding(horizontal = 24.dp, vertical = 24.dp)
                .clickable { onDismiss() },
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .padding(4.dp),
            ) {
                val test = Res.drawable.ic_qr
                Icon(
                    painter = painterResource(test),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1F)
                        .background(Color.White)
                        .align(Alignment.Center)
                )
            }

            Button(
                onClick = onDismiss,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = primaryLight,
                    contentColor = Color.White,
                ),
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(
                    text = "Κλείσιμο",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    QrScreen(
        profileViewModel = ProfileViewModel(),
        onDismiss = {}
    )
}