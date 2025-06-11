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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
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
            NewNavigation()
        }
    }
}



@Composable
fun NewNavigation(){
    val backStack = remember { mutableStateListOf<BottomNavItem>(BottomNavItem.Home) }

    NewsTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopBar() },
            bottomBar = {
                BottomBar(
                    currentItem = backStack.lastOrNull() ?: BottomNavItem.Home,
                    onItemSelected = { item ->
                        if (backStack.lastOrNull() != item) {
                            backStack.clear()
                            backStack.add(item)
                        }
                    }
                )
            }
        ) { paddingValues ->
            NavDisplay(
                backStack = backStack,
                onBack = { backStack.removeLastOrNull() },
                entryProvider = { item ->
                    when(item){
                        BottomNavItem.Discover -> NavEntry(item){
                            DiscoverScreen(padding = paddingValues)
                        }
                        BottomNavItem.Home -> NavEntry(item){
                            HomeScreen(paddingValues = paddingValues)
                        }
                        BottomNavItem.Profile -> NavEntry(item){
                            ProfileScreen(padding = paddingValues)
                        }
                        BottomNavItem.Saved -> NavEntry(item){
                            SavedScreen(padding = paddingValues)
                        }
                    }
                }
            )
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
