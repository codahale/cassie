package com.codahale.cassie

/**
 * Just here to poke a hole through BatchMutationBuilder's package-level privacy
 * for its mutations.
 */
object Mutations {
  def apply(builder: BatchMutationBuilder) = builder.mutations
}
