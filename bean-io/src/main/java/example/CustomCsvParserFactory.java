package example;

import org.beanio.stream.RecordIOException;
import org.beanio.stream.RecordReader;
import org.beanio.stream.RecordWriter;
import org.beanio.stream.csv.CsvRecordParserFactory;
import org.beanio.stream.csv.CsvWriter;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


public class CustomCsvParserFactory extends CsvRecordParserFactory {
    private Integer recordLength;
    @Override
    public RecordWriter createWriter(Writer out) throws IllegalArgumentException {
//        return new FixedLengthWriter(out, this.getRecordTerminator());
        final RecordWriter writer = super.createWriter(out);
        return new CsvWriter(out) {
            @Override
            public void write(Object o) throws IOException {

                //super.write(o);
                String[] fields=(String[])o;
                StringBuilder sbRecord= new StringBuilder();
                for(String field:fields){
                    sbRecord.append(field);
                }
                out.write(sbRecord.toString());
                out.write(System.getProperty("line.separator"));
            }

            @Override
            public void flush() throws IOException {
                writer.flush();
            }

            @Override
            public void close() throws IOException {
                writer.close();
            }
        };
    }

    @Override
    public RecordReader createReader(Reader in) throws IllegalArgumentException {
        final RecordReader reader = super.createReader(in);
        return new RecordReader() {
            public Object read() throws IOException, RecordIOException {
                String record = (String) reader.read();
                if (record != null) {
                    record = pad(record);
                }
                return record;
            }

            public void close() throws IOException {
                reader.close();
            }

            public int getRecordLineNumber() {
                return reader.getRecordLineNumber();
            }

            public String getRecordText() {
                return reader.getRecordText();
            }
        };
    }


    private String pad(String record) {
        if (recordLength == null) {
            return record;
        }
        int n = recordLength - record.length();
        if (n <= 0) {
            return record;
        }
        StringBuilder s = new StringBuilder(record);
        for (int i = 0; i < n; i++) {
            s.append(' ');
        }
        return s.toString();
    }

    public Integer getRecordLength() {
        return recordLength;
    }

    public void setRecordLength(Integer recordLength) {
        this.recordLength = recordLength;
    }
}