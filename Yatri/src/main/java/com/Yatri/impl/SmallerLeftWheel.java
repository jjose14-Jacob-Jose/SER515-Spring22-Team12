package com.Yatri.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.Yatri.ifc.LeftWheel;

public class SmallerLeftWheel implements LeftWheel{

	@Override
	public void addLeftWheelToRover(Document doc) {

		Element root =doc.getDocumentElement();

		Element link = doc.createElement("link");
		root.appendChild(link);
		link.setAttribute("name", "link_left_wheel");

		Element inertial = doc.createElement("inertial");
		link.appendChild(inertial);

		Element mass = doc.createElement("mass");
		inertial.appendChild(mass);
		mass.setAttribute("value", "0.2");

		Element origin = doc.createElement("origin");
		inertial.appendChild(origin);
		origin.setAttribute("rpy", "0 1.5707 1.5707");
		origin.setAttribute("xyz", "0 0 0");

		Element inertia = doc.createElement("inertia");
		inertial.appendChild(inertia);
		inertia.setAttribute("ixx", "0.000526666666667");
		inertia.setAttribute("ixy", "0");
		inertia.setAttribute("ixz", "0");
		inertia.setAttribute("iyy", "0.000526666666667");
		inertia.setAttribute("iyz", "0");
		inertia.setAttribute("izz", "0.001");
		
		Element collision = doc.createElement("collision");
		link.appendChild(collision);
		collision.setAttribute("name", "link_left_wheel_collision");		
		
		Element originA = doc.createElement("origin");
		collision.appendChild(originA);
		originA.setAttribute("rpy", "0 1.5707 1.5707");
		originA.setAttribute("xyz", "0 0 0");
		
		Element geometry = doc.createElement("geometry");
		collision.appendChild(geometry);
		
		Element cylinder = doc.createElement("cylinder");
		geometry.appendChild(cylinder);
		cylinder.setAttribute("length", "0.04");
		cylinder.setAttribute("radius", "0.1");
		
		Element visual = doc.createElement("visual");
		link.appendChild(visual);
		visual.setAttribute("name", "link_left_wheel_visual");
		
		Element originB = doc.createElement("origin");
		visual.appendChild(originB);
		originB.setAttribute("rpy", "0 1.5707 1.5707");
		originB.setAttribute("xyz", "0 0 0");
		
		Element geometryA = doc.createElement("geometry");
		visual.appendChild(geometryA);
		
		Element cylinderA = doc.createElement("cylinder");
		geometryA.appendChild(cylinderA);
		cylinderA.setAttribute("length", "0.04");
		cylinderA.setAttribute("radius", "0.1");
		
		
		Element joint = doc.createElement("joint");
		root.appendChild(joint);
		joint.setAttribute("name", "joint_left_wheel");
		joint.setAttribute("type", "continuous");
		
		Element originD = doc.createElement("origin");
		joint.appendChild(originD);
		originD.setAttribute("rpy", "0 0 0");
		originD.setAttribute("xyz", "-0.05 -0.15 0");
		
		Element child = doc.createElement("child");
		joint.appendChild(child);
		child.setAttribute("link", "link_left_wheel");
		
		Element parent = doc.createElement("parent");
		joint.appendChild(parent);
		parent.setAttribute("link", "base_link");
		
		Element axis = doc.createElement("axis");
		joint.appendChild(axis);
		axis.setAttribute("rpy", "0 0 0");
		axis.setAttribute("xyz", "0 1 0");

		Element limit = doc.createElement("limit");
		joint.appendChild(limit);
		limit.setAttribute("effort", "10000");
		limit.setAttribute("velocity", "1000");
		
		Element joint_properties = doc.createElement("joint_properties");
		joint.appendChild(joint_properties);
		joint_properties.setAttribute("damping", "1.0");
		joint_properties.setAttribute("friction", "1.0");
	}

}
