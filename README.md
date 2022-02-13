# CaesarCipher
 This project is a Java implementation of the famous Caesar Cipher used by the emperor himself in private conversation. This project includes implementations of encryption and decryption using the Caesar cipher, as well as a method that can break it.
 
 ## How It Works
The Caesar Cipher is a substitution cipher, meaning it will replace a plaintext letter with a letter of some fixed number of positions down the alphabet. For example, with a left shift of 3, the letter O would be the letter L, W would be T, and so on. 
 
 ## Encryption
 The cipher() method handles encryption. Its parameters are the message and the offset being used for encryption.
 
 ## Decryption
 The decipher() method handles decryption. Its parameters are similar to the cipher() method.
 
 
 ## Breaking the Cipher
The project has two methods for breaking the cipher: breakCipher() and chiSquares(). In this project, the cipher is broken using the Chi-squared statistic on the assumption that as the attacker, it does not know what the offset is. The Chi-squared statistic will provide a number telling us whether two distributions are similar or not. The smaller the number, the more similar they are.
 
 ## Running the Project
 The project has no main method to run it. Instead, it uses a series of JUnit tests to run encryption, decryption and breaking of the cipher respectively. Each method is commented to reflect the test being conducted.
 
 
