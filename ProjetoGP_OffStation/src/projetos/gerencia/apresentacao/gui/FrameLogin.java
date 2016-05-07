package projetos.gerencia.apresentacao.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import projetos.gerencia.Principal;

public class FrameLogin extends JFrame implements ActionListener {
    
    private final JButton entrar = new JButton("Entrar");
    private final JTextField cpf = new JTextField();
    private final JPasswordField senha = new JPasswordField();
    
    public FrameLogin() {
        super("Tela de Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 150);
        this.iniciarComponentes();
        this.setVisible(true);
    }
    
    private void iniciarComponentes() {
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        
        Container formulario = new JPanel();
        formulario.setLayout(new GridLayout(3, 2));
        
        formulario.add(new JLabel("CPF: "));
        formulario.add(this.cpf);
        formulario.add(new JLabel("Senha: "));
        formulario.add(this.senha);
        formulario.add(new JLabel(""));
        
        this.entrar.addActionListener(this);
        formulario.add(this.entrar);
        
        JLabel intro = new JLabel("Bem vindo");
        intro.setBounds(0, 0, 200, 200);
        
        c.add(BorderLayout.WEST, intro);
        c.add(BorderLayout.CENTER, formulario);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() == this.entrar)) {
            String senha = String.valueOf(this.senha.getPassword());
            Principal.getInstancia().fazerLogin(this.cpf.getText(), senha);
        } else {
            System.err.println("Algo errado...");
        }
    }
    
}
