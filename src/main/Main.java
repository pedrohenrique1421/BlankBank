package main;

import menu.Menu;
import objRetorno.ObjRetorno;
import user.UserController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        UserController userController = new UserController();
        boolean loopOn = true;
        while (loopOn){
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
                        System.out.print("Digite sua agencia: ");
                        String agencia = scanner.next();
                        System.out.print("Digite seu cpf: ");
                        String cpf = scanner.next();
                        System.out.print("Digite sua data de nascimento: ");
                        String dataNasc = scanner.next();
                        ObjRetorno response;
                        response = userController.criarUser(nome, agencia, cpf, dataNasc);
                        System.out.println(((response.status)?response.nome + " | " + response.agencia:"Error"));
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
