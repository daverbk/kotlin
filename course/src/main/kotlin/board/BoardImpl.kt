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

fun <T> createGameBoard(width: Int): GameBoard<T> = object : GameBoard<T> {
    private val squareBoard = createSquareBoard(width)
    private val data: MutableMap<Cell, T?> = mutableMapOf()

    init {
        squareBoard.getAllCells().forEach { cell ->
            data[cell] = null
        }
    }

    override val width: Int
        get() = squareBoard.width

    override fun get(cell: Cell): T? = data.getOrDefault(cell, null)

    override fun set(cell: Cell, value: T?) {
        data[cell] = value
    }

    override fun all(predicate: (T?) -> Boolean): Boolean =
        data.all { predicate.invoke(it.value) }

    override fun any(predicate: (T?) -> Boolean): Boolean =
        data.any { predicate.invoke(it.value) }

    override fun find(predicate: (T?) -> Boolean): Cell? =
        data.entries.find { predicate(it.value) }?.key

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        return data.entries.filter { predicate(it.value) }.map { it.key }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? = squareBoard.getCellOrNull(i, j)

    override fun getCell(i: Int, j: Int): Cell = squareBoard.getCell(i, j)

    override fun getAllCells(): Collection<Cell> = squareBoard.getAllCells()

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> = squareBoard.getRow(i, jRange)

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> =
        squareBoard.getColumn(iRange, j)

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        return when (direction) {
            UP -> getCellOrNull(this.i - 1, this.j)
            DOWN -> getCellOrNull(this.i + 1, this.j)
            LEFT -> getCellOrNull(this.i, this.j - 1)
            RIGHT -> getCellOrNull(this.i, this.j + 1)
        }
    }
}
