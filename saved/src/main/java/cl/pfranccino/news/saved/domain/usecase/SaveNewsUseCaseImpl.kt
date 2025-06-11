package cl.pfranccino.news.saved.domain.usecase

import cl.pfranccino.news.saved.domain.model.SavedNews
import cl.pfranccino.news.saved.domain.repository.SavedRepository
import javax.inject.Inject

class SaveNewsUseCaseImpl @Inject constructor(
    private val repository: SavedRepository
) : SaveNewsUseCase {

    override suspend operator fun invoke(news: SavedNews) {
        validateNews(news)
        repository.saveNews(news)
    }

    override suspend fun saveMultiple(newsList: List<SavedNews>) {
        val validNews = newsList.filter { isValidNews(it) }
        validNews.forEach { news ->
            repository.saveNews(news)
        }
    }

    override suspend fun saveIfValid(news: SavedNews): Boolean {
        return if (isValidNews(news)) {
            repository.saveNews(news)
            true
        } else {
            false
        }
    }

    private fun validateNews(news: SavedNews) {
        if (news.title.isBlank()) {
            throw IllegalArgumentException("Title cannot be empty")
        }
        if (news.url.isBlank()) {
            throw IllegalArgumentException("URL cannot be empty")
        }
        if (news.publishedAt.isBlank()) {
            throw IllegalArgumentException("Published date cannot be empty")
        }
    }

    private fun isValidNews(news: SavedNews): Boolean {
        return news.title.isNotBlank() &&
                news.url.isNotBlank() &&
                news.publishedAt.isNotBlank()
    }
}