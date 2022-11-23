package ItemProfile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class writeCSV extends ItemProfile {

    public static void write_items(ArrayList<ItemProfile> items){

            try (FileWriter writer = new FileWriter(ItemProfile.file_path, false))
            {
                writer.write(ItemProfile.CSVHeaderLine);

                for (ItemProfile item : items)
                {
                    writer.write('\n' + ItemProfileCSV.CSVFormatter(item));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}

