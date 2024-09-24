package cl.pfranccino.news.data.repository

import cl.pfranccino.news.data.model.NewsResponseDTO
import cl.pfranccino.news.data.network.ApiService
import cl.pfranccino.news.domain.repository.NewsRepository
import cl.pfranccino.news.utils.either.ApiError
import cl.pfranccino.news.utils.either.Either
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val apiService: ApiService) : NewsRepository {
    override suspend fun getAllNews(): Either<ApiError, NewsResponseDTO> {
        return apiService.getNews()
    }
}
