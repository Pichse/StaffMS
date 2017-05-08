/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffms;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author sepich
 */
public class reportCode {
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst = null;
    
    public void StaffReport(){
           JFileChooser dialog = new JFileChooser();
                dialog.setSelectedFile(new File("Employees Report.pdf"));
                int dialogResult = dialog.showSaveDialog(null);
                if (dialogResult==JFileChooser.APPROVE_OPTION){
                String filePath = dialog.getSelectedFile().getPath();
                conn = dbConnect.connectDB();

            try {
                // TODO add your handling code here:
//                Class.forName("org.sqlite.JDBC");
//                Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/sepich/NetBeansProjects/StaffManagementSystem/mydatabase.sqlite");    
                String sql ="select * from Staff_Information";


                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();


               Document myDocument = new Document();
               PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
               PdfPTable table = new PdfPTable(13);
               myDocument.open();


               float[] columnWidths = new float[] {3,8,7,5,5,9,8,9,6,6,6,8,8};
               table.setWidths(columnWidths);

               table.setWidthPercentage(100); //set table width to 100%


              myDocument.add(new Paragraph("Employees List",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
              myDocument.add(new Paragraph(new Date().toString()));
              myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
              table.addCell(new PdfPCell(new Paragraph("ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
              table.addCell(new PdfPCell(new Paragraph("First Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
              table.addCell(new PdfPCell(new Paragraph("Last Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
              table.addCell(new PdfPCell(new Paragraph("Date of Birth",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
              table.addCell(new PdfPCell(new Paragraph("Gender",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
              table.addCell(new PdfPCell(new Paragraph("Contact",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
              table.addCell(new PdfPCell(new Paragraph("Email",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
              table.addCell(new PdfPCell(new Paragraph("Address",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
              table.addCell(new PdfPCell(new Paragraph("Department",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
              table.addCell(new PdfPCell(new Paragraph("Status",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
              table.addCell(new PdfPCell(new Paragraph("Date Hired",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
              table.addCell(new PdfPCell(new Paragraph("Basic Salary",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
              table.addCell(new PdfPCell(new Paragraph("Job Title",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));

              while(rs.next())
                {


               table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
               table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
               table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
               table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
               table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
               table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
               table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
               table.addCell(new PdfPCell(new Paragraph(rs.getString(8),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
               table.addCell(new PdfPCell(new Paragraph(rs.getString(9),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
               table.addCell(new PdfPCell(new Paragraph(rs.getString(10),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
               table.addCell(new PdfPCell(new Paragraph(rs.getString(11),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
               table.addCell(new PdfPCell(new Paragraph(rs.getString(12),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
               table.addCell(new PdfPCell(new Paragraph(rs.getString(13),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));

                }

               myDocument.add(table);
               myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
               myDocument.close();  
               JOptionPane.showMessageDialog(null,"Report was successfully generated");

         }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);


         }
         finally {

                try{
                    rs.close();
                    pst.close();

                }
                catch(Exception e){
                JOptionPane.showMessageDialog(null,e);

                }
         }
       }
    }
    public void AllowanceReport(){
                   JFileChooser dialog = new JFileChooser();
                   dialog.setSelectedFile(new File("Employee Allowance Report.pdf"));
                   int dialogResult = dialog.showSaveDialog(null);
                   if (dialogResult==JFileChooser.APPROVE_OPTION){
                   String filePath = dialog.getSelectedFile().getPath();
                   
                   conn = dbConnect.connectDB();

               try {
                   // TODO add your handling code here:
//                   Class.forName("org.sqlite.JDBC");
//                   Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/sepich/NetBeansProjects/StaffManagementSystem/mydatabase.sqlite");    
 
                   String sql ="select * from Allowance";


                   pst=conn.prepareStatement(sql);
                   rs=pst.executeQuery();


                  Document myDocument = new Document();
                  PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
                  PdfPTable table = new PdfPTable(11);
                  myDocument.open();


                  float[] columnWidths = new float[] { 3,7,7,5,5,9,6,5,8,8,8};
                  table.setWidths(columnWidths);

                  table.setWidthPercentage(100); //set table width to 100%


                  myDocument.add(new Paragraph("Employees Allowance List",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
                  myDocument.add(new Paragraph(new Date().toString()));
                  myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                 table.addCell(new PdfPCell(new Paragraph("ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                 table.addCell(new PdfPCell(new Paragraph("Overtime",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                 table.addCell(new PdfPCell(new Paragraph("Medical",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                 table.addCell(new PdfPCell(new Paragraph("Bonus",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                 table.addCell(new PdfPCell(new Paragraph("Other",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                 table.addCell(new PdfPCell(new Paragraph("Employee ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                 table.addCell(new PdfPCell(new Paragraph("Salary",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                 table.addCell(new PdfPCell(new Paragraph("Rate",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                 table.addCell(new PdfPCell(new Paragraph("Allowance",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                 table.addCell(new PdfPCell(new Paragraph("First Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                 table.addCell(new PdfPCell(new Paragraph("Last Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));


                 while(rs.next())
                   {


                  table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                  table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                  table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                  table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                  table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                  table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                  table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                  table.addCell(new PdfPCell(new Paragraph(rs.getString(8),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                  table.addCell(new PdfPCell(new Paragraph(rs.getString(9),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                  table.addCell(new PdfPCell(new Paragraph(rs.getString(10),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                  table.addCell(new PdfPCell(new Paragraph(rs.getString(11),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));

                   }

                  myDocument.add(table);
                  myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
                  myDocument.close();  
                  JOptionPane.showMessageDialog(null,"Report was successfully generated");

            }
               catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);


            }
            finally {

                   try{
                       rs.close();
                       pst.close();

                   }
                   catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);

                   }
            }
        }
    }
    public void DeductionReport(){
                    JFileChooser dialog = new JFileChooser();
                    dialog.setSelectedFile(new File("Employee Deduction Report.pdf"));
                    int dialogResult = dialog.showSaveDialog(null);
                    if (dialogResult==JFileChooser.APPROVE_OPTION){
                    String filePath = dialog.getSelectedFile().getPath();
                    
                    conn = dbConnect.connectDB();

                try {
                    // TODO add your handling code here:
//                    Class.forName("org.sqlite.JDBC");
//                    Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/sepich/NetBeansProjects/StaffManagementSystem/mydatabase.sqlite");    

                    String sql ="select * from Deductions";


                    pst=conn.prepareStatement(sql);
                    rs=pst.executeQuery();


                   Document myDocument = new Document();
                   PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
                   PdfPTable table = new PdfPTable(8);
                   myDocument.open();


                   float[] columnWidths = new float[] { 3,7,7,5,5,9,6,5};
                   table.setWidths(columnWidths);

                   table.setWidthPercentage(100); //set table width to 100%


                   myDocument.add(new Paragraph("Employees Deduction List",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
                   myDocument.add(new Paragraph(new Date().toString()));
                   myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                  table.addCell(new PdfPCell(new Paragraph("ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                  table.addCell(new PdfPCell(new Paragraph("First Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                  table.addCell(new PdfPCell(new Paragraph("Last Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                  table.addCell(new PdfPCell(new Paragraph("Salary",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                  table.addCell(new PdfPCell(new Paragraph("Deduction Amount",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                  table.addCell(new PdfPCell(new Paragraph("Deduction Reason",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                  table.addCell(new PdfPCell(new Paragraph("Employee ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
                  table.addCell(new PdfPCell(new Paragraph("Created By",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));



                  while(rs.next())
                    {
                   table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                   table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                   table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                   table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                   table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                   table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                   table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
                   table.addCell(new PdfPCell(new Paragraph(rs.getString(8),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));


                    }

                   myDocument.add(table);
                   myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
                   myDocument.close();  
                   JOptionPane.showMessageDialog(null,"Report was successfully generated");

             }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);


             }
             finally {

                    try{
                        rs.close();
                        pst.close();

                    }
                    catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);

                    }
             }
        }
    }

}
