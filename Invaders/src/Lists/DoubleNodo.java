package Lists;

public class DoubleNodo<T>{
	
	private DoubleNodo<T> next;
	private DoubleNodo<T> prev;
	private T dato;
	public int ID;

	
	public DoubleNodo(T dato, int ID) {
		this.dato = dato;
		this.next = null;
		this.prev = null;
		this.ID = ID;
	}

	public DoubleNodo<T> getNext() {
		return next;
	}

	public void setNext(DoubleNodo<T> next) {
		this.next = next;
	}

	public DoubleNodo<T> getPrev() {
		return prev;
	}

	public void setPrev(DoubleNodo<T> prev) {
		this.prev = prev;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	

}
