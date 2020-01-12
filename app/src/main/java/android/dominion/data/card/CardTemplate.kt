package android.dominion.data.card

import android.dominion.R
import androidx.annotation.DrawableRes

enum class CardTemplate(val cost: Int, @DrawableRes val imageResId: Int) {
    COPPER(0, R.drawable.i_card_copper),
    SILVER(3, R.drawable.i_card_silver),
    GOLD(6, R.drawable.i_card_gold),
    ESTATE(2, R.drawable.i_card_estate),
    DUCHY(5, R.drawable.i_card_duchy),
    PROVINCE(8, R.drawable.i_card_province),
    CURSE(0, R.drawable.i_card_curse),

    CELLAR(2, R.drawable.i_card_cellar),
    CHAPEL(2, R.drawable.i_card_chapel),
    MOAT(2, R.drawable.i_card_moat),
    HARBINGER(3, R.drawable.i_card_harbinger),
    MERCHANT(3, R.drawable.i_card_merchant),
    VASSAL(3, R.drawable.i_card_vassal),
    VILLAGE(3, R.drawable.i_card_village),

    OASIS(3, R.drawable.i_card_oasis),

    PLATINUM(9, R.drawable.i_card_platinum);
}