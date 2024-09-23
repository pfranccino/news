package cl.pfranccino.news.domain


interface NewsRepository {
    suspend fun getAllNews()
}