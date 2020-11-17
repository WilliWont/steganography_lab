/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J2LP0003;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import static java.lang.Thread.sleep;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import mdlaf.MaterialLookAndFeel;

/**
 *
 * @author Will
 */
public class SteganographyEncryptView extends javax.swing.JFrame {
    final int CHARACTER_BIT = 8;
    final int COLOR_BIT = 8;
    
    //this counts from zero, so amount is actually 3
    final int COLOR_CHANNELS = 2;
    
    private String fileName;
    
    private final Graphics ogImage;
    private final Graphics enImage;
    
    private BufferedImage originalImage;
    private BufferedImage encryptedImage;
    
    private int characterAvailable;
    private int characterCount;
    CharacterCounter cc;
    
    public SteganographyEncryptView() {
        initComponents();
        ogImage = pnlOG.getGraphics();
        enImage = pnlEN.getGraphics();
        cc = new CharacterCounter();
        characterAvailable = 0;
        characterCount = 0;
//        setTxtAreaShadow(txtMsg);
//        setPanelShadow(pnlOG);
//        setPanelShadow(pnlEN);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        txtAddr = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMsg = new javax.swing.JTextArea();
        rdNone = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        rdLZW = new javax.swing.JRadioButton();
        rdHuff = new javax.swing.JRadioButton();
        pnlOG = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnlEN = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnEncrypt = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblTxtRemaining = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtAddr.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtAddr.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("Image Address:");

        jLabel2.setBackground(new java.awt.Color(40, 40, 40));
        jLabel2.setFont(new java.awt.Font("Raleway Black", 1, 48)); // NOI18N
        jLabel2.setText("STEGANOGRAPHY ENCRYPTION");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setText("Encryption Text:");

        btnBrowse.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        txtMsg.setColumns(20);
        txtMsg.setLineWrap(true);
        txtMsg.setRows(5);
        txtMsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMsgKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtMsg);

        buttonGroup2.add(rdNone);
        rdNone.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        rdNone.setSelected(true);
        rdNone.setText("None");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setText("Compression Method:");

        buttonGroup2.add(rdLZW);
        rdLZW.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        rdLZW.setText("LZW");
        rdLZW.setEnabled(false);

        buttonGroup2.add(rdHuff);
        rdHuff.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        rdHuff.setText("Huffman");
        rdHuff.setEnabled(false);

        pnlOG.setBackground(new java.awt.Color(238, 238, 238));
        pnlOG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 40, 40)));
        pnlOG.setPreferredSize(new java.awt.Dimension(480, 360));

        javax.swing.GroupLayout pnlOGLayout = new javax.swing.GroupLayout(pnlOG);
        pnlOG.setLayout(pnlOGLayout);
        pnlOGLayout.setHorizontalGroup(
            pnlOGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlOGLayout.setVerticalGroup(
            pnlOGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setText("Original Image:");

        pnlEN.setBackground(new java.awt.Color(238, 238, 238));
        pnlEN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 40, 40)));
        pnlEN.setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout pnlENLayout = new javax.swing.GroupLayout(pnlEN);
        pnlEN.setLayout(pnlENLayout);
        pnlENLayout.setHorizontalGroup(
            pnlENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        pnlENLayout.setVerticalGroup(
            pnlENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel6.setText("Encrypted Image:");

        btnEncrypt.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnEncrypt.setText("Encrypt");
        btnEncrypt.setEnabled(false);
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnSave.setText("Save As");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblTxtRemaining.setText("Character Limit Reached!");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(txtAddr, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTxtRemaining)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(btnBrowse)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(jLabel4)
                                .addGap(0, 60, Short.MAX_VALUE))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdNone)
                            .addComponent(rdLZW)
                            .addComponent(rdHuff))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel2))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSave)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnEncrypt)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(346, 346, 346))
                                    .addComponent(pnlOG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(lblTxtRemaining))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(rdNone)
                        .addGap(18, 18, 18)
                        .addComponent(rdLZW)
                        .addGap(18, 18, 18)
                        .addComponent(rdHuff))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlOG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEncrypt)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    // https://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage
    private BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
//        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
        BufferedImage newImage = new BufferedImage(bi.getWidth(),bi.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
        newImage.getGraphics().drawImage(bi, 0, 0, null);
//        return new BufferedImage(bi.getWidth(),bi.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
        return newImage;
    }
    
    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser f = new JFileChooser();
        if(!cc.isAlive())
            cc.start();
        FileNameExtensionFilter filter = 
        new FileNameExtensionFilter("Image files","JPG","BMP","PNG","GIF");
        
        f.setFileFilter(filter);
        
        int returnVal = f.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            fileName = f.getSelectedFile().getName();
            if(returnExtension(fileName).equals(".gif"))
                JOptionPane.showMessageDialog(this, "Due to software limitation, only the first frame will be encrypted and saved");
    
            txtAddr.setText(f.getSelectedFile().getAbsolutePath());
            originalImage = loadImg(txtAddr.getText());
            showImage(ogImage,pnlOG,originalImage);
            clearImage(enImage,pnlEN);
            btnSave.setEnabled(false);
            btnEncrypt.setEnabled(true);
            characterAvailable = imageCharacterCount(originalImage);
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private int imageCharacterCount(BufferedImage img)
    {
        return ((img.getWidth()*img.getHeight()-3)*(COLOR_CHANNELS+1))/CHARACTER_BIT;
    }
    
    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
        int b = encryptLSB(originalImage);
        if(b==0)
            btnSave.setEnabled(true);
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void txtMsgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMsgKeyTyped
        int remaining = characterAvailable - characterCount;
        if(remaining <= 0){
            try{
            evt.consume();
            }
        catch(Exception w){}
        } 
    }//GEN-LAST:event_txtMsgKeyTyped

    private String returnExtension(String file){
        return file.substring(fileName.lastIndexOf('.'), fileName.length());
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        String extension = returnExtension(fileName);
        fileChooser.setFileFilter(new FileNameExtensionFilter("*"+extension, extension));
        
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        System.out.println("CHOSENFILE: " + fileChooser.getSelectedFile());
        System.out.println("EXTENSION: " + extension);
        try {
            System.out.println("IMAGESAVETYPE: " + encryptedImage.getType());
            ImageIO.write(encryptedImage, "png", new File(file.getAbsolutePath()+extension));
            JOptionPane.showMessageDialog(this, "Image Saved Successfully!");
        } catch (Exception ex) {
            System.out.println("Failed to save image!\n" + ex);
        }
        } else {
            System.out.println("No file choosen!");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private int encryptLSB(BufferedImage img)
    {
        
        int characterBit = CHARACTER_BIT;
        int colorBit = COLOR_BIT;
        int colorChannel = COLOR_CHANNELS;
        BufferedImage imgToEncrypt = deepCopy(img);
        int x = imgToEncrypt.getWidth();
        int y = imgToEncrypt.getHeight();
        
        String input = txtMsg.getText().trim();
        
        if(characterCount == 0){
            JOptionPane.showMessageDialog(this, "Encryption Text is Empty!");
            return -1;
        }
        if(characterAvailable - characterCount < 0){
            JOptionPane.showMessageDialog(this, "Exceeded Maximum Character Amount!\nEncryption Unvailable!");
            return -1;
        }
        
        char input_array[] = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        
        /* METADATA FORMAT */
        
        // Pixel(0,0) holds character bit
        // Value 0 means 8 bit
        // Value 1 means 16 bit
        // TO ADD MORE LATER
        
        // Pixel(1,0) holds compression method
        // Value 0 means no compression
        // Value 1 means LZW compression
        // TO ADD MORE LATER
        
        
        /* SETTING METADATA */
        
        switch(characterBit){
            case 16:
                sb.append("001");
            default:
                sb.append("000");
        }
        int compressionType = 0;
        if(rdLZW.isSelected())
            compressionType = 1;
        if(rdHuff.isSelected())
            compressionType = 2;
            
        switch(compressionType){
            case 1:
                sb.append("001");
            case 2:
                sb.append("002");
            default:
                sb.append("000");
        }
        
        //////////////////////
        
        for(char c : input_array){
            String binary = Integer.toBinaryString(c);
            
            if(binary.length()>characterBit){
                JOptionPane.showMessageDialog(this, 
                        "Message contains invalid characters.\nPlease use only ASCII characters!");
                return -1;
            }
            
            while(binary.length()<characterBit)
                binary = '0' + binary;
            
            sb.append(binary);
        }
        
        // append NULL at end of string
        for(int i = 0 ; i < characterBit; i++)
            sb.append("0");
                
        int curChar = 0;
        int curRow = 0;
        int curCol = 0; // at 2 because of metadata
        int curColor = 0;
        
        int pixel = imgToEncrypt.getRGB(curCol, curRow);
        int count = 0;
        
        while(curChar < sb.length() && (curRow < y && curCol < x)){
            count++;
            char c = sb.charAt(curChar);
            
            switch (c) {
                case '1':
                    pixel |=  (1 << curColor);
                    break;
                case '0':
                    pixel &= ~(1 << curColor);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "How did you break this?");
                    break;
            }
            
            curColor += colorBit;
            curChar++;
            
            // the sb.length() condition is when the message runs out of character
            // but it hasn't used all of the color bits yet but you still need to set the RGB
            if(curColor > colorBit*colorChannel || curChar >= sb.length()){

                imgToEncrypt.setRGB(curCol, curRow, pixel);
                
                curColor = 0;
                curCol++;

            if(curCol >= x){
                curCol = 0;
                curRow++;
            }
            
            if(curRow<y)
                pixel = imgToEncrypt.getRGB(curCol, curRow);
            }
        }
        encryptedImage = deepCopy(imgToEncrypt);
        showImage(enImage, pnlEN, encryptedImage);

        return 0;
    }
    
    class CharacterCounter extends Thread{
    @Override
    public void run()
    {
        while(true){
        characterCount = txtMsg.getText().trim().length();
        
        int remaining = characterAvailable - characterCount;
        
        if(remaining == 0){
            lblTxtRemaining.setText("Characters Limit Reached!");
        } else if(remaining < 0){
            lblTxtRemaining.setText("Exceeded Chacaters Limit!");
        } else{
            lblTxtRemaining.setText(remaining + " characters remaining");
        }
        
        try {
            sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        }
    }
}
    
    private BufferedImage loadImg(String addr)
    {
        if (addr == null || addr.isEmpty()){
            JOptionPane.showMessageDialog(this, "Image Address unavailable, please try again");
            return null;
        }

        try
        {
            File f = new File(addr);
            BufferedImage in = ImageIO.read(f);
            System.out.println("IMAGETYPE_BEF: " + in.getType());
            if(in.getType()!=5){
                BufferedImage newImage = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
                newImage.getGraphics().drawImage(in, 0, 0, null);
                System.out.println("IMAGETYPE_AFT: " + in.getType());
                in = newImage;
            }
            return in;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
        return null;
    }
    
    private void clearImage(Graphics grToClear, JPanel pnlToClear){
        int x = 1, y =1;
        grToClear.clearRect(x,y,pnlToClear.getWidth()-2*x,pnlToClear.getHeight()-2*y);
    }
    
    private boolean showImage(Graphics showTo, JPanel showPanel, BufferedImage img)
    {
        int x = 1, y = 1;
        BufferedImage curImg = img;
        if (curImg != null)
        {
            showTo.clearRect(x,y,showPanel.getWidth()-2*x,showPanel.getHeight()-2*y);
       
            int imgWidth = curImg.getWidth();
            int imgHeight = curImg.getHeight();
            
            double ratio = 1.0*imgWidth/imgHeight;
            
            int areaWidth = showPanel.getWidth()-2*x;
            int areaHeight = showPanel.getHeight()-2*y;
            
            if (imgWidth <= areaWidth && imgHeight <= areaHeight)
            {
                if(imgWidth > imgHeight){
                    areaHeight = (int)(areaWidth/ratio);
                } else {
                    areaWidth = (int)(areaHeight*ratio);
                }
            } else if (imgWidth > imgHeight)
            {
                if (imgWidth < areaWidth) {
                    areaWidth = imgWidth;
                }
                areaHeight = (int)(areaWidth/ratio);
            } else {
                if (imgHeight < areaHeight){
                    areaHeight = imgHeight;
                }
                areaWidth = (int) (areaHeight*ratio);
            }
            showTo.drawImage(curImg,x,y,areaWidth,areaHeight,showPanel);
            System.out.println("End showImg Successfully");
            return true;
        }
        System.out.println("End showImg Unsuccessfully");
        return false;
    }

    public static void main(String args[]) {
        try {
                UIManager.setLookAndFeel (new MaterialLookAndFeel ());
            }
            catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace ();
            }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SteganographyEncryptView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTxtRemaining;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pnlEN;
    private javax.swing.JPanel pnlOG;
    private javax.swing.JRadioButton rdHuff;
    private javax.swing.JRadioButton rdLZW;
    private javax.swing.JRadioButton rdNone;
    private javax.swing.JTextField txtAddr;
    private javax.swing.JTextArea txtMsg;
    // End of variables declaration//GEN-END:variables
}
