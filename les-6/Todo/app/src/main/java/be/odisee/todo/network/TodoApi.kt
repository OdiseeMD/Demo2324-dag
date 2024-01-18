package be.odisee.todo.network

import be.odisee.todo.model.ListResponse
import be.odisee.todo.model.StringResponse
import be.odisee.todo.model.Todo
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

val BASE_URL = "https://odisee-todo.azurewebsites.net/"

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .build()


interface TodoApiService {

    /*
    {
        "status": "success",
         "message": []
    }
     */
    @GET("todo")
    suspend fun getItems(): ListResponse

    @POST("todo/{id}/check")
    suspend fun checkItem(@Path("id") todoId: String)

    @POST("todo/{id}/uncheck")
    suspend fun uncheckItem(@Path("id") todoId: String)

    @POST("todo")
    suspend fun addTodo(@Body item: Todo): StringResponse
}

object TodoApi {
    val retrofitService by lazy {
        retrofit.create(TodoApiService::class.java)
    }
}

