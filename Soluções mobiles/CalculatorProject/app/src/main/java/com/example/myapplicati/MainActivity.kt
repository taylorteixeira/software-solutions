import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorApp()
        }
    }
}

@Composable
fun CalculatorApp() {
    var input by remember { mutableStateOf("0") }
    var result by remember { mutableStateOf(0.0) }
    var operation by remember { mutableStateOf("") }
    var lastInput by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = input,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().background(Color.LightGray).padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        val buttons = listOf(
            listOf("7", "8", "9", "/"),
            listOf("4", "5", "6", "*"),
            listOf("1", "2", "3", "-"),
            listOf("C", "0", "=", "+")
        )

        buttons.forEach { row ->
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                row.forEach { button ->
                    Button(
                        onClick = {
                            when (button) {
                                "C" -> {
                                    input = "0"
                                    result = 0.0
                                    operation = ""
                                    lastInput = 0.0
                                }
                                "=" -> {
                                    val secondNumber = input.toDoubleOrNull() ?: 0.0
                                    result = when (operation) {
                                        "+" -> lastInput + secondNumber
                                        "-" -> lastInput - secondNumber
                                        "*" -> lastInput * secondNumber
                                        "/" -> if (secondNumber != 0.0) lastInput / secondNumber else 0.0
                                        else -> secondNumber
                                    }
                                    input = result.toString()
                                    operation = ""
                                }
                                "+", "-", "*", "/" -> {
                                    lastInput = input.toDoubleOrNull() ?: 0.0
                                    operation = button
                                    input = "0"
                                }
                                else -> {
                                    input = if (input == "0") button else input + button
                                }
                            }
                        },
                        modifier = Modifier.size(80.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = button, fontSize = 24.sp)
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
