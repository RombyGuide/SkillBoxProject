import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите папку, которую нужно копировать: ");
        String sourceDirectory = null;
        try {
            sourceDirectory = reader1.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите папку, в которую нужно скопировать: ");
        String destinationDirectory = null;
        try {
            destinationDirectory = reader2.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileUtils.copyFolder(sourceDirectory, destinationDirectory);
    }
}
