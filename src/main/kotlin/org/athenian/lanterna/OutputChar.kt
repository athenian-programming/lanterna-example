package org.athenian.lanterna

import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory

fun main() {
    TerminalScreen(DefaultTerminalFactory().createTerminal())
        .apply {
            startScreen()
            clear()
            setCharacter(10, 10, TextCharacter('*'))
            refresh()
            readInput()
            stopScreen()
        }
}