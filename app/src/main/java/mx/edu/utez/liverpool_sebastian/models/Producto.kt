package mx.edu.utez.liverpool_sebastian.models

import java.util.UUID

data class Review(
    val id: String = UUID.randomUUID().toString(),
    val userName: String,
    val comment: String,
    val rating: Float
)

data class ProductDetail(
    val id: String = UUID.randomUUID().toString(),
    val brand: String,
    val name: String,
    val price: Double,
    val rating: Float,
    val reviewCount: Int,
    val isFreeShipping: Boolean = true,
    val description: String,
    val image: Int?,
    val reviews: List<Review> = emptyList(),
    val isFavorite: Boolean = false
)
{
    fun obtenerPromedioCalificacion(): Float {
        if (reviews.isEmpty()) {
            return 0.0f
        }
        var suma = 0.0f
        for (opinion in reviews) {
            suma += opinion.rating
        }
        return suma / reviews.size
    }
}