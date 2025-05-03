package com.example.mvvm

import android.app.Application
import com.example.core_module.di.databaseModule
import com.example.core_module.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(databaseModule)
            modules(viewModelModule)
        }
    }
}