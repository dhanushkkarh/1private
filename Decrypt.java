import java.util.HashMap;

class Decrypt {
    private static HashMap<String, String> decryptDict;

    static {
        decryptDict = new HashMap<>();
        decryptDict.put("01", "a");
        decryptDict.put("02", "b");
        decryptDict.put("03", "c");
        decryptDict.put("04", "d");
        decryptDict.put("05", "e");
        decryptDict.put("06", "f");
        decryptDict.put("07", "g");
        decryptDict.put("08", "h");
        decryptDict.put("09", "i");
        decryptDict.put("10", "j");
        decryptDict.put("11", "k");
        decryptDict.put("12", "l");
        decryptDict.put("13", "m");
        decryptDict.put("14", "n");
        decryptDict.put("15", "o");
        decryptDict.put("16", "p");
        decryptDict.put("17", "q");
        decryptDict.put("18", "r");
        decryptDict.put("19", "s");
        decryptDict.put("20", "t");
        decryptDict.put("21", "u");
        decryptDict.put("22", "v");
        decryptDict.put("23", "w");
        decryptDict.put("24", "x");
        decryptDict.put("25", "y");
        decryptDict.put("26", "z");
    }

    public static String decrypt(String encryptedValue, String password) {
        StringBuilder decryptedValue = new StringBuilder();
        int encryptedLength = encryptedValue.length();
        int passwordLength = password.length();
        int passwordIndex = 0;

        for (int i = 0; i < encryptedLength; i += 2) {
            String encryptedChunk = encryptedValue.substring(i, i + 2);
            int encryptedIndex = Integer.parseInt(encryptedChunk);

            char passwordChar = password.charAt(passwordIndex);
            String passwordKey = Encrypt.encryptDict.get(String.valueOf(passwordChar));

            if (passwordKey != null) {
                int passwordIndexValue = Integer.parseInt(passwordKey);
                int inputIndex = encryptedIndex - passwordIndexValue;

                String inputKey = String.format("%02d", inputIndex);
                String decrypted = decryptDict.get(inputKey);
                if (decrypted != null) {
                    decryptedValue.append(decrypted);
                }
            }

            passwordIndex++;
            passwordIndex %= passwordLength;
        }

        return decryptedValue.toString();
    }
}
