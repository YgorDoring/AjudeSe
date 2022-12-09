package dev.ygordoring.ajude_se.ui.viewmodel

import dev.ygordoring.ajude_se.R
import dev.ygordoring.ajude_se.data.model.QuickAccess
import dev.ygordoring.ajude_se.data.model.MainItem

fun mountItems(mainItems: MutableList<MainItem>) {
    mainItems.clear()
    QuickAccess.values().forEach {
        mainItems.add(
            MainItem(
                it.id,
                getDrawableId(it),
                getTextStringId(it)
            )
        )
    }
}

fun getDrawableId(id: QuickAccess): Int {
    return when(id) {
        QuickAccess.IMC -> {  R.drawable.imc }
        QuickAccess.TMB -> {R.drawable.tmb }
        QuickAccess.WATER -> {R.drawable.water }
        QuickAccess.PHARM -> { R.drawable.pharm }
        QuickAccess.SUGES -> { R.drawable.sugest }
    }
}

fun getTextStringId(id: QuickAccess): Int {
    return when(id) {
        QuickAccess.IMC -> { R.string.label_imc }
        QuickAccess.TMB -> { R.string.label_tmb }
        QuickAccess.WATER -> { R.string.label_water }
        QuickAccess.PHARM -> { R.string.label_pharm }
        QuickAccess.SUGES -> { R.string.label_sugest }
    }
}

fun getActivity(id: QuickAccess): Class<*>  {
    return when (id) {
        QuickAccess.IMC -> { ImcActivity::class.java }
        QuickAccess.TMB -> { TmbActivity::class.java }
        QuickAccess.WATER -> { WaterCountActivity::class.java }
        QuickAccess.PHARM -> { PharmaciesActivity::class.java }
        QuickAccess.SUGES -> { SugestionsActivity::class.java }
    }
}