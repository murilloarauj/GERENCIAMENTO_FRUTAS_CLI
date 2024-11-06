package gerenfrutas;

import java.util.ArrayList; // ArrayList para modificar lista de frutas
import java.util.InputMismatchException; // exceção para tratar entradas incorretas
import java.util.Scanner; // Scanner para receber dados do usuário

public class frutasger { // Classe principal 
    public static void main(String[] args) { // Método que inicia o programa
        Scanner scanner = new Scanner(System.in); // Cria o Scanner para receber comando do usuário
        ArrayList<String> frutas = new ArrayList<>(); // Inicializa a lista para armazenar as frutas

        while (true) { // Inicia o loop contínuo 
            try {
                // Exibe as opções do menu
                System.out.println("Escolha uma opcao:");
                System.out.println("1. Adicionar uma fruta"); 
                System.out.println("2. Listar todas as frutas");
                System.out.println("3. Modificar uma fruta"); 
                System.out.println("4. Remover uma fruta"); 
                System.out.println("5. Sair"); 
                System.out.print("Opcao: "); 
                
                int opcao = scanner.nextInt(); // Recebe a opção escolhida
                scanner.nextLine(); 

                switch (opcao) { // Executa ações com base na opção selecionada
                    case 1: // Adicionar nova fruta
                        System.out.print("Digite o nome da fruta para adicionar: "); 
                        String novaFruta = scanner.nextLine(); // Recebe o nome da fruta
                        frutas.add(novaFruta); // Insere a fruta na lista
                        System.out.println(novaFruta + " foi adicionada."); 
                        break;

                    case 2: // Listar todas as frutas
                        System.out.println("Frutas: " + frutas); 
                        break;

                    case 3: // Modificar uma fruta existente
                        System.out.println("Digite o índice da fruta que deseja modificar: "); 
                        int indiceModificar = scanner.nextInt(); // Lê o índice da fruta
                        scanner.nextLine(); 
                        
                        if (indiceModificar >= 0 && indiceModificar < frutas.size()) { // Verifica se o índice é válido
                            System.out.println("Digite o novo nome da fruta: "); 
                            String frutaModificada = scanner.nextLine(); // Recebe o novo nome
                            frutas.set(indiceModificar, frutaModificada); // Atualiza a fruta na posição informada
                            System.out.println("Fruta do índice " + indiceModificar + " foi modificada para " + frutaModificada);
                        } else {
                            System.out.println("Índice inválido."); // Notifica se o índice não for válido
                        }
                        break;

                    case 4: // Remover uma fruta da lista
                        System.out.println("Digite o nome da fruta que deseja remover: "); 
                        String frutaRemover = scanner.nextLine(); // Recebe o nome da fruta a ser excluída
                        
                        if (frutas.remove(frutaRemover)) { // Tenta excluir a fruta da lista
                            System.out.println(frutaRemover + " foi removida."); 
                        } else {
                            System.out.println(frutaRemover + " não foi encontrada."); // Informa caso a fruta não exista na lista
                        }
                        break;

                    case 5: // Finalizar o programa
                        System.out.println("Saindo..."); 
                        scanner.close(); // Encerra o Scanner
                        return; // Finaliza o programa

                    default: // Mensagem para opção inválida
                        System.out.println("Opcao invalida. Tente novamente."); 
                }
            } catch (InputMismatchException e) { // Captura erro de tipo incorreto na entrada
                System.out.println("Entrada invalida. Por favor, digite um numero."); 
                scanner.nextLine(); // Limpa o buffer do Scanner para a próxima entrada
            }
        }
    }
}
