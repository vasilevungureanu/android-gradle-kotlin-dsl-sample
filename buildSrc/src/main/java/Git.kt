import org.gradle.api.Project
import java.io.File

// https://github.com/ZacSweers/CatchUp/blob/master/buildSrc/src/main/kotlin/dependencies.kt
fun String?.letIfEmpty(fallback: String): String {
    return if (this == null || isEmpty()) {
        fallback
    } else {
        this
    }
}

// https://github.com/ZacSweers/CatchUp/blob/master/buildSrc/src/main/kotlin/dependencies.kt
fun String?.execute(workingDir: File, fallback: String): String {
    Runtime.getRuntime().exec(this, null, workingDir).let {
        it.waitFor()
        return try {
            it.inputStream.reader().readText().trim().letIfEmpty(fallback)
        } catch (e: Exception) {
            fallback
        }
    }
}

object Git {
    fun getCommitsSinceLastTag(project: Project): String {
        val range = getLastAbbrevTag(project) + "..HEAD".replace("\n", "")

        return "git log $range --pretty=format:%s".execute(project.rootDir, "")
    }

    private fun getLastAbbrevTag(project: Project) =
            "git describe --tags --abbrev=0 --always".execute(project.rootDir, "")

    fun getCommitsCount(project: Project) = "git rev-list --count HEAD".execute(project.rootDir, "0").toInt()

    fun getLastTag(project: Project) = "git describe --tags --always".execute(project.rootDir, "")
}