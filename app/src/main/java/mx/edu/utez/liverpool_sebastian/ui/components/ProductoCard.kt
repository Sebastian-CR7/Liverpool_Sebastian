package mx.edu.utez.liverpool_sebastian.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardTravel
import androidx.compose.material.icons.filled.LocalPharmacy
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.edu.utez.liverpool_sebastian.models.ProductDetail

val RosaLiverpool = Color(0xFFDE004C)
val Fondo = Color(0xFFF3EDF7)

@Composable
fun ProductoCard(
    producto: ProductDetail,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Fondo, shape = RoundedCornerShape(12.dp)),
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
                        modifier = Modifier.size(50.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = producto.brand,
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray,
                fontSize = 10.sp
            )

            Text(
                text = producto.name,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp
            )

            Text(
                text = "$${producto.price}",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(containerColor = RosaLiverpool),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(text = "Ver detalle", color = Color.White, fontSize = 11.sp)
            }
        }
    }
}

fun obtenerIcono(id: String): ImageVector {
    return when (id) {
        "1" -> Icons.Default.LocalPharmacy
        "2" -> Icons.Default.Tv
        "3" -> Icons.Default.ShoppingBag
        "4" -> Icons.Default.CardTravel
        else -> Icons.Default.ShoppingBag
    }
}