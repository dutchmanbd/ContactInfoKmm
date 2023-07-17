package com.ticonsys.contactinfokmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.platform.LocalContext
import com.ticonsys.contactinfokmm.App
import com.ticonsys.contactinfokmm.core.presentation.ImagePickerFactory
import com.ticonsys.contactinfokmm.di.AppModule


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                darkTheme = isSystemInDarkTheme(),
                dynamicColor = true,
                appModule = AppModule(
                    LocalContext.current
                ),
                imagePicker = ImagePickerFactory().createPicker()
            )
        }
    }
}

