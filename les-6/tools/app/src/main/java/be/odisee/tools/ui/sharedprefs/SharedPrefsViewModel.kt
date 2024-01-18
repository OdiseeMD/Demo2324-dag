package be.odisee.tools.ui.sharedprefs

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

val Context.dataStore by preferencesDataStore(name = "settings")

class SharedPrefsViewModel(application: Application) : AndroidViewModel(application) {
    private val _state = MutableStateFlow(SharedPrefsUiState())
    val state = _state.asStateFlow()
    private val preferenceKey = stringPreferencesKey("name")
    private val agePreferenceKey = intPreferencesKey("age")

    init {
        // execute once
        viewModelScope.launch {
            val nameFlow = getApplication<Application>().dataStore.data.map {
                it[preferenceKey]
            }
            _state.update {
                it.copy(name = nameFlow.first() ?: "")
            }
        }

        // React on changes in the datastore
        viewModelScope.launch {
            val nameFlow = getApplication<Application>().dataStore.data.map {
                it[preferenceKey]
            }

            nameFlow.collectLatest { name ->
                _state.update {
                    it.copy(name = name ?: "")
                }
            }
        }
    }

    fun onNameChanged(name: String) {
        _state.update {
            it.copy(name = name)
        }
        viewModelScope.launch {
            getApplication<Application>().dataStore.edit { preferences ->
                preferences[preferenceKey] = name
                preferences[agePreferenceKey] = 12
                // { "name": "matthias"}
            }

            getApplication<Application>().dataStore.edit { preferences ->
                preferences.remove(agePreferenceKey)
            }
        }
    }
}
