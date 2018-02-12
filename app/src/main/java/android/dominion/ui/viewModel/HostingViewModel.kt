package android.dominion.ui.viewModel

import android.content.Context
import android.content.Intent
import android.databinding.ObservableField
import android.dominion.data.PlayerType
import android.dominion.data.engine.DominionGameEngine
import android.dominion.data.engine.player.AggressivePlayer
import android.dominion.data.engine.player.BigMoneyPlayer
import android.dominion.injection.component.DaggerDominionComponent
import android.dominion.ui.activity.GameActivity
import android.dominion.ui.adapter.PlayerListAdapter
import android.dominion.ui.base.BaseViewModel
import android.dominion.ui.provider.Navigator
import android.os.Bundle
import javax.inject.Inject

/**
 * Created by michaelkrakauer on 17/11/2017.
 */
class HostingViewModel(private val navigator: Navigator) : BaseViewModel() {
    @Inject
    lateinit var gameEngine: DominionGameEngine
    val players = ObservableField<MutableList<PlayerType>>(mutableListOf())
    val listAdapter = ObservableField(PlayerListAdapter(players.get(), this::addPlayer, this::updateList))

    private fun updateList(position: Int, playerType: PlayerType) {
        players.get()[position] = playerType
        listAdapter.get().updateList(players.get())
    }

    override fun attachView(context: Context, bundle: Bundle?) {
        super.attachView(context, bundle)
        DaggerDominionComponent.builder().build().injectHosting(this)
        players.set(mutableListOf())
    }

    private fun addPlayer() {
        if (players.get().count() < 4) {
            players.get().add(PlayerType.values().first())
            listAdapter.get().updateList(players.get())
        }
    }

    fun startGame() {
        players.get().forEach {
            when (it) {
                PlayerType.AGGRESSIVE -> gameEngine.register(AggressivePlayer())
                PlayerType.GREEDY -> gameEngine.register(BigMoneyPlayer())
                else -> {
                }
            }
        }
        navigator.startActivity(Intent(context, GameActivity::class.java))
    }
}