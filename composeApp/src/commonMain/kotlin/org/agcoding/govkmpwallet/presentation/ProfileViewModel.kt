package org.agcoding.govkmpwallet.presentation

import androidx.lifecycle.ViewModel
import org.agcoding.govkmpwallet.data.AG
import org.agcoding.govkmpwallet.data.Profile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {

    private val _profile = MutableStateFlow(AG)
    val profile: StateFlow<Profile> = _profile.asStateFlow()

    fun setProfile(profile: Profile) {
        _profile.value = profile
    }
}