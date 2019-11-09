package burakcanbulbul.com.newsapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.model.DataSource
import burakcanbulbul.com.newsapp.model.Source
import kotlinx.android.synthetic.main.news_list_custom_layout.view.*


class NewsListAdapter constructor(private var dataSource: DataSource) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val source : Source = dataSource.sources[position]
        val view : View = LayoutInflater.from(parent?.context).inflate(R.layout.news_list_custom_layout,parent,false)
        view.news_description.text = source.description
        view.news_source.text = source.name
        return view
    }

    override fun getItem(position: Int): Any = dataSource.sources[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = dataSource.sources.size


}