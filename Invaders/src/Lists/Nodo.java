package Lists;

public class Nodo <T> {
	
	protected Nodo<T> next;
	protected Nodo<T> prev;
	protected T dato;
	
	public Nodo(T dato){
		this.dato = dato;
		this.next = null;
		this.prev = null;
	}
	/**
	 * Getters and setters
	 * @return
	 */
	public Nodo<T> getNext() {
		return next;
	}
	public void setNext(Nodo<T> next) {
		this.next = next;
	}
	public Nodo<T> getPrev() {
		return prev;
	}
	public void setPrev(Nodo<T> prev) {
		this.prev = prev;
	}
	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
}
