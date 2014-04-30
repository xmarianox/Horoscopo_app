package la.funka.apphoroscopo;

public abstract class Signo {

    private String nombreSigno;

    public String getNombreSigno() {
        return nombreSigno;
    }

    public void setNombreSigno(String nombreSigno) {
        this.nombreSigno = nombreSigno;
    }

    // Construcctor del Objeto Signo.
    public Signo(String nombreSigno) {
        this.nombreSigno = nombreSigno;
    }

    // Construcctor del Objeto Signo.
    public Signo() {

    }

    public abstract int setUrlIcon(String nombreSigno);

    public abstract int prediccionAmor(String nombreSigno);

    public abstract int prediccionSalud(String nombreSigno);

    public abstract int prediccionDinero(String nombreSigno);

}
