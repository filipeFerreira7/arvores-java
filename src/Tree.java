public class Tree {
    No raiz;

    public static No insere(No root, int valor) {
        if (root == null) {
            return new No(valor);
        } else {
            if (valor > root.conteudo) {
                root.dir = insere(root.dir, valor);
            } else
                root.esq = insere(root.esq, valor);
        }
        root.altura = calculaAltura(root);
        root.balance = calculaBalance(root);

        return balanceia(root);
    }

    public static int calculaBalance(No root) {
        if (root == null)
            return 0;
        return calculaAltura(root.dir) - calculaAltura(root.esq);
    }

    public static No balanceia(No root) {
        int balance = calculaBalance(root);
        if (balance > 1){
            if (calculaBalance(root.dir) < 0) {
                root.dir = rotacaoDir(root.dir);
            }
        return rotacaoEsq(root);
    }
        if(balance<-1){
            if(calculaBalance(root.esq)>0){
                root.esq = rotacaoEsq(root.esq);
            }
            return rotacaoDir(root);
        }
        return root;
    }


    public static No rotacaoEsq(No root){
      No novaRaiz = root.dir;
      root.dir = novaRaiz.esq;
      novaRaiz.esq = root;

      root.altura = calculaAltura(root);
      novaRaiz.altura = calculaAltura(novaRaiz);

      root.balance = calculaBalance(root);
      novaRaiz.balance = calculaBalance(novaRaiz);

    return novaRaiz;
    }

    public static No rotacaoDir(No root){
        No novaRaiz = root.esq;
        root.esq = novaRaiz.dir;
        novaRaiz.dir = root;

        root.altura = calculaAltura(root);
        novaRaiz.altura = calculaAltura(novaRaiz);

        root.balance = calculaBalance(root);
        novaRaiz.balance = calculaBalance(novaRaiz);

        root.altura = calculaAltura(root);
        novaRaiz.altura = calculaAltura(novaRaiz);

        root.balance = calculaBalance(root);
        novaRaiz.balance = calculaBalance(novaRaiz);

        return novaRaiz;
    }



    public static boolean existeNo(No root, int valor){
        if(root==null)
            return false;
        if(root.conteudo == valor)
            return true;
        return valor < root.conteudo ? existeNo(root.esq, valor) : existeNo(root.dir, valor);
    }

    public static int calculaAltura(No node){
        if(node == null){
            return 0;
        }
        int alturaDir = calculaAltura(node.dir);
        int alturaEsq = calculaAltura(node.esq);
        return Math.max(alturaEsq,alturaDir)+1;

    }
    public static int quantidadeNos(No root) {
        if (root == null) {
            return 0;
        }
        return 1 + quantidadeNos(root.esq) + quantidadeNos(root.dir);
    }
    public static void inOrdem(No root) {
        if (root != null) {
            inOrdem(root.esq);
            System.out.print(" -> " + root.conteudo + " altura: "+"["+root.altura+"]" + ", FB: " + root.balance + ")");
            inOrdem(root.dir);
        }
    }
    public static void preOrdem(No root) {
        if (root != null) {
            System.out.print(" -> " + root.conteudo + " altura: "+"["+root.altura+"]" + ", FB: " + root.balance + ")");
            preOrdem(root.esq);
            preOrdem(root.dir);
        }
    }
    public static void posOrdem(No root) {
        if (root != null) {
            posOrdem(root.esq);
            posOrdem(root.dir);
            System.out.print(" -> " + root.conteudo + " altura: "+"["+root.altura+"]" + ", FB: " + root.balance + ")");
        }
    }
    public static int retornaMenor(No raiz) {
        if (raiz == null) {
            return -1;
        }
        while (raiz.esq != null)
            raiz = raiz.esq;

        return raiz.conteudo;
    }
    public static int retornaMaior(No raiz) {
        if (raiz == null) {
            return -1;
        }
        while (raiz.dir != null)
            raiz = raiz.dir;

        return raiz.conteudo;
    }
}
