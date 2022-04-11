package com.Yatri.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.Yatri.ifc.BaseLink;

public class OrangeBaseLink implements BaseLink{

	@Override
	public void addBaseToRover(Document doc) {
		

		
		Element root =doc.getDocumentElement();
		
		Element link = doc.createElement("link");
		root.appendChild(link);
		link.setAttribute("name", "base_link");
		
		Element pose = doc.createElement("pose");
		link.appendChild(pose);
		pose.setTextContent("0 0 0.1 0 0 0");
		
		Element inertial = doc.createElement("inertial");
		link.appendChild(inertial);
		
		Element mass = doc.createElement("mass");
		inertial.appendChild(mass);
		mass.setAttribute("value","5");
		
		Element origin = doc.createElement("origin");
		inertial.appendChild(origin);
		origin.setAttribute("rpy","0 0 0");
		origin.setAttribute("xyz","0 0 0.1");
		
		Element inertia = doc.createElement("inertia");
		inertial.appendChild(inertia);
		inertia.setAttribute("ixx","0.0395416666667");
		inertia.setAttribute("ixy","0");
		inertia.setAttribute("ixz","0");
		inertia.setAttribute("iyy","0.106208333333");
		inertia.setAttribute("iyz","0");
		inertia.setAttribute("izz","0.106208333333");
		
		
		Element collision = doc.createElement("collision");
		link.appendChild(collision);
		collision.setAttribute("name","collision_chassis");
		
		Element geometry = doc.createElement("geometry");
		collision.appendChild(geometry);
		
		Element box = doc.createElement("box");
		geometry.appendChild(box);
		box.setAttribute("size","1.0 0.5 0.10");
		
		Element visual = doc.createElement("visual");
		link.appendChild(visual);
		
		Element originA = doc.createElement("origin");
		visual.appendChild(originA);
		originA.setAttribute("rpy","0 0 0");
		originA.setAttribute("xyz","0 0 0");
		
		Element geometryA = doc.createElement("geometry");
		visual.appendChild(geometryA);

		Element boxA = doc.createElement("box");
		geometryA.appendChild(boxA);
		boxA.setAttribute("size","1.0 0.5 0.10");
		
		Element material = doc.createElement("material");
		visual.appendChild(material);
		material.setAttribute("name","orange");
		
		
		Element collisionA = doc.createElement("collision");
		link.appendChild(collisionA);
		collisionA.setAttribute("name","caster_front_collision");
		
		Element originB = doc.createElement("origin");
		collisionA.appendChild(originB);
		originB.setAttribute("rpy","0 0 0");
		originB.setAttribute("xyz","0.35 0 -0.05");
		
		Element geometryB = doc.createElement("geometry");
		collisionA.appendChild(geometryB);
		
		Element sphere = doc.createElement("sphere");
		geometryB.appendChild(sphere);
		sphere.setAttribute("radius","0.10");
		
		Element surface = doc.createElement("surface");
		collisionA.appendChild(surface);
		
		Element friction = doc.createElement("friction");
		surface.appendChild(friction);
		
		Element ode = doc.createElement("ode");
		friction.appendChild(ode);
		
		Element mu = doc.createElement("mu");
		ode.appendChild(mu);
		mu.setTextContent("0");
		
		Element mu2 = doc.createElement("mu2");
		ode.appendChild(mu2);
		mu2.setTextContent("0");
		
		Element slip1 = doc.createElement("slip1");
		ode.appendChild(slip1);
		slip1.setTextContent("1.0");
		
		Element slip2 = doc.createElement("slip2");
		ode.appendChild(slip2);
		slip2.setTextContent("1.0");
		
		
		Element visualA = doc.createElement("visual");
		link.appendChild(visualA);
		visualA.setAttribute("name","caster_front_visual");
		
		Element originC = doc.createElement("origin");
		visualA.appendChild(originC);
		originC.setAttribute("rpy"," 0 0 0");
		originC.setAttribute("xyz","0.2 0 -0.05");
		
		Element geometryC = doc.createElement("geometry");
		visualA.appendChild(geometryC);
		
		Element sphereA = doc.createElement("sphere");
		geometryC.appendChild(sphereA);
		sphereA.setAttribute("radius","0.10");
	
		
	}

}
