package cl.pfranccino.news.data.network


import cl.pfranccino.news.data.model.NewsResponseDTO
import cl.pfranccino.news.utils.either.ApiError
import cl.pfranccino.news.utils.either.Either
import retrofit2.http.GET

interface ApiService {
    @GET("everything?q=bitcoin")
    suspend fun getNews() : Either<ApiError, NewsResponseDTO>
}