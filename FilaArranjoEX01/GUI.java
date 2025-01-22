import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
  int senhas = 50;
  int clientesParaAtender = 0;
  Fila fila = new Fila();
  JLabel labelQtdSenhas = new JLabel(" Senhas Restantes: " + senhas);
  JButton btnSenha = new JButton("Retirar Senha");
  JButton btnAtender = new JButton("Atender Cliente");
  JButton btnSair = new JButton("Sair");
  JLabel labelControle = new JLabel(" Controle: ");

  public GUI() {
    super("Atendimento de Clientes");
    setLayout(new GridLayout(5, 1));
    setSize(300, 200);
    add(labelQtdSenhas);
    add(btnSenha);
    add(btnAtender);
    add(btnSair);
    add(labelControle);
    btnSenha.addActionListener(this);
    btnAtender.addActionListener(this);
    btnSair.addActionListener(this);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(btnSenha)) {
      try {
        if (senhas > 0) {
          fila.enfileirar(JOptionPane.showInputDialog("Informe seu nome:"));
          senhas--;
          clientesParaAtender++;
          labelQtdSenhas.setText(" Senhas Restantes: " + senhas);
        } else {
          JOptionPane.showMessageDialog(null, "Não há mais senhas disponíveis.");
        }
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    } else if (e.getSource().equals(btnAtender)) {
      try {
        if (clientesParaAtender > 0) {
          String cliente = fila.desenfileirar();
          clientesParaAtender--;
          labelControle.setText(" Controle: Atendendo " + cliente);
        } else {
          JOptionPane.showMessageDialog(null, "Não há clientes na fila para serem atendidos.");
        }
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    } else {
      System.exit(0);
    }
  }
}
