/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import antlr.SQLiteBaseListener;
import br.udesc.udescdb.SQLiteLexer;
import java.io.File;
import java.io.RandomAccessFile;
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
    
    private SQLiteBaseListener sQLiteBaseListener = new SQLiteBaseListener();
    
    public String createDatabase(String nome) {
        File diretorio = new File(buscaCaminho() + File.separator + nome);
        if(!diretorio.exists()){
            diretorio.mkdirs();
            return "Banco de dados criado com sucesso!";
        } else {
            return "Já existe um banco de dados com o nome informado. Tente novamente!";
        }
    }
    
    public boolean validaNome(String nome) {
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
    
    public String buscaCaminho(){
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        return s + File.separator + "databases";
    }
    
    public String recebeComando(String comando, String database){
        sQLiteBaseListener.setDatabase(database);
        
        CodePointCharStream inputStream = CharStreams.fromString(comando);
        SQLiteLexer lexer = new SQLiteLexer(inputStream);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        SQLiteParser parser = new SQLiteParser(cts);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.parse();
        ParseTreeWalker p = new ParseTreeWalker();
        p.walk(sQLiteBaseListener, tree);
        
        return "Comando recebido.";
    }
   
    public int buscaFimDoArquivo(RandomAccessFile raf){
    }

}
