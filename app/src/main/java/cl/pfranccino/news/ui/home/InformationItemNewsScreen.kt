package cl.pfranccino.news.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.pfranccino.news.ui.theme.NewsTextStyles


@Composable
fun InformationItemNewsScreen(title: String, subtitle: String) {
    Column(
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.titleMedium )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = subtitle , style = MaterialTheme.typography.bodyMedium, maxLines = 3)
    }
}