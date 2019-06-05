package com.example.coincap.viewModels

import androidx.lifecycle.*
import com.example.coincap.commons.DataWrapper
import com.example.coincap.data.CoinCapApiInterface
import com.example.coincap.data.CoinListing
import com.example.coincap.data.Status
import com.example.coincap.di.CoinCapComponent
import com.example.coincap.di.CoinModule
import com.example.coincap.di.CoreModule
import com.example.coincap.di.DaggerCoinCapComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CoinCapViewModel:ViewModel(), LifecycleObserver {

    @Inject
    lateinit var coinCapComponent: CoinCapComponent

    @Inject
    lateinit var coinCapApiInterface: CoinCapApiInterface

    private val compositeDisposable = CompositeDisposable()

    init {
        buildComponent()
    }

    fun getCoinResults(): LiveData<DataWrapper<CoinListing>> {
        val mutableLiveData = MutableLiveData<DataWrapper<CoinListing>>()
        val disposable = coinCapApiInterface.getLatestCryptoListing()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ coinListResult ->
                mutableLiveData.value = DataWrapper(coinListResult, null)
            }, { t: Throwable? ->
                run {
                    mutableLiveData.value =
                        DataWrapper(CoinListing(mutableListOf(), Status(0,0,0,"error","1234345355")), t!!.message)
                }
            })
        compositeDisposable.add(disposable)
        return mutableLiveData
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun unsubscribeViewModel() {
        compositeDisposable.clear()
    }


    override fun onCleared() {
        unsubscribeViewModel()
        super.onCleared()
    }

    private fun buildComponent() {
        coinCapComponent= DaggerCoinCapComponent.builder()
            .build()
        coinCapComponent.inject(this)
    }
}