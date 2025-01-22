import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
  Fila filaProcs = new Fila();
  JButton btnNovoProc = new JButton("Novo Processo");
  JButton btnExecutarProc = new JButton("Executar Processo");
  JButton btnVerProcs = new JButton("Ver Processos");
  JButton btnLocalizarProc = new JButton("Localizar Processo");
  JButton btnExcluirProcs = new JButton("Excluir Processos");
  JLabel labelLog = new JLabel("  Controle: " + filaProcs.tamanho + " Processos em espera.");

  public GUI() {
    super("Fila de Processos");
    setLayout(new GridLayout(6, 1));
    setSize(300, 250);
    add(btnNovoProc);
    add(btnExecutarProc);
    add(btnVerProcs);
    add(btnLocalizarProc);
    add(btnExcluirProcs);
    add(labelLog);
    btnNovoProc.addActionListener(this);
    btnExecutarProc.addActionListener(this);
    btnVerProcs.addActionListener(this);
    btnLocalizarProc.addActionListener(this);
    btnExcluirProcs.addActionListener(this);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(btnNovoProc)) {
      try {
        if (!filaProcs.isFull()) {
          String titulo = JOptionPane.showInputDialog("Informe o título do processo: ");
          filaProcs.enfileirar(new Processo(titulo));
          JOptionPane.showMessageDialog(null, "Processo incluído com sucesso.", "Controle", JOptionPane.PLAIN_MESSAGE);
          labelLog.setText("Controle: " + filaProcs.tamanho + " Processos em espera.");
        } else {
          JOptionPane.showMessageDialog(null, "Não há mais espaço na fila de processos.", "Controle",
              JOptionPane.PLAIN_MESSAGE);
        }
      } catch (Exception ex) {
        System.out.println("Erro: " + ex.getMessage());
      }
    } else if (e.getSource().equals(btnExecutarProc)) {
      try {
        if (!filaProcs.isEmpty()) {
          Processo p = filaProcs.desenfileirar();
          JOptionPane.showMessageDialog(null, "Processo \"" + p.getTitulo() + "\" executado com sucesso.", "Controle",
              JOptionPane.PLAIN_MESSAGE);
          labelLog.setText("  Controle: " + filaProcs.tamanho + " Processos em espera.");
        } else {
          JOptionPane.showMessageDialog(null, "Não há processos na fila para serem executados.", "Controle",
              JOptionPane.PLAIN_MESSAGE);
        }
      } catch (Exception ex) {
        System.out.println("Erro: " + ex.getMessage());
      }
    } else if (e.getSource().equals(btnVerProcs)) {
      try {
        if (!filaProcs.isEmpty()) {
          StringBuilder procs = new StringBuilder();
          for (int i = 0; i < filaProcs.tamanho; i++) {
            Processo p = filaProcs.desenfileirar();
            procs.append(i + 1 + " - " + p.getTitulo() + "\n");
            filaProcs.enfileirar(p);
          }
          String todosProcs = procs.toString();
          JOptionPane.showMessageDialog(null, "Fila de Processos: \n" + todosProcs, "Controle",
              JOptionPane.PLAIN_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(null, "A fila de processos está vazia.", "Controle", JOptionPane.PLAIN_MESSAGE);
        }
      } catch (Exception ex) {
        System.out.println("Erro: " + ex.getMessage());
      }
    } else if (e.getSource().equals(btnLocalizarProc)) {
      try {
        if (!filaProcs.isEmpty()) {
          String titulo = JOptionPane.showInputDialog("Informe o título do processo: ");
          int posicao = 0;
          for (int i = 0; i < filaProcs.tamanho; i++) {
            Processo p = filaProcs.desenfileirar();
            if (p.getTitulo().equals(titulo)) {
              posicao = i + 1;
            }
            filaProcs.enfileirar(p);
          }
          if (posicao != 0) {
            JOptionPane.showMessageDialog(null, "O processo \"" + titulo + " \" ocupa a " + posicao + "º posição.",
                "Controle", JOptionPane.PLAIN_MESSAGE);
          } else {
            JOptionPane.showMessageDialog(null, "O processo \"" + titulo + " \" não foi encontrado.",
                "Controle", JOptionPane.PLAIN_MESSAGE);
          }
        } else {
          JOptionPane.showMessageDialog(null, "A fila de processos está vazia.", "Controle", JOptionPane.PLAIN_MESSAGE);
        }
      } catch (Exception ex) {
        System.out.println("Erro: " + ex.getMessage());
      }
    } else if (e.getSource().equals(btnExcluirProcs)) {
      try {
        if (!filaProcs.isEmpty()) {
          int procsExcluidos = 0;
          while (!filaProcs.isEmpty()) {
            filaProcs.desenfileirar();
            procsExcluidos++;
          }
          JOptionPane.showMessageDialog(null, procsExcluidos + " processo(s) excluído(s) com sucesso.", "Controle",
              JOptionPane.PLAIN_MESSAGE);
          labelLog.setText("  Controle: " + filaProcs.tamanho + " Processos em espera.");
        } else {
          JOptionPane.showMessageDialog(null, "Não há processos na fila para serem excluídos.", "Controle",
              JOptionPane.PLAIN_MESSAGE);
        }
      } catch (Exception ex) {
        System.out.println("Erro: " + ex.getMessage());
      }
    }
  }
}
