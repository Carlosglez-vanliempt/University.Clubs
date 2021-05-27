package Usuarios;

import java.util.HashMap;
public class ppal {
    public static void main (String args[]){
        HashMap <Integer,String> login = new HashMap<>();
        HashMap <Integer,Usuario > user = new HashMap<>();
        Usuario dani = new Usuario(22049209,"dani","blazquez","biologia","1234");
        dani.ModDAtos();
    }
}
