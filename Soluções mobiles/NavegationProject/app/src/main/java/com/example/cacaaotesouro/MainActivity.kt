package com.example.cacaaotesouro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Definição das rotas de navegação
object Routes {
    const val HOME = "home"
    const val CLUE1 = "clue1"
    const val CLUE2 = "clue2"
    const val CLUE3 = "clue3"
    const val TREASURE = "treasure"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TreasureHuntApp()
                }
            }
        }
    }
}

@Composable
fun TreasureHuntApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        // Tela Inicial
        composable(Routes.HOME) {
            HomeScreen(navController)
        }

        // Tela de Pista 1
        composable(Routes.CLUE1) {
            ClueScreen(
                clueText = "Em uma casa há 4 cantos. Cada canto tem um gato. Cada gato vê 3 gatos. Quantos gatos existem no total?",
                correctAnswer = "5",
                currentRoute = Routes.CLUE1,
                navController = navController
            )
        }

        // Tela de Pista 2
        composable(Routes.CLUE2) {
            ClueScreen(
                clueText = "Qual é o número que, se você o vira de cabeça para baixo, continua sendo o mesmo?",
                correctAnswer = "8",
                currentRoute = Routes.CLUE2,
                navController = navController
            )
        }

        // Tela de Pista 3
        composable(Routes.CLUE3) {
            ClueScreen(
                clueText = "Eu sou alto quando sou jovem e baixo quando sou velho. O que sou?",
                correctAnswer = "vela",
                currentRoute = Routes.CLUE3,
                navController = navController
            )
        }

        // Tela do Tesouro
        composable(Routes.TREASURE) {
            TreasureScreen(navController)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Caça ao Tesouro",
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate(Routes.CLUE1) }) {
            Text("Iniciar Caça ao Tesouro")
        }
    }
}

@Composable
fun ClueScreen(
    clueText: String,
    correctAnswer: String,
    currentRoute: String,
    navController: NavController
) {
    // Estado para armazenar a resposta do usuário
    var userAnswer by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = clueText,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Campo de texto para resposta
        TextField(
            value = userAnswer,
            onValueChange = { userAnswer = it },
            label = { Text("Sua resposta") },
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (showError) {
            Text(
                text = "Resposta incorreta. Tente novamente!",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // Botões de navegação
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = { navController.navigateUp() }) {
                Text("Voltar")
            }

            Button(onClick = {
                if (userAnswer.trim().lowercase() == correctAnswer.lowercase()) {
                    // Navega para próxima pista ou tesouro
                    when (currentRoute) {
                        Routes.CLUE1 -> navController.navigate(Routes.CLUE2)
                        Routes.CLUE2 -> navController.navigate(Routes.CLUE3)
                        Routes.CLUE3 -> navController.navigate(Routes.TREASURE)
                    }
                } else {
                    showError = true
                }
            }) {
                Text("Próxima Pista")
            }
        }
    }
}

@Composable
fun TreasureScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Parabéns! Você encontrou o tesouro!",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(onClick = { navController.navigate(Routes.HOME) }) {
            Text("Recomeçar Caça ao Tesouro")
        }
    }
}