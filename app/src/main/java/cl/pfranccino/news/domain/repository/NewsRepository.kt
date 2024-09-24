package cl.pfranccino.news.domain.repository


interface NewsRepository {
    suspend fun getAllNews()
}