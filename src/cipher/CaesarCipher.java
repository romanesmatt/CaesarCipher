package cipher;
import java.*;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.commons.math3.stat.inference.ChiSquareTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CaesarCipher {


    private final Logger log = LoggerFactory.getLogger(CaesarCipher.class);

    private final double[] ENGLISH_LETTERS_PROBABILITIES =  {0.073, 0.009, 0.030, 0.044, 0.130, 0.028, 0.016, 0.035, 0.074,
            0.002, 0.003, 0.035, 0.025, 0.078, 0.074, 0.027, 0.003,
            0.077, 0.063, 0.093, 0.027, 0.013, 0.016, 0.005, 0.019, 0.001};






    /**
     * Encrypts the message using the Caesar Cipher.
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

    /**
     * Decrypts the message.
     * @param message
     * @param offset
     * @return
     */
     public String decipher(String message, int offset){
        return cipher(message, 26 - (offset % 26));
     }

    /**
     * Breaks the cipher by using the Chi-squared statistic to compare distributions.
     * @param message
     * @return
     */
     public int breakCipher(String message){
         return probableOffset(chiSquares(message));

     }

     private double[] chiSquares(String message){

         double[] expectedLetterFrequencies =
                 Arrays.stream(ENGLISH_LETTERS_PROBABILITIES)
                         .map(probability -> probability * message.length())
                         .toArray();


         double[] chiSquares = new double[26];

         for(int offset = 0; offset < chiSquares.length; offset++){
             String decipheredMessage = decipher(message, offset);
             long[] lettersFrequencies =
                     observedLettersFrequencies(decipheredMessage);
             double chiSquare = new ChiSquareTest().chiSquare(expectedLetterFrequencies, lettersFrequencies);
             chiSquares[offset] = chiSquare;
         }
         return chiSquares;
     }


    /**
     * Realizes a count of letters a to z in the passed message.
     * @param message
     * @return
     */
     public long[] observedLettersFrequencies(String message) {
         return IntStream.rangeClosed('a', 'z')
                 .mapToLong(letter -> countLetter((char) letter, message))
                 .toArray();
     }


     public long countLetter(char letter, String message){
        return message.chars().filter(character -> character == letter)
                .count();
     }

    /**
     * Returns the offset matching the smallest Chi-square.
     * @param chiSquares
     * @return
     */
     public int probableOffset(double[] chiSquares){
         int probableOffset = 0;
         for(int offset = 0; offset < chiSquares.length; offset++) {
             log.debug(String.format("Chi-Square for offset %d: %.2f", offset, chiSquares[offset]));
             if(chiSquares[offset] < chiSquares[probableOffset]){
                 probableOffset = offset;
             }
         }
         return probableOffset;
     }


}
