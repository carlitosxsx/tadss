package br.univille.NoSQL.Redis.Exercicio8.app;

import br.univille.NoSQL.Redis.Exercicio8.dao.PessoaDAO;
import br.univille.NoSQL.Redis.Exercicio8.model.Pessoa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        PessoaDAO dao = new PessoaDAO();

        String opcao;

        do {

            System.out.println("\n========== PESSOAS ==========");
            System.out.println("| [1] - Incluir             |");
            System.out.println("| [2] - Listar              |");
            System.out.println("| [3] - Buscar              |");
            System.out.println("| [4] - Editar              |");
            System.out.println("| [5] - Excluir             |");
            System.out.println("| [0] - Sair                |");
            System.out.println("=============================");

            opcao = scanner.nextLine();

            switch (opcao) {

                case "1":

                    System.out.print("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Apelido: ");
                    String apelido = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Idade: ");
                    int idade = Integer.parseInt(scanner.nextLine());

                    Pessoa pessoa = new Pessoa(
                            id,
                            nome,
                            apelido,
                            telefone,
                            email,
                            idade
                    );

                    dao.create(pessoa);

                    System.out.println("Pessoa cadastrada.");

                    break;

                case "2":

                    System.out.println("\n=== LISTA DE PESSOAS ===");

                    dao.listar();

                    break;

                case "3":

                    System.out.print("Digite o apelido: ");
                    String apelidoBusca = scanner.nextLine();

                    Pessoa encontrada = dao.read(apelidoBusca);

                    if (encontrada != null) {
                        System.out.println(encontrada);
                    } else {
                        System.out.println("Pessoa não encontrada.");
                    }

                    break;

                case "4":

                    System.out.print("Digite o apelido da pessoa: ");
                    String apelidoEditar = scanner.nextLine();

                    Pessoa pessoaEditar = dao.read(apelidoEditar);

                    if (pessoaEditar == null) {
                        System.out.println("Pessoa não encontrada.");
                        break;
                    }

                    System.out.println("\n=== EDITAR ===");
                    System.out.println("[1] Nome");
                    System.out.println("[2] Telefone");
                    System.out.println("[3] Email");
                    System.out.println("[4] Idade");

                    String campo = scanner.nextLine();

                    switch (campo) {

                        case "1":

                            System.out.print("Novo nome: ");
                            pessoaEditar.setNome(scanner.nextLine());

                            break;

                        case "2":

                            System.out.print("Novo telefone: ");
                            pessoaEditar.setTelefone(scanner.nextLine());

                            break;

                        case "3":

                            System.out.print("Novo email: ");
                            pessoaEditar.setEmail(scanner.nextLine());

                            break;

                        case "4":

                            System.out.print("Nova idade: ");
                            pessoaEditar.setIdade(
                                    Integer.parseInt(scanner.nextLine())
                            );

                            break;

                        default:

                            System.out.println("Campo inválido.");
                            continue;
                    }

                    dao.update(pessoaEditar);

                    System.out.println("Pessoa atualizada.");

                    break;

                case "5":

                    System.out.print("Digite o apelido da pessoa: ");
                    String apelidoExcluir = scanner.nextLine();

                    if (dao.delete(apelidoExcluir)) {
                        System.out.println("Pessoa removida.");
                    } else {
                        System.out.println("Pessoa não encontrada.");
                    }

                    break;

                case "0":

                    System.out.println("Programa encerrado.");

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (!opcao.equals("0"));

        scanner.close();
    }
}