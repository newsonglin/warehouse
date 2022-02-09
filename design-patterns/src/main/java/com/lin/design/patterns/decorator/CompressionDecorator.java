package com.lin.design.patterns.decorator;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 1/27/2022
 */
public class CompressionDecorator extends DataSourceDecorator{
    public CompressionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {
        // 1. Compress passed data.
        data="Compressed:"+data;
        // 2. Pass compressed data to the wrappee's writeData method.
        super.writeData(data);
    }

    @Override
    public String readData() {
        // 1. Get data from the wrappee's readData method.
        String compressedData=super.readData();
        // 2. Try to decompress it if it's compressed.
        String decompress=compressedData.replace("Compressed:","");
        // 3. Return the result.
        return decompress;
    }
}
