package br.com.agenda.main;

import java.util.Scanner;
import java.util.Date;
import java.util.Iterator;

import br.com.agenda.dao.ContactDAO;
import br.com.agenda.model.Contact;

public class main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ContactDAO DAO = new ContactDAO();
		Contact user = new Contact();
		int idUser;
		boolean back = false;
		String comand;
		char charset;
		
		do {
			if(!back) {
				System.out.println("\n <C> Criar \n <I> Buscar apenas um \n <F> "
						+ "Buscar todos \n <D> Deletar \n <U> Atualizar \n <S> Sair");
				comand = input.nextLine().toUpperCase();
			}else {
				System.out.println("<V> Voltar");
				comand = input.nextLine().toUpperCase();
			}
		
			charset = comand.charAt(0);
			
			switch(charset) {
				case 'C':
					back = true;
					user.setName("Matheus");
					user.setYearsOld(22);
					user.setDate(new Date());
					DAO.create(user);
					
					System.out.println(
							"\n nome: " + user.getName() +
							"\n idade: " + user.getYearsOld() +
							"\n data: " + user.getDate());
					break;
				case 'I': 
					back = true;
					Contact findId = DAO.findId(3);
					System.out.println(
							"\n id: " + findId.getId() +
							"\n Nome: " + findId.getName() + 
							"\n Idade: " + findId.getYearsOld() + 
							"\n Data: " + findId.getDate()
						);
					break;
				case 'F':
					back = true;
					for(Contact c: DAO.findAll() ) {
						System.out.println(
								"\n Nome: " + c.getName() + 
								"\n Idade: " + c.getYearsOld() + 
								"\n Data: " + c.getDate()
							);
					}
					break;
				case 'D': 
					back = true;
					user.setId(5);
					Contact delete = DAO.findId(user.getId());
					DAO.delete(user);
					System.out.println(
							"\n Nome: " + delete.getName() +
							"\n Idade: " + delete.getYearsOld() +
							"\n Data: " + delete.getDate()
							);
					break;
				case 'U': 
					back = true;
					user.setName("Matheus");
					user.setYearsOld(22);
					user.setDate(new Date());
					user.setId(4);
					DAO.update(user);
					
					System.out.println(
							"\n Nome: " + user.getName() +
							"\n Idade: " + user.getYearsOld() +
							"\n Data: " + user.getDate()
						);
					
					break;
				case 'V': 
					back = false;
					break;
				case 'S': 
					back = false;
					System.out.println("Sair");
			}
		}while(charset != 'S');

	}
}
