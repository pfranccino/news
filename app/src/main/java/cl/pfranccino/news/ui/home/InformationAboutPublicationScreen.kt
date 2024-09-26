package cl.pfranccino.news.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InformationAboutPublicationScreen(views: String, publicationTime: String, sentiment: String) {
    Row(modifier = Modifier.padding(horizontal = 4.dp)) {
        Text("$views views -", fontSize = 6.sp)
        Spacer(modifier = Modifier.height(2.dp))
        Text(" $publicationTime hours ago -", fontSize = 6.sp)
        Spacer(modifier = Modifier.height(2.dp))
        Text(" AI sentiment: $sentiment", fontSize = 6.sp)
    }
}