@file:Suppress("UNCHECKED_CAST")

package ir.golriz.amirhosein.cryptoapp.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory
@Inject constructor(private val viewModelMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelMap[modelClass]!!.get() as T
    }

}