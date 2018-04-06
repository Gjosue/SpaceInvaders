package Lists;

public class CircularDouble <T>{
	private Nodo<T> head;
	private Nodo<T> tail;
	private int large;
	public CircularDouble(){
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
			temp.getNext().setPrev(temp);
			this.tail = temp.getNext();
			this.head.setPrev(tail);
			this.tail.setNext(head);
		}
	}
	/**
	 * Metodo para borrar datos
	 * @param dato
	 */
	public void delete(T dato){
		Nodo<T> nodo = this.head;
		if(nodo.getDato() == dato){
			if(nodo.getNext() == head){
				nodo.setNext(null);
				nodo.setPrev(null);
			}else{
				this.head = nodo.getNext();
				nodo.getNext().setPrev(tail);
				this.tail.setNext(head);
			}
		}else{
			nodo = nodo.getNext();
			while(nodo != head){
				if(nodo.getDato() == dato){
					if(nodo.getNext() == head){
						nodo.getPrev().setNext(head);
						this.tail = nodo.getPrev();
						this.head.setPrev(tail);
					}else if(nodo.getNext() != head && nodo.getPrev() != tail){
						nodo.getPrev().setNext(nodo.getNext());
						nodo.getNext().setPrev(nodo.getPrev());
					}
					break;
				}else{
					nodo = nodo.getNext();
				}
			}
		}
		
	}
	/**
	 * Metodo para imprimir la lista
	 */
	public void printList(){
		Nodo<T> actual = this.head;
		System.out.println(actual.getDato());
		actual = actual.getNext();
		while(actual != head){
			System.out.println(actual.getDato());
			actual = actual.getNext();
		}
	}
	 
}
