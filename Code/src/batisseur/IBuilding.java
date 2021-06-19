package batisseur;

import java.util.ArrayList;

public interface IBuilding {
	public ArrayList<IWorker> getWorkerOn();
	public void addWorkerOn(IWorker worker);
	public void removeWorkerOn(IWorker worker);
	public int getPoint();
	public int getCoin();
	public void setPoint(int point);
	public int[] checkRessources();
	public boolean isConstruct();
	public String toStringValue();
}