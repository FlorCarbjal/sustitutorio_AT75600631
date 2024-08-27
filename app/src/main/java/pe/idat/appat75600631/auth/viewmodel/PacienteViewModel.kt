package pe.idat.appat75600631.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.idat.appat75600631.auth.data.local.PacienteEntity
import pe.idat.appat75600631.auth.data.repository.PacienteRepository
import javax.inject.Inject

@HiltViewModel
class PacienteViewModel @Inject constructor(
    private val repository: PacienteRepository
) : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult

    fun login(codpaciente: String, password: String) {
        viewModelScope.launch {
            val paciente = repository.getPaciente(codpaciente, password)
            if (paciente != null) {
                _loginResult.value = true
            } else {
                _loginResult.value = false
            }
        }
    }

    fun savePaciente(paciente: PacienteEntity) {
        viewModelScope.launch {
            repository.insertPaciente(paciente)
        }
    }
}