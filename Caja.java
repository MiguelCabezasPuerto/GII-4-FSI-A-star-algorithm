package storagehouse;

public class Caja {

	private int id, diaEntrada, diaSalida;
	
	public Caja(int id, int diaEntrada, int diaSalida) {
		this.id = id;
		this.diaEntrada = diaEntrada;
		this.diaSalida = diaSalida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDiaEntrada() {
		return diaEntrada;
	}

	public void setDiaEntrada(int diaEntrada) {
		this.diaEntrada = diaEntrada;
	}

	public int getDiaSalida() {
		return diaSalida;
	}

	public void setDiaSalida(int diaSalida) {
		this.diaSalida = diaSalida;
	}
	
    public Caja clone() throws CloneNotSupportedException {
        return new Caja(this.id, this.diaEntrada, this.diaSalida);
    }
	
    public boolean equals(Caja caja) {
        return (this.getDiaEntrada() == caja.getDiaEntrada() && this.getDiaSalida() == caja.getDiaSalida());
    }
}