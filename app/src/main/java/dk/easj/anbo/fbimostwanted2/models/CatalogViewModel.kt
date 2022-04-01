package dk.easj.anbo.fbimostwanted2.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dk.easj.anbo.fbimostwanted.repository.FBIrepository

class CatalogViewModel : ViewModel() {
    private val repository = FBIrepository()
    val booksLiveData: LiveData<Catalog> = repository.catalogLiveData
    val errorMessageLiveData: LiveData<String> = repository.errorMessageLiveData

    init {
        reload()
    }

    fun reload() {
        repository.getCatalog()
    }

    operator fun get(index: Int): Item? {
        return booksLiveData.value?.items?.get(index)
    }
}