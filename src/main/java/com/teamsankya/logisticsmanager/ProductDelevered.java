package com.teamsankya.logisticsmanager;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ProductDelevered {

	private static final String QUEUE_NAME = "Message";
	private static final String URL = "tcp://localhost:61616";
	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory(URL);
		System.out.println("Creating Connection factory object");
		 Connection connection=  factory.createConnection();
		System.out.println("Creating Connection via factory");
		Session session =((javax.jms.Connection) connection).createSession(false,Session.AUTO_ACKNOWLEDGE);
		System.out.println("Creating Session via Connection");
		Destination destination = session.createQueue(QUEUE_NAME);
		System.out.println("Creating Queue via Session");
		TextMessage message = session.createTextMessage("Product delevered to the ramanji");
		System.out.println("Creating TextMessage via Session");
		MessageProducer producer = session.createProducer(destination);
		System.out.println("Creating MessageProducer via session");
		producer.send(message);
		System.out.println("Sending the message the ActiveMQ using Produser");
		connection.close();

	}

}
