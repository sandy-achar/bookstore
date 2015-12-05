package com.challengers; /**
 * Created by darkstar on 12/4/15.
 */

//For bouncy castle encryption
import org.jasypt.util.text.BasicTextEncryptor;

public class Encrypt {

    BasicTextEncryptor bte = new BasicTextEncryptor();

    //Init this object
    public Encrypt(String pass) {

        bte.setPassword(pass);

    }

    public String encryption(String text) {

        return bte.encrypt(text);

    }

    public String decryption(String text) {

        return bte.decrypt(text);
    }

}
