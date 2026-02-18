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
            System.out.println("\n==== CRUD USUÁRIOS ====");
            System.out.println("1 - Criar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            
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
                default:
                    System.out.println("Opção inválida");
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
                System.out.println("Removido!");
                return;
            }
        }
        
        System.out.println("Usuário não encontrado.");
    }
}
