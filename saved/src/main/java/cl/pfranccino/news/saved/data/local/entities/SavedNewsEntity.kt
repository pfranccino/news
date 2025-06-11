package cl.pfranccino.news.saved.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_news")
data class SavedNewsEntity(
    @PrimaryKey
    @androidx.room.ColumnInfo(name = "id")
    val id: String,
    @androidx.room.ColumnInfo(name = "title")
    val title: String,
    @androidx.room.ColumnInfo(name = "description")
    val description: String?,
    @androidx.room.ColumnInfo(name = "image_url")
    val imageUrl: String?,
    @androidx.room.ColumnInfo(name = "published_at")
    val publishedAt: String,
    @androidx.room.ColumnInfo(name = "source")
    val source: String,
    @androidx.room.ColumnInfo(name = "url")
    val url: String,
    @androidx.room.ColumnInfo(name = "saved_at")
    val savedAt: Long = System.currentTimeMillis(),
    @androidx.room.ColumnInfo(name = "author")
    val author: String?,
    @androidx.room.ColumnInfo(name = "content")
    val content: String?
)
