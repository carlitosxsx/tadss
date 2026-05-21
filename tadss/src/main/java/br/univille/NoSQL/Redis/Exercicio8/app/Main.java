package br.univille.NoSQL.Redis.Exercicio8.app;

import br.univille.NoSQL.Redis.Exercicio8.dao.*;
import br.univille.NoSQL.Redis.Exercicio8.model.*;

import java.util.List;
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
            System.out.println("| [3] - Excluir             |");
            System.out.println("| [4] - Editar              |");
            System.out.println("| [0] - Sair                |");
            System.out.println("=============================");

            opcao = scanner.nextLine();

            switch (opcao) {

                case "1":

                    System.out.print("ID: ");
                    int id = Integer.parseInt(
                            scanner.nextLine()
                    );

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Idade: ");
                    int idade = Integer.parseInt(
                            scanner.nextLine()
                    );

                    Pessoa pessoa = new Pessoa(
                            id,
                            nome,
                            telefone,
                            email,
                            idade
                    );

                    dao.salvar(pessoa);

                    System.out.println(
                            "Pessoa cadastrada."
                    );

                    break;

                case "2":

                    List<Pessoa> pessoas =
                            dao.listarTodos();

                    if (pessoas.isEmpty()) {

                        System.out.println(
                                "Nenhuma pessoa encontrada."
                        );

                    } else {

                        pessoas.forEach(System.out::println);
                    }

                    break;

                case "3":

                    System.out.print(
                            "Digite o nome da pessoa: "
                    );

                    String nomeExcluir =
                            scanner.nextLine();

                    if (dao.excluir(nomeExcluir)) {

                        System.out.println(
                                "Pessoa removida."
                        );

                    } else {

                        System.out.println(
                                "Pessoa não encontrada."
                        );
                    }

                    break;

                case "4":

                    System.out.print(
                            "Digite o nome da pessoa: "
                    );

                    String nomeEditar =
                            scanner.nextLine();

                    Pessoa pessoaEditar =
                            dao.buscar(nomeEditar);

                    if (pessoaEditar == null) {

                        System.out.println(
                                "Pessoa não encontrada."
                        );

                        break;
                    }

                    System.out.println("=== EDITAR ===");
                    System.out.println("[1] Telefone");
                    System.out.println("[2] Email");
                    System.out.println("[3] Idade");

                    String campo =
                            scanner.nextLine();

                    switch (campo) {

                        case "1":

                            System.out.print(
                                    "Novo telefone: "
                            );

                            pessoaEditar.setTelefone(
                                    scanner.nextLine()
                            );

                            break;

                        case "2":

                            System.out.print(
                                    "Novo email: "
                            );

                            pessoaEditar.setEmail(
                                    scanner.nextLine()
                            );

                            break;

                        case "3":

                            System.out.print(
                                    "Nova idade: "
                            );

                            pessoaEditar.setIdade(
                                    Integer.parseInt(
                                            scanner.nextLine()
                                    )
                            );

                            break;

                        default:

                            System.out.println(
                                    "Campo inválido."
                            );

                            continue;
                    }

                    dao.atualizar(pessoaEditar);

                    System.out.println(
                            "Pessoa atualizada."
                    );

                    break;

                case "0":

                    System.out.println(
                            "Programa encerrado."
                    );

                    break;

                default:

                    System.out.println(
                            "Opção inválida."
                    );
            }

        } while (!opcao.equals("0"));

        scanner.close();
        dao.fecharConexao();
    }
}