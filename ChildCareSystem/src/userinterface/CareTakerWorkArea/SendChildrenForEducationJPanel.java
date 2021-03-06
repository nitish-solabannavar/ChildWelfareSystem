/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CareTakerWorkArea;

import Business.EcoSystem;
import Business.EducationChildren.EducationChildren;
import Business.Enterprise.Enterprise;
import Business.FosterCareChildren.FosterCareChildren;
import Business.Organization.EducationOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EducationChildrenWorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nitis
 */
public class SendChildrenForEducationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SendChildrenForEducationJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem system;
    public SendChildrenForEducationJPanel(JPanel userProcessContainer, EcoSystem system, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        this.system = system;
        populateViewVolunteerTable();
    }
    
    public void populateViewVolunteerTable() {
        
        DefaultTableModel model = (DefaultTableModel) tblViewVolunteers.getModel();

        model.setRowCount(0);
                for (FosterCareChildren child : enterprise.getFosterCareDirectory().getFosterCareChildrenList()) {
                    Object[] row = new Object[2];
                    row[0] = child;
                    row[1] = child.getAge();
                    model.addRow(row);
                }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewVolunteers = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 255));

        submitJButton.setText("Send for Education");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Send Children For Education");

        tblViewVolunteers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Age"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblViewVolunteers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(backJButton)
                .addGap(130, 130, 130)
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(submitJButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(submitJButton)
                .addContainerGap(291, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        int selectedRow = tblViewVolunteers.getSelectedRow();
        if (selectedRow >= 0) {
            FosterCareChildren child = (FosterCareChildren) tblViewVolunteers.getValueAt(selectedRow, 0);
            String name = child.getName();
            int age = child.getAge();
        
        if(child.getAge() > 5){
            enterprise.getFosterCareDirectory().removeFosterCareChildren(child);
            populateViewVolunteerTable();

            EducationChildrenWorkRequest req = new EducationChildrenWorkRequest();
            EducationChildren children = new EducationChildren();
            children.setName(name);
            children.setAge(age);
            children.setStatus(true);
            req.setChild(children);

            for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof EducationOrganization) {
                    organization.getWorkQueue().getWorkRequestList().add(req);
                }
            }

            JOptionPane.showMessageDialog(null, "Request successfully sent to Education", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Only children above the age of 5 can be sent to education", "Warning", JOptionPane.WARNING_MESSAGE);               
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTable tblViewVolunteers;
    // End of variables declaration//GEN-END:variables
}
