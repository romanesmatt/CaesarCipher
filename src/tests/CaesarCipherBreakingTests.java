package tests;

import cipher.CaesarCipher;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.*;

public class CaesarCipherBreakingTests {

    private static final CaesarCipher CIPHER = new CaesarCipher();
    /**
     * Testing the breaking of the cipher by using probability to determine the shift in letters.
     */
    @Test
    public void testCaesarCipher_001(){
        String encryptedMessage = "pfoduhq udflqj";
        String expectedSentenceResult = "mclaren racing";
        int offset = CIPHER.breakCipher(encryptedMessage);
        int expectedOffsetResult = 3;
        assertEquals(offset, expectedOffsetResult);


        assertEquals(CIPHER.decipher(encryptedMessage, 3), expectedSentenceResult);


    }
}
