package de.comsystoreply.gearbox

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import de.comsystoreply.gearbox.navigation.GearboxNavigation
import de.comsystoreply.gearbox.ui.theme.GearboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GearboxTheme {
                GearboxNavigation()
            }
        }
    }
}