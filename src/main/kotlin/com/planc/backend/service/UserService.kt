package com.planc.backend.service

import com.planc.backend.model.User
import com.planc.backend.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    fun createUser(user: User): User {
        if (userRepository.existsByEmail(user.email)) {
            throw IllegalArgumentException("Email already exists")
        }
        val encodedPassword = passwordEncoder.encode(user.password)
        val newUser = User(
            id = user.id,
            email = user.email,
            password = encodedPassword,
            name = user.name,
            dateOfBirth = user.dateOfBirth,
            gender = user.gender,
            height = user.height,
            weight = user.weight,
            fitnessLevel = user.fitnessLevel,
            goals = user.goals,
            availableEquipment = user.availableEquipment,
            preferredWorkoutDays = user.preferredWorkoutDays,
            workoutDurationPreference = user.workoutDurationPreference,
            healthConditions = user.healthConditions,
        )
        return userRepository.save(newUser)
    }

    fun getUserById(id: String): User {
        return userRepository.findById(id).orElseThrow { NoSuchElementException("User not found") }
    }

    fun getUserByEmail(email: String): User {
        return userRepository.findByEmail(email) ?: throw NoSuchElementException("User not found")
    }

    fun updateUser(id: String, userUpdate: User): User {
        val existingUser = getUserById(id)
        existingUser.apply {
            name = userUpdate.name
            height = userUpdate.height
            weight = userUpdate.weight
            fitnessLevel = userUpdate.fitnessLevel
            goals = userUpdate.goals
            availableEquipment = userUpdate.availableEquipment
            preferredWorkoutDays = userUpdate.preferredWorkoutDays
            workoutDurationPreference = userUpdate.workoutDurationPreference
            healthConditions = userUpdate.healthConditions
        }
        return userRepository.save(existingUser)
    }

    fun deleteUser(id: String) {
        userRepository.deleteById(id)
    }
}
