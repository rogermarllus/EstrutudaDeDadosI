import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
  Fila q = new Fila();
  Fila a = new Fila();
  Fila b = new Fila();
  JTextField txtNome = new JTextField();
  String[] OPERACOES = { "A", "B", "X" };
  JComboBox<String> comboOperacao = new JComboBox<>(OPERACOES);
  JButton btnCad = new JButton("Cadastrar");
  JButton btnVis = new JButton("Visualizar");

  public GUI() {
    super("Cadastro de Strings");
    setLayout(new GridLayout(2, 2));
    add(txtNome);
    add(comboOperacao);
    add(btnCad);
    add(btnVis);
    btnCad.addActionListener(this);
    btnVis.addActionListener(this);
    setSize(300, 100);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(btnCad)) {
      if (!txtNome.getText().equals("")) {
        Elemento op = new Elemento((String) comboOperacao.getSelectedItem());
        Elemento el = new Elemento(txtNome.getText());
        q.enfileirar(op);
        q.enfileirar(el);
        txtNome.setText("");
        comboOperacao.setSelectedIndex(0);
        preencherFilas();
        txtNome.requestFocus();
      } else {
        JOptionPane.showMessageDialog(null, "Preencha o campo de nome.");
      }
    } else if (e.getSource().equals(btnVis)) {
      try {
        if (!a.isVazia() && !b.isVazia()) {
          String filaA = a.mostrarFila();
          String filaB = b.mostrarFila();
          JOptionPane.showMessageDialog(null, "Filas:\nA: " + filaA + "\nB: " + filaB);
        } else {
          JOptionPane.showMessageDialog(null, "Não há elementos para visualizar.");
        }
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    }
  }

  public void preencherFilas() {
    try {
      while (!q.isVazia()) {
        String op = q.desenfileirar().elemento;
        switch (op) {
          case "A":
            a.enfileirar(q.desenfileirar());
            JOptionPane.showMessageDialog(null, "Adicionado à fila A");
            break;
          case "B":
            b.enfileirar(q.desenfileirar());
            JOptionPane.showMessageDialog(null, "Adicionado à fila B");
            break;
          case "X":
            if (a.getTamanho() < b.getTamanho()) {
              a.enfileirar(q.desenfileirar());
              JOptionPane.showMessageDialog(null, "Adicionado à fila A");
            } else if (a.getTamanho() > b.getTamanho()) {
              b.enfileirar(q.desenfileirar());
              JOptionPane.showMessageDialog(null, "Adicionado à fila B");
            } else {
              q.desenfileirar();
              JOptionPane.showMessageDialog(null, "Descartado");
            }
            break;
          default:
            System.out.println("Ocorreu um erro: " + op);
            break;
        }
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}
