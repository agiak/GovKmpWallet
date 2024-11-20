package org.agcoding.govkmpwallet.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import govkmpwallet.composeapp.generated.resources.Res
import govkmpwallet.composeapp.generated.resources.ic_gov_logo
import org.agcoding.govkmpwallet.presentation.ProfileViewModel
import org.agcoding.govkmpwallet.presentation.components.AddButton
import org.agcoding.govkmpwallet.ui.theme.primary
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    viewModel: ProfileViewModel
) {
    val profile by viewModel.profile.collectAsState()

    Box(
        modifier = Modifier
            .background(primary)
            .padding(
                vertical = 32.dp,
                horizontal = 16.dp
            )
            .fillMaxSize()
    ) {
        Column {
            HomeLogoComponent()

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Καλωσόρισες,",
                color = Color.White,
                style = TextStyle(fontSize = 20.sp)
            )
            Text(
                text = profile.getFullName(),
                color = Color.White,
                style = TextStyle(fontSize = 26.sp)
            )
        }
    }
}

@Composable
fun HomeLogoComponent() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_gov_logo),
            contentDescription = "Logo gov wallet",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(84.dp)
                .background(primary)
                .weight(1f)
        )
        AddButton()
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        HomeScreen(ProfileViewModel())
    }
}