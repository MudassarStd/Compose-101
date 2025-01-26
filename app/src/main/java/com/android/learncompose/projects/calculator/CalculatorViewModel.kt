package com.android.learncompose.projects.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.android.learncompose.projects.calculator.eventHandler.CalculatorAction
import com.android.learncompose.projects.calculator.eventHandler.CalculatorOperation
import com.android.learncompose.projects.calculator.eventHandler.CalculatorState


class CalculatorViewModel: ViewModel() {

    // in this scenario, state is just like saving and retaining data during UI events

    // here we are creating a new instance of CalculatorState class as new State
    // NOTE: we are not using remember, because we need a new state on every event, that's why we are not remembering previous state

    // this state is subscribed/attached to viewmodel now, when we attach this viewmodel to composable , then this state is automatically subscribed to that comp as well.
    // state change will only update that composable to which it is subscribed/attached

    var state by mutableStateOf(CalculatorState())

    fun onAction(action: CalculatorAction) {
        when(action) {
            CalculatorAction.Calculate -> calculate()
            CalculatorAction.Clear -> state = CalculatorState() // new state with empty values
            CalculatorAction.Decimal -> enterDecimal()
            CalculatorAction.DeleteLastEntry -> delete()
            // when number is pressed, enter number that came from action
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> enterOp(action.operation)
        }
    }

    private fun calculate() {
        val n1 = state.num1.toDoubleOrNull()
        val n2 = state.num2.toDoubleOrNull()

        if (n1 == null || n2 == null) return

        val result = when(state.operation) {
            CalculatorOperation.Add -> n1 + n2
            CalculatorOperation.Divide -> n1 / n2
            CalculatorOperation.Multiply -> n1 * n2
            CalculatorOperation.Subtract -> n1 - n2
            null -> TODO()
        }

        // new state
        state = state.copy(
            num1 = result.toString().take(10),
            num2 = "",
            operation = null
        )

    }

    private fun enterDecimal() {
        // conditions -> number should not contain decimal already, number should not be blank

        if (state.operation == null && !state.num1.contains(".") && state.num1.isNotBlank()) {
            state = state.copy(num1 = state.num1 + ".")
            return
        } else if (!state.num2.contains(".") && state.num2.isNotBlank()) {
            state = state.copy(num2 = state.num2 + ".")
        }
    }

    private fun delete() {
        when {
            state.num2.isNotBlank() -> state = state.copy(num2 = state.num2.dropLast(1))
            state.operation != null -> state = state.copy(operation = null)
            state.num1.isNotBlank() -> state = state.copy(num1 = state.num1.dropLast(1))
        }
    }

    private fun enterOp(operation: CalculatorOperation) {
        // if first number is entered already
        if (state.num1.isNotBlank()) {
            state = state.copy(operation = operation)
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
            return
        }

        if (state.num2.length >= MAX_NUM_LENGTH) return

        // creates a new state
        state = state.copy(
            num2 = state.num2 + number
        )
    }

companion object {
    private const val MAX_NUM_LENGTH = 8
}
}

