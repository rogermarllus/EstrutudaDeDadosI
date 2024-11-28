import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExListaGUI extends JFrame implements ActionListener {
    public JTextField txtInscricao = new JTextField();
    public JTextField txtNome = new JTextField();
    public JTextField txtNota = new JTextField();

    public JButton btnInserir = new JButton("Inserir");
    public JButton btnExcluir = new JButton("Excluir");
    public JButton btnBuscar = new JButton("Buscar");
    public JButton btnAtivarBusca = new JButton("Ativar Busca");
    public JButton btnExibirTodos = new JButton("Exibir Todos");

    public JTextArea taLista = new JTextArea();

    public JPanel painelSuperior = new JPanel();

    public ExListaListaCandidatos lista = new ExListaListaCandidatos();

    public ExListaGUI() {
        super("Lista de Candidatos");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        painelSuperior.setLayout(new GridLayout(4, 2));
        painelSuperior.add(txtInscricao);
        painelSuperior.add(btnInserir);
        painelSuperior.add(txtNome);
        painelSuperior.add(btnExcluir);
        painelSuperior.add(txtNota);
        painelSuperior.add(new JLabel());
        painelSuperior.add(btnAtivarBusca);
        painelSuperior.add(btnBuscar);
        add(painelSuperior, BorderLayout.NORTH);
        add(taLista, BorderLayout.CENTER);
        add(btnExibirTodos, BorderLayout.SOUTH);
        btnInserir.addActionListener(this);
        btnExcluir.addActionListener(this);
        btnAtivarBusca.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnExibirTodos.addActionListener(this);
        setVisible(true);
    }

    public void atualizarLista() {
        taLista.setText("");
        for (int i = 0; i < this.lista.getuPosicao(); i++) {
            taLista.append(this.lista.getLista()[i].getInscricao() + " - " + this.lista.getLista()[i].getNome() + " - " + this.lista.getLista()[i].getNota() +"\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInserir) {
            try {
                ExListaCandidato c = new ExListaCandidato(txtNome.getText(), Float.parseFloat(txtNota.getText()));
                this.lista.inserir(c);
                atualizarLista();
                txtNome.setText("");
                txtNota.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
            }
        } else if (e.getSource() == btnExcluir) {
            try {
                int inscricao = Integer.parseInt(txtInscricao.getText());
                this.lista.excluir(inscricao);
                atualizarLista();
                txtInscricao.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
            }
        } else if (e.getSource() == btnAtivarBusca) {
            txtInscricao.setText("");
            txtNome.setText("");
            txtNota.setText("");
            taLista.setText("");
            txtNome.requestFocus();
            btnBuscar.setEnabled(true);
            btnAtivarBusca.setEnabled(false);
            btnInserir.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnExibirTodos.setEnabled(false);
        } else if (e.getSource() == btnBuscar) {
            taLista.setText("");
            btnBuscar.setEnabled(false);
            btnAtivarBusca.setEnabled(true);
            btnInserir.setEnabled(true);
            btnExcluir.setEnabled(true);
            btnExibirTodos.setEnabled(true);
            try {
                ExListaCandidato[] notas = lista.consultarNota(txtNome.getText());
                for (int i = 0; i < notas.length; i++) {
                    if (notas[i] != null) {
                        taLista.append(notas[i].getInscricao() + " - " + notas[i].getNome() + " - " + notas[i].getNota() +"\n");
                    }
                }
                txtNome.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
            }
        } else if (e.getSource() == btnExibirTodos) {
            atualizarLista();
        }
    }
}