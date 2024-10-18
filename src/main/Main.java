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
                    menu.EntrarConta();
                    break;
                case 2:
                    menu.printConfirmação("a função criar conta");
                    if (scanner.nextInt() == 1){
                        menu.criarConta();
                    } else {
                        System.out.println("voltando para o menu...");
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    loopOn = false;
                    break;
                case 12:
                    // codando...
                    break;
                default:
                    System.out.println("Entrada invalida, escolha uma opção valida");
                    break;
            }
        }
    }
}
