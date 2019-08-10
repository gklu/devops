package gov.utilities;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.neo4j.driver.internal.spi.Connection;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Statement;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.graphql.Translator;
import org.neo4j.graphql.Translator.Cypher;
import org.neo4j.driver.v1.*;
import static org.neo4j.driver.v1.Values.parameters;
public class DBUtility {
	
private static Connection conn; 
private static Statement statement;
private static StatementResult result;







private static void setResultSet(String cypher) throws ClassNotFoundException {
	
	{
		
		try {
			
			Class.forName("org.neo4j.jdbc.bolt.BoltDriver");
			conn = (Connection) DriverManager.getConnection("bolt://neo4j.essential-dev.com:7687","neo4j","icdcDBneo4j0");
			Driver driver = (Driver) GraphDatabase.driver("\"bolt://neo4j.essential-dev.com:7687\"",
					AuthTokens.basic("neo4j", "icdcDBneo4j0"));
			statement = (Statement) ((java.sql.Connection) conn).createStatement();
			result = (StatementResult) ((java.sql.Statement) statement).executeQuery(cypher);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
		
		
		/**
		 * Exposed to the public, this function takes graphql script ( query / mutation ) translate into  cypher 
		 * and then execute cypher return collection of map object
		 * 
		 * 
		 * @param graphql script
		 * 
		 * @return List<List<Map<String, Object>>>, if fails to execute cypher will return empty object;
		 */
//
//		public List<List<Map<String, Object>>> query (String graphQl) {
//			List<Cypher> cyphers = this.translate(graphQl);
//			List<List<Map<String, Object>>> results = new ArrayList<List<Map<String, Object>>>();
//			for (Cypher cypher : cyphers) {
//				results.add(query(cypher.getQuery(), cypher.getParams()));
			}
			
//			return results;
		

		/**
		 * Translator , translate graphql into cypher
		 * 
		 * @param graphql script
		 * 
		 * @return List of cypher object
		 */
//		private List<Cypher> translate(String graphql) {
//			String schema = config.getGraphSchemas();
//			Translator translator = new Translator(SchemaBuilder.buildSchema(schema));
//			return translator.translate(graphql);
//		}

//} 
	
//	try{
//		Class.forName("org.neo4j.jdbc.Driver").newInstance();
//	}catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	
//	}
//		
//try {
//	Driver driver = (Driver) GraphDatabase.driver( "bolt://localhost:7687", AuthTokens.basic( "neo4j", "neo4j" ) );
//	 java.sql.Connection connect =  DriverManager.getConnection("bolt://neo4j.essential-dev.com:7687","neo4j","icdcDBneo4j0");
//
//     java.sql.Statement stmt = connect.createStatement();
//     String q = "";  
//
//     ResultSet rs = stmt.executeQuery(q);
//     while(rs.next())
//     {
//         System.out.println(rs.getString(""));
//     }
// } catch (Exception e) {
//     // TODO: handle exception
//
//     e.printStackTrace();
// }
		
	//}
}


	


