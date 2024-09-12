package de.comsystoreply.gearbox

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import de.comsystoreply.gearbox.navigation.RootNavHost
import de.comsystoreply.gearbox.ui.theme.GearboxTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GearboxTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    RootNavHost()
                }
            }
        }
    }
}