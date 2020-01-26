package at.fh.swengb.lesch

import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

object MovieAPI {
    const val accessToken = "ff2c1eea-dc90-4c4b-b5e2-f44b74c4c28c"
    val retrofit: Retrofit
    val retrofitService: MovieApiService

    init {
        val moshi = Moshi.Builder().build()
        retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://movies.bloder.xyz")
            .build()
        retrofitService = retrofit.create(MovieApiService::class.java)
    }
}
interface MovieApiService {
    @GET("/${MovieAPI.accessToken}/movies")
    fun movies(): Call<List<Movie>>

    @GET("/${MovieAPI.accessToken}/movies/{id}")
    fun movieById(@Path("id") movieId: String): Call<MovieDetail>

    @POST("/${MovieAPI.accessToken}/movies/{id}/rate")
    fun rateMovie(@Path("id") movieId: String, @Body rating: Review): Call<Unit>
}