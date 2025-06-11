package cl.pfranccino.news.saved.domain.usecase

import cl.pfranccino.news.saved.domain.model.SavedNews
import cl.pfranccino.news.saved.domain.model.SearchFilters
import kotlinx.coroutines.flow.Flow

interface SearchSavedNewsUseCase {
    operator fun invoke(query: String): Flow<List<SavedNews>>
    fun searchWithFilters(query: String, filters: SearchFilters): Flow<List<SavedNews>>
    fun searchByKeywords(keywords: List<String>): Flow<List<SavedNews>>
}