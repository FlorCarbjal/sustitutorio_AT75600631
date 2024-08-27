package pe.idat.appat75600631.auth.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pacientes")
data class PacienteEntity(
    @PrimaryKey
    val codpaciente: String,
    val password: String,
    val nombreApellido: String,
    val celular: String
)
