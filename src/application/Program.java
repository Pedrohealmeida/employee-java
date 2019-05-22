package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.excecptions.EmailException;
import entities.excecptions.LastNameException;
import entities.excecptions.NameException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> empList = new ArrayList<>();
		int x = 0;
		
		System.out.println("Inser��o de novo funcion�rio ao sistema:");
		System.out.print("PIS: ");
		int pis = sc.nextInt();
		sc.nextLine();
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Sobrenome: ");
		String lastName = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		while(x == 0) {
			try {
				System.out.println();
				Employee emp = new Employee(name, lastName, email, pis);
				x += 1;
			}
			catch(NameException e) {
				System.out.println(e.getMessage());
				System.out.print("Nome: ");
				name = sc.nextLine();
			}
			catch(LastNameException e) {
				System.out.println(e.getMessage());
				System.out.print("Sobrenome: ");
				lastName = sc.nextLine();
			}
			catch(EmailException e) {
				System.out.println(e.getMessage());
				System.out.print("Email: ");
				email = sc.nextLine();
			}
		}
			
		empList.add(new Employee(name, lastName, email, pis));
		
		System.out.println();
		
		System.out.println("Funcion�rio cadastrado com sucesso: ");
		System.out.println(empList.get(0).toString());
		
		System.out.println();
		
		System.out.println("Escolha uma das op��es a seguir: ");
		System.out.print("R - Consultar dados do funcion�rio\nU - Atualizar dados do funcin�rio\nD - Excluir funcion�rio do sistema\nF - Finalizar consulta no sistema\nOp��o: ");
		char anwser = sc.next().charAt(0);
		while(anwser != '`') {
			switch(anwser) {
			case 'U':
			case 'u':
				System.out.println();
				System.out.println("Novos dados: ");
				int a = 0;
				System.out.print("PIS: ");
				pis = sc.nextInt();
				sc.nextLine();
				System.out.print("Nome: ");
				name = sc.nextLine();
				System.out.print("Sobrenome: ");
				lastName = sc.nextLine();
				System.out.print("Email: ");
				email = sc.nextLine();
				while(a == 0) {
					try {
						Employee emp = new Employee(name, lastName, email, pis);
						a += 1;
						empList.remove(0);
						empList.add(new Employee(name, lastName, email, pis));
						System.out.println("Dados do funcion�rio atualizados com sucesso!");
					}
					catch(NameException e) {
						System.out.println(e.getMessage());
						System.out.print("Nome: ");
						name = sc.nextLine();
						empList.get(0).updateName(name);
					}
					catch(LastNameException e) {
						System.out.println(e.getMessage());
						System.out.print("Sobrenome: ");
						lastName = sc.nextLine();
						empList.get(0).updateLastName(lastName);
					}
					catch(EmailException e) {
						System.out.println(e.getMessage());
						System.out.print("Email: ");
						email = sc.nextLine();
						empList.get(0).updateEmail(email);
					}
				}
				System.out.println();
				System.out.print("R - Consultar dados do funcion�rio\nU - Atualizar dados do funcion�rio\nD - Excluir funcion�rio do sistema\nF - Finalizar consulta no sistema\nOp��o: ");
				anwser = sc.next().charAt(0);
				break;
			case 'R':
			case 'r':
				System.out.println();
				System.out.println("Dados do funcion�rio: ");
				System.out.println(empList.get(0).toString());
				System.out.println();
				System.out.print("R - Consultar dados do funcion�rio\nU - Atualizar dados do funcion�rio\nD - Excluir funcion�rio do sistema\nF - Finalizar consulta no sistema\nOp��o: ");
				anwser = sc.next().charAt(0);
				break;
			case 'D':
			case 'd':
				System.out.println();
				empList.remove(0);
				System.out.println("Funcion�rio excluido com sucesso!");
				System.out.println();
				System.out.println("Opera��o finalizada.");
				anwser = '`';
				break;
			case 'F':
			case 'f':
				System.out.println();
				System.out.println("Opera��o finalizada.");
				System.out.println();
				anwser = '`';
				break;
			default :
				System.out.println();
				System.out.print("Opera��o inv�lida, por favor, escolha uma das op��es a seguir: ");
				System.out.print("\nR - Consultar dados do funcion�rio\nU - Atualizar dados do funcion�rio\nD - Excluir funcion�rio do sistema\nF - Finalizar consulta no sistema\nOp��o: ");
				anwser = sc.next().charAt(0);
			}	
		}
		
		
		sc.close();
	}

}
