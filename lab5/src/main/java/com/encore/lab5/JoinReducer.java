package com.encore.lab5;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text, Text, Text, Text> {
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		String name = "";
		double total = 0.0;
		int count = 0;
		for (Text t : values) {
			String parts[] = t.toString().split("\t");
			if (parts[0].equals("emp")) {
				count++;
				total += Float.parseFloat(parts[1]);
			} else if (parts[0].equals("dept")) {
				name = String.format("%20s", parts[1]);
			}
		}
		String str = String.format("%20d  %20.1f", count, total);
		context.write(new Text(name), new Text(str));
	}
}
