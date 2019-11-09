/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
    List<String> linhas = new ArrayList<>();

    public void addColuna(String coluna, String tipoColuna){
        colunas.put(coluna, tipoColuna);
    }
    
    public void addLinha(String linha){
        linhas.add(linha);
    }
}