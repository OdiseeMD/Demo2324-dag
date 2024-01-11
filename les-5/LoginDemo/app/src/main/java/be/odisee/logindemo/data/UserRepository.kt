package be.odisee.logindemo.data

import be.odisee.logindemo.model.User

object UserRepository {
    val users = mutableListOf(User("matthias", "demo", "matthias.druwe@odisee.be"))
}