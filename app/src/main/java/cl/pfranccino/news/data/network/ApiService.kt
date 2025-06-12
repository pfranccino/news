package cl.pfranccino.news.data.network


import cl.pfranccino.core.network.either.ApiError
import cl.pfranccino.core.network.either.Either
import cl.pfranccino.news.data.model.NewsResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("everything?q=IA")
    suspend fun getNews() : Either<ApiError, NewsResponseDTO>

    @GET("everything")
    suspend fun getNewsByCategory(@Query("q") category: String): Either<ApiError, NewsResponseDTO>
}