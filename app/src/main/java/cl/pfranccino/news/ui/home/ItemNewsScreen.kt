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
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.pfranccino.news.R
import cl.pfranccino.news.domain.model.Article
import cl.pfranccino.news.domain.model.Source
import cl.pfranccino.news.utils.Dimens
import coil.compose.AsyncImage

@Composable
fun ItemNewsScreen(new: Article) {
    Column(
        modifier = Modifier.padding(
            start = Dimens.spacing16,
            end = Dimens.spacing16,
            bottom = Dimens.spacing8,
            top = Dimens.spacing8
        )
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(Dimens.radiusMedium))
                .height(200.dp),
            contentDescription = null,
            placeholder = if (LocalInspectionMode.current) painterResource(id = R.drawable.ic_launcher_background) else null,
            contentScale = ContentScale.Crop,
            model = new.urlToImage,
        )
        InformationItemNewsScreen(
            new.title,
            new.description
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemNewsScreen() {
    ItemNewsScreen(
        new = Article(
            Source("", ""),
            "Paul Ayala",
            "Paul quiere aprender compose",
            "Esta probando nuevas tecnologias",
            "",
            "",
            "",
            ""

        )
    )
}