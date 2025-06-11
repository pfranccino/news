package cl.pfranccino.news.saved.domain.usecase

fun interface GetAllAuthorsUseCase {
    suspend operator fun invoke(): List<String>
}