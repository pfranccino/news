package cl.pfranccino.news.data.repository

import cl.pfranccino.news.data.network.ApiService
import cl.pfranccino.news.domain.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor( private val apiService: ApiService) : NewsRepository {
    override suspend fun getAllNews() {
    }

}