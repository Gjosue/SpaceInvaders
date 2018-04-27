package Lists;

public class CircularList <T>{
	private Nodo<T> head;
	private Nodo<T> tail;
	private int large;
	
	public CircularList(){
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
			this.tail.setNext(head);
			this.head.setPrev(tail);
		}else{
			Nodo<T> temp = this.tail;
			temp.setNext(new Nodo<T>(dato));
			this.tail = temp.getNext();
			this.tail.setNext(head);
			this.head.setPrev(tail);
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
			this.tail.setNext(head);
			this.head.setPrev(tail);
			large --;
		}else{
			while(nodo.getNext()!= head){
				if(nodo.getNext().getDato() == dato){
					nodo.setNext(nodo.getNext().getNext());
					nodo.getNext().setPrev(nodo);
					large --;
					if(nodo.getNext() == head){
						this.tail = nodo;
						this.tail.setNext(head);
					}
					break;
				}else{
					nodo = nodo.getNext();
				}
			}
		}
	}
	
	public void deleteAll() {
		this.head.setNext(null);
		this.head.setPrev(null);
		this.head = null;
		this.setLarge(0);
	}
	
	/**
	 * Matodo para imprimir la lista
	 */
	public void printList(){
		Nodo<T> actual = this.head;
		System.out.println(actual.getDato());
		actual = actual.getNext();
		while(actual != head){
			System.out.println(actual.getDato());
			actual = actual.getNext();
		}
		System.out.println(actual.getDato());
		actual = actual.getNext();
		System.out.println(actual.getDato());
	}
	
	public Nodo<T> getNodo(int i) {
		int cont = 0;
		Nodo<T> temp = this.head;
		while(cont < i) {
			temp = temp.getNext();
			cont ++;
		}
		return temp;
	}
}
