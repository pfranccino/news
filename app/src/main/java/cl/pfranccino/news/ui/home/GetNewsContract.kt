package cl.pfranccino.news.ui.home

import cl.pfranccino.news.domain.model.NewsResponse

interface GetNewsContract {
    data class UiState(val news: NewsResponse? = null)

    sealed interface UiAction {
        data object OnLoadNews : UiAction
        data object OnShowNews : UiAction
        data object OnGoToNewDetail : UiAction
    }

    sealed interface SideEffect {
        data object RefreshNews : SideEffect
    }
}