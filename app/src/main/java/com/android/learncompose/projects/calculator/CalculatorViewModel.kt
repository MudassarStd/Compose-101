package com.android.learncompose.projects.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.android.learncompose.projects.calculator.eventHandler.CalculatorAction
import com.android.learncompose.projects.calculator.eventHandler.CalculatorState

class CalculatorViewModel: ViewModel() {

    // in this scenario, state is just like saving and retaining data during UI events

    // here we are creating a new instance of CalculatorState class as new State
    // NOTE: we are not using remember, because we need a new state on every event, that's why we are not remembering previous state

    // this state is subscribed/attached to viewmodel now, when we attach this viewmodel to comp, then this state is automatically subscribed to that comp as well.

    var state by mutableStateOf(CalculatorState())

    fun onAction(action: CalculatorAction) {
        when(action) {
            CalculatorAction.Calculate -> TODO()
            CalculatorAction.Clear -> TODO()
            CalculatorAction.Decimal -> TODO()
            CalculatorAction.DeleteLastEntry -> TODO()
            // when number is pressed, enter number that came from action
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> TODO()
        }
    }

    private fun enterNumber(number: Int) {
        // things to check before entering first number
        // 1- validate number
        // 2- (no operation definition before first number)
        // 3- if operation is not defined yet, it means this is first number else 2nd number

        if (state.operation == null) { // first number
            if (state.num1.length >= MAX_NUM_LENGTH) return

            // create new state by appending new number to current number
            // so when this state will change, it will automatically recompose UI to which it is subscribed

            state = state.copy(
                num1 = state.num1 + number
            )

        }

    }



companion object {
    private const val MAX_NUM_LENGTH = 8
}
}

