package es.deusto.ingeniaria.sd.strava.gateway;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.strava.remote.IGoogleServer;

public class GateWayGoogle {
	private static GateWayGoogle gateWay;
	private String[] args;
	private IGoogleServer googleServer;
	
	
	private GateWayGoogle() {
		try {
			String url = "//127.0.0.1:1099/CurrencyExchange";
			this.googleServer = (IGoogleServer) Naming.lookup(url); 
		} catch (Exception e) {
			System.err.println("Error : " + e);
		}
	}

	public void rmiGoogleServer() {
		try {
			this.googleServer.googleRmi();
		} catch (Exception e) {
			System.err.println("Error : " + e);
		}
	}
	
	public static GateWayGoogle getGateWay() {
		if(gateWay == null) {
			gateWay = new GateWayGoogle();
		}
		return gateWay;
	}
	
	
}
