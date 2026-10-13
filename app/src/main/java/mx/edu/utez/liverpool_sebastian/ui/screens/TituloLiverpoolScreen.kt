package mx.edu.utez.liverpool_sebastian.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.edu.utez.liverpool_sebastian.R
import mx.edu.utez.liverpool_sebastian.components.RosaLiverpool

@Composable
fun TituloLiverpoolScreen(
    onIngresarClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.liverpoollogo),
                contentDescription = "Imagen Principal",
                modifier = Modifier
                    .size(130.dp)
                    .padding(bottom = 16.dp)
            )



            Spacer(modifier = Modifier.height(120.dp))

            Button(
                onClick = onIngresarClick,
                colors = ButtonDefaults.buttonColors(containerColor = RosaLiverpool),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(48.dp)
            ) {
                Text(
                    text = "Ir a Catálogo",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}