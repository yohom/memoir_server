package me.yohom.memoir.bean

import java.sql.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Story(
        @Id @GeneratedValue
        var id: Long = 0,
        var title: String = "",
        var storyContent: String = "",
        var storyImage: String = "",
        var storyDate: String = "",
        var hero: String = ""
)