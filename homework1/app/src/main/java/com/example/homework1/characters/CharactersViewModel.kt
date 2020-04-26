package com.example.homework1.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework1.Provider
import com.example.homework1.network.models.Character
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {
    val charactersItems = MutableLiveData<List<Character>>()
    val charactersLoadingError = MutableLiveData<Boolean>()
    val charactersIsLoading = MutableLiveData<Boolean>()

    fun loadCharacters() {
        charactersIsLoading.postValue(true)
        viewModelScope.launch {
            val items =
                Provider.repository.loadCharacters()
            charactersIsLoading.postValue(false)
            if (items != null) {
                charactersItems.postValue(items)
            } else {
                charactersLoadingError.postValue(true)
            }

        }
    }
}
