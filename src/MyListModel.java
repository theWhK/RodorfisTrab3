import javax.swing.AbstractListModel;
import java.util.List;
import java.util.LinkedList;

public class MyListModel<E> extends AbstractListModel<E> {
	List<E> lst;
	
	public MyListModel() {
		lst = new LinkedList<>();
	}
	
	@Override
	public E getElementAt(int index){
		return lst.get(index);
	}

	@Override
	public int getSize(){
		return lst.size();
	}
	
	public boolean add(E e){
		boolean ret = lst.add(e);
		fireIntervalAdded(e,lst.size(),lst.size());
		return ret;
	}
	
	public E remove(int index) {
		E ret = lst.remove(index);
		//TODO: testar se o indice está correto.
		fireIntervalRemoved(ret,index,index);
		return ret;
	}
}
