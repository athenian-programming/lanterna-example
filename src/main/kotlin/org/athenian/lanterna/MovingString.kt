package org.athenian.lanterna

import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory

fun main() {
    TerminalScreen(DefaultTerminalFactory().createTerminal())
        .apply {
            startScreen()
            clear()
            repeat(20) {
                newTextGraphics().putString(10, it, "Hello World!")
                refresh()
                Thread.sleep(300)
                clear()
            }
            readInput()
            stopScreen()
        }
}
