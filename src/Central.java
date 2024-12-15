import java.lang.Math;

public class Central {

    private double y = 0;
    private double w[];
    private double x[];
    private double bw = 0;
    private double bx = 0;
    private double d = 0;
    private double f;
    private double e = 0;
    private double u = 0;
    private int t = 0;

    public Central() {
        this.w = new double[3];
        this.x = new double[3];
    }

    public void SetDesejado(double d) {
        this.d = d;
    }

    public void Setpesos(double w[]) {
        for (int i = 0; i < x.length; i++) {
            this.w[i] = w[i];
        }
    }

    public void SetBiaspesos(double bw) {
        this.bw = bw;
    }

    public void SetActualizacao(double f) {
        this.f = f;
    }

    public void SetEntradas(double x[]) {
        for (int i = 0; i < x.length; i++) {
            this.x[i] = x[i];
        }

    }

    public void SetSaida(double y) {
        this.y = y;
    }

    public void SetEntradasBias(double bx) {
        this.bx = bx;
    }

    public void Getpeso() {
        for (int i = 0; i < this.x.length; i++) {
            System.out.println("Pesos:" + w[i]);
        }
    }

    public void Getsaida() {
       
        System.out.println("Saida:" + this.y);
    }

    public void Getdesejado() {
        System.out.println("Desejados:" + this.d);
    }

    public void GetEntradas() {
        for (int i = 0; i < this.x.length; i++) {
            System.out.println("Entradas:" + x[i]);
        }
    }

    public double GetErro() {
        double erroMedio = 0;
        this.e = this.d - this.y;
        return this.e;
    }

    public double Sigmoid(double value) {
        int val = 0;
        return (1 / (1 + Math.exp(-value)));
    }

    public void backprogation() {

        for (int i = 0; i < x.length; i++) {
            if (this.e != this.d) {
                w[i] += (this.f * this.x[i] * this.e);
            } else {
                break;
            }
        }

        System.out.println("Pesos Actualizados");
    }

    public double Soma() {
        // pra fazer soma total double somaTotal=0;
        if (this.e != this.d) {
            for (int x = 0; x < this.x.length; x++) {
                this.u = (this.w[x] * this.x[x]);
            }
        }
        return this.u;
    }

    public void Classificacao() {
        for (int i = 0; i < this.x.length; i++) {
            if (Math.round(this.y) == d) {
                System.out.println("Gerou a cor preta ");
            } else {
                System.out.println("Gerou a cor verde");
            }
        }
    }

    public int setEpocas(int i) {
        return this.t;
    }

    public int GetEpocas() {
        return this.t++;
    }
}
