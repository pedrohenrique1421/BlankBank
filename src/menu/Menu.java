package menu;

public class Menu {
    public void printMenuPrincipal(){
        System.out.print("1. Entrar na sua conta"+"\n2.Criar conta"
        +"\n3. Sair"+"\n--> ");
    }

    public void printConfirmação(String msg){
        System.out.println("Você selecionou "+msg+", continuar? ( 1 - sim | 2 - não )"+"\n--> ");
    }

    public void limparConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
