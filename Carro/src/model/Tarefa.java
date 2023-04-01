package model;

public class Tarefa {

    private String objetivo;
    private String status;
    private int tempoEmMinutos;
    private Date prazo;

    public Tarefa(String objetivo, String status, int tempoEmMinuto, Date prazo){
        this.objetivo = objetivo;
        this.status = status;
        this.tempoEmMinutos = tempoEmMinutos;
        this.prazo = prazo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTempoEmMinutos() {
        return tempoEmMinutos;
    }

    public void setTempoEmMinutos(int tempoEmMinutos) {
        this.tempoEmMinutos = tempoEmMinutos;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "objetivo='" + objetivo + '\'' +
                ", status='" + status + '\'' +
                ", tempoEmMinutos=" + tempoEmMinutos +
                ", prazo=" + prazo +
                '}';
    }
}
