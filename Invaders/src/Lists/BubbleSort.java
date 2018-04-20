package Lists;

public class BubbleSort <T extends Comparable <T>> {


	public  void bubbleSort(CircularList<T> list ) {

		if (list.getLarge() > 1) {

			for (int i = 0; i < list.getLarge(); i++ ) {

				Nodo <T> temp1 = list.getHead();
				Nodo <T> next = list.getHead().getNext();
				for (int j = 0; j < list.getLarge() - 1; j++) {

					if (temp1.getDato().compareTo(next.getDato()) == 1) {
						T temp2 = temp1.getDato();
						temp1.setDato(next.getDato());
						next.setDato(temp2);

					} 

					temp1 = next;
					next = next.getNext();   
				}
			}
		}
	}
}