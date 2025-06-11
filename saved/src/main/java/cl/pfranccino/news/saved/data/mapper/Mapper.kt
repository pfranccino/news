package cl.pfranccino.news.saved.data.mapper

import cl.pfranccino.news.saved.data.local.entities.SavedNewsEntity
import cl.pfranccino.news.saved.domain.model.SavedNews


fun SavedNewsEntity.toDomain() = SavedNews(
    id = id,
    title = title,
    description = description,
    imageUrl = imageUrl,
    publishedAt = publishedAt,
    source = source,
    url = url,
    savedAt = savedAt,
    author = author,
    content = content
)

fun SavedNews.toEntity() = SavedNewsEntity(
    id = id,
    title = title,
    description = description,
    imageUrl = imageUrl,
    publishedAt = publishedAt,
    source = source,
    url = url,
    savedAt = savedAt,
    author = author,
    content = content
)


fun generateNewsId(url: String, publishedAt: String): String {
    return "${url.hashCode()}_${publishedAt.hashCode()}".replace("-", "")
}

fun createSavedNews(
    id: String,
    title: String,
    description: String?,
    imageUrl: String?,
    publishedAt: String,
    source: String,
    url: String,
    author: String? = null,
    content: String? = null
) = SavedNews(
    id = id,
    title = title,
    description = description,
    imageUrl = imageUrl,
    publishedAt = publishedAt,
    source = source,
    url = url,
    savedAt = System.currentTimeMillis(),
    author = author,
    content = content
)

fun List<SavedNewsEntity>.toDomain(): List<SavedNews> = map { it.toDomain() }
fun List<SavedNews>.toEntity(): List<SavedNewsEntity> = map { it.toEntity() }