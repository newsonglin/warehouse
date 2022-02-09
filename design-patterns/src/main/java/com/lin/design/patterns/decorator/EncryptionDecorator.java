package com.lin.design.patterns.decorator;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * The class in learn/exercises project,Concrete decorators must call methods on the wrapped object,
 * but may add something of their own to the result. Decorators can execute the added behavior either before or after the
 * call to a wrapped object.
 *
 * @author Songlin Li
 * @since 1/27/2022
 */
public class EncryptionDecorator extends DataSourceDecorator{

    public EncryptionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {
        // 1. Encrypt passed data.
        byte[] encryptBytes=Base64.getEncoder().encode(data.getBytes(StandardCharsets.UTF_8));

        // 2. Pass encrypted data to the wrappee's writeData method.
        super.writeData(new String(encryptBytes));
    }

    @Override
    public String readData() {
        // 1. Get data from the wrappee's readData method.
        String encryptData= super.readData();
        // 2. Try to decrypt it if it's encrypted.
        byte[] decryptBytes= Base64.getDecoder().decode(encryptData.getBytes(StandardCharsets.UTF_8));
        // 3. Return the result.
        return new String(decryptBytes);
    }
}
