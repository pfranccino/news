package cl.pfranccino.news.ui.home

import cl.pfranccino.news.domain.model.NewsResponse

interface GetNewsContract {
    data class UiState(val news: NewsResponse = NewsResponse(status = "", totalResults = 0,articles = listOf()), val isLoading : Boolean = false)

    sealed interface UiAction {
        data object OnLoadNews : UiAction
        data class OnNewsLoadedWithCategory(val category: String) : UiAction
    }

    sealed interface SideEffect {
        data object RefreshNews : SideEffect
    }
}