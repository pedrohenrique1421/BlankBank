package objRetorno;

public class ObjRetorno {
    public String nome, agencia, cpf;
    public float saldo;
    public boolean status;

    public ObjRetorno(String nome, String agencia, String cpf, float saldo, boolean status){
        this.nome = nome;
        this.agencia = agencia;
        this.cpf = cpf;
        this.saldo = saldo;
        this.status = status;
    }
}
