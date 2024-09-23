package cl.pfranccino.news.data.network


import retrofit2.http.GET

interface ApiService {
    @GET("news")
    suspend fun getNews()
}