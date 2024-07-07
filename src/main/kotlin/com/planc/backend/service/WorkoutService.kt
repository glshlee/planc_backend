package com.planc.backend.service

import com.planc.backend.model.Workout
import com.planc.backend.repository.WorkoutRepository
import org.springframework.stereotype.Service

@Service
class WorkoutService(private val workoutRepository: WorkoutRepository) {
    fun createWorkout(workout: Workout): Workout {
        return workoutRepository.save(workout)
    }

    fun getWorkoutById(id: String): Workout {
        return workoutRepository.findById(id).orElseThrow { NoSuchElementException("Workout not found") }
    }

    fun getAllWorkouts(): List<Workout> {
        return workoutRepository.findAll()
    }

    fun getWorkoutsByType(type: String): List<Workout> {
        return workoutRepository.findByType(type)
    }

    fun getWorkoutsByDifficulty(difficulty: String): List<Workout> {
        return workoutRepository.findByDifficulty(difficulty)
    }

    fun getWorkoutsByMuscleGroup(muscleGroup: String): List<Workout> {
        return workoutRepository.findByMuscleGroupsContaining(muscleGroup)
    }

    fun updateWorkout(id: String, workoutUpdate: Workout): Workout {
        val existingWorkout = getWorkoutById(id)
        val updatedWorkout = Workout(
            id = existingWorkout.id,
            name = workoutUpdate.name,
            description = workoutUpdate.description,
            type = workoutUpdate.type,
            difficulty = workoutUpdate.difficulty,
            muscleGroups = workoutUpdate.muscleGroups,
            equipment = workoutUpdate.equipment,
            instructions = workoutUpdate.instructions,
            imageUrl = workoutUpdate.imageUrl,
            videoUrl = workoutUpdate.videoUrl,
        )
        return workoutRepository.save(updatedWorkout)
    }

    fun deleteWorkout(id: String) {
        workoutRepository.deleteById(id)
    }
}
