package teste;

import estruturadados.mapa.ListaEncadeada;
import estruturadados.mapa.Mapa;

public class MapaTeste {

    public static void main(String[] args) {
        // Descomenta o exercício que desejas testar:

        exercicio1();
        // exercicio2();
        // exercicio3();
        // exercicio4();
        // exercicio5();
        // exercicio6();
        // exercicio7();
    }

    public static void exercicio1() {
        System.out.println("--- Exercício 1: Sistema de alunos ---");
        Mapa<Integer, String> alunos = new Mapa<>();

        // Inserir pelo menos 5 alunos[cite: 35]
        alunos.inserir(101, "Ana");
        alunos.inserir(102, "Bruno");
        alunos.inserir(103, "Carlos");
        alunos.inserir(104, "Diana");
        alunos.inserir(105, "Eduardo");

        System.out.println("Buscar aluno 103: " + alunos.buscar(103)); // Carlos[cite: 35]

        System.out.println("Remover aluno 102: " + alunos.remover(102)); // Bruno[cite: 35]

        System.out.println("Chaves: " + alunos.chaves()); // Exibir todas as chaves[cite: 35]
        System.out.println("Valores: " + alunos.valores()); // Exibir todos os valores[cite: 35]
    }

    public static void exercicio2() {
        System.out.println("--- Exercício 2: Contador de palavras ---");
        String frase = "java java mapa lista mapa mapa"; //[cite: 35]
        String[] palavras = frase.split(" ");

        Mapa<String, Integer> contador = new Mapa<>();

        for (String palavra : palavras) {
            Integer qtd = contador.buscar(palavra);
            if (qtd == null) {
                contador.inserir(palavra, 1);
            } else {
                contador.inserir(palavra, qtd + 1);
            }
        }

        System.out.println("Contagem: " + contador); // Saída esperada[cite: 35]
    }

    public static void exercicio3() {
        System.out.println("--- Exercício 3: Agenda telefónica ---");
        Mapa<String, String> agenda = new Mapa<>(); //[cite: 35]

        agenda.inserir("Mãe", "911222333");
        agenda.inserir("Pai", "911222444");
        agenda.inserir("Trabalho", "211000000");
        agenda.inserir("Pizzaria", "222333444"); // Inserir 4 contatos[cite: 36]

        System.out.println("Telefone da Mãe: " + agenda.buscar("Mãe")); // Buscar telefone[cite: 36]

        agenda.remover("Trabalho"); // Remover um contato[cite: 36]

        System.out.println("Todos os contatos: " + agenda); // Exibir contatos[cite: 36]
    }

    public static void exercicio4() {
        System.out.println("--- Exercício 4: Controle de estoque ---");
        Mapa<String, Integer> estoque = new Mapa<>(); //[cite: 36]

        estoque.inserir("Rato", 10);
        estoque.inserir("Teclado", 5);
        estoque.inserir("Monitor", 3);

        System.out.println("Estoque inicial: " + estoque);

        // Simular venda de um teclado (diminuir quantidade)[cite: 36]
        Integer qtdTeclado = estoque.buscar("Teclado");
        if (qtdTeclado != null && qtdTeclado > 0) {
            estoque.inserir("Teclado", qtdTeclado - 1);
        }

        System.out.println("Estoque atualizado: " + estoque); // Exibir atualizado[cite: 36]
    }

    public static void exercicio5() {
        System.out.println("--- Exercício 5: Frequência de notas ---");
        int[] notas = {7, 8, 7, 10, 8, 7}; //[cite: 36]
        Mapa<Integer, Integer> frequencia = new Mapa<>();

        for (int nota : notas) {
            Integer qtd = frequencia.buscar(nota);
            if (qtd == null) {
                frequencia.inserir(nota, 1);
            } else {
                frequencia.inserir(nota, qtd + 1);
            }
        }

        System.out.println("Frequência: " + frequencia);
    }

    public static void exercicio6() {
        System.out.println("--- Exercício 6: Inverter mapa ---");
        Mapa<Integer, String> mapaOriginal = new Mapa<>();
        mapaOriginal.inserir(1, "A");
        mapaOriginal.inserir(2, "B");
        mapaOriginal.inserir(3, "C"); //[cite: 36]

        Mapa<String, Integer> mapaInvertido = new Mapa<>();

        // Lógica de inversão[cite: 36]
        ListaEncadeada<Integer> chavesOriginal = mapaOriginal.chaves();
        for (int i = 0; i < chavesOriginal.getTamanho(); i++) {
            Integer chave = chavesOriginal.buscaPorPosicao(i);
            String valor = mapaOriginal.buscar(chave);
            mapaInvertido.inserir(valor, chave);
        }

        System.out.println("Original: " + mapaOriginal);
        System.out.println("Invertido: " + mapaInvertido);
    }

    public static void exercicio7() {
        System.out.println("--- Exercício 7: Ranking de pontuação ---");
        Mapa<String, Integer> ranking = new Mapa<>(); //[cite: 37]

        ranking.inserir("Jogador1", 1500);
        ranking.inserir("Jogador2", 2200);
        ranking.inserir("Jogador3", 1800);
        ranking.inserir("Jogador4", 2100); // 4 jogadores[cite: 37]

        ranking.inserir("Jogador3", 2500); // Atualizar pontuação[cite: 37]

        ListaEncadeada<String> nomes = ranking.chaves();
        String melhorJogador = "";
        int maiorPontuacao = -1;

        for (int i = 0; i < nomes.getTamanho(); i++) {
            String nome = nomes.buscaPorPosicao(i);
            int pontuacao = ranking.buscar(nome);

            if (pontuacao > maiorPontuacao) {
                maiorPontuacao = pontuacao;
                melhorJogador = nome;
            }
        }

        System.out.println("Ranking completo: " + ranking);
        System.out.println("Melhor jogador: " + melhorJogador + " com " + maiorPontuacao + " pontos."); //[cite: 37]
    }
}