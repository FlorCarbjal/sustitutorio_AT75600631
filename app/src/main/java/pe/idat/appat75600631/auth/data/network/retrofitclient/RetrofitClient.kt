package pe.idat.appat75600631.auth.data.network.retrofitclient

import pe.idat.appat75600631.auth.data.network.response.Pacientes
import pe.idat.appat75600631.auth.data.network.response.Photo
import retrofit2.http.GET

interface RetrofitClient {
    @GET("todos")
    suspend fun getTodos(): List<Pacientes>

    @GET("photos")
    suspend fun getPhotos(): List<Photo>
}