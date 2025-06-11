package cl.pfranccino.news.saved.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import cl.pfranccino.news.saved.data.local.dao.SavedNewsDao
import cl.pfranccino.news.saved.data.mapper.toDomain
import cl.pfranccino.news.saved.data.mapper.toEntity
import cl.pfranccino.news.saved.domain.model.SavedNews
import cl.pfranccino.news.saved.domain.repository.SavedRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SavedRepositoryImpl @Inject constructor(
    private val savedNewsDao: SavedNewsDao
) : SavedRepository {

    override fun getSavedNews(): Flow<List<SavedNews>> {
        return savedNewsDao.getAllSavedNews()
            .map { entities -> entities.map { it.toDomain() } }
    }

    override suspend fun saveNews(news: SavedNews) {
        savedNewsDao.saveNews(news.toEntity())
    }

    override suspend fun removeSavedNews(newsId: String) {
        savedNewsDao.removeSavedNews(newsId)
    }

    override suspend fun removeSavedNewsByUrl(url: String) {
        savedNewsDao.removeSavedNewsByUrl(url)
    }

    override suspend fun isNewsSaved(newsId: String): Boolean {
        return savedNewsDao.isNewsSaved(newsId)
    }

    override suspend fun isNewsUrlSaved(url: String): Boolean {
        return savedNewsDao.isNewsUrlSaved(url)
    }

    override suspend fun getSavedNewsById(newsId: String): SavedNews? {
        return savedNewsDao.getSavedNewsById(newsId)?.toDomain()
    }

    override suspend fun getSavedNewsByUrl(url: String): SavedNews? {
        return savedNewsDao.getSavedNewsByUrl(url)?.toDomain()
    }

    override suspend fun getSavedNewsCount(): Int {
        return savedNewsDao.getSavedNewsCount()
    }

    override suspend fun clearOldSavedNews(daysOld: Int) {
        val cutoffTime = System.currentTimeMillis() - (daysOld * 24 * 60 * 60 * 1000L)
        savedNewsDao.clearOldNews(cutoffTime)
    }

    override fun searchSavedNews(query: String): Flow<List<SavedNews>> {
        return savedNewsDao.searchSavedNews(query)
            .map { entities -> entities.map { it.toDomain() } }
    }

    override fun getSavedNewsBySource(sourceName: String): Flow<List<SavedNews>> {
        return savedNewsDao.getSavedNewsBySource(sourceName)
            .map { entities -> entities.map { it.toDomain() } }
    }

    // ✅ NUEVOS MÉTODOS
    override fun getSavedNewsByAuthor(authorName: String): Flow<List<SavedNews>> {
        return savedNewsDao.getSavedNewsByAuthor(authorName)
            .map { entities -> entities.map { it.toDomain() } }
    }

    override suspend fun getAllAuthors(): List<String> {
        return savedNewsDao.getAllAuthors()
    }

    override suspend fun getAllSources(): List<String> {
        return savedNewsDao.getAllSources()
    }
}