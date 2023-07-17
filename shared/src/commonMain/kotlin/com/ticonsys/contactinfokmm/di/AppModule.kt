package com.ticonsys.contactinfokmm.di

import com.ticonsys.contactinfokmm.contacts.domain.sources.ContactDataSource

expect class AppModule {
    val contactDataSource: ContactDataSource
}