package com.github.paylike.kotlin_sdk.whitelabel.extendable.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.github.paylike.kotlin_engine.viewmodel.PaylikeEngine
import com.github.paylike.kotlin_sdk.whitelabel.simple.viewmodel.WhiteLabelViewModel

class ExtendableWhiteLabelViewModel(
    engine: PaylikeEngine,
    onPayButton:
    ((
        cardNumber: String,
        cvc: String,
        expiryMonth: Int,
        expiryYear: Int,
    ) -> Unit),
) : WhiteLabelViewModel(
    engine = engine,
    onPayButton = onPayButton,
) {
    var FirstName by mutableStateOf("")
        private set
    var isFirstNameInputValid by mutableStateOf(true)
        private set

    var LastName by mutableStateOf("")
        private set
    var isLastNameInputValid by mutableStateOf(true)
        private set

    var Note by mutableStateOf("")
        private set

    fun handleFirstNameInputChange(newValue: String) {
        isFirstNameInputValid = true
        FirstName = newValue
    }

    fun handleLastNameInputChange(newValue: String) {
        isLastNameInputValid = true
        LastName = newValue
    }

    fun handleNoteInputChange(newValue: String) {
        Note = newValue
    }

    override fun handleButtonClick() {
        super.handleButtonClick()

        if (FirstName.isEmpty())
            isFirstNameInputValid = false

        if (LastName.isEmpty())
            isLastNameInputValid = false
    }
}