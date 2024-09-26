package cl.pfranccino.news.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import cl.pfranccino.news.domain.model.Article
import coil.compose.AsyncImage

@Composable
fun ItemNewsScreen(new : Article) {
    Column {
        AsyncImage(model = new.urlToImage , contentDescription = null)
        InformationItemNewsScreen(
            new.title,
            new.description
        )
        InformationAboutPublicationScreen(
            views = "1.2k",
            publicationTime = "3 hours",
            sentiment = "Negative"
        )
    }
}