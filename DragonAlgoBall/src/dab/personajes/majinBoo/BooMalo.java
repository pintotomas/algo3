package dab.personajes.majinBoo;

import dab.personajes.Personaje;

public class BooMalo extends MajinBoo {

	public BooMalo(){
		vidaMaxima = 300;
		vida = vidaMaxima;
		poder = 50;
		alcance = 2;
		ki = 0;
		velocidad = 3;
		nombre = "Boo Malo";
		kiParaEspecial = 30;
		kiParaTransformar = 50;
	}
	
	
	@Override
	public Personaje transformar() {
		Personaje booOriginal = new BooOriginal();
		return booOriginal;
	}

}
