package Lists;

public class DoublyLinked <T>{
	private Nodo<T> head;
	private Nodo<T> tail;
	private int large;
	public DoublyLinked(){
		this.head = null;
		this.tail = null;
		this.large = 0;
	}
	/**
	 * Getters and setters
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
	 * Matodo para añadir datos
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
			temp.getNext().setPrev(temp);
			this.tail = temp.getNext();
		}
	}
	/**
	 * Metodo para borrar datos
	 * @param dato
	 */
	public void delete(T dato){
		Nodo<T> nodo = this.head;
		while(nodo != null){
			if(nodo.getDato() == dato){
				if(nodo != head && nodo.getNext() == null){
					nodo.getPrev().setNext(null);
					this.tail = nodo.getPrev();
				}else if(nodo == head){
					if(nodo.getNext() == null){
						this.head = nodo.getNext();
						this.tail = nodo.getPrev();
					}else{
						this.head = nodo.getNext();
						nodo.getNext().setPrev(null);
					}
				}else if(nodo != head && nodo.getNext() != null && nodo.getPrev() != null){
					nodo.getPrev().setNext(nodo.getNext());
					nodo.getNext().setPrev(nodo.getPrev());
				}
				break;
			}else{
				nodo = nodo.getNext();
			}
		}
	}
	/**
	 * Metodo para imprimir la lista
	 */
	public void printList(){
		Nodo<T> actual = this.head;
		while(actual != null){
			System.out.println(actual.getDato());
			actual = actual.getNext();
		}
	}
	 
}
