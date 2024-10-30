package user;

import objRetorno.ObjRetorno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class UserController {
    private final List<User> usuarios = new ArrayList<>();
    private List<Integer> ids = new ArrayList<>();
    
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
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
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

}
