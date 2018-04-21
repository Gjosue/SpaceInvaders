package Lists;


public class DoublyLinked <T>{
	private Nodo<T> head;
	private Nodo<T> tail;
	private int large;
	public int positionEnemy;
	public int positionBoss;
	public int position;
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
					large --;
				}else if(nodo == head){
					if(nodo.getNext() == null){
						this.head = null;
						this.tail = null;
						large --;
					}else{
						this.head = nodo.getNext();
						nodo.getNext().setPrev(null);
						large --;
					}
				}else if(nodo != head && nodo.getNext() != null && nodo.getPrev() != null){
					nodo.getPrev().setNext(nodo.getNext());
					nodo.getNext().setPrev(nodo.getPrev());
					large --;
				}
				break;
			}else{
				nodo = nodo.getNext();
			}
		}
	}
	
	public void deleteAll() {
		this.head.setNext(null);
		this.head = null;
		this.setLarge(0);
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
	
	public T getNodo(int i) {
		int cont = 0;
		Nodo<T> temp = this.head;
		while(cont < i) {
			temp = temp.getNext();
			cont ++;
		}
		return temp.getDato();
	}
	
	public void search(T num) {
		position = 0;
		Nodo<T> temp = this.head;
		while(temp != null){
			if(temp.getDato() == num){
				if(temp == this.head) {
					System.out.println("El numero " + num + " esta en la posicion " + position);
					break;
				}else {
					System.out.println("El numero " + num + " esta en la posicion " + position);
					break;
				}
			}else {
				temp = temp.getNext();
				position ++;
			}
		}
	}
	
	 
}
