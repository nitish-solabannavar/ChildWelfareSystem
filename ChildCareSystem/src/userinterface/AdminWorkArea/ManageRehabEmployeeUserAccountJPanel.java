/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.AdminOrganization;
import Business.Organization.EducationOrganization;
import Business.Organization.FosterCareOrganization;
import Business.Organization.Organization;
import Business.Role.AdminRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author nitis
 */
public class ManageRehabEmployeeUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageRehabEmployeeUserAccountJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem system;
    public ManageRehabEmployeeUserAccountJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.enterprise = enterprise;
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateOrganization();
        populateEmployee();
        populateRole();
        populateTable();
    }
    
    private void populateOrganization() {
        cbOrg.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if ((organization instanceof FosterCareOrganization) || (organization instanceof EducationOrganization)) {
                cbOrg.addItem(organization);
            }
        }
    }

    private void populateEmployee() {
        cbEmp.removeAllItems();
        Organization org = (Organization) cbOrg.getSelectedItem();
        if (org != null) {
            for (Employee employee : org.getEmployeeDirectory().getEmployeeList()) {
                cbEmp.addItem(employee);
            }
        }
    }

    private void populateRole() {
        cbRole.removeAllItems();
        Organization org = (Organization) cbOrg.getSelectedItem();
        if (org != null) {
            for (Role role : org.getSupportedRole()) {
                if (!(role instanceof AdminRole)) {
                    cbRole.addItem(role);
                }
            }
        }
    }

    private void populateTable() {

        DefaultTableModel dtm = (DefaultTableModel) tblUserAcc.getModel();

        dtm.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                if (!ua.getRole().getName().equals(Role.RoleType.Applicant.getValue())) {
                    Object row[] = new Object[2];
                    row[0] = ua;
                    row[1] = ua.getRole();
                    dtm.addRow(row);
                }

            }
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

        tblScrollPane = new javax.swing.JScrollPane();
        tblUserAcc = new javax.swing.JTable();
        btnDeleteAcc = new javax.swing.JButton();
        lblOrg = new javax.swing.JLabel();
        cbOrg = new javax.swing.JComboBox();
        lblEmp = new javax.swing.JLabel();
        cbEmp = new javax.swing.JComboBox();
        lblRole = new javax.swing.JLabel();
        cbRole = new javax.swing.JComboBox();
        lblUserName = new javax.swing.JLabel();
        txtFldUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtFldPassword = new javax.swing.JTextField();
        btnAddAccount = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        tblUserAcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUserAcc.setMinimumSize(new java.awt.Dimension(375, 0));
        tblScrollPane.setViewportView(tblUserAcc);

        btnDeleteAcc.setText("Delete Account");
        btnDeleteAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAccActionPerformed(evt);
            }
        });

        lblOrg.setText("Organization");

        cbOrg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrgActionPerformed(evt);
            }
        });

        lblEmp.setText("Employee");

        cbEmp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEmpActionPerformed(evt);
            }
        });

        lblRole.setText("Role");

        cbRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblUserName.setText("User Name");

        lblPassword.setText("Password");

        btnAddAccount.setText("Add Account");
        btnAddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAccountActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Manage User Account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(131, 131, 131)
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addComponent(btnDeleteAcc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(lblOrg)
                        .addGap(98, 98, 98)
                        .addComponent(cbOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(lblEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(cbEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(lblUserName)
                        .addGap(107, 107, 107)
                        .addComponent(txtFldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(txtFldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(btnAddAccount)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnDeleteAcc)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrg)
                    .addComponent(cbOrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmp)
                    .addComponent(cbEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRole)
                    .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName)
                    .addComponent(txtFldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPassword)
                    .addComponent(txtFldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnAddAccount)
                .addContainerGap(142, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAccActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblUserAcc.getSelectedRow();
        if (selectedRow >= 0) {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the user account?", "Warning", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                UserAccount ua = (UserAccount) tblUserAcc.getValueAt(selectedRow, 0);

                if (ua.getRole().getName().equals("Admin Type")) {
                    JOptionPane.showMessageDialog(null, "You are not authorized to delete admin", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                enterprise.getUserAccountDirectory().deleteUserAccount(ua);
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                        if (userAccount.equals(ua)) {
                            organization.getUserAccountDirectory().deleteUserAccount(ua);
                            break;
                        }
                    }
                }

                populateTable();
                JOptionPane.showMessageDialog(null, "User account deleted successfully", "Warning", JOptionPane.WARNING_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteAccActionPerformed

    private void cbOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrgActionPerformed

        populateEmployee();
        populateRole();
    }//GEN-LAST:event_cbOrgActionPerformed

    private void cbEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEmpActionPerformed

    private void btnAddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAccountActionPerformed
        // TODO add your handling code here:

        try {
            String userName = txtFldUserName.getText();
            String password = txtFldPassword.getText();
            Organization organization = (Organization) cbOrg.getSelectedItem();
            Employee employee = (Employee) cbEmp.getSelectedItem();
            Role role = (Role) cbRole.getSelectedItem();

            if (!userName.equals("") && !password.equals("")) {

                // validate username
                String regex = "^[a-z A-Z]+$";
                Pattern namePattern = Pattern.compile(regex);
                Matcher unameMatcher = namePattern.matcher(userName);

                if (!unameMatcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Invalid characters in user name", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (password.length() > 10) {
                    JOptionPane.showMessageDialog(null, "Password should not have more than 10 characters", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                } else if (password.length() < 4) {
                    JOptionPane.showMessageDialog(null, "Password should have 4 to 10 characters", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                // check if username is unique
                if (system.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
                    if (role.getName().equals("CareTaker Type")) {
                        // dont add manager is already exists
                        if (!organization.getUserAccountDirectory().checkIfCareTakerExists(organization)) {
                            organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                            enterprise.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                            system.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                            JOptionPane.showMessageDialog(null, "User account added successfully", "Warning", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "CareTaker already exists", "Info", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        if (!organization.getUserAccountDirectory().checkIfEducatorExists(organization)) {
                            organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                            enterprise.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                            system.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                            JOptionPane.showMessageDialog(null, "User account added successfully", "Warning", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Educator already exists", "Info", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "User name already exists", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

                populateTable();
                txtFldPassword.setText("");
                txtFldUserName.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Enter values for all field", "Warning", JOptionPane.WARNING_MESSAGE);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter values for all field", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddAccountActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAccount;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteAcc;
    private javax.swing.JComboBox cbEmp;
    private javax.swing.JComboBox cbOrg;
    private javax.swing.JComboBox cbRole;
    private javax.swing.JLabel lblEmp;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblOrg;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JScrollPane tblScrollPane;
    private javax.swing.JTable tblUserAcc;
    private javax.swing.JTextField txtFldPassword;
    private javax.swing.JTextField txtFldUserName;
    // End of variables declaration//GEN-END:variables
}
