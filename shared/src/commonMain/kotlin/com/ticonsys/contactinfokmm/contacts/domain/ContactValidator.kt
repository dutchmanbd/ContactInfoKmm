package com.ticonsys.contactinfokmm.contacts.domain

import com.ticonsys.contactinfokmm.contacts.domain.models.Contact

object ContactValidator {

    fun validateContact(contact: Contact): ValidationResult {
        var result = ValidationResult()

        if (contact.firstName.isEmpty()) {
            result = result.copy(
                firstNameError = "The first name can't be empty."
            )
        }

        if (contact.lastName.isEmpty()) {
            result = result.copy(
                lastNameError = "The last name can't be empty."
            )
        }
        val regex = Regex(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
        if (!regex.matches(contact.email)) {
            result = result.copy(
                emailError = "This is not a valid email."
            )
        }
        if (contact.phoneNumber.isEmpty()) {
            result = result.copy(
                phoneNumberError = "The phone number can't be empty."
            )
        }
        return result
    }


    data class ValidationResult(
        val firstNameError: String? = null,
        val lastNameError: String? = null,
        val emailError: String? = null,
        val phoneNumberError: String? = null,
    )
}