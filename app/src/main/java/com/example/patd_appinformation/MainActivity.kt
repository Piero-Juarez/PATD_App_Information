package com.example.patd_appinformation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.patd_appinformation.navigation.NavManager
import com.example.patd_appinformation.ui.theme.PATDAppInformationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val darkMode = remember { mutableStateOf(false) }
            PATDAppInformationTheme(
                darkTheme = darkMode.value
            ) {
                NavManager(darkMode = darkMode)
            }
        }
    }
}