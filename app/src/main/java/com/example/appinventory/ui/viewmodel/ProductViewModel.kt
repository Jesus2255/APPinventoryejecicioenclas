package com.example.appinventory.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appinventory.data.model.Product
import com.example.appinventory.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val repository = ProductRepository()

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                _products.value = repository.getProducts()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun addProduct(product: Product) {
        viewModelScope.launch {
            try {
                repository.addProduct(product)
                fetchProducts() // Refresh the list
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

     fun updateProduct(id: Int, product: Product) {
        viewModelScope.launch {
            try {
                repository.updateProduct(id, product)
                fetchProducts() // Refresh the list
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun deleteProduct(id: Int) {
        viewModelScope.launch {
            try {
                repository.deleteProduct(id)
                fetchProducts() // Refresh the list
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun searchProduct(name: String) {
        viewModelScope.launch {
            try {
                _products.value = repository.searchProductByName(name)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
