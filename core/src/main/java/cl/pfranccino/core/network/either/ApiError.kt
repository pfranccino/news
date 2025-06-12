package cl.pfranccino.core.network.either

data class ApiError(
    val status: String,
    val code: String,
    val message: String
)