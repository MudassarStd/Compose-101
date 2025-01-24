package com.android.learncompose.projects.calculator.eventHandler

data class CalculatorState(
    val num1: String = "",
    val num2: String = "",
    val operation: CalculatorOperation? = null
)
