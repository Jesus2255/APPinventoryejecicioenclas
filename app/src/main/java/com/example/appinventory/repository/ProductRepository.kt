package com.example.appinventory.repository

import com.example.appinventory.data.model.Product
import com.example.appinventory.data.network.ProductApiService
import com.example.appinventory.data.network.RetrofitInstance

class ProductRepository {
    private val productService: ProductApiService = RetrofitInstance.api

    suspend fun getProducts(): List<Product> {
        return productService.getProducts()
    }

    suspend fun addProduct(product: Product) {
        productService.createProduct(product)
    }

    suspend fun updateProduct(id: Int, product: Product) {
        productService.updateProduct(id, product)
    }

    suspend fun deleteProduct(id: Int) {
        productService.deleteProduct(id)
    }

    suspend fun searchProductByName(name: String): List<Product> {
        return productService.searchProductsByName(name)
    }
}
