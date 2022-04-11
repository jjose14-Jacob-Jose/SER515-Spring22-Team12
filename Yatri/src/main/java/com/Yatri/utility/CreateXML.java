package com.Yatri.utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.Yatri.ifc.BaseLink;
import com.Yatri.ifc.LeftWheel;
import com.Yatri.ifc.RightWheel;
import com.Yatri.impl.BiggerLeftWheel;
import com.Yatri.impl.BiggerRightWheel;
import com.Yatri.impl.BlueBaseLink;
import com.Yatri.impl.OrangeBaseLink;
import com.Yatri.impl.SmallerLeftWheel;
import com.Yatri.impl.SmallerRightWheel;

public class CreateXML {

	BaseLink baselink;
	RightWheel rightWheel;	
	LeftWheel leftWheel;	

	/**
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 */
	public void preparebaseURDF(String baselinkColor, String rightWheelSize, String leftWheelSize) throws ParserConfigurationException, TransformerException {		

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("robot");
		rootElement.setAttribute("name", "myfirst");
		doc.appendChild(rootElement);

		Element material = doc.createElement("material");
		rootElement.appendChild(material);
		material.setAttribute("name", "black");

		Element color = doc.createElement("color");
		color.setAttribute("rgba", "0.0 0.0 0.0 1.0");
		material.appendChild(color);


		Element materialA = doc.createElement("material");
		rootElement.appendChild(materialA);
		materialA.setAttribute("name", "blue");

		Element colorA = doc.createElement("color");
		colorA.setAttribute("rgba", "0.203125 0.23828125 0.28515625 1.0");
		materialA.appendChild(colorA);


		Element materialB = doc.createElement("material");
		rootElement.appendChild(materialB);
		materialB.setAttribute("name", "green");

		Element colorB = doc.createElement("color");
		colorB.setAttribute("rgba", "0.0 0.8 0.0 1.0");
		materialB.appendChild(colorB);

		Element materialC = doc.createElement("material");
		rootElement.appendChild(materialC);
		materialC.setAttribute("name", "grey");

		Element colorC = doc.createElement("color");
		colorC.setAttribute("rgba", "0.2 0.2 0.2 1.0");
		materialC.appendChild(colorC);

		Element materialD = doc.createElement("material");
		rootElement.appendChild(materialD);
		materialD.setAttribute("name", "orange");

		Element colorD = doc.createElement("color");
		colorD.setAttribute("rgba", "1.0 0.423529411765 0.0392156862745 1.0");
		materialD.appendChild(colorD);

		Element materialE = doc.createElement("material");
		rootElement.appendChild(materialE);
		materialE.setAttribute("name", "brown");

		Element colorE = doc.createElement("color");
		colorE.setAttribute("rgba", "0.870588235294 0.811764705882 0.764705882353 1.0");
		materialE.appendChild(colorE);

		Element materialF = doc.createElement("material");
		rootElement.appendChild(materialF);
		materialF.setAttribute("name", "red");

		Element colorF = doc.createElement("color");
		colorF.setAttribute("rgba", "0.80078125 0.12890625 0.1328125 1.0");
		materialF.appendChild(colorF);

		Element materialG = doc.createElement("material");
		rootElement.appendChild(materialG);
		materialG.setAttribute("name", "white");

		Element colorG = doc.createElement("color");
		colorG.setAttribute("rgba", "1.0 1.0 1.0 1.0");
		materialG.appendChild(colorG);

		Element gazebobl = doc.createElement("gazebo");
		rootElement.appendChild(gazebobl);
		gazebobl.setAttribute("reference", "base_link");

		Element materialgo = doc.createElement("material");
		gazebobl.appendChild(materialgo);
		materialgo.setTextContent("Gazebo/Orange");


		Element gazeboll = doc.createElement("gazebo");
		rootElement.appendChild(gazeboll);
		gazeboll.setAttribute("reference", "link_left_wheel");

		Element materialgb = doc.createElement("material");
		gazeboll.appendChild(materialgb);
		materialgb.setTextContent("Gazebo/Blue");        

		Element gazeborw = doc.createElement("gazebo");
		rootElement.appendChild(gazeborw);
		gazeborw.setAttribute("reference", "link_right_wheel");

		Element materialrw = doc.createElement("material");
		gazeborw.appendChild(materialrw);
		materialrw.setTextContent("Gazebo/Blue");


		Element gazebomain = doc.createElement("gazebo");
		rootElement.appendChild(gazebomain);        

		Element plugin = doc.createElement("plugin");
		gazebomain.appendChild(plugin);
		plugin.setAttribute("filename", "libgazebo_ros_diff_drive.so");
		plugin.setAttribute("name", "differential_drive_controller");

		Element alwaysOn = doc.createElement("alwaysOn");
		plugin.appendChild(alwaysOn);
		alwaysOn.setTextContent("true");

		Element updateRate = doc.createElement("updateRate");
		plugin.appendChild(updateRate);
		updateRate.setTextContent("20");

		Element leftJoint = doc.createElement("leftJoint");
		plugin.appendChild(leftJoint);
		leftJoint.setTextContent("joint_left_wheel");

		Element rightJoint = doc.createElement("rightJoint");
		plugin.appendChild(rightJoint);
		rightJoint.setTextContent("joint_right_wheel");

		Element wheelSeparation = doc.createElement("wheelSeparation");
		plugin.appendChild(wheelSeparation);
		wheelSeparation.setTextContent("0.4");

		Element wheelDiameter = doc.createElement("wheelDiameter");
		plugin.appendChild(wheelDiameter);
		wheelDiameter.setTextContent("0.2");

		Element torque = doc.createElement("torque");
		plugin.appendChild(torque);
		torque.setTextContent("0.1");

		Element commandTopic = doc.createElement("commandTopic");
		plugin.appendChild(commandTopic);
		commandTopic.setTextContent("cmd_vel");

		Element odometryTopic = doc.createElement("odometryTopic");
		plugin.appendChild(odometryTopic);
		odometryTopic.setTextContent("odom");

		Element odometryFrame = doc.createElement("odometryFrame");
		plugin.appendChild(odometryFrame);
		odometryFrame.setTextContent("odom");

		Element robotBaseFrame = doc.createElement("robotBaseFrame");
		plugin.appendChild(robotBaseFrame);
		robotBaseFrame.setTextContent("base_link");

		Element gazeboNext = doc.createElement("gazebo");
		gazeboNext.setAttribute("reference", "sensor_laser");
		rootElement.appendChild(gazeboNext);        

		Element sensor = doc.createElement("sensor");
		sensor.setAttribute("type", "ray");
		sensor.setAttribute("name", "head_hokuyo_sensor");
		gazeboNext.appendChild(sensor);


		Element pose = doc.createElement("pose");
		pose.setTextContent("0 0 0 0 0 0");
		sensor.appendChild(pose);

		Element visualize = doc.createElement("visualize");
		visualize.setTextContent("false");
		sensor.appendChild(visualize);

		Element update_rate = doc.createElement("update_rate");
		update_rate.setTextContent("20");
		sensor.appendChild(update_rate);

		Element ray = doc.createElement("ray");
		sensor.appendChild(ray);

		Element scan = doc.createElement("scan");
		ray.appendChild(scan);

		Element horizontal = doc.createElement("horizontal");
		scan.appendChild(horizontal);

		Element samples = doc.createElement("samples");
		horizontal.appendChild(samples);
		samples.setTextContent("720");

		Element resolution = doc.createElement("resolution");
		horizontal.appendChild(resolution);
		resolution.setTextContent("1");

		Element min_angle = doc.createElement("min_angle");
		horizontal.appendChild(min_angle);
		min_angle.setTextContent("-1.570796");

		Element max_angle = doc.createElement("max_angle");
		horizontal.appendChild(max_angle);
		max_angle.setTextContent("1.570796");


		Element range = doc.createElement("range");
		ray.appendChild(range);

		Element min = doc.createElement("min");
		range.appendChild(min);
		min.setTextContent("0.10");

		Element max = doc.createElement("max");
		range.appendChild(max);
		max.setTextContent("10.0");

		Element resolutionR = doc.createElement("resolution");
		range.appendChild(resolutionR);
		resolutionR.setTextContent("0.01");        

		Element noise = doc.createElement("noise");
		ray.appendChild(noise);

		Element type = doc.createElement("type");
		noise.appendChild(type);
		type.setTextContent("gaussian");

		Element mean = doc.createElement("mean");
		noise.appendChild(mean);
		mean.setTextContent("0.0");

		Element stddev = doc.createElement("stddev");
		noise.appendChild(stddev);
		stddev.setTextContent("0.01");

		Element pluginAg = doc.createElement("plugin");
		sensor.appendChild(pluginAg);
		pluginAg.setAttribute("name", "gazebo_ros_head_hokuyo_controller");
		pluginAg.setAttribute("filename", "libgazebo_ros_laser.so");

		Element topicName = doc.createElement("topicName");
		pluginAg.appendChild(topicName);
		topicName.setTextContent("/m2wr/laser/scan");

		Element frameName = doc.createElement("frameName");
		pluginAg.appendChild(frameName);
		frameName.setTextContent("sensor_laser"); 

		// Factory Design Pattern
		if(baselinkColor.equalsIgnoreCase("blue")) {
			baselink= new BlueBaseLink();
		}
		else if(baselinkColor.equalsIgnoreCase("orange")) {
			baselink= new OrangeBaseLink();
		}

		baselink.addBaseToRover(doc);


		// Factory Design Pattern
		if(rightWheelSize.equalsIgnoreCase("bigger")) {
			rightWheel= new BiggerRightWheel();
		}
		else if(rightWheelSize.equalsIgnoreCase("smaller")) {
			rightWheel= new SmallerRightWheel();
		}

		rightWheel.addRightWheelToRover(doc);


		// Factory Design Pattern
		if(leftWheelSize.equalsIgnoreCase("smaller")) {
			leftWheel= new SmallerLeftWheel();
		}
		else if(rightWheelSize.equalsIgnoreCase("bigger")) {
			leftWheel= new BiggerLeftWheel();
		}

		leftWheel.addLeftWheelToRover(doc);


		try (FileOutputStream output =new FileOutputStream("Yatri-URDF.xml")) {
			writeXml(doc, output);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param doc
	 * @param output
	 * @throws TransformerException
	 */
	private static void writeXml(Document doc, OutputStream output)
			throws TransformerException {

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(output);

		transformer.transform(source, result);

	}

}
