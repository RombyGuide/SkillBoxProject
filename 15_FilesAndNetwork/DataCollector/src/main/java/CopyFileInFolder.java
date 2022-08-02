import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class CopyFileInFolder {
    public static void main(final String[] args) throws IOException {

        AtomicLong directoryNumber = new AtomicLong(0);
        Path start = Paths.get("15_FilesAndNetwork/DataCollector/data");

        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                String fileName = file.getFileName().toString();
                String newFileName;
                int index = fileName.lastIndexOf('.');
                if (index == -1)
                    newFileName = fileName;
                else
                    newFileName = directoryNumber.get() + fileName.substring(index);

                Path target = Paths.get(file.getParent().toString(), newFileName);
                Files.copy(file, target, StandardCopyOption.REPLACE_EXISTING);

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                directoryNumber.incrementAndGet();
                return super.preVisitDirectory(dir, attrs);
            }
        });
    }
}
