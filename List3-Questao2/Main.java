import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Robo r1 = new Robo();
        String sala[][] = new String[20][40];

        for (int i=0;i<20;i++) {
            for(int j=0;j<40;j++){
                sala[i][j] = " ";
            }
        }

        sala[r1.getLinha()][r1.getColuna()] = "1";

        int escolha;
        do { 
            sala[r1.getLinha()][r1.getColuna()] = "1";
            for (int i=0;i<20;i++) {
                for(int j=0;j<40;j++){
                    System.out.print(sala[i][j]);
                }
                System.out.println("");
            }
            sala[r1.getLinha()][r1.getColuna()] = " ";

            System.out.println("Andar: 1-Frente 2-Tras 3-Direita 4-Esquerda");

            escolha=cin.nextInt();
            cin.nextLine();

            switch (escolha) {
                case 0: break;

                case 1:
                    r1.andarFrente();
                    if (r1.getLinha()>sala.length-1) { //sala[0].length ---> número de colunas !
                        r1.andarTras();
                    }
                    break;
                case 2:
                    r1.andarTras();
                    if (r1.getLinha()<0) { //sala[0].length ---> número de colunas !
                        r1.andarFrente();
                    }
                    break;
                case 3:
                    r1.andarDireita();
                    if (r1.getColuna()>sala[0].length-1) { //sala[0].length ---> número de colunas !
                        r1.andarEsquerda();
                    }
                    break;
                case 4:
                    r1.andarEsquerda();
                    if (r1.getColuna()<0) { //sala[0].length ---> número de colunas !
                        r1.andarDireita();
                    }
                    break;
                default: 
                    System.out.println("Valor invalido, tente novamente ou digite 0 para sair");;
            }

            System.out.println("----------------------------------------------------");

        } while (escolha!=0);

        

    }
}
