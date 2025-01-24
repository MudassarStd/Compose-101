package com.android.learncompose.projects.calculator.eventHandler

// possible actions from/on calculator

sealed class CalculatorAction {
    data class Number(val number: Int): CalculatorAction()
    object Clear: CalculatorAction()
    object DeleteLastEntry: CalculatorAction()
    object Calculate: CalculatorAction()
    object Decimal: CalculatorAction()
    data class Operation(val operation: CalculatorOperation): CalculatorAction()
}


sealed class CalculatorOperation(val op: String) {
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("x")
    object Divide: CalculatorOperation("/")
}