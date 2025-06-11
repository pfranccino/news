package cl.pfranccino.news.saved.domain.usecase

fun interface IsNewsUrlSavedUseCase {
    suspend operator fun invoke(url: String): Boolean
}