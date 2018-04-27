package Lists;

import enemys.Boss;
import enemys.enemy;
import enemys.randomClass;

public class CircularList <T>{
	private DoubleNodo<T> head;
	private DoubleNodo<T> tail;
	private int large;
	public int positionEnemy;
	public int positionBoss;
	public int position;
	
	public CircularList(){
		this.head = null;
		this.tail = null;
		this.large = 0;
	}
	/**
	 * Getter and setters
	 * @return
	 */
	public DoubleNodo<T> getHead() {
		return head;
	}
	public void setHead(DoubleNodo<T> head) {
		this.head = head;
	}
	public DoubleNodo<T> getTail() {
		return tail;
	}
	public void setTail(DoubleNodo<T> tail) {
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
	public void add(T dato, int ID){
		large ++;
		if(this.head == null){
			this.head = new DoubleNodo<T>(dato, ID);
			this.tail = head;
			this.tail.setNext(head);
			this.head.setPrev(tail);
		}else{
			DoubleNodo<T> temp = this.tail;
			temp.setNext(new DoubleNodo<T>(dato, ID));
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
		DoubleNodo<T> nodo = this.head;
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
		DoubleNodo<T> actual = this.head;
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
	
	public DoubleNodo<T> getNodo(int i) {
		int cont = 0;
		DoubleNodo<T> temp = this.head;
		while(cont < i) {
			temp = temp.getNext();
			cont ++;
		}
		return temp;
	}
	
	public void search(int e) {
		position = 0;
		DoubleNodo<T> temp = this.head;
		while(temp != null){
			if(temp.ID == e){
				break;
			}else {
				temp = temp.getNext();
				position ++;
			}
		}
		if (randomClass.enemies1.getLarge() == position) {
			position = 0;
		}
	}
	
	public void change(int boss, int enemy) {
		search(boss);
		positionBoss = position;
		search(enemy);
		positionEnemy = position;
		enemy temp = randomClass.enemies1.getNodo(positionBoss).getDato();
		enemy temp1 = randomClass.enemies1.getNodo(positionEnemy).getDato();
		randomClass.enemies1.getNodo(positionEnemy).setDato(temp);
		randomClass.enemies1.getNodo(positionBoss).setDato(temp1);
		int n1 = temp.a;
		int n2 = temp1.a;
		int m1 = temp.b;
		int m2 = temp1.b;
		int x1 = temp.x;
		int x2 = temp1.x;
		int ID1 = temp.ID;
		int ID2 = temp.ID;
		temp.a = n2;
		temp1.a = n1;
		temp.b = m2;
		temp1.b = m1;
		temp.x = x2;
		temp1.x = x1;
		temp.ID = ID2;
		temp1.ID = ID1;
	}
}
