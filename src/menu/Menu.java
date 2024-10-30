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


    public void printObjRetorno(ObjRetorno obj){
        System.out.println(((obj.status)?obj.nome + " | " + obj.agencia + " | " + obj.cpf + " | " + obj.saldo:"Error"));
    }

    public void criarConta(){
        String nome, agencia, cpf, dataNasc;
        do {
            System.out.print("Digite seu nome ou para sair digite 400: ");
            nome = scanner.next();
            if (nome.equals("400")){
                return;
            }
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

    public void entrarConta(){
        String nome, cpf, senha;
        do {
            System.out.print("Digite seu nome ou para sair digite 400: ");
            nome = scanner.next();
            if (nome.equals("400")){
                return;
            }
            System.out.print("Digite sua cpf: ");
            cpf = scanner.next();
            System.out.print("Digite sua senha: ");
            senha = scanner.next();
            System.out.printf("Nome: %s\nCPF: %s\nSenha: %s", nome, cpf, senha.replaceAll(".", "*"));
            System.out.print("\n\nInformcoes conferem? ( 1 - sim | 0 - não )\n--> ");
        } while(scanner.nextInt() == 0);
        response = userController.getUser(nome, cpf, senha);
        menuDentroConta(response);
    }

    // Fazer as opcoes de transferir, depositar e retirar...

    public void menuDentroConta(ObjRetorno objUser){
        int resp;
        while(true) {
            System.out.println("1. Transferir\n2. Depositar\n3. Retirar\n4. Extrato\n5. Sair para o menu principal");
            resp = scanner.nextInt();

            switch (resp){
                case 1:
                    System.out.println("Transferir");
                    // Escrever codigo de transferir aqui
                    break;
                case 2:
                    System.out.println("Depositar");
                    boolean loop = true;
                    do {
                        boolean response = userController.depositar(objUser.nome, objUser.cpf);
                        if (!response){
                            System.out.print("\nO deposito falhou, deseja tentar novamente? ( 1 - sim | 2 - não )\n --> ");
                            if (scanner.nextInt() == 2){
                                loop = false;
                            }
                        } else {
                            System.out.println("Deposito realizado com sucesso!");
                            loop = false;
                        }
                    } while (loop);
                    break;
                case 3:
                    System.out.println("Retirar");
                    // Escrever codigo de Retirada aqui
                    break;
                case 4:
                    System.out.println("Extrato");
                    ObjRetorno response = userController.getUserSemSenha(objUser.nome, objUser.cpf);
                    System.out.printf("| Nome: %s |\n| Agencia: %s |\n| CPF: %s |\n| Saldo: %.2f |",
                            response.nome, response.agencia, response.cpf, response.saldo);
                    System.out.println("\n\nDigite algo para continuar... ");
                    scanner.next();
                    break;
                case 5:
                    System.out.println("fim ------------------");
                    return;
            }
        }
    }
}
