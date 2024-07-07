package com.planc.backend.controller

import com.planc.backend.model.Routine
import com.planc.backend.service.RoutineService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/routines")
class RoutineController(private val routineService: RoutineService) {

    @PostMapping
    fun createRoutine(@RequestBody routine: Routine): ResponseEntity<Routine> {
        val createdRoutine = routineService.createRoutine(routine)
        return ResponseEntity(createdRoutine, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getRoutineById(@PathVariable id: String): ResponseEntity<Routine> {
        val routine = routineService.getRoutineById(id)
        return ResponseEntity(routine, HttpStatus.OK)
    }

    @GetMapping("/user/{userId}")
    fun getRoutinesByUserId(@PathVariable userId: String): ResponseEntity<List<Routine>> {
        val routines = routineService.getRoutinesByUserId(userId)
        return ResponseEntity(routines, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateRoutine(@PathVariable id: String, @RequestBody routineUpdate: Routine): ResponseEntity<Routine> {
        val updatedRoutine = routineService.updateRoutine(id, routineUpdate)
        return ResponseEntity(updatedRoutine, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteRoutine(@PathVariable id: String): ResponseEntity<Unit> {
        routineService.deleteRoutine(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
