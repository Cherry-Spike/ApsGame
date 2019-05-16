package model.window;

import java.util.ArrayList;
import java.util.List;


public class WindowList {
	
	private List<CityLastLightWindow> Windowlist;	
	JanelaTripla w1, w2, w3, w4, w5, w6, w7, w8, w9, w10;
	JanelaAp w11, w12, w13, w14, w15, w16, w17, w18, w19, w20;
	JanelaAntiga w21, w22, w23;
	JanelaAntigaPerspectiva w24, w25, w26;
	JanelaMuseu w27, w28, w29, w30, w31, w32;
	JanelaVidroModerna w33, w34, w35;
	JanelaCafe w36;
	VitrineCafe w37;
	
	public WindowList() {
		
		CreateWindowList();
		
	}
	
	public void CreateWindowList(){
		
		Windowlist = new ArrayList<CityLastLightWindow>();

		w1 = new JanelaTripla(106,297);
		w2 = new JanelaTripla(106,361);
		w3 = new JanelaTripla(106,425);
		w4 = new JanelaTripla(106,489);
		w5 = new JanelaTripla(106,553);
		w6 = new JanelaTripla(187,297);
		w7 = new JanelaTripla(187,361);
		w8 = new JanelaTripla(187,425);
		w9 = new JanelaTripla(187,489);
		w10 = new JanelaTripla(187,553);
		w11 = new JanelaAp(286,168);
		w12 = new JanelaAp(286,247);
		w13 = new JanelaAp(286,331);
		w14 = new JanelaAp(286,413);
		w15 = new JanelaAp(286,492);
		w16 = new JanelaAp(424,168);
		w17 = new JanelaAp(424,247);
		w18 = new JanelaAp(424,331);
		w19 = new JanelaAp(424,413);
		w20 = new JanelaAp(424,492);	
		w21 = new JanelaAntiga(8,357);	
		w22 = new JanelaAntiga(8,420);	
		w23 = new JanelaAntiga(8,484);	
		w24 = new JanelaAntigaPerspectiva(57,351);	
		w25 = new JanelaAntigaPerspectiva(58,415);	
		w26 = new JanelaAntigaPerspectiva(58,478);	
		w27 = new JanelaMuseu(521,282);	
		w28 = new JanelaMuseu(521,377);	
		w29 = new JanelaMuseu(521,472);	
		w30 = new JanelaMuseu(611,282);	
		w31 = new JanelaMuseu(610,377);	
		w32 = new JanelaMuseu(610,472);
		w33 = new JanelaVidroModerna(698,281);
		w34 = new JanelaVidroModerna(698,429);
		w35 = new JanelaVidroModerna(808,355);
		w36 = new JanelaCafe(740,496);
		w37 = new VitrineCafe(730,608);
		
		Windowlist.add(w1);
		Windowlist.add(w2);
		Windowlist.add(w3);
		Windowlist.add(w4);
		Windowlist.add(w5);
		Windowlist.add(w6);
		Windowlist.add(w7);
		Windowlist.add(w8);
		Windowlist.add(w9);
		Windowlist.add(w10);
		Windowlist.add(w11);
		Windowlist.add(w12);
		Windowlist.add(w13);
		Windowlist.add(w14);
		Windowlist.add(w15);
		Windowlist.add(w16);
		Windowlist.add(w17);
		Windowlist.add(w18);
		Windowlist.add(w19);
		Windowlist.add(w20);
		Windowlist.add(w21);
		Windowlist.add(w22);
		Windowlist.add(w23);
		Windowlist.add(w24);
		Windowlist.add(w25);
		Windowlist.add(w26);
		Windowlist.add(w27);
		Windowlist.add(w28);
		Windowlist.add(w29);
		Windowlist.add(w30);
		Windowlist.add(w31);
		Windowlist.add(w32);
		Windowlist.add(w33);
		Windowlist.add(w34);
		Windowlist.add(w35);
		Windowlist.add(w36);
		Windowlist.add(w37);
		
	}
	
	public List<CityLastLightWindow> GetWindowList() {
		return Windowlist;
	}
	
}
