package com.br.whitelabel.domain.usecase

import android.net.Uri
import com.br.whitelabel.data.ProductRepository
import com.br.whitelabel.domain.model.Product
import java.util.UUID

class CreateProductUseCaseImpl(
    private val uploadProductImageUseCase: UploadProductImageUseCase,
    private val productRepository: ProductRepository
) : CreateProductUseCase {

    override suspend fun invoke(description: String, price: Double, imageUri: Uri): Product {
        return try {
            val imageUrl = uploadProductImageUseCase(imageUri)
            val product = Product(UUID.randomUUID().toString(), description, price, imageUrl)
            productRepository.createProduct(product)
        } catch (e: java.lang.Exception) {
            throw e
        }
    }
}