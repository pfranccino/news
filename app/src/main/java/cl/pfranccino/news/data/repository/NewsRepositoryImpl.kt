package cl.pfranccino.news.data.repository

import cl.pfranccino.core.network.either.ApiError
import cl.pfranccino.core.network.either.Either
import cl.pfranccino.news.data.mapper.toDomain
import cl.pfranccino.news.data.network.ApiService
import cl.pfranccino.news.domain.model.NewsResponse
import cl.pfranccino.news.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val apiService: ApiService) : NewsRepository {
    override suspend fun getAllNews(): Either<ApiError, NewsResponse> {
        return apiService.getNews().map {
            it.toDomain()
        }
    }

    override suspend fun getNewsByCategory(category: String): Either<ApiError, NewsResponse> {
        return apiService.getNewsByCategory(category).map {
                it.toDomain()
            }
        }
}
