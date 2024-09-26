package cl.pfranccino.news.data.mapper

import cl.pfranccino.news.data.model.ArticleDTO
import cl.pfranccino.news.data.model.NewsResponseDTO
import cl.pfranccino.news.data.model.SourceDTO
import cl.pfranccino.news.domain.model.Article
import cl.pfranccino.news.domain.model.NewsResponse
import cl.pfranccino.news.domain.model.Source
import cl.pfranccino.news.utils.orZero

fun NewsResponseDTO?.toDomain() = NewsResponse(
    status = this?.status.orEmpty(),
    totalResults = this?.totalResults.orZero(),
    articles = this?.articles?.map { it.toDomain() } ?: listOf()
)

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
    id = this?.id.orEmpty(),
    name =  this?.name.orEmpty()
)