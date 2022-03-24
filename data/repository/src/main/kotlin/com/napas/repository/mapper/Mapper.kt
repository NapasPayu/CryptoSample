package com.napas.repository.mapper

interface Mapper<E, D> {
    fun mapFromEntity(entity: E): D
}