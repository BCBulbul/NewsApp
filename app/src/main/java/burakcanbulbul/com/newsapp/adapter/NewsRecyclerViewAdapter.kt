package burakcanbulbul.com.newsapp.adapter

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.data.local.db.data.AppDatabase
import burakcanbulbul.com.newsapp.model.Article
import burakcanbulbul.com.newsapp.model.News
import burakcanbulbul.com.newsapp.widget.OnRecyclerViewClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_list_item.view.*
import javax.inject.Inject

class NewsRecyclerViewAdapter constructor(private var context : Context,private val articles : ArrayList<Article>): RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {

    private lateinit var onRecyclerViewClickListener : OnRecyclerViewClickListener
    private lateinit var appDatabase: AppDatabase

    fun setOnRecyclerViewClickListener(onRecyclerViewClickListener: OnRecyclerViewClickListener){
        this.onRecyclerViewClickListener = onRecyclerViewClickListener
    }

    fun setAppDatabase(appDatabase: AppDatabase){
        this.appDatabase = appDatabase
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_list_item,parent,false))

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { holder.bind(articles[position]) }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        init {itemView.setOnClickListener(this)}

        override fun onClick(view: View?) {
            onRecyclerViewClickListener.onRecyclerViewClick(view, adapterPosition)
        }

        // holder'in bağlandığı ve değerlerin bastırıldığı method ayrıca database ekleme çıkarma işlemleri burada yapılıyor
        fun bind(article : Article){
            var counter : Int = 0
            val new : News = News(counter,article.author,article.title,article.set,article.description,
                    article.url,article.urlToImage,article.publishedAt,article.content)
            itemView.news_list_item_time_text.text = article.publishedAt
            itemView.news_list_item_title.text = article.title
            Picasso.get().
                    load(article.urlToImage).
                    into(itemView.news_list_item_image)
            itemView.news_list_item_read_list_text.setOnClickListener {
                if(counter % 2 == 0){
                    itemView.news_list_item_read_list_text.text = "Okuma Listemden Çıkar"
                    AsyncTask.execute {
                        appDatabase.newsDao().insertAllNews(new)
                    }
                    Toast.makeText(context,"Haber okuma listesine eklendi",Toast.LENGTH_SHORT).show()

                }else{
                    itemView.news_list_item_read_list_text.text = "Okuma Listeme Ekle"
                    AsyncTask.execute {
                        appDatabase.newsDao().deleteNew(new)
                    }
                    Toast.makeText(context,"Haber okuma listesinden çıkarıldı",Toast.LENGTH_SHORT).show()

                }
                counter++
            }
        }
    }
}