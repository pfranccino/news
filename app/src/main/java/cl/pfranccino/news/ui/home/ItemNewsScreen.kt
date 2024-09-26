package cl.pfranccino.news.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cl.pfranccino.news.domain.model.Article
import cl.pfranccino.news.utils.Dimens
import coil.compose.AsyncImage

@Composable
fun ItemNewsScreen(new: Article) {
    Column(modifier = Modifier.padding(start = Dimens.spacing12, end = Dimens.spacing12, bottom = Dimens.spacing8, top = Dimens.spacing4)) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(Dimens.radiusMedium))
                .height(200.dp),
            contentScale = ContentScale.Crop, model = new.urlToImage, contentDescription = null
        )
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