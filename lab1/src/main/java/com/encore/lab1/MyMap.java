package com.encore.lab1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMap extends Mapper<LongWritable, Text, Text, IntWritable>{

	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String line = value.toString();
		String[] words = line.split(" ");
		
/*		for(String word:words) {
			context.write(new Text(word), new IntWritable(1));
		}
*/	
		int age = Integer.valueOf(words[1]);
		context.write(new Text(words[0]), new IntWritable(age));
		}
}
