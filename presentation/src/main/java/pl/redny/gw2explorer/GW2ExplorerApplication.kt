package pl.redny.gw2explorer

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import pl.redny.application.config.accountModule
import pl.redny.gw2explorer.config.viewModelModule
import pl.redny.infrastructure.config.retrofitModule

class GW2ExplorerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@GW2ExplorerApplication)
            modules(
                listOf(
                    retrofitModule,
                    accountModule,
                    viewModelModule
                )
            )
        }
    }
}