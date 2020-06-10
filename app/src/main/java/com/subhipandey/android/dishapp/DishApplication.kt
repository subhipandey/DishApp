package com.subhipandey.android.dishapp

import android.app.Application
import com.subhipandey.android.dishapp.data.database.AppDatabase
import com.subhipandey.android.dishapp.data.network.Api
import com.subhipandey.android.dishapp.data.network.NetworkConnectionInterceptor
import com.subhipandey.android.dishapp.data.repository.QuotesRepository
import com.subhipandey.android.dishapp.data.repository.UserRepo
import com.subhipandey.android.dishapp.ui.auth.AuthViewModelFactory
import com.subhipandey.android.dishapp.ui.home.profile.ProfileViewModelFactory
import com.subhipandey.android.dishapp.ui.home.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class DishApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@DishApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton {Api(instance())}
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepo(instance(), instance())}
        bind() from singleton { QuotesRepository(instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider {QuotesViewModelFactory(instance())}
    }
}