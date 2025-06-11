package cl.pfranccino.news.saved.domain.usecase

import cl.pfranccino.news.saved.domain.model.SavedNews

fun interface GetSavedNewsByIdUseCase {
    suspend operator fun invoke(newsId: String): SavedNews?
}