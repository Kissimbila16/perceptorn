package multiplayer;

import java.lang.Math;

public class Teste {
    private int relu(double y) {
        if (y > 0)
            return 1;
        else
            return 0;
    }

    private double GetSigmoid(double y) {
        return 1 / (1 + Math.exp(y));
    }

    public void start() {
        double x[] = new double[2];
        double xw[] = new double[2];
        double o[] = new double[2];
        double ow[] = new double[2];
        double y[] = new double[2];
        double yw[] = new double[2];
        double e[] = new double[2];
        double d[] = new double[2];
        double u[] = new double[x.length * o.length];
        double f = 0.001;
        double bw = 0.5;
        double b = 1;
        int t = 0;
        double erroMedio = 0;
        double erroTotal = 0;
        double DerivadoErro = 0;

        for (int i = 0; i < x.length; i++) {
            x[i] = -0.2;
            xw[i] = 0.4;
            o[i] = -0.4;
            ow[i] = 0;
            y[i] = 0;
            yw[i] = 0;
            e[i] = 0;
        }
        d[0] = 0.2;
        d[1] = 0.6;

        for (int i = 0; i < u.length; i++) {
            u[i] = 0;
        }

        for (int i = 0; i < x.length; i++) {
            u[0] = x[i] * xw[i];
            y[0] = this.relu(u[0]);
        }

        // recebeu do codigo anterior a este ,camada oculta
        for (int i = 0; i < x.length; i++) {
            u[1] = y[0] * ow[i];
            y[1] = this.relu(u[1]);
        }

        for (int i = 0; i < e.length; i++) {
            e[i] = (d[i] - y[i]) * (d[i] - y[i]);
        }

        for (int i = 0; i < x.length; i++) {
            if (y[i] != d[i]) {
                xw[i] += (f * e[i] + x[i]) + (bw + b);
                ow[i] += (f * e[i] + o[i]) + (bw + b);
                bw += (f * e[i] + b);
            } else {
                break;
            }
        }

        t++;
        System.out.println("\n ----Epocas de Treinamento----:" + t);

        for (int i = 0; i < y.length; i++) {
            System.out.println("Entradas:" + x[i]);
        }
        for (int i = 0; i < y.length; i++) {
            System.out.println("Desejados:" + d[i]);
        }

        for (int i = 0; i < y.length; i++) {
            System.out.println("Ocultas:" + o[i]);
        }

        for (int i = 0; i < y.length; i++) {
            System.out.println("Peso da Entrada:" + xw[i]);
        }

        for (int i = 0; i < y.length; i++) {
            System.out.println("Peso da Oculta:" + ow[i]);
        }

        for (int i = 0; i < y.length; i++) {
            System.out.println("Erros:" + e[i]);
        }

        for (int i = 0; i < y.length; i++) {
            System.out.println("Erro medio:" + erroMedio);
        }

        for (int i = 0; i < y.length; i++) {
            System.out.println("Saida:" + y[i]);
        }

        System.out.println();

    }
}
