package cl.pfranccino.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.pfranccino.news.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                Column {
                    InformationItemNews(
                        "How AI is shaping the future of business",
                        "By Sarah E.Needleman, Wall Street Journal"
                    )
                    InformationAboutPublication(
                        views = "1.2k",
                        publicationTime = "3 hours",
                        sentiment = "Negative"
                    )
                }
            }
        }
    }
}


@Composable
fun InformationItemNews(title: String, subtitle: String) {
    Column(
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        Text(text = title, fontSize = 8.sp)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = subtitle, fontSize = 6.sp)
    }
}

@Composable
fun InformationAboutPublication(views: String, publicationTime: String, sentiment: String) {
    Row(modifier = Modifier.padding(horizontal = 4.dp)) {
        Text("$views views -", fontSize = 6.sp)
        Spacer(modifier = Modifier.height(2.dp))
        Text(" $publicationTime hours ago -", fontSize = 6.sp)
        Spacer(modifier = Modifier.height(2.dp))
        Text(" AI sentiment: $sentiment", fontSize = 6.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherTheme {
        Column {
            InformationItemNews(
                "How AI is shaping the future of business",
                "By Sarah E.Needleman, Wall Street Journal"
            )
            InformationAboutPublication(
                views = "1.2k",
                publicationTime = "3 hours",
                sentiment = "Negative"
            )
        }

    }
}