package cl.pfranccino.news.saved.domain.model

data class SearchFilters(
    val source: String? = null,
    val author: String? = null,
    val dateFrom: Long? = null,
    val dateTo: Long? = null
)