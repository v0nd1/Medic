package com.huggydugy.medic.data.manger

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.huggydugy.medic.domain.manger.LocalUserManger
import com.huggydugy.medic.util.Constants
import com.huggydugy.medic.util.Constants.APP_ENTRY
import com.huggydugy.medic.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserMangerImpl(
    private val context: Context
): LocalUserManger {
    override suspend fun saveAppEntry() {
        context.datastore.edit {
            it[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.datastore.data.map {
            it[PreferencesKeys.APP_ENTRY] ?: false
        }
    }

}

private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}