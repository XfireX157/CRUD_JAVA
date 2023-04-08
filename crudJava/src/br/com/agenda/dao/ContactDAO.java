package br.com.agenda.dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contact;

public class ContactDAO {
	public void create(Contact contact) {
		String sql = "INSERT INTO contatos (name, yearsOld, date) VALUES (?,?,?)";
		
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setInt(2, contact.getYearsOld());
			ps.setDate(3, new Date(contact.getDate().getTime()));
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Contact> findAll() {
		String sql = "SELECT * FROM contatos";

		List<Contact> contacts = new ArrayList<Contact>();
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getInt("idUser"));
				contact.setName(rs.getString("name"));
				contact.setYearsOld(rs.getInt("yearsOld"));
				contact.setDate(rs.getDate("date"));
		
				contacts.add(contact);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return contacts;
	}
	
	public Contact findId(int idUser) {
		String sql = "SELECT * FROM contatos WHERE idUser = ?";
		
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
			ps.setInt(1, idUser);
			ResultSet rs = ps.executeQuery();
			Contact contact = new Contact();
			
			if(rs.next()) {
				contact.setId(rs.getInt("idUser"));
				contact.setName(rs.getString("name"));
				contact.setYearsOld(rs.getInt("yearsOld"));
				contact.setDate(rs.getDate("date"));
				return contact;
			}else {
                return null;
            }
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void delete(Contact contact) {
		String sql = "DELETE FROM contatos WHERE idUser = ?";
		
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
			ps.setInt(1, contact.getId());
			
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Contact contact) {
		String sql = "UPDATE contatos SET name = ?, yearsOld = ?, date = ? WHERE idUser = ?";
		
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setInt(2, contact.getYearsOld());
			ps.setDate(3, new Date(contact.getDate().getTime()));
			ps.setInt(4, contact.getId());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
