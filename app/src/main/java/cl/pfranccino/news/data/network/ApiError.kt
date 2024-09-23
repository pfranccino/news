package cl.pfranccino.news.data.network

data class ApiError(
    val status: String,
    val code: String,
    val message: String
)

class ApiException(val apiError: ApiError) : Exception(apiError.message)