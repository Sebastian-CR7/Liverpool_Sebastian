package mx.edu.utez.liverpool_sebastian.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.edu.utez.liverpool_sebastian.components.Fondo
import mx.edu.utez.liverpool_sebastian.components.RosaLiverpool
import mx.edu.utez.liverpool_sebastian.components.obtenerIcono
import mx.edu.utez.liverpool_sebastian.models.ProductDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetallesScreen(
    producto: ProductDetail?,
    onBackClick: () -> Unit,
    onToggleFavorito: (String) -> Unit
) {
    if (producto == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Producto no encontrado")
        }
        return
    }

    val promedioCalificacion = producto.obtenerPromedioCalificacion()
    val cantidadOpiniones = producto.reviews.size
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Regresar")
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Share, contentDescription = "Compartir")
                    }
                    IconButton(onClick = { onToggleFavorito(producto.id) }) {
                        Icon(
                            imageVector = if (producto.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorito",
                            tint = RosaLiverpool
                        )
                    }
                }
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = RosaLiverpool),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text("Comprar ahora", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Fondo),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        if (producto.image != null) {
                            Image(
                                painter = painterResource(id = producto.image),
                                contentDescription = producto.name,
                                modifier = Modifier.fillMaxSize()
                            )
                        } else {
                            Icon(
                                imageVector = obtenerIcono(producto.id),
                                contentDescription = producto.name,
                                tint = RosaLiverpool,
                                modifier = Modifier.size(90.dp)
                            )
                        }

                        Row(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 10.dp),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Box(modifier = Modifier.size(8.dp).background(RosaLiverpool, CircleShape))
                            Box(modifier = Modifier.size(8.dp).background(Color.LightGray, CircleShape))
                            Box(modifier = Modifier.size(8.dp).background(Color.LightGray, CircleShape))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    val estrellasLlenas = promedioCalificacion.toInt()
                    repeat(estrellasLlenas) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Estrella",
                            tint = Color(0xFFFFB800),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    repeat(5 - estrellasLlenas) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Estrella gris",
                            tint = Color.LightGray,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "${String.format("%.1f", promedioCalificacion)} ($cantidadOpiniones opiniones)",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                if (producto.isFreeShipping) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocalShipping,
                                contentDescription = "Envío",
                                tint = Color(0xFF2E7D32),
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Envío gratis", color = Color(0xFF2E7D32), fontSize = 12.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }

                Text(
                    text = producto.brand,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = producto.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "$${producto.price}",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = RosaLiverpool
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Descripción",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )

                Text(
                    text = producto.description,
                    fontSize = 13.sp,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Opiniones (${producto.reviews.size})",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(8.dp))
            }

            items(producto.reviews) { review ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = review.userName, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                            Text(text = "★ ${review.rating}", color = Color(0xFFFFB800), fontSize = 12.sp)
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = review.comment, fontSize = 12.sp, color = Color.DarkGray)
                    }
                }
            }
        }
    }
}