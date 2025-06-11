package cl.pfranccino.news.saved.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.pfranccino.news.saved.data.local.entities.SavedNewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedNewsDao {

    @Query("SELECT * FROM saved_news ORDER BY saved_at DESC")
    fun getAllSavedNews(): Flow<List<SavedNewsEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM saved_news WHERE id = :newsId)")
    suspend fun isNewsSaved(newsId: String): Boolean

    @Query("SELECT EXISTS(SELECT 1 FROM saved_news WHERE url = :url)")
    suspend fun isNewsUrlSaved(url: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNews(news: SavedNewsEntity)

    @Query("DELETE FROM saved_news WHERE id = :newsId")
    suspend fun removeSavedNews(newsId: String)

    @Query("DELETE FROM saved_news WHERE url = :url")
    suspend fun removeSavedNewsByUrl(url: String)

    @Query("DELETE FROM saved_news WHERE saved_at < :timestamp")
    suspend fun clearOldNews(timestamp: Long)

    @Query("SELECT COUNT(*) FROM saved_news")
    suspend fun getSavedNewsCount(): Int

    @Query("SELECT * FROM saved_news WHERE id = :newsId LIMIT 1")
    suspend fun getSavedNewsById(newsId: String): SavedNewsEntity?

    @Query("SELECT * FROM saved_news WHERE url = :url LIMIT 1")
    suspend fun getSavedNewsByUrl(url: String): SavedNewsEntity?

    @Query("""
        SELECT * FROM saved_news 
        WHERE title LIKE '%' || :searchQuery || '%' 
           OR description LIKE '%' || :searchQuery || '%'
           OR author LIKE '%' || :searchQuery || '%'
           OR content LIKE '%' || :searchQuery || '%'
        ORDER BY saved_at DESC
    """)
    fun searchSavedNews(searchQuery: String): Flow<List<SavedNewsEntity>>

    @Query("SELECT * FROM saved_news WHERE source = :sourceName ORDER BY saved_at DESC")
    fun getSavedNewsBySource(sourceName: String): Flow<List<SavedNewsEntity>>

    @Query("SELECT * FROM saved_news WHERE author = :authorName ORDER BY saved_at DESC")
    fun getSavedNewsByAuthor(authorName: String): Flow<List<SavedNewsEntity>>

    @Query("SELECT DISTINCT author FROM saved_news WHERE author IS NOT NULL ORDER BY author")
    suspend fun getAllAuthors(): List<String>

    @Query("SELECT DISTINCT source FROM saved_news ORDER BY source")
    suspend fun getAllSources(): List<String>
}