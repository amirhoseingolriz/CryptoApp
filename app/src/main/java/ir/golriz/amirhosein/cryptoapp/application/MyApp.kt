package ir.golriz.amirhosein.cryptoapp.application

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ir.golriz.amirhosein.cryptoapp.di.component.DaggerMainComponent

class MyApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMainComponent.builder()
            .application(this)
            .build()
    }
}