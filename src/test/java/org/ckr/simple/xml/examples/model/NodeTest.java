package org.ckr.simple.xml.examples.model;

import java.io.StringReader;
import java.io.StringWriter;

import org.junit.Test;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.CycleStrategy;

public class NodeTest {

	private Persister persister = new Persister(new CycleStrategy("xmlId","xmlRef"));

	@Test
	public void testPersisNormalNode() throws Exception {
		Node node = new Node(20L);
		persist(node);
	}

	@Test
	public void testPersistNodeWithOneOtherNode() throws Exception {
		Node node = new Node(20L);
		Node node2 = new Node(21L);
		node.addRef(node2);
		persist(node);
	}

	@Test
	public void testPersistNodeWithCycle() throws Exception {
		Node node = new Node(20L);
		Node node2 = new Node(21L);
		node.addRef(node2);
		node2.addCal(node);
		persist(node);
	}

	Node createNode(long id) {
		return new Node(id);
	}

	

	@Test
	public void testPersistListForNodesWithCycle() throws Exception {
		NodeList nodeList = new NodeList();
		Node node = createNode(20);
		Node node2 = createNode(21L);
		node.addRef(node2);
		node2.addCal(node);
		nodeList.add(node);
		nodeList.add(node2);
		persist(nodeList);
	}

	private void persist(Object node) throws Exception {
		StringWriter out = new StringWriter();
		persister.write(node, out);
		out.flush();
		System.out.println(out.getBuffer().toString());
		Object read = persister.read(node.getClass(), new StringReader(out.getBuffer().toString()));
	}

}
