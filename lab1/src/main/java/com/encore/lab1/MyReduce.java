package com.encore.lab1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReduce extends Reducer<Text, IntWritable, Text, LongWritable>{

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {
/*		long count = 0;
		for (IntWritable value: values) {
			count++;
			//count += value.get();
		}
		context.write(key,  new LongWritable(count));
*/	
		long sum = 0;
		for (IntWritable value: values) {
			sum +=value.get();
		}
		context.write(key,  new LongWritable(sum));
		
	
	
	}

	
	
	
}
