package ItemProfile;

public class GenerateItemID extends ItemProfile {
    public static String GenerateItemID() {
        String NumericString = "0123456789";
        int idLength = 6;
        StringBuilder sb = new StringBuilder(idLength);

        for (int i = 0; i < idLength; i++) {
            int index
                    = (int) (NumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(NumericString.charAt(index));
        }
        return sb.toString();
    }

}


