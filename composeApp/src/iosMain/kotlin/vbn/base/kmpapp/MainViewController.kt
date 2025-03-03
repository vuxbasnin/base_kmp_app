package vbn.base.kmpapp

import androidx.compose.ui.window.ComposeUIViewController
import vbn.base.kmpapp.app.App
import vbn.base.kmpapp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}