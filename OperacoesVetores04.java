import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OperacoesVetores04 extends JFrame implements ActionListener {
  int[] vetor = new int[10];
  int proximaPosicao = 0;
  JTextField txtNum = new JTextField();
  JButton btnIncluirInicio = new JButton("Incluir no Início");
  JButton btnIncluirFinal = new JButton("Incluir no Final");
  JButton btnIncluirMeio = new JButton("Incluir no Meio");
  JButton btnExcluirPrimeiro = new JButton("Excluir Primeiro");
  JButton btnExcluirUltimo = new JButton("Excluir Último");
  JButton btnExcluirMeio = new JButton("Excluir no Meio");
  JTextField[] elementos = new JTextField[10];
  JPanel painelOperacoes = new JPanel();
  JPanel painelElementos = new JPanel();

  public OperacoesVetores04() {
    super("Operações com Vetores - Ex04");
    setSize(550, 120);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    painelOperacoes.setLayout(new GridLayout(2, 4));
    painelOperacoes.add(txtNum);
    painelOperacoes.add(btnIncluirInicio);
    painelOperacoes.add(btnIncluirFinal);
    painelOperacoes.add(btnIncluirMeio);
    painelOperacoes.add(new JLabel());
    painelOperacoes.add(btnExcluirPrimeiro);
    painelOperacoes.add(btnExcluirUltimo);
    painelOperacoes.add(btnExcluirMeio);
    btnIncluirInicio.addActionListener(this);
    btnIncluirFinal.addActionListener(this);
    btnIncluirMeio.addActionListener(this);
    btnExcluirPrimeiro.addActionListener(this);
    btnExcluirUltimo.addActionListener(this);
    btnExcluirMeio.addActionListener(this);

    painelElementos.setLayout(new BoxLayout(painelElementos, BoxLayout.X_AXIS));
    for (int i = 0; i < elementos.length; i++) {
      elementos[i] = new JTextField("      ");
      elementos[i].setHorizontalAlignment(JTextField.CENTER);
      painelElementos.add(elementos[i]);
    }

    add(painelOperacoes, BorderLayout.CENTER);
    add(painelElementos, BorderLayout.SOUTH);
    atualizarVetor();
    setVisible(true);
  }

  public void atualizarVetor() {
    for (int i = 0; i < elementos.length; i++) {
      elementos[i].setText("      ");
    }
    if (proximaPosicao != 0) {
      for (int i = 0; i < proximaPosicao; i++) {
        elementos[i].setText("  " + String.valueOf(vetor[i]) + "  ");
      }
    }
  }

  private boolean verificarEntrada() {
    if (txtNum.getText().isEmpty()) {
      JOptionPane.showMessageDialog(this, "Entrada inválida.", "Atenção", JOptionPane.WARNING_MESSAGE);
      return false;
    }
    try {
      Integer.parseInt(txtNum.getText());
      return true;
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(this, "Entrada inválida.", "Atenção", JOptionPane.WARNING_MESSAGE);
      return false;
    }
  }

  public static void main(String[] args) {
    new OperacoesVetores04();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(btnIncluirInicio)) {
      if (proximaPosicao >= vetor.length) {
        JOptionPane.showMessageDialog(this, "Não há mais espaços disponíveis.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
      }
      if (verificarEntrada()) {
        for (int i = proximaPosicao; i > 0; i--) {
          vetor[i] = vetor[i - 1];
        }
        vetor[0] = Integer.parseInt(txtNum.getText());
        proximaPosicao++;
        txtNum.setText("");
        atualizarVetor();
      }
    } else if (e.getSource().equals(btnIncluirFinal)) {
      if (proximaPosicao >= vetor.length) {
        JOptionPane.showMessageDialog(this, "Não há mais espaços disponíveis.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
      }
      if (verificarEntrada()) {
        vetor[proximaPosicao] = Integer.parseInt(txtNum.getText());
        proximaPosicao++;
        txtNum.setText("");
        atualizarVetor();
      }
    } else if (e.getSource().equals(btnIncluirMeio)) {
      if (proximaPosicao >= vetor.length) {
        JOptionPane.showMessageDialog(this, "Não há mais espaços disponíveis.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
      }
      if (proximaPosicao < 2) {
        JOptionPane.showMessageDialog(this, "Deve haver pelo menos 2 elementos para incluir no meio.", "Atenção",
            JOptionPane.WARNING_MESSAGE);
        return;
      }
      if (verificarEntrada()) {
        String posicoesDisponiveis = "Posições Disponíveis: ";
        for (int i = 1; i < proximaPosicao; i++) {
          posicoesDisponiveis += String.valueOf(i) + " ";
        }
        int posicao;
        try {
          posicao = Integer.parseInt(
              JOptionPane.showInputDialog("Em qual posição deseja alocar o elemento?\n" + posicoesDisponiveis));
          if (posicao < 1 || posicao >= proximaPosicao) {
            JOptionPane.showMessageDialog(this, "Posição inválida.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
          }
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(this, "Posição inválida.", "Atenção", JOptionPane.WARNING_MESSAGE);
          return;
        }
        for (int i = proximaPosicao; i != posicao; i--) {
          vetor[i] = vetor[i - 1];
        }
        vetor[posicao] = Integer.parseInt(txtNum.getText());
        proximaPosicao++;
        txtNum.setText("");
        atualizarVetor();
      }
    } else if (e.getSource().equals(btnExcluirPrimeiro)) {
      if (proximaPosicao == 0) {
        JOptionPane.showMessageDialog(this, "Não há elementos para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
      }
      for (int i = 0; i < proximaPosicao - 1; i++) {
        vetor[i] = vetor[i + 1];
      }
      proximaPosicao--;
      atualizarVetor();
    } else if (e.getSource().equals(btnExcluirUltimo)) {
      if (proximaPosicao == 0) {
        JOptionPane.showMessageDialog(this, "Não há elementos para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
      }
      proximaPosicao--;
      atualizarVetor();
    } else if (e.getSource().equals(btnExcluirMeio)) {
      if (proximaPosicao == 0) {
        JOptionPane.showMessageDialog(this, "Não há elementos para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
      }
      if (proximaPosicao < 2) {
        JOptionPane.showMessageDialog(this, "Deve haver pelo menos 2 elementos para excluir no meio.", "Atenção",
            JOptionPane.WARNING_MESSAGE);
        return;
      }
      String posicoesDisponiveis = "Posições Disponíveis: ";
      for (int i = 1; i < proximaPosicao - 1; i++) {
        posicoesDisponiveis += String.valueOf(i) + " ";
      }
      int posicao;
      try {
        posicao = Integer.parseInt(JOptionPane.showInputDialog("Qual posição deseja excluir?\n" + posicoesDisponiveis));
        if (posicao < 1 || posicao >= proximaPosicao - 1) {
          JOptionPane.showMessageDialog(this, "Posição inválida.", "Atenção", JOptionPane.WARNING_MESSAGE);
          return;
        }
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Posição inválida.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
      }
      for (int i = posicao; i < proximaPosicao - 1; i++) {
        vetor[i] = vetor[i + 1];
      }
      proximaPosicao--;
      atualizarVetor();
    }
  }
}
