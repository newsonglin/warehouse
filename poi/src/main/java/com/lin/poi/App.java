package com.lin.poi;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class App {

    private static void setCellValue(XWPFTableCell cell, Object value) {
        String strValue = value == null ? "" : value.toString();

        Optional.ofNullable(cell)
                .map(c -> c.getParagraphs())
                .map(p -> p.get(0))
                .map(p -> p.getRuns())
                .filter(l-> CollectionUtils.isNotEmpty(l))
                .map(r -> r.get(0))
                .ifPresent(r -> r.setText(strValue, 0));
    }

    private static void setCellValue(XWPFTable table, Point cellAddress, Object value) {
        String strValue = value == null ? "" : value.toString();

        Optional.ofNullable(table)
                .map(t -> t.getRow(cellAddress.x).getCell(cellAddress.y))
                .map(c -> c.getParagraphs())
                .map(p -> p.get(0))
                .map(p -> p.getRuns())
                .map(r -> r.get(0))
                .ifPresent(r -> r.setText(strValue, 0));
    }

    public static void main(String[] args) throws  Exception{
        InputStream inputStream = new FileInputStream(new File("D:\\projects\\personal\\github\\warehouse\\poi\\src\\main\\resources" +
                "\\AgentGuildApplyChangeCompanyCensusEducation.docx"));
        try (XWPFDocument document = new XWPFDocument(inputStream)) {
            List<XWPFTable> tables = document.getTables();
            System.out.println("tables = " + tables.size());
            document.removeBodyElement(document.getPosOfTable(tables.get(0)));
            tables = document.getTables();
            System.out.println("tables = " + tables.size());
//            document.removeBodyElement(document.getPosOfTable(tables.get(0)));
//            tables = document.getTables();
//            System.out.println("tables = " + tables.size());
//            document.removeBodyElement(document.getPosOfTable(tables.get(0)));
//            tables = document.getTables();
//            System.out.println("tables = " + tables.size());

//            XWPFTable tab = tables.get(2);
//
//            tab.getCTTbl().getTblPr().getTblBorders().getLeft().setVal(STBorder.NONE);
//            tab.getCTTbl().getTblPr().getTblBorders().getRight().setVal(STBorder.NONE);
//            tab.getCTTbl().getTblPr().getTblBorders().getTop().setVal(STBorder.NONE);
//            tab.getCTTbl().getTblPr().getTblBorders().getBottom().setVal(STBorder.NONE);
//            tab.getCTTbl().getTblPr().getTblBorders().getInsideH().setVal(STBorder.NONE);
//            tab.getCTTbl().getTblPr().getTblBorders().getInsideV().setVal(STBorder.NONE);

            XWPFTable table = tables.get(0);
            XWPFTableRow firstRow = table.getRow(5);

            XWPFTableRow newRow = null;
            for (int i=1;i<12;i++) {
                CTRow ctRow = CTRow.Factory.parse(firstRow.getCtRow().newInputStream());
                newRow = new XWPFTableRow(ctRow, table);

//                newRow.getCell(0).getParagraphs().get(0).getRuns().get(0).setText("a",0);
                setCellValue(newRow.getCell(0),"sdf");
                newRow.getCell(1).setText("a");
                newRow.getCell(2).setText("a");
                newRow.getCell(3).setText("a");
                newRow.getCell(4).setText("a");
                newRow.getCell(5).setText("a");
                newRow.getCell(6).setText("a");

                table.addRow(newRow, 5 + i);
            }




//            int pos=document.getPosOfTable(tables.get(1));
//            document.removeBodyElement(pos);

            List<XWPFParagraph> paragraphs= document.getParagraphs();
            System.out.println("paragraphs.size() = " + paragraphs.size());

            document.getParagraphs().forEach(
                    p->p.getRuns().forEach(
                            r-> {

//                                System.out.println("===="+(r.getCTR().getTArray()==null?0:r.getCTR().getTArray().length));

                                if (r.getText(0)!=null && r.getText(0).contains("${changeItems}")){
                                    r.setText( r.getText(0).replace("${changeItems}","哈哈中"),0);
                                }
                                System.out.println( r.getText(0));
                            }
                    )
            );


            FileOutputStream target = new FileOutputStream("d:\\test.docx");
            document.write(target);
            target.flush();
            target.close();
        }
    }

}
