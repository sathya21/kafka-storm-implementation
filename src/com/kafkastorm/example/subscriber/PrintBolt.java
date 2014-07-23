package com.kafkastorm.example.subscriber;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class PrintBolt extends BaseRichBolt  {

	private static final long serialVersionUID = 1L;

	public void execute(Tuple tuple) {
		System.out.println("message " + tuple.getValues());
	}

	public void prepare(Map arg0, TopologyContext arg1, OutputCollector arg2) {
	}

	public void declareOutputFields(OutputFieldsDeclarer arg0) {
	}

}
