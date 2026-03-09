public class Tarefa {

    private int id;
    private String titulo;
    private String categoria;
    private String status;

    public Tarefa(int id, String titulo, String categoria, String status) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getStatus() {
        return status;
    }
}
