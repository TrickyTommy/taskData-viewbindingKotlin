package com.example.tommybinding

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tommybinding.di.DaggerApiComponent
import com.example.tommybinding.Model.Data
import com.example.tommybinding.Model.User
import com.example.tommybinding.UsersService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListViewModel : ViewModel() {

    @Inject
    lateinit var usersService: UsersService

    init {
        DaggerApiComponent.create().inject(this)
    }

    private val disposable = CompositeDisposable()

    val users = MutableLiveData<List<User>>()
    val userLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchUsers()
    }

    private fun fetchUsers() {
        loading.value = true
        disposable.add(
            usersService.getUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Data>() {
                    override fun onSuccess(data: Data) {
                        Log.d("error ", "" + data)
                        users.value = data.users
                        userLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        userLoadError.value = true
                        loading.value = false
                        Log.d("error ", "" + e.printStackTrace())
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}