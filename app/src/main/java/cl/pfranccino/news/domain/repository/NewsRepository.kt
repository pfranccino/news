package cl.pfranccino.news.domain.repository

import cl.pfranccino.news.data.model.NewsResponseDTO
import cl.pfranccino.news.utils.either.ApiError
import cl.pfranccino.news.utils.either.Either


interface NewsRepository {
    suspend fun getAllNews() : Either<ApiError, NewsResponseDTO>
}