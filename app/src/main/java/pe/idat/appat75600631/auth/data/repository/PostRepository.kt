package pe.idat.appat75600631.auth.data.repository

import pe.idat.appat75600631.auth.data.network.response.Pacientes
import pe.idat.appat75600631.auth.data.network.response.Photo
import pe.idat.appat75600631.auth.data.network.service.PostService
import javax.inject.Inject

class PostRepository @Inject constructor(private val postService: PostService){
    suspend fun getTodos(): List<Pacientes> {
        return postService.getTodos()
    }
    suspend fun getPhotos(): List<Photo> {
        return postService.getPhotos().filter { it.albumId % 2 == 0 }
    }
}