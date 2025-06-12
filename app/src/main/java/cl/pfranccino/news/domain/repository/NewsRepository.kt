package cl.pfranccino.news.domain.repository

import cl.pfranccino.core.network.either.ApiError
import cl.pfranccino.core.network.either.Either
import cl.pfranccino.news.domain.model.NewsResponse


interface NewsRepository {
    suspend fun getAllNews() : Either<ApiError, NewsResponse>

    suspend fun getNewsByCategory(category: String) : Either<ApiError, NewsResponse>
}