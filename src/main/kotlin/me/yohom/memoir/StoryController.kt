package me.yohom.memoir

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StoryController {
    @Autowired
    lateinit var repo: StoryRepo

    @GetMapping("/story")
    fun getStory(): Response<List<Story>> = Response(repo.findAll())

    @RequestMapping("/add_story")
    fun saveStory(story: Story) {
        repo.save(story)
    }
}