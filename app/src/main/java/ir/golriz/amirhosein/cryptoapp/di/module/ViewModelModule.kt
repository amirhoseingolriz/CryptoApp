package ir.golriz.amirhosein.cryptoapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.golriz.amirhosein.cryptoapp.di.key.ViewModelKey
import ir.golriz.amirhosein.cryptoapp.ui.coin_about.CoinAboutViewModel
import ir.golriz.amirhosein.cryptoapp.ui.main.MainViewModel
import ir.golriz.amirhosein.cryptoapp.utils.ViewModelFactory
import javax.inject.Provider

@Module
abstract class ViewModelModule {

    fun viewModelFactory(provideMap:Map<Class<out ViewModel>, Provider<ViewModel>>): ViewModelProvider.Factory{
        return ViewModelFactory(provideMap)
    }

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CoinAboutViewModel::class)
    abstract fun bindCoinAboutViewModel(coinAboutViewModel: CoinAboutViewModel): ViewModel


}