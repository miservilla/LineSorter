import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
/**
 * @author Michael Servilla
 * @version date 2017-02-28
 */
public class LineSorter {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("testinput.txt"); //for source test file
        Path target = Paths.get("testoutput.txt"); //for target test file
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(source))
        {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Collections.sort(lines);
        lines.sort((s1, s2) -> (s1.length() - "line".length()) -
                (s2.length() - "line".length()));
        //http://stackoverflow.com/questions/7575761/
        // sort-arraylist-of-strings-by-length
        try (BufferedWriter writer = Files.newBufferedWriter(target))
        {
            Iterator<String> iterator = lines.iterator();

            while (iterator.hasNext()) {
                String s = iterator.next();
                writer.write(s, 0, s.length());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}