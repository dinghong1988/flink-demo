package com.dh.wc;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import scala.Int;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WordCount {

    public static void main(String[] args) {

        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        DataSet<String> dataSet = env.readTextFile("./hello.txt");

        dataSet.flatMap(new FlatMapFunction<String, Tuple2<String,Integer>>() {

            public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                String[] str = s.split(" ");
                List<Tuple2<String, Integer>> list = new ArrayList<Tuple2<String, Integer>>();
                for (String sr: str){
                    collector.collect(new Tuple2<String, Integer>(sr,1));
                }

            }
        });
    }
}
