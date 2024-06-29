package com.planc.backend.controller

import com.planc.backend.model.Exercise
import com.planc.backend.repository.ExerciseRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class ExerciseController(
    private val exerciseRepository: ExerciseRepository,
) {

    @GetMapping("/exercises")
    fun getAllExercises(): List<Exercise> {
        return exerciseRepository.findAll()
    }

    @PostMapping("/exercise")
    fun createExercise(@RequestBody exercise: Exercise): Exercise {
        return exerciseRepository.save(exercise)
    }
}
