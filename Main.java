import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Usuario {
    int id;
    String nome;
    String email;
    
    Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}

public class Main {
    
    static ArrayList<Usuario> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int contadorId = 1;
    
    public static void main(String[] args) {
        int opcao;
        
        do {
            System.out.println("\n==== CRUD USUÁRIOS ====\n");
            System.out.println("1 - Criar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Sair");
            System.out.println("9 - Mostrar arquivo");
            System.out.println("\nEscolha uma opção: ");
            
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch (opcao) {
                case 1:
                    criar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    atualizar();
                    break;
                case 4:
                    deletar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 9:
                    mostrarArquivo();
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);
    }
    
    static void criar() {
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        
        System.out.println("Email: ");
        String email = sc.nextLine();
        
        Usuario u = new Usuario(contadorId++, nome, email);
        lista.add(u);
        salvarArquivo();
        System.out.println("Usuário criado!");
    }
    
    static void listar() {
        if (lista.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        
        for (Usuario u : lista) {
            System.out.println("ID: " + u.id + " | Nome: " + u.nome + " | Email: " + u.email);
        }
    }
    
    static void atualizar() {
        System.out.print("ID para atualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        for (Usuario u : lista) {
            if (u.id == id) {
                System.out.print("Novo nome: ");
                u.nome = sc.nextLine();
                
                System.out.println("Novo email: ");
                u.email = sc.nextLine();
                
                salvarArquivo();
                System.out.println("Atualizado!");
                return;
            }
        }
        
        System.out.println("Usuário não encontrado.");
    }
    
    static void deletar() {
        System.out.println("ID para deletar: ");
        int id = sc.nextInt();
        
        for (Usuario u : lista) {
            if (u.id == id) {
                lista.remove(u);
                salvarArquivo();
                System.out.println("Removido!");
                return;
            }
        }
        
        System.out.println("Usuário não encontrado.");
    }
    
    static void salvarArquivo() {
        try {
            FileWriter writer = new FileWriter("usuários.txt");
            
            for (Usuario u : lista) {
                writer.write(u.id + ";" + u.nome + ";" + u.email + "\n");
            }
            
            writer.close();
            
        } catch (IOException e) {
            System.out.println("Erro ao salvar.");
        }
    }
    
    static void mostrarArquivo() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("usuários.txt"));
            String linha;
            
            System.out.println("\n==== CONTEÚDO DO ARQUIVO ====\n");
            
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
            
            reader.close();
            
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}
