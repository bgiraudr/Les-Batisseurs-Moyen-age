package batisseur;

import java.util.ArrayList;

public interface IBuilding {
	public ArrayList<Card> getWorkerOn();
	public void addWorkerOn(IWorker worker);
	public void removeWorkerOn(IWorker worker);
	public int getPoint();
	public void setPoint(int point);
	public boolean checkConstruct();
}