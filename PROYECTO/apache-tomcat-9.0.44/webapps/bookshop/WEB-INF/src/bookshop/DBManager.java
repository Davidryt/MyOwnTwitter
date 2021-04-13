package bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.naming.InitialContext;
import javax.naming.Context;

import javax.sql.DataSource;


public class DBManager implements AutoCloseable {

    private Connection connection;

    public DBManager() throws SQLException, NamingException {
		connect();
	}

    private void connect() throws SQLException, NamingException {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/BookShop");
		connection = ds.getConnection();
	}


    /**
     * Close the connection to the database if it is still open.
     *
     */
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        connection = null;
    }

    /**
     * Return the number of units in stock of the given book.
     *
     * @param book The book object.
     * @return The number of units in stock, or 0 if the book does not
     *         exist in the database.
     * @throws SQLException If somthing fails with the DB.
     */
    public int getStock(Book book) throws SQLException {
        return getStock(book.getId());
    }

    /**
     * Return the number of units in stock of the given book.
     *
     * @param bookId The book identifier in the database.
     * @return The number of units in stock, or 0 if the book does not
     *         exist in the database.
     */
    public int getStock(int bookId) throws SQLException {
        String query = "SELECT * " + " FROM Unidades " + " WHERE libro=" + bookId;
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		if(rs != null){
			rs.next();
			return rs.getInt("unidades");
		}

        return 0;
    }

    /**
     * Search book by ISBN.
     *
     * @param isbn The ISBN of the book.
     * @return The Book object, or null if not found.
     * @throws SQLException If somthing fails with the DB.
     */
    public Book searchBook(String isbn) throws SQLException {
		String query = "SELECT * " + " FROM Libros " + " WHERE isbn=" + isbn;
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		Book b = new Book();

		if(rs != null){
			rs.next();
			b.setId(rs.getInt("id"));
			b.setYear(rs.getInt("anyo"));
			b.setTitle(rs.getString("titulo"));
			b.setIsbn(rs.getString("isbn"));
		
			return b;
		}

        return null;
    }

	public Book searchBook(int id) throws SQLException {
		String query = "SELECT * " + " FROM Libros " + " WHERE id=" + id;
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		Book b = new Book();

		if(rs != null){
			rs.next();
			b.setId(rs.getInt("id"));
			b.setYear(rs.getInt("anyo"));
			b.setTitle(rs.getString("titulo"));
			b.setIsbn(rs.getString("isbn"));
		
			return b;
		}

        return null;
    }

    /**
     * Sell a book.
     *
     * @param book The book.
     * @param units Number of units that are being sold.
     * @return True if the operation succeeds, or false otherwise
     *         (e.g. when the stock of the book is not big enough).
     * @throws SQLException If somthing fails with the DB.
     */
    public boolean sellBook(Book book, int units) throws SQLException {
        return sellBook(book.getId(), units);
    }

    /**
     * Sell a book.
     *
     * @param book The book's identifier.
     * @param units Number of units that are being sold.
     * @return True if the operation succeeds, or false otherwise
     *         (e.g. when the stock of the book is not big enough).
     * @throws SQLException If something fails with the DB.
     */
    public boolean sellBook(int book, int units) throws SQLException {
        // TODO: program this method
		int r;
		String query = "Update Unidades " + " SET unidades=unidades-" + units + " WHERE libro=" + book + " AND unidades>=" + units;
		Statement stmt = connection.createStatement();
		r = stmt.executeUpdate(query);

		if(r>0){
			query = "INSERT INTO Operaciones " + " (fecha, libro, unidades) " + "VALUES (NOW(), " + book + ", " + units + ")" ;
			stmt = connection.createStatement();
			stmt.executeUpdate(query);
			return true;
		}
		
        return false;
    }

    /**
     * Return a list with all the books in the database.
     *
     * @return List with all the books.
     * @throws SQLException If something fails with the DB.
     */
    public List<Book> listBooks() throws SQLException {
		ArrayList l = new ArrayList<Book>();

		String query = "SELECT * " + " FROM Libros";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		Book b;
		
		if(rs != null){
			while(rs.next()){
				b = new Book();
				b.setId(rs.getInt("id"));
				b.setYear(rs.getInt("anyo"));
				b.setTitle(rs.getString("titulo"));
				b.setIsbn(rs.getString("isbn"));
				l.add(b);
			}
		}
		
        return l;
    }
}
