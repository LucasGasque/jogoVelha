import java.util.Scanner;

public class App {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);

        JogoVelha jogovelha = new JogoVelha();

        System.out.println("Jogador 1 = X");
        System.out.println("Jogador 2 = O");

        boolean ganhou = false;
        char sinal; 
        int linha = 0, coluna = 0;

        while(!ganhou){

            if (jogovelha.vezJogador1()){

                System.out.println("Vez do jogador 1. Escolha linha e coluna (1-3).");
                sinal = 'X';
            } else {

                System.out.println("Vez do jogador 2. Escolha linha e coluna (1-3).");                
                sinal = 'O';
            }                    
            
            linha = valor("Linha", scan);
            coluna = valor("Coluna", scan);

            jogovelha.validarJogada(linha, coluna, sinal);
            
            jogovelha.imprimirTabuleiro();

            if(jogovelha.verificarGanhador('X')){
                ganhou = true;
                System.out.println("Parabéns, jogador 1 ganhou!");
            } else if(jogovelha.verificarGanhador('O')){
                ganhou = true;
                System.out.println("Parabéns, jogador 2 ganhou!");
            } else if (jogovelha.jogada>9){
                ganhou = true;
                System.out.println("ninguém ganhou essa partida!");
            }

                    
        }    
    }

    static int valor(String tipoValor, Scanner scan){
        int valor = 0;
        boolean valorValida = false;
            while(!valorValida){
                System.out.println("Entre com a "+ tipoValor +" (1, 2 ou 3)");
                valor = scan.nextInt();
                if (valor >= 1 && valor <=3){
                    valorValida = true;
                } else {
                    System.out.println("Entrada inválida, tente novamente");
                }
            }
        valor --;
        return valor;    
    } 

}


