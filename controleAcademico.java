import java.util.Scanner;

public class controleAcademico {
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
