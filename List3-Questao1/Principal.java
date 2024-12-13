import java.text.SimpleDateFormat;
import java.util.*; //Array, ArrayList, Collections

class Principal{
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Date dataHoraAtual = new Date();
        // String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        // String hora = new SimpleDateFormat("HH/mm/ss").format(dataHoraAtual); ---> Instanciar na hora de guardar !!
        ArrayList <Pedido> listaPedidos = new ArrayList<Pedido>();

        int escolha;
        int escolhaAuxiliar;
        int pesquisa;
        int qBotijoes;
        int sequencial=0;
        int qEncontrados;
        boolean encontrou;
        do { 
            //Implementar um MENU !! =TOP=
            System.out.println("-------------------------------------");
            System.out.println("1-Fazer Pedido");
            System.out.println("2-Confirmar Entrega");
            System.out.println("3-Ver Pedidos Confirmados"); //Pedidos em aberto (não entregues)
            System.out.println("4-Ver Pedidos Entregues"); //Pedidos já atendidos (já entregues)
            System.out.println("5-Exibir Todos os Dados de um Pedido"); //Opcional para a questão
            System.out.println("6-Sair");
            System.out.println("-------------------------------------");

            escolha=cin.nextInt();
            cin.nextLine(); //Guarda o Enter que sobra na leitura anterior, que espera mas não guarda o "\n", mas sim apenas valores inteiros 

            switch(escolha){
                case 1:

                    //Instancia um novo pedido e a hora atual do pedido
                    Pedido p = new Pedido();
                    String hora = new SimpleDateFormat("HH/mm/ss").format(dataHoraAtual);
                    //Preenche os dados do novo Pedido
                    p.setHoraCompra(hora);
                    System.out.print("Digite o endereco de entrega: ");
                    p.setEndereco(cin.nextLine());
                    
                    //Pedir para escolher entre alterar e confirmar
                    do { 
                        System.out.println("");
                        System.out.println("Endereco do pedido atual: ");
                        System.out.println(p.getEndereco());
                        System.out.println("1-Alterar Endereco/2-Continuar");
                        escolhaAuxiliar=cin.nextInt();
                        cin.nextLine(); //Guarda o Enter
                        if (escolhaAuxiliar==1) {
                            System.out.println("Alterando endereco do pedido atual...");
                            System.out.print("Digite o novo endereco: ");
                            p.setEndereco(cin.nextLine());
                        }else{
                            if(escolhaAuxiliar!=2) System.out.println("Opcao inexistente, tente novamente");
                        }
                        
                    } while (escolhaAuxiliar !=2);

                   

                    //2-confirmar -> exibir o valor unitário do botijão, exigir quantidade de botijões requeridos e guardar a qProduto
                    System.out.println("");
                    System.out.println("O valor atual do botijao de gas eh de 100 reais");
                    System.out.print("Digite a quantidade de botijoes desejados para este pedido: ");
                    qBotijoes=cin.nextInt();
                    cin.nextLine();

                    // guarda o total de produtos pedidos e já calcula o total da compra e insere no pedido
                    p.setQDeProduto(qBotijoes);

                    //Informar se será hoje ou no dia seguinte e o horário previsto para entrega
                    if(p.getEntregaNoDiaSeguinte()){
                        System.out.print("A entrega sera realizada AMANHA ate as ");
                    }else{
                        System.out.print("A entrega sera realizada hoje ate as ");
                    }
                    System.out.println(p.getHoraEntrega());
                    

                    // solicitar e guardar número de um cartão de crédito -> Após isso, altera status do pedido para "confirmado" e exibe o código do pedido
                    System.out.print("Digite o numero do cartao de credito para realizar o pagamento: ");
                    p.setCartao(cin.nextLine());
                    p.setStatus("confirmado");
                    sequencial++;
                    p.setCodigoSequencial(sequencial);

                     //Após setar TODOS os atributos, o Pedido p é guardado na ArrayList de Pedido.
                    listaPedidos.add(p);
                    break;
                case 2:

                    System.out.print("Digite o codigo do pedido que deseja confirmar a entrega: ");
                    pesquisa = cin.nextInt();
                    cin.nextLine();//guarda o Enter

                    encontrou = false;
                    for(int i=0;i<listaPedidos.size();i++){
                        if(listaPedidos.get(i).getCodigoSequencial() == pesquisa){

                            encontrou = true;
                            listaPedidos.get(i).setStatus("entregue");
                            i=listaPedidos.size(); //Força a sair do for caso o Pedido desejado já tenha sido encontrado
                        
                        }
                    }

                    if(!encontrou)System.out.println("Pedido NAO localizado");
                    break;
                case 3: //Ver pedidos confirmados

                    System.out.println("Exibindo pedidos confirmados:");
                    qEncontrados = 0;
                    System.out.println("-----------------------");
                    for(int i=0;i<listaPedidos.size();i++){
                        if(listaPedidos.get(i).getStatus() == "confirmado" ){

                            qEncontrados++;
                            System.out.println("Pedido de codigo - " + listaPedidos.get(i).getCodigoSequencial());

                        }
                    }
                    System.out.println("-----------------------");
                    if(qEncontrados>0){
                        System.out.println("Temos no total "+qEncontrados+" pedidos confirmados.");
                    }else{
                        System.out.println("NAO ha nenhum pedido com status de confirmado.");
                    }
                    
                    
                    break;
                case 4: //ver pedidos entregues

                    System.out.println("Exibindo pedidos entregues:");
                    qEncontrados = 0;
                    System.out.println("-----------------------");
                    for(int i=0;i<listaPedidos.size();i++){
                        if(listaPedidos.get(i).getStatus() == "entregue" ){

                            qEncontrados++;
                            System.out.println("Pedido de codigo - " + listaPedidos.get(i).getCodigoSequencial());

                        }
                    }
                    System.out.println("-----------------------");
                    if(qEncontrados>0){
                        System.out.println("Temos no total "+qEncontrados+" pedidos entregues.");
                    }else{
                        System.out.println("NAO ha nenhum pedido entregue.");
                    }
                    
                    break;
                case 5: //ver todos os dados de um pedido (pesquisar através do código)
                    System.out.print("Codigo do pedido do qual se deseja exibir os dados: ");
                    pesquisa = cin.nextInt();
                    cin.nextLine();//guarda o Enter

                    encontrou = false;
                    for(int i=0;i<listaPedidos.size();i++){
                        if(listaPedidos.get(i).getCodigoSequencial() == pesquisa){

                            encontrou = true;

                            listaPedidos.get(i).exibirDadosPedido();

                            i=listaPedidos.size(); //Força a sair do for caso o Pedido desejado já tenha sido encontrado
                        
                        }
                    }
                    if(!encontrou)System.out.println("Pedido NAO localizado");
                    break;

                case 6: break;
                default:
                    System.out.println("Entrada inválida, tente novamente");

            }
            if(escolha!=6){
                System.out.println("Pressione Enter para continuar");
                cin.nextLine();
            }
            
        } while (escolha!=6);

        System.out.println("Programa finalizado com sucesso");

    }
}