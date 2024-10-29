package cl.pfranccino.news.ui.home

import android.util.Log
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import cl.pfranccino.news.domain.model.Article
import cl.pfranccino.news.domain.model.NewsResponse
import cl.pfranccino.news.domain.model.Source
import cl.pfranccino.news.ui.theme.NewsTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun HomeScreen(paddingValues : PaddingValues) {
    val viewModel: GetNewsViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onAction(uiAction = GetNewsContract.UiAction.OnLoadNews)
    }
    HomeScreen(paddingValues,uiState,viewModel.sideEffect)
}

@Composable
private fun HomeScreen(
    paddingValues: PaddingValues,
    uiState: GetNewsContract.UiState,
    sideEffect: Flow<GetNewsContract.SideEffect>,
) {
    Column(modifier = Modifier.padding(paddingValues)) {
    NewsCategoryFilters(onCategorySelected = {
        Log.e("HomeScreen", it.toString())
    })
    LazyColumn(
        flingBehavior = ScrollableDefaults.flingBehavior(),
        state = rememberLazyListState(),
        modifier = Modifier
            .fillMaxSize(),
        content = {
            items(uiState.news.articles) { art ->
                ItemNewsScreen(new = art)
            }
        }
    )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val sampleArticles = List(5) {
        Article(
            Source("", ""),
            "Paul Ayala",
            "Paul quiere aprender compose",
            "Esta probando nuevas tecnologias",
            "",
            "",
            "",
            ""

        )
    }

    val sampleUiState = GetNewsContract.UiState(
        news = NewsResponse(status = "", totalResults = 10, articles = sampleArticles)
    )

    NewsTheme {
        HomeScreen(
            paddingValues = PaddingValues(),
            uiState = sampleUiState,
            sideEffect = flowOf()
        )
    }
}