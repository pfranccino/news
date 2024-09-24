package cl.pfranccino.news.either

data class ApiError(
    val status: String,
    val code: String,
    val message: String
)