package az.khayalsharifli.noteapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import az.khayalsharifli.noteapp.di.dataModule
import az.khayalsharifli.noteapp.di.domainModule
import az.khayalsharifli.noteapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(androidContext = this@App)

            val modules = listOf(dataModule, domainModule, presentationModule)
            modules(modules)
        }
        // Close Dark Mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}