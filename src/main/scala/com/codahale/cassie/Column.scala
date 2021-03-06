package com.codahale.cassie

import clocks.Clock

object Column {
  /**
   * Creates a new column with the provided name and value and the latest
   * timestamp from the implicit clock parameter.
   */
  def apply[A, B](name: A, value: B)(implicit clock: Clock): Column[A, B] =
    Column(name, value, clock.timestamp)
}

/**
 * A column in a Cassandra. Belongs to a row in a column family.
 *
 * @author coda
 */
case class Column[A, B](name: A, value: B, timestamp: Long) {
  def pair = name -> this
}

/*

Or does it make more sense to define a series of implicit codecs?

Encoding, say, Long instances would suck ass. But one potential way of getting
around this would be to just create a wrapper class to go with the codec:

chunks.insert(chunk.id, Column("gc-marker", VarLong(clock.timestamp)))

*/
