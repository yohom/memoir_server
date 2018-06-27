package me.yohom.memoir

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

interface StoryRepo : JpaRepository<Story, Long>