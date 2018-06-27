package me.yohom.memoir

import me.yohom.memoir.bean.Story
import org.springframework.data.jpa.repository.JpaRepository

interface StoryRepo : JpaRepository<Story, Long>