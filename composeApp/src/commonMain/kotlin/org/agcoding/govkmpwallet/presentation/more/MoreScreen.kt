package org.agcoding.govkmpwallet.presentation.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.agcoding.govkmpwallet.data.Profile
import org.agcoding.govkmpwallet.data.availableProfiles
import org.agcoding.govkmpwallet.presentation.ProfileViewModel
import org.agcoding.govkmpwallet.ui.theme.primary
import org.agcoding.govkmpwallet.ui.theme.primaryLight
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MoreScreen(
    profileViewModel: ProfileViewModel
) {
    val selectedProfile by profileViewModel.profile.collectAsState()

    Column(
        modifier = Modifier
            .background(primary)
            .padding(vertical = 24.dp)
            .fillMaxSize()
    ) {
        availableProfiles.forEach { profile ->
            MoreItem(
                currentSelectedProfile = selectedProfile,
                profile = profile,
                onItemClick = { selectedProfile ->
                    profileViewModel.setProfile(selectedProfile)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MoreItem(
    currentSelectedProfile: Profile,
    profile: Profile,
    onItemClick: (profile: Profile) -> Unit
) {
    val backgroundColor = if (currentSelectedProfile == profile) primaryLight else Color.White
    val textColor = if (currentSelectedProfile == profile) Color.White else Color.Black

    Card(
        shape = RoundedCornerShape(4.dp),
        onClick = { onItemClick(profile) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
    ) {
        Text(
            text = profile.getFullName(),
            style = TextStyle(
                color = textColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
                .padding(horizontal = 12.dp, vertical = 24.dp)
        )
    }
}

@Preview()
@Composable
fun MoreScreenPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MoreScreen(ProfileViewModel())
    }
}