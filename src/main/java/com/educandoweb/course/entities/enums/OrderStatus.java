package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

	private int code;

	private OrderStatus(int code) { // O construtor no enum sempre vai ser privado
		this.code = code;
	}

	public int getCode() { // Metodo int
		return code;
	}

	// Metodo statico para converter um valor numerico para um tipo enumerado
	public static OrderStatus valueOf(int code) { // Esse metodo statico vai funcionar sem eu precisar instanciar
		for (OrderStatus value : OrderStatus.values()) { // Percorrer todos os valores possiveis do OrderStatus
			if (value.getCode() == code) {// Para cada um deles vou testar se o valor é o codigo correspondente
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}