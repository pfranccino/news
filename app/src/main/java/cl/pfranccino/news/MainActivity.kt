package cl.pfranccino.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                    composable(BottomNavItem.Discover.route) { DiscoverScreen() }
                    composable(BottomNavItem.Saved.route) { SavedScreen() }
                    composable(BottomNavItem.Profile.route) { ProfileScreen() }
                }
            }
        }
    }
}

@Composable
fun DiscoverScreen() {
    //Futura Implementación de la pantalla de descubrimiento
    Text("Pantalla de Descubrimiento")
}

@Composable
fun SavedScreen() {
    //Futura Implementación de la pantalla de guardados
    Text("Pantalla de Guardados")
}

@Composable
fun ProfileScreen() {
    //Futura Implementación de la pantalla de perfil
    Text("Pantalla de Perfil")
}
