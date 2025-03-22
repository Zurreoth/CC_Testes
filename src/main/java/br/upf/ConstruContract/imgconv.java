package br.upf.ConstruContract;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class imgconv {

    public static void main(String[] args) {
        String filePath = "/Users/igorc/Downloads/img1.jpg"; // Substitua com o caminho correto da sua imagem

        try {
            File file = new File(filePath);
            byte[] fileContent = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(fileContent); // Lê todo o conteúdo do arquivo para o array de bytes
            fis.close();

            // Exemplo de como você pode representar o array de bytes como base64
            String base64Encoded = Base64.getEncoder().encodeToString(fileContent);
            System.out.println(base64Encoded);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
