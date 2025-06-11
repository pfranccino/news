package cl.pfranccino.news.saved.domain.model

data class SavedNews(
    val id: String,
    val title: String,
    val description: String?,
    val imageUrl: String?,
    val publishedAt: String,
    val source: String,
    val url: String,
    val savedAt: Long,
    val author: String?,
    val content: String?
)