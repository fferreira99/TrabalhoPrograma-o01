package trabalhoProg2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Servidor {

    private ServerSocket server;
    private Socket client;
    private Scanner scanner;
    private JTextArea textArea;
    private JTextField portField;

    public Servidor() {
        JFrame frame = new JFrame("Servidor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();

        textArea = new JTextArea(15, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        portField = new JTextField(10);
        JButton startButton = new JButton("Iniciar Servidor");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
            }
        });

        panel.add(portField);
        panel.add(startButton);

        frame.add(scrollPane, "Center");
        frame.add(panel, "South");

        frame.setVisible(true);
    }

    private void startServer() {
        int port = Integer.parseInt(portField.getText());

        try {
            server = new ServerSocket(port);
            appendMessage("Porta " + port + " aberta, aguardando conexão do cliente");
            client = server.accept();
            appendMessage("Conexão do Cliente " + client.getInetAddress().getHostAddress());
            scanner = new Scanner(client.getInputStream());

            while (scanner.hasNextLine()) {
                appendMessage(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (scanner != null) {
                    scanner.close();
                }
                if (client != null) {
                    client.close();
                }
                if (server != null) {
                    server.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void appendMessage(String message) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                textArea.append(message + "\n");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Servidor();
            }
        });
    }
}

//Geralmente, essa estrutura é uma interface gráfica simples que permite ao usuário definir 
//a porta do servidor e iniciar o servidor. Quando o servidor é iniciado, ele começa a ouvir na 
//porta especificada, aceita conexões de clientes e exibe mensagens recebidas na área de texto.

