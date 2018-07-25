package com.bst.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

import org.json.JSONArray;
import org.json.JSONObject;

public class LlamadasController{
	

// HTTP GET request
public void sendGet() throws Exception {

	String url = "http://10.1.14.249/api/query_incoming_sms?flag=read";
	
	URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();

	// optional default is GET
	con.setRequestMethod("GET");
	con.setRequestProperty("Authorization","Basic R0lOWFRJOjYxTng3MQ==");
	//add request header
	//con.setRequestProperty("User-Agent", USER_AGENT);

	int responseCode = con.getResponseCode();
	System.out.println("\nSending 'GET' request to URL : " + url);
	System.out.println("Response Code : " + responseCode);

	BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();

	//print result
	System.out.println(response.toString());

}

// HTTP POST request
@SuppressWarnings("restriction")
public void sendPost() throws Exception {
	
	JSONObject objeto = new JSONObject();
	objeto.put("text","prueba");
	
	JSONObject objeto2 = new JSONObject();
	objeto2.put("number","5530690093");
	
	String[] llamada = new String[1];
	llamada[0]="hola";
	objeto2.put("text_param", llamada);
	objeto2.put("user_id", 0);
	
	JSONArray arreglo = new JSONArray();
	arreglo.put(objeto2);
	
	objeto.put("param", arreglo);
	objeto.put("port", 0);
	System.out.println("prueba"+objeto.toString());
	String loginPassword = "vitelso"+ ":" + "v173150";
	String encoded = new Base64().encodeToString(loginPassword.getBytes());
	System.out.println(encoded);
	URL url = new URL("http://10.1.14.249/api/send_sms");
	
	HttpURLConnection con = (HttpURLConnection) url.openConnection();

	con.setRequestMethod("POST");
	con.setRequestProperty("Content-Type", "application/json");
	con.setRequestProperty ("Authorization", "Basic " + encoded);

	con.setDoOutput(true);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	wr.writeBytes(objeto.toString());
	wr.flush();
	wr.close();

	int responseCode = con.getResponseCode();
	System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + objeto.toString());
	System.out.println("Response Code : " + responseCode);

	BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();
	
	//print result
	System.out.println(response.toString());
	}

@SuppressWarnings("restriction")
public void sendMensajeRegistro(String nombre, String telefono,int numero) throws Exception {
	
	JSONObject objeto = new JSONObject();
	String mensaje =nombre+"Bienvenido a Innovacción. Descarga la app oficial,\" Tu código de acceso es "+numero+": IOS https://goo.gl/WDwbLW  Android https://goo.gl/QTctEW" ;
	objeto.put("text",mensaje);
	String numeroenvio = String.valueOf(telefono);
	JSONObject objeto2 = new JSONObject();
	objeto2.put("number", numeroenvio);
	
	String[] llamada = new String[1];
	llamada[0]="hola";
	objeto2.put("text_param", llamada);
	objeto2.put("user_id", 0);
	
	JSONArray arreglo = new JSONArray();
	arreglo.put(objeto2);
	
	objeto.put("param", arreglo);
	objeto.put("port", 0);
	System.out.println("prueba"+objeto.toString());
	String loginPassword = "GINXTI"+ ":" + "61nX71";
	String encoded = new Base64().encodeToString(loginPassword.getBytes());
	System.out.println(encoded);
	URL url = new URL("http://10.1.14.249/api/send_sms");
	
	HttpURLConnection con = (HttpURLConnection) url.openConnection();

	con.setRequestMethod("POST");
	con.setRequestProperty("Content-Type", "application/json");
	con.setRequestProperty ("Authorization", "Basic " + encoded);

	con.setDoOutput(true);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	wr.writeBytes(objeto.toString());
	wr.flush();
	wr.close();

	int responseCode = con.getResponseCode();
	System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + objeto.toString());
	System.out.println("Response Code : " + responseCode);

	BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();
	
	//print result
	System.out.println(response.toString());
	}

}


