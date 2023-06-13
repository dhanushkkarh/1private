import java.util.HashMap;

class Encrypt {
    public static HashMap<String, String> encryptDict;

    static {
        encryptDict = new HashMap<>();
        encryptDict.put("a", "01");
        encryptDict.put("b", "02");
        encryptDict.put("c", "03");
        encryptDict.put("d", "04");
        encryptDict.put("e", "05");
        encryptDict.put("f", "06");
        encryptDict.put("g", "07");
        encryptDict.put("h", "08");
        encryptDict.put("i", "09");
        encryptDict.put("j", "10");
        encryptDict.put("k", "11");
        encryptDict.put("l", "12");
        encryptDict.put("m", "13");
        encryptDict.put("n", "14");
        encryptDict.put("o", "15");
        encryptDict.put("p", "16");
        encryptDict.put("q", "17");
        encryptDict.put("r", "18");
        encryptDict.put("s", "19");
        encryptDict.put("t", "20");
        encryptDict.put("u", "21");
        encryptDict.put("v", "22");
        encryptDict.put("w", "23");
        encryptDict.put("x", "24");
        encryptDict.put("y", "25");
        encryptDict.put("z", "26");
    }

    public static String encrypt(String input, String password) {
        StringBuilder encryptedValue = new StringBuilder();
        int inputLength = input.length();
        int passwordLength = password.length();
        int passwordIndex = 0;

        for (int i = 0; i < inputLength; i++) {
            char inputChar = input.charAt(i);
            char passwordChar = password.charAt(passwordIndex);

            String inputKey = encryptDict.get(String.valueOf(inputChar));
            String passwordKey = encryptDict.get(String.valueOf(passwordChar));

            if (inputKey != null && passwordKey != null) {
                int inputIndex = Integer.parseInt(inputKey);
                int passwordIndexValue = Integer.parseInt(passwordKey);
                int sum = inputIndex + passwordIndexValue;
                String encrypted = String.format("%02d", sum);
                encryptedValue.append(encrypted);
            }

            passwordIndex++;
            passwordIndex %= passwordLength;

        }

        return encryptedValue.toString();
    }
}
