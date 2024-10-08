package cl.pfranccino.news.ui.home

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
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.Flow

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
    LazyColumn(
        flingBehavior = ScrollableDefaults.flingBehavior(),
        state = rememberLazyListState(),
        modifier = Modifier.fillMaxSize().padding(paddingValues),
        content = {
            items(uiState.news.articles) { art ->
                ItemNewsScreen(new = art)
            }
        }
    )
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(PaddingValues())
}