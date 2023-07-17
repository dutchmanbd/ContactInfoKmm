package com.ticonsys.contactinfokmm.contacts.data.mappers

import com.ticonsys.contactinfokmm.contacts.domain.models.Contact
import com.ticonsys.contactinfokmm.core.data.ImageStorage
import database.ContactEntity

suspend fun ContactEntity.toContact(
    imageStorage: ImageStorage
) = Contact(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email,
    phoneNumber = phoneNumber,
    photoBytes = imagePath?.let { imageStorage.getImage(it) }
)