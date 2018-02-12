package android.dominion.injection.component

import android.dominion.data.engine.DominionGameEngine
import android.dominion.injection.module.DominionGameEngineModule
import android.dominion.ui.viewModel.GameViewModel
import android.dominion.ui.viewModel.HostingViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by michaelkrakauer on 25/10/2017.
 */
@Singleton
@Component(modules = arrayOf(DominionGameEngineModule::class))
interface DominionComponent {

    fun provideDominionGameEngine(): DominionGameEngine

    fun injectHosting(instance: HostingViewModel?)
    fun injectGame(instance: GameViewModel?)
}