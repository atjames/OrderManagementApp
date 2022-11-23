package ItemProfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


/* It's important to make sure you are using the correct file path. Make sure you are defining it as rsrc/<file name>.
   The rsrc folder is marked as the Resource dirc so the project will read files from there without needing to put entire filepath.
* */
public class getItems extends ItemProfile {
        public static ArrayList<ItemProfile> get_items() {

            String line = "";
            ArrayList<ItemProfile> items = new ArrayList<>(); //arraylist of items that we will store items from CSV in
            try {
                BufferedReader reader = new BufferedReader(new FileReader(ItemProfile.file_path));
                reader.readLine(); // skips header line of CSV
                while ((line = reader.readLine()) != null)
                {
                    String[] values = line.split(","); // splits the line of the commas and which stores each value in an array of Strings.
                    ItemProfile item = new ItemProfile(); // creating new itemProfile
                    item.createItem(values[0],values[1],values[2],Double.parseDouble(values[3]),values[4],Double.parseDouble(values[5]),values[6],values[7]);
                    //line above takes the CSV value and creates an item.
                    items.add(item); //add newly created item to arraylist
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            return items; //return the create arraylist
        }

}
