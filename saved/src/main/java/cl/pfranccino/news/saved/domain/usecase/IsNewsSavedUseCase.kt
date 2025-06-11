package cl.pfranccino.news.saved.domain.usecase

fun interface IsNewsSavedUseCase {
    suspend operator fun invoke(newsId: String): Boolean
}