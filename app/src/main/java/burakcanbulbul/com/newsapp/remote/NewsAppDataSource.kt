package burakcanbulbul.com.newsapp.remote

import burakcanbulbul.com.newsapp.constants.NewsConstants
import burakcanbulbul.com.newsapp.model.DataSource
import burakcanbulbul.com.newsapp.model.Headlines
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAppDataSource {

    @GET("/v2/sources?apiKey="+NewsConstants.NEWS_API_KEY)
    fun getSources() : Call<DataSource>

    @GET("/v2/top-headlines?country=us&apiKey="+NewsConstants.NEWS_API_KEY)
    fun getArticleHeadlines() : Call<Headlines>

}