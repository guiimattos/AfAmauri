import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double[] pesos = new double[4];
        double[][] notas;
        double[] medias;

        double somaPesos;
        double notaMinima;
        double somaMedias = 0;
        double maiorMedia = 0;
        double menorMedia = 0;
        double percentualAprovados;
        double percentualReprovados;

        int qtdAlunos;
        int aprovados = 0;
        int reprovados = 0;

        do {
            somaPesos = 0;

            System.out.println("Digite os pesos das avaliações:");

            System.out.print("Peso AC1: ");
            pesos[0] = lerNumero(entrada);

            System.out.print("Peso AC2: ");
            pesos[1] = lerNumero(entrada);

            System.out.print("Peso AF: ");
            pesos[2] = lerNumero(entrada);

            System.out.print("Peso AG: ");
            pesos[3] = lerNumero(entrada);

            for (int i = 0; i < 4; i++) {
                somaPesos = somaPesos + pesos[i];
            }

            if (somaPesos != 100) {
                System.out.println("A soma dos pesos deve ser 100. Digite novamente.");
            }
        } while (somaPesos != 100);

        do {
            System.out.print("Digite a nota mínima para aprovação: ");
            notaMinima = lerNumero(entrada);

            if (notaMinima < 0 || notaMinima > 10) {
                System.out.println("Nota mínima inválida.");
            }
        } while (notaMinima < 0 || notaMinima > 10);

        do {
            System.out.print("Digite a quantidade de alunos: ");
            qtdAlunos = lerInteiro(entrada);

            if (qtdAlunos <= 0) {
                System.out.println("Quantidade inválida.");
            }
        } while (qtdAlunos <= 0);

        notas = new double[qtdAlunos][4];
        medias = new double[qtdAlunos];

        for (int i = 0; i < qtdAlunos; i++) {
            System.out.println("Aluno " + (i + 1));

            for (int j = 0; j < 4; j++) {
                do {
                    if (j == 0) {
                        System.out.print("Digite a nota AC1: ");
                    }

                    if (j == 1) {
                        System.out.print("Digite a nota AC2: ");
                    }

                    if (j == 2) {
                        System.out.print("Digite a nota AF: ");
                    }

                    if (j == 3) {
                        System.out.print("Digite a nota AG: ");
                    }

                    notas[i][j] = lerNumero(entrada);

                    if (notas[i][j] < 0 || notas[i][j] > 10) {
                        System.out.println("Nota inválida. Digite novamente.");
                    }
                } while (notas[i][j] < 0 || notas[i][j] > 10);
            }

            medias[i] = (notas[i][0] * pesos[0]
                    + notas[i][1] * pesos[1]
                    + notas[i][2] * pesos[2]
                    + notas[i][3] * pesos[3]) / 100;

            System.out.printf("Média final: %.2f%n", medias[i]);

            if (medias[i] >= notaMinima) {
                System.out.println("Situação: Aprovado");
                aprovados++;
            } else if (Math.abs(medias[i] - (notaMinima - 1)) < 0.000001) {
                System.out.println("Situação: Recuperação");
            } else {
                System.out.println("Situação: Reprovado");
                reprovados++;
            }

            somaMedias = somaMedias + medias[i];

            if (i == 0) {
                maiorMedia = medias[i];
                menorMedia = medias[i];
            } else {
                if (medias[i] > maiorMedia) {
                    maiorMedia = medias[i];
                }

                if (medias[i] < menorMedia) {
                    menorMedia = medias[i];
                }
            }
        }

        percentualAprovados = aprovados * 100.0 / qtdAlunos;
        percentualReprovados = reprovados * 100.0 / qtdAlunos;

        System.out.println("Coleta de dados finalizada.");
        System.out.printf("Média da turma: %.2f%n", somaMedias / qtdAlunos);
        System.out.printf("Maior média: %.2f%n", maiorMedia);
        System.out.printf("Menor média: %.2f%n", menorMedia);
        System.out.printf("Porcentagem de aprovados: %.2f%%%n", percentualAprovados);
        System.out.printf("Porcentagem de reprovados: %.2f%%%n", percentualReprovados);

        entrada.close();
    }

    public static double lerNumero(Scanner entrada) {
        String texto = entrada.next();
        texto = texto.replace(",", ".");
        return Double.parseDouble(texto);
    }

    public static int lerInteiro(Scanner entrada) {
        return entrada.nextInt();
    }
}

/*
EXPLICACAO DO CODIGO

1. import java.util.Scanner;
Essa linha importa a classe Scanner.
O Scanner e usado para ler os dados que o usuario digita no teclado.

2. public class Main
Essa e a classe principal do programa.
Em Java, todo codigo precisa estar dentro de uma classe.
Como o arquivo se chama Main.java, a classe publica tambem se chama Main.

3. public static void main(String[] args)
Esse e o metodo principal.
O programa comeca a executar a partir dele.

4. Scanner entrada = new Scanner(System.in);
Cria o objeto entrada.
Esse objeto permite ler valores digitados pelo usuario.

5. double[] pesos = new double[4];
Cria um vetor com 4 posicoes para guardar os pesos das avaliacoes.
As posicoes sao:
pesos[0] = peso da AC1
pesos[1] = peso da AC2
pesos[2] = peso da AF
pesos[3] = peso da AG

6. double[][] notas;
Declara uma matriz para guardar as notas dos alunos.
Ela sera criada depois, quando o programa souber quantos alunos existem.
A matriz funciona assim:
notas[aluno][avaliacao]

Exemplo:
notas[0][0] = nota AC1 do aluno 1
notas[0][1] = nota AC2 do aluno 1
notas[0][2] = nota AF do aluno 1
notas[0][3] = nota AG do aluno 1

7. double[] medias;
Declara um vetor para guardar a media final de cada aluno.
Exemplo:
medias[0] = media do aluno 1
medias[1] = media do aluno 2

8. Variaveis double
As variaveis do tipo double guardam numeros com casas decimais.
No programa, elas sao usadas para pesos, notas, medias e porcentagens.

somaPesos: guarda a soma dos pesos digitados.
notaMinima: guarda a nota minima para aprovacao.
somaMedias: soma todas as medias dos alunos.
maiorMedia: guarda a maior media encontrada.
menorMedia: guarda a menor media encontrada.
percentualAprovados: guarda a porcentagem de alunos aprovados.
percentualReprovados: guarda a porcentagem de alunos reprovados.

9. Variaveis int
As variaveis do tipo int guardam numeros inteiros.

qtdAlunos: quantidade de alunos da turma.
aprovados: contador de alunos aprovados.
reprovados: contador de alunos reprovados.

10. Entrada dos pesos
O primeiro do while pede os 4 pesos das avaliacoes.
Ele continua repetindo enquanto a soma dos pesos for diferente de 100.

Dentro dele:
somaPesos recebe 0 para limpar a soma anterior.
Depois o usuario digita os pesos de AC1, AC2, AF e AG.

11. Soma dos pesos com for
O for percorre o vetor pesos.
Ele soma as 4 posicoes do vetor:
pesos[0], pesos[1], pesos[2] e pesos[3].

Se a soma for diferente de 100, aparece uma mensagem de erro.
Depois o programa pede todos os pesos novamente.

12. Entrada da nota minima
O segundo do while pede a nota minima para aprovacao.
A nota minima precisa estar entre 0 e 10.

Se o usuario digitar menor que 0 ou maior que 10, o programa mostra:
Nota minima invalida.
Depois pede novamente.

13. Entrada da quantidade de alunos
O terceiro do while pede a quantidade de alunos da turma.
A quantidade precisa ser maior que 0.

Se o usuario digitar 0 ou numero negativo, o programa mostra:
Quantidade invalida.
Depois pede novamente.

14. Criacao da matriz e do vetor
Depois de saber a quantidade de alunos, o programa cria:

notas = new double[qtdAlunos][4];
Essa matriz tem uma linha para cada aluno e 4 colunas para as notas.

medias = new double[qtdAlunos];
Esse vetor tem uma posicao para a media de cada aluno.

15. Laco dos alunos
O for com a variavel i passa por todos os alunos.
Como Java comeca a contar do zero:
i = 0 representa o aluno 1
i = 1 representa o aluno 2
i = 2 representa o aluno 3

Por isso, para mostrar na tela, foi usado i + 1.

16. Laco das notas
Dentro do laco dos alunos existe outro for, usando a variavel j.
Esse laco passa pelas 4 notas do aluno.

j = 0 representa AC1
j = 1 representa AC2
j = 2 representa AF
j = 3 representa AG

17. if para mostrar o nome da avaliacao
Os if verificam o valor de j.
Dependendo do valor, o programa mostra a mensagem correta:
Digite a nota AC1
Digite a nota AC2
Digite a nota AF
Digite a nota AG

18. Guardando a nota na matriz
A linha notas[i][j] = lerNumero(entrada); guarda a nota digitada.

Exemplo:
Se i = 0 e j = 0, guarda AC1 do aluno 1.
Se i = 0 e j = 1, guarda AC2 do aluno 1.
Se i = 1 e j = 0, guarda AC1 do aluno 2.

19. Validacao das notas
Cada nota precisa estar entre 0 e 10.
Se a nota for menor que 0 ou maior que 10, o programa mostra erro.
O do while repete apenas aquela nota ate o usuario digitar um valor valido.

20. Calculo da media ponderada
A media e calculada com a formula:

(AC1 * pesoAC1 + AC2 * pesoAC2 + AF * pesoAF + AG * pesoAG) / 100

No codigo:
notas[i][0] * pesos[0] calcula a parte da AC1.
notas[i][1] * pesos[1] calcula a parte da AC2.
notas[i][2] * pesos[2] calcula a parte da AF.
notas[i][3] * pesos[3] calcula a parte da AG.

Depois tudo e dividido por 100 porque os pesos foram digitados em porcentagem.

21. Mostrando a media
System.out.printf("Media final: %.2f%n", medias[i]);
Mostra a media com 2 casas decimais.
O %.2f significa numero real com duas casas depois da virgula.

22. Verificando se o aluno foi aprovado
Se a media do aluno for maior ou igual a nota minima, ele e aprovado.
Quando isso acontece, o contador aprovados aumenta 1.

23. Verificando recuperacao
Se o aluno nao foi aprovado, o programa verifica se a media e exatamente um ponto abaixo da nota minima.

Exemplo:
Nota minima = 6
Recuperacao = 5

Foi usado Math.abs para comparar numeros decimais com mais seguranca.

24. Verificando reprovacao
Se o aluno nao foi aprovado e tambem nao ficou de recuperacao, ele foi reprovado.
Quando isso acontece, o contador reprovados aumenta 1.

25. Soma das medias
A cada aluno, a media dele e somada em somaMedias.
No final, essa variavel sera usada para calcular a media geral da turma.

26. Maior e menor media
No primeiro aluno, a maiorMedia e a menorMedia recebem a media dele.
Depois, para os proximos alunos:
Se a media atual for maior que maiorMedia, atualiza maiorMedia.
Se a media atual for menor que menorMedia, atualiza menorMedia.

27. Percentual de aprovados e reprovados
Depois que todos os alunos foram processados, o programa calcula:

percentualAprovados = aprovados * 100.0 / qtdAlunos;
percentualReprovados = reprovados * 100.0 / qtdAlunos;

O 100.0 foi usado para a conta ser feita com numero decimal.

28. Resultados finais
No final, o programa mostra:
Coleta de dados finalizada.
Media da turma.
Maior media.
Menor media.
Porcentagem de aprovados.
Porcentagem de reprovados.

29. entrada.close();
Fecha o Scanner.
Isso indica que o programa terminou de usar a entrada de dados.

30. Metodo lerNumero
Esse metodo le um valor digitado como texto.
Depois troca virgula por ponto.
Assim o usuario pode digitar 6,5 ou 6.5.
Depois o texto e convertido para double.

31. Metodo lerInteiro
Esse metodo le um numero inteiro.
Ele e usado para ler a quantidade de alunos.

RESUMO GERAL
O programa le os pesos das avaliacoes, valida se a soma e 100, le a nota minima,
le a quantidade de alunos, armazena as notas em uma matriz, calcula a media de
cada aluno, mostra a situacao individual e no final exibe as estatisticas da turma.
*/
