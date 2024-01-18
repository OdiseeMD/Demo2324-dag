package be.odisee.todo.model

import kotlinx.serialization.Serializable

@Serializable
data class ListResponse(val status: String, val message: List<Todo>)
