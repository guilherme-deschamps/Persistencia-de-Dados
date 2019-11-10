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
    List<HashMap<String, String>> listColunasArquivo = new ArrayList<>();

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

    public void insereDados() {
        try {
            RandomAccessFile raf = new RandomAccessFile(systemControl.buscaCaminho() + File.separator + database + File.separator + tableName + ".dat", "rw");
            populaListas(raf);

            // Para cada par coluna/tipo do arquivo
            for (HashMap map : listColunasArquivo) {
                // Só terá uma coluna dentro. A ideia de Map foi usada para associar coluna/tipo, no formado key/value.
                for (Object s : map.keySet()) {
                    String coluna = (String) s;
                    raf.seek(raf.length());
                    // Caso o map de dados por coluna tiver algum dado para a coluna atual, insere o dado nela. Se não, insere "null" (∅)
                    if (mapColunasDados.containsKey(coluna)) {
                        // Os dados podem ser int, char ou float.
                        if (map.get(s).equals("int")) {
                            raf.writeInt(Integer.parseInt(mapColunasDados.get(coluna)));
                        } else if (map.get(s).equals("char")) {
                            raf.writeChars(mapColunasDados.get(coluna));
                        } else {
                            raf.writeFloat(Float.parseFloat(mapColunasDados.get(coluna)));
                        }
                    } else {
                        raf.writeChar('∅');
                    }
                }
                raf.writeChar('ä');
            }
            raf.writeChar(';');
            raf.writeChar('\n');
            raf.close();
        } catch (IOException ex) {
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
