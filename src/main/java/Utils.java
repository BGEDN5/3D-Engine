import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {
    public static String loadResource(String path) throws IOException {
        return Files.readString(Path.of(path));
    }

}