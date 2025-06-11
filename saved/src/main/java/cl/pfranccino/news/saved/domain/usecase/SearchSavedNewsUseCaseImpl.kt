package cl.pfranccino.news.saved.domain.usecase

import cl.pfranccino.news.saved.domain.model.SavedNews
import cl.pfranccino.news.saved.domain.model.SearchFilters
import cl.pfranccino.news.saved.domain.repository.SavedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchSavedNewsUseCaseImpl @Inject constructor(
    private val repository: SavedRepository
) : SearchSavedNewsUseCase {

    override operator fun invoke(query: String): Flow<List<SavedNews>> {
        if (query.isBlank()) {
            return flowOf(emptyList())
        }

        val cleanQuery = query.trim()
        return repository.searchSavedNews(cleanQuery)
    }

    override fun searchWithFilters(query: String, filters: SearchFilters): Flow<List<SavedNews>> {
        val baseFlow = when {
            filters.source != null -> repository.getSavedNewsBySource(filters.source)
            filters.author != null -> repository.getSavedNewsByAuthor(filters.author)
            query.isNotBlank() -> repository.searchSavedNews(query.trim())
            else -> repository.getSavedNews()
        }

        return baseFlow.map { newsList ->
            newsList.filter { news ->
                applyDateFilters(news, filters)
            }
        }
    }

    override fun searchByKeywords(keywords: List<String>): Flow<List<SavedNews>> {
        if (keywords.isEmpty()) {
            return flowOf(emptyList())
        }

        return repository.getSavedNews().map { newsList ->
            newsList.filter { news ->
                keywords.any { keyword ->
                    news.title.contains(keyword, ignoreCase = true) ||
                            news.description?.contains(keyword, ignoreCase = true) == true ||
                            news.content?.contains(keyword, ignoreCase = true) == true
                }
            }
        }
    }

    private fun applyDateFilters(news: SavedNews, filters: SearchFilters): Boolean {
        val newsTime = news.savedAt

        val afterFrom = filters.dateFrom?.let { newsTime >= it } ?: true
        val beforeTo = filters.dateTo?.let { newsTime <= it } ?: true

        return afterFrom && beforeTo
    }
}