package cl.pfranccino.news.data.mapper

import cl.pfranccino.news.data.model.ArticleDTO
import cl.pfranccino.news.data.model.NewsResponseDTO
import cl.pfranccino.news.data.model.SourceDTO
import cl.pfranccino.news.domain.model.Article
import cl.pfranccino.news.domain.model.NewsResponse
import cl.pfranccino.news.domain.model.Source

fun NewsResponseDTO?.toDomain() = NewsResponse(
    status = this?.status ?: "",
    totalResults = this?.totalResults ?: 0,
    articles = this?.articles?.map { it.toDomain() } ?: listOf()
)

fun ArticleDTO?.toDomain() = Article(
    source = this?.source.toDomainModel(),
    author = this?.author ?: "",
    title = this?.title ?: "",
    description = this?.description ?: "",
    url = this?.url ?: "",
    urlToImage = this?.urlToImage ?: "",
    publishedAt = this?.publishedAt ?:"",
    content = this?.content ?: ""
)

fun SourceDTO?.toDomainModel() = Source(
    id = this?.id ?: "",
    name =  this?.name ?: ""
)