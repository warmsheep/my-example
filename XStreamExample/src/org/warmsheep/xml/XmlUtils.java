package org.warmsheep.xml;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.KXml2Driver;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

public class XmlUtils {

	private XStream xstream =  new XStream(new Xpp3Driver());
	private ObjectOutputStream out = null;
	private ObjectInputStream ins = null;
	
	public void destory(){
		xstream = null;
		try {
			if(out != null){
				out.flush();
				out.close();
			}
			if(ins != null){
				ins.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			System.gc();
		}
	}
	
	public String toXml(Object obj){
		xstream.autodetectAnnotations(true);
		return xstream.toXML(obj);
	}
}
