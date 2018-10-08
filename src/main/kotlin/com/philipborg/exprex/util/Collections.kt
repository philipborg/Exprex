package com.philipborg.exprex.util

inline fun <T> Collection<T>.sliceWhereIncluding(predicate: (T) -> Boolean): Collection<Collection<T>> {
    val result = mutableListOf<Collection<T>>()

    var current = mutableListOf<T>()

    for (obj in this) {
        current.add(obj)
        if (predicate(obj)) {
            result.add(current)
            current = mutableListOf()
        }
    }

    if (current.isNotEmpty())
        result.add(current)

    return result
}

inline fun <T> Collection<T>.takeWhileIncludingLast(predicate: (T) -> Boolean): Collection<T> {
    val pos = this.indexOfFirst { !predicate(it) }
    return when (pos) {
        -1 -> this
        else -> this.take(pos + 1)
    }
}