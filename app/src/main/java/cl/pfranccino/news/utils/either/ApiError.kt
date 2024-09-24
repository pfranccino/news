package cl.pfranccino.news.utils.either

data class ApiError(
    val status: String,
    val code: String,
    val message: String
)