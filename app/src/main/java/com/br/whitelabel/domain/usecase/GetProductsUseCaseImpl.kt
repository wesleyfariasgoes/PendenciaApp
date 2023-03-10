package com.br.whitelabel.domain.usecase

import com.br.whitelabel.data.ProductRepository
import com.br.whitelabel.domain.model.Product

class GetProductsUseCaseImpl(
    private val productRepository: ProductRepository
) : GetProductsUseCase {

    override suspend fun invoke(): List<Product> {
        return productRepository.getProducts()
    }
}