package conta_bancaria;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        int opcao;
        
        Conta c1 = new Conta(1, 123, 1, "Cristiano", 5000000);
        c1.visualizar();
        
        //Sacar
        c1.sacar(600000);
        c1.visualizar();
        
        //Depositar
        c1.depositar(1000);
        c1.visualizar();
        
        c1.setTitular("Cristiano Forner");
        c1.visualizar();
        c1.setSaldo(100000);
        c1.visualizar();

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
            System.out.println("║ 9️-  Sair                                                       ║");
            System.out.println("╚════════════════════════════════════════════════════════════════╝");
            System.out.print( Cores.TEXT_RESET + Cores.TEXT_YELLOW_BOLD_BRIGHT + "👉 Escolha uma opção: ");

            opcao = leia.nextInt();

            if (opcao == 9) {
                System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\n🏦 Banco do Brazil com Z - O seu Futuro começa aqui!\n" + Cores.TEXT_RESET);
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n📂 Criar Conta\n");
                    break;
                case 2:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n📋 Listar todas as Contas\n");
                    break;
                case 3:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n🔍 Consultar dados da Conta - por número\n");
                    break;
                case 4:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n✏️ Atualizar dados da Conta\n");
                    break;
                case 5:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n🗑️ Apagar a Conta\n");
                    break;
                case 6:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n💸 Saque\n");
                    break;
                case 7:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n💰 Depósito\n");
                    break;
                case 8:
                    System.out.println(Cores.TEXT_CYAN_BOLD + "\n🔁 Transferência entre Contas\n");
                    break;
                default:
                    System.out.println(Cores.TEXT_RED_BOLD + "\n❌ Opção Inválida!\n" + Cores.TEXT_RESET);
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
}
