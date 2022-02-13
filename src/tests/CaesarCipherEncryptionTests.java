package tests;

import cipher.CaesarCipher;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CaesarCipherEncryptionTests {

    /**
     * Testing the encryption of a given sentence with an offset of 3.
     */
    @Test
    public void testCaesarCipher_001(){
        CaesarCipher cipher = new CaesarCipher();
        String cipheredMessage = cipher.cipher("he told me i could never teach a llama to drive", 3);
        String expectedResult = "kh wrog ph l frxog qhyhu whdfk d oodpd wr gulyh";

        assertEquals(cipheredMessage, expectedResult);
    }


    /**
     * Testing the encryption of a given sentence with an offset of 4.
     */
    @Test
    public void testCaesarCipher_002(){
        CaesarCipher cipher = new CaesarCipher();
        String cipheredMessage = cipher.cipher("mclaren racing", 4);
        String expectedResult = "qgpevir vegmrk";

        assertEquals(cipheredMessage, expectedResult);
    }

    /**
     * Testing the encryption of a given sentence with an offset of 11.
     */
    @Test
    public void testCaesarCipher_003(){
        CaesarCipher cipher = new CaesarCipher();
        String cipheredMessage = cipher.cipher("oracle red bull racing", 11);
        String expectedResult = "zclnwp cpo mfww clntyr";

        assertEquals(cipheredMessage, expectedResult);
    }

    /**
     * Testing the encryption of a given sentence with an offset of 16.
     */
    @Test
    public void testCaesarCipher_004(){
        CaesarCipher cipher = new CaesarCipher();
        String cipheredMessage = cipher.cipher("scuderia ferrari", 16);
        String expectedResult = "isktuhyq vuhhqhy";

        assertEquals(cipheredMessage, expectedResult);
    }

}
