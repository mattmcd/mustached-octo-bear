import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) throws Exception {
		CharStream input = new ANTLRFileStream(args[0]);
		ReportSpecLexer lex = new ReportSpecLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		// System.out.println("tokens="+tokens);
		ReportSpecParser parser = new ReportSpecParser(tokens);
		ReportSpecParser.workbook_return r = parser.workbook();

    CommonTree t = (CommonTree) r.getTree();
    CommonTreeNodeStream nodes = new CommonTreeNodeStream( t );
    nodes.setTokenStream( tokens );

    FileReader groupFileR = new FileReader( "XML.stg" );
    StringTemplateGroup templates = new StringTemplateGroup( groupFileR );
    groupFileR.close();

    SpecWalker walker = new SpecWalker( nodes );
    walker.setTemplateLib( templates );
    SpecWalker.workbook_return ret = walker.workbook();
    System.out.println( ret.getTemplate() );
	}
}
