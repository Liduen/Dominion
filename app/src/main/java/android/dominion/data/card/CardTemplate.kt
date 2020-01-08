package android.dominion.data.card

import android.dominion.R
import androidx.annotation.DrawableRes

enum class CardTemplate(@DrawableRes val imageResId: Int) {
    COPPER(R.drawable.i_card_copper),
    SILVER(R.drawable.i_card_silver),
    GOLD(R.drawable.i_card_gold),
    CURSE(R.drawable.i_card_curse),
    ESTATE(R.drawable.i_card_estate),
    DUCHY(R.drawable.i_card_duchy),
    PROVINCE(R.drawable.i_card_province),

    VILLAGE(R.drawable.i_card_village),

    OASIS(R.drawable.i_card_oasis),

    PLATINUM(R.drawable.i_card_platinum);
}