package com.example.appinventory.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appinventory.data.model.Product
import com.example.appinventory.ui.viewmodel.ProductViewModel

@Composable
fun ProductScreen(viewModel: ProductViewModel = viewModel()) {
    val products by viewModel.products.collectAsState()

    LazyColumn {
        items(products) { product ->
            ProductItem(product = product)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${product.name}")
            Text(text = "Price: $${product.price}")
            Text(text = "Quantity: ${product.quantity}")
        }
    }
}
