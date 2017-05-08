/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffms;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author sepich
 */
public class reportOneStaffInformation extends javax.swing.JInternalFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form reportStaffBasicSalary
     */
    public reportOneStaffInformation() {
        initComponents();
        conn = dbConnect.connectDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_staffid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_firstname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_lastname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_dateofbirth = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_department = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_designation = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_status = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_datehired = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_jobtitle = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_basesalary = new javax.swing.JTextField();
        jGenerateSlip = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel1.setText("Search:");

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Staff Information"));

        jLabel2.setText("Staff ID:");

        jLabel3.setText("First Name:");

        jLabel4.setText("Last Name:");

        jLabel5.setText("Date of Birth:");

        jLabel6.setText("Department:");

        jLabel7.setText("Designation:");

        jLabel8.setText("Status:");

        jLabel9.setText("Date hired:");

        jLabel10.setText("Job title:");

        jLabel11.setText("Basic Salary:");

        jGenerateSlip.setText("Generate Slip");
        jGenerateSlip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGenerateSlipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jGenerateSlip, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_staffid)
                            .addComponent(txt_firstname)
                            .addComponent(txt_lastname)
                            .addComponent(txt_dateofbirth)
                            .addComponent(txt_department, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_designation)
                            .addComponent(txt_status)
                            .addComponent(txt_datehired)
                            .addComponent(txt_jobtitle)
                            .addComponent(txt_basesalary, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_staffid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_designation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_datehired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_dateofbirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_jobtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_basesalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jGenerateSlip, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
        try{
//            Class.forName("org.sqlite.JDBC");
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/sepich/NetBeansProjects/StaffManagementSystem/mydatabase.sqlite");

            String sql = "select * from Staff_Information where id=? ";

            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_search.getText());
            rs = pst.executeQuery();

            String add1 = rs.getString("id");
            txt_staffid.setText(add1);

            String add2 = rs.getString("first_name");
            txt_firstname.setText(add2);

            String add3 = rs.getString("last_name");
            txt_lastname.setText(add3);

            String add4 = rs.getString("date_of_birth");
            txt_dateofbirth.setText(add4);

            String add5 = rs.getString("department");
            txt_department.setText(add5);

            String add6 = rs.getString("basic_salary");
            txt_basesalary.setText(add6);

            String add7 = rs.getString("status");
            txt_status.setText(add7);

            String add8 = rs.getString("job_title");
            txt_jobtitle.setText(add8);

            String add9 = rs.getString("date_hier");
            txt_datehired.setText(add9);

            // String add10 = rs.getString("Designation");
            //txt_designation.setText(add10);

        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "No Data Connetion");
        }
        finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
            }
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void jGenerateSlipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGenerateSlipActionPerformed
        // TODO add your handling code here:
        String value = txt_firstname.getText();
        String value0 = txt_lastname.getText();
        String value1 = txt_staffid.getText();
        String value2 = txt_department.getText();

        JFileChooser dialog = new JFileChooser();
        dialog.setSelectedFile(new File(value + " " + value0 + "-Salary Slip" + ".pdf"));
        int dialogResult = dialog.showSaveDialog(null);

        if(dialogResult == JFileChooser.APPROVE_OPTION){
            String filePath = dialog.getSelectedFile().getPath();

            try{
//                Class.forName("org.sqlite.JDBC");
//                Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/sepich/NetBeansProjects/StaffManagementSystem/mydatabase.sqlite");

                String sql = "select * from Deductions where staff_id= '"+value1+"' ";

                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                String val = rs.getString(5);
                String reason = rs.getString(6);
                rs.close();
                pst.close();

                String sq = "select * from Allowance where staff_id = '"+value1+"' ";
                pst = conn.prepareStatement(sq);
                rs = pst.executeQuery();
                String overTime = rs.getString(2);
                String medical = rs.getString(3);
                String bonus = rs.getString(4);
                String other = rs.getString(5);

                int calcTotal = Integer.parseInt(txt_basesalary.getText());
                float x = Float.valueOf(rs.getString(9));
                int v = Integer.parseInt(val);
                float total = calcTotal + x - v;

                Document myDocument = new Document();
                PdfWriter myWriter = PdfWriter.getInstance(myDocument,new FileOutputStream (filePath));

                myDocument.open();

                myDocument.add(new Paragraph("PAY SLIP", FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD)));
                myDocument.add(new Paragraph(new Date().toString() ));
                myDocument.add(new Paragraph("-----------------------------------------------------------------"));
                myDocument.add(new Paragraph("STAFF DETAILS", FontFactory.getFont(FontFactory.TIMES_BOLD,16,Font.BOLD)));
                myDocument.add(new Paragraph("Name of Staff: "+value+" "+value0, FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN)));
                myDocument.add(new Paragraph("Department: "+value2, FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN)));
                myDocument.add(new Paragraph("-----------------------------------------------------------------"));
                myDocument.add(new Paragraph("SALARY", FontFactory.getFont(FontFactory.TIMES_BOLD,16,Font.BOLD)));
                myDocument.add(new Paragraph("Basic Salary: "+calcTotal, FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN)));
                myDocument.add(new Paragraph("Overtime: "+overTime, FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN)));
                myDocument.add(new Paragraph("Medical: "+medical, FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN)));
                myDocument.add(new Paragraph("Bonus: "+bonus, FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN)));
                myDocument.add(new Paragraph("Other: "+other, FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN)));
                myDocument.add(new Paragraph("-----------------------------------------------------------------"));
                myDocument.add(new Paragraph("DEDUCTION", FontFactory.getFont(FontFactory.TIMES_BOLD,16,Font.BOLD)));
                myDocument.add(new Paragraph("Deduction Details: "+reason, FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN)));
                myDocument.add(new Paragraph("Total Deduction: "+overTime, FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN)));
                myDocument.add(new Paragraph("Medical: "+val, FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN)));
                myDocument.add(new Paragraph("-----------------------------------------------------------------"));
                myDocument.add(new Paragraph("TOTAL PAYMENT", FontFactory.getFont(FontFactory.TIMES_BOLD,16,Font.BOLD)));
                myDocument.add(new Paragraph("Total Earnings: "+ rs.getString(9), FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN)));
                myDocument.add(new Paragraph("Net Pay: "+ total, FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.PLAIN)));
                myDocument.add(new Paragraph("-----------------------------------------------------------------"));

                myDocument.newPage();
                myDocument.close();
                JOptionPane.showMessageDialog(null, "Report was successfully generate");

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);

            }
        }

    }//GEN-LAST:event_jGenerateSlipActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jGenerateSlip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_basesalary;
    private javax.swing.JTextField txt_datehired;
    private javax.swing.JTextField txt_dateofbirth;
    private javax.swing.JTextField txt_department;
    private javax.swing.JTextField txt_designation;
    private javax.swing.JTextField txt_firstname;
    private javax.swing.JTextField txt_jobtitle;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_staffid;
    private javax.swing.JTextField txt_status;
    // End of variables declaration//GEN-END:variables
}
