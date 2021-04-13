package twitter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

public class Tweet {
	private String autor;
	private String mensaje;
	private LocalDateTime datetime;
	private int responde_a;
	private int es_retweet;
	private int id;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getMensaje) {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime datetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime d) {
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
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		return autor + ": " + mensaje + " (" + dt.format(datetime) + ")";
	}
}
