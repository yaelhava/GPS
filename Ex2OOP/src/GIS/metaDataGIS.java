package GIS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import Geom.Point3D;


public class metaDataGIS implements Meta_data{

	String MAC, SSID, AuthMode, FirstSeen, Channel, RSSI,AccuracyMeters ,Type ;

	 public metaDataGIS (String[]s) {
		 MAC = s[0];
		 SSID = s[1];
		 AuthMode = s[2];
		 FirstSeen = s[3];
		 Channel = s[4];
		 RSSI = s[5];
		 Type = s[10];
		 AccuracyMeters = s[9];
	 }


	 public String getMAC() {
		return MAC;
	}

	public String getSSID() {
		return SSID;
	}

	public String getAuthMode() {
		return AuthMode;
	}

	public String getFirstSeen() {
		return FirstSeen;
	}

	public String getChannel() {
		return Channel;
	}

	public String getRSSI() {
		return RSSI;
	}

	public String getAccuracyMeters() {
		return AccuracyMeters;
	}

	public String getType() {
		return Type;
	}



	/**
	 *  returns the Universal Time Clock associated with this data
	 *  @return the real time
	 */

	@Override
	public long getUTC() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date = null;
		try {
			date = format.parse("1995-10-26 10:49:48");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long millis = date.getTime();
//		System.out.println(millis);
//		  SimpleDateFormat sdf = new SimpleDateFormat();
//	        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//	        System.out.println(sdf.format(new Date(millis)));

		return millis;
	}

	/**
	 *  return a String representing this data
	 */

	public String toString() {
		return ("MAC:" + MAC + " , SSID: " + SSID +
				" AuthMode: " + AuthMode + "Channel: " + Channel+ "RSSI: " + RSSI
						+ "Type: " + Type);
	}


	/**
	 * @return the orientation: yaw, pitch and roll associated with this data;
	 */

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
