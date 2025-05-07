package conta_bancaria;

import java.io.IOException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        
        ContaController contas = new ContaController();
               
        int opcao, numero, agencia, tipo, aniversario;
        String titular;
        float saldo, limite;
        
        //Dados para teste
        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);

		contas.cadastrar(cc1);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);

		contas.cadastrar(cp1);
 
        

        while (true) {
            System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
            System.out.println("╔════════════════════════════════════════════════════════════════╗");
            System.out.println("║                     BANCO DO BRAZIL COM Z                      ║");
            System.out.println("╠════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1️-  Criar Conta                                                ║");
            System.out.println("║ 2️-  Listar todas as Contas                                     ║");
            System.out.println("║ 3️-  Buscar Conta por Número                                    ║");
            System.out.println("║ 4️-  Atualizar Dados da Conta                                   ║");
            System.out.println("║ 5️-  Apagar Conta                                               ║");
            System.out.println("║ 6️-  Sacar                                                      ║");
            System.out.println("║ 7️-  Depositar                                                  ║");
            System.out.println("║ 8️-  Transferir valores entre Contas                            ║");
            System.out.println("║ 9️-  Listar Contas Por Titular                                  ║");
            System.out.println("║ 0-  Sair                                                       ║");
            System.out.println("╚════════════════════════════════════════════════════════════════╝");
            System.out.print( Cores.TEXT_RESET + Cores.TEXT_YELLOW_BOLD_BRIGHT + "👉 Escolha uma opção: ");

            opcao = leia.nextInt();

            if (opcao == 0) {
                System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\n🏦 Banco do Brazil com Z - O seu Futuro começa aqui!\n" + Cores.TEXT_RESET);
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n📂 Criar Conta\n");
                    
                    System.out.println("Digite o número da Agência:");
                    agencia = leia.nextInt();
                    
                    System.out.println("Digite o nome do Titular:");
                    leia.skip("\\R");
                    titular = leia.nextLine();
                    
                    System.out.println("Digite o tipo de Conta ( 1- CC | 2- CP)"
                    		+ ":");
                    tipo = leia.nextInt();
                    
                    System.out.println("Digite o Saldo Inicial da conta:");
                    saldo = leia.nextFloat();
                    
                    switch (tipo) {
                    
                    case 1 -> {
                    			System.out.println("Digite o limite da conta:");
                    			limite = leia.nextFloat();
                    			contas.cadastrar(new ContaCorrente(contas.gerarNumero(), 
                    								agencia, tipo, titular, saldo, limite ));
                    	}
                    case 2 -> {
            					System.out.println("Digite o dia do aniversário da conta:");
            					aniversario = leia.nextInt();
            					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), 
            										agencia, tipo, titular, saldo, aniversario ));
            	}
                    }
                    
                    keyPress();
                    break;
                
                case 2:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n📋 Listar todas as Contas\n");
                    contas.listarTodas();
                    keyPress();
                    break;
                
                case 3:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n🔍 Consultar dados da Conta - por número\n");
                    System.out.println("Digite o número da conta:");
                    numero = leia.nextInt();
                    
                    contas.procurarPorNumero(numero);
                    
                    keyPress();
                    break;
                case 4:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n✏️ Atualizar dados da Conta\n");
                    keyPress();
                    break;
                case 5:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n🗑️ Apagar a Conta\n");
                    keyPress();
                    break;
                case 6:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n💸 Saque\n");
                    keyPress();
                    break;
                case 7:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n💰 Depósito\n");
                    keyPress();
                    break;
                case 8:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n🔁 Transferência entre Contas\n");
                    keyPress();
                    break;
                case 9: 
                	System.out.println(Cores.TEXT_CYAN_BOLD + "\n🔍Consultar Contas por Titular\n");
                	
                	System.out.println("\nDigite o nome do Titular:\n");
                	leia.skip("\\R");
                	titular= leia.nextLine();
                	
                	contas.listarPorTitular(titular);
                	
                	keyPress();
                	break;
                default:
                    System.out.println(Cores.TEXT_RED_BOLD + "\n❌ Opção Inválida!\n" + Cores.TEXT_RESET);
                    keyPress();
                    break;
            }
        }
    }

    public static void sobre() {
        System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\n==================================================================");
        System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT +"👨‍💻 Projeto Desenvolvido por: Cristiano Forner");
        System.out.println("📧 Email: cristianosampaio1996@gmail.com");
        System.out.println("🔗 GitHub: https://github.com/cristianoforner" + Cores.TEXT_RESET);
        System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT +"==================================================================" + Cores.TEXT_RESET);
    }
    
    	public static void keyPress() {
    	 
		try {
 
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
 
		} catch (IOException e) {
 
			System.err.println("Ocorreu um erro ao tentar ler o teclado");
 
		}
	}
}
