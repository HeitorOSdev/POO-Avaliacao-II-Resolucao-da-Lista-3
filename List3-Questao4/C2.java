public class C2 extends C1 { //Pessoa física
    private String cpf;
    private String clt;
    private String dataNascimento;

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getCpf(){
        return cpf;
    }
    public void setClt(String clt){
        this.clt = clt;
    }
    public String getClt(){
        return clt;
    }
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public String getDataNascimento(){
        return dataNascimento;
    }

    public void futuroProfissional(int escolha){
        switch () {
            case 1:
                System.out.println("Quero ser empresario!!!");
                break;
            case 2:
                System.out.println("Quero ser medico!!");
                break;
            case 3:
                System.out.println("Quero ser do TADS e serei um dev !! Cadê meu home office !?");
                
                break;
            case 4:  
                System.out.println("Estou tranquilo do jeito que estou, nao sonho em ter nada a mais");
                break;
                
            default:
                System.out.println("Escolha invalida");
        }
    }
}