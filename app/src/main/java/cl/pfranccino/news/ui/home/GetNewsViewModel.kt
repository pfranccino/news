package cl.pfranccino.news.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.pfranccino.news.domain.model.NewsResponse
import cl.pfranccino.news.domain.repository.NewsRepository
import cl.pfranccino.news.utils.mvi.MVI
import cl.pfranccino.news.utils.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class GetNewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel(),
    MVI<GetNewsContract.UiState, GetNewsContract.UiAction, GetNewsContract.SideEffect> by mvi(
        GetNewsContract.UiState()
    ) {

    override fun onAction(uiAction: GetNewsContract.UiAction) {
        when(uiAction){
            GetNewsContract.UiAction.OnLoadNews -> {
                Log.e("ViewModel", "Iniciando carga, setting loading = true")
                updateUiState { copy(isLoading = true) }
                getNews()
            }

            is GetNewsContract.UiAction.OnNewsLoadedWithCategory -> {
                Log.e("ViewModel", "Categoría seleccionada: ${uiAction.category}")
                updateUiState { copy(isLoading = true) }
                getNewsByCategory(uiAction.category)

            }
        }
    }

    private fun updateNews(newsResponse: NewsResponse){
        Log.e("ViewModel", "Actualizando noticias, setting loading = false")
        updateUiState { copy( news = newsResponse, isLoading = false)}
    }

    private fun getNewsByCategory(category: String) {
        viewModelScope.launch {
            repository.getNewsByCategory(category.toUpperCase(Locale.getDefault())).fold({
                Log.e("GetNewsViewModel", "$it")
            }, {
                updateNews(it)
            })
        }
    }

    private fun getNews() {
        viewModelScope.launch {
            repository.getAllNews().fold({
                Log.e("GetNewsViewModel", "$it")
            }, {
                updateNews(it)
            })
        }
    }
}