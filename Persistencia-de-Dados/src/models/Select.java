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
public class Select {

    SystemControl systemControl = new SystemControl();
    String tableName;
    String database;

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

    public List<String> getColunasArquivo() {
        return null;
    }

    public List<HashMap<String, String>> getMapColunasArquivo(RandomAccessFile raf) {
        try {
            List<HashMap<String, String>> listColunasOrdenadas = new ArrayList<>();
            HashMap<String,String> mapColunas = new HashMap<>();

            String s = "";
            String colunaAtual = "";
            String tipoAtual = "";
            char c;
            do {
                c = raf.readChar();
                    while (c != 'ä') {
                        colunaAtual += c;
                        c = raf.readChar();
                    }
                    c = raf.readChar();
                    while (c != 'ü'){
                        tipoAtual += c;
                        c = raf.readChar();
                    }
                    mapColunas.put(colunaAtual, tipoAtual);
                    listColunasOrdenadas.add(mapColunas);
                    mapColunas = new HashMap<>();
                    colunaAtual = "";
                    tipoAtual = "";
            } while (!s.equals(';'));
            return listColunasOrdenadas;
        } catch (IOException ex) {
            return null;
        }
    }
}
