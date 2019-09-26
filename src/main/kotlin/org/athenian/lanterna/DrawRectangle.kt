package org.athenian.lanterna

import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory

fun main() {
    TerminalScreen(DefaultTerminalFactory().createTerminal())
        .apply {
            startScreen()
            clear()
            newTextGraphics().drawRectangle(TerminalPosition(3, 3), TerminalSize(10, 10), '*')
            refresh()
            readInput()
            stopScreen()
        }
}
