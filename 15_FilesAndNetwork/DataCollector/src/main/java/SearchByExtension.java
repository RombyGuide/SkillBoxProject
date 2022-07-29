import java.io.File;
import java.io.FilenameFilter;

public class SearchByExtension {

    public static void main(String[] args) {
        // будем искать в папке tmp
        String dir = "FilesAndNetwork/DataCollector/data/4/6";
        // в этой папке будем искать файлы с расширением .xml
        String ext = ".csv";
        // вызываем метод поиска файлов с расширением .xml в папке tmp
        findFiles(dir, ext);
    }

    // метод поиска
    private static void findFiles(String dir, String ext) {
        File file = new File(dir);
        if(!file.exists()) System.out.println(dir + " папка не существует");
        File[] listFiles = file.listFiles(new MyFileNameFilter(ext));
        if(listFiles.length == 0){
            System.out.println(dir + " не содержит файлов с расширением " + ext);
        }else{
            for(File f : listFiles)
                System.out.println("Файл: " + dir + File.separator + f.getName());
        }
    }

    // Реализация интерфейса FileNameFilter
    public static class MyFileNameFilter implements FilenameFilter{

        private String ext;

        public MyFileNameFilter(String ext){
            this.ext = ext.toLowerCase();
        }
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext);
        }
    }
}