package com.hotel.interfaz;

import java.awt.event.ActionEvent;


public class ConfirmarDatos extends Confirmar {
    private static final long serialVersionUID = -792638974716873679L;
    
    public ConfirmarDatos() {
        super("Datos ingresados con Éxito");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==super.bnt1) {
            SistemaReserva rese = new SistemaReserva();
			rese.iniciar();
			this.setVisible(false);
        }
        if(e.getSource()==super.bnt2) {
            this.setVisible(false);
        }
    }
}	