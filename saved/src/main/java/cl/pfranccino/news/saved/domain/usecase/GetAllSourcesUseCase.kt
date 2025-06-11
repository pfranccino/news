package cl.pfranccino.news.saved.domain.usecase



fun interface GetAllSourcesUseCase {
    suspend operator fun invoke(): List<String>
}