package be.odisee.todo.model

import kotlinx.serialization.Serializable

@Serializable
data class StringResponse(val status: String, val message: String)
