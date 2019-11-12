
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr.SQLiteBaseListener;
import br.udesc.udescdb.SQLiteLexer;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import antlr.SQLiteParser;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Teste {

    public static void main(String[] args) {
//		String create = "create table xpto (col1 int, col2 char(20), col3 float)";
//		String insert = "insert into xpto (col1, col2) values (1, 'abc')";
//		String select = "select * from xpto";
//		
//		CodePointCharStream inputStream = CharStreams.fromString(select);
//		SQLiteLexer lexer = new SQLiteLexer(inputStream);
//		CommonTokenStream cts = new CommonTokenStream(lexer);
//		SQLiteParser parser = new SQLiteParser(cts);
//		parser.setBuildParseTree(true);
//		ParseTree tree = parser.parse();
//				
//		ParseTreeWalker p = new ParseTreeWalker();
//		p.walk(new SQLiteBaseListener(), tree);

        // agora vamos pegar as informacoes que o listener capturou e processar o comando 

    }



}
