package burakcanbulbul.com.newsapp.remote

import android.content.Context
import burakcanbulbul.com.newsapp.constants.NewsConstants
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAppDataSourceBuilder {

    private lateinit var context : Context

    fun with(context : Context) : NewsAppDataSourceBuilder{
        this.context = context
        return this
    }

    fun build(gson : Gson) : NewsAppDataSource{
        val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl(NewsConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()


        return retrofit.create(NewsAppDataSource :: class.java)
    }

}