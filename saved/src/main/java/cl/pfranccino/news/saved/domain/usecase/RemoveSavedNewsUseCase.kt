package cl.pfranccino.news.saved.domain.usecase

fun interface RemoveSavedNewsUseCase {
    suspend operator fun invoke(newsId: String)
}