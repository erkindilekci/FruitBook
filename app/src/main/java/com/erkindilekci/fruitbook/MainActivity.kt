package com.erkindilekci.fruitbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erkindilekci.fruitbook.presentation.fruislistscreen.FruitListScreen
import com.erkindilekci.fruitbook.presentation.ui.theme.Background
import com.erkindilekci.fruitbook.presentation.ui.theme.FruitBookTheme
import com.erkindilekci.fruitbook.presentation.ui.theme.TopBar
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this) {}

        setContent {
            Surface(modifier = Modifier
                .fillMaxSize()
                .background(Background)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                FruitListScreen()
            }
        }
    }
}
// ca-app-pub-6857571371166228~6395700920 -> app
// ca-app-pub-6857571371166228/7589363097 -> banner