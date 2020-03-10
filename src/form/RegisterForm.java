package form;

import model.User;
import org.apache.commons.lang3.StringUtils;
import service.RegisterService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm {
    private JPanel panel1;
    private JTextField email;
    private JPasswordField pwd;
    private JPasswordField checkPwd;


    public RegisterForm() {
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isFormValid()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                } else if (!RegisterService.getRegisterService().isPwdValid(pwd.getText(), checkPwd.getText())) {
                    JOptionPane.showMessageDialog(null, "Incorrect password!");
                } else {
                    User user = new User(email.getText(), pwd.getText());
                    RegisterService.getRegisterService().registerUser(user);
                    JOptionPane.showMessageDialog(null, "User is registered successfully!");
                }
            }
        });
        printRegisteredUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, RegisterService.getRegisterService().printUsers());
            }
        });
    }

    private boolean isFormValid() {
        return StringUtils.isNotBlank(email.getText()) && StringUtils.isNotBlank(pwd.getText()) && StringUtils.isNotBlank(checkPwd.getText());
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("RegisterForm");
        jFrame.setContentPane(new RegisterForm().panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
