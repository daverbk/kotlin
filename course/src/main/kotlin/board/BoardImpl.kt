package board

import board.Direction.*

fun createSquareBoard(width: Int): SquareBoard = object : SquareBoard {
    private val matrix: List<List<Cell>> = MutableList(width) { i ->
        MutableList(width) { j ->
            Cell(i + 1, j + 1)
        }
    }

    override val width: Int
        get() = width

    override fun getCellOrNull(i: Int, j: Int): Cell? =
        matrix.getOrNull(i - 1)?.getOrNull(j - 1)

    override fun getCell(i: Int, j: Int): Cell = getCellOrNull(i, j)
        ?: throw IllegalArgumentException("No cell present for i=$i and j=$j")

    override fun getAllCells(): Collection<Cell> = matrix.flatten()

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> =
        jRange.mapNotNull { j -> getCellOrNull(i, j) }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> =
        iRange.mapNotNull { i -> getCellOrNull(i, j) }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        return when (direction) {
            UP -> getCellOrNull(this.i - 1, this.j)
            DOWN -> getCellOrNull(this.i + 1, this.j)
            LEFT -> getCellOrNull(this.i, this.j - 1)
            RIGHT -> getCellOrNull(this.i, this.j + 1)
        }
    }
}

fun <T> createGameBoard(width: Int): GameBoard<T> = TODO()

