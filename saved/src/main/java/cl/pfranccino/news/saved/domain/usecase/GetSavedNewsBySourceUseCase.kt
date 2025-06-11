package cl.pfranccino.news.saved.domain.usecase

import cl.pfranccino.news.saved.domain.model.SavedNews
import kotlinx.coroutines.flow.Flow

fun interface GetSavedNewsBySourceUseCase {
    operator fun invoke(sourceName: String): Flow<List<SavedNews>>
}