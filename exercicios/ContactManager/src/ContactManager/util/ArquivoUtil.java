package ContactManager.util;

import ContactManager.model.Contato;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ArquivoUtil {

    private static final String ARQUIVO_DADOS = "contatos.dat";

    public static void salvar(Map<String, Contato> contatos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DADOS))) {
            oos.writeObject(contatos);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    // Carrega o mapa de contatos do arquivo
    @SuppressWarnings("unchecked")
    public static Map<String, Contato> carregar() {
        File arquivo = new File(ARQUIVO_DADOS);
        if (!arquivo.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (Map<String, Contato>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
            return new HashMap<>();
        }
    }
}