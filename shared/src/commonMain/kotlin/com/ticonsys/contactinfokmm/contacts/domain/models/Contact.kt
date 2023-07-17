package com.ticonsys.contactinfokmm.contacts.domain.models

data class Contact(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val photoBytes: ByteArray?
)
