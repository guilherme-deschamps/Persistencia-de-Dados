/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import antlr.SQLiteBaseListener;
import br.udesc.udescdb.SQLiteLexer;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import model.AntLR.SQLiteParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author guilh
 */
public class SystemControl {

    public static String createDatabase(String nome) {
        File diretorio = new File(buscaCaminho() + File.separator + nome);
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
    
    public static String buscaCaminho(){
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        return s + File.separator + "databases";
    }
    
}
