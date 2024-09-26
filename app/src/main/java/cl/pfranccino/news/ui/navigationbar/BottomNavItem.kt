package cl.pfranccino.news.ui.navigationbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route : String,val icon : ImageVector, val label : String) {
    data object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    data object Discover : BottomNavItem("discover", Icons.Default.Search, "Discover")
    data object Saved : BottomNavItem("saved", Icons.Default.Favorite, "Saved")
    data object  Profile : BottomNavItem("Profile", Icons.Default.Person, "Profile")
}