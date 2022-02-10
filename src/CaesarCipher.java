import java.*;


public class CaesarCipher {
    /**
     * Encrypts the message using the Caesar Cipher
     *
     * @param message
     * @param offset
     * @return
     */
    public String cipher(String message, int offset) {
        StringBuilder result = new StringBuilder();
        //Assuming that offsets are positive and messages are lowercase only
        for(char character: message.toCharArray()){
            if(character != ' '){
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            }else{
                result.append(character);
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
//        Testing the encryption process of the Caesar cipher
        CaesarCipher cipher = new CaesarCipher();

        String cipheredMessage = cipher.cipher("he told me i could never teach a llama to drive", 3);
        System.out.println(cipheredMessage);





    }


}
