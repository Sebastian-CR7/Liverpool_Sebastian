package mx.edu.utez.liverpool_sebastian.models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ProductoViewModel : ViewModel() {

    var listaProductos = mutableStateOf<List<ProductDetail>>(emptyList())
        private set

    var textoBuscador = mutableStateOf("")

    init {
        cargarProductos()
    }

    private fun cargarProductos() {
        listaProductos.value = listOf(
            ProductDetail(
                id = "1",
                brand = "DIOR",
                name = "Perfume Sauvage",
                price = 2899.0,
                rating = 4.8f,
                reviewCount = 124,
                isFreeShipping = true,
                description = "Fragancia elegante ",
                image = null,
                reviews = listOf(
                    Review(userName = "Miguel M.", comment = "Excelente aroma", rating = 5.0f),
                    Review(userName = "Gerardo ", comment = "Llegó super tarde.", rating = 3f),
                    Review(userName = "Angel Jesus", comment = "Un perfume de muy hombre", rating = 4.5f),
                    Review(userName = "Esmeralda", comment = "El mejor regalo, le encanto", rating = 5f)
                )
            ),
            ProductDetail(
                id = "2",
                brand = "SAMSUNG",
                name = "Pantalla Smart TV 55\"",
                price = 9999.00,
                rating = 4.5f,
                reviewCount = 89,
                isFreeShipping = true,
                description = "Televisor inteligente ",
                image = null,
                reviews = listOf(
                    Review(userName = "Angel Jesus K.", comment = "La calidad de imagen es muy buena.", rating = 5.0f)
                )
            ),
            ProductDetail(
                id = "3",
                brand = "GAP",
                name = "Gorra Abierta",
                price = 367.00,
                rating = 4.2f,
                reviewCount = 35,
                isFreeShipping = false,
                description = "Gorra de buena calidad para pasear",
                image = null
            ),
            ProductDetail(
                id = "4",
                brand = "MICHAEL KORS",
                name = "Bolso Elegante de Mano",
                price = 2067.67,
                rating = 4.7f,
                reviewCount = 52,
                isFreeShipping = true,
                description = "Bolso espacioso y bonito",
                image = null
            )
        )
    }

    fun obtenerProductoPorId(id: String): ProductDetail? {
        return listaProductos.value.find { it.id == id }
    }

    fun toggleFavorito(id: String) {
        listaProductos.value = listaProductos.value.map { item ->
            if (item.id == id) {
                item.copy(isFavorite = !item.isFavorite)
            } else {
                item
            }
        }
    }
}