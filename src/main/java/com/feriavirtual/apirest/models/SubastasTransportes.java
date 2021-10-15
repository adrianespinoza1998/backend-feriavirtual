package com.feriavirtual.apirest.models;

public class SubastasTransportes {
	
    private int idSubastasTr;
    private int idSubastas;
    private int idTransporte;
    
    public SubastasTransportes() {
    	
    }

	public int getIdSubastasTr() {
		return idSubastasTr;
	}

	public void setIdSubastasTr(int idSubastasTr) {
		this.idSubastasTr = idSubastasTr;
	}

	public int getIdSubastas() {
		return idSubastas;
	}

	public void setIdSubastas(int idSubastas) {
		this.idSubastas = idSubastas;
	}

	public int getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}

	@Override
	public String toString() {
		return "SubastasTransportes{" +
				"idSubastasTr=" + idSubastasTr +
				", idSubastas=" + idSubastas +
				", idTransporte=" + idTransporte +
				'}';
	}
}
