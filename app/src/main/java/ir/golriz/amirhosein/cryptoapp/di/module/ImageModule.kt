package ir.golriz.amirhosein.cryptoapp.di.module

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageModule {

    @Singleton
    @Provides
    fun provideGlide(context: Context): RequestManager {
        return Glide.with(context)
    }

}