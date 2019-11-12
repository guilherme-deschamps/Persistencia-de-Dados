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
import antlr.SQLiteParser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import models.Insert;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author guilh
 */
public class SystemControl {

    private SQLiteBaseListener sQLiteBaseListener = new SQLiteBaseListener();
    List<String> nomesColunasXml = new ArrayList<>();
    List<String> valoresColunasXml = new ArrayList<>();
    List<String> entradasXml = new ArrayList<>();
    String database;

    public String createDatabase(String nome) {
        File diretorio = new File(buscaCaminho() + File.separator + nome);
        if (!diretorio.exists()) {
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

    public String buscaCaminho() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        return s + File.separator + "databases";
    }

    public String recebeComando(String comando, String database) {
        sQLiteBaseListener.setDatabase(database);

        CodePointCharStream inputStream = CharStreams.fromString(comando);
        SQLiteLexer lexer = new SQLiteLexer(inputStream);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        SQLiteParser parser = new SQLiteParser(cts);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.parse();
        ParseTreeWalker p = new ParseTreeWalker();
        p.walk(sQLiteBaseListener, tree);

        if (sQLiteBaseListener.getRetornoCreate() != null) {
            return sQLiteBaseListener.getRetornoCreate();
        } else if (sQLiteBaseListener.getRetornoInsert() != null) {
            return sQLiteBaseListener.getRetornoInsert();
        } else {
            return "select_command";
        }
    }

    public HashMap<String, List<String>> getRetornoSelect() {
        return sQLiteBaseListener.getRetornoSelect();
    }

    public boolean validaXml(String rota) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            Schema schema = schemaFactory.newSchema(new File(s + File.separator + "udescdb.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(rota)));
            return true;
        } catch (SAXException ex) {
            JOptionPane.showMessageDialog(null, "O XML informado possui um formato inválido. Tente novamente!");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "O arquivo informado não pôde ser encontrado!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void inserePorXml(String rota) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(true);
        dbf.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(rota));

            Element root = doc.getDocumentElement();

            NodeList tabelas = doc.getElementsByTagName("table");
            for (int i = 0; i < tabelas.getLength(); i++) {
                getDadosXml(tabelas.item(i).getChildNodes());
                
                for (int j = 0; j < entradasXml.size(); j++) {
                    nomesColunasXml.add(entradasXml.get(j));
                    j++;
                    valoresColunasXml.add(entradasXml.get(j));
                }

                String colunasInsert = (nomesColunasXml.toString().replace("[", "(").replace("]", ")"));
                String valoresInsert = (valoresColunasXml.toString().replace("[", "(").replace("]", ")"));
                
                Insert insert = new Insert();
                insert.setDatabase(database);
                insert.setColunas(nomesColunasXml);
                insert.setDados(valoresColunasXml);
                insert.setTableName(tabelas.item(i).getAttributes().getNamedItem("name").getNodeValue());
                insert.insereDados();
                
                nomesColunasXml = new ArrayList<>();
                valoresColunasXml = new ArrayList<>();
                entradasXml = new ArrayList<>();
            }
            
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso! Utilize o comando select para visualizar.");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }
    }

    private void getDadosXml(NodeList filhos) {
        for (int i = 0; i < filhos.getLength(); i++) {
            Node filho = filhos.item(i);
            if (filho.getChildNodes().getLength() > 0) {
                getDadosXml(filho.getChildNodes());
            } else if (filho.getNodeValue().trim().length() > 0) {
                entradasXml.add(filho.getNodeValue());
            }
        }
    }
    
    public void setDatabase(String dabatase){
        this.database = dabatase;
    }
}
