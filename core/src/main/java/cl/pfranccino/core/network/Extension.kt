package cl.pfranccino.core.network

// Función de extensión orZero para tipos numéricos
fun Int?.orZero(): Int = this ?: 0
fun Long?.orZero(): Long = this ?: 0L
fun Float?.orZero(): Float = this ?: 0f
fun Double?.orZero(): Double = this ?: 0.0
