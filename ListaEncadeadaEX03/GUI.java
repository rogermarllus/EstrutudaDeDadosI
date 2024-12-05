import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    ListaEnc lista = new ListaEnc();
    No elementoAtual = lista.cabeca;

    JLabel labelCidade = new JLabel("Cidade");
    JLabel labelPais = new JLabel("País");
    JLabel labelAtrativo = new JLabel("Atrativos");
    JLabel labelNota = new JLabel("Nota");
    JLabel labelCidadeAtual = new JLabel("Cidade Atual");

    JTextField txtCidade = new JTextField();
    JTextField txtPais = new JTextField();
    JTextField txtAtrativo = new JTextField();
    JTextField txtNota = new JTextField();
    JTextField txtCidadeAtual = new JTextField();

    JButton btnAdd = new JButton("+");
    JButton btnAnt = new JButton("<<");
    JButton btnProx = new JButton(">>");
    JButton btnExcluir = new JButton("Excluir");

    public GUI() {
        super("Cidades Turísticas");
        setLayout(new GridLayout(7, 3));
        setSize(650, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(labelCidade);
        add(txtCidade);
        add(new JLabel());
        add(labelPais);
        add(txtPais);
        add(new JLabel());
        add(labelAtrativo);
        add(txtAtrativo);
        add(new JLabel());
        add(labelNota);
        add(txtNota);
        add(btnAdd);
        add(new JLabel());
        add(labelCidadeAtual);
        add(new JLabel());
        add(btnAnt);
        add(txtCidadeAtual);
        add(btnProx);
        add(new JLabel());
        add(btnExcluir);
        add(new JLabel());
        atualiza();
        txtCidadeAtual.setEnabled(false);
        txtCidadeAtual.setDisabledTextColor(Color.BLACK);
        btnAdd.addActionListener(this);
        btnExcluir.addActionListener(this);
        btnAnt.addActionListener(this);
        btnProx.addActionListener(this);
        setVisible(true);
    }

    public void atualiza() {
        if (lista.tamanho == 0) {
            txtCidadeAtual.setText("Lista Vazia.");
        } else {
            txtCidadeAtual.setText(elementoAtual.cidade.nome + ", " + elementoAtual.cidade.pais + ", " + elementoAtual.cidade.atrativos + " - " + elementoAtual.cidade.nota);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == btnAdd) {
            if (!(txtCidade.getText().equals("")) && !(txtPais.getText().equals("")) && !(txtAtrativo.getText().equals("")) && !(txtNota.getText().equals(""))) {
                Cidade c = new Cidade(txtCidade.getText(), txtPais.getText(), txtAtrativo.getText(), Integer.parseInt(txtNota.getText()));
                lista.add(c);
                elementoAtual = lista.cabeca.prox;
                atualiza();
                txtCidade.setText("");
                txtPais.setText("");
                txtAtrativo.setText("");
                txtNota.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Sistema", JOptionPane.WARNING_MESSAGE);
            }
        } else if (ev.getSource() == btnAnt) {
            if (elementoAtual.ant != lista.cabeca) {
                elementoAtual = elementoAtual.ant;
                atualiza();
            } else {
                JOptionPane.showMessageDialog(null, "Esta é a primeira cidade.", "Sistema", JOptionPane.WARNING_MESSAGE);
            }
        } else if (ev.getSource() == btnProx) {
            if (elementoAtual.prox != null) {
                elementoAtual = elementoAtual.prox;
                atualiza();
            } else {
                JOptionPane.showMessageDialog(null, "Esta é a última cidade.", "Sistema", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            if (lista.tamanho == 0) {
                JOptionPane.showMessageDialog(null, "A lista está vazia.", "Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                String cidade = JOptionPane.showInputDialog("Informe a cidade:");
                String pais = JOptionPane.showInputDialog("Informe o país:");
                try {
                    if (lista.remove(cidade, pais)) {
                        JOptionPane.showMessageDialog(null, "Cidade encontrada e excluída com sucesso.", "Sistema", JOptionPane.INFORMATION_MESSAGE);
                        if (lista.tamanho > 0) {
                            elementoAtual = lista.cabeca.prox;
                        }
                        atualiza();
                    } else {
                        JOptionPane.showMessageDialog(null, "Cidade não encontrada.", "Sistema", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
