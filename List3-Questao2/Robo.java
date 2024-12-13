public class Robo {
    private int linha;
    private int coluna;
    private int passo;

    Robo(){
        linha=0;
        coluna=0;
        passo=1;
    }

    public int getLinha(){
        return linha;
    }
    public int getColuna(){
        return coluna;
    }

    public void mostrarPosicaoAtual(){
        System.out.println("Posicao atual do robo:");
        System.out.println("Linha " + linha);
        System.out.println("Coluna " + coluna);
    } 
    public void andarFrente(){
        linha = linha+passo;
    } 
    public void andarTras(){
        linha = linha-passo;
    } 
    public void andarDireita(){
        coluna = coluna+passo;
    } 
    public void andarEsquerda(){
        coluna = coluna-passo;
    }  
}
