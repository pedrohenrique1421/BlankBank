package user;

import java.util.Random;

public class User {
    protected String nome, agencia;
    protected String cpf, dataNasc;
    private int id;
    private String senha;
    private float saldo;

    protected User(String nome, String agencia, String cpf, String dataNasc, int id){
        this.nome = nome;
        this.agencia = agencia;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.id = id;
    }

    protected String getCpf(){
        return cpf;
    }

    protected String getNome(){ return nome; }

    protected String getAgencia(){ return agencia; }

    protected float getSaldo(){ return saldo; }

    protected boolean verificarSenha(String senha){
        return this.senha.equals(senha);
    }

    protected boolean definirSenha(String senha){
        this.senha = senha;
        return true;
    }
    protected boolean depositar(String senha, float valor){
        if(this.senha.equals(senha)){
            saldo += valor;
            return true;
        } else {
            return false;
        }
    }
}
