package com.websocket.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.websocket.model.ThietBi;
import com.websocket.service.ThietBiService;

@ServerEndpoint("/realtime-data")
public class RealTime {
	static Set<Session> users = Collections.synchronizedSet(new HashSet<>());
	ThietBiService thietbiService;	
	public RealTime() {
		thietbiService = new ThietBiService();
	}
	@OnOpen
	public void handleOpen(Session session) {
		users.add(session);
		List<ThietBi> list = thietbiService.getAll();
		ObjectMapper mapper = new ObjectMapper();
		String value;
		try {
			value = mapper.writeValueAsString(list);
			session.getBasicRemote().sendText(value);
			session.getBasicRemote().sendText(value);
			session.getBasicRemote().sendText(value);
			System.out.println("hehhe");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException
	{
		System.out.println("kkakakak");
		ObjectMapper mapper = new ObjectMapper();
		ThietBi thietbi = mapper.readValue(message, ThietBi.class);
		System.out.println(thietbi.getTen()+"-"+thietbi.getThoigianmo()+"-"+thietbi.getThoigiantat());
		String value = null;
		if(thietbi.getTen().contains("chedo"))
		{
			List<ThietBi> result = thietbiService.updateMod(thietbi);
			value = mapper.writeValueAsString(result);
		}
		else
		{
			
			List<ThietBi> result = thietbiService.update(thietbi);
			value = mapper.writeValueAsString(result);
		}
		System.out.println(value);
		if(value != null)
		{
			for (Session session : users) {
		        session.getBasicRemote().sendText(value);
		     }
		}		
		else
			userSession.getBasicRemote().sendText("null");
	}
	@OnClose
	  public void handleClose(Session userSession) {
		users.remove(userSession);
	    System.out.println("Client is now disconnected!");
	 }
	@OnError
	 public void handleError(Throwable t) {
	    t.printStackTrace();
	  
	}

}
