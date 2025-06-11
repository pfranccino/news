package cl.pfranccino.news.saved.domain.usecase

fun interface GetSavedNewsCountUseCase {
    suspend operator fun invoke(): Int
}