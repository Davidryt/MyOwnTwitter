package twitter;
import java.util.Date;

public class Tweet {
	private int autor;
	private String autor_name;
	private String mensaje;
	private Date datetime;
	private int responde_a;
	private int es_retweet;
	private int id;

	public int getAutor() {
		return autor;
	}

	public void setAutor(int autor) {
		this.autor = autor;
	}

	public String getAutor_name() {
		return autor_name;
	}

	public void setAutor_name(String autor_name) {
		this.autor_name = autor_name;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date datetime() {
		return datetime;
	}

	public void setDatetime(Date d) {
		this.datetime = d;
	}

	public int getResponde_a() {
		return responde_a;
	}

	public void setResponde_a(int r) {
		this.responde_a = r;
	}

	public int getEs_retweet() {
		return es_retweet;
	}

	public void setEs_retweet(int e) {
		this.es_retweet= e;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		//DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		return "";
	}
}
