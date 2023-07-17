package com.ticonsys.contactinfokmm.di

import android.content.Context
import com.plcoding.contactscomposemultiplatform.database.ContactDatabase
import com.ticonsys.contactinfokmm.contacts.data.sources.SqlDelightContactDataSource
import com.ticonsys.contactinfokmm.contacts.domain.sources.ContactDataSource
import com.ticonsys.contactinfokmm.core.data.DatabaseDriverFactory
import com.ticonsys.contactinfokmm.core.data.ImageStorage

actual class AppModule(
    private val context: Context
) {
    actual val contactDataSource: ContactDataSource by lazy {
        SqlDelightContactDataSource(
            db = ContactDatabase(
                driver = DatabaseDriverFactory(context).create()
            ),
            imageStorage = ImageStorage(context)
        )
    }
}