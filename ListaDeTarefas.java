import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListaDeTarefas {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Minha Lista de Tarefas 🌸");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JPanel painelFundo = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradiente = new GradientPaint(0, 0, new Color(255, 182, 193), 0, getHeight(), new Color(255, 240, 245));
                g2d.setPaint(gradiente);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        painelFundo.setLayout(null);
        frame.setContentPane(painelFundo);

        JTextField tarefaInput = new JTextField();
        tarefaInput.setBounds(50, 30, 200, 30);
        tarefaInput.setFont(new Font("Arial", Font.PLAIN, 14));
        painelFundo.add(tarefaInput);

        JButton addButton = new JButton("Adicionar 🌷");
        addButton.setBounds(260, 30, 100, 30);
        addButton.setBackground(new Color(255, 105, 180));
        addButton.setForeground(Color.WHITE);
        painelFundo.add(addButton);

        DefaultListModel<String> listaModelo = new DefaultListModel<>();
        JList<String> listaTarefas = new JList<>(listaModelo);
        listaTarefas.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(listaTarefas);
        scroll.setBounds(50, 80, 310, 300);
        painelFundo.add(scroll);

        JButton removeButton = new JButton("Remover 💔");
        removeButton.setBounds(50, 400, 310, 40);
        removeButton.setBackground(new Color(255, 105, 180));
        removeButton.setForeground(Color.WHITE);
        painelFundo.add(removeButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tarefa = tarefaInput.getText();
                if (!tarefa.isEmpty()) {
                    listaModelo.addElement(tarefa);
                    tarefaInput.setText("");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaTarefas.getSelectedIndex();
                if (selectedIndex != -1) {
                    listaModelo.remove(selectedIndex);
                }
            }
        });

        frame.setVisible(true);
    }
}