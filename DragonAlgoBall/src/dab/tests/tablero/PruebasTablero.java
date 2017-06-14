package dab.tests.tablero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import dab.dragonBallExceptions.MovimientoInvalido;
import dab.estados.gohan.GohanBase;
import dab.estados.goku.GokuBase;
import dab.juego.Tablero;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
public class PruebasTablero{

	@Test
	public void testCoordenadasDelPersonajeCorrectasAlPosicionarEnTablero() {
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(goku, 5, 6);
		assertEquals(tableroDab.filaPersonaje(goku), 5);
		assertEquals(tableroDab.columnaPersonaje(goku), 6);
		
	}
	@Test
	public void testCoordenadasActualizadasAlMoverPersonaje(){ 
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(goku, 5, 6);
		tableroDab.colocarPersonaje(goku, 4, 5);
		assertEquals(tableroDab.filaPersonaje(goku), 4);
		assertEquals(tableroDab.columnaPersonaje(goku), 5);
	}
	@Test
	public void testCeldaAnteriorQuedaLibreAlMoverPersonaje(){ 
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(goku, 5, 6);
		tableroDab.moverPersonaje(goku, 4, 5);
		assertFalse(tableroDab.celdaOcupada(5, 6));
	}

	@Test
	public void testPersonajePuedeMoverseEnSentidoHorizontalHastaSuAlcanceMaximo(){ 
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(goku, 5, 6);
		tableroDab.colocarPersonaje(goku, 5 + goku.getVelocidad(), 6);
		assertEquals(tableroDab.filaPersonaje(goku), 5+ goku.getVelocidad());
		assertEquals(tableroDab.columnaPersonaje(goku), 6);
	}
	
	@Test
	public void testPersonajePuedeMoverseEnSentidoVerticalHastaSuAlcanceMaximo(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(goku, 5, 6);
		tableroDab.colocarPersonaje(goku, 5, 6 + goku.getVelocidad());
		assertEquals(tableroDab.filaPersonaje(goku), 5);
		assertEquals(tableroDab.columnaPersonaje(goku), 6 + goku.getVelocidad());
	}
	@Test
	public void testPersonajePuedeMoverseEnSentidoDiagonalHastaSuAlcanceMaximo(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(goku, 5, 6);
		tableroDab.colocarPersonaje(goku, 5 + ((int)(goku.getVelocidad())), 6 + ((int)(goku.getVelocidad())));
		assertEquals(tableroDab.filaPersonaje(goku), 5 + ((int)(goku.getVelocidad())));
		assertEquals(tableroDab.columnaPersonaje(goku), 6 + ((int)(goku.getVelocidad())));
	}
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeHorizontalMayorQueAlcanceLanzaMovimientoInvalido(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(goku, 5, 6);
		
		tableroDab.moverPersonaje(goku, 5 + goku.getVelocidad() + 1, 6);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeVerticalMayorQueAlcanceLanzaMovimientoInvalido(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(goku, 5, 6);
		tableroDab.moverPersonaje(goku, 5, 6 + goku.getVelocidad() + 1);
	}
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeDiagonalMayorAlcanceMaximoLanzaMovimientoInvalido(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(goku, 5, 6);
		tableroDab.moverPersonaje(goku, 5 + 1 + ((int)(goku.getVelocidad())), 6 + ((int)(goku.getVelocidad())));
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeSobrepasandoOtroLanzaError(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		tableroDab.colocarPersonaje(goku, 5, 6);
		tableroDab.colocarPersonaje(gohan, 6, 6);
		tableroDab.moverPersonaje(goku, 7 , 6);
		//para que funcione falta la funcion de existeCamino
		
	}
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeSobrepasandoOtroDiagonalLanzaError(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		tableroDab.colocarPersonaje(goku, 5, 7);
		tableroDab.colocarPersonaje(gohan, 6, 6);
		tableroDab.colocarPersonaje(goku,7,5);
	}
	
}
