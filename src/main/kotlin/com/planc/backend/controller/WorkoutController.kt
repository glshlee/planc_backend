package com.planc.backend.controller

import com.planc.backend.model.Workout
import com.planc.backend.service.WorkoutService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/workouts")
class WorkoutController(private val workoutService: WorkoutService) {

    @PostMapping
    fun createWorkout(@RequestBody workout: Workout): ResponseEntity<Workout> {
        val createdWorkout = workoutService.createWorkout(workout)
        return ResponseEntity(createdWorkout, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getWorkoutById(@PathVariable id: String): ResponseEntity<Workout> {
        val workout = workoutService.getWorkoutById(id)
        return ResponseEntity(workout, HttpStatus.OK)
    }

    @GetMapping
    fun getAllWorkouts(): ResponseEntity<List<Workout>> {
        val workouts = workoutService.getAllWorkouts()
        return ResponseEntity(workouts, HttpStatus.OK)
    }

    @GetMapping("/type/{type}")
    fun getWorkoutsByType(@PathVariable type: String): ResponseEntity<List<Workout>> {
        val workouts = workoutService.getWorkoutsByType(type)
        return ResponseEntity(workouts, HttpStatus.OK)
    }

    @GetMapping("/difficulty/{difficulty}")
    fun getWorkoutsByDifficulty(@PathVariable difficulty: String): ResponseEntity<List<Workout>> {
        val workouts = workoutService.getWorkoutsByDifficulty(difficulty)
        return ResponseEntity(workouts, HttpStatus.OK)
    }

    @GetMapping("/musclegroup/{muscleGroup}")
    fun getWorkoutsByMuscleGroup(@PathVariable muscleGroup: String): ResponseEntity<List<Workout>> {
        val workouts = workoutService.getWorkoutsByMuscleGroup(muscleGroup)
        return ResponseEntity(workouts, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateWorkout(@PathVariable id: String, @RequestBody workoutUpdate: Workout): ResponseEntity<Workout> {
        val updatedWorkout = workoutService.updateWorkout(id, workoutUpdate)
        return ResponseEntity(updatedWorkout, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteWorkout(@PathVariable id: String): ResponseEntity<Unit> {
        workoutService.deleteWorkout(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}