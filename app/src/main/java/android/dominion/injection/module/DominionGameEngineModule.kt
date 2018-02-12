package android.dominion.injection.module

import android.dominion.data.engine.DominionGameEngine
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by michaelkrakauer on 28/10/2017.
 */
@Module
class DominionGameEngineModule {
    @Provides
    @Singleton
    fun provideDominionGameEngine(): DominionGameEngine {
        return DominionGameEngine()
    }
}