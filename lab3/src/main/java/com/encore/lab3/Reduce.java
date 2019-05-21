package com.encore.lab3;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public  class Reduce extends Reducer<Text, Text, Text, Text> {
    public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
        Configuration conf = context.getConfiguration();
        String[] value;

        //각 행렬의 위치와 값을 저장할 수 있는 Map을 생성한다.
        HashMap<Integer, Float> hashA = new HashMap<Integer, Float>();
        HashMap<Integer, Float> hashB = new HashMap<Integer, Float>();
        for (Text val : values) {
            value = val.toString().split(",");
            if (value[0].equals("A")) {
                hashA.put(Integer.parseInt(value[1]), Float.parseFloat(value[2]));
            } else {
                hashB.put(Integer.parseInt(value[1]), Float.parseFloat(value[2]));
            }
        }
        //행렬 A와 B의 크기를 정의한다.
        int m = Integer.parseInt(conf.get("m"));
        int n = Integer.parseInt(conf.get("n"));
        int p = Integer.parseInt(conf.get("p"));

        float result = 0.0f;
        float a_ij;
        float b_jk;

        //각 행렬의 요소들과 비교하여 일치하면 서로 곱한 후 더한다.   
        for (int j = 0; j < n; j++) {
            a_ij = hashA.containsKey(j) ? hashA.get(j) : 0.0f;
            b_jk = hashB.containsKey(j) ? hashB.get(j) : 0.0f;
            result += a_ij * b_jk;
        }
        if (result != 0.0f) {
            context.write( key, new Text(Float.toString(result)) );
        }
    }
}


