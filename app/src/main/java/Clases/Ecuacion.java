package Clases;

public class Ecuacion {

    private int x;
    private int y;

    public Ecuacion(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int x()
    {
        return x;
    }
    public int y()
    {
        return y;
    }

    public String Resultado()
    {
        int resultado;
        resultado=x*y;
        String resultadoFinal = String.valueOf(resultado);
        return resultadoFinal;
    }
}
