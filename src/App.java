public class App {

    
    public static void main(String[] args) throws Exception {
      Central cen = new Central();
     cen.SetActualizacao(0.54);
      double x[] = new double[3];
      double w[] = new double[3];
      x[0]=0.0; 
      x[1]=0.255; 
      x[2]=0.255; 
      cen.SetEntradas(x); // verde escuro na cor do verde claro
     
      cen.SetDesejado(0.7); //cor preta
      w[0]=-0.0; 
      w[1]=0.2; 
      w[2]=-0.5; 
      cen.Setpesos(w);
      cen.SetEntradasBias(1);
      cen.SetBiaspesos(0.2);

     for (int i=0;i<500;i++) {
         cen.SetSaida(cen.Sigmoid(cen.Soma()));
      System.out.println("\n ---EPOCA: "+i+"---\n");
      cen.GetEntradas();
      cen.Getdesejado();
      cen.Getpeso();
      System.out.println("Erro:" + cen.GetErro());
      cen.Getsaida();
      cen.backprogation();   
}
      cen.Classificacao();
    }
}
