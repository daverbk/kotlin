package games.gameOfFifteen

import board.Direction
import board.createGameBoard
import games.game.Game

/*
 * Implement the Game of Fifteen (https://en.wikipedia.org/wiki/15_puzzle).
 * When you finish, you can play the game by executing 'PlayGameOfFifteen'.
 */
fun newGameOfFifteen(initializer: GameOfFifteenInitializer = RandomGameInitializer()): Game = GameOfFifteen(initializer)

class GameOfFifteen(private val initializer: GameOfFifteenInitializer) : Game {
    private val board = createGameBoard<Int?>(4)

    override fun initialize() {
        board.getAllCells().forEachIndexed { i, cell -> board[cell] = initializer.initialPermutation.getOrNull(i) }
    }

    override fun canMove() = board.any { it == null }

    override fun hasWon() = board.getAllCells().mapIndexed { i, cell -> board[cell] == i }.all { true }

    override fun processMove(direction: Direction) {
        val emptyCell = board.find { it == null }!!
        val neighbour = with(board) {
            emptyCell.getNeighbour(direction.reversed())
        }
        if (neighbour == null) return
        board[emptyCell] = board[neighbour]
        board[neighbour] = null
    }

    override fun get(i: Int, j: Int): Int? = board.run { get(getCell(i, j)) }
}
