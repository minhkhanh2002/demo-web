

package dao;

import entity.Account;
import entity.Catalog_id;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;

 
public class DAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

//lấy danh sách tất cả sản phẩm
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		String query = "SELECT * FROM product";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getInt(2),
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5),
						rs.getDouble(6), 
						rs.getString(7), 
						rs.getInt(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
		
}
	
	//lấy danh mục các sản phẩm
	public List<Catalog_id> getAllCatalog_id() {
		List<Catalog_id> list = new ArrayList<>();
		String query = "SELECT * FROM catalog";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Catalog_id(rs.getInt(1),
						rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
		
}
	//load sản phẩm theo danh mục
	public List<Product> getProductByCID(String cateID) {
		List<Product> list = new ArrayList<>();
		String query = "SELECT * FROM product\r\n"
				+ "WHERE catalog_id = ? ";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			ps.setString(1, cateID);
			while(rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getInt(2),
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5),
						rs.getDouble(6), 
						rs.getString(7), 
						rs.getInt(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
}
	//lấy sản phẩm theo id
	public Product getProductByID(String id) {
		String query = "SELECT * FROM product\r\n"
				+ "WHERE id = ? ";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			ps.setString(1, id);
			while(rs.next()) {
				return new Product(rs.getInt(1),
						rs.getInt(2),
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5),
						rs.getDouble(6), 
						rs.getString(7), 
						rs.getInt(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
}
	//search sản phẩm
	public List<Product> searchByName() {
		List<Product> list = new ArrayList<>();
		String query = "SELECT * FROM product\n"
				+"WHERE name LIKE ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,"%"+txtSearch+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getInt(2),
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5),
						rs.getDouble(6), 
						rs.getString(7), 
						rs.getInt(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
		
}
	
	//login
	public Account login(String username, String password) {
		String query ="SELECT * FROM `user`\r\n"
				+ "WHERE username = ?\r\n"
				+ "AND `password`= ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,username);
			ps.setString(2,password);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), 
						rs.getString(2),
						rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		List<Product> list = dao.getAllProduct();
		List<Catalog_id> listC = dao.getAllCatalog_id();
		for (Product o : list) {
			System.out.println(o);
			
			
		}
	}

	public Product getLast() {
		// TODO Auto-generated method stub
		return null;
	}
	
}







