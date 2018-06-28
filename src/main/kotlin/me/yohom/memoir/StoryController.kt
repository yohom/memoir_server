package me.yohom.memoir

import me.yohom.memoir.bean.Empty
import me.yohom.memoir.bean.ImageInfo
import me.yohom.memoir.bean.Response
import me.yohom.memoir.bean.Story
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
    fun getStory(): Response<Story> = Response(results = repo.findAll())

    @PostMapping("/add_story")
    fun saveStory(@RequestBody story: Story): Response<Empty> {
        repo.save(story)
        return Response()
    }

    @PostMapping("/add_image")
    fun saveImage(@RequestParam("file") file: MultipartFile): Response<ImageInfo> {
        try {
            val path = Paths.get("$IMAGE_PATH/${file.originalFilename}")
            Files.write(path, file.bytes)
        } catch (e: IOException) {
            e.printStackTrace()
            return Response(error = true, message = "保存文件失败")
        }

        return Response(results = listOf(ImageInfo("$IMAGE_URL/${file.originalFilename}")))
    }

    @GetMapping("/annalistic")
    fun getAnnalistic(): Response<Pair<String, List<Story>>> {
        return Response(results = repo.findAll().groupBy { it.storyDate.toString() }.toList())
    }
}