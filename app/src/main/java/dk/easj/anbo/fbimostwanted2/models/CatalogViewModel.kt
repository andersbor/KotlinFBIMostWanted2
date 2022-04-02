package dk.easj.anbo.fbimostwanted2.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dk.easj.anbo.fbimostwanted2.repository.FBIrepository

class CatalogViewModel : ViewModel() {
    private val repository = FBIrepository()
    var currentPage = 1
    val booksLiveData: LiveData<Catalog> = repository.catalogLiveData
    val errorMessageLiveData: LiveData<String> = repository.errorMessageLiveData

    init {
        reload()
    }

    fun reload() {
        repository.getCatalog(currentPage)
    }

    operator fun get(index: Int): Item? {
        return booksLiveData.value?.items?.get(index)
    }
}