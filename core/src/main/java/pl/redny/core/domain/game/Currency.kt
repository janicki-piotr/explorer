package pl.redny.core.domain.game

import pl.redny.core.base.Entity

data class Currency(
    val id: Short,
    val name: String,
    val description: String,
    val order: Short,
    val icon: String
) : Entity