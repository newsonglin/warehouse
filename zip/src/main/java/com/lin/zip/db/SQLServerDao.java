package com.lin.zip.db;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SQLServerDao {

    public static void main(String[] args) {
        ResultSet rs = null;
        Connection con = null;
        Statement statement=null;
        try {
            String sql = "select BYTES_ from EPB_OP_DOCGEN_DATASOURCE datasource";
            con = JDBCSQLServerConnection.getConnection();

            statement = con.createStatement();
            rs = statement.executeQuery(sql);

            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(new File("lin.zip")));


            while (rs.next()){
                byte[] bytes=rs.getBytes(1);
//                System.out.println(new String(bytes, StandardCharsets.UTF_8));

                for (int i=0;i<1000;i++) {
                    String fileName="EIS"+rs.getRow()+"0000_"+i+".xml";
                    System.out.println(fileName);;
//                                    System.out.println(new String(bytes, StandardCharsets.UTF_8));
                    ZipEntry zipEntry=new ZipEntry(fileName);
                    out.putNextEntry(zipEntry);
                    out.write(bytes,0,bytes.length);
                    out.closeEntry();
                }

            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            JDBCSQLServerConnection.closeAll(rs, statement, con);
        }


    }
}
