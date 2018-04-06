package Lists;

public class LinkedList <T>{
	private Nodo<T> head;
	private Nodo<T> tail;
	private int large;
	public LinkedList(){
		this.head = null;
		this.tail = null;
		this.large = 0;
	}
	/**
	 * Getter and setters
	 * @return
	 */
	public Nodo<T> getHead() {
		return head;
	}
	public void setHead(Nodo<T> head) {
		this.head = head;
	}
	public Nodo<T> getTail() {
		return tail;
	}
	public void setTail(Nodo<T> tail) {
		this.tail = tail;
	}
	public int getLarge() {
		return large;
	}
	public void setLarge(int large) {
		this.large = large;
	}
	/**
	 * Metodo para añadir datos
	 * @param dato
	 */
	public void add(T dato){
		large ++;
		if(this.head == null){
			this.head = new Nodo<T>(dato);
			this.tail = head;
		}else{
			Nodo<T> temp = this.tail;
			temp.setNext(new Nodo<T>(dato));
			this.tail = temp.getNext();
		}
	}
	/**
	 * Metodo para eliminar datos
	 * @param dato
	 */
	public void delete(T dato){
		Nodo<T> nodo = this.head;
		if(nodo.getDato() == dato){
			this.head = nodo.getNext();
			large --;
		}else{
			while(nodo.getNext()!= null){
				if(nodo.getNext().getDato() == dato){
					nodo.setNext(nodo.getNext().getNext());
					large --;
					if(nodo.getNext() == null){
						this.tail = nodo;
					}
					break;
				}else{
					nodo = nodo.getNext();
				}
			}
		}
	}
	/**
	 * Matodo para imprimir la lista
	 */
	public void printList(){
		Nodo<T> actual = this.head;
		while(actual != null){
			System.out.println(actual.getDato());
			actual = actual.getNext();
		}
	}
}