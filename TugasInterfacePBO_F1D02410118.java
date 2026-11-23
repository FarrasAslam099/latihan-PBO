import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BiodataApp extends JFrame {  

    private JTextField tfNama, tfNim, tfJurusan;
    private JTextArea taHasil;
    private JButton btnSimpan, btnReset;

    public BiodataApp() {
        setTitle("Form Biodata Mahasiswa");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        JPanel panelUtama = new JPanel(new BorderLayout(10, 10));
        panelUtama.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelForm = new JPanel(new GridLayout(3, 2, 5, 5));
        tfNama = new JTextField();
        tfNim = new JTextField();
        tfJurusan = new JTextField();
        panelForm.add(new JLabel("Nama"));    // (3) 
        panelForm.add(tfNama);
        panelForm.add(new JLabel("NIM"));
        panelForm.add(tfNim);
        panelForm.add(new JLabel("Jurusan"));
        panelForm.add(tfJurusan);

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnSimpan = new JButton("Simpan");
        btnReset = new JButton("Reset");
        panelTombol.add(btnSimpan);
        panelTombol.add(btnReset);

        taHasil = new JTextArea(8, 30);
        taHasil.setEditable(false);
        JScrollPane scroll = new JScrollPane(taHasil);

        JPanel panelAtas = new JPanel(new BorderLayout(5, 5));
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        panelUtama.add(new JLabel("Isi data diri Anda:", SwingConstants.CENTER), BorderLayout.NORTH);
        panelUtama.add(panelAtas, BorderLayout.CENTER);
        panelUtama.add(scroll, BorderLayout.SOUTH);
        add(panelUtama);

        pasangEvent();
    }

    private void pasangEvent() {
        // (5) Event Listener Interface: ActionListener
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfNama.getText().isBlank() || tfNim.getText().isBlank()) {
                    JOptionPane.showMessageDialog(BiodataApp.this,
                            "Nama dan NIM wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                taHasil.append("Nama   : " + tfNama.getText() + "\n"
                        + "NIM    : " + tfNim.getText() + "\n"
                        + "Jurusan: " + tfJurusan.getText() + "\n"
                        + "----------------------\n");
            }
        });

        btnReset.addActionListener(e -> {  
            tfNama.setText("");
            tfNim.setText("");
            tfJurusan.setText("");
            taHasil.setText("");
        });

        MouseAdapter hover = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ((JButton) e.getSource()).setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ((JButton) e.getSource()).setBackground(null);
            }
        };
        btnSimpan.addMouseListener(hover);
        btnReset.addMouseListener(hover);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int pilih = JOptionPane.showConfirmDialog(BiodataApp.this,
                        "Yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (pilih == JOptionPane.YES_OPTION) {
                    dispose();
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BiodataApp().setVisible(true));
    }
}
