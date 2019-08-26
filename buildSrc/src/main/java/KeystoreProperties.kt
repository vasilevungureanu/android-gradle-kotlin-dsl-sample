import java.io.File
import java.io.FileInputStream
import java.util.Properties

object KeystoreProperties {
    fun load(file: File): Property {
        val properties = Properties()
        properties.load(FileInputStream(file))

        return Property(
                properties["keyAlias"] as String,
                properties["keyPassword"] as String,
                properties["storeFile"] as String,
                properties["storePassword"] as String
        )
    }
}