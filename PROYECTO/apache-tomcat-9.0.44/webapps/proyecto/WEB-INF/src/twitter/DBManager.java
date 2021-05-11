package twitter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.naming.NamingException;
import javax.naming.InitialContext;
import javax.naming.Context;

import javax.sql.DataSource;

import twitter.Tweet;


public class DBManager implements AutoCloseable {

    private Connection connection;

    public DBManager() throws SQLException, NamingException {
		connect();
	}

    private void connect() throws SQLException, NamingException {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/Twitter");
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

	public List<Tweet> getProfileTweet(int user) throws SQLException{

		ArrayList l = new ArrayList<Tweet>();
		PreparedStatement query = connection.prepareStatement("SELECT Mensajes.id, autor, mensaje, fecha, login, responde_a, es_retweet FROM Mensajes INNER JOIN Usuarios ON Mensajes.autor=Usuarios.id WHERE autor = ? ORDER BY fecha DESC" );
		query.setInt(1, user);
		ResultSet rs = query.executeQuery();
		Tweet t;
		

		while(rs.next()){
			t = new Tweet();
			t.setAutor(rs.getInt("autor"));
			t.setAutor_name(rs.getString("login"));
			t.setMensaje(rs.getString("mensaje"));
			t.setDatetime(rs.getTimestamp("fecha"));
			t.setResponde_a(rs.getInt("responde_a"));
			t.setEs_retweet(rs.getInt("es_retweet"));
			t.setId(rs.getInt("id"));

			l.add(t);
		}
		
        return l;

	}

	public boolean checkCredentials(String user, String pass) throws SQLException{

		PreparedStatement query = connection.prepareStatement("SELECT * FROM Usuarios WHERE login = ?" );
		query.setString(1, user);
		ResultSet rs = query.executeQuery();
		String true_pwd = "";


		if(rs.next()){
			true_pwd = rs.getString("password");
		}else{
			return false;		
		}
		
		return pass.equals(true_pwd);

	}


	public List<String> getProfile(String login) throws SQLException{

		
		List<String> info = new ArrayList<String>();
		PreparedStatement query = connection.prepareStatement("SELECT * FROM Usuarios WHERE login = ?" );
		query.setString(1, login);
		ResultSet rs = query.executeQuery();
		


		if(rs.next()){
			info.add(String.valueOf(rs.getInt("id")));
			info.add(rs.getString("login"));
			info.add(rs.getString("nombre"));
			info.add(rs.getString("bio"));
		}else{
			return null;		
		}
		
		return info;

	}


	public List<Tweet> getAnswers(int id) throws SQLException{ //MOSTRAR CONVERSACIÓN, CUANDO RESPUESTA_A != 0, ID=RESPUESTA_A

		ArrayList l = new ArrayList<Tweet>();

		PreparedStatement query = connection.prepareStatement("SELECT * FROM Mensajes WHERE responde_a = ?" );
		query.setInt(1, id);
		ResultSet rs = query.executeQuery();
		Tweet t;
		

		while(rs.next()){
			t = new Tweet();
			t.setAutor(rs.getInt("autor"));
			t.setMensaje(rs.getString("mensaje"));
			t.setDatetime(rs.getTimestamp("fecha"));
			t.setResponde_a(rs.getInt("responde_a"));
			t.setEs_retweet(rs.getInt("es_retweet"));
			t.setId(rs.getInt("id"));

			l.add(t);
		}
		
        return l;

	}

	public boolean usernameAvailable(String user) throws SQLException{

		PreparedStatement query = connection.prepareStatement("SELECT * FROM Usuarios WHERE login = ?" );
		query.setString(1, user);
		ResultSet rs = query.executeQuery();

		if(rs.next())
			return false;
		
		return true;

	}

	public boolean newUser(String user, String password, String nombre, String correo, String bio) throws SQLException{

		if(usernameAvailable(user) && (user.length() < 255) && (password.length() < 255) && (nombre.length() < 255) && (correo.length() < 255) && (bio.length() < 255)){

			PreparedStatement query = connection.prepareStatement("INSERT INTO Usuarios (login, password, nombre, correo, bio) VALUES(?, ?, ?, ?, ?)" );
			query.setString(1, user);
			query.setString(2, password);
			query.setString(3, nombre);
			query.setString(4, correo);
			query.setString(5, bio);
			query.executeUpdate();

			return true;
	
		}
	
		return false;
	}


	public boolean publicarTweet(int autor, String mensaje, int responde_a, int es_retweet) throws SQLException{

		if(mensaje.length() <= 255){

			PreparedStatement query = connection.prepareStatement("INSERT INTO Mensajes (autor, mensaje, fecha, responde_a, es_retweet) VALUES(?, ?, NOW(), ?, ?)" );
			query.setInt(1, autor);
			query.setString(2, mensaje);
			query.setInt(4, responde_a);
			query.setInt(5, es_retweet);
			query.executeUpdate();

			return true;
	
		}
	
		return false;
	}

	


	public List<Tweet> timeline(int idUser) throws SQLException{

		ArrayList l = new ArrayList<Tweet>();

		PreparedStatement query = connection.prepareStatement("SELECT Mensajes.id, Mensajes.autor, Mensajes.mensaje, Mensajes.fecha, Mensajes.responde_a, Mensajes.es_retweet" +
				"From Mensajes INNER JOIN Seguimientos ON Mensajes.autor=Seguimientos.id_seguido WHERE Seguimientos.id_seguidor= ? ORDER BY Mensajes.fecha DESC LIMIT 50" );
		query.setInt(1, idUser);
		ResultSet rs = query.executeQuery();
		Tweet t;
		

		while(rs.next()){
			t = new Tweet();
			t.setAutor(rs.getInt("autor"));
			t.setMensaje(rs.getString("mensaje"));
			t.setDatetime(rs.getTimestamp("fecha"));
			t.setResponde_a(rs.getInt("responde_a"));
			t.setEs_retweet(rs.getInt("es_retweet"));
			t.setId(rs.getInt("id"));

			l.add(t);
		}
		
        return l;

	}

	public void follow(int id_seguidor, int id_seguido) throws SQLException{

		PreparedStatement query = connection.prepareStatement("INSERT INTO Seguimientos (id_seguidor, id_seguido) VALUES(?, ?)" );
		query.setInt(1, id_seguidor);
		query.setInt(2, id_seguido);
		query.executeUpdate();

	}

	public void unfollow(int id_seguidor, int id_seguido) throws SQLException{

		PreparedStatement query = connection.prepareStatement("DELETE FROM Seguimientos WHERE id_seguidor=? AND id_seguido=?" );
		query.setInt(1, id_seguidor);
		query.setInt(2, id_seguido);
		ResultSet rs = query.executeQuery();

	}

}
