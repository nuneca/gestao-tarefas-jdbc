import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TarefaDAO dao = new TarefaDAO();

        int opcao = 0;

        while (opcao != 6) {

            System.out.println("\n===== MENU =====");
            System.out.println("1 Criar tarefa");
            System.out.println("2 Listar tarefas");
            System.out.println("3 Concluir tarefa");
            System.out.println("4 Excluir tarefa");
            System.out.println("5 Filtrar por categoria");
            System.out.println("6 Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("Título:");
                    String titulo = sc.nextLine();

                    System.out.println("Categoria:");
                    String categoria = sc.nextLine();

                    dao.criarTarefa(titulo, categoria);

                    break;

                case 2:
                    dao.listarTarefas();
                    break;

                case 3:

                    System.out.println("ID da tarefa:");
                    int id = sc.nextInt();

                    dao.concluirTarefa(id);

                    break;

                case 4:

                    System.out.println("ID da tarefa:");
                    int idExcluir = sc.nextInt();

                    dao.excluirTarefa(idExcluir);

                    break;

                case 5:

                    System.out.println("Categoria:");
                    String cat = sc.nextLine();

                    dao.filtrarCategoria(cat);

                    break;

                case 6:
                    System.out.println("Encerrando...");
                    break;

            }

        }

    }
}
