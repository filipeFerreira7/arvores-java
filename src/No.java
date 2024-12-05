public class No {

    int conteudo;
    No esq;
    No dir;
    int altura;
    int balance;


    public No(int conteudo) {
        this.conteudo = conteudo;
        this.esq = null;
        this.dir = null;
        this.altura = 1;
        this.balance = 0;
    }
}