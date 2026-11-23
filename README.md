# Latihan GUI Java Swing: Form Biodata Mahasiswa

Aplikasi sederhana untuk mengeksplorasi 5 komponen utama GUI pada Java Swing.
Pengguna mengisi Nama, NIM, dan Jurusan, lalu menekan **Simpan** untuk menampilkan data di area hasil, atau **Reset** untuk mengosongkan form.

## Cara Menjalankan

```bash
javac BiodataApp.java
java BiodataApp
```

## 5 Komponen Utama GUI yang Digunakan

### 1. Top-level Container Class
| Class | Fungsi |
|---|---|
| `javax.swing.JFrame` | Jendela utama aplikasi. `BiodataApp` meng-extend `JFrame`, sehingga menjadi wadah paling luar yang menampung semua komponen lain. |

### 2. Intermediate Container Class
| Class | Fungsi |
|---|---|
| `javax.swing.JPanel` | Wadah perantara untuk mengelompokkan komponen: `panelUtama`, `panelAtas`, `panelForm`, `panelTombol`. |
| `javax.swing.JScrollPane` | Membungkus `JTextArea` agar bisa di-scroll. |

### 3. Atomic Component Class
| Class | Fungsi |
|---|---|
| `javax.swing.JLabel` | Menampilkan teks label ("Nama", "NIM", "Jurusan"). |
| `javax.swing.JTextField` | Input satu baris untuk nama, NIM, dan jurusan. |
| `javax.swing.JButton` | Tombol **Simpan** dan **Reset**. |
| `javax.swing.JTextArea` | Area teks (read-only) untuk menampilkan hasil. |

### 4. Layout Classes (3 layout)
| Class | Dipakai pada | Keterangan |
|---|---|---|
| `java.awt.BorderLayout` | `panelUtama` dan `panelAtas` | Membagi area menjadi NORTH, CENTER, SOUTH. |
| `java.awt.GridLayout` | `panelForm` | Grid 3 baris x 2 kolom untuk pasangan label dan input. |
| `java.awt.FlowLayout` | `panelTombol` | Menata tombol berurutan secara h
orizontal di tengah. |

### 5. Event Listener
| Class / Interface | Jenis | Method yang di-override |
|---|---|---|
| `java.awt.event.ActionListener` | Interface | `actionPerformed()` untuk tombol Simpan dan Reset. |
| `java.awt.event.MouseAdapter` | Adapter class | `mouseEntered()` dan `mouseExited()` untuk efek hover pada tombol. |
| `java.awt.event.WindowAdapter` | Adapter class | `windowClosing()` untuk dialog konfirmasi saat menutup jendela. |

## Isi Repositori

- `BiodataApp.java`: kode program
- `README.md`: dokumentasi ini

<img width="538" height="485" alt="image" src="https://github.com/user-attachments/assets/0969b624-2fad-4fd3-a067-3a4b8d53918d" />

