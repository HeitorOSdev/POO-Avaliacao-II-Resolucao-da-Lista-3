public abstract class C1 {
    private String nome;
    private int idade;
    private String endereco;

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return idade;
    }

    public void souPropriedade(boolean resposta){
        if (resposta) {
            System.out.println("Sou uma propriedade de alguém");
        }else{
            System.out.println("NAO, eu sou proprietario");
        }
    }
}
