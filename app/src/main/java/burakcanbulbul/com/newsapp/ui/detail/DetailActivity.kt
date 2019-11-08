package burakcanbulbul.com.newsapp.ui.detail


import android.os.Bundle
import android.os.PersistableBundle
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.base.BaseActivity

class DetailActivity : BaseActivity() {


    override fun getLayoutRes(): Int = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(getLayoutRes())
    }
}