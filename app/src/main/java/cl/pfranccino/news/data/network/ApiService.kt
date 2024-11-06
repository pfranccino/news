package cl.pfranccino.news.data.network


import cl.pfranccino.news.data.model.NewsResponseDTO
import cl.pfranccino.news.utils.either.ApiError
import cl.pfranccino.news.utils.either.Either
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("everything?q=IA")
    suspend fun getNews() : Either<ApiError, NewsResponseDTO>

    @GET("everything")
    suspend fun getNewsByCategory(@Query("q") category: String): Either<ApiError, NewsResponseDTO>
}