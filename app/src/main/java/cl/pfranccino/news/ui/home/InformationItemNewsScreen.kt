package cl.pfranccino.news.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun InformationItemNewsScreen(title: String, subtitle: String) {
    Column(
        modifier = Modifier.padding(top = 4.dp)
    ) {
        Text(text = title, fontSize = 10.sp, fontWeight = FontWeight.Bold )
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = subtitle, fontSize = 8.sp)
    }
}