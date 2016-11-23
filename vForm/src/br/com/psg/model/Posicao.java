package br.com.psg.model;

public class Posicao {
 String [] posicoes = {"A", "B", "C"};
 Posicao posi;
 
 public Posicao() {
	 posi = new Posicao();
}

 int next = 0;
 
 String getPos(int pos){
	 if(next == pos){
		 return posicoes[pos];
	 }else{
		 next ++;
		return posi.getPos(pos);
	 }

 }
 
 public static void main(String[] args) {
	Posicao pos = new Posicao();
	String posicao = pos.getPos(0);
	System.out.println(posicao);
}
}
