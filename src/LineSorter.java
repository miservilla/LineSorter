import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
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

        Path source = Paths.get("testinput.txt"); //args[0], use args[0] for source text file, was "testinput.txt"
        System.out.println(source.getFileName());
        Path target = Paths.get("testoutput.txt"); //args[1], use args[1] target test file, was "testoutput.txt"
        System.out.println(target.getFileName());

        Charset charset = Charset.forName("US-ASCII");

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(source, charset))
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

        lines.sort((s1, s2) -> Math.abs(s1.length() - "intelligent".length()) - Math.abs(s2.length() - "intelligent".length()));
        try (BufferedWriter writer = Files.newBufferedWriter(target, charset))
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
