package com.leo.miprimeraapp.models

data class PhotoResponse(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)