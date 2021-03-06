package gui;

import static java.awt.event.KeyEvent.VK_ENTER;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.text.DefaultCaret;

/* NAME: ClientGUI
 * PROJECT: Chattie - https://github.com/demiurgosoft/chattie
 * AUTHOR: demiurgosoft
 * DESCRIPTION: Main chat GUI for Chattie
 */
public abstract class ClientGUI extends javax.swing.JFrame {

    public ClientGUI(String username,ImageIcon icon) {
        initComponents();
        setGUIUsername(username);
        if(icon!=null) this.setIconImage(icon.getImage());
        setVisible(true);
        setLocationRelativeTo(null);
        DefaultCaret caret = (DefaultCaret)chatArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }
    //Override for exit action
    protected abstract void exitGUI();
    protected abstract void reconnectGUI();
    protected abstract void changeUsernameGUI();
    protected abstract void showHelpGUI();
    protected abstract void sendGUI(String string);
    //Override if want to return instead of simply exit
    protected void returnGUI(){
        exitGUI();
    }

    protected void setUsers(ArrayList<String> users,String username){
    	usersList.setText(null);
        for(String user:users){
            if(user.equals(username)) usersList.append(">");
            usersList.append(user+"\n");
        }
    }
    protected void addText(String string) {
        if(string!=null && !string.isEmpty())
            chatArea.append(string+"\n");
    }
    protected void setGUIUsername(String username) {
        title.setText(username);
        setTitle("Chattie - "+username);
    }
    private void sendAction() {
        String message=userInput.getText();
        userInput.setText(null);
        sendGUI(message);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        userInput = new javax.swing.JTextArea();
        exitButton = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        reconnectMenu = new javax.swing.JMenuItem();
        changeUsernameMenu = new javax.swing.JMenuItem();
        disconnectMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        sendMenu = new javax.swing.JMenuItem();
        clearMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        userInput.setColumns(20);
        userInput.setLineWrap(true);
        userInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userInputKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(userInput);

        exitButton.setText("Disconnect");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        title.setText(" ");

        chatArea.setEditable(false);
        chatArea.setColumns(35);
        chatArea.setLineWrap(true);
        jScrollPane1.setViewportView(chatArea);

        usersList.setEditable(false);
        usersList.setColumns(9);
        usersList.setRows(5);
        jScrollPane2.setViewportView(usersList);

        fileMenu.setText("File");

        reconnectMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        reconnectMenu.setText("Reconnect");
        reconnectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reconnectMenuActionPerformed(evt);
            }
        });
        fileMenu.add(reconnectMenu);

        changeUsernameMenu.setText("Change username");
        changeUsernameMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeUsernameMenuActionPerformed(evt);
            }
        });
        fileMenu.add(changeUsernameMenu);

        disconnectMenu.setText("Disconnect");
        disconnectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectMenuActionPerformed(evt);
            }
        });
        fileMenu.add(disconnectMenu);

        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenu);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Edit");

        sendMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.CTRL_MASK));
        sendMenu.setText("Send");
        sendMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMenuActionPerformed(evt);
            }
        });
        editMenu.add(sendMenu);

        clearMenu.setText("Clear");
        clearMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearMenuActionPerformed(evt);
            }
        });
        editMenu.add(clearMenu);

        jMenuBar1.add(editMenu);

        helpMenu.setText("Help");

        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem1);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sendButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        returnGUI();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        sendAction();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       exitGUI();
    }//GEN-LAST:event_formWindowClosing

    private void userInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInputKeyPressed
        if(evt.getKeyCode() == VK_ENTER) {
            evt.consume();
            sendAction();
        }
    }//GEN-LAST:event_userInputKeyPressed

    private void reconnectMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reconnectMenuActionPerformed
        reconnectGUI();
    }//GEN-LAST:event_reconnectMenuActionPerformed

    private void changeUsernameMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUsernameMenuActionPerformed
        changeUsernameGUI();
    }//GEN-LAST:event_changeUsernameMenuActionPerformed

    private void disconnectMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectMenuActionPerformed
       returnGUI();
    }//GEN-LAST:event_disconnectMenuActionPerformed

    private void sendMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMenuActionPerformed
      sendAction();
    }//GEN-LAST:event_sendMenuActionPerformed

    private void clearMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearMenuActionPerformed
       userInput.setText(null);
    }//GEN-LAST:event_clearMenuActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        exitGUI();
    }//GEN-LAST:event_exitMenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       showHelpGUI();
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem changeUsernameMenu;
    private javax.swing.JTextArea chatArea;
    private javax.swing.JMenuItem clearMenu;
    private javax.swing.JMenuItem disconnectMenu;
    private javax.swing.JMenu editMenu;
    private javax.swing.JButton exitButton;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem reconnectMenu;
    private javax.swing.JButton sendButton;
    private javax.swing.JMenuItem sendMenu;
    private javax.swing.JLabel title;
    private javax.swing.JTextArea userInput;
    private javax.swing.JTextArea usersList;
    // End of variables declaration//GEN-END:variables
}
