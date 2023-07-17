package com.ticonsys.contactinfokmm.di

import com.plcoding.contactscomposemultiplatform.database.ContactDatabase
import com.ticonsys.contactinfokmm.contacts.data.sources.SqlDelightContactDataSource
import com.ticonsys.contactinfokmm.contacts.domain.sources.ContactDataSource
import com.ticonsys.contactinfokmm.core.data.DatabaseDriverFactory
import com.ticonsys.contactinfokmm.core.data.ImageStorage

actual class AppModule {
    actual val contactDataSource: ContactDataSource by lazy {
        SqlDelightContactDataSource(
            db = ContactDatabase(
                driver = DatabaseDriverFactory().create()
            ),
            imageStorage = ImageStorage()
        )
    }
}