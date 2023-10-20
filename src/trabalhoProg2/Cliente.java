package trabalhoProg2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    private JTextField serverIPField;
    private JTextField portField;
    private JTextArea messageTextArea;
    private JTextField inputField;
    private JButton connectButton;

    public Cliente() {
        JFrame frame = new JFrame("Cliente Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel controlPanel = new JPanel();
        serverIPField = new JTextField(15);
        portField = new JTextField(5);
        connectButton = new JButton("Conectar ao Servidor");

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        controlPanel.add(new JLabel("IP do Servidor: "));
        controlPanel.add(serverIPField);
        controlPanel.add(new JLabel("Porta: "));
        controlPanel.add(portField);
        controlPanel.add(connectButton);

        frame.add(controlPanel, BorderLayout.NORTH);

        messageTextArea = new JTextArea();
        messageTextArea.setEditable(false);
        frame.add(new JScrollPane(messageTextArea), BorderLayout.CENTER);

        inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        frame.add(inputField, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    protected void sendMessage() {
		
	}

	protected void connectToServer() {
		
	}

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Cliente();
            }
        });
    }
}

//Agora, o código do cliente é um aplicativo de janela Swing que permite ao usuário inserir o IP do servidor, 
//a porta e enviar mensagens para o servidor.




