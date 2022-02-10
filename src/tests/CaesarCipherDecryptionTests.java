package tests;

import cipher.CaesarCipher;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CaesarCipherDecryptionTests {

    @Test
    public void testCaesarCipher_001(){
        CaesarCipher cipher = new CaesarCipher();
        String decipheredMessage = cipher.decipher("ro dyvn wo s myevn xofob dokmr k vvkwk dy nbsfo", 36);
        String expectedResult = "he told me i could never teach a llama to drive";

        assertEquals(decipheredMessage, expectedResult);
    }

    @Test
    public void testCaesarCipher_002(){
        CaesarCipher cipher = new CaesarCipher();
        String decipheredMessage = cipher.decipher("qgpevir vegmrk", 4);
        String expectedResult = "mclaren racing";

        assertEquals(decipheredMessage, expectedResult);
    }

    @Test
    public void testCaesarCipher_003(){
        CaesarCipher cipher = new CaesarCipher();
        String decipheredMessage = cipher.decipher("zclnwp cpo mfww clntyr", 11);
        String expectedResult = "oracle red bull racing";

        assertEquals(decipheredMessage, expectedResult);
    }

    @Test
    public void testCaesarCipher_004(){
        CaesarCipher cipher = new CaesarCipher();
        String decipheredMessage = cipher.decipher("isktuhyq vuhhqhy", 16);
        String expectedResult = "scuderia ferrari";

        assertEquals(decipheredMessage, expectedResult);
    }

}
