package com.example.bottombar_con_cambio_de_contenido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bottombar_con_cambio_de_contenido.ui.theme.BottomBar_con_Cambio_de_ContenidoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomBar_con_Cambio_de_ContenidoTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var selectedScreen by remember { mutableStateOf("A") }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(modifier = Modifier.fillMaxWidth()) {
                    BottomBarButton(
                        label = "Pantalla A",
                        onClick = { selectedScreen = "A" },
                        isSelected = selectedScreen == "A",
                        modifier = Modifier.weight(1f)
                    )
                    BottomBarButton(
                        label = "Pantalla B",
                        onClick = { selectedScreen = "B" },
                        isSelected = selectedScreen == "B",
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    ) { innerPadding ->
        ScreenContent(
            screen = selectedScreen,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun BottomBarButton(label: String, onClick: () -> Unit, isSelected: Boolean, modifier: Modifier = Modifier) {
    TextButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = label,
            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun ScreenContent(screen: String, modifier: Modifier = Modifier) {
    Text(
        text = if (screen == "A") "Estás en la Pantalla A" else "Estás en la Pantalla B",
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    BottomBar_con_Cambio_de_ContenidoTheme {
        MainScreen()
    }
}
