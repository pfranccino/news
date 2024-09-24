package cl.pfranccino.news.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.pfranccino.news.domain.model.NewsResponse
import cl.pfranccino.news.domain.repository.NewsRepository
import cl.pfranccino.news.utils.mvi.MVI
import cl.pfranccino.news.utils.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetNewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel(),
    MVI<GetNewsContract.UiState, GetNewsContract.UiAction, GetNewsContract.SideEffect> by mvi(
        GetNewsContract.UiState(null)
    ) {

    override fun onAction(uiAction: GetNewsContract.UiAction) {
        when(uiAction){
            GetNewsContract.UiAction.OnGoToNewDetail -> TODO()
            GetNewsContract.UiAction.OnLoadNews -> getNews()
            GetNewsContract.UiAction.OnShowNews -> {

            }
        }
    }

    private fun updateNews(newsResponse: NewsResponse){
        updateUiState { copy( news = newsResponse)}
    }

    fun getNews() {
        viewModelScope.launch {
            repository.getAllNews().fold({

            }, {
                updateNews(it)
                onAction(GetNewsContract.UiAction.OnShowNews)
            })
        }
    }
}