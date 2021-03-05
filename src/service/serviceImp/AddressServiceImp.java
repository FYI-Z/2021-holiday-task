package service.serviceImp;


import java.util.ArrayList;


import dao.AddressDao;
import entity.AddressEntity;


public class AddressServiceImp {
	AddressEntity addressunity = new AddressEntity();
	AddressDao addressDao = new AddressDao();
	
	public ArrayList<AddressEntity> showAddress(){
		ArrayList<AddressEntity> list=addressDao.showAddress(addressunity);
		return list;
	}
	
	public AddressEntity updataAddress(String userid,int addressid, String name , String phone, String address) {
		addressunity.setAddress(address);
		addressunity.setAddressid(addressid);
		addressunity.setName(name);
		addressunity.setPhone(phone);
		addressunity.setUserid(userid);
		addressunity = addressDao.updataAddress(addressunity);
		return addressunity;
	}
	
	public ArrayList<AddressEntity> findGoodsId(String userid) {
		addressunity.setUserid(userid);
		ArrayList<AddressEntity> list=addressDao.findGoodsId(addressunity);
		return list;
	}
	
	public AddressEntity deleteAddress(int addressid) {
		addressunity.setAddressid(addressid);
		addressunity = addressDao.deleteAddress(addressunity);
		return addressunity;
	}
	
	public AddressEntity addAddress(String userid,String name,String phone,String address) {
		addressunity.setAddress(address);
		addressunity.setUserid(userid);
		addressunity.setName(name);
		addressunity.setPhone(phone);
		addressunity=addressDao.addAddress(addressunity);
		return addressunity;
	}
}
