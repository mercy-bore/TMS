package com.transportsystem.pdf;


import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
@WebServlet("/ordersreport")

public class OrdersList extends HttpServlet {
    public static void main(String[] args) throws Exception{

        /* Create Connection objects */
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TMS",
                "root", "@root123");
        Statement stmt = conn.createStatement();
        /* Define the SQL query */
        ResultSet query_set = stmt.executeQuery("SELECT id, cargo, startLocation,destination,customer_id FROM orders");
        /* Step-2: Initialize PDF documents - logical objects */
        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, Files.newOutputStream(Paths.get("/home/mercy/Desktop/Reports/orders_report.pdf")));
        my_pdf_report.open();
        Font bold = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Paragraph paragraph =new Paragraph("Report for Current Orders List");
        paragraph.setFont(bold);
        paragraph.setSpacingAfter(8);
        paragraph.setAlignment(5);

        //we have four columns in our table
        PdfPTable my_report_table = new PdfPTable(5);
        //create a cell object
        PdfPCell table_cell;

        while (query_set.next()) {
            String dept_id = query_set.getString("id");
            table_cell=new PdfPCell(new Phrase(dept_id));
            my_report_table.addCell(table_cell);
            String dept_name=query_set.getString("startLocation");
            table_cell=new PdfPCell(new Phrase(dept_name));
            my_report_table.addCell(table_cell);
            String manager_id=query_set.getString("destination");
            table_cell=new PdfPCell(new Phrase(manager_id));
            my_report_table.addCell(table_cell);
            String location_id=query_set.getString("cargo");
            table_cell=new PdfPCell(new Phrase(location_id));
            my_report_table.addCell(table_cell);
            String route=query_set.getString("customer_id");
            table_cell=new PdfPCell(new Phrase(route));
            my_report_table.addCell(table_cell);
        }
        /* Attach report table to PDF */
        my_pdf_report.add(paragraph);

        my_pdf_report.add(my_report_table);
        my_pdf_report.close();

        /* Close all DB related objects */
        query_set.close();
        stmt.close();
        conn.close();

    }
}



