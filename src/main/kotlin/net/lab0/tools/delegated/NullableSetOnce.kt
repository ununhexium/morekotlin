package net.lab0.tools.delegated

import kotlin.reflect.KProperty

/**
 * Delegated property that can only be set once.
 * May store and return null values.
 * Returns null when it's not set.
 */
class NullableSetOnce<T> {
  var store: T? = null
  var set = false

  operator fun getValue(thisRef: Any?, property: KProperty<*>): T? = store

  operator fun setValue(thisRef: Any?, property: KProperty<*>, new: T) =
      if (!set) {
        store = new
        set = true
      } else {
        // do nothing
      }
}

