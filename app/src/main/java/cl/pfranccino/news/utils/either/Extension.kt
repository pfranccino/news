package cl.pfranccino.news.utils.either

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


suspend fun <L, R, T> Either<L, R>.coEither(
    leftOperation: suspend (L) -> T,
    rightOperation: suspend (R) -> T
): T = withContext(Dispatchers.Default) {
    when (this@coEither) {
        is Either.Left -> leftOperation(value)
        is Either.Right -> rightOperation(value)
    }
}