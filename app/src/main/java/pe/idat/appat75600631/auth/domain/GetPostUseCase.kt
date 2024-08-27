package pe.idat.appat75600631.auth.domain

import pe.idat.appat75600631.auth.data.network.response.Pacientes
import pe.idat.appat75600631.auth.data.network.response.Photo
import pe.idat.appat75600631.auth.data.repository.PostRepository
import javax.inject.Inject

class GetPostUseCase @Inject constructor(private val postRepository: PostRepository) {
    suspend fun getPacientes(): List<Pacientes> {
        return postRepository.getTodos()
    }

    suspend fun getPhotos(): List<Photo> {
        return postRepository.getPhotos()
    }
}