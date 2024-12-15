package multiplayer;

public interface Neural {

    public void SetPesos(double x[]);

    public void SetSaidas(double x[]);

    public void SetEntradas(double x[]);

    public void SetDesejados(double x[]);

    public void SetErro(double x[]);

    public void GetPesos();

    public void GetSaidas();

    public void GetEntradas();

    public void GetDesejados();

    public double GetErro();

    public double GetSoma();

    public double GetSigmoid();
}
