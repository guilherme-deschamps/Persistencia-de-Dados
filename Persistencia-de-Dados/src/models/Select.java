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

    public HashMap<String, List<String>> getAllDadosArquivo() {
        try {
            RandomAccessFile raf
                    = new RandomAccessFile(systemControl.buscaCaminho() + File.separator + database + File.separator + tableName + ".dat", "r");

            List<Pair<String, String>> listaColunas = getMapColunasArquivo(raf);
            HashMap<String, List<String>> result = new HashMap<>();
            List<String> dados;
            String dadoAtual = "";
            char c;

            // Cada elemento da lista de colunas é, na mesma ordem, uma coluna no arquivo.
            for (int i = 0; i < listaColunas.size(); i++) {
                dados = new ArrayList<>();
                raf.seek(0);
                raf.readLine();
                while (raf.getFilePointer() != raf.length()) {
                    int contSeparators = 0;
                    // Move o ponteiro para a coluna correta
                    while (contSeparators != i) {
                        c = raf.readChar();
                        if (c == 'ä') {
                            contSeparators++;
                        }
                    }
                    if (listaColunas.get(i).getValue().equals("int")) {
                        dadoAtual += raf.readInt();
                    } else if (listaColunas.get(i).getValue().equals("float")) {
                        dadoAtual += raf.readFloat();
                    } else {
                        do {
                            c = raf.readChar();
                            dadoAtual += c;
                        } while (c != 'ä');
                        dadoAtual = dadoAtual.substring(0, dadoAtual.length() - 2);
                    }
                    dadoAtual = dadoAtual.replace("'", "");
                    if (dadoAtual.contains("its_a_nullhere") || dadoAtual.contains("" + Integer.MAX_VALUE) || dadoAtual.contains("" + Float.MAX_VALUE)) {
                        dados.add("null");
                    } else {
                        dados.add(dadoAtual);
                    }
                    dadoAtual = "";
                    raf.readLine();
                }
                result.put(listaColunas.get(i).getKey(), dados);
            }
            return result;
        } catch (IOException ex) {
            return null;
        }
    }

    public List<Pair<String, String>> getMapColunasArquivo(RandomAccessFile raf) {
        try {
            List<Pair<String, String>> listColunasOrdenadas = new ArrayList<>();
            Pair<String, String> parColunaTipo;

            String s;
            String colunaAtual = "";
            String tipoAtual = "";
            char c;
            c = raf.readChar();
            do {
                s = "";
                while (c != 'ä') {
                    colunaAtual += c;
                    c = raf.readChar();
                }
                c = raf.readChar();
                while (c != 'ü') {
                    tipoAtual += c;
                    c = raf.readChar();
                }
                parColunaTipo = new Pair<>(colunaAtual, tipoAtual);
                listColunasOrdenadas.add(parColunaTipo);
                colunaAtual = "";
                tipoAtual = "";
                c = raf.readChar();
                s += c;
            } while (!s.equals(";"));
            return listColunasOrdenadas;
        } catch (IOException ex) {
            return null;
        }
    }
}
