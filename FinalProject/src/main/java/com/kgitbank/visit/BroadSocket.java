package com.kgitbank.visit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;



// WebSocket 호스트 설정
@ServerEndpoint("/broadsocket")
public class BroadSocket {
// 접속 된 클라이언트 WebSocket session 관리 리스트
	/*@Resource(name="ClientDAO")
	private ClientDAO ClientDAO;*/
	private static ArrayList<String> logClient=new ArrayList<String>();
	private String log1= new String();
	private String imsinick="";
	private static Integer count =new Integer(0);
	
	public static int getCount() {
		if(count==null) {
			count=0;
		}
		return count;
	}

	/*List<HttpSession> session1=VisitSessionListener.getSession1();*/
	private static List<Session> sessionUsers = Collections.synchronizedList(new ArrayList<>());
	
	// 메시지에서 유저 명을 취득하기 위한 정규식 표현
	private static Pattern pattern = Pattern.compile("^\\{\\{.*?\\}\\}");
	/*static Boolean runCheck =false;*/
	 
	public static ArrayList<String> getLogClient() {
		return logClient;
	}
	
	public static void setLogClient(ArrayList<String> logClient1) {
		logClient = logClient1;
	}
	
	

	
	// WebSocket으로 브라우저가 접속하면 요청되는 함수
@OnOpen
public void handleOpen(Session userSession) throws IOException {
	// 클라이언트가 접속하면 WebSocket세션을 리스트에 저장한다.
	// 콘솔에 접속 로그를 출력한다.
	sessionUsers.add(userSession);
	
	
	for (int i = 0; i < sessionUsers.size(); i++) {
			if (sessionUsers.get(i).equals(userSession)) {
				System.out.println((i+1)+"client is now connected...");
			}
	}
	
	if (logClient.size()<=0 ) {
		log1="없음";
		count=0;
	}
	else {
		log1= "";
		count=logClient.size();
		
		for (int i = 0; i < logClient.size(); i++) {
			if (i==0) {
				log1=Integer.toString(count)+"~";
			}
			log1+=logClient.get(i)+"~";
		}
		
	}
	
	
	System.out.println(log1);
	System.out.println(logClient.size());
	Matcher matcher = pattern.matcher(log1);
	// 클로져를 위해 변수의 상수화
	final String sss = log1.replaceAll(pattern.pattern(), "");
	
	// session관리 리스트에서 Session을 취득한다.
	sessionUsers.forEach(session -> {
		try {
			// 리스트에 있는 모든 세션(메시지 보낸 유저 제외)에 메시지를 보낸다. (형식: 유저명 => 메시지)
			session.getBasicRemote().sendText(sss);
		} catch (IOException e) {
			// 에러가 발생하면 콘솔에 표시한다.
			e.printStackTrace();
		}
	});
	

}

// WebSocket으로 메시지가 오면 요청되는 함수 회원이 로그인 한 시점에 이 부분을 걸어줘야 함.
@OnMessage
public void handleMessage(String nickname) throws IOException {

	imsinick=nickname;
	// 메시지 내용을 콘솔에 출력한다.
	System.out.println(nickname);
	
	log1="";
	
	for (int i = 0; i < logClient.size(); i++) {
		if (nickname.equals(logClient.get(i))) {
			logClient.remove(i);	
		}
	}
	
	logClient.add(nickname);
	count=logClient.size();
	System.out.println(count);
	if (logClient.size()<=0 ) {
		count=0;
	}
	for (int i = 0; i < logClient.size(); i++) {
		if (i==0) {
			log1=Integer.toString(count)+"~";
		}
			log1+=logClient.get(i)+"~";
	}
	
	System.out.println(log1);
	System.out.println(count);
	// 클로져를 위해 변수의 상수화
	Matcher matcher = pattern.matcher(log1);
	final String msg = log1.replaceAll(pattern.pattern(), "");
	sessionUsers.forEach(session -> {
		try {
			// 리스트에 있는 모든 세션(메시지 보낸 유저 제외)에 메시지를 보낸다. (형식: 유저명 => 메시지)
			session.getBasicRemote().sendText(msg);
		} catch (IOException e) {
			// 에러가 발생하면 콘솔에 표시한다.
			e.printStackTrace();
		}
	});
	
}
	

// WebSocket과 브라우저가 접속이 끊기면 요청되는 함수
@OnClose
public void handleClose(Session userSession) {
	if (!logClient.equals(null)) {
		for (int i = 0; i < logClient.size(); i++) {
			if (imsinick.equals(logClient.get(i))) {
				System.out.println(imsinick);
				logClient.remove(i);	
			}
		}
		count=logClient.size();
	}
	else {
		count=0;
	}
	for (int i = 0; i < sessionUsers.size(); i++) {
		if (sessionUsers.get(i).equals(userSession)) {
			System.out.println("client is now disconnected...");
		}
	}
	
	sessionUsers.remove(userSession);
	// 콘솔에 접속 끊김 로그를 출력한다.

}

}
