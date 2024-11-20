package org.agcoding.govkmpwallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import org.agcoding.govkmpwallet.ui.theme.primaryDark

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = primaryDark.toArgb()
        setContent {
            App2()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App2()
}