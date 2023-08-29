package com.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.bean.EquityBean;

public class PriceService {
	public static void main(String[] args) {
		new PriceService().getPrice();
	}

	public ArrayList<EquityBean> getPrice() {
		ArrayList<EquityBean> list = new ArrayList<EquityBean>();

		try {
			File file = new File("C:\\Users\\devanshu\\Downloads\\eq.csv");

			FileReader fr = new FileReader(file);// single character
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {

				// System.out.println(line);// coaline,xx,xx,xx,xx,x,x,x,x,x,x
				String data[] = line.split("\",\"");
				String price = data[5].replaceAll("\"", "").replaceAll(",", "");
				String name = data[0].replace("\"", "");
				System.out.println(name + " " + price);

				EquityBean eq = new EquityBean();
				eq.setName(name);
				eq.setPrice(Float.parseFloat(price));

				list.add(eq);

			}

			br.close();
		} catch (Exception e) {

		}
		return list;
	}
}