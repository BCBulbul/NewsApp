package burakcanbulbul.com.newsapp.adapter

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.model.Article
import burakcanbulbul.com.newsapp.widget.OnRecyclerViewClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_list_item.view.*

class NewsRecyclerViewAdapter constructor(private val articles : ArrayList<Article>): RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {

    private lateinit var onRecyclerViewClickListener : OnRecyclerViewClickListener

    fun setOnRecyclerViewClickListener(onRecyclerViewClickListener: OnRecyclerViewClickListener){
        this.onRecyclerViewClickListener = onRecyclerViewClickListener
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

        fun bind(article : Article){
            itemView.news_list_item_time_text.text = article.publishedAt
            itemView.news_list_item_title.text = article.title
            Picasso.get().
                    load(article.urlToImage).
                    into(itemView.news_list_item_image)
            itemView.news_list_item_read_list_text.setOnClickListener {
                // buradad database işlemleri yapılacak
                Log.d("ReadListTıklandı",itemView.news_list_item_read_list_text.text.toString())
            }
        }
    }
}