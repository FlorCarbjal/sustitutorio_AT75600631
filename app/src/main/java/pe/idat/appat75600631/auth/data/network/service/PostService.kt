package pe.idat.appat75600631.auth.data.network.service

import pe.idat.appat75600631.auth.data.network.response.Pacientes
import pe.idat.appat75600631.auth.data.network.response.Photo
import pe.idat.appat75600631.auth.data.network.retrofitclient.RetrofitClient
import javax.inject.Inject

class PostService @Inject constructor(private val retrofitClient: RetrofitClient) {
    suspend fun getTodos(): List<Pacientes> {
        return retrofitClient.getTodos()
    }
    suspend fun getPhotos(): List<Photo> {
        return retrofitClient.getPhotos()
    }
}