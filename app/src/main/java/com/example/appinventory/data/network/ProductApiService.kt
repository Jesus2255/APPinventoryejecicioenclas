package com.example.appinventory.data.network

import com.example.appinventory.data.model.Product
import retrofit2.http.*

interface ProductApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Product

    @POST("products")
    suspend fun createProduct(@Body product: Product): Product

    @PUT("products/{id}")
    suspend fun updateProduct(@Path("id") id: Int, @Body product: Product): Product

    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") id: Int)

    @GET("products/search")
    suspend fun searchProductsByName(@Query("name") name: String): List<Product>
}
