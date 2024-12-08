package board

import org.junit.FixMethodOrder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestGameBoard {
    operator fun <T> GameBoard<T>.get(i: Int, j: Int) = get(getCell(i, j))
    operator fun <T> GameBoard<T>.set(i: Int, j: Int, value: T) = set(getCell(i, j), value)

    @Test
    fun test01GetAndSetElement() {
        val gameBoard = createGameBoard<Char>(2)
        gameBoard[1, 1] = 'a'
        Assertions.assertEquals('a', gameBoard[1, 1])
    }

    @Test
    fun test02Filter() {
        val gameBoard = createGameBoard<Char>(2)
        gameBoard[1, 1] = 'a'
        gameBoard[1, 2] = 'b'
        val cells = gameBoard.filter { it == 'a' }
        Assertions.assertEquals(1, cells.size)
        val cell = cells.first()
        Assertions.assertEquals(1, cell.i)
        Assertions.assertEquals(1, cell.j)
    }

    @Test
    fun test03All() {
        val gameBoard = createGameBoard<Char>(2)
        gameBoard[1, 1] = 'a'
        gameBoard[1, 2] = 'a'
        Assertions.assertFalse(gameBoard.all { it == 'a' })
        gameBoard[2, 1] = 'a'
        gameBoard[2, 2] = 'a'
        Assertions.assertTrue(gameBoard.all { it == 'a' })
    }

    @Test
    fun test04Any() {
        val gameBoard = createGameBoard<Char>(2)
        gameBoard[1, 1] = 'a'
        gameBoard[1, 2] = 'b'
        Assertions.assertTrue(gameBoard.any { it in 'a'..'b' })
        Assertions.assertTrue(gameBoard.any { it == null })
    }

    @Test
    fun test05TheSameCell() {
        val gameBoard = createGameBoard<Char>(2)
        gameBoard[1, 1] = 'a'
        val cell1 = gameBoard.find { it == 'a' }
        gameBoard[1, 1] = 'b'
        val cell2 = gameBoard.find { it == 'b' }
        Assertions.assertEquals(cell1, cell2)
    }

    @Test
    fun test06FindReturnsTheSameCell() {
        val gameBoard = createGameBoard<Char>(2)
        gameBoard[1, 1] = 'a'
        val first = gameBoard.find { it == 'a' }
        val second = gameBoard.getCell(1, 1)
        Assertions.assertTrue(
            first === second, "'find' shouldn't recreate the 'Cell' instances.\n" +
                    "Create only 'width * width' cells; all the functions working with cells\n" +
                    "should return existing cells instead of creating new ones."
        )
    }

    @Test
    fun test07FilterTheSameCell() {
        val gameBoard = createGameBoard<Char>(2)
        gameBoard[1, 1] = 'a'
        val cells = gameBoard.filter { it == 'a' }
        val first = cells.first()
        val second = gameBoard.getCell(1, 1)
        Assertions.assertTrue(
            first === second, "'filter' shouldn't recreate the 'Cell' instances.\n" +
                    "Create only 'width * width' cells; all the functions working with cells\n" +
                    "should return existing cells instead of creating new ones."
        )
    }

    @Test
    fun test08AllAny() {
        val gameBoard = createGameBoard<Int>(2)
        gameBoard[1, 1] = 1
        gameBoard[1, 2] = 0
        gameBoard[2, 1] = 2
        gameBoard[2, 2] = 3
        testAllAny(gameBoard)
    }

    @Test
    fun test09AllAny() {
        val gameBoard = createGameBoard<Int>(2)
        gameBoard[1, 1] = 0
        gameBoard[1, 2] = 0
        gameBoard[2, 1] = 0
        gameBoard[2, 2] = 0
        testAllAny(gameBoard)
    }

    @Test
    fun test10AllAny() {
        val gameBoard = createGameBoard<Int>(2)
        gameBoard[1, 1] = 1
        gameBoard[1, 2] = 2
        gameBoard[2, 1] = 3
        gameBoard[2, 2] = 4
        testAllAny(gameBoard)
    }

    @Test
    fun test11AllAny() {
        val gameBoard = createGameBoard<Int>(2)
        gameBoard[1, 1] = 0
        gameBoard[1, 2] = 1
        gameBoard[2, 2] = 1
        testAllAny(gameBoard)
    }

    private fun <T> GameBoard<T>.asString() =
        (1..width).joinToString("\n") { i ->
            (1..width).joinToString(" ") { j ->
                "${get(i, j) ?: "-"}"
            }
        }

    private fun testAllAny(gameBoard: GameBoard<Int>) {
        val allNonZero = gameBoard.all { it != 0 }
        val anyZero = gameBoard.any { it == 0 }
        Assertions.assertTrue(allNonZero == !anyZero, buildString {
            appendln("'board.all { it != 0 }' should give the same result as '!board.any { it == 0 }' for the board")
            appendln(gameBoard.asString())
        })
    }
}
