package pl.redny.gw2explorer.config

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.redny.gw2explorer.ui.home.HomeViewModel
import pl.redny.gw2explorer.ui.wallet.WalletViewModel

class PresentationModules

val viewModelModule = module {
    viewModel {
        HomeViewModel()
        WalletViewModel(get())
    }
}