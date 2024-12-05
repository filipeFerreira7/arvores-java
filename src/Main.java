package arvore_corrigida.src;

import java.util.Scanner;
import arvore_corrigida.src.*;
public class Main {

    public static void main(final String[] args) {
        No raiz = null; // Inicializa a raiz como null, indicando uma árvore vazia

        int valor;
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe um valor para inserir na lista:");
        valor = leitor.nextInt();

        while (valor > 0) {
            raiz = Tree.insere(raiz, valor); // Atualiza a raiz com o retorno de insere
            Tree.inOrdem(raiz);
            System.out.println(" --- prox");
            System.out.print("Informe um valor para inserir na lista:");
            valor = leitor.nextInt();
        }

        System.out.println("--------PERCURSOS(PRÉ,PÓS)---------");
        System.out.println("Pre");
        Tree.preOrdem(raiz);

        System.out.println("\n pos");
        Tree.posOrdem(raiz);


        System.out.println("\n ------------MENORES E QUANTIDADE----------------");

        System.out.println(" \n O menor valor da árvore é: "+   Tree.retornaMenor(raiz));

        System.out.println("O maior valor da árvore é: "+ Tree.retornaMaior(raiz));

        System.out.println("Quantidade de nós da árvore: "+ Tree.quantidadeNos(raiz));

        System.out.println("-------------BUSCA------------------");
        System.out.print("Informe um valor para buscar na árvore: ");
        valor = leitor.nextInt();
        System.out.println("O valor " + valor + " existe na árvore? " + Tree.existeNo(raiz, valor));

        leitor.close();
    }}
