package br.univille.NoSQL.Redis.Exercicio8.app;

import br.univille.NoSQL.Redis.Exercicio8.dao.*;
import br.univille.NoSQL.Redis.Exercicio8.model.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        ContatoDAO dao = new ContatoDAO();

        String opcao;

        do {

            System.out.println("\n=========CONTATOS=========");
            System.out.println("| [1] - Incluir          |");
            System.out.println("| [2] - Listar           |");
            System.out.println("| [3] - Excluir          |");
            System.out.println("| [4] - Editar           |");
            System.out.println("| [0] - Sair             |");
            System.out.println("==========================");

            opcao = scanner.nextLine();

            switch (opcao) {

                case "1":

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Sobrenome: ");
                    String sobrenome = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Idade: ");
                    String idade = scanner.nextLine();

                    Contato contato = new Contato(
                            nome,
                            sobrenome,
                            telefone,
                            idade
                    );

                    dao.salvar(contato);

                    System.out.println("Contato cadastrado.");

                    break;

                case "2":

                    List<Contato> contatos = dao.listarTodos();

                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato encontrado.");
                    } else {
                        contatos.forEach(System.out::println);
                    }

                    break;

                case "3":

                    System.out.print("Digite o nome do contato: ");
                    String nomeExcluir = scanner.nextLine();

                    if (dao.excluir(nomeExcluir)) {
                        System.out.println("Contato removido.");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }

                    break;

                case "4":

                    System.out.print("Digite o nome do contato: ");
                    String nomeEditar = scanner.nextLine();

                    if (!dao.existe(nomeEditar)) {
                        System.out.println("Contato não encontrado.");
                        break;
                    }

                    System.out.println("=== EDITAR ===");
                    System.out.println("[1] Nome");
                    System.out.println("[2] Sobrenome");
                    System.out.println("[3] Telefone");
                    System.out.println("[4] Idade");

                    String campo = scanner.nextLine();

                    String nomeCampo = "";

                    switch (campo) {
                        case "1":
                            nomeCampo = "nome";
                            break;

                        case "2":
                            nomeCampo = "sobrenome";
                            break;

                        case "3":
                            nomeCampo = "telefone";
                            break;

                        case "4":
                            nomeCampo = "idade";
                            break;

                        default:
                            System.out.println("Campo inválido.");
                            continue;
                    }

                    System.out.print("Novo valor: ");
                    String novoValor = scanner.nextLine();

                    dao.atualizarCampo(
                            nomeEditar,
                            nomeCampo,
                            novoValor
                    );

                    System.out.println("Contato atualizado.");

                    break;

                case "0":
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (!opcao.equals("0"));

        scanner.close();
        dao.fecharConexao();
    }
}