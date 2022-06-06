package com.sampson.daggerstudy

import java.util.*

class NumberRepositoryImpl(private val random: Random) : NumberRepository {
    override fun generateNextNumber(): Int {
        return random.nextInt()
    }

}