package cl.pfranccino.news.data.mapper

import cl.pfranccino.core.network.orZero
import cl.pfranccino.news.data.model.ArticleDTO
import cl.pfranccino.news.data.model.NewsResponseDTO
import cl.pfranccino.news.data.model.SourceDTO
import cl.pfranccino.news.domain.model.Article
import cl.pfranccino.news.domain.model.NewsResponse
import cl.pfranccino.news.domain.model.Source
import cl.pfranccino.news.saved.domain.model.SavedNews

fun NewsResponseDTO?.toDomain() = NewsResponse(
    status = this?.status.orEmpty(),
    totalResults = this?.totalResults.orZero(),
    articles = this?.articles?.filter { it.urlToImage?.isNotEmpty() == true }?.map { it.toDomain() }
        ?: listOf())

fun ArticleDTO?.toDomain() = Article(
    source = this?.source.toDomainModel(),
    author = this?.author.orEmpty(),
    title = this?.title.orEmpty(),
    description = this?.description.orEmpty(),
    url = this?.url.orEmpty(),
    urlToImage = this?.urlToImage.orEmpty(),
    publishedAt = this?.publishedAt.orEmpty(),
    content = this?.content.orEmpty()
)

fun SourceDTO?.toDomainModel() = Source(
    id = this?.id.orEmpty(), name = this?.name.orEmpty()
)


fun Article.toSavedNews() = SavedNews(
    id = generateArticleId(url, publishedAt),
    title = title,
    description = description,
    imageUrl = urlToImage,
    publishedAt = publishedAt,
    source = source.name,
    url = url,
    savedAt = System.currentTimeMillis(),
    author = author,
    content = content
)

fun SavedNews.toArticle() = Article(
    source = Source(id = "", name = source),
    author = author ?: "",
    title = title,
    description = description ?: "",
    url = url,
    urlToImage = imageUrl ?: "",
    publishedAt = publishedAt,
    content = content.orEmpty()
)

private fun generateArticleId(url: String, publishedAt: String): String {
    return "${url.hashCode()}_${publishedAt.hashCode()}".replace("-", "")
}

fun Article.getNewsId(): String = generateArticleId(url, publishedAt)

fun Article.isValid(): Boolean {
    return title.isNotBlank() && url.isNotBlank() && publishedAt.isNotBlank()
}

fun List<Article>.toSavedNews(): List<SavedNews> = map { it.toSavedNews() }
fun List<SavedNews>.toArticles(): List<Article> = map { it.toArticle() }