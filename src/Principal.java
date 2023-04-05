import java.net.*;
import java.io.*;
import javax.swing.*;

public class Principal {
    private static int Porta;
    private static String Endereco;

    public static void main(String[] args) {

        Porta = Integer.parseInt(JOptionPane.showInputDialog("Insira a porta: "));
        Endereco = JOptionPane.showInputDialog("Insira o endereço: ");

        try {
            try (Socket sock = new Socket(Endereco, Porta)) {
                PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                String linha = "";
                out.println("GET / HTTP/1.0\n");
                while ((linha = in.readLine()) != null) {
                    System.out.println("echo: " + linha);
                }
            }
        } catch (IOException e) {
            System.err.println("Problemas de IO");
        }
    }
}
