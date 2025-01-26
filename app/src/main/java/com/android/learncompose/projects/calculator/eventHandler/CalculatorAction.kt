package com.android.learncompose.projects.calculator.eventHandler

// possible actions from/on calculator
// a fixed set of all possible actions/events

sealed class CalculatorAction {
    data class Number(val number: Int): CalculatorAction()
    object Clear: CalculatorAction()
    object DeleteLastEntry: CalculatorAction()
    object Calculate: CalculatorAction()
    object Decimal: CalculatorAction()
    data class Operation(val operation: CalculatorOperation): CalculatorAction()
}


// how this works

// symbol is like a property of CalculatorOperation Class
// so whenever an object (Add, Subtract etc.) inherits this class, each object will get symbol property
// of parent class with specific value at the time of inheritance

sealed class CalculatorOperation(val symbol: String) {
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("x")
    object Divide: CalculatorOperation("/")
}