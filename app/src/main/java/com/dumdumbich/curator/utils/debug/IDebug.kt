package com.dumdumbich.curator.utils.debug

import android.util.Log


const val DEBUG_TAG = "DUMDUMBICH_CURATOR"

const val DEBUG_App: Boolean = false

const val DEBUG_MainActivity: Boolean = false

const val DEBUG_MenteeFragment: Boolean = false

const val DEBUG_MenteesFragment: Boolean = false
const val DEBUG_MenteesPresenter: Boolean = false
const val DEBUG_MenteesInteractor: Boolean = false

const val DEBUG_AboutFragment: Boolean = false

const val DEBUG_TablesInteractor: Boolean = true
const val DEBUG_TablesPresenter: Boolean = true
const val DEBUG_TablesFragment: Boolean = true

const val DEBUG_Database_Room: Boolean = true


interface IDebug {
    fun debugMessage(flag: Boolean, message: String) {
        if (flag) Log.d(DEBUG_TAG, message)
    }
}