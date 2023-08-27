package fl0wer.app

import android.app.Application
import coil.Coil
import coil.ImageLoader

internal class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initImageLoader()
    }

    private fun initImageLoader() {
        Coil.setImageLoader(
            ImageLoader.Builder(this)
                .respectCacheHeaders(false)
                .build()
        )
    }
}
