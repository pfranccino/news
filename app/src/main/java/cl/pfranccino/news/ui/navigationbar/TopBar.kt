package cl.pfranccino.news.ui.navigationbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cl.pfranccino.news.ui.theme.NewsTextStyles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text("AI News", style = NewsTextStyles.appBarTitle) },
        actions = {
            IconButton(onClick = { /* Acción del icono */ }) {
                Icon(Icons.Filled.AccountCircle, contentDescription = "Configuración")
            }
        }
    )
}

@Preview
@Composable
fun PreviewTopBar() {
    TopBar()
}
