package com.kafkastorm.example.subscriber;

import storm.kafka.BrokerHosts;
import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.StringScheme;
import storm.kafka.ZkHosts;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.spout.SchemeAsMultiScheme;
import backtype.storm.topology.TopologyBuilder;

public class KafkaTopology {

	public static void main(String args[]) {
		BrokerHosts zk = new ZkHosts("localhost:2181");
		SpoutConfig spoutConf = new SpoutConfig(zk, "test-topic",
				"/kafkastorm", "discovery");
		spoutConf.scheme = new SchemeAsMultiScheme(new StringScheme());
		KafkaSpout spout = new KafkaSpout(spoutConf);
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("spout", spout, 1);
		builder.setBolt("printerbolt", new PrintBolt())
				.shuffleGrouping("spout");
		Config config = new Config();
		config.setDebug(true);
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("kafka", config, builder.createTopology());

		try {
			Thread.sleep(100000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
