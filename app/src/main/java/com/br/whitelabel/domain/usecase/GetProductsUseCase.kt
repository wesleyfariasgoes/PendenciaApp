package com.br.whitelabel.domain.usecase

import android.net.Uri
import com.br.whitelabel.domain.model.Product

interface GetProductsUseCase {
    suspend operator fun invoke(): List<Product>
}