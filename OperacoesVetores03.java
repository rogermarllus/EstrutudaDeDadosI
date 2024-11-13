import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperacoesVetores03 extends JFrame implements ActionListener {
  public static String[] convidados = new String[10];
  public static int proximaPosicao = 0;

  public JTextField txtConvidado = new JTextField();
  public JTextField txtVagas = new JTextField();

  public JLabel labelVagas = new JLabel("Vagas Restantes");

  public JButton btnIncluir = new JButton("Incluir");
  public JButton btnExcluir = new JButton("Excluir");

  public JTextArea txtAreaConvidados = new JTextArea(10, 40);

  public JPanel painel = new JPanel();

  public GridBagLayout layout = new GridBagLayout();
  public GridBagConstraints constraints = new GridBagConstraints();

  public OperacoesVetores03() {
    super("Controle de Convidados");
    setSize(400, 320);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    painel.setLayout(layout);
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.fill = GridBagConstraints.BOTH;
    constraints.weightx = 1;
    constraints.weighty = 1;
    constraints.insets = new Insets(3, 3, 3, 3);
    addC(txtConvidado, 0, 0, 2, 1);
    addC(btnIncluir, 0, 1, 1, 1);
    addC(btnExcluir, 1, 1, 1, 1);
    addC(txtVagas, 0, 2, 1, 1);
    addC(labelVagas, 1, 2, 1, 1);
    add(painel, BorderLayout.CENTER);
    add(txtAreaConvidados, BorderLayout.SOUTH);
    txtVagas.setEnabled(false);
    txtAreaConvidados.setEnabled(false);
    txtVagas.setDisabledTextColor(Color.BLACK);
    txtAreaConvidados.setDisabledTextColor(Color.BLACK);
    btnIncluir.addActionListener(this);
    btnExcluir.addActionListener(this);
    atualizarLista();
    setVisible(true);
  }

  public void addC(Component c, int col, int row, int width, int height) {
    constraints.gridx = col;
    constraints.gridy = row;
    constraints.gridwidth = width;
    constraints.gridheight = height;
    layout.setConstraints(c, constraints);
    painel.add(c);
  }

  public void atualizarLista() {
    if (proximaPosicao == 0) {
      txtAreaConvidados.setText("");
      txtAreaConvidados.append("Não há convidados na lista.");
    } else {
      txtAreaConvidados.setText("");
      for (int i = 0; i < proximaPosicao; i++) {
        txtAreaConvidados.append("- " + convidados[i] + "\n");
      }
    }
    txtVagas.setText(String.valueOf(convidados.length - proximaPosicao));
  }

  public static void main(String[] args) {
    new OperacoesVetores03();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnIncluir) {
      if (txtConvidado.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Preencha o campo de convidado.", "Atenção", JOptionPane.WARNING_MESSAGE);
      } else if ((convidados.length - proximaPosicao) == 0) {
        JOptionPane.showMessageDialog(null, "Não há vagas restantes.", "Atenção", JOptionPane.WARNING_MESSAGE);
      } else {
        boolean estaNalista = false;
        for (int i = 0; i < proximaPosicao; i++) {
          if (convidados[i].equals(txtConvidado.getText())) {
            JOptionPane.showMessageDialog(null, "\"" + txtConvidado.getText() + "\" já está na lista.", "Atenção",
                JOptionPane.WARNING_MESSAGE);
            estaNalista = true;
            break;
          }
        }
        if (!(estaNalista)) {
          convidados[proximaPosicao] = txtConvidado.getText();
          proximaPosicao++;
          txtConvidado.setText("");
          atualizarLista();
        }
      }
    } else {
      if (txtConvidado.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Preencha o campo de convidado.", "Atenção", JOptionPane.WARNING_MESSAGE);
      } else if ((convidados.length - proximaPosicao) == 10) {
        JOptionPane.showMessageDialog(null, "Não há convidados para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
      } else {
        int excluirPosicao = -1;
        for (int i = 0; i < proximaPosicao; i++) {
          if (convidados[i].equals(txtConvidado.getText())) {
            excluirPosicao = i;
            break;
          }
        }
        if (excluirPosicao != -1) {
          for (int i = excluirPosicao + 1; i < proximaPosicao; i++) {
            convidados[i - 1] = convidados[i];
          }
          proximaPosicao--;
          txtConvidado.setText("");
          atualizarLista();
        } else {
          JOptionPane.showMessageDialog(null, "Não há um(a) \"" + txtConvidado.getText() + "\" na lista.", "Atenção",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    }
  }
}
