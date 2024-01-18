package be.odisee.todo.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val id: String,
    val title: String,
    val description: String,
    @SerialName("due_date") val dueDate: String?,
    @SerialName("created_date") val createdDate: String? = null,
    val done: Boolean = false
)