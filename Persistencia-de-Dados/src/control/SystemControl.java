/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author guilh
 */
public class SystemControl {

    public String createDatabase(String nome) {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        File diretorio = new File(s + File.separator + "databases" + File.separator + nome);
        if(!diretorio.exists()){
            diretorio.mkdirs();
            return "Banco de dados criado com sucesso!";
        } else {
            return "Já existe um banco de dados com o nome informado. Tente novamente!";
        }
    }
    
    public static boolean validaNome(String nome) {
        String caracteresPermitidos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";
        boolean retorno = true;
        if (nome.length() > 20 || nome.length() < 1) {
            retorno = false;
        } else {
            for (char c : nome.toCharArray()) {
                if (!caracteresPermitidos.contains(String.valueOf(c))) {
                    retorno = false;
                    break;
                }
            }
        }
        return retorno;
    }

}
