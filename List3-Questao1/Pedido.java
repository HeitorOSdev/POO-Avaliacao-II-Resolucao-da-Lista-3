
    // - nomeCliente
    // - horaCompra
    // - horaEntrega --- Verificar mudança de dia!!
    // - valorTotal
    // - qDeProduto
    // - endereco
    // - cartao
    // - status;
    // - codigo --- numero sequencial gerado automaticamente


public class Pedido {
    //Atributos
    // private String nomeCliente;
    private String horaCompra;
    private String horaEntrega;
    private float valorTotal;
    private int qDeProduto;
    private String endereco;
    private String cartao;
    private String status;
    private int codigoSequencial;
    private final float valorUnitario = 100.0f;
    private boolean entregaNoDiaSeguinte=false;


    //construtor
    public Pedido(){

    }
    
    //getters
    // public String getNomeCliente(){
    //     return nomeCliente;
    // }
    public String getHoraCompra(){
        String[] partesHorario = horaCompra.split("/");
        // String horaCompraStringCorrigida = partesHorario[0]+":"+partesHorario[1] ;
        return partesHorario[0]+":"+partesHorario[1];
    }
    public String getHoraEntrega(){
        return horaEntrega;
    }
    public float getValorTotal(){
        return valorTotal;
    }
    public int getQDeProduto(){
        return qDeProduto;
    }
    public String getEndereco(){
        return endereco;
    }
    public String getCartao(){
        return cartao;
    }
    public String getStatus(){
        return status;
    }
    public int getCodigoSequencial(){
        return codigoSequencial;
    }
    public boolean getEntregaNoDiaSeguinte(){
        return entregaNoDiaSeguinte;
    }


    //setters
    // public void setNomeCliente(String nomeCliente){
    //     this.nomeCliente = nomeCliente;
    // }
    public void setHoraCompra(String horaCompra){

        this.horaCompra = horaCompra;
        
        String[] partesHorario = horaCompra.split("/");
        int horas = Integer.parseInt(partesHorario[0]);

        int horaEntregaInt;
        if (horas+6 >= 24) {
            entregaNoDiaSeguinte = true;
            horaEntregaInt=24-(horas+6);
            if(horaEntregaInt<0){
                horaEntregaInt=horaEntregaInt*-1;
            }

        }else{
            horaEntregaInt = horas+6;
        }

        horaEntrega = horaEntregaInt + ":" + partesHorario[1] + "h";

    }
    public void setHoraEntrega(String horaEntrega){
        this.horaEntrega = horaEntrega;   
    }
    // public void setValorTotal(float valorTotal){
    //     this.valorTotal = valorTotal;    
    // }
    public void setQDeProduto(int qDeProduto){
        this.qDeProduto = qDeProduto;
        valorTotal = qDeProduto*valorUnitario;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;    
    }
    public void setCartao(String cartao){
        this.cartao = cartao;    
    }
    public void setStatus(String status){
        this.status = status;    
    }
    public void setCodigoSequencial(int codigoSequencial){
        this.codigoSequencial = codigoSequencial;    
    }
    
    //método exibirDadosPedido()
    public void exibirDadosPedido(){
        // System.out.println("Nome do cliente: " + nomeCliente);
        System.out.println("Hora de compra: " + getHoraCompra());
        System.out.println("Hora prevista da entrega: " + horaEntrega);
        System.out.println("Valor total da compra: " + valorTotal);
        System.out.println("Butijoes pedidos: " + qDeProduto);
        System.out.println("Endereco: " + endereco);
        System.out.println("Cartao: " + cartao);
        System.out.println("Status: " + status);
        System.out.println("Codigo sequencial: " + codigoSequencial);
        System.out.println("Valor unitario: " + valorUnitario);
        if(entregaNoDiaSeguinte){
            System.out.println("Entrega apenas no dia seguinte");
        }else{
            System.out.println("Entrega apenas no mesmo dia");
        }
    }

    //Outro métodos

    // public void calcularTotal(int qBotijoes){ //Deixei acoplado no método setQDeProduto
    //     valorTotal = qBotijoes*valorUnitario;
    // }

    // public void calcularHoraEntrega(){ //acoplado no setHoraCompra
        
    //     String[] partesHorario = horaCompra.split("/");
    //     int horas = Integer.parseInt(partesHorario[0]);

    //     if (horas+6 >= 24) {
    //         entregaNoDiaSeguinte = true;
    //         horaEntrega=24-(horas+6);

    //     }else{
    //         horaEntrega = horas+6;
    //     }

        
    // }

}
