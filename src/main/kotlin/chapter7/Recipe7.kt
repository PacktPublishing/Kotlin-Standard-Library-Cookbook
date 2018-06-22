package chapter7

import com.google.gson.annotations.SerializedName
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Chapter: Making Asynchronous programming great again
 * Recipe: Building REST API client with Retrofit and coroutines adapter
 */
fun main(vararg args: String) = runBlocking {
    val api: GithubApi = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(GithubApi::class.java)

    api.searchRepositories("Kotlin").await().list.map { println(it) }
    Unit
}

interface GithubApi {
    // Api docs:
    // https://developer.github.com/v3/search/#search-repositories
    // example call https://api.github.com/search/repositories?q=iosched
    @GET("/search/repositories")
    fun searchRepositories(@Query("q") searchQuery: String): Deferred<SearchRepositoriesResponse>

}

data class SearchRepositoriesResponse(@SerializedName("items") val list: Collection<Repository>)
data class Repository(val id: Long?,
                      val name: String?,
                      val description: String?,
                      @SerializedName("full_name") val fullName: String?,
                      @SerializedName("html_url") val url: String?,
                      @SerializedName("stargazers_count") val stars: Long?)

