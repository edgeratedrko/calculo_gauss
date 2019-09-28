package com.company.Controller;

public class Gauss {
    double[][] matriz;
    double mult[] = new double[9];
    double resposta[] = {1,1,1,1,1,1,1,1,1,1};
    int k = 0;

    public Gauss(double gauss[][]){
        this.matriz = gauss;
    }

    public double[][] getMatriz() {
        return matriz;
    }

    public void iteração(){
        acharM();
        calculo();
        this.k++;
    }

    public void acharM(){
        double dividendo = matriz[k][k];
        for(int x = 1; x<mult.length;x++){
            if(dividendo == 0){dividendo = 1;}
            mult[x-1]= matriz[x][k]/dividendo;
        }
    }

    public double[] getMult(){
        return mult;
    }

    public void calculo(){
        for(int x = k+1; x < matriz.length; x++){
            double mul = mult[x-1];
            for(int y = k; y < matriz[0].length; y++){
                double novo = matriz[x][y] - mul*matriz[k][y];
                matriz[x][y] = novo;
            }
        }
    }

    public void valorX(){
        double controle = 0;
        for(int x = 9; x > 0; x--){
            for(int y = 9; y >= x; y--){
                controle = matriz[x][y] * (matriz[11][y] - resposta[y]);
                resposta[y] = controle;
            }
        }
    }

    public String retorno(){
        int cont = 0;
        String saida = "";

        for(int z = 0; z < matriz.length; z++) {
            if (cont > 0) {
                iteração();
            }
            boolean vazia = true;
            for (int x = 0; x < matriz.length - 1; x++) {
                for (int y = 0; y < (matriz[0].length - 1); y++) {
                    if (matriz[x][y] != 0) {
                        saida += "(" + (Double) matriz[x][y] + "*X" + (y + 1) + ") + ";
                    }
                    if (matriz[x][y] != 0) {
                        vazia = false;
                    }
                }
                if (!vazia) {
                    saida = saida.substring(0, saida.length() - 2);
                    saida += "= " + matriz[x][matriz[0].length - 1];
                    saida += '\n';
                    vazia = true;
                }
            }
            saida += '\n';
            cont++;
        }
        return saida;
    }
}

