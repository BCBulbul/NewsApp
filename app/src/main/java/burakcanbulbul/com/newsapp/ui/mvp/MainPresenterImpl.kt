package burakcanbulbul.com.newsapp.ui.mvp

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent

abstract class MainPresenterImpl<Any> : MainPresenter, LifecycleObserver {

    var mainView : MainView? = null

    fun MainPresenterImpl(mainView : MainView?){
        this.mainView = mainView
        (mainView as LifecycleOwner).lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    override fun onResume() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onDestroy() {
        getLifeCycle().removeObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun onPause() {

    }

    fun getLifeCycle(): Lifecycle {
        return (mainView as LifecycleOwner).lifecycle
    }


}