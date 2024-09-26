package cl.pfranccino.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.pfranccino.news.ui.navigationbar.BottomBar
import cl.pfranccino.news.ui.navigationbar.BottomNavItem
import cl.pfranccino.news.ui.navigationbar.TopBar
import cl.pfranccino.news.ui.home.HomeScreen
import cl.pfranccino.news.ui.theme.NewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsTheme{
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { BottomBar(navController) },
                topBar = { TopBar()}
            ) { padding ->
                NavHost(
                    navController = navController,
                    startDestination = BottomNavItem.Home.route,
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable(BottomNavItem.Home.route) { HomeScreen(padding) }
                    composable(BottomNavItem.Discover.route) { DiscoverScreen(padding) }
                    composable(BottomNavItem.Saved.route) { SavedScreen(padding) }
                    composable(BottomNavItem.Profile.route) { ProfileScreen(padding) }
                }
            }
            }
        }
    }
}

@Composable
fun DiscoverScreen(padding: PaddingValues) {
    //Futura Implementación de la pantalla de descubrimiento
    Text(modifier = Modifier.padding(padding), text = "Pantalla de Descubrimiento")
}

@Composable
fun SavedScreen(padding: PaddingValues) {
    //Futura Implementación de la pantalla de guardados
    Text(modifier = Modifier.padding(padding), text ="Pantalla de Guardados")
}

@Composable
fun ProfileScreen(padding: PaddingValues) {
    //Futura Implementación de la pantalla de perfil
    Text(modifier = Modifier.padding(padding), text ="Pantalla de Perfil")
}
