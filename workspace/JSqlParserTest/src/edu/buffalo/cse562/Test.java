package edu.buffalo.cse562;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;

public class Test {
    public static void main(String args[]) throws JSQLParserException {
        String sql = "select t1.a, t2.b from t1, t2 where t1.id = t2.id";
        Statement parse = CCJSqlParserUtil.parse(sql);
        Select select = (Select)parse;
        PlainSelect ps = (PlainSelect)select.getSelectBody();
        System.out.println(ps);
        System.out.println(ps.getFromItem());
        System.out.println(ps.getJoins().get(0));
        System.out.println(ps.getJoins());	
    }
}