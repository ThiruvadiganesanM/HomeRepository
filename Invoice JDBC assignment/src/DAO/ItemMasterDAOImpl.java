package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.ItemMasterDTO;

public class ItemMasterDAOImpl implements ItemMasterDAO{
	Connection con; ResultSet rs; PreparedStatement pstmt;
	public ItemMasterDAOImpl(Connection con) {
		this.con=con;
	}
	@Override
	public ItemMasterDTO findItemMasterByItemId(int itemId) throws SQLException {
		pstmt=con.prepareStatement("select * from Item_Master where item_id=?");
		pstmt.setInt(1, itemId);
		rs=pstmt.executeQuery();
		ItemMasterDTO imd=new ItemMasterDTO();
		if(rs.next()) {
			imd.setItem_id(rs.getInt(1));
			imd.setItem_name(rs.getString(2));
			imd.setUnit(rs.getString(3));
			imd.setPrice(rs.getFloat(4));
		//	imd.setImage();
		}
		con.close();rs.close();
		return imd;
	}

	@Override
	public ItemMasterDTO findItemMasterByItemName(String itemName) throws SQLException {
		pstmt=con.prepareStatement("select * from Item_Master where item_name=?");
		pstmt.setString(1, itemName);
		rs=pstmt.executeQuery();
		ItemMasterDTO imd=new ItemMasterDTO();
		if(rs.next()) {
			imd.setItem_id(rs.getInt(1));
			imd.setItem_name(rs.getString(2));
			imd.setUnit(rs.getString(3));
			imd.setPrice(rs.getFloat(4));
		//	imd.setImage();
		}
		con.close();rs.close();
		return imd;
	}

	@Override
	public List<ItemMasterDTO> findAll() {
	try {
		pstmt=con.prepareStatement("select * from Item_Master");
		rs=pstmt.executeQuery();
		ArrayList<ItemMasterDTO> list=new ArrayList<>();
		while(rs.next()) {
			ItemMasterDTO imd=new ItemMasterDTO();
			imd.setItem_id(rs.getInt(1));
			imd.setItem_name(rs.getString(2));
			imd.setUnit(rs.getString(3));
			imd.setPrice(rs.getFloat(4));
			//imd.setImage(rs.get)
			list.add(imd);
		}
		con.close();rs.close();
		return list;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	}

	@Override
	public int addItemMaster(ItemMasterDTO imd) {
		try {
			pstmt=con.prepareStatement("insert into Item_master values(?,?,?,?,?)");
			pstmt.setInt(1, imd.getItem_id());
			pstmt.setString(2, imd.getItem_name());
			pstmt.setString(3, imd.getUnit());
			pstmt.setFloat(4, imd.getPrice());
			//pstmt.setImage();
			int nori=pstmt.executeUpdate();
			con.close();rs.close();
			return nori;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int updateItemMaster(ItemMasterDTO imd) {
		try {
			pstmt=con.prepareStatement("update Item_master set item_id=?, item_name=?, unit=?, price=?, image=? ");
			pstmt.setInt(1, imd.getItem_id());
			pstmt.setString(2, imd.getItem_name());
			pstmt.setString(3, imd.getUnit());
			pstmt.setFloat(4, imd.getPrice());
		//	pstimt.setImage(5,imd.)
			
			int noru=pstmt.executeUpdate();
			con.close();rs.close();
			return noru;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteItemMaster(int itemId) {
		try {
			pstmt=con.prepareStatement("delete Item_master where item_id=?");
			pstmt.setInt(1, itemId);
			int nord=pstmt.executeUpdate();
			con.close();rs.close();
			return nord;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

}
