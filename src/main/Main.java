package main;

import menu.Menu;
import user.UserController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        UserController userController = new UserController();
        boolean loopOn = true;
        while (loopOn){
            menu.limparConsole();
            menu.printMenuPrincipal();
            switch (scanner.nextInt()){
                case 1:
                    System.out.println("Entrando na conta");
                    break;
                case 2:
                    menu.printConfirmação("a função criar conta");
                    if (scanner.nextInt() == 1){
                        System.out.print("Digite seu nome: ");
                        String nome = scanner.next();
                        scanner.next();
                        System.out.print("Digite sua agencia: ");
                        String agencia = scanner.next();
                        scanner.next();
                        System.out.print("Digite seu cpf: ");
                        String cpf = scanner.next();
                        scanner.next();
                        System.out.print("Digite sua data de nascimento: ");
                        String dataNasc = scanner.next();
                        scanner.next();
                        userController.criarUser(nome, agencia, cpf, dataNasc);
                    } else {
                        System.out.println("voltando para o menu...");
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    loopOn = false;
                    break;
                default:
                    System.out.println("Entrada invalida, escolha uma opção valida");
                    break;
            }
        }
    }
}
