package DAO;

import java.sql.SQLException;
import java.util.List;

import DTO.ItemMasterDTO;

public interface ItemMasterDAO {
public ItemMasterDTO findItemMasterByItemId(int itemId) throws SQLException;
public ItemMasterDTO findItemMasterByItemName(String itemName) throws SQLException;
public List<ItemMasterDTO> findAll();
public int addItemMaster(ItemMasterDTO imd);
public int updateItemMaster(ItemMasterDTO imd);
public int deleteItemMaster(int itemId);
}
