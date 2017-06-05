

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import javax.swing.ImageIcon;
import javax.swing.JSlider;


/**
 *
 * @author HP
 */

public class colorSegFrame extends javax.swing.JFrame {
     int threshold;
     ColorSegmentation cseg;
     BufferedImage outputImage;
    /**
     * Creates new form colorSegFrame
     */
    public colorSegFrame() {
                initComponents();
                 cseg=new ColorSegmentation(MainSegFrame.image);
                 cseg.segmentize(10);
                 colorslider.setEnabled(false);
                 jRadioButton2.setSelected(true);
       // this.image=image;
        
             Rectangle rect = colorsource.getBounds();
      Image scimage = MainSegFrame.image.getScaledInstance(rect.width,rect.height,Image.SCALE_DEFAULT);
     
       ImageIcon icon = new ImageIcon(scimage); 
        colorsource.setIcon(icon);
        
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        colorslider = new javax.swing.JSlider();
        bcolorsave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Tfthresh = new javax.swing.JTextField();
        colorsource = new javax.swing.JLabel();
        colordest = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Threshold");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 350, 80, 16);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jRadioButton1.setText("Enable");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(60, 380, 67, 27);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jRadioButton2.setText("Disable");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(60, 410, 71, 27);

        colorslider.setMajorTickSpacing(20);
        colorslider.setMaximum(255);
        colorslider.setMinorTickSpacing(10);
        colorslider.setPaintLabels(true);
        colorslider.setPaintTicks(true);
        colorslider.setSnapToTicks(true);
        colorslider.setValue(10);
        colorslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                colorsliderStateChanged(evt);
            }
        });
        getContentPane().add(colorslider);
        colorslider.setBounds(170, 400, 450, 50);

        bcolorsave.setText("Save");
        bcolorsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcolorsaveActionPerformed(evt);
            }
        });
        getContentPane().add(bcolorsave);
        bcolorsave.setBounds(640, 360, 57, 23);

        jLabel2.setText("Threshold");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(361, 360, 100, 14);

        Tfthresh.setEditable(false);
        getContentPane().add(Tfthresh);
        Tfthresh.setBounds(440, 360, 50, 20);

        colorsource.setText("\n");
        colorsource.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(colorsource);
        colorsource.setBounds(80, 60, 280, 230);

        colordest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(colordest);
        colordest.setBounds(400, 60, 290, 230);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void colorsliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_colorsliderStateChanged
        // TODO add your handling code here:
       
        
               JSlider source = (JSlider)evt.getSource();
	        if (!source.getValueIsAdjusting()) {
				System.out.println("threshold="+source.getValue());
				threshold=source.getValue();
				Tfthresh.setText(""+source.getValue());
                               BufferedImage outimg= cseg.segmentize(threshold);
                               outputImage=outimg;
                               Rectangle rect = colordest.getBounds();
                               Image scimage = outimg.getScaledInstance(rect.width,rect.height,Image.SCALE_DEFAULT);
                              ImageIcon icon = new ImageIcon(scimage); 
                              colordest.setIcon(icon);
                                
                } 
        
        
    }//GEN-LAST:event_colorsliderStateChanged

    private void bcolorsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcolorsaveActionPerformed
        // TODO add your handling code here:
        FileHandling fh=new FileHandling(this);
        if(jRadioButton2.isSelected()==true){
            BufferedImage outimg= cseg.segmentize(10);
            outputImage=outimg;
        }
        fh.WriteImage(outputImage);
    }//GEN-LAST:event_bcolorsaveActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        colorslider.setEnabled(true);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        colorslider.setEnabled(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(colorSegFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(colorSegFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(colorSegFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(colorSegFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new colorSegFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Tfthresh;
    private javax.swing.JButton bcolorsave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel colordest;
    private javax.swing.JSlider colorslider;
    private javax.swing.JLabel colorsource;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    // End of variables declaration//GEN-END:variables
}