package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.AddressEntity;
import util.DBUtil;
import util.SQLConstant;


public class AddressDao {
	private static PreparedStatement st = null;
	private static ResultSet rs = null;
	String sql = "";
	int count = 0;
	public static int Number = 0;
	public ArrayList<AddressEntity> showAddress(AddressEntity addressEntity){
		ArrayList<AddressEntity> list = new ArrayList<AddressEntity>();
		sql=SQLConstant.Show_Address;
		try {
			st=DBUtil.getPreparedStatement(sql);
			rs=st.executeQuery();
			Number=0;
			while(rs.next()) {
				addressEntity = new AddressEntity();
				addressEntity.setAddressid(rs.getInt("addressid"));
				addressEntity.setUserid(rs.getString("userid"));
				addressEntity.setName(rs.getString("name"));
				addressEntity.setPhone(rs.getString("phone"));
				addressEntity.setAddress(rs.getString("address"));
				Number++;
				list.add(addressEntity);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public AddressEntity updataAddress(AddressEntity addressEntity) {
		sql=SQLConstant.Undata_Address;
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setString(1, addressEntity.getUserid());
			st.setString(2, addressEntity.getName());
			st.setString(3, addressEntity.getPhone());
			st.setString(4, addressEntity.getAddress());
			st.setInt(5, addressEntity.getAddressid());
			
			count=st.executeUpdate();
			if(count>0) {
				addressEntity.setStatus("修改成功");
			}
			else {
				addressEntity.setStatus("修改失败");
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			addressEntity.setStatus("修改失败");
		}
		return addressEntity;
	}
	
	public ArrayList<AddressEntity> findGoodsId(AddressEntity addressEntity){
		ArrayList<AddressEntity> list = new ArrayList<AddressEntity>();
		sql=SQLConstant.Find_Address;
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setString(1, addressEntity.getUserid());
			String userid = addressEntity.getUserid();
			rs=st.executeQuery();
			Number=0;
			while(rs.next()) {
				addressEntity = new AddressEntity();
				addressEntity.setUserid(userid);
				addressEntity.setAddressid(rs.getInt("addressid"));
				addressEntity.setName(rs.getString("name"));
				addressEntity.setPhone(rs.getString("phone"));
				addressEntity.setAddress(rs.getString("address"));
				Number++;
				list.add(addressEntity);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public AddressEntity deleteAddress(AddressEntity addressEntity) {
		sql= SQLConstant.Delete_Address;
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setInt(1, addressEntity.getAddressid());
			count=st.executeUpdate();
			if(count>0) {
				
				addressEntity.setStatus("删除成功");
			}
			else {
				
				addressEntity.setStatus("删除失败");
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressEntity;
	}
	
	public AddressEntity addAddress(AddressEntity addressEntity) {
		sql=SQLConstant.Inser_Address;
		try {
			st=DBUtil.getPreparedStatement(sql);
			st.setString(1, addressEntity.getUserid());
			st.setString(2, addressEntity.getName());
			st.setString(3, addressEntity.getPhone());
			st.setString(4, addressEntity.getAddress());
			
			count=st.executeUpdate();
			if (count>0) {
				System.out.println("增加地址成功");
			}
			else {
				System.out.println("增加失败");
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressEntity;
	}
}
