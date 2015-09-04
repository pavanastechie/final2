/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * saveemployee.java
 *
 * Created on May 26, 2012, 1:43:51 AM
 */

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.sql.*;
import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import net.proteanit.sql.DbUtils;
public  class saveemployee extends javax.swing.JFrame {
 Connection conn=null;
     ResultSet rs=null;
     PreparedStatement pst=null;

    public saveemployee(String text) {
        initComponents();
        conn=javaconnect.ConnecrDb();
        CurrentDate();
        Fillcombo();
        Update_table();
        userid1.setText(text);
userid1.setVisible(false);
setTitle("WELCOME TO EMPLOYEE MANAGEMENT PAGE");

    }

    private saveemployee() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    private void Update_table()
    {
    try{
    String sql="SELECT userid,role,branch,date,time FROM employeeinfo ";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery( );
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
    }
}
    public void CurrentDate(){
    Calendar cal=new GregorianCalendar();
    int month=cal.get(Calendar.MONTH);
    int year=cal.get(Calendar.YEAR);
    int day=cal.get(Calendar.DAY_OF_MONTH);
    date.setText(day+"/"+(month+1)+"/"+year);
     int second=cal.get(Calendar.SECOND);
      int minute=cal.get(Calendar.MINUTE);
       int hour=cal.get(Calendar.HOUR);
        time.setText(hour+":"+(minute)+":"+second);

}
     private void Fillcombo(){

         try{
        String sql="select * from branch";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        while(rs.next()){
            String name=rs.getString("branchname");
             branch.addItem(name);

        }
         }
        catch(Exception e){

        }
    }
     public void close(){
        WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
      Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userid = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        role = new javax.swing.JComboBox();
        branch = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        userid1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passwordhint = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        date = new javax.swing.JMenu();
        time = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("userid");

        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("password");

        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText("role");

        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("branch");

        userid.setForeground(new java.awt.Color(153, 153, 153));
        userid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                useridKeyReleased(evt);
            }
        });

        password.setForeground(new java.awt.Color(153, 153, 153));

        role.setForeground(new java.awt.Color(51, 51, 255));
        role.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "administrator", "supervisor", "worker" }));

        branch.setForeground(new java.awt.Color(0, 51, 255));

        jButton1.setForeground(new java.awt.Color(255, 0, 153));
        jButton1.setText("CREATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        update.setForeground(new java.awt.Color(255, 0, 204));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setForeground(new java.awt.Color(255, 0, 204));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(255, 0, 255));
        jButton2.setText("LOGOUT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        back.setForeground(new java.awt.Color(255, 0, 255));
        back.setText("< BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setText("passwordhint");

        date.setForeground(new java.awt.Color(0, 0, 255));
        date.setText("date");
        jMenuBar1.add(date);

        time.setForeground(new java.awt.Color(51, 51, 255));
        time.setText("time");
        jMenuBar1.add(time);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(userid, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                                .addComponent(password))
                                            .addComponent(update))
                                        .addGap(48, 48, 48)
                                        .addComponent(delete))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(passwordhint, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(role, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(branch, javax.swing.GroupLayout.Alignment.LEADING, 0, 113, Short.MAX_VALUE)))
                                .addGap(57, 57, 57))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(userid1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(passwordhint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(update)
                            .addComponent(delete)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(userid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try{




           String sql="Insert into employeeinfo (userid,password,role,branch,date,time,passwordhint) values(?,?,?,?,?,?,?)";

           String jCombo=role.getSelectedItem().toString();
           String jCombo1=branch.getSelectedItem().toString();

           pst=conn.prepareStatement(sql);
                pst.setString(1,userid.getText());
                pst.setString(2,password.getText());

               pst.setString(3, jCombo);
                pst.setString(4, jCombo1);
                pst.setString(5, date.getText());
                pst.setString(6, time.getText());
                 pst.setString(7, passwordhint.getText());
       pst.execute();

JOptionPane.showMessageDialog(null,"Saved");
 Update_table();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

         Object item =role.getSelectedItem();
        Object item1 =branch.getSelectedItem();
        try{
                   String value1=userid.getText();
                   String value2=password.getText();
                   String value3=role.getSelectedItem().toString();
                   String value4=branch.getSelectedItem().toString();
                    String value5=passwordhint.getText();
                   


           String sql="update employeeinfo set userid='"+value1+"',password='"+value2+"',role='"+value3+"',branch='"+value4+"',passwordhint='"+value5+"' where userid='"+value1+"'";
           pst=conn.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(null, "Updated");

       }
catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
    }
            Update_table();
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String sql1="delete from employeeinfo  where userid=? ";

try{
            pst=conn.prepareStatement(sql1);
     pst.setString(1, userid.getText());
               pst.execute();

JOptionPane.showMessageDialog(null,"Deleted");

            Update_table();
               }


        catch (Exception e){
            JOptionPane.showMessageDialog(null,e );



    }
    }//GEN-LAST:event_deleteActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
           close();
        admin s=new admin(this.userid1.getText());
       s.setVisible(true);
       this.addPropertyChangeListener((PropertyChangeListener) s);
    }//GEN-LAST:event_backActionPerformed

    private void useridKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_useridKeyReleased
        firePropertyChange("textchange", "", userid1.getText());
    }//GEN-LAST:event_useridKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         close();
                    login s=new login();
                    s.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new saveemployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JComboBox branch;
    private javax.swing.JMenu date;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField password;
    private javax.swing.JTextField passwordhint;
    private javax.swing.JComboBox role;
    private javax.swing.JMenu time;
    private javax.swing.JButton update;
    private javax.swing.JTextField userid;
    private javax.swing.JTextField userid1;
    // End of variables declaration//GEN-END:variables

}