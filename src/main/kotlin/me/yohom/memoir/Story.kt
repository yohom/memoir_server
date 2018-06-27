package me.yohom.memoir

import java.sql.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Story(
        @Id @GeneratedValue
        var id: Long? = 0,
        var title: String? = "",
        var storyContent: String? = "",
        var storyImage: String? = "",
        var storyDate: Date? = null,
        var character: String? = ""
)