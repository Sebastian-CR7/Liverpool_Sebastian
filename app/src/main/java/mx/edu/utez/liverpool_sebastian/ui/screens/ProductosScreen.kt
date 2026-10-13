package mx.edu.utez.liverpool_sebastian.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import mx.edu.utez.liverpool_sebastian.components.ProductoList
import mx.edu.utez.liverpool_sebastian.components.RosaLiverpool
import mx.edu.utez.liverpool_sebastian.models.ProductoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductosScreen(
    viewModel: ProductoViewModel,
    onBackClick: () -> Unit,
    onProductoClick: (String) -> Unit
) {
    val productos = viewModel.listaProductos.value

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Atrás",
                        tint = Color.Black
                    )
                }

                OutlinedTextField(
                    value = viewModel.textoBuscador.value,
                    onValueChange = { viewModel.textoBuscador.value = it },
                    placeholder = { Text("Buscar...") },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.LightGray
                    )
                )

                Spacer(modifier = Modifier.width(6.dp))

                IconButton(
                    onClick = {  },
                    modifier = Modifier
                        .size(46.dp)
                        .background(RosaLiverpool, shape = RoundedCornerShape(12.dp))
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar",
                        tint = Color.White
                    )
                }
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            ProductoList(
                productos = productos,
                onProductoClick = { producto ->
                    onProductoClick(producto.id)
                }
            )
        }
    }
}