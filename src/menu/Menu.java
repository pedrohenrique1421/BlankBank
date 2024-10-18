package menu;

import objRetorno.ObjRetorno;
import user.UserController;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();
    ObjRetorno response;

    public void printMenuPrincipal(){
        System.out.print("1. Entrar na sua conta"+"\n2. Criar conta"
        +"\n3. Sair"+"\n12. DevOptions  "+"\n--> ");
    }

    public void printConfirmação(String msg){
        System.out.print("\n\nVocê selecionou "+msg+", continuar? ( 1 - sim | 2 - não )"+"\n--> ");
    }

    public void printObjRetorno(ObjRetorno obj){
        System.out.println(((obj.status)?obj.nome + " | " + obj.agencia + " | " + obj.cpf + " | " + obj.saldo:"Error"));
    }

    public void criarConta(){
        String nome, agencia, cpf, dataNasc;
        do {
            System.out.print("Digite seu nome: ");
            nome = scanner.next();
            System.out.print("Digite sua agencia: ");
            agencia = scanner.next();
            System.out.print("Digite seu cpf: ");
            cpf = scanner.next();
            System.out.print("Digite sua data de nascimento: ");
            dataNasc = scanner.next();
            System.out.printf("Nome: %s\nAgência: %s\nCPF: %s\nData de Nascimento: %s", nome, agencia, cpf, dataNasc);
            System.out.print("\n\nInformcoes conferem? ( 1 - sim | 0 - não )\n--> ");
        } while (scanner.nextInt() == 0);
        response = userController.criarUser(nome, agencia, cpf, dataNasc);
        System.out.println((response.status)?"Criado com sucesso":"Error ao criar usuario");
    }

    public void EntrarConta(){
        String nome, cpf, senha;
        do {
            System.out.print("Digite seu nome: ");
            nome = scanner.next();
            System.out.print("Digite sua cpf: ");
            cpf = scanner.next();
            System.out.print("Digite sua senha: ");
            senha = scanner.next();
            System.out.printf("Nome: %s\nCPF: %s\nSenha: %s", nome, cpf, senha.replaceAll(".", "*"));
            System.out.print("\n\nInformcoes conferem? ( 1 - sim | 0 - não )\n--> ");
        } while(scanner.nextInt() == 0);
        response = userController.getUser(nome, cpf, senha);
        printObjRetorno(response);
    }

    // Fazer as opcoes de transferir, depositar e retirar...

    public void limparConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
