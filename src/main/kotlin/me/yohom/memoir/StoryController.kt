package me.yohom.memoir

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths


@RestController
class StoryController {
    @Autowired
    lateinit var repo: StoryRepo

    @GetMapping("/story")
    fun getStory(): Response<List<Story>> = Response(repo.findAll())

    @PostMapping("/add_story")
    fun saveStory(@RequestBody story: Story) {
        print(story)
        repo.save(story)
    }

    @PostMapping("/add_image")
    fun saveImage(@RequestParam("file") file: MultipartFile): String {
        try {
            val filename = file.originalFilename
            val path = Paths.get("/Users/yohom/Github/Me/All/memoir-server/image/$filename")
            Files.write(path, file.bytes)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return "redirect:/uploadStatus"
    }
}