package com.lin.design.patterns.decorator;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 1/27/2022
 */
public class Application {
    public static void main(String[] args) {
        DataSource source = new FileDataSource();
        // The target file has been written with plain data.
        source.writeData("Hello World");

        // The target file has been written with compressed data.
        source = new CompressionDecorator(source);
        source.writeData("Hello World");

        // The target file has been written with encrypted and compressed data.
        source = new EncryptionDecorator(source);
        source.writeData("Hello World");  //Encryption > Compression > FileDataSource

    }
}
