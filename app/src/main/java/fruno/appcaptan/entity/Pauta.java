package fruno.appcaptan.entity;

public class Pauta {
    private String titulo;
    private String breveDescricao;
    private String descricao;
    private String autor;
    private String status;

    private boolean selecionado = false;

    public Pauta(String titulo, String breveDescricao, String descricao, String autor, String status) {
        this.titulo = titulo;
        this.breveDescricao = breveDescricao;
        this.descricao = descricao;
        this.autor = autor;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBreveDescricao() {
        return breveDescricao;
    }

    public void setBreveDescricao(String breveDescricao) {
        this.breveDescricao = breveDescricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }
}
