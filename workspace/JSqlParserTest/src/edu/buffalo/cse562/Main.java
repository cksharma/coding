package edu.buffalo.cse562;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParser;
import net.sf.jsqlparser.parser.ParseException;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.select.FromItem;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.select.SelectItem;
import net.sf.jsqlparser.statement.select.Union;

public class Main {
	public static void main(String[] args) {
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		TaskJSqlTest solver = new TaskJSqlTest();
		solver.solve(out);
		out.close();
	}
}

class TaskJSqlTest {
	
	private final String SQL_FILE_PATH = "/home/cksharma/data/git/db-prjs/db/data/Sanity_Check_Examples/AGG12.SQL";
	//private final String DAT_FILE_PATH = "/home/cksharma/data/git/db-prjs/db/data/Sanity_Check_Examples/data/r.dat";
	
	public void solve(PrintWriter out) {
		File file = new File(SQL_FILE_PATH);
		try {
			Statement stmt;
			CCJSqlParser parser = new CCJSqlParser(new FileReader(file));
			while ((stmt = parser.Statement()) != null) {
				
				if (stmt instanceof CreateTable) {
					
				} else if (stmt instanceof Select) {
					SelectBody body = ((Select) stmt).getSelectBody();					
					if (body instanceof PlainSelect) {
						FromItem fromItem = ((PlainSelect) body).getFromItem();
						Expression where = ((PlainSelect) body).getWhere();
						List <SelectItem> list = ((PlainSelect) body).getSelectItems();
						
						out.println("FromItem analysis");
						out.println(fromItem);
						out.println(((PlainSelect) body).getJoins());
						out.println();
						
						out.println("Where");
						out.println(where);
						out.println();				
						
						out.println("Select Items");
						out.println(list);
						out.println();
						
					} else if (body instanceof Union) {
						
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
