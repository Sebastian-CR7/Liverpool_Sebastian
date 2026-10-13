package mx.edu.utez.liverpool_sebastian

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import mx.edu.utez.liverpool_sebastian.models.ProductoViewModel
import mx.edu.utez.liverpool_sebastian.screens.DetallesScreen
import mx.edu.utez.liverpool_sebastian.screens.ProductosScreen
import mx.edu.utez.liverpool_sebastian.screens.TituloLiverpoolScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    viewModel: ProductoViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio",
        modifier = modifier
    ) {
        composable("inicio") {
            TituloLiverpoolScreen(
                onIngresarClick = {
                    navController.navigate("productos")
                }
            )
        }

        composable("productos") {
            ProductosScreen(
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                },
                onProductoClick = { id ->
                    navController.navigate("detalles/$id")
                }
            )
        }

        composable(
            route = "detalles/{productoId}",
            arguments = listOf(navArgument("productoId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productoId = backStackEntry.arguments?.getString("productoId") ?: ""
            val producto = viewModel.obtenerProductoPorId(productoId)

            DetallesScreen(
                producto = producto,
                onBackClick = {
                    navController.popBackStack()
                },
                onToggleFavorito = { id ->
                    viewModel.toggleFavorito(id)
                }
            )
        }
    }
}