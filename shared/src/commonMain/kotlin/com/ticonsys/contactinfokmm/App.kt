package com.ticonsys.contactinfokmm

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ticonsys.contactinfokmm.contacts.presentation.ContactListScreen
import com.ticonsys.contactinfokmm.contacts.presentation.ContactListViewModel
import com.ticonsys.contactinfokmm.core.presentation.ContactsTheme
import com.ticonsys.contactinfokmm.core.presentation.ImagePicker
import com.ticonsys.contactinfokmm.di.AppModule
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    appModule: AppModule,
    imagePicker: ImagePicker
) {

    val viewModel = getViewModel(
        key = "contact-list-screen",
        factory = viewModelFactory {
            ContactListViewModel(
                appModule.contactDataSource
            )
        }
    )

    val state by viewModel.state.collectAsState()

    ContactsTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ContactListScreen(
                state = state,
                newContact = viewModel.newContact,
                onEvent = viewModel::onEvent,
                imagePicker = imagePicker
            )
        }
    }
}