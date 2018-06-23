package net.lab0.tools.delegated

import kotlin.reflect.KProperty

/**
 * Delegated property that can only be set once.
 * Can't store null values.
 * Can't be accessed before it's set.
 */
class SetOnce<T> {
    var store: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
        store ?: throw IllegalStateException("Access SetOnce before it's been set")

    operator fun setValue(thisRef: Any?, property: KProperty<*>, new: T) =
        if (store == null) {
            store = new
        } else {
            // do nothing
        }
}
