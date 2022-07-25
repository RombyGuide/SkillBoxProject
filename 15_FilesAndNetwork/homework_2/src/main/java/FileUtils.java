import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        try {
            Files.walk(Paths.get(sourceDirectory))
                    .forEach(source -> {
                        Path destination = Paths.get(destinationDirectory,
                                source.toString().substring(sourceDirectory.length()));
                        try {
                            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
