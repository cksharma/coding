package edu.buffalo.cse562;

import java.io.StringReader;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;

public class MySQLParser
{
    CCJSqlParserManager parserManager = new CCJSqlParserManager();

    public MySQLParser() throws JSQLParserException
    {
        String statement = "SELECT R.A, R.B from R as k, S where k.B = S.B";
        PlainSelect plainSelect = (PlainSelect) ((Select) parserManager.parse(new StringReader(statement))).getSelectBody();        
        System.out.println(plainSelect.getFromItem());
        System.out.println(plainSelect.getJoins());
        System.out.println(plainSelect.getWhere());
        System.out.format("%s",
                plainSelect.getSelectItems().get(0),
                ((Function)((SelectExpressionItem) plainSelect.getSelectItems().get(0)).getExpression()).isAllColumns());
    }
    public static void main(String[] args) throws JSQLParserException
    {

        new MySQLParser();

    }

}
