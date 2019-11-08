package burakcanbulbul.com.newsapp.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())


    }

    override fun getLayoutRes(): Int = R.layout.activity_main

}
