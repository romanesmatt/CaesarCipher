import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.*;

public class CaesarCipherEncryptionTests {
    @Test
    public void testCaesarCipher_001(){
        CaesarCipher cipher = new CaesarCipher();
        String cipheredMessage = cipher.cipher("he told me i could never teach a llama to drive", 3);
        String expectedResult = "kh wrog ph l frxog qhyhu whdfk d oodpd wr gulyh";

        assertEquals(cipheredMessage, expectedResult);
    }

    @Test
    public void testCaesarCipher_002(){
        CaesarCipher cipher = new CaesarCipher();
        String cipheredMessage = cipher.cipher("mclaren racing", 4);
        String expectedResult = "qgpevir vegmrk";

        assertEquals(cipheredMessage, expectedResult);
    }

    @Test
    public void testCaesarCipher_003(){
        CaesarCipher cipher = new CaesarCipher();
        String cipheredMessage = cipher.cipher("oracle red bull racing", 11);
        String expectedResult = "zclnwp cpo mfww clntyr";

        assertEquals(cipheredMessage, expectedResult);
    }

}
