package ir.golriz.amirhosein.cryptoapp.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.golriz.amirhosein.cryptoapp.ui.coin_about.CoinAboutActivity
import ir.golriz.amirhosein.cryptoapp.ui.main.MainActivity

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeCoinAboutActivity(): CoinAboutActivity

}


