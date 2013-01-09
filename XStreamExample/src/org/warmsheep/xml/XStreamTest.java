package org.warmsheep.xml;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.warmsheep.xml.entity.LightingCommand;
import org.warmsheep.xml.entity.LightingMode;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.SjsxpDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.io.xml.WstxDriver;
import com.thoughtworks.xstream.io.xml.XomDriver;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

public class XStreamTest {
	
	public XStreamTest(){
		
	}

	
	
	public static void main(String[] args) {
		long b = System.currentTimeMillis();
		LightingCommand cmd = new LightingCommand();
		cmd.setId(1L);
		cmd.setContent("调光80%");
		cmd.setName("调光指令");
		cmd.setOperator("张三");
		cmd.setType("调光");

		
		LightingCommand cmd2 = new LightingCommand();
		cmd2.setId(2L);
		cmd2.setContent("调光80%");
		cmd2.setName("调光指令");
		cmd2.setOperator("张三");
		cmd2.setType("调光");
		
		LightingCommand cmd3 = new LightingCommand();
		cmd3.setId(3L);
		cmd3.setContent("调光80%22222222222222222222222222");
		cmd3.setName("调光指令22222222222222222222");
		cmd3.setOperator("张三22222222222222222");
		cmd3.setType("调光22222222222222222222");
		
		LightingCommand cmd4 = new LightingCommand();
		cmd4.setId(4L);
		cmd4.setContent("调光80%111111111111111");
		cmd4.setName("调光指令222222222222222222222222");
		cmd4.setOperator("张三111111111111111111111111111111111111111");
		cmd4.setType("调光22222222222222222222");
		
		LightingCommand cmd5 = new LightingCommand();
		cmd5.setId(2L);
		cmd5.setContent("调光80%");
		cmd5.setName("调光指令333333333333333333333333333333");
		cmd5.setOperator("张三111111111111111111111111111111111");
		cmd5.setType("调光22222222222222222222222222222222222222222");
		
		LightingMode mode2 = new LightingMode();
		mode2.setId(123L);
		cmd5.setMode(mode2);
		
		LightingMode mode = new LightingMode();
		List<LightingCommand> cmds = new ArrayList<LightingCommand>();
		cmds.add(cmd);
		cmds.add(cmd2);
		cmds.add(cmd3);
		cmds.add(cmd4);
		cmds.add(cmd5);
		mode.setCommands(cmds);
		mode.setId(100L);
		mode.setStatus(0);
		mode.setName("照明模式");
		
	
		
		XmlUtils xs = new XmlUtils();
		String str = null;
		for(int i = 0 ;i<1;i++){
		str = xs.toXml(mode);
		}
		System.out.println(str);
		System.out.println("执行耗时:"+(System.currentTimeMillis()-b)+"ms");
		
		
	}
}
