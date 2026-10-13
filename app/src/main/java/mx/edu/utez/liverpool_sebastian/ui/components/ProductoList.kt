package mx.edu.utez.liverpool_sebastian.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import mx.edu.utez.liverpool_sebastian.models.ProductDetail

@Composable
fun ProductoList(
    productos: List<ProductDetail>,
    onProductoClick: (ProductDetail) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(productos) { producto ->
            ProductoCard(
                producto = producto,
                onClick = { onProductoClick(producto) }
            )
        }
    }
}