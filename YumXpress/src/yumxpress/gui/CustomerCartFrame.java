package yumxpress.gui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.mail.MessagingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import yumxpress.dao.OrderDAO;
import yumxpress.dao.ProductDAO;
import yumxpress.dao.StaffDAO;
import yumxpress.pojo.OrderPojo;
import yumxpress.pojo.PlaceOrderPojo;
import yumxpress.pojo.ProductPojo;
import yumxpress.util.Mailer;
import yumxpress.util.UserProfile;

/**
 *
 * @author Admin
 */

public class CustomerCartFrame extends javax.swing.JFrame {
    private DefaultTableModel model;
    private ProductPojo product;
    private List<ProductPojo> productList;
    
    private JFrame showFrame;
    
    /**
     * Creates new form CustomerCartFrame
     */
    public CustomerCartFrame(){
        initComponents();
        this.setLocationRelativeTo(null);
        this.lblUserProfile.setText("Hello " + UserProfile.getUserName().trim());
        model=(DefaultTableModel)jtCartTable.getModel();
        
    }
    public CustomerCartFrame(ProductPojo product){
        this();
        this.product = product;
        loadProductDetails(product.getProductId().trim());
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCartTable = new javax.swing.JTable();
        btnOrderCart = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnOrderFood = new javax.swing.JButton();
        btnCancelOrder = new javax.swing.JButton();
        btnOrderHistory = new javax.swing.JButton();
        btnMyAccount = new javax.swing.JButton();
        lblUserProfile = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Cart Frame");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtCartTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtCartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT NAME", "PRODUCT PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCartTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCartTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 620, 370));

        btnOrderCart.setBackground(new java.awt.Color(51, 153, 255));
        btnOrderCart.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnOrderCart.setForeground(new java.awt.Color(254, 255, 254));
        btnOrderCart.setText("Order (0)");
        btnOrderCart.setEnabled(false);
        btnOrderCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderCartActionPerformed(evt);
            }
        });
        jPanel1.add(btnOrderCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 219, 48));

        btnBack.setBackground(new java.awt.Color(51, 153, 255));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnBack.setForeground(new java.awt.Color(254, 255, 254));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 219, 48));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 630, 460));

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOrderFood.setBackground(new java.awt.Color(255, 176, 9));
        btnOrderFood.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnOrderFood.setText("Order Food");
        btnOrderFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderFoodActionPerformed(evt);
            }
        });
        jPanel3.add(btnOrderFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 220, 40));

        btnCancelOrder.setBackground(new java.awt.Color(255, 176, 9));
        btnCancelOrder.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCancelOrder.setText("Cancel Order");
        btnCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelOrderActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 220, 40));

        btnOrderHistory.setBackground(new java.awt.Color(255, 176, 9));
        btnOrderHistory.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnOrderHistory.setText("Order History");
        btnOrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderHistoryActionPerformed(evt);
            }
        });
        jPanel3.add(btnOrderHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 220, 40));

        btnMyAccount.setBackground(new java.awt.Color(255, 176, 9));
        btnMyAccount.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnMyAccount.setText("My Account");
        btnMyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyAccountActionPerformed(evt);
            }
        });
        jPanel3.add(btnMyAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 220, 40));

        lblUserProfile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUserProfile.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(lblUserProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 200, 34));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/user.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 7));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 280, 560));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 65)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("My Cart");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtCartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCartTableMouseClicked
       
    }//GEN-LAST:event_jtCartTableMouseClicked

    private void btnOrderCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderCartActionPerformed
        
        int index = jtCartTable.getSelectedRow();
       // OrderPojo order=orderList.get(index);
        ProductPojo prdlist = productList.get(index);
        PlaceOrderPojo placeOrder=new PlaceOrderPojo();
        placeOrder.setCompanyId(product.getCompanyId());
        placeOrder.setProductId(product.getProductId());
        placeOrder.setCustomerId(UserProfile.getUserId());
        String[] str = {"Remove", "Order"};
        
        try{
            String staffId=StaffDAO.getRandomStaffIdFromCompany(product.getCompanyId());
            placeOrder.setDeliveryStaffId(staffId);
            String orderId=OrderDAO.placeOrder(placeOrder);
            int choice = JOptionPane.showOptionDialog(null, "What do you want to do ?", "Select", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, str, str[1]);
            if(choice==0){
                model.removeRow(index);
                productList.remove(index);
                JOptionPane.showMessageDialog(null,"Product removed !");
                return ;
            }else
            if(orderId==null){
              JOptionPane.showMessageDialog(null,"Sorry ! Order cannot be placed");
              return;
            }
          JOptionPane.showMessageDialog(null," Order placed ");
          OrderPojo orderDetails=OrderDAO.getOrderDetailsByOrderId(orderId);
          Map<String,String>emailCredentials=new HashMap<>();
                emailCredentials.put("emailId", "yumxpress45@gmail.com");
                emailCredentials.put("securityKey", "yphl aeor glam aixu");
                Mailer.sendMail(emailCredentials, orderDetails);
          JOptionPane.showMessageDialog(null," Email Sent Successfully to:"+UserProfile.getEmailId());
          this.dispose();
          new CustomerCartFrame().setVisible(true);
        }catch(SQLException sq){
            JOptionPane.showMessageDialog(null,"DB ERROR IN CustomerCartFrame");
            sq.printStackTrace();
        }catch(MessagingException sq){
            JOptionPane.showMessageDialog(null,"MAIL ERROR IN CustomerCartFrame");
            sq.printStackTrace();
        } 
    }//GEN-LAST:event_btnOrderCartActionPerformed

    private void btnOrderFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderFoodActionPerformed
        new OrderFoodFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnOrderFoodActionPerformed

    private void btnCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelOrderActionPerformed
        new CancelOrderFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelOrderActionPerformed

    private void btnOrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderHistoryActionPerformed
        new OrderHistoryFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnOrderHistoryActionPerformed

    private void btnMyAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyAccountActionPerformed
        new CustomerAccountFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyAccountActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new CustomerOptionFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerCartFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerCartFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerCartFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerCartFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerCartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnMyAccount;
    private javax.swing.JButton btnOrderCart;
    private javax.swing.JButton btnOrderFood;
    private javax.swing.JButton btnOrderHistory;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jtCartTable;
    private javax.swing.JLabel lblUserProfile;
    // End of variables declaration//GEN-END:variables

    private void loadProductDetails( String productId){
       try{
           productList = ProductDAO.getProductDetailsByProductId(productId);
            if(productList.isEmpty()){
                JOptionPane.showMessageDialog(null,"No Products added in your cart ");
                jtCartTable.setEnabled(false);
                return;
            }
            btnOrderCart.setEnabled(true);
           int i=0;
           Object []rows=new Object[2];
           while(i<productList.size()){
               ProductPojo prd=productList.get(i);
               rows[0]=prd.getProductName();
               rows[1]=prd.getProductPrice();
               model.addRow(rows);
               i++;   
           }
        }catch(SQLException sq){
            JOptionPane.showMessageDialog(null,"DB ERROR IN CustomerCartFrame");
            sq.printStackTrace();
        }catch(IOException io){
            JOptionPane.showMessageDialog(null,"get Invalid id");
            io.printStackTrace();
        } 
    }   
}
