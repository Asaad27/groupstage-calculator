package com.calc.qualification.repository

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class MatchRepositoryImplTest {

    private val matchRepo = MatchRepositoryImpl
    @Test
    fun getAllMatches() {
        runBlocking {
            val matches = matchRepo.getAllMatches()
            matches.forEach { println(it) }
        }
    }

    @Test
    fun getAllMatchesOfTeam() {
        runBlocking {
            val matches = matchRepo.getAllMatchesOfTeam("MAR")
            println(matches)
        }
    }

    @Test
    fun getMatchResult() {
        runBlocking {
            val result = matchRepo.getMatchResult("MAR", "BEL")
            val secondResult = matchRepo.getMatchResult("BEL", "MAR")
            assert(secondResult.first == result.second &&
            result.first == secondResult.second)
        }
    }
}