package com.encore.lab3;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, Text, Text> {
    public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
        Configuration conf = context.getConfiguration();
        //행렬 A와 B의 크기를 정의한다.
        int m = Integer.parseInt(conf.get("m"));
        int n = Integer.parseInt(conf.get("n"));
        int p = Integer.parseInt(conf.get("p"));

        String line = value.toString();
        String[] indicesAndValue = line.split(",");
        Text outputKey = new Text();
        //Key와 Value를 저장할 값을 정의한다.
        Text outputValue = new Text();
        //Split의 각 줄을 , 단위로 나눈다.

        //Key는 행렬곱의 결과로 출력되는 행렬의 위치이다.
        //Value는 해당 행렬의 이름과 위치, 값을 정의한다.
        if (indicesAndValue[0].equals("A")) {
            for (int k = 0; k < p; k++) {
                outputKey.set(indicesAndValue[1] + "," + k);
                outputValue.set("A," + indicesAndValue[2] + "," + indicesAndValue[3]);
                context.write(outputKey, outputValue);
            }
        } else {
            for (int i = 0; i < m; i++) {
                outputKey.set(i + "," + indicesAndValue[2]);
                outputValue.set("B," + indicesAndValue[1] + "," + indicesAndValue[3]);
                context.write(outputKey, outputValue);
            }
        }
    }
}
