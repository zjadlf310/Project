package com.kgitbank.front.vodao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import com.kgitbank.dbconn.Dbconn;

@Repository
public class FrontDAO {
	private Connection con;
	private PreparedStatement st;

	public ArrayList<String> APIRoadKind(FrontVO vo) throws IOException, ParseException {
		
		  String skey = "eZ%2F7pGiWqqvhlkGmf57JYKGih5zv%2FZImo%2FCS%2F6bJy3oE4WFYHiLlXBw2nctMQ4nPRxbH9d0sCXtci%2Bpv4nC0dg%3D%3D";
		  StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/restarea-std?serviceKey="+skey);
		  urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); 
		  urlBuilder.append("&" +URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("250", "UTF-8"));
		  urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); 
		  
		  
		  URL url = new URL(urlBuilder.toString());
		  HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
		  conn.setRequestMethod("GET");
		  conn.setRequestProperty("Content-type", "application/json");
		  System.out.println("Response code: " + conn.getResponseCode());
		  BufferedReader rd; 
		  if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) { 
			  rd = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
		  } else { rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); }
		  StringBuilder sb = new StringBuilder();
		  String line; 
		  while ((line = rd.readLine()) != null) { 
			  sb.append(line);
		  }
		  
		  rd.close(); conn.disconnect();
		  
		  JSONParser parser = new JSONParser();
		  JSONObject job = (JSONObject)
		  parser.parse(sb.toString()); 
		  JSONObject job2 = (JSONObject) job.get("response"); 
		  JSONObject job3 = (JSONObject) job2.get("body");
		  JSONArray ja = (JSONArray) job3.get("items"); 
		  ArrayList<String> ar1 = new  ArrayList<String>(); 
		  for (int i = 0; i < ja.size(); i++) { 
			  JSONObject unitname = (JSONObject) ja.get(i); 
			  ar1.add((String) unitname.get("roadKnd"));
		  
		  } 
		  HashSet<String> hs = new HashSet<String>(ar1);
		  
		  ArrayList<String> ar2 = new ArrayList<String>(hs);
		  
		  Collections.sort(ar2);
		 
		

		return ar2;
	}

	public ArrayList<String> APIRoadName(FrontVO vo) throws IOException, ParseException {
		
		  String skey ="eZ%2F7pGiWqqvhlkGmf57JYKGih5zv%2FZImo%2FCS%2F6bJy3oE4WFYHiLlXBw2nctMQ4nPRxbH9d0sCXtci%2Bpv4nC0dg%3D%3D";
		  StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/restarea-std?serviceKey=" + skey);
		  
		  urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		  urlBuilder.append("&" +  URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("250","UTF-8"));
		  urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); 
		  urlBuilder.append("&" + URLEncoder.encode("roadKnd", "UTF-8") + "=" + URLEncoder.encode(vo.getRoadKnd(), "UTF-8"));
		  
		  URL url = new URL(urlBuilder.toString()); 
		  HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
		  conn.setRequestMethod("GET");
		  conn.setRequestProperty("Content-type", "application/json");
		  System.out.println("Response code: " + conn.getResponseCode());
		  BufferedReader rd; 
		  if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) { 
			  rd = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
		} else { 
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); 
		} StringBuilder sb = new StringBuilder();
		  
		  String line; while ((line = rd.readLine()) != null) {
			  sb.append(line); 
		}
		  
		  rd.close(); conn.disconnect();
		  
		  JSONParser parser = new JSONParser(); 
		  JSONObject job = (JSONObject) parser.parse(sb.toString());
		  JSONObject job2 = (JSONObject) job.get("response"); 
		  JSONObject job3 = (JSONObject) job2.get("body");
		  JSONArray ja = (JSONArray) job3.get("items"); 
		  ArrayList<String> ar1 = new ArrayList<String>(); 
		  for (int i = 0; i < ja.size(); i++) { 
			  JSONObject unitname = (JSONObject) ja.get(i); 
			  ar1.add((String)unitname.get("roadRouteNm")); 
			  } 
		  HashSet<String> hs = new HashSet<String>(ar1);
		  
		  ArrayList<String> ar2 = new ArrayList<String>(hs); 
		  Collections.sort(ar2);
		 
		


		return ar2;
	}

	public ArrayList<String> APIRestName(FrontVO vo) throws IOException, ParseException {
		
		  String skey ="eZ%2F7pGiWqqvhlkGmf57JYKGih5zv%2FZImo%2FCS%2F6bJy3oE4WFYHiLlXBw2nctMQ4nPRxbH9d0sCXtci%2Bpv4nC0dg%3D%3D";
		  StringBuilder urlBuilder = new StringBuilder( "http://api.data.go.kr/openapi/restarea-std?serviceKey=" + skey); 
		  
		  urlBuilder.append( "&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); 
		  urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("250", "UTF-8"));
		  urlBuilder.append( "&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); 
		  urlBuilder.append("&" + URLEncoder.encode("roadRouteNm", "UTF-8") + "=" + URLEncoder.encode(vo.getRoadRouteNm(), "UTF-8"));
		  
		  URL url = new URL(urlBuilder.toString());
		  HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
		  conn.setRequestMethod("GET");
		  conn.setRequestProperty("Content-type", "application/json");
		  System.out.println("Response code: " + conn.getResponseCode());
		  BufferedReader rd; 
		  if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) { 
			  rd = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
			  } else { 
				  rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); 
				}
		  StringBuilder  sb = new StringBuilder();
		  
		  String line; 
		  while ((line = rd.readLine()) != null) { 
			  sb.append(line); 
		}
		  
		  rd.close(); 
		  conn.disconnect();
		  
		  JSONParser parser = new JSONParser(); 
		  JSONObject job = (JSONObject) parser.parse(sb.toString()); 
		  JSONObject job2 = (JSONObject) job.get("response");
		  JSONObject job3 = (JSONObject) job2.get("body");
		  JSONArray ja = (JSONArray) job3.get("items");
		  ArrayList<String> ar1 = new ArrayList<String>(); 
		  for (int i = 0; i < ja.size(); i++) { 
			  JSONObject unitname = (JSONObject) ja.get(i); 
			  ar1.add((String) unitname.get("entrpsNm")); 
			  }
		  HashSet<String> hs = new HashSet<String>(ar1);
		  
		  ArrayList<String> ar2 = new ArrayList<String>(hs); 
		  Collections.sort(ar2);
		 
		
		return ar2;
	}

	public ArrayList<FrontVO> APIList(FrontVO vo) throws IOException, ParseException {
		String skey = "eZ%2F7pGiWqqvhlkGmf57JYKGih5zv%2FZImo%2FCS%2F6bJy3oE4WFYHiLlXBw2nctMQ4nPRxbH9d0sCXtci%2Bpv4nC0dg%3D%3D";
		StringBuilder urlBuilder = new StringBuilder(
				"http://api.data.go.kr/openapi/restarea-std?serviceKey=" + skey); /* URL */
		if (vo.getRoadRouteNm().equals("")) {
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지 번호 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("250", "UTF-8")); /* 한 페이지 결과 수 */
			urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "="
					+ URLEncoder.encode("json", "UTF-8")); /* XML/JSON 여부 */
			urlBuilder.append(
					"&" + URLEncoder.encode("roadKnd", "UTF-8") + "=" + URLEncoder.encode(vo.getRoadKnd(), "UTF-8"));

		} else if (vo.getEntrpsNm().equals("")) {
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지 번호 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("250", "UTF-8")); /* 한 페이지 결과 수 */
			urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "="
					+ URLEncoder.encode("json", "UTF-8")); /* XML/JSON 여부 */
			urlBuilder.append(
					"&" + URLEncoder.encode("roadKnd", "UTF-8") + "=" + URLEncoder.encode(vo.getRoadKnd(), "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("roadRouteNm", "UTF-8") + "="
					+ URLEncoder.encode(vo.getRoadRouteNm(), "UTF-8"));

		} else {
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지 번호 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("250", "UTF-8")); /* 한 페이지 결과 수 */
			urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "="
					+ URLEncoder.encode("json", "UTF-8")); /* XML/JSON 여부 */
			urlBuilder.append(
					"&" + URLEncoder.encode("roadKnd", "UTF-8") + "=" + URLEncoder.encode(vo.getRoadKnd(), "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("roadRouteNm", "UTF-8") + "="
					+ URLEncoder.encode(vo.getRoadRouteNm(), "UTF-8"));
			urlBuilder.append(
					"&" + URLEncoder.encode("entrpsNm", "UTF-8") + "=" + URLEncoder.encode(vo.getEntrpsNm(), "UTF-8"));
		}

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();

		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}

		rd.close();
		conn.disconnect();

		JSONParser parser = new JSONParser();
		JSONObject job = (JSONObject) parser.parse(sb.toString());
		JSONObject job2 = (JSONObject) job.get("response");
		JSONObject job3 = (JSONObject) job2.get("body");
		JSONArray ja = (JSONArray) job3.get("items");
		ArrayList<FrontVO> ar1 = new ArrayList<FrontVO>();
		for (int i = 0; i < ja.size(); i++) {
			JSONObject unitname = (JSONObject) ja.get(i);
			FrontVO list = new FrontVO();
			list.setEntrpsNm((String) unitname.get("entrpsNm")); // 휴게소 이름
			list.setRoadKnd((String) unitname.get("roadKnd")); // 도로종류
			list.setRoadRouteNo((String) unitname.get("roadRouteNo")); // 도로노선번호
			list.setRoadRouteNm((String) unitname.get("roadRouteNm")); // 도로노선명
			list.setRoadRouteDrc((String) unitname.get("roadRouteDrc")); // 도로노선방향
			list.setLatitude(Double.parseDouble((String) unitname.get("latitude"))); // 위도
			list.setHardness(Double.parseDouble((String) unitname.get("hardness"))); // 경도
			list.setRestAreaType((String) unitname.get("restAreaType")); // 휴게소종류
			list.setOperOpenHhmm((String) unitname.get("operOpenHhmm")); // 영업시작시간
			list.setOperCloseHhmm((String) unitname.get("operCloseHhmm"));// 영업종료시간
			list.setOcpatAr((String) unitname.get("ocpatAr")); // 도로점용면적
			list.setPrkplceCo((String) unitname.get("prkplceCo")); // 주차면수
			list.setCrrpwrkYn((String) unitname.get("crrpwrkYn")); // 경정비 가능여부
			list.setOltYn((String) unitname.get("oltYn")); // 주유소 유무
			list.setLpgYn((String) unitname.get("lpgYn")); // LPG충전소 유무
			list.setElctyYn((String) unitname.get("elctyYn")); // 전기차충전소 유무
			list.setBusTrnsitYn((String) unitname.get("busTrnsitYn")); // 버스환승가능여부
			list.setShltrYn((String) unitname.get("shltrYn")); // 쉼터 유무
			list.setToiletYn((String) unitname.get("toiletYn")); // 화장실 유무
			list.setParmacyYn((String) unitname.get("parmacyYn")); // 약국 유무
			list.setNrsgYn((String) unitname.get("nrsgYn")); // 수유실 유무
			list.setShopYn((String) unitname.get("shopYn")); // 매점 유무
			list.setRstrtYn((String) unitname.get("rstrtYn")); // 음식점 유무
			list.setEtcCvntl((String) unitname.get("etcCvntl")); // 기타편의시설 유무
			list.setRprsntvRstrt((String) unitname.get("rprsntvRstrt")); // 휴게소 대표음식명
			list.setPhoneNumber((String) unitname.get("phoneNumber")); // 휴게소 전화번호
			list.setReferenceDate((String) unitname.get("referenceDate"));// 데이터 기준일자
			list.setInsttCode((String) unitname.get("insttCode")); // 제공기관코드
			list.setInsttNm((String) unitname.get("insttNm")); // 제공기관명
			ar1.add(list);
		}

		return ar1;
	}

	public boolean QA(FrontVO vo) throws SQLException, ClassNotFoundException {
		con = new Dbconn().getConnection();
		String sql = "insert into QA values((SELECT NVL(MAX(num),0)+1 FROM QA),?,?,?,sysdate)";
		st = con.prepareStatement(sql);
		st.setString(1, vo.getName());
		st.setString(2, vo.getEmail());
		st.setString(3, vo.getText());
		int aa = st.executeUpdate();

		if (aa == 1) {
			return true;
		} else {
			return false;
		}

	}
}
