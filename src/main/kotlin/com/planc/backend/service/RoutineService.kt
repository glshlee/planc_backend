package com.planc.backend.service

import com.planc.backend.model.Routine
import com.planc.backend.model.RoutineWorkout
import com.planc.backend.repository.RoutineRepository
import org.springframework.stereotype.Service

@Service
class RoutineService(
    private val routineRepository: RoutineRepository,
    private val workoutService: WorkoutService,
) {
    fun createRoutine(routine: Routine): Routine {
        validateWorkouts(routine.workouts)
        return routineRepository.save(routine)
    }

    fun getRoutineById(id: String): Routine {
        return routineRepository.findById(id).orElseThrow { NoSuchElementException("Routine not found") }
    }

    fun getRoutinesByUserId(userId: String): List<Routine> {
        return routineRepository.findByUserId(userId)
    }

    fun updateRoutine(id: String, routineUpdate: Routine): Routine {
        val existingRoutine = getRoutineById(id)
        validateWorkouts(routineUpdate.workouts)

        val updatedRoutine = Routine(
            id = existingRoutine.id,
            userId = existingRoutine.userId,
            name = routineUpdate.name,
            description = routineUpdate.description,
            workouts = routineUpdate.workouts,
        )

        return routineRepository.save(updatedRoutine)
    }

    fun deleteRoutine(id: String) {
        routineRepository.deleteById(id)
    }

    private fun validateWorkouts(workouts: List<RoutineWorkout>) {
        workouts.forEach { routineWorkout ->
            workoutService.getWorkoutById(routineWorkout.workoutId)
        }
    }
}
