package src.db.executer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import src.db.DBConstants;
import src.db.connection.NoConnectionException;
/**
 * Execution of DML Commands for a given database schema
 * Stateless objects
 */
public class DBDMLExecuter implements PersistenceDMLExecuter {
	private final DMLStatementTextCreator dml;
	private DBConnectionManager mgr;
	private final String databaseSchema; 
	protected DBDMLExecuter(String serviceName) {
		super();
		this.mgr = DBConnectionManager.getTheInstance();
		this.dml = new DMLStatementTextCreator();
		this.databaseSchema = serviceName; 
	}
	public String getDataBaseSchema() {
		return this.databaseSchema;
	}
/**
 * Protected against concurrent id retrieval	
 */
	public synchronized Integer getNextId() throws PersistenceException {
		try {return mgr.getNextId(this.databaseSchema);}catch(NoConnectionException | SQLException e) {throw new PersistenceException(e.getMessage());} 
	}
	public void insertInto(String tableName, String columnNames, String values) throws SQLException, NoConnectionException {
		stmt().executeUpdate(this.dml.insertInto(tableName, columnNames, values));
	}
	public void delete(String tableName, Integer id) throws SQLException, NoConnectionException {
		stmt().executeUpdate(this.dml.delete(tableName, id));
	}
	public void deleteFromRelationTable(String tableName, Integer p1, Integer p2) throws SQLException, NoConnectionException {
		stmt().executeUpdate(this.dml.deleteFromRelationTable(tableName, p1, p2));
	}
	public Optional<ResultSet> selectIdsOfEntriesOfTable(String tableName, Integer typeKey) throws SQLException, NoConnectionException {
		return Optional.of(stmt().executeQuery(this.dml.selectIdsOfEntriesOfTable(tableName, typeKey)));
	}
	public Optional<ResultSet> selectEntriesOfTable(String tableName, Integer typeKey) throws SQLException, NoConnectionException {
		return Optional.of(stmt().executeQuery(this.dml.selectEntriesOfTable(tableName, typeKey)));
	}
	public Optional<ResultSet> selectAllEntriesOfRelationTable(String tableName) throws SQLException, NoConnectionException {
		return Optional.of(stmt().executeQuery(this.dml.selectAllEntriesOfRelationTable(tableName)));
	}
	public Optional<ResultSet> selectAllEntriesOfTypeKeyTable() throws SQLException, NoConnectionException {
		return Optional.of(stmt().executeQuery(this.dml.selectAllEntriesOfTypeKeyTable(this.databaseSchema)));
	}
	public Optional<ResultSet> selectIdSpecifiedCursorAleadyAtFirstRow(String tableName, Integer id) throws SQLException, NoConnectionException {
		ResultSet rs = stmt().executeQuery(this.dml.selectIdSpecifiedCursorAleadyAtFirstRow(tableName, id));
		boolean hasRow = rs.next();
		if(!hasRow) throw new SQLException("Object with id = " + id + " not found in table " + tableName);
		return Optional.of(rs);
	}
/**
 * Transactionality is guaranteed by database	
 */
	public void update(String tableName, String columnName, String value, Integer id) throws SQLException, NoConnectionException {
		stmt().executeUpdate(this.dml.update(tableName, columnName, value, id));
	}
/**	
 * Retrieves the typename of the object with <id> stored in table <tableName> 
 * @throws PersistenceException 
 */
	public String getNameOfConcreteType(Integer id, String tableName) throws PersistenceException {		
		ResultSet rs1,rs2 = null;
		try {
			rs1 = stmt().executeQuery("SELECT typeKey FROM " + tableName + " WHERE id = " + id);
			if(!rs1.next()) throw new PersistenceException("Retrieving typekey for id " + id + ", but found no entry in table " + tableName);
			Integer typeKey = rs1.getInt("typeKey"); // Type Key is in column 2
			return PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeName(this.databaseSchema, typeKey);
		} catch (SQLException | NoConnectionException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	private Statement stmt() throws SQLException, NoConnectionException {
		return mgr.getIndividualConnection(this.databaseSchema).createStatement(); 
	}
}
