package pe.idat.appat75600631.auth.data.repository

import pe.idat.appat75600631.auth.data.local.PacienteDao
import pe.idat.appat75600631.auth.data.local.PacienteEntity
import javax.inject.Inject

class PacienteRepository @Inject constructor(
    private val pacienteDao: PacienteDao
) {
    suspend fun insertPaciente(paciente: PacienteEntity) {
        pacienteDao.insertPaciente(paciente)
    }

    suspend fun getPaciente(codpaciente: String, password: String): PacienteEntity? {
        return pacienteDao.getPaciente(codpaciente, password)
    }
}