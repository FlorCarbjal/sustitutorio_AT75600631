package pe.idat.appat75600631.auth.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pe.idat.appat75600631.auth.data.local.PacienteEntity
import pe.idat.appat75600631.auth.viewmodel.PacienteViewModel

@Composable
fun LoginScreen(viewModel: PacienteViewModel = hiltViewModel(), navController: NavController) {
    var codpaciente by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    // Definir la lista de pacientes
    val pacientesList = listOf(
        PacienteEntity("001", "password1", "Juan Perez", "999888777"),
        PacienteEntity("002", "password2", "Ana Gómez", "999777666"),
        PacienteEntity("003", "password3", "Luis Torres", "999666555")
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = codpaciente,
            onValueChange = { codpaciente = it },
            label = { Text("Código de Paciente") },
            modifier = Modifier.padding(16.dp)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(16.dp)
        )
        Button(
            onClick = {
                val paciente = pacientesList.find { it.codpaciente == codpaciente && it.password == password }
                if (paciente != null) {
                    viewModel.savePaciente(
                        PacienteEntity(
                            codpaciente = paciente.codpaciente,
                            password = paciente.password,
                            nombreApellido = paciente.nombreApellido,
                            celular = paciente.celular
                        )
                    )
                    Toast.makeText(context, "Login exitoso", Toast.LENGTH_SHORT).show()
                    navController.navigate("home") // Navega a la pantalla Home
                } else {
                    Toast.makeText(context, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Ingresar")
        }
    }
}
