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
    JLabel labelValor = new JLabel(" Valor inicial:");
    JLabel labelParcelas = new JLabel(" Quantidade de Parcelas:");
    JLabel labelValorRestante = new JLabel(" Valor restante:");
    JTextField txtValor = new JTextField();
    JTextField txtParcelas = new JTextField();
    JTextField txtValorPago = new JTextField();
    JButton btnEnviar = new JButton("Pronto");
    JButton btnPagarAtual = new JButton("Pagar Atual");
    JButton btnPagarUltima = new JButton("Pagar Última");

    double valor;
    double juros;
    int qtdParcelas;
    double valorParcela;
    int parcelasPagasComJuros = 1;
    double pagamento = 0.0;
    Deque<Double> parcelamento = new Deque<Double>();

    public GUI() {
        super("IF Bank");
        setLayout(new GridLayout(5, 2));
        setSize(380, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(labelValor);
        add(txtValor);
        add(labelParcelas);
        add(txtParcelas);
        add(new JLabel());
        add(btnEnviar);
        btnEnviar.addActionListener(this);
        add(labelValorRestante);
        add(txtValorPago);
        txtValorPago.setEnabled(false);
        txtValorPago.setDisabledTextColor(Color.BLACK);
        add(btnPagarAtual);
        btnPagarAtual.setEnabled(false);
        btnPagarAtual.addActionListener(this);
        add(btnPagarUltima);
        btnPagarUltima.setEnabled(false);
        btnPagarUltima.addActionListener(this);
        setVisible(true);
    }

    public void ativaCampos(boolean b) {
        txtValor.setEnabled(!b);
        txtParcelas.setEnabled(!b);
        btnEnviar.setEnabled(!b);
        btnPagarAtual.setEnabled(b);
        btnPagarUltima.setEnabled(b);
    }

    public void pagarAtual() throws Exception {
        if (!parcelamento.taVazio()) {
            double valorPago = parcelamento.removeInicio() + (this.juros * parcelasPagasComJuros);
            parcelasPagasComJuros++;
            txtValorPago.setText("R$" + valorPago);
            JOptionPane.showMessageDialog(null, "Valor pago: R$" + valorPago);
            pagamento += valorPago;
            txtValorPago.setText("R$" + pagamento);
            if (parcelamento.taVazio()) {
                JOptionPane.showMessageDialog(null, "Você terminou o pagamento.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há mais parcelas para pagar.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEnviar) {
            try {
                if (!(txtValor.getText().equals("")) && !(txtParcelas.getText().equals(""))) {
                    this.valor = Double.parseDouble(txtValor.getText());
                    this.qtdParcelas = Integer.parseInt(txtParcelas.getText());
                    this.valorParcela = this.valor / this.qtdParcelas;
                    this.juros = this.valorParcela / 100;
                    ativaCampos(true);
                    txtValorPago.setText("R$" + pagamento);
                    while (qtdParcelas > 0) {
                        this.parcelamento.addInicio(this.valorParcela);
                        qtdParcelas--;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha os campos corretamente.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else if (e.getSource() == btnPagarAtual) {
            try {
                pagarAtual();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else if (e.getSource() == btnPagarUltima) {
            try {
                if (parcelamento.tamanho() == 1) {
                    pagarAtual();
                } else if (!parcelamento.taVazio()) {
                    double valorPago = parcelamento.removeFinal();
                    JOptionPane.showMessageDialog(null, "Valor pago: R$" + valorPago);
                    pagamento += valorPago;
                    txtValorPago.setText("R$" + pagamento);
                    if (parcelamento.taVazio()) {
                        JOptionPane.showMessageDialog(null, "Você terminou o pagamento.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não há mais parcelas para pagar.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
}
