package co.edu.uco.tiendaonline.service.domain;

public interface ValidationRule<T> {
	void validator(T dato);
}
