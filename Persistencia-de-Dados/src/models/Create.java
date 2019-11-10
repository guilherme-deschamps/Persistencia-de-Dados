/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import control.SystemControl;
import java.io.File;
import java.io.FileNotFoundException;
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
public class Create {

    Map<String, String> colunas = new HashMap<>();
    SystemControl systemControl = new SystemControl();
    String tableName;
    String database;

    public void addColuna(String coluna, String tipoColuna) {
        colunas.put(coluna, tipoColuna);
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String nome) {
        this.tableName = nome;
    }

    public void createTable() throws FileNotFoundException, IOException {
        String path = systemControl.buscaCaminho() + File.separator + database + File.separator + tableName + ".dat";
        File table = new File(path);
        try {
            table.createNewFile();
        } catch (IOException ex) {
        }

        RandomAccessFile raf = new RandomAccessFile(path, "rw");
        
        for(String key : colunas.keySet()){
        raf.writeChars(key);
        raf.writeChar('ä');
        raf.writeChars(colunas.get(key));
        raf.writeChar('ü');
        }
        raf.writeChar(';');
    }

}
