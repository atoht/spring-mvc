package testMVC.org;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ListDataModeSerice implements IListDataModelSerice {
	
	public List<String> getList() {
		List<String> listStr = new ArrayList<String>();
		listStr.add("Windows");
		listStr.add("Mac");
		listStr.add("linux");
		
		return listStr;
	}

	/* (non-Javadoc)
	 * @see testMVC.org.IListDataModelSerice#getListDataModel()
	 */
	@Override
	public List<ListDataModel> getListDataModel() {
		List<ListDataModel> listLDM = new ArrayList<ListDataModel>();
		listLDM.add(new ListDataModel("一", "ONE"));
		listLDM.add(new ListDataModel("二", "TWO"));
		listLDM.add(new ListDataModel("三", "THREE"));
		listLDM.add(new ListDataModel("四", "FOUR"));
		return listLDM;
	}
}
