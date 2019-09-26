package org.athenian.lanterna

import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory

fun main() {
    TerminalScreen(DefaultTerminalFactory().createTerminal())
        .apply {
            startScreen()
            clear()
            newTextGraphics().putString(10, 10, "Hello World!")
            refresh()
            readInput()
            stopScreen()
        }
}
