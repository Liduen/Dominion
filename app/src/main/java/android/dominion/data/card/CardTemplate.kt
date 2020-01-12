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
    WORKSHOP(3, R.drawable.i_card_workshop),
    BUREAUCRAT(4, R.drawable.i_card_bureaucrat),
    GARDENS(4, R.drawable.i_card_gardens),
    MILITIA(4, R.drawable.i_card_militia),
    MONEYLENDER(4, R.drawable.i_card_moneylender),
    POACHER(4, R.drawable.i_card_poacher),
    REMODEL(4, R.drawable.i_card_remodel),
    SMITHY(4, R.drawable.i_card_smithy),
    THRONE_ROOM(4, R.drawable.i_card_throne_room),

    OASIS(3, R.drawable.i_card_oasis),

    PLATINUM(9, R.drawable.i_card_platinum);
}