import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int newWidth = 300;
    private static int cores = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        String srcFolder = "C:/Users/blino/OneDrive/Pictures/Saved Pictures";
        String dstFolder = "C:/Users/blino/OneDrive/Pictures/Dst Pictures";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int middle = files.length / cores;

        List<ImageResizer> imageResizers = new ArrayList<>();

        for (int x = 0; x < cores; x++) {
            File[] threadFiles = new File[middle];
            System.arraycopy(files, middle * x, threadFiles, 0, threadFiles.length);
            imageResizers.add(x, new ImageResizer(threadFiles, newWidth, dstFolder, start));
            new Thread(imageResizers.get(x)).start();
        }

//        File[] files1 = new File[middle];
//        System.arraycopy(files, 0, files1, 0, files1.length);
//        ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
//        new Thread(resizer1).start();
//
//        File[] files2 = new File[files.length - middle];
//        System.arraycopy(files, middle, files2, 0, files2.length);
//        ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
//        new Thread(resizer2).start();
    }
}
