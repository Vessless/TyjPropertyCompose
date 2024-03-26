package com.wycrm.tyjpropertycompose.repositories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreRepository @Inject constructor(private val dataStore: DataStore<Preferences>) {

    suspend fun putString(key: String, value: String) {
        val preferenceKey = stringPreferencesKey(key)
        dataStore.edit {
            it[preferenceKey] = value
        }
    }

    suspend fun putBoolean(key: String, value: Boolean) {
        val preferenceKey = booleanPreferencesKey(key)
        dataStore.edit {
            it[preferenceKey] = value
        }
    }

    suspend fun getString(key: String): String {
        val preferenceKey = stringPreferencesKey(key)
        val preference = dataStore.data.first()
        return preference[preferenceKey] ?: ""
    }


    suspend fun clearPreference(key: String) {
        val preferenceKey = stringPreferencesKey(key)
        dataStore.edit {
            if (it.contains(preferenceKey)) {
                it.remove(preferenceKey)
            }
        }
    }

}