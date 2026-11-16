package com.example.ushtrimi_2.home.contacts

import com.example.ushtrimi_2.R
import java.util.UUID

class ContactsRepo {
    private val avatars = listOf(
        R.drawable.avatar_1,
        R.drawable.avatar_2,
        R.drawable.avatar_3,
        R.drawable.avatar_4,
        R.drawable.avatar_5,
        R.drawable.avatar_6,
        R.drawable.avatar_7,
        R.drawable.avatar_8,
        R.drawable.avatar_9,
        R.drawable.avatar_10,
        R.drawable.avatar_11,
        R.drawable.avatar_12,
    )
    fun getContacts(): List<ContactsUiModel> = List(100) { index ->
        val currentUser = index + 1
        ContactsUiModel(
            id = UUID.randomUUID().toString(),
            firstName = "Firstname $currentUser",
            lastName = "Lastname $currentUser",
            email = "firstname$currentUser.lastname$currentUser@example.com",
            avatarId = avatars[index % avatars.size],
        )
    }
}

data class ContactsUiModel(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val avatarId: Int,
)