package cl.pfranccino.news.saved.domain.usecase

import cl.pfranccino.news.saved.domain.model.SavedNews

interface SaveNewsUseCase {
    suspend operator fun invoke(news: SavedNews)
    suspend fun saveMultiple(newsList: List<SavedNews>)
    suspend fun saveIfValid(news: SavedNews): Boolean
}