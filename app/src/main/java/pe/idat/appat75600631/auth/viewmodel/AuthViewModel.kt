package pe.idat.appat75600631.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.idat.appat75600631.auth.data.network.response.Pacientes
import pe.idat.appat75600631.auth.data.network.response.Photo
import pe.idat.appat75600631.auth.domain.GetPostUseCase
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val getPostUseCase: GetPostUseCase): ViewModel() {

    private val _todos = MutableLiveData<List<Pacientes>>()
    val todos: LiveData<List<Pacientes>> = _todos

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    fun fetchTodos() {
        viewModelScope.launch {
            val todos = getPostUseCase.getPacientes().sortedBy { it.id }
            _todos.value = todos
        }
    }

    fun fetchPhotos() {
        viewModelScope.launch {
            val photos = getPostUseCase.getPhotos()
            _photos.value = photos
        }
    }
}
