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

    SystemControl systemControl;
    String tableName;
    String database;
    List<String> colunas = new ArrayList<>();
    List<Object> dados = new ArrayList<>();
    Map<String, Object> mapColunasDados = new HashMap<>();
    List<HashMap<String, String>> listColunasArquivo = new ArrayList<>();
    RandomAccessFile raf;

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

    public List<Object> getDados() {
        return dados;
    }

    public void setDados(List<Object> dados) {
        this.dados = dados;
    }

    public void insereDados() {
        try {
            raf = new RandomAccessFile(systemControl.buscaCaminho() + File.separator + database + File.separator + tableName + ".dat", "rw");
            populaListas(raf);

            for (HashMap map : listColunasArquivo) {
                for (Object s : map.keySet()) {
                    String coluna = (String) s;
                    if (mapColunasDados.containsKey(coluna)) {
                        
                    }
                }
            }
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
