package com.hotel.interfaz;

import java.awt.event.ActionEvent;


public class ConfirmarSalida extends Confirmar {
    private static final long serialVersionUID = -792638974716873679L;
    
    public ConfirmarSalida() {
        super("Confirmar la salida del Programa");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==super.bnt1) {
            System.exit(0);
        }
        if(e.getSource()==super.bnt2) {
            this.setVisible(false);
        }
    }
}	
	

