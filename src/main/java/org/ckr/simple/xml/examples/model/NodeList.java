package org.ckr.simple.xml.examples.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class NodeList {

	public NodeList() {
	}

	@ElementList(inline = true)
	private List<Node> nodes = new ArrayList<Node>();

	public void add(Node node) {
		nodes.add(node);
	}

}