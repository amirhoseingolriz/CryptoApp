package ir.golriz.amirhosein.cryptoapp.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ir.golriz.amirhosein.cryptoapp.application.MyApp
import ir.golriz.amirhosein.cryptoapp.di.module.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class,
        ApplicationModule::class,
        NetworkModule::class,
        ImageModule::class,
        RepositoryModule::class
    ]
)
interface MainComponent : AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): MainComponent

    }

}