package cl.pfranccino.news.saved.domain.repository

import cl.pfranccino.news.saved.domain.model.SavedNews
import kotlinx.coroutines.flow.Flow

interface SavedRepository {
    fun getSavedNews(): Flow<List<SavedNews>>
    suspend fun saveNews(news: SavedNews)
    suspend fun removeSavedNews(newsId: String)
    suspend fun removeSavedNewsByUrl(url: String)
    suspend fun isNewsSaved(newsId: String): Boolean
    suspend fun isNewsUrlSaved(url: String): Boolean
    suspend fun getSavedNewsById(newsId: String): SavedNews?
    suspend fun getSavedNewsByUrl(url: String): SavedNews?
    suspend fun getSavedNewsCount(): Int
    suspend fun clearOldSavedNews(daysOld: Int = 30)
    fun searchSavedNews(query: String): Flow<List<SavedNews>>
    fun getSavedNewsBySource(sourceName: String): Flow<List<SavedNews>>
    fun getSavedNewsByAuthor(authorName: String): Flow<List<SavedNews>>
    suspend fun getAllAuthors(): List<String>
    suspend fun getAllSources(): List<String>
}