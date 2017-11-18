package org.ckr.simple.xml.examples.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Node {

	@Attribute
	private long nodeId;

	public Node() {
	}
	
	public Node(long nodeId) {
		this.nodeId = nodeId;
	}

	@ElementList(inline = true, required = false, entry = "refs")
	private List<Node> refs = new ArrayList<Node>();
	
	@ElementList(inline = true, required = false, entry = "call")
	private List<Node> calls = new ArrayList<Node>();

	public void addRef(Node node) {
		refs.add(node);
	}
	
	public void addCal(Node node) {
		calls.add(node);
	}
	
	
}
