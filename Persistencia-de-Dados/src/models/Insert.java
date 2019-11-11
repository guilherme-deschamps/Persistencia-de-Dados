/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import control.SystemControl;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author Lucas
 */
public class Insert {

    SystemControl systemControl = new SystemControl();
    String tableName;
    String database;
    List<String> colunas = new ArrayList<>();
    List<String> dados = new ArrayList<>();
    Map<String, String> mapColunasDados = new HashMap<>();
    List<Pair<String, String>> listColunasArquivo = new ArrayList<>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public List<String> getColunas() {
        return colunas;
    }

    public void setColunas(List<String> colunas) {
        this.colunas = colunas;
    }

    public List<String> getDados() {
        return dados;
    }

    public void setDados(List<String> dados) {
        this.dados = dados;
    }

    public String insereDados() {
        try {
            RandomAccessFile raf = new RandomAccessFile(systemControl.buscaCaminho() + File.separator + database + File.separator + tableName + ".dat", "rw");
            populaListas(raf);

            // Para cada par coluna/tipo do arquivo
            for (Pair pair : listColunasArquivo) {
                String coluna = (String) pair.getKey();
                raf.seek(raf.length());
                // Os dados podem ser int, char ou float. Para cada tipo, reservamos um elemento para ser seu respectivo "null".
                if (pair.getValue().equals("int")) {
                    if (mapColunasDados.containsKey(coluna)) {
                        raf.writeInt(Integer.parseInt(mapColunasDados.get(coluna)));
                    } else {
                        raf.writeInt(Integer.MAX_VALUE);
                    }
                } else if (pair.getValue().equals("char")) {
                    if (mapColunasDados.containsKey(coluna)) {
                        raf.writeChars(mapColunasDados.get(coluna));
                    } else {
                        raf.writeChars("its_a_nullhere'");
                    }
                } else {
                    if (mapColunasDados.containsKey(coluna)) {
                        raf.writeFloat(Float.parseFloat(mapColunasDados.get(coluna)));
                    } else {
                        raf.writeFloat(Float.MAX_VALUE);
                    }
                }
                raf.writeChar('ä');
            }
            raf.writeChar(';');
            raf.writeChar('\n');
            raf.close();
            return "Dados inseridos com sucesso!";
        } catch (IOException ex) {
            return "Ocorreu um erro ao inserir os dados. Tente novamente!";
        }
    }

    private void populaListas(RandomAccessFile raf) {
//        if(colunas.size() != dados.size()){
//            return "Para inserir dados na tabela, deve haver um dado para cada coluna informada.";
//        }
        for (int i = 0; i < colunas.size(); i++) {
            this.mapColunasDados.put(colunas.get(i), dados.get(i));
        }
        this.listColunasArquivo = new Select().getMapColunasArquivo(raf);
    }
}
