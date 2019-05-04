import com.robbery.file.utils.Detective;
import com.robbery.file.utils.FileHandler;
import com.robbery.file.utils.Stay;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Stay> collection = FileHandler.parse(args[0]);

        FileHandler.writeFile(Detective.discoverSuspectGroups(collection));
    }
}
