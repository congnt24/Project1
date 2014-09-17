package application;

import javafx.beans.property.SimpleIntegerProperty;

public class TableHangHoa {
	private SimpleIntegerProperty mahanghoa;

	public int getMahanghoa() {
		return mahanghoa.get();
	}

	public void setMahanghoa(SimpleIntegerProperty mahanghoa) {
		this.mahanghoa = mahanghoa;
	}

	public TableHangHoa(int mahanghoa) {
		this.mahanghoa = new SimpleIntegerProperty(mahanghoa);
	}
	
	
	

	
}
