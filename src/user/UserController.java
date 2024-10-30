package user;

import objRetorno.ObjRetorno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class UserController {
    private final List<User> usuarios = new ArrayList<>();
    private List<Integer> ids = new ArrayList<>();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    
    private boolean verificarId(int id){
        if(ids.size() > 0){
            for (int i = 0; i < ids.size(); i++) {
                if (ids.get(i) == id){
                    return true;
                }
            }
        }
        return false;
    }
    
    public ObjRetorno criarUser(String nome, String agencia, String cpf, String dataNasc){
        int proxId;
        do{
            proxId = random.nextInt(1000000000, 2147483647);
        } while (verificarId(proxId));
        usuarios.add(new User(nome, agencia, cpf, dataNasc, proxId));
        System.out.print("defina sua senha de 6 numeros: ");
        String novaSenha = scanner.next();
        User user = usuarios.getLast();
        if (novaSenha.length() > 4){
            user.definirSenha(novaSenha);
        }
        ids.add(proxId);

        return new ObjRetorno(usuarios.getLast().nome, usuarios.getLast().agencia, usuarios.getLast().cpf, usuarios.getLast().getSaldo(), true);
    }

    public ObjRetorno getUser(String nome, String cpf, String senha){
        for (int i = 0; i < usuarios.size(); i++) {
            User user = usuarios.get(i);
            if (user.getCpf().equals(cpf) && user.getNome().equals(nome) && user.verificarSenha(senha)){
                return new ObjRetorno(user.getNome(), user.getAgencia(), user.getCpf(), user.getSaldo(), true);
            }
        }
        return new ObjRetorno("","","",0,false);
    }

    public ObjRetorno getUserSemSenha(String nome, String cpf){
        for (int i = 0; i < usuarios.size(); i++) {
            User user = usuarios.get(i);
            if (user.getCpf().equals(cpf) && user.getNome().equals(nome)){
                return new ObjRetorno(user.getNome(), user.getAgencia(), user.getCpf(), user.getSaldo(), true);
            }
        }
        return new ObjRetorno("","","",0,false);
    }

    public boolean depositar(String nome, String cpf){
        float valor = 0;
        for (int i = 0; i < usuarios.size(); i++) {
            User user = usuarios.get(i);
            if (user.getCpf().equals(cpf) && user.getNome().equals(nome)){
                do {
                    System.out.print("Qual o valor?\n--> ");
                    valor = scanner.nextFloat();
                    if (valor > 1000 || valor <= 0){
                        System.out.println((valor > 100)?"Valor maximo excedido. Valor máximo: R$ 1.000,00":"Valor menor que zero. valor minimo: R$ 1,00");
                        System.out.print("\n\nDeseja digitar o valor novamente?( 1 - sim | 2 - não )\n--> ");
                        if (scanner.nextInt() == 2){
                            return false;
                        }
                    }

                } while (valor == 0 || valor > 1000 );

                System.out.printf("| Nome: %s |\n| Agencia: %s |\n| CPF: %s |\n| Valor: %.2f |\n",
                        user.getNome(), user.getAgencia(), user.getCpf(), valor);
                System.out.print("\nConfirmar?( 1 - sim | 2 - não )\n--> ");

                if (scanner.nextInt() == 1){
                    System.out.print("Digite sua senha: ");
                    boolean responseDepositar = user.depositar(scanner.next(), valor);

                    if (responseDepositar){
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

}
