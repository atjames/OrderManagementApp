package ItemProfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class getItems extends ItemProfile {
        public static ArrayList<ItemProfile> get_items() {

            String line = "";
            ArrayList<ItemProfile> items = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(ItemProfile.file_path));
                reader.readLine();
                while ((line = reader.readLine()) != null)
                {
                    String[] values = line.split(",");
                    ItemProfile item = new ItemProfile();
                    item.createItem(values[0],values[1],values[2],Double.parseDouble(values[3]),values[4],Double.parseDouble(values[5]),values[6],values[7]);
                    items.add(item);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            return items;
        }

}
